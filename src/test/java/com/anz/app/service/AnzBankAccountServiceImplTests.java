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

import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.repository.AnzBankAccountRepository;

/**
 * ANZ Engineering Test Cases: Banking Application Unit Test suite verify
 * testing of multiple scenario's in the service class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnzBankAccountServiceImplTests {

	@InjectMocks
	private AnzBankAccountService anzBankAccountService = new AnzBankAccountServiceImpl();

	@Mock
	private AnzBankAccountRepository anzBankAccountRepository;

	@Mock
	private AnzNewCustomerAccountModel mockAnzNewCustomerAccountModel;

	/**
	 * ANZ Engineering : This method is to verify creation of customer account
	 * details when no input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountDetailsWIthNullInput() throws Exception {
		anzBankAccountService.anzBankNewCustomerAccount(null);
		verify(anzBankAccountRepository).save(null);
	}

	/**
	 * ANZ Engineering : This method is to verify creation of customer account
	 * details when input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountDetails() throws Exception {
		anzBankAccountService.anzBankNewCustomerAccount(mockAnzNewCustomerAccountModel);
		verify(anzBankAccountRepository).save(mockAnzNewCustomerAccountModel);
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountsWithNullInput() throws Exception {
		given(anzBankAccountRepository.anzBankingCustomerAccountDetails(null)).willReturn(Collections.emptyList());
		List<AnzNewCustomerAccountModel> bankingCustomerAccountModels = anzBankAccountService
				.anzBankingCustomerAccountDetails(null);
		assertThat(bankingCustomerAccountModels).as("Customer Account Details").isEqualTo(Collections.emptyList());
		verify(anzBankAccountRepository).anzBankingCustomerAccountDetails(null);
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * details when input data provided. Here response data successfully fetched and
	 * verified.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccounts() throws Exception {
		AnzNewCustomerAccountModel bankingCustomerAccountModel = new AnzNewCustomerAccountModel();
		Integer accountNumber = 239403456;
		bankingCustomerAccountModel.setAccountNumber(accountNumber);
		String accountName = "AUSaving933";
		bankingCustomerAccountModel.setAccountName(accountName);
		String accountType = "Savings";
		bankingCustomerAccountModel.setAccountType(accountType);
		Date balanceDate = new Date(1220227200L * 1000);
		bankingCustomerAccountModel.setBalanceDate(balanceDate);
		String currency = "AUD";
		bankingCustomerAccountModel.setCurrency(currency);
		BigDecimal openingBalanceAvailable = new BigDecimal(34322.44);
		bankingCustomerAccountModel.setOpeningAvailableBalance(openingBalanceAvailable);
		String userCode = "banking_test_user31";
		bankingCustomerAccountModel.setUserCode(userCode);
		List<AnzNewCustomerAccountModel> bankingCustomerAccountModels = new ArrayList<>();
		bankingCustomerAccountModels.add(bankingCustomerAccountModel);
		given(anzBankAccountRepository.anzBankingCustomerAccountDetails(userCode))
				.willReturn(bankingCustomerAccountModels);
		List<AnzNewCustomerAccountModel> bankingCustomerAccountModelValues = anzBankAccountService
				.anzBankingCustomerAccountDetails(userCode);
		assertThat(bankingCustomerAccountModelValues).as("Customer Account Details").isNotEmpty().hasSize(1);
		assertThat(bankingCustomerAccountModels.get(0).getAccountNumber()).as("Account Number")
				.isEqualTo(accountNumber);
		assertThat(bankingCustomerAccountModels.get(0).getAccountName()).as("Account Name").isEqualTo(accountName);
		assertThat(bankingCustomerAccountModels.get(0).getAccountType()).as("Account Type").isEqualTo(accountType);
		assertThat(bankingCustomerAccountModels.get(0).getBalanceDate()).as("Balance Date").isEqualTo(balanceDate);
		assertThat(bankingCustomerAccountModels.get(0).getCurrency()).as("Currency").isEqualTo(currency);
		assertThat(bankingCustomerAccountModels.get(0).getOpeningAvailableBalance()).as("Opening Balance Available")
				.isEqualTo(openingBalanceAvailable);
		verify(anzBankAccountRepository).anzBankingCustomerAccountDetails(userCode);
	}
}
