package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Seller;





public interface SellerDAO extends GenericDAO<Seller, Integer> {
  
	List<Seller> findAll();
	






}


