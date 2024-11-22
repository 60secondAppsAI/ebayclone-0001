package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.Bidding;
import com.ebayclone.dto.BiddingDTO;
import com.ebayclone.dto.BiddingSearchDTO;
import com.ebayclone.dto.BiddingPageDTO;
import com.ebayclone.dto.BiddingConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BiddingService extends GenericService<Bidding, Integer> {

	List<Bidding> findAll();

	ResultDTO addBidding(BiddingDTO biddingDTO, RequestDTO requestDTO);

	ResultDTO updateBidding(BiddingDTO biddingDTO, RequestDTO requestDTO);

    Page<Bidding> getAllBiddings(Pageable pageable);

    Page<Bidding> getAllBiddings(Specification<Bidding> spec, Pageable pageable);

	ResponseEntity<BiddingPageDTO> getBiddings(BiddingSearchDTO biddingSearchDTO);
	
	List<BiddingDTO> convertBiddingsToBiddingDTOs(List<Bidding> biddings, BiddingConvertCriteriaDTO convertCriteria);

	BiddingDTO getBiddingDTOById(Integer biddingId);







}





