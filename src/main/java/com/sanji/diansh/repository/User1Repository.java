package com.sanji.diansh.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sanji.diansh.entity.User;

public interface User1Repository extends PagingAndSortingRepository<User, Serializable>{

}
