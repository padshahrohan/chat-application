import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { User } from 'src/models/user.model';
import { UserService } from '../service/user.service';
import { grpc } from '@improbable-eng/grpc-web';
import { Request } from '@improbable-eng/grpc-web/dist/typings/invoke';
import { ChatMessage, UserId } from '../proto-gen/chat_pb';
import { BehaviorSubject, Subject } from 'rxjs';
import { ChatApiService } from '../service/chat.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ChatWindowComponent } from '../chat-window/chat-window.component';
import { CreateGroupComponent } from '../create-group/create-group.component';
import { GroupService } from '../service/group.service';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users: User[];
  groups: {id: string, name: string}[];
  messages: ChatMessage[];
  unReadUserMessages: Map<string, number> = new Map<string, number>();
  currentUser: User;
  chatWindowActiveWith:any ;

  @ViewChild('chatWindowModal') 
  chatWindowModal: ChatWindowComponent;
 
  @ViewChild('createGroupModal') 
  createGroupModal: CreateGroupComponent;

  constructor(private userService: UserService, private chatService: ChatApiService, private groupService: GroupService,
    private router: Router) { }

  ngOnInit(): void {
    
    this.userService.currentUserObs$.subscribe({
      next: (user: User) => {
        
        if (user.id !== "" && user.password !== "") {
          this.currentUser = user;          
          this.refreshChatForUsersAndGroups();
          const userId = new UserId();
          userId.setId(user.id);
          this.chatService.receive(userId);
        } else {
          let userId = localStorage.getItem('userId');
          if (userId) {
            this.userService.saveCurrentUser(userId).subscribe();
          }
        }
      }, error : (err) => {
        console.log(err);
        
      }
    })

    this.chatService.messageObs$.subscribe({
      next: (message) => {

        let chatWindowId: string; 
        if (message.getBelongstogroup()){
          chatWindowId = message.getTo();
        } else {
          chatWindowId = message.getFrom();
        }

        
        if (this.chatWindowActiveWith === undefined || this.chatWindowActiveWith !== chatWindowId) {
          let unreadMessages = this.unReadUserMessages.get(chatWindowId);
          if (unreadMessages !== undefined) {
            this.unReadUserMessages.set(chatWindowId, unreadMessages+1);
          } else {
            if (message.getBelongstogroup()) {
              this.refreshGroups();
            } else {
              this.refreshUsers();
            }
            this.unReadUserMessages.set(chatWindowId, 1);
          }
        }
      }
    })
  }

  refreshChatForUsersAndGroups() {
    this.refreshUsers();
    this.refreshGroups();
  }

  refreshUsers() {
    this.userService.getAllUser().subscribe({
      next: (users: User[]) => {
        this.users = users;
        this.users.forEach((u) => {
          if(this.unReadUserMessages.get(u.id) === undefined) {
            this.unReadUserMessages.set(u.id, 0);
          }
        });
      }
    })
  }

  openChatWindowWithUser(user: User ) {

    this.chatWindowActiveWith = user.id;
    let messages =  this.chatService.getChatMessagesFor(user.id); 
    this.unReadUserMessages.set(user.id, 0);
    this.chatWindowModal.openForOneOnOneChat(messages == undefined ? [] : messages, user, this.currentUser);
  }

  openChatWindowWithGroup(group: {id: string, name: string}) {

    this.chatWindowActiveWith = group.id;
    let messages =  this.chatService.getChatMessagesFor(group.id); 
    this.unReadUserMessages.set(group.id, 0);
    this.chatWindowModal.openForGroupChat(messages == undefined ? [] : messages, group, this.currentUser);
  }
  
  createGroup() {
    this.createGroupModal.open();
  }

  refreshGroups() {
    this.groupService.getAllGroups(this.currentUser.id).subscribe({
      next: (groups) => {
        this.groups = groups;
        this.groups.forEach((g) => {
          if(this.unReadUserMessages.get(g.id) === undefined) {
            this.unReadUserMessages.set(g.id, 0);
          }
        });
      }
    });
  }

  logOut() {
    this.userService.logOut(this.currentUser.id).subscribe({
      next: () => {
        this.chatService.removeStream(this.currentUser.id);
        this.router.navigate(['']);
      }
    })
  }

}
