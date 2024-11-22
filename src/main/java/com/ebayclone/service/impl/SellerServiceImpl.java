package com.ebayclone.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.ebayclone.dao.GenericDAO;
import com.ebayclone.service.GenericService;
import com.ebayclone.service.impl.GenericServiceImpl;
import com.ebayclone.dao.SellerDAO;
import com.ebayclone.domain.Seller;
import com.ebayclone.dto.SellerDTO;
import com.ebayclone.dto.SellerSearchDTO;
import com.ebayclone.dto.SellerPageDTO;
import com.ebayclone.dto.SellerConvertCriteriaDTO;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import com.ebayclone.service.SellerService;
import com.ebayclone.util.ControllerUtils;





@Service
public class SellerServiceImpl extends GenericServiceImpl<Seller, Integer> implements SellerService {

    private final static Logger logger = LoggerFactory.getLogger(SellerServiceImpl.class);

	@Autowired
	SellerDAO sellerDao;

	


	@Override
	public GenericDAO<Seller, Integer> getDAO() {
		return (GenericDAO<Seller, Integer>) sellerDao;
	}
	
	public List<Seller> findAll () {
		List<Seller> sellers = sellerDao.findAll();
		
		return sellers;	
		
	}

	public ResultDTO addSeller(SellerDTO sellerDTO, RequestDTO requestDTO) {

		Seller seller = new Seller();

		seller.setSellerId(sellerDTO.getSellerId());


		seller.setStoreName(sellerDTO.getStoreName());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		seller = sellerDao.save(seller);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Seller> getAllSellers(Pageable pageable) {
		return sellerDao.findAll(pageable);
	}

	public Page<Seller> getAllSellers(Specification<Seller> spec, Pageable pageable) {
		return sellerDao.findAll(spec, pageable);
	}

	public ResponseEntity<SellerPageDTO> getSellers(SellerSearchDTO sellerSearchDTO) {
	
			Integer sellerId = sellerSearchDTO.getSellerId(); 
 			String storeName = sellerSearchDTO.getStoreName(); 
 			String sortBy = sellerSearchDTO.getSortBy();
			String sortOrder = sellerSearchDTO.getSortOrder();
			String searchQuery = sellerSearchDTO.getSearchQuery();
			Integer page = sellerSearchDTO.getPage();
			Integer size = sellerSearchDTO.getSize();

	        Specification<Seller> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, sellerId, "sellerId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, storeName, "storeName"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("storeName")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<Seller> sellers = this.getAllSellers(spec, pageable);
		
		//System.out.println(String.valueOf(sellers.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(sellers.getTotalPages()));
		
		List<Seller> sellersList = sellers.getContent();
		
		SellerConvertCriteriaDTO convertCriteria = new SellerConvertCriteriaDTO();
		List<SellerDTO> sellerDTOs = this.convertSellersToSellerDTOs(sellersList,convertCriteria);
		
		SellerPageDTO sellerPageDTO = new SellerPageDTO();
		sellerPageDTO.setSellers(sellerDTOs);
		sellerPageDTO.setTotalElements(sellers.getTotalElements());
		return ResponseEntity.ok(sellerPageDTO);
	}

	public List<SellerDTO> convertSellersToSellerDTOs(List<Seller> sellers, SellerConvertCriteriaDTO convertCriteria) {
		
		List<SellerDTO> sellerDTOs = new ArrayList<SellerDTO>();
		
		for (Seller seller : sellers) {
			sellerDTOs.add(convertSellerToSellerDTO(seller,convertCriteria));
		}
		
		return sellerDTOs;

	}
	
	public SellerDTO convertSellerToSellerDTO(Seller seller, SellerConvertCriteriaDTO convertCriteria) {
		
		SellerDTO sellerDTO = new SellerDTO();
		
		sellerDTO.setSellerId(seller.getSellerId());

	
		sellerDTO.setStoreName(seller.getStoreName());

	

		
		return sellerDTO;
	}

	public ResultDTO updateSeller(SellerDTO sellerDTO, RequestDTO requestDTO) {
		
		Seller seller = sellerDao.getById(sellerDTO.getSellerId());

		seller.setSellerId(ControllerUtils.setValue(seller.getSellerId(), sellerDTO.getSellerId()));

		seller.setStoreName(ControllerUtils.setValue(seller.getStoreName(), sellerDTO.getStoreName()));



        seller = sellerDao.save(seller);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public SellerDTO getSellerDTOById(Integer sellerId) {
	
		Seller seller = sellerDao.getById(sellerId);
			
		
		SellerConvertCriteriaDTO convertCriteria = new SellerConvertCriteriaDTO();
		return(this.convertSellerToSellerDTO(seller,convertCriteria));
	}







}
