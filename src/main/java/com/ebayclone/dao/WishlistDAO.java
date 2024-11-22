package com.ebayclone.dao;

import java.util.List;

import com.ebayclone.dao.GenericDAO;
import com.ebayclone.domain.Wishlist;





public interface WishlistDAO extends GenericDAO<Wishlist, Integer> {
  
	List<Wishlist> findAll();
	






}


