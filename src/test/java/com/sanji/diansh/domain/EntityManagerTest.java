package com.sanji.diansh.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.activemq.transaction.Transaction;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.sanji.diansh.UltlonApplication;
import com.sanji.diansh.entity.Person;
import com.sanji.diansh.repository.PersonRepository;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UltlonApplication.class)
@TransactionConfiguration(defaultRollback=false)
public class EntityManagerTest {

	@PersistenceContext
	EntityManager entityManager;// 实体管理
	
	@Autowired
	PersonRepository pr;

	@Test
	public void savePerson(){
		for(int i=0;i<10;i++){
			Person person = new Person();

	        DateTime createdDate =  DateTime.now();
			person.setAddress("山东省济南市"+i);
			person.setCompany("三际有限公司"+i);
			//person.setCreatedBy(Calendar.getInstance());
			person.setCreatedDate(createdDate);
			person.setStreet("清联花园19号"+i);
			person.setTelephone("15294614524"+i);
			person.setName("lissss"+i);
			//list.add(person);
			pr.save(person);
		}
		
	}
	
	
	
	/**
	 * 更新数据 使用的是flush
	 * 当实体正在被容器管理时，你可以调用实体的set方法对数据进行修改，在容器决定flush时（这个由container自行判断），
	 * 更新的数据 才会同步到数据库，而不是在调用了set方法对数据进行修改后马上同步到数据库。如果你希望修改后的数据马上同步到数据库，你可以调用 
	 * EntityManager.flush()方法。在要使用@Transactional注解事务
	 */
	@Test
	@Transactional//事务
	public void updateFlushPerson() {//transaction
		try {
			DateTime createdDate =  DateTime.now();
			Person person = entityManager.find(Person.class, 2L);
			person.setName("ssss");//方法执行完后即可更新数据 执行主键唯1数据据的更新
			person.setLastModifiedDate(createdDate);
			entityManager.persist(person);
			entityManager.flush();//数据马上同步到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 如果级联关系cascade=CascadeType.ALL，在删除person 时候，也会把级联对象删除。
	 * 把cascade属性设为cascade=CascadeType.REMOVE 有同样的效果。
	 * 如果传递进remove ()方法的参数不是实体Bean，会引发一个IllegalArgumentException
	 */
	@Test
	@Transactional
	public void deletePerson(){
		try {
			Person person =  entityManager.find(Person.class, 2L);
		    entityManager.remove(person);//删除主键为2的数据
		    entityManager.flush();//数据提交的到数据库
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * -------------------------------------------------
	 * -------------------------------------------------
	 * -------------------------------------------------
	 * HPQL语句
	 * 
	 */
	
	/**
	 * 除了使用find()或getReference()方法来获得Entity Bean之外，你还可以通过JPQL得到实体Bean。
	 * 要执行JPQL语句，你必须通过EntityManager的createQuery()或createNamedQuery()方法创建一个Query 对象
	 */
	
	
	@Test
	@Transactional
	public void  JPQLqueryPerson(){
		Person person =  new Person();
		try {
			javax.persistence.Query query = entityManager.createQuery("select p.name,p.address,p.company,p.street,p.telephone from Person p order by p.id desc");
			List<?> result = query.getResultList();
			Iterator<?> iterator = result.iterator();
			
			while(iterator.hasNext()){
				//处理person
				Object[] obj= ( Object[]) iterator.next();
				String address=obj[0].toString();
				String company=obj[1].toString();
				String name = obj[2].toString();
				String street= obj[3].toString();
				String telephone = obj[4].toString();
				person.setAddress(address);
				person.setCompany(company);
				person.setName(name);;
				person.setStreet(street);
				person.setTelephone(telephone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("person="+person);
		}
	}
	
	
	/**
	 * 更新数据
	 */
	@Test
	@Transactional
	public void JPQLUpdatePerson(){
		int result = 0;
		try {
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = format.format(date);
			
			
			 DateTime createdDate =  DateTime.now();
			 
			 
			javax.persistence.Query query = entityManager.createQuery("update Person as p set p.name =?1 "+" where p.id=?3 ");
			query.setParameter(1, "eeeee");
			/*query.setParameter(2,"2016-06-12");*/
			query.setParameter(3, 3L);
			result = query.executeUpdate(); //影响的记录数
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("影响的记录数"+" "+result);
		}
	}
	
	/**
	 * 删除数据
	 */
	@Test
	@Transactional
	public void JPQLDeletePerson(){
		int result = 0;
		try {
			javax.persistence.Query query = entityManager.createQuery("delete from Person as p where p.id=?1 ");
			query.setParameter(1, 1L);
			result = query.executeUpdate(); //影响的记录数
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("影响的记录数"+" "+result);
		}
	}
	
	
	
	/**
	 * -------------------------------------
	 * -------------------------------------
	 * -------------------------------------
	 * -------------------------------------
	 * SQL语句
	 */
	
	
	/**
	 * 我们可以让EJB3 Persistence 运行环境将列值直接填充入一个Entity 的实例
	 * 并将实例作为结果返回.
	 */
	@Test
	@Transactional
	public void SQLQueryPerson(){
		List<Person> list = new ArrayList<Person>();
		Person person = new Person();
		try {
			javax.persistence.Query query = entityManager.createNativeQuery("select p.address,p.company,p.name,p.street,p.telephone,p.id,p.created_by_id,p.created_date,p.last_modified_by_id,p.last_modified_date  from tb_person as p where p.name='lissss0'", Person.class);
			//query.setParameter(1, 2L);
			List<?> result = query.getResultList();
			if(result !=null){
				Iterator<?> iterator = result.iterator();
				while(iterator.hasNext()){
					Object[] obj = (Object[]) iterator.next();
					
					/*String address=obj[0].toString();
					String company=obj[1].toString();
					String name = obj[2].toString();
					String street= obj[3].toString();
					String telephone = obj[4].toString();
					person.setAddress(address);
					person.setCompany(company);
					person.setName(name);;
					person.setStreet(street);
					person.setTelephone(telephone);*/
					//list.add(person);
					//处理操作
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("person="+person);
		}
	}
	
	/**
	 * 更新数据
	 */
	@Test
	@Transactional
	public void SQLUpdatePerson(){
		int result=0;
		try {
			DateTime createdDate =  DateTime.now();
			String name="sswww";
			Long id=4L;
			javax.persistence.Query query = entityManager.createNativeQuery("update tb_person as p set p.name="+"'"+name+"'"+",p.last_modified_date="+"'"+createdDate.toLocalDateTime().toString()+"'"+" where p.id="+"'"+id+"'");
			result=query.executeUpdate();//影响的行数
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("影响的行数："+result);
		}
	}
	
	/**
	 * 删除数据
	 */
	@Test
	@Transactional
	public void SQLDeletePerson(){
		try {
			Long id=2L;
			javax.persistence.Query query = entityManager.createNativeQuery("delete from tb_person where id="+"'"+id+"'");
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
