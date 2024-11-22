package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.PaymentMethod;
import com.ebayclone.dto.PaymentMethodDTO;
import com.ebayclone.dto.PaymentMethodSearchDTO;
import com.ebayclone.dto.PaymentMethodPageDTO;
import com.ebayclone.dto.PaymentMethodConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PaymentMethodService extends GenericService<PaymentMethod, Integer> {

	List<PaymentMethod> findAll();

	ResultDTO addPaymentMethod(PaymentMethodDTO paymentMethodDTO, RequestDTO requestDTO);

	ResultDTO updatePaymentMethod(PaymentMethodDTO paymentMethodDTO, RequestDTO requestDTO);

    Page<PaymentMethod> getAllPaymentMethods(Pageable pageable);

    Page<PaymentMethod> getAllPaymentMethods(Specification<PaymentMethod> spec, Pageable pageable);

	ResponseEntity<PaymentMethodPageDTO> getPaymentMethods(PaymentMethodSearchDTO paymentMethodSearchDTO);
	
	List<PaymentMethodDTO> convertPaymentMethodsToPaymentMethodDTOs(List<PaymentMethod> paymentMethods, PaymentMethodConvertCriteriaDTO convertCriteria);

	PaymentMethodDTO getPaymentMethodDTOById(Integer paymentMethodId);







}





