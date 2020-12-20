package com.anilsatendra.mvctutorial.tutorialspringmvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Login {
	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Login(@Size(min = 2, max = 45) String username, @Size(min = 2, max = 45) String password) {
		super();
		this.username = username;
		this.password = password;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginId;
	
	@Size(min = 2, max = 45)
	@Column(name = "username", nullable = false, length = 45)
	private String username;
	
	@Size(min = 2, max = 45)
	@Column(name = "password", nullable = false, length = 45)
	private String password;
	
	@Transient
	@Size(min = 2, max = 45)
	private String cpassword;
	

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "recordDate", insertable=false)
	private Date recordDate;


	public Long getLoginId() {
		return loginId;
	}


	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCpassword() {
		return cpassword;
	}


	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}


	public Date getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	@Override
	public String toString() {
		return "login [loginId=" + loginId + ", username=" + username + ", password=" + password + ", recordDate="
				+ recordDate + "]";
	}
	
	

}
