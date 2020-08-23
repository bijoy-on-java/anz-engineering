package com.anz.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * ANZ Engineering: Model class holding corresponding data's mapped to customer account transaction's table in the database.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "customer_account_transactions")
@EntityListeners(AuditingEntityListener.class)
public class AnzNewCustomerAccountTransactionsModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Integer accountNumber;

	private String accountName;

	private Date valueDate;

	private String currency;

	private BigDecimal debitAmount;

	private BigDecimal creditAmount;

	private String debitOrCredit;

	private String transactionNarative;
}
