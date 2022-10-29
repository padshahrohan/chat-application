import { Component, EventEmitter, Input, OnInit, Output, TemplateRef, ViewChild } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/models/user.model';
import { GroupService } from '../service/group.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-create-group',
  templateUrl: './create-group.component.html',
  styleUrls: ['./create-group.component.css']
})
export class CreateGroupComponent implements OnInit {

  @Input() currentUser: User;
  createGroupForm: FormGroup;
  addParticipantsForm: FormGroup;
  users: User[] = [];
  groupCreated = false;
  groupName = '';
  group : {id: string, name: string};

  @Output() createdGroup = new EventEmitter<{id: string, name: string}>()

  @ViewChild('createGroupModal')
  createGroupModal: TemplateRef<any>;

  constructor(private fb: FormBuilder, private modalService: NgbModal, private groupService: GroupService,
     private userService: UserService) {
    this.createGroupForm = this.fb.group({
      name: ['', Validators.required]
    });

    this.addParticipantsForm = this.fb.group({
      participants: this.fb.array([])
    })
  }

  open() {
    this.modalService.open(this.createGroupModal, {backdrop: "static"});
  }

  onCheckboxChange(e: any) {
    const particpants: FormArray = this.addParticipantsForm.get('participants') as FormArray;
    if (e.target.checked) {
      particpants.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      particpants.controls.forEach((item: any) => {
        if (item.value == e.target.value) {
          particpants.removeAt(i);
          return;
        }
        i++;
      });
    }
  }

  addParticipants() {
    const participants: FormArray = this.addParticipantsForm.get('participants') as FormArray;
    participants.push(new FormControl(this.currentUser.id));
    
    this.groupService.addParticipants(this.group.id, participants.value).subscribe({
      next: () => {
        this.createGroupForm.reset();
        this.groupCreated = false;
        this.modalService.dismissAll();
        this.createdGroup.emit(this.group);
      }
    })
  }
  
  ngOnInit(): void {
    
  }

  close() {
    this.modalService.dismissAll();
  }

  createGroup() {
    this.groupService.createGroup(this.createGroupForm.value.name).subscribe({
      next: (group: {id: string; name : string}) => {
        this.group = group;
        this.userService.getAllUser().subscribe({
          next: (users) => {
            this.users = users;
            this.groupCreated = true;
            this.groupName = this.createGroupForm.value.name;
          }
        })
      } 
    })
  }

  
}
