package com.banking.facade;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.anz.app.facade.AnzCustomerBankAccountFacade;
import com.anz.app.facade.AnzCustomerBankAccountFacadeImpl;
import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.service.AnzBankAccountService;

/**
 * ANZ Engineering Test Cases: Banking Application Unit Test suite verify
 * testing of multiple scenario's in the bank account facade class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AnzCustomerBankAccountFacadeImplTests {

	@InjectMocks
	private AnzCustomerBankAccountFacade bankingCustomerAccountFacade = new AnzCustomerBankAccountFacadeImpl();

	@Mock
	private AnzBankAccountService mockBankingCustomerAccountService;

	@Mock
	private AnzNewCustomerAccountModel mockBankingCustomerAccountModel;

	/**
	 * ANZ Engineering : This method is to verify creation of customer account details
	 * when no input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountDetailsWithNullInput() throws Exception {
		bankingCustomerAccountFacade.anzBankNewCustomerAccount(null);
		verify(mockBankingCustomerAccountService).anzBankNewCustomerAccount(null);
	}

	/**
	 * ANZ Engineering : This method is to verify creation of customer account details
	 * when input data provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInsertBankingCustomerAccountDetails() throws Exception {
		bankingCustomerAccountFacade.anzBankNewCustomerAccount(mockBankingCustomerAccountModel);
		verify(mockBankingCustomerAccountService).anzBankNewCustomerAccount(mockBankingCustomerAccountModel);
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * details when no input provided.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountsWithNullInput() throws Exception {
		bankingCustomerAccountFacade.anzBankingCustomerAccountDetails(null);
		verify(mockBankingCustomerAccountService, never()).anzBankNewCustomerAccount(null);
	}

	/**
	 * ANZ Engineering : This method is to verify retrieval of customer account
	 * details when input data provided. Here response data successfully fetched and
	 * verified.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetBankingCustomerAccountsDetails() throws Exception {
		String userCode = "banking_test_user1";
		bankingCustomerAccountFacade.anzBankingCustomerAccountDetails(userCode);
		verify(mockBankingCustomerAccountService).anzBankingCustomerAccountDetails(userCode);
	}

}
