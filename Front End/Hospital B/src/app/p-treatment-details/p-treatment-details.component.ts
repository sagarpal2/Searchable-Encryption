import { Component, OnInit } from '@angular/core';
import { Treatment } from '../Treatment';
import { Router } from '@angular/router';
import { AppserviceService } from '../appservice.service';

@Component({
  selector: 'app-p-treatment-details',
  templateUrl: './p-treatment-details.component.html',
  styleUrls: ['./p-treatment-details.component.css']
})
export class PTreatmentDetailsComponent implements OnInit {

  pusername:any;
  problem:string ='';
  desp:string='';
  specialist:string='';
  dusername:string='';
  t:Treatment=new Treatment();
  dnames:any;
  flag = 0;

  constructor(private appservice: AppserviceService, private router:Router) { }

  ngOnInit(): void {
    this.pusername = localStorage.getItem('pUsername');
  }

  load(){
    console.log(this.specialist);
    this.appservice.doctorNames(this.specialist).subscribe(data=>{
      this.dnames=data;
      this.flag=1;
    })
  }

  onSubmit(){
    this.t.d_username=this.dusername;
    this.t.p_username=this.pusername;
    this.t.desp=this.desp;
    this.t.problem=this.problem;
    this.t.progess='0';
    this.appservice.addTreatment(this.t).subscribe(data=>{
      console.log(data);
      this.router.navigate(['patientDashboard']);
    },
    err=>{
      console.log(err);
    })
  }

}
