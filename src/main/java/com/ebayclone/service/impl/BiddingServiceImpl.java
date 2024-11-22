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
import com.ebayclone.dao.BiddingDAO;
import com.ebayclone.domain.Bidding;
import com.ebayclone.dto.BiddingDTO;
import com.ebayclone.dto.BiddingSearchDTO;
import com.ebayclone.dto.BiddingPageDTO;
import com.ebayclone.dto.BiddingConvertCriteriaDTO;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import com.ebayclone.service.BiddingService;
import com.ebayclone.util.ControllerUtils;





@Service
public class BiddingServiceImpl extends GenericServiceImpl<Bidding, Integer> implements BiddingService {

    private final static Logger logger = LoggerFactory.getLogger(BiddingServiceImpl.class);

	@Autowired
	BiddingDAO biddingDao;

	


	@Override
	public GenericDAO<Bidding, Integer> getDAO() {
		return (GenericDAO<Bidding, Integer>) biddingDao;
	}
	
	public List<Bidding> findAll () {
		List<Bidding> biddings = biddingDao.findAll();
		
		return biddings;	
		
	}

	public ResultDTO addBidding(BiddingDTO biddingDTO, RequestDTO requestDTO) {

		Bidding bidding = new Bidding();

		bidding.setBiddingId(biddingDTO.getBiddingId());


		bidding.setBidAmount(biddingDTO.getBidAmount());


		bidding.setBidDate(biddingDTO.getBidDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		bidding = biddingDao.save(bidding);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Bidding> getAllBiddings(Pageable pageable) {
		return biddingDao.findAll(pageable);
	}

	public Page<Bidding> getAllBiddings(Specification<Bidding> spec, Pageable pageable) {
		return biddingDao.findAll(spec, pageable);
	}

	public ResponseEntity<BiddingPageDTO> getBiddings(BiddingSearchDTO biddingSearchDTO) {
	
			Integer biddingId = biddingSearchDTO.getBiddingId(); 
    			String sortBy = biddingSearchDTO.getSortBy();
			String sortOrder = biddingSearchDTO.getSortOrder();
			String searchQuery = biddingSearchDTO.getSearchQuery();
			Integer page = biddingSearchDTO.getPage();
			Integer size = biddingSearchDTO.getSize();

	        Specification<Bidding> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, biddingId, "biddingId"); 
			
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

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

		Page<Bidding> biddings = this.getAllBiddings(spec, pageable);
		
		//System.out.println(String.valueOf(biddings.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(biddings.getTotalPages()));
		
		List<Bidding> biddingsList = biddings.getContent();
		
		BiddingConvertCriteriaDTO convertCriteria = new BiddingConvertCriteriaDTO();
		List<BiddingDTO> biddingDTOs = this.convertBiddingsToBiddingDTOs(biddingsList,convertCriteria);
		
		BiddingPageDTO biddingPageDTO = new BiddingPageDTO();
		biddingPageDTO.setBiddings(biddingDTOs);
		biddingPageDTO.setTotalElements(biddings.getTotalElements());
		return ResponseEntity.ok(biddingPageDTO);
	}

	public List<BiddingDTO> convertBiddingsToBiddingDTOs(List<Bidding> biddings, BiddingConvertCriteriaDTO convertCriteria) {
		
		List<BiddingDTO> biddingDTOs = new ArrayList<BiddingDTO>();
		
		for (Bidding bidding : biddings) {
			biddingDTOs.add(convertBiddingToBiddingDTO(bidding,convertCriteria));
		}
		
		return biddingDTOs;

	}
	
	public BiddingDTO convertBiddingToBiddingDTO(Bidding bidding, BiddingConvertCriteriaDTO convertCriteria) {
		
		BiddingDTO biddingDTO = new BiddingDTO();
		
		biddingDTO.setBiddingId(bidding.getBiddingId());

	
		biddingDTO.setBidAmount(bidding.getBidAmount());

	
		biddingDTO.setBidDate(bidding.getBidDate());

	

		
		return biddingDTO;
	}

	public ResultDTO updateBidding(BiddingDTO biddingDTO, RequestDTO requestDTO) {
		
		Bidding bidding = biddingDao.getById(biddingDTO.getBiddingId());

		bidding.setBiddingId(ControllerUtils.setValue(bidding.getBiddingId(), biddingDTO.getBiddingId()));

		bidding.setBidAmount(ControllerUtils.setValue(bidding.getBidAmount(), biddingDTO.getBidAmount()));

		bidding.setBidDate(ControllerUtils.setValue(bidding.getBidDate(), biddingDTO.getBidDate()));



        bidding = biddingDao.save(bidding);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public BiddingDTO getBiddingDTOById(Integer biddingId) {
	
		Bidding bidding = biddingDao.getById(biddingId);
			
		
		BiddingConvertCriteriaDTO convertCriteria = new BiddingConvertCriteriaDTO();
		return(this.convertBiddingToBiddingDTO(bidding,convertCriteria));
	}







}
