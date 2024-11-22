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

import com.ebayclone.domain.Seller;
import com.ebayclone.dto.SellerDTO;
import com.ebayclone.dto.SellerSearchDTO;
import com.ebayclone.dto.SellerPageDTO;
import com.ebayclone.service.SellerService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/seller")
@RestController
public class SellerController {

	private final static Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	SellerService sellerService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Seller> getAll() {

		List<Seller> sellers = sellerService.findAll();
		
		return sellers;	
	}

	@GetMapping(value = "/{sellerId}")
	@ResponseBody
	public SellerDTO getSeller(@PathVariable Integer sellerId) {
		
		return (sellerService.getSellerDTOById(sellerId));
	}

 	@RequestMapping(value = "/addSeller", method = RequestMethod.POST)
	public ResponseEntity<?> addSeller(@RequestBody SellerDTO sellerDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = sellerService.addSeller(sellerDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/sellers")
	public ResponseEntity<SellerPageDTO> getSellers(SellerSearchDTO sellerSearchDTO) {
 
		return sellerService.getSellers(sellerSearchDTO);
	}	

	@RequestMapping(value = "/updateSeller", method = RequestMethod.POST)
	public ResponseEntity<?> updateSeller(@RequestBody SellerDTO sellerDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = sellerService.updateSeller(sellerDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
