package com.cvr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cvr.dao.SearchableEncryptionDAO;
import com.cvr.model.Doctor;
import com.cvr.model.Patient;
import com.cvr.model.Treatment;

@Service(value="searchableEncryptionService")
@Transactional
public class SearchableEncryptionServiceImpl implements SearchableEncryptionService{
	@Autowired
	private SearchableEncryptionDAO searchableEncryptionDAO;
	
	public String addPatient(Patient p) {
		String p_username=searchableEncryptionDAO.addPatient(p);
		return p_username;
	}
	
	public List<String> getUsernames(){
		List<String> l = searchableEncryptionDAO.getUsernames();
		return l;
	}
	
	public String addDoctor(Doctor d) {
		String d_username=searchableEncryptionDAO.addDoctor(d);
		return d_username;
	}
	
	public Doctor loginDoctor(String username, String password) {
		Doctor d = searchableEncryptionDAO.loginDoctor(username, password);
		return d;
	}
	
	public Patient loginPatient(String username, String password) {
		Patient p = searchableEncryptionDAO.loginPatient(username, password);
		return p;
		
	}
	
	public List<Patient> patientList(){
		List<Patient> pList = searchableEncryptionDAO.patientList();
		return pList;
	}
	
	public List<Treatment> treatmentList(){
		List<Treatment> tList = searchableEncryptionDAO.treatmentList();
		return tList;
	}
	
	public String addTreatment(Treatment t) {
		return searchableEncryptionDAO.addTreatment(t);
	}
	
	public Patient patientDetails(String username) {
		return searchableEncryptionDAO.patientDetails(username);
	}
	
	public Doctor doctorDetails(String username) {
		return searchableEncryptionDAO.doctorDetails(username);
	}
	
	public List<String> doctorNames(String sp){
		return searchableEncryptionDAO.doctorNames(sp);
	}
}
