package com.cvr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "treatment")
public class TreatmentEntity {
	@Id
	private String t_id;
	private String d_username;
	private String p_username;
	private String problem;
	private String progess;
	private String desp;
	
	
	public String getT_id() {
		return t_id;
	}
	
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getD_username() {
		return d_username;
	}
	public void setD_username(String d_username) {
		this.d_username = d_username;
	}
	public String getP_username() {
		return p_username;
	}
	public void setP_username(String p_username) {
		this.p_username = p_username;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getProgess() {
		return progess;
	}
	public void setProgess(String progess) {
		this.progess = progess;
	}
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	
}
