package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Shipment;





public interface ShipmentDAO extends GenericDAO<Shipment, Integer> {
  
	List<Shipment> findAll();
	






}


