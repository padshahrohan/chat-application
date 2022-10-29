import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { 
  NgbActiveModal,
  NgbModule,
  NgbTooltipConfig,
  NgbTooltipModule, } from '@ng-bootstrap/ng-bootstrap';
import { ChatWindowComponent } from './chat-window/chat-window.component';
import { CreateGroupComponent } from './create-group/create-group.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    ChatWindowComponent,
    CreateGroupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    NgbTooltipModule
  ],
  providers: [NgbActiveModal, NgbTooltipConfig],
  bootstrap: [AppComponent]
})
export class AppModule { }
