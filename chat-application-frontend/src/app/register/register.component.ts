import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  @ViewChild('regModal') regModal: NgbModal;
  
  constructor(private fb: FormBuilder, private userService: UserService, private modalService: NgbModal,
    private router: Router) {
    this.registerForm = this.fb.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      password: ['', [Validators.required]],
  });
  }

  open() {
    this.modalService.open(this.regModal, {windowClass: 'zindex'});
  }
  
  ngOnInit(): void {
    
  }

  register() {
    let body = this.registerForm.value;
    this.userService.register(body).subscribe({
      next: () => {
        this.registerForm.reset();
      }
    });
  }

  login() {
    this.router.navigate(['']);
  }

}
