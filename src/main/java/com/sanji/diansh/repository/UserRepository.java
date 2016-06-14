package com.sanji.diansh.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sanji.diansh.entity.Unit;
import com.sanji.diansh.entity.User;





public interface UserRepository extends JpaRepository<User, Long>,CrudRepository<User, Long>{
	
	User findByUsername(String userName);
	
	
	@Query("select a from User a where a.username=?1")
	Page<User> findByname(String userName,Pageable pageable);
	
	
	@Query("select a from User a where a.mobile=?1")
	Page<User> findBymobile(String mobile,Pageable pageable);
	
	
	@Query("select a from User a where a.imei=?1")
	Page<User> findByImei(String imei, Pageable pageable);
	
	
	
	/*@Query("select a from User ")
	Page<User> findByPage(Pageable pageable);*/
	
	@Query("select a from User a where a.username=?1")
	Page<User> findByUsername(String username,Pageable pageable);
	
	
	@Modifying
	@Query("update User u set u.username = ?1 where u.id = ?2")
	int setUpdateByid(String username,Long id);
	
/*	@Modifying
	@Query("update User u set u.username = ?1,u.password = ?2 where u.id = ?3")
	int setUpdateByIdPassword(String username,String password,Long id);*/
	
	/*@Modifying
	@Query("update User u set u.username = ?1")
	int updateByname(String username);*/


}
