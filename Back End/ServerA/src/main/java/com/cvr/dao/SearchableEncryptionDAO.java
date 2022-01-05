package com.cvr.dao;

import java.util.List;

import com.cvr.model.Doctor;
import com.cvr.model.Patient;
import com.cvr.model.Treatment;

public interface SearchableEncryptionDAO {
	public String addPatient(Patient p);
	public String addDoctor(Doctor d);
	public String encryption(Object input);
	public Object decryption(String cipherText);
	public List<String> getUsernames();
	public Doctor loginDoctor(String username, String password);
	public Patient loginPatient(String username, String password);
	public List<Patient> patientList();
	public String addTreatment(Treatment t);
	public List<Treatment> treatmentList();
	public Doctor doctorDetails(String username);
	public Patient patientDetails(String username);
	public List<String> doctorNames(String sp);
}
