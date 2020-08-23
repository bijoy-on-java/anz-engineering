package com.anz.app.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;
import com.anz.app.service.AnzBankAccountTransactionsService;

/**
 * ANZ Engineering: Facade Impl class responsible to perform various database
 * transactions based on user(s) interaction used for Banking application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Service
public class AnzCustomerAccountTransactionsFacadeImpl implements AnzCustomerAccountTransactionsFacade {

	private static final Logger ANZ_LOGGER = LoggerFactory.getLogger(AnzCustomerAccountTransactionsFacadeImpl.class);

	@Autowired
	private AnzBankAccountTransactionsService anzBankAccountTransactionsService;

	@Override
	public void anzBankCustomerAccountNewTransactions(
			final AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel) throws ANZEngineeringException {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug(
					"AnzCustomerAccountTransactionsFacadeImpl.anzBankCustomerAccountNewTransactions: Create customer transactions information.");
		}
		anzBankAccountTransactionsService.anzBankCustomerAccountNewTransactions(anzNewCustomerAccountTransactionsModel);

	}

	@Override
	public List<AnzNewCustomerAccountTransactionsModel> anzBankingCustomerAccountTransactions(
			final Integer accountNumber) throws ANZEngineeringException {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug(
					"AnzCustomerAccountTransactionsFacadeImpl.anzBankingCustomerAccountTransactions: Fetch customer transactions information.");
		}
		return anzBankAccountTransactionsService.anzBankingCustomerAccountTransactions(accountNumber);
	}

}
