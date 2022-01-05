import { Component, OnInit } from '@angular/core';
import { AppserviceService } from '../appservice.service';

@Component({
  selector: 'app-p-dashboard',
  templateUrl: './p-dashboard.component.html',
  styleUrls: ['./p-dashboard.component.css']
})
export class PDashboardComponent implements OnInit {

  username:any;
  proofID='';
  name='';
  age='';
  phoneNo='';
  dob='';
  p:any;

  constructor(private appservice: AppserviceService) { }

  ngOnInit(): void {
    this.username=localStorage.getItem('pUsername');
    this.appservice.patientDetails(this.username).subscribe(data=>{
      this.p = data;
    this.proofID = this.p.proof_id;
    this.name = this.p.patient_name;
    this.age = this.p.age;
    this.phoneNo = this.p.phone_no;
    this.dob = this.p.dob;
    })
  }

}
