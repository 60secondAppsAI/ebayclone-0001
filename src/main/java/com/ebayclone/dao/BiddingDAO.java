package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Bidding;





public interface BiddingDAO extends GenericDAO<Bidding, Integer> {
  
	List<Bidding> findAll();
	






}


