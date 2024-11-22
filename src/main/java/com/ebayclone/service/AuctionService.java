package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.Auction;
import com.ebayclone.dto.AuctionDTO;
import com.ebayclone.dto.AuctionSearchDTO;
import com.ebayclone.dto.AuctionPageDTO;
import com.ebayclone.dto.AuctionConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AuctionService extends GenericService<Auction, Integer> {

	List<Auction> findAll();

	ResultDTO addAuction(AuctionDTO auctionDTO, RequestDTO requestDTO);

	ResultDTO updateAuction(AuctionDTO auctionDTO, RequestDTO requestDTO);

    Page<Auction> getAllAuctions(Pageable pageable);

    Page<Auction> getAllAuctions(Specification<Auction> spec, Pageable pageable);

	ResponseEntity<AuctionPageDTO> getAuctions(AuctionSearchDTO auctionSearchDTO);
	
	List<AuctionDTO> convertAuctionsToAuctionDTOs(List<Auction> auctions, AuctionConvertCriteriaDTO convertCriteria);

	AuctionDTO getAuctionDTOById(Integer auctionId);







}





