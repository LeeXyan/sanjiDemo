package com.sanji.diansh.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sanji.diansh.entity.Person;

public class test {

	@PersistenceContext
	EntityManager entityManager;// 实体管理

	public void updatePerson() {
		try {
			Person person = entityManager.find(Person.class, 1);
			person.setName("lisasa");//方法执行完后即可更新数据 执行主键唯1数据据的更新
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
