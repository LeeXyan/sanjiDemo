package com.sanji.diansh.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sanji.diansh.entity.Unit;
import com.sanji.diansh.entity.User;

public interface UnitRepository extends JpaRepository<Unit, Long>,CrudRepository<Unit, Long>{
	
	
	@Query("select a from Unit a where a.user.imei=?1")
	Page<Unit> findByImei1(String imei, Pageable pageable);
	
	
	@Query("select a from Unit a where a.user.username=?1")
	Page<Unit> findByUsername1(String username,Pageable pageable);
	
	@Query("select a from Unit a where a.user.id=?1")
	Unit findByUserId(Long userid);
	
	@Query("select a from Unit a where a.address=?1")
	Unit findByAddress(String address);
	
	
	@Query("select a from Unit a where a.user.mobile=?1")
	Page<Unit> findBymobile(String mobile,Pageable pageable);
	
	@Query("select a from Unit a where a.user.username=?1")
	Page<Unit> findByname(String userName,Pageable pageable);
}
