import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { bindCallback } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RegisterComponent } from '../register/register.component';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {
    this.loginForm = this.fb.group({
      id: ['', Validators.required],
      password: ['', Validators.required]
  });
  }
  
  ngOnInit(): void {
    
  }

  login() {
    let user = this.loginForm.value;
    this.userService.login(user).subscribe({
      next: (resp) => {
        if (resp) {
          this.userService.saveCurrentUser(user.id).subscribe({next: () => {
            this.router.navigate(['home']);
          }})
        } else {
          alert('User not registered or already logged in')
        }
      }
    });
  }

  register() {
    this.router.navigate(['register']);
  }
}
