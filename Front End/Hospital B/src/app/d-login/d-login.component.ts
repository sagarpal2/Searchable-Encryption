import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppserviceService } from '../appservice.service';

@Component({
  selector: 'app-d-login',
  templateUrl: './d-login.component.html',
  styleUrls: ['./d-login.component.css']
})
export class DLoginComponent implements OnInit {

  username:string = '';
  password:string = '';

  constructor(private appservice: AppserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.appservice.doctorLogin(this.username, this.password).subscribe(data =>{
      console.log(data);
      localStorage.setItem('dUsername',this.username);
      this.router.navigate(["doctorDashboard"]);
    },
    err =>{console.log(err);})
  }
}
