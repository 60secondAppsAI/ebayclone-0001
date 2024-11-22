package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.WishlistItem;





public interface WishlistItemDAO extends GenericDAO<WishlistItem, Integer> {
  
	List<WishlistItem> findAll();
	






}


