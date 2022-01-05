import { Component, OnInit } from '@angular/core';
import { AppserviceService } from '../appservice.service';
import { Doctor } from '../Doctor';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  
  username:any = '';
  name :string='';
  qualification='';
  age = '';
  phone ='';
  sp='';
  d:any;

  constructor(private appservice: AppserviceService) { }

  ngOnInit(): void {
    this.username=localStorage.getItem('dUsername');
    this.appservice.doctorDetails(this.username).subscribe((data)=>{
      this.d = data
      this.name = this.d.d_username;
      this.qualification=this.d.doctor_name;
      this.age = this.d.age;
      this.phone = this.d.phone_no;
      this.sp = this.d.specialist;
    })
  }

}
