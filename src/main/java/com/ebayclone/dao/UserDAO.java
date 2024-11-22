package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.User;

import java.util.Optional;




public interface UserDAO extends GenericDAO<User, Integer> {
  
	List<User> findAll();
	






}


