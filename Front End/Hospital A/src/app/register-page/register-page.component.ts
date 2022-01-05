import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppserviceService } from '../appservice.service';
import { Patient } from '../Patient';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  username: string = '';
  password: string = '';
  cpassword: string = '';
  proofID: string = '';
  name: string = '';
  age: string = '';
  phoneNo: string = '';
  dob: Date = new Date();
  p:Patient = new Patient();

  constructor(private appservice: AppserviceService, private router:Router) { }

  ngOnInit(): void {

  }

  onSubmit(){
    this.p.p_username=this.username;
    this.p.password=this.password;
    this.p.proof_id=this.proofID;
    this.p.patient_name=this.name;
    this.p.age=this.age;
    this.p.phone_no= this.phoneNo;
    this.p.dob="11/02/2000";
    console.log(this.p);
    this.appservice.registerPatient(this.p).subscribe(data =>{
      console.log(data);
      localStorage.setItem('pUsername',this.username);
      this.router.navigate(["patientDashboard"]);
    },
    err =>{console.log(err);})
  }

}
