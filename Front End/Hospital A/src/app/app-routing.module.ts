import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterPageComponent } from './register-page/register-page.component';
import { DLoginComponent } from './d-login/d-login.component';
import { PLoginComponent } from './p-login/p-login.component'; 
import {PDashboardComponent} from './p-dashboard/p-dashboard.component';
import {DDashboardComponent} from './d-dashboard/d-dashboard.component';
import {PTreatmentDetailsComponent} from './p-treatment-details/p-treatment-details.component'

const routes: Routes = [
  {path: '', component: PLoginComponent},
  {path: 'doctorDetails', component: LoginPageComponent},
  {path: 'registration', component: RegisterPageComponent},
  {path: 'doctorlogin', component: DLoginComponent},
  {path: 'patientlogin', component: PLoginComponent},
  {path: 'patientDashboard', component: PDashboardComponent},
  {path: 'doctorDashboard', component: DDashboardComponent},
  {path: 'patient/treatmentRequest', component: PTreatmentDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
