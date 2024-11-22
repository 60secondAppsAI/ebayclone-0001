package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Address;





public interface AddressDAO extends GenericDAO<Address, Integer> {
  
	List<Address> findAll();
	






}


