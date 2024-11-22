package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Cart;





public interface CartDAO extends GenericDAO<Cart, Integer> {
  
	List<Cart> findAll();
	






}


