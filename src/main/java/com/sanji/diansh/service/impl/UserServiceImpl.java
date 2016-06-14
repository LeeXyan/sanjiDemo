package com.sanji.diansh.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.diansh.entity.User;
import com.sanji.diansh.repository.UserRepository;
import com.sanji.diansh.service.UserService;

@Service
@Transactional 
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	
	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.ur.findByUsername(userName);
	}

	@Override
	public void save(User user) {
		this.ur.save(user);
	}

	@Override
	public Page<User> findAll(String imei, Pageable pageable) {
		if(imei != null && !"".equals(imei)){
			return ur.findByImei(imei,pageable);
		}else{
			return ur.findAll(pageable);
		}
	}

	@Override
	public Page<User> findAll2(String username, Pageable pageable) {
		if(username != null && !"".equals(username)){
			return ur.findByUsername(username,pageable);
		}else{
			return ur.findAll(pageable);
		}
	}

	@Override
	public Page<User> findAll3(Pageable pageable) {
		// TODO Auto-generated method stub
		return ur.findAll(pageable);
	}


}
