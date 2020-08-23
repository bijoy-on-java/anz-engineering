package com.anz.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.anz.app.constant.AnzEngineeringConstants;
import com.anz.app.dto.AnzNewCustomerAccountDTO;
import com.anz.app.dto.AnzNewCustomerAccountTransactionsDTO;
import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.facade.AnzCustomerAccountTransactionsFacade;
import com.anz.app.facade.AnzCustomerBankAccountFacade;
import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering Test Cases: Banking Application Unit Test suite verify
 * testing of multiple scenario's in the controller class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnzEngineeringControllerTests {

	private static final String CUSTOMER_ACCOUNT_CREATED = "ANZ account: Customer account have been created successfully. And the account number is: ";

	@InjectMocks
	private AnzEngineeringController anzEngineeringController = new AnzEngineeringController();

	@Mock
	private AnzNewCustomerAccountDTO mockAnzNewCustomerAccountDTO;

	@Mock
	private AnzNewCustomerAccountModel mockAnzNewCustomerAccountModel;

	@Mock
	private AnzNewCustomerAccountTransactionsDTO anzNewCustomerAccountTransactionsDTO;

	@Mock
	private AnzNewCustomerAccountTransactionsModel mockBankingCustomerAccountTransactionModel;

	@Mock
	private AnzCustomerBankAccountFacade mockBankingCustomerAccountFacade;

	@Mock
	private AnzCustomerAccountTransactionsFacade mockAnzCustomerAccountTransactionsFacade;

	@Mock
	private ANZEngineeringException mockANZEngineeringException;

	@Mock
	private Throwable mockThrowable;

	/**
	 * ANZ Engineering: This test scenario will verify non processing of data and
	 * throw an error message if supplied input is null.
	 */
	@Test
	public void testCreateBankingCustomerAccountWithNullInput() {
		final ResponseEntity<?> responseEntity = anzEngineeringController.anzBankNewCustomerAccount(null);
		assertThat(responseEntity.getBody()).isNotNull().as("Response Body")
				.isEqualTo(AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY);
		assertThat(responseEntity.getStatusCode()).isNotNull().as("Status Code")
				.isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * ANZ Engineering: This test scenario will verify creation of customer data
	 * successfully.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateBankingCustomerAccount() throws Exception {
		final Integer accountNumber = 123044569;
		given(mockAnzNewCustomerAccountDTO.getAccountNumber()).willReturn(accountNumber);
		given(mockAnzNewCustomerAccountDTO.getUserCode()).willReturn("banking_test_user1");
		ResponseEntity<?> responseEntity = anzEngineeringController
				.anzBankNewCustomerAccount(mockAnzNewCustomerAccountDTO);
		assertThat(responseEntity.getBody()).isNotNull().as("Response Body")
				.isEqualTo(CUSTOMER_ACCOUNT_CREATED + accountNumber);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: This test scenario will verify non processing of data and
	 * throw an error message if supplied input is null.
	 */
	@Test
	public void testGetBankingCustomerAccountsWithNullInput() {
		final ResponseEntity<?> responseEntity = anzEngineeringController.anzBankingCustomerAccountDetails(null);
		assertThat(responseEntity.getBody()).isNotNull().as("Response Body")
				.isEqualTo(AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY);
		assertThat(responseEntity.getStatusCode()).isNotNull().as("Status Code")
				.isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * ANZ Engineering: This test scenario will return exception whenever request
	 * processing failed to get account information for the user.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountsThrowException() throws Exception {
		final String userCode = "banking_test_user_22";
		given(mockANZEngineeringException.getCause()).willReturn(mockThrowable);
		willThrow(mockANZEngineeringException).given(mockBankingCustomerAccountFacade)
				.anzBankingCustomerAccountDetails(userCode);
		ResponseEntity<?> responseEntity = anzEngineeringController.anzBankingCustomerAccountDetails(userCode);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * ANZ Engineering: This test scenario will verify list of account(s) created
	 * for the user.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccounts() throws Exception {
		final List<AnzNewCustomerAccountModel> customerAccounts = new ArrayList<>();
		final AnzNewCustomerAccountModel bankingCustomerAccountModel = new AnzNewCustomerAccountModel();
		bankingCustomerAccountModel.setAccountNumber(234567844);
		bankingCustomerAccountModel.setAccountType("Savings");
		bankingCustomerAccountModel.setAccountName("AUSavings");
		bankingCustomerAccountModel.setBalanceDate(new Date(1220227200L * 1000));
		bankingCustomerAccountModel.setCurrency("AUD");
		bankingCustomerAccountModel.setOpeningAvailableBalance(new BigDecimal(23123.33));
		customerAccounts.add(bankingCustomerAccountModel);
		final String userCode = "banking_test_user2";
		given(mockBankingCustomerAccountFacade.anzBankingCustomerAccountDetails(userCode)).willReturn(customerAccounts);
		ResponseEntity<?> responseEntity = anzEngineeringController.anzBankingCustomerAccountDetails(userCode);
		assertThat(responseEntity.getBody()).isNotNull().asList().as("Response Body").isNotEmpty();
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: This test scenario will verify empty list of user.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountsWithEmptyResponse() throws Exception {
		final String userCode = "banking_test_user3";
		given(mockBankingCustomerAccountFacade.anzBankingCustomerAccountDetails(userCode)).willReturn(null);
		final ResponseEntity<?> responseEntity = anzEngineeringController.anzBankingCustomerAccountDetails(userCode);
		assertThat(responseEntity.getBody()).as("Response Body").isEqualTo(
				AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_BANKING_NO_CONTENT_RESPONSE);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.NO_CONTENT);
	}

	/**
	 * ANZ Engineering: This test scenario will verify error response for null
	 * transaction input.
	 */
	@Test
	public void testInsertBankingCustomerTransactionWithNullInput() {
		final ResponseEntity<?> responseEntity = anzEngineeringController.anzBankCustomerAccountNewTransactions(null);
		assertThat(responseEntity.getBody()).as("Response Body")
				.isEqualTo(AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * ANZ Engineering: This test scenario will verify successful creation of
	 * customer account transaction information.
	 */
	@Test
	public void testInsertBankingCustomerTransactions() {
		given(mockBankingCustomerAccountTransactionModel.getAccountNumber()).willReturn(234679315);
		final ResponseEntity<?> responseEntity = anzEngineeringController
				.anzBankCustomerAccountNewTransactions(anzNewCustomerAccountTransactionsDTO);
		assertThat(responseEntity.getBody()).as("Response Body").isNotNull().isEqualTo(
				AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_SUCCESSFUL_MESSAGE_BANKING_ACCOUNT_TRANSACTION);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: This test scenario will verify error messages whenever no
	 * customer number input provided for getting respective transaction
	 * information.
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsWithNullInput() {
		final ResponseEntity<?> responseEntity = anzEngineeringController.anzBankingCustomerAccountTransactions(null);
		assertThat(responseEntity.getBody()).as("Response Body").isNotNull()
				.isEqualTo(AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	/**
	 * ANZ Engineering: This test scenario will verify return exception whenever
	 * request processing failed to get transaction information for the user.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsThrowException() throws Exception {
		final Integer accountNumber = Integer.valueOf(343223564);
		given(mockANZEngineeringException.getCause()).willReturn(mockThrowable);
		willThrow(mockANZEngineeringException).given(mockAnzCustomerAccountTransactionsFacade)
				.anzBankingCustomerAccountTransactions(accountNumber);
		final ResponseEntity<?> responseEntity = anzEngineeringController
				.anzBankingCustomerAccountTransactions(accountNumber);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * ANZ Engineering: This test scenario will verify no response of transaction
	 * information while processing the request.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactionsReturnNull() throws Exception {
		final Integer accountNumber = 988650975;
		given(mockAnzCustomerAccountTransactionsFacade.anzBankingCustomerAccountTransactions(accountNumber))
				.willReturn(null);
		final ResponseEntity<?> responseEntity = anzEngineeringController
				.anzBankingCustomerAccountTransactions(accountNumber);
		assertThat(responseEntity.getBody()).as("Response Body").isNotNull().isEqualTo(
				AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_BANKING_NO_CONTENT_RESPONSE);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.NO_CONTENT);
	}

	/**
	 * ANZ Engineering: This test scenario will verify the response of customer
	 * transaction information while processing the request.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountTransactions() throws Exception {
		final Integer accountNumber = 435678234;
		final List<AnzNewCustomerAccountTransactionsModel> bankingCustomerAccountTransactionsModels = new ArrayList<>();
		final AnzNewCustomerAccountTransactionsModel bankingCustomerAccountTransactionsModel = new AnzNewCustomerAccountTransactionsModel();
		bankingCustomerAccountTransactionsModel.setAccountNumber(accountNumber);
		bankingCustomerAccountTransactionsModel.setAccountName("Current Account");
		bankingCustomerAccountTransactionsModel.setCurrency("SGD");
		bankingCustomerAccountTransactionsModel.setDebitAmount(new BigDecimal(1234567.4));
		bankingCustomerAccountTransactionsModel.setCreditAmount(new BigDecimal(4533.44));
		bankingCustomerAccountTransactionsModel.setDebitOrCredit("Credit");
		bankingCustomerAccountTransactionsModel.setTransactionNarative("Amount credited");
		bankingCustomerAccountTransactionsModels.add(bankingCustomerAccountTransactionsModel);
		given(mockAnzCustomerAccountTransactionsFacade.anzBankingCustomerAccountTransactions(accountNumber))
				.willReturn(bankingCustomerAccountTransactionsModels);
		final ResponseEntity<?> responseEntity = anzEngineeringController
				.anzBankingCustomerAccountTransactions(accountNumber);
		assertThat(responseEntity.getBody()).as("Response Body").isNotNull()
				.isEqualTo(bankingCustomerAccountTransactionsModels);
		assertThat(responseEntity.getStatusCode()).as("Status Code").isEqualTo(HttpStatus.OK);
	}

}
