import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Patient } from './Patient';
import { Treatment } from './Treatment';

@Injectable({
  providedIn: 'root'
})
export class AppserviceService {

  constructor(private http: HttpClient) { }

  public registerPatient(patientDetails:Patient){
    const headers = new HttpHeaders().set('Content_Type', 'text/plain; charset=utf-8');
    return this.http.post("http://localhost:4321/addPatient", patientDetails, { headers, responseType:'text' });

  }

  public patientLogin(username:string, password: string){
    const headers = new HttpHeaders().set('Content_Type', 'text/plain; charset=utf-8');
    return this.http.get("http://localhost:4321/patientLogin/"+username+"/"+password, { headers, responseType:'text' });
  }

  public doctorLogin(username:string, password: string){
    const headers = new HttpHeaders().set('Content_Type', 'text/plain; charset=utf-8');
    return this.http.get("http://localhost:4321/doctorLogin/"+username+"/"+password, { headers, responseType:'text' });
  }

  public patientDetails(username:string){
    return this.http.get("http://localhost:4321/patientDetails/"+username);
  }

  public doctorDetails(username:string){
    return this.http.get("http://localhost:4321/doctorDetails/"+username);
  }
  

  public addTreatment(t:Treatment){
    const headers = new HttpHeaders().set('Content_Type', 'text/plain; charset=utf-8');
    return this.http.post("http://localhost:4321/addTreatment", t, { headers, responseType:'text' });
  }

  public TreatmentList(){
    return this.http.get("http://localhost:4321/treatmentList");
  }

  public patientList(){
    return this.http.get("http://localhost:4321/patientList");
  }

  public doctorNames(sp:String){
    return this.http.get("http://localhost:4321/doctorNames/"+sp);
  }
  
}
