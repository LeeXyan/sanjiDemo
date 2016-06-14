package com.sanji.diansh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="tb_student")
public class Student extends AbstractAuditable<User,Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imei;
	private String address;
	
	public Student(){
		super();
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
