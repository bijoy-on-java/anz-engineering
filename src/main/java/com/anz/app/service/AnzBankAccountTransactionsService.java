package com.anz.app.service;

import java.util.List;

import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering: Service Interface definition in service layer contains
 * method(s) used for ANZ engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
public interface AnzBankAccountTransactionsService {

	/**
	 * ANZ Engineering: Service method is responsible to insert transaction(s)
	 * information for specified account of the Customer.
	 * 
	 * @param anzNewCustomerAccountTransactionsModel
	 */
	public void anzBankCustomerAccountNewTransactions(AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel);
	
	/**
	 * ANZ Engineering: Facade method is responsible to get Customer account
	 * transaction information(s).
	 * 
	 * @param accountNumber
	 * @return List<AnzNewCustomerAccountTransactionsModel>
	 */
	public List<AnzNewCustomerAccountTransactionsModel> anzBankingCustomerAccountTransactions(Integer accountNumber);

}
