package com.sanji.diansh.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sanji.diansh.UltlonApplication;
import com.sanji.diansh.entity.User;
import com.sanji.diansh.repository.UserRepository;
import com.sanji.diansh.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UltlonApplication.class)
@TransactionConfiguration(defaultRollback=false)
public class UserRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private UserService us;
	
	@Test
	public void saveTest(){
		User user=new User();
		user.setPassword("1");
		user.setRegions("1");
		user.setUsername("admin");
		ur.save(user);
	}
	
	@Test
	public void ListTest(){
		User user = new User();
		ur.findAll();
	}
	
	//@Test
	public void deleteTest(){
		ur.delete(323L);
	}
	
	//@Test
	public void findByUserNameTest(){
		/*、、User u=ur.findByUsername("李四");
		logger.debug("u===="+u.toString());*/
	}
	
}
