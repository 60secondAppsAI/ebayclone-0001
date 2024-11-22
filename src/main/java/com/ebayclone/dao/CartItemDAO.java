package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.CartItem;





public interface CartItemDAO extends GenericDAO<CartItem, Integer> {
  
	List<CartItem> findAll();
	






}


