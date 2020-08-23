package com.anz.app.service;

import java.util.List;

import com.anz.app.model.AnzNewCustomerAccountModel;

/**
 * ANZ Engineering: Service Interface definition in service layer contains
 * method(s) used for ANZ engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
public interface AnzBankAccountService {

	/**
	 * ANZ Engineering: Facade method responsible to create Banking customer
	 * account(s).
	 * 
	 * @param anzNewCustomerAccountModel
	 */
	public void anzBankNewCustomerAccount(AnzNewCustomerAccountModel anzNewCustomerAccountModel);

	/**
	 * ANZ Engineering: Service method is responsible to get Banking customer
	 * account details.
	 * 
	 * @param userCode
	 * @return List<AnzNewCustomerAccountModel>
	 */
	public List<AnzNewCustomerAccountModel> anzBankingCustomerAccountDetails(String userCode);
}
