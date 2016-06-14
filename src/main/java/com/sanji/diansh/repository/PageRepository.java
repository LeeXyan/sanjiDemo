package com.sanji.diansh.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sanji.diansh.entity.User;

public interface PageRepository extends PagingAndSortingRepository<User, Serializable>{

}
