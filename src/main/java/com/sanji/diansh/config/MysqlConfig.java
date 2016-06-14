/*package com.sanji.diansh.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
*//**
 * @Configuration 注解该类，等价 与XML中配置beans；
 *//*

@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager",basePackages = { "com.sanji.diansh.repository" })
*//**
 * @EnableJpaRepositories注解中 
 * entityManagerFactoryRef：实体管理工厂引用名称，对应到@Bean注解对应的方法
 * transactionManagerRef：事务管理工厂引用名称，对应到@Bean注解对应的方法
 * basePackages：用于配置扫描Repositories所在的package及子package。简单配置中的配置则等同于此项配置值，basePackages可以配置为单个字符串，也可以配置为字符串数组形式
 * @author 神盾局
 *
 *//*


@EnableJpaAuditing(auditorAwareRef="auditorAware")
*//**
 * 配置 AuditorAware 豆被用来查找当前本金。 
 *
 *//*



public class MysqlConfig {
	
	private Logger logger = LoggerFactory.getLogger(MysqlConfig.class);
	@Bean(name="auditorAware")
	*//**
	 * @Bean标注方法等价于XML中配置bean
	 * @return
	 *//*
	public AuditorAware<Object> auditorAware(){
		return new AuditorAwareImpl();
	}
	
	
	*//**
	 * MYSQL读取datasource配置文件 application-datasource.properties
	 * @return
	 *//*
	@Bean(name = "mysqlDataSource")
	@Primary
	@ConfigurationProperties(prefix="datasource.mysql")
	public DataSource mysqlDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	
	
	*//**
	 * MySQL的实体管理器工厂
	 * @return
	 *//*
	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory  entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();//声明 Hibernate Jpa 供应商适配器
	    vendorAdapter.setGenerateDdl(true);
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();//局部容器实体管理方式
	    factory.setJpaVendorAdapter(vendorAdapter); 
	    factory.setDataSource(mysqlDataSource());
	    factory.setMappingResources("META-INF/orm.xml");
	    factory.setPackagesToScan("com.sanji.diansh.domain");
	    Properties jpaProperties = new Properties();
	    jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		factory.setJpaProperties(jpaProperties);
	    factory.afterPropertiesSet();
	    return factory.getObject();
	}
	
	*//**
	 * MySQL事务管理
	 * @return
	 *//*
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManagerSecondary() {
		JpaTransactionManager txManager = new JpaTransactionManager();//JPA的事务管理器
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	}
	
}
*/