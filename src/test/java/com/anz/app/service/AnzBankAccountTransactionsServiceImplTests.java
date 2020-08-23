package com.anz.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;
import com.anz.app.repository.AnzBankAccountTransactionsRepository;

/**
 * ANZ Engineering Test Cases: Banking Application Unit Test suite verify
 * testing of multiple scenario's in the service class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnzBankAccountTransactionsServiceImplTests {

	@InjectMocks
	private AnzBankAccountTransactionsService mockBankingCustomerAccountServiceImpl = new AnzBankAccountTransactionsServiceImpl();

	@Mock
	private AnzBankAccountTransactionsRepository anzBankAccountTransactionsRepository;

	@Mock
	private AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel;

	/**
	 * ANZ Engineering : This method is to verify creation of customer account
	 * transaction details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountModelTransactionsWithNullInput() throws Exception {
		mockBankingCustomerAccountServiceImpl.anzBankCustomerAccountNewTransactions(null);
		verify(anzBankAccountTransactionsRepository).save(null);
	}

	/**
	 * ANZ Engineering : This method is to verify creation of customer account
	 * transaction details when input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountModelTransaction() throws Exception {
		mockBankingCustomerAccountServiceImpl
				.anzBankCustomerAccountNewTransactions(anzNewCustomerAccountTransactionsModel);
		verify(anzBankAccountTransactionsRepository).save(anzNewCustomerAccountTransactionsModel);
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * transaction details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsWithNullInput() throws Exception {
		List<AnzNewCustomerAccountTransactionsModel> bankingCustomerAccountTransactionsModels = mockBankingCustomerAccountServiceImpl
				.anzBankingCustomerAccountTransactions(null);
		assertThat(bankingCustomerAccountTransactionsModels).as("Customer Account Transaction Details")
				.isEqualTo(Collections.emptyList());
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * transaction details when no input provided. Here response data successfully
	 * fetched and verified.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactions() throws Exception {
		AnzNewCustomerAccountTransactionsModel bankingCustomerAccountTransactionsModel = new AnzNewCustomerAccountTransactionsModel();
		Integer accountNumber = 239403456;
		bankingCustomerAccountTransactionsModel.setAccountNumber(accountNumber);
		String accountName = "AUSaving933";
		bankingCustomerAccountTransactionsModel.setAccountName(accountName);
		Date valueDate = new Date(1220227200L * 1000);
		bankingCustomerAccountTransactionsModel.setValueDate(valueDate);
		String currency = "AUD";
		bankingCustomerAccountTransactionsModel.setCurrency(currency);
		BigDecimal debitAmount = new BigDecimal(34322.44);
		bankingCustomerAccountTransactionsModel.setDebitAmount(debitAmount);
		BigDecimal creditAccount = new BigDecimal(3344322.44);
		bankingCustomerAccountTransactionsModel.setCreditAmount(creditAccount);
		String debitOrCredit = "Credit";
		bankingCustomerAccountTransactionsModel.setDebitOrCredit(debitOrCredit);
		String transactionNarative = "Banking Transaction.";
		bankingCustomerAccountTransactionsModel.setTransactionNarative(transactionNarative);
		List<AnzNewCustomerAccountTransactionsModel> bankingCustomerAccountModelTransactions = new ArrayList<>();
		bankingCustomerAccountModelTransactions.add(bankingCustomerAccountTransactionsModel);
		given(anzBankAccountTransactionsRepository.anzBankingCustomerAccountTransactions(accountNumber))
				.willReturn(bankingCustomerAccountModelTransactions);
		List<AnzNewCustomerAccountTransactionsModel> bankingCustomerAccountTransactionsModels = mockBankingCustomerAccountServiceImpl
				.anzBankingCustomerAccountTransactions(accountNumber);
		assertThat(bankingCustomerAccountTransactionsModels).as("Customer Account Details").isNotEmpty().hasSize(1);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getAccountNumber()).as("Account Number")
				.isEqualTo(accountNumber);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getAccountName()).as("Account Name")
				.isEqualTo(accountName);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getValueDate()).as("Value Date")
				.isEqualTo(valueDate);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getCurrency()).as("Currency").isEqualTo(currency);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getDebitAmount()).as("Debit Amount")
				.isEqualTo(debitAmount);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getCreditAmount()).as("Credit Amount")
				.isEqualTo(creditAccount);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getDebitOrCredit()).as("Debit/Credit")
				.isEqualTo(debitOrCredit);
		assertThat(bankingCustomerAccountTransactionsModels.get(0).getTransactionNarative())
				.as("Transactions Narrative").isEqualTo(transactionNarative);
		verify(anzBankAccountTransactionsRepository).anzBankingCustomerAccountTransactions(accountNumber);
	}

}
