import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { PDashboardComponent } from './p-dashboard/p-dashboard.component';
import { DDashboardComponent } from './d-dashboard/d-dashboard.component';
import { PTreatmentDetailsComponent } from './p-treatment-details/p-treatment-details.component';
import { DPatientDetailsComponent } from './d-patient-details/d-patient-details.component';
import { DLoginComponent } from './d-login/d-login.component';
import { PLoginComponent } from './p-login/p-login.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegisterPageComponent,
    PDashboardComponent,
    DDashboardComponent,
    PTreatmentDetailsComponent,
    DPatientDetailsComponent,
    DLoginComponent,
    PLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
