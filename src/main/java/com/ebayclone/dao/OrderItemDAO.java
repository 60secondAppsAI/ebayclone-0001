package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.OrderItem;





public interface OrderItemDAO extends GenericDAO<OrderItem, Integer> {
  
	List<OrderItem> findAll();
	






}


