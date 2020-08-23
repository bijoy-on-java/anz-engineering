package com.anz.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;
import com.anz.app.repository.AnzBankAccountTransactionsRepository;

/**
 * ANZ Engineering: Service implementation class for account transactions in
 * service layer contains method(s) used for ANZ engineering application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
@Service
public class AnzBankAccountTransactionsServiceImpl implements AnzBankAccountTransactionsService {

	private static final Logger ANZ_LOGGER = LoggerFactory.getLogger(AnzBankAccountTransactionsServiceImpl.class);

	@Autowired
	private AnzBankAccountTransactionsRepository anzBankAccountTransactionsRepository;

	@Override
	public void anzBankCustomerAccountNewTransactions(
			AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug(
					"AnzBankAccountTransactionsServiceImpl.anzBankCustomerAccountNewTransactions: Create customer transactions information.");
		}
		anzBankAccountTransactionsRepository.save(anzNewCustomerAccountTransactionsModel);
	}

	@Override
	public List<AnzNewCustomerAccountTransactionsModel> anzBankingCustomerAccountTransactions(Integer accountNumber) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug(
					"AnzBankAccountTransactionsServiceImpl.anzBankingCustomerAccountTransactions: Fetch customer transactions information.");
		}
		return anzBankAccountTransactionsRepository.anzBankingCustomerAccountTransactions(accountNumber);
	}

}
