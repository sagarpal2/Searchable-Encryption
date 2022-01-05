package com.cvr.service;

import java.util.List;

import com.cvr.model.Doctor;
import com.cvr.model.Patient;
import com.cvr.model.Treatment;

public interface SearchableEncryptionService {
	public String addPatient(Patient p);
	public List<String> getUsernames();
	public String addDoctor(Doctor d);
	public Doctor loginDoctor(String username, String password);
	public Patient loginPatient(String username, String password);
	public List<Patient> patientList();
	public List<Treatment> treatmentList();
	public String addTreatment(Treatment t);
	public Patient patientDetails(String username);
	public Doctor doctorDetails(String username);
	public List<String> doctorNames(String sp);
}
