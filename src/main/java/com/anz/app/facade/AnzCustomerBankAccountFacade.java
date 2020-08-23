package com.anz.app.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.model.AnzNewCustomerAccountModel;

/**
 * ANZ Engineering: Interface definition in facade layer contains method(s) used
 * for Banking wholesale engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
@Service
public interface AnzCustomerBankAccountFacade {

	/**
	 * ANZ Engineering: Facade method responsible to create Banking customer
	 * account(s).
	 * 
	 * @param anzNewCustomerAccountModel
	 */
	public void anzBankNewCustomerAccount(AnzNewCustomerAccountModel anzNewCustomerAccountModel) throws ANZEngineeringException;

	/**
	 * ANZ Engineering: Facade method is responsible to get Banking customer account
	 * details.
	 * 
	 * @param userCode
	 * @return List<AnzNewCustomerAccountModel>
	 */
	public List<AnzNewCustomerAccountModel> anzBankingCustomerAccountDetails(String userCode) throws ANZEngineeringException;

}
