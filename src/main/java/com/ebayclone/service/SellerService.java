package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.Seller;
import com.ebayclone.dto.SellerDTO;
import com.ebayclone.dto.SellerSearchDTO;
import com.ebayclone.dto.SellerPageDTO;
import com.ebayclone.dto.SellerConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface SellerService extends GenericService<Seller, Integer> {

	List<Seller> findAll();

	ResultDTO addSeller(SellerDTO sellerDTO, RequestDTO requestDTO);

	ResultDTO updateSeller(SellerDTO sellerDTO, RequestDTO requestDTO);

    Page<Seller> getAllSellers(Pageable pageable);

    Page<Seller> getAllSellers(Specification<Seller> spec, Pageable pageable);

	ResponseEntity<SellerPageDTO> getSellers(SellerSearchDTO sellerSearchDTO);
	
	List<SellerDTO> convertSellersToSellerDTOs(List<Seller> sellers, SellerConvertCriteriaDTO convertCriteria);

	SellerDTO getSellerDTOById(Integer sellerId);







}





