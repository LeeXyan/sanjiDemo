package com.sanji.diansh.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sanji.diansh.entity.Unit;


public interface UnitService {
	public Page<Unit> findAll(String imei,Pageable pageable);
	
	public Page<Unit> findAll2(String username,Pageable pageable);
}
