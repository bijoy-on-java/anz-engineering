package com.banking.facade;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.anz.app.facade.AnzCustomerAccountTransactionsFacade;
import com.anz.app.facade.AnzCustomerAccountTransactionsFacadeImpl;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;
import com.anz.app.service.AnzBankAccountTransactionsService;

/**
 * ANZ Engineering Test Cases: Banking Application Unit Test suite verify
 * testing of multiple scenario's in the account transactions facade class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnzCustomerBankAccountTransactionsFacadeImplTests {

	@InjectMocks
	private AnzCustomerAccountTransactionsFacade anzCustomerAccountTransactionsFacade = new AnzCustomerAccountTransactionsFacadeImpl();

	@Mock
	private AnzBankAccountTransactionsService anzBankAccountTransactionsService;

	@Mock
	private AnzNewCustomerAccountTransactionsModel mockBankingCustomerAccountTransactionsModel;

	/**
	 * Test scenario : This method is to verify creation of customer account
	 * transaction details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountModelTransactionsWithNullInput() throws Exception {
		anzCustomerAccountTransactionsFacade.anzBankCustomerAccountNewTransactions(null);
		verify(anzBankAccountTransactionsService).anzBankCustomerAccountNewTransactions(null);
	}

	/**
	 * Test scenario : This method is to verify creation of customer account
	 * transaction details when input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountModelTransactions() throws Exception {
		anzCustomerAccountTransactionsFacade
				.anzBankCustomerAccountNewTransactions(mockBankingCustomerAccountTransactionsModel);
		verify(anzBankAccountTransactionsService)
				.anzBankCustomerAccountNewTransactions(mockBankingCustomerAccountTransactionsModel);
	}

	/**
	 * Test scenario : This method is to verify retrieval of customer account
	 * transaction details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsWithNullInput() throws Exception {
		anzCustomerAccountTransactionsFacade.anzBankingCustomerAccountTransactions(null);
		verify(anzBankAccountTransactionsService).anzBankingCustomerAccountTransactions(null);
	}

	/**
	 * Test scenario : This method is to verify retrieval of customer account
	 * transaction details when no input provided. Here response data successfully
	 * fetched and verified.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsDetails() throws Exception {
		Integer accountNumber = 564567324;
		anzCustomerAccountTransactionsFacade.anzBankingCustomerAccountTransactions(accountNumber);
		verify(anzBankAccountTransactionsService).anzBankingCustomerAccountTransactions(accountNumber);
	}
}
