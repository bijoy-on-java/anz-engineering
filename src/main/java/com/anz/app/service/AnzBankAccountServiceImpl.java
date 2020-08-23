package com.anz.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.repository.AnzBankAccountRepository;

/**
 * ANZ Engineering: Service implementation class for account creation/details in service layer contains
 * method(s) used for ANZ engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
@Service
public class AnzBankAccountServiceImpl implements AnzBankAccountService {
	
	private static final Logger ANZ_LOGGER = LoggerFactory.getLogger(AnzBankAccountServiceImpl.class);

	@Autowired
	private AnzBankAccountRepository productRepository;

	@Override
	public void anzBankNewCustomerAccount(AnzNewCustomerAccountModel anzNewCustomerAccountModel) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzBankAccountServiceImpl.anzBankNewCustomerAccount: Create new customer account.");
		}
		productRepository.save(anzNewCustomerAccountModel);
	}

	@Override
	public List<AnzNewCustomerAccountModel> anzBankingCustomerAccountDetails(String userCode) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzBankAccountServiceImpl.anzBankingCustomerAccountDetails: Fetch Anz customer information.");
		}
		return productRepository.anzBankingCustomerAccountDetails(userCode);
	}
}
