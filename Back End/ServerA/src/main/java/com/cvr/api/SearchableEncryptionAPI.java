package com.cvr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvr.entity.DoctorEntity;
import com.cvr.model.Doctor;
import com.cvr.model.Patient;
import com.cvr.model.Treatment;
import com.cvr.service.SearchableEncryptionService;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class SearchableEncryptionAPI {
	@Autowired
	SearchableEncryptionService serviceobj;
	
	@PostMapping("/addPatient")
	public ResponseEntity<String> addPatient(@RequestBody Patient p) {
		String p_username = serviceobj.addPatient(p);
		if(p_username==null) {
			return new ResponseEntity<String>("Patient already exists", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Patient Id:"+p_username, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getUsernames")
	public ResponseEntity<Object> getUserNames() {
		List<String> l= serviceobj.getUsernames();
		System.out.println(l);
		if(l.isEmpty()) {
			return new ResponseEntity<>("No User exists", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(l, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addDoctor")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor d) {
		String d_username = serviceobj.addDoctor(d);
		if(d_username==null) {
			return new ResponseEntity<String>("Doctor already exists", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Doctor Id:"+d_username, HttpStatus.OK);
		}
	}
	
	//doctor & Patient Login
	//Treatment Details Specific User
	//PatientList
	//patientDetails
	//update patient Details and Doctor Details
	
	@GetMapping("/doctorLogin/{username}/{password}")
	public ResponseEntity<String> doctorLogin(@PathVariable(value="username")String username, @PathVariable(value="password")String password){
		Doctor d = serviceobj.loginDoctor(username, password);
		if(d==null) {
			return new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Login Successfull", HttpStatus.OK);
		}
	}
	@GetMapping("/patientLogin/{username}/{password}")
	public ResponseEntity<String> patientLogin(@PathVariable(value="username")String username, @PathVariable(value="password")String password){
		Patient p = serviceobj.loginPatient(username, password);
		if(p==null) {
			return new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Login Successfull", HttpStatus.OK);
		}
	}
	@GetMapping("/patientList")
	public ResponseEntity<List<Patient>> patientList(){
		List<Patient> pList = serviceobj.patientList();
		return new ResponseEntity<List<Patient>>(pList, HttpStatus.OK);
	}
	
	@GetMapping("/treatmentList")
	public ResponseEntity<List<Treatment>> treatmentList(){
		List<Treatment> pList = serviceobj.treatmentList();
		return new ResponseEntity<List<Treatment>>(pList, HttpStatus.OK);
	}
	
	@PostMapping("/addTreatment")
	public ResponseEntity<String> addTreatement(@RequestBody Treatment t) {
		String t_id = serviceobj.addTreatment(t);
		if(t_id==null) {
			return new ResponseEntity<String>("Problem occured", HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<String>("Treatment Id:"+t_id, HttpStatus.OK);
		}
	}
	
	@GetMapping("/patientDetails/{username}")
	public ResponseEntity<Patient> patientDetails(@PathVariable(value="username")String username){
		Patient p = serviceobj.patientDetails(username);
		return new ResponseEntity<Patient>(p, HttpStatus.OK);
	}
	
	@GetMapping("/doctorDetails/{username}")
	public ResponseEntity<Doctor> doctorDetails(@PathVariable(value="username")String username){
		Doctor d = serviceobj.doctorDetails(username);
		return new ResponseEntity<Doctor>(d, HttpStatus.OK);
	}
	
	@GetMapping("/doctorNames/{sp}")
	public ResponseEntity<List<String>> doctorNames(@PathVariable(value="sp")String sp){
		List<String> dl = serviceobj.doctorNames(sp);
		return new ResponseEntity<List<String>>(dl, HttpStatus.OK);
	}
}
