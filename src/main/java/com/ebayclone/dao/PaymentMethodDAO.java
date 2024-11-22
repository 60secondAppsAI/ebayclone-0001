package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.PaymentMethod;





public interface PaymentMethodDAO extends GenericDAO<PaymentMethod, Integer> {
  
	List<PaymentMethod> findAll();
	






}


