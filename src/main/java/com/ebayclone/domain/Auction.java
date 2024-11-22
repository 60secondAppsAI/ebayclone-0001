package com.ebayclone.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="auctions")
@Getter @Setter @NoArgsConstructor
public class Auction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="auction_id")
	private Integer auctionId;
    
  	@Column(name="start_time")
	private Date startTime;
    
  	@Column(name="end_time")
	private Date endTime;
    
  	@Column(name="starting_price")
	private double startingPrice;
    
	




}
