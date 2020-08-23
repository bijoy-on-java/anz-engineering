package com.anz.app.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.service.AnzBankAccountService;

/**
 * ANZ Engineering: Facade Impl class responsible to perform various database
 * transactions based on user(s) interaction used for Banking application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Service
public class AnzCustomerBankAccountFacadeImpl implements AnzCustomerBankAccountFacade {
	
	private static final Logger ANZ_LOGGER = LoggerFactory.getLogger(AnzCustomerAccountTransactionsFacadeImpl.class);

	@Autowired
	private AnzBankAccountService anzBankAccountService;

	@Override
	public void anzBankNewCustomerAccount(final AnzNewCustomerAccountModel bankingCustomerAccountModel) throws ANZEngineeringException {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzCustomerBankAccountFacadeImpl.anzBankNewCustomerAccount: Create new customer account.");
		}
		anzBankAccountService.anzBankNewCustomerAccount(bankingCustomerAccountModel);
	}

	@Override
	public List<AnzNewCustomerAccountModel> anzBankingCustomerAccountDetails(final String userCode) throws ANZEngineeringException {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzCustomerBankAccountFacadeImpl.anzBankingCustomerAccountDetails: Fetch Anz customer information.");
		}
		return anzBankAccountService.anzBankingCustomerAccountDetails(userCode);
	}
}
