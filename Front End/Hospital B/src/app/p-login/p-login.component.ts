import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppserviceService } from '../appservice.service';

@Component({
  selector: 'app-p-login',
  templateUrl: './p-login.component.html',
  styleUrls: ['./p-login.component.css']
})
export class PLoginComponent implements OnInit {
  username:string = '';
  password:string = '';
  constructor(private appservice: AppserviceService, private router:Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(){
    this.appservice.patientLogin(this.username, this.password).subscribe(data =>{
      console.log(data);
      localStorage.setItem('pUsername',this.username);
      this.router.navigate(["patientDashboard"]);
    },
    err =>{console.log(err);})
  }

}
