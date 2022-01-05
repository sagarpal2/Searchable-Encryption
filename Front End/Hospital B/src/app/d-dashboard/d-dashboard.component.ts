import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppserviceService } from '../appservice.service';
import { Treatment } from '../Treatment';

@Component({
  selector: 'app-d-dashboard',
  templateUrl: './d-dashboard.component.html',
  styleUrls: ['./d-dashboard.component.css']
})
export class DDashboardComponent implements OnInit {

tList:any;

  constructor(private appservice: AppserviceService, private router:Router) { }

  ngOnInit(): void {
    this.appservice.TreatmentList().subscribe(data=>{
      this.tList=data;
    })
  }

  

}
