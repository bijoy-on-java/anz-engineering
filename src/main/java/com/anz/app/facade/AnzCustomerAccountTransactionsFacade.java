package com.anz.app.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering: Facade Interface definition in facade layer contains
 * method(s) used for Banking wholesale engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
@Service
public interface AnzCustomerAccountTransactionsFacade {

	/**
	 * ANZ Engineering: Facade method is responsible to insert transaction(s)
	 * information for specified account of the Customer.
	 * 
	 * @param anzNewCustomerAccountTransactionsModel
	 */
	public void anzBankCustomerAccountNewTransactions(
			final AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel) throws ANZEngineeringException;

	/**
	 * ANZ Engineering: Facade method is responsible to get Customer account
	 * transaction information(s).
	 * 
	 * @param accountNumber
	 * @return List<BankingCustomerAccountTransactionsModel>
	 */
	public List<AnzNewCustomerAccountTransactionsModel> anzBankingCustomerAccountTransactions(
			final Integer accountNumber) throws ANZEngineeringException;

}
