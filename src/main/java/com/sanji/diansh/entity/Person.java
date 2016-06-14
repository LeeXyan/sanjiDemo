package com.sanji.diansh.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

/**
 * 
 * @author lixiaoyan
 * 
 */
@Entity
@Table(name="tb_person")//AbstractAuditable
public class Person extends AbstractAuditable<Person, Long>{
	private static final long serialVersionUID = 1L;
	private String name;// 名字
	private String address;// 地址
	private String telephone;// 电话
	private String company;// 公司
	private String street;// 街道

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", telephone=" + telephone + ", company=" + company
				+ ", street=" + street + "]";
	}

	
	
}
