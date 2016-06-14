package com.sanji.diansh.entity;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name="tb_users")
public class User extends AbstractAuditable<User,Long> {
//AbstractAuditable
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String mobile;
	private String regions;//所在区域
	private String roler;
	private String imei;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public String getRegions() {
		return regions;
	}
	public void setRegions(String regions) {
		this.regions = regions;
	}
	
	public String getRoler() {
		return roler;
	}


	public void setRoler(String roler) {
		this.roler = roler;
	}
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", mobile=" + mobile + ", regions=" + regions
				+ ", roler=" + roler + ", imei=" + imei + "]";
	}

/*	public String toString(){
		return "username="+username+",password="+password+",regions="+regions+",roler="+roler;
		
	}
  
	@Transient
	public List<String> getRegionList(){
		List<String> result = Splitter.on(",").trimResults().splitToList(this.regions);
		return result;
	}*/
}
