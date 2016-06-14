package com.sanji.diansh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanji.diansh.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
