package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.Report;
import com.ebayclone.dto.ReportDTO;
import com.ebayclone.dto.ReportSearchDTO;
import com.ebayclone.dto.ReportPageDTO;
import com.ebayclone.dto.ReportConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface ReportService extends GenericService<Report, Integer> {

	List<Report> findAll();

	ResultDTO addReport(ReportDTO reportDTO, RequestDTO requestDTO);

	ResultDTO updateReport(ReportDTO reportDTO, RequestDTO requestDTO);

    Page<Report> getAllReports(Pageable pageable);

    Page<Report> getAllReports(Specification<Report> spec, Pageable pageable);

	ResponseEntity<ReportPageDTO> getReports(ReportSearchDTO reportSearchDTO);
	
	List<ReportDTO> convertReportsToReportDTOs(List<Report> reports, ReportConvertCriteriaDTO convertCriteria);

	ReportDTO getReportDTOById(Integer reportId);







}





