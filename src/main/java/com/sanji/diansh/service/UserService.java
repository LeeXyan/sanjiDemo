package com.sanji.diansh.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sanji.diansh.entity.User;

public interface UserService {
	
	User findByUserName(String userName);
	
	public void save(User user);
	
	public Page<User> findAll(String imei,Pageable pageable);
	
	public Page<User> findAll2(String username,Pageable pageable);
	
	public Page<User> findAll3(Pageable pageable);
	
}
