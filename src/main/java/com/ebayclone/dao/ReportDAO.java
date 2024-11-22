package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Report;





public interface ReportDAO extends GenericDAO<Report, Integer> {
  
	List<Report> findAll();
	






}


