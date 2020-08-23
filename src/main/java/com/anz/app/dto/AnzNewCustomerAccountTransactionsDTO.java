package com.anz.app.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * ANZ Engineering: POJO class / Data structure to hold customer account
 * transaction details.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class AnzNewCustomerAccountTransactionsDTO {

	private Integer accountNumber;

	private String accountName;

	private Date valueDate;

	private String currency;

	private BigDecimal debitAmount;

	private BigDecimal creditAmount;

	private String debitOrCredit;

	private String transactionNarative;
}
