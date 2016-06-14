package com.sanji.diansh.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.diansh.entity.Unit;
import com.sanji.diansh.repository.UnitRepository;
import com.sanji.diansh.service.UnitService;

@Service
@Transactional 
public class UnitServiceImpl implements UnitService{

	@Autowired
	UnitRepository ur;
	
	@Override
	public Page<Unit> findAll(String imei, Pageable pageable) {
		if(imei != null && !"".equals(imei)){
			return ur.findByImei1(imei, pageable);
		}else{
			return ur.findAll(pageable);
		}
	}

	@Override
	public Page<Unit> findAll2(String username, Pageable pageable) {
		if(username != null && !"".equals(username)){
			return ur.findByUsername1(username, pageable);
		}else{
			return ur.findAll(pageable);
		}
	}

}
