package com.cvr.dao;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Repository;

import com.cvr.Encryption.EncryptionClass;
import com.cvr.entity.DoctorEntity;
import com.cvr.entity.HelperEntity;
import com.cvr.entity.PatientEntity;
import com.cvr.entity.TreatmentEntity;
import com.cvr.model.Doctor;
import com.cvr.model.Patient;
import com.cvr.model.Treatment;

@Repository(value = "searchableEncryptionDAO")
public class SearchableEncryptionDAOImpl implements SearchableEncryptionDAO{

	@PersistenceContext
	private EntityManager entityManager;
	private EncryptionClass encrypting = new EncryptionClass();
	//private static SecretKey key=new SecretKeySpec("Sumita@222".getBytes(), 0, "Sumita@222".getBytes().length,"AES");
	private SecretKey key;
	private byte[] iv;
	
	SearchableEncryptionDAOImpl() {
		keyvalue();
	}
	
	public void keyvalue() {
		try {
		SecretKey Symmetrickey= encrypting.createAESKey();
		key = Symmetrickey;
		byte[] initializationVector= encrypting.createInitializationVector();
		iv=initializationVector;
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String encryption(Object input) {
		try {
			String plainText=input.toString();
			String cipherText= encrypting.do_AESEncryption(plainText,key,iv);
			return cipherText;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public String decryption(String cipherText) {
		try {
		String decryptedText = encrypting.do_AESDecryption(cipherText,key,iv);
		return decryptedText;
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public String addPatient(Patient p) {
		String p_username=null;
		PatientEntity pe;
		HelperEntity helperentity=entityManager.find(HelperEntity.class, encryption(p.getP_username()));
		if(helperentity==null) {
			Query q=entityManager.createQuery("select m from PatientEntity m where m.proof_id = ?1");
			q.setParameter(1, encryption(p.getProof_id()));
			List<PatientEntity> userlist=q.getResultList();
			if(!userlist.isEmpty()) {
				System.out.println("Patient already exists");
			}
			else {
				pe = new PatientEntity();
				HelperEntity he = new HelperEntity();
				he.setUsername(encryption(p.getP_username()));
				he.setTypee(encryption("patient"));
				pe.setP_username(encryption(p.getP_username()));
				pe.setAge(encryption(p.getAge()));
				pe.setPassword(encryption(p.getPassword()));
				pe.setDob(encryption(p.getDob()));
				pe.setPatient_name(encryption(p.getPatient_name()));
				pe.setPhone_no(encryption(p.getPhone_no()));
				pe.setProof_id(encryption(p.getProof_id()));
				entityManager.persist(pe);
				entityManager.persist(he);
				
				p_username=p.getP_username();
				
	//			byte[] decodedKey = Base64.getDecoder().decode(he.getMy());
	//			key = new SecretKey(decodedKey, 0, decodedKey.length, "AES");
			}
		}
		return p_username;
	}
	
	public List<String> getUsernames() {
		List<String> l =new ArrayList<>();
		Query q=entityManager.createQuery("select m from HelperEntity m");
		List<HelperEntity> userlist=q.getResultList();
		for(HelperEntity he:userlist) {
			l.add(decryption(he.getUsername()));
		}
		return l;
	}
	
	public String addDoctor(Doctor d) {
		String d_username=null;
		DoctorEntity de;
		HelperEntity helperentity=entityManager.find(HelperEntity.class, encryption(d.getD_username()));
		if(helperentity==null) {
			Query q=entityManager.createQuery("select m from DoctorEntity m where m.phone_no = ?1");
			q.setParameter(1, encryption(d.getPhone_no()));
			List<DoctorEntity> userlist=q.getResultList();
			if(!userlist.isEmpty()) {
				System.out.println("Doctor already exists");
			}
			else {
				de = new DoctorEntity();
				HelperEntity he = new HelperEntity();
				he.setUsername(encryption(d.getD_username()));
				he.setTypee(encryption("doctor"));
				de.setD_username(encryption(d.getD_username()));
				de.setPassword(encryption(d.getPassword()));
				de.setAge(encryption(d.getAge()));
				de.setQualification(encryption(d.getQualification()));
				de.setDoctor_name(encryption(d.getDoctor_name()));
				de.setPhone_no(encryption(d.getPhone_no()));
				de.setSpecialist(encryption(d.getSpecialist()));
				entityManager.persist(he);
				entityManager.persist(de);
				
				d_username=d.getD_username();
				
	//			byte[] decodedKey = Base64.getDecoder().decode(he.getMy());
	//			key = new SecretKey(decodedKey, 0, decodedKey.length, "AES");
			}
		}
		return d_username;
	}
	
	public Patient loginPatient(String username, String password) {
		String eusername = encryption(username);
		String epassword = encryption(password);
		PatientEntity pe=entityManager.find(PatientEntity.class, eusername);
		if(pe==null || !(pe.getPassword().equals(epassword))) {
			return null;
		}
		else {
			Patient p = new Patient();
			p.setAge(decryption(pe.getAge()));
			p.setDob(decryption(pe.getDob()));
			p.setP_username(this.decryption(pe.getP_username()));
			p.setPassword(epassword);
			p.setPatient_name(decryption(pe.getPatient_name()));
			p.setPhone_no(decryption(pe.getPhone_no()));
			p.setProof_id(decryption(pe.getProof_id()));
			return p;
		}
		
	}
	
	public Doctor loginDoctor(String username, String password) {
		String eusername = encryption(username);
		String epassword = encryption(password);
		DoctorEntity de=entityManager.find(DoctorEntity.class, eusername);
		if(de==null || !(de.getPassword().equals(epassword))) {
			return null;
		}
		else {
			Doctor d = new Doctor();
			d.setD_username(decryption(de.getD_username()));
			d.setPassword(decryption(de.getPassword()));
			d.setAge(decryption(de.getAge()));
			d.setQualification(decryption(de.getQualification()));
			d.setDoctor_name(decryption(de.getDoctor_name()));
			d.setPhone_no(decryption(de.getPhone_no()));
			d.setSpecialist(decryption(de.getSpecialist()));
			return d;
		}
	}
	
	public List<Patient> patientList() {
		List<Patient> l =new ArrayList<>();
		Query q=entityManager.createQuery("select m from PatientEntity m");
		List<PatientEntity> plist=q.getResultList();
		for(PatientEntity pe:plist) {
			Patient p = new Patient();
			p.setAge(decryption(pe.getAge()));
			p.setDob(decryption(pe.getDob()));
			p.setP_username(decryption(pe.getP_username()));
			p.setPassword(decryption(pe.getPassword()));
			p.setPatient_name(decryption(pe.getPatient_name()));
			p.setPhone_no(decryption(pe.getPhone_no()));
			p.setProof_id(decryption(pe.getProof_id()));
			l.add(p);
		}
		return l;
	}
	
	public String addTreatment(Treatment t) {
		TreatmentEntity te = new TreatmentEntity();
		List<Treatment> l = this.treatmentList();
		te.setT_id(encryption((l.size()+1)));
		te.setD_username(encryption(t.getD_username()));
		te.setP_username(encryption(t.getP_username()));
		te.setProblem(encryption(t.getProblem()));
		te.setProgess(encryption(t.getProgess()));
		te.setDesp(encryption(t.getDesp()));
		entityManager.persist(te);
		return decryption(te.getT_id());
	}
	
	public List<Treatment> treatmentList() {
		List<Treatment> l =new ArrayList<>();
		Query q=entityManager.createQuery("select m from TreatmentEntity m");
		List<TreatmentEntity> tlist=q.getResultList();
		for(TreatmentEntity te:tlist) {
			Treatment t = new Treatment();
			t.setT_id(decryption(te.getT_id()));
			t.setD_username(decryption(te.getD_username()));
			t.setP_username(decryption(te.getP_username()));
			t.setDesp(decryption(te.getDesp()));
			t.setProblem(decryption(te.getProblem()));
			t.setProgess(decryption(te.getProgess()));
			l.add(t);
		}
		return l;
	}
	
	public Patient patientDetails(String username) {
		PatientEntity pe=entityManager.find(PatientEntity.class, encryption(username));
		Patient p = new Patient();
		p.setAge(decryption(pe.getAge()));
		p.setDob(decryption(pe.getDob()));
		p.setP_username(decryption(pe.getP_username()));
		p.setPassword(decryption(pe.getPassword()));
		p.setPatient_name(decryption(pe.getPatient_name()));
		p.setPhone_no(decryption(pe.getPhone_no()));
		p.setProof_id(decryption(pe.getProof_id()));
		return p;
	}
	
	public Doctor doctorDetails(String username) {
		DoctorEntity de=entityManager.find(DoctorEntity.class, encryption(username));
		Doctor d = new Doctor();
		d.setD_username(decryption(de.getD_username()));
		d.setPassword(decryption(de.getPassword()));
		d.setAge(decryption(de.getAge()));
		d.setQualification(decryption(de.getQualification()));
		d.setDoctor_name(decryption(de.getDoctor_name()));
		d.setPhone_no(decryption(de.getPhone_no()));
		d.setSpecialist(decryption(de.getSpecialist()));
		return d;
	}
	
	public List<String> doctorNames(String sp){
		List<String> dl = new ArrayList<>();
		Query q=entityManager.createQuery("select m from DoctorEntity m where m.specialist = ?1");
		q.setParameter(1, encryption(sp));
		List<DoctorEntity> userlist=q.getResultList();
		for(DoctorEntity de:userlist) {
			dl.add(decryption(de.getD_username()));
		}
		return dl;
	}
	
	//public String hmacencryption(Object input) {
	//	try {
	//	String plainText=input.toString();
	//	String cipherText= encrypting.generateHmac(key.getEncoded(),plainText);
	//	return cipherText;
	//}fever
	//catch(Exception e) {
	//	System.out.println(e);
	//	return null;
	//}
	//}
}
