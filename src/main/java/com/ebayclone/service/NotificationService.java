package com.ebayclone.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.ebayclone.domain.Notification;
import com.ebayclone.dto.NotificationDTO;
import com.ebayclone.dto.NotificationSearchDTO;
import com.ebayclone.dto.NotificationPageDTO;
import com.ebayclone.dto.NotificationConvertCriteriaDTO;
import com.ebayclone.service.GenericService;
import com.ebayclone.dto.common.RequestDTO;
import com.ebayclone.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface NotificationService extends GenericService<Notification, Integer> {

	List<Notification> findAll();

	ResultDTO addNotification(NotificationDTO notificationDTO, RequestDTO requestDTO);

	ResultDTO updateNotification(NotificationDTO notificationDTO, RequestDTO requestDTO);

    Page<Notification> getAllNotifications(Pageable pageable);

    Page<Notification> getAllNotifications(Specification<Notification> spec, Pageable pageable);

	ResponseEntity<NotificationPageDTO> getNotifications(NotificationSearchDTO notificationSearchDTO);
	
	List<NotificationDTO> convertNotificationsToNotificationDTOs(List<Notification> notifications, NotificationConvertCriteriaDTO convertCriteria);

	NotificationDTO getNotificationDTOById(Integer notificationId);







}





