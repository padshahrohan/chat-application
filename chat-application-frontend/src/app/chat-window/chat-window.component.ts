import { Component, EventEmitter, Input, OnInit, Output, TemplateRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Timestamp } from 'google-protobuf/google/protobuf/timestamp_pb';
import { User } from 'src/models/user.model';
import { ChatMessage } from '../proto-gen/chat_pb';
import { ChatApiService } from '../service/chat.service';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.css']
})
export class ChatWindowComponent implements OnInit {

  chatForm: FormGroup;

  @Input() users: User[];
  @Output() chatWindowClosed = new EventEmitter<void>();

  @ViewChild('chatWindowModal')
  chatWindowModal: TemplateRef<any>;

  toUser: User;
  group: {id: string, name: string};
  messages: ChatMessage[];
  fromUser: User;
  userNames: Map<string, string> = new Map<string,string>();

  constructor(private modalService: NgbModal, private chatService: ChatApiService, private fb: FormBuilder) {
    this.chatForm = this.fb.group({
      message: ['', Validators.required]
  });
   }

  ngOnInit(): void {
    this.chatService.messageObs$.subscribe({
      next: (message) => {
        
        if ((message.getBelongstogroup() && this.group && message.getTo() === this.group.id) || 
          (!message.getBelongstogroup() && this.toUser && message.getFrom() === this.toUser.id)){
            this.messages.push(message);
        } 
      }
    })
  }

  openForOneOnOneChat(messages: ChatMessage[], toUser: User, fromUser: User) {
    this.toUser = toUser;
    this.fromUser = fromUser;
    this.messages = Object.assign([], messages);
    this.modalService.open(this.chatWindowModal, {backdrop: "static"});
    this.buildUserNameMap();
  }

  openForGroupChat(messages: ChatMessage[], group: {id: string, name: string}, fromUser: User) {
    this.group = group;
    this.fromUser = fromUser;
    this.messages = Object.assign([], messages);
    this.modalService.open(this.chatWindowModal, {backdrop: "static"});
    this.buildUserNameMap()
  }

  buildUserNameMap() {
    this.users.forEach((u) => this.userNames.set(u.id, u.name));
  }

  send() {
    let message = new ChatMessage();
    message.setFrom(this.fromUser.id);
    message.setMessage(this.chatForm.value.message);
    
    if (this.group) {
      message.setTo(this.group.id);
      message.setBelongstogroup(true);  
    } else {
      message.setTo(this.toUser.id);
      message.setBelongstogroup(false);

    }
    
    this.messages.push(message);
    this.chatService.send(message);
    this.chatForm.reset();
  }

  close() {
    this.messages = [];
    this.modalService.dismissAll();
    this.chatWindowClosed.emit();
  }
}
