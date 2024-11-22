package com.ebayclone.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.ebayclone.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.ebayclone.domain.Bidding;
import com.ebayclone.dto.BiddingDTO;
import com.ebayclone.dto.BiddingSearchDTO;
import com.ebayclone.dto.BiddingPageDTO;
import com.ebayclone.service.BiddingService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/bidding")
@RestController
public class BiddingController {

	private final static Logger logger = LoggerFactory.getLogger(BiddingController.class);

	@Autowired
	BiddingService biddingService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Bidding> getAll() {

		List<Bidding> biddings = biddingService.findAll();
		
		return biddings;	
	}

	@GetMapping(value = "/{biddingId}")
	@ResponseBody
	public BiddingDTO getBidding(@PathVariable Integer biddingId) {
		
		return (biddingService.getBiddingDTOById(biddingId));
	}

 	@RequestMapping(value = "/addBidding", method = RequestMethod.POST)
	public ResponseEntity<?> addBidding(@RequestBody BiddingDTO biddingDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = biddingService.addBidding(biddingDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/biddings")
	public ResponseEntity<BiddingPageDTO> getBiddings(BiddingSearchDTO biddingSearchDTO) {
 
		return biddingService.getBiddings(biddingSearchDTO);
	}	

	@RequestMapping(value = "/updateBidding", method = RequestMethod.POST)
	public ResponseEntity<?> updateBidding(@RequestBody BiddingDTO biddingDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = biddingService.updateBidding(biddingDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
