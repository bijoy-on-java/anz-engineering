package com.anz.app.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * ANZ Engineering: POJO class / Data structure to hold customer account information.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class AnzNewCustomerAccountDTO {

	private Integer accountNumber;

	private String accountName;
	
	private String accountType;

	private Date balanceDate;

	private String currency;

	private BigDecimal openingAvailableBalance;

	private String userCode;
}
