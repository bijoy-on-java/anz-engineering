package com.anz.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anz.app.constant.AnzEngineeringConstants;
import com.anz.app.dto.AnzNewCustomerAccountDTO;
import com.anz.app.dto.AnzNewCustomerAccountTransactionsDTO;
import com.anz.app.exception.ANZEngineeringException;
import com.anz.app.facade.AnzCustomerAccountTransactionsFacade;
import com.anz.app.facade.AnzCustomerBankAccountFacade;
import com.anz.app.mapper.AnzBankAccountMapper;
import com.anz.app.mapper.AnzBankAccountTransactionsMapper;
import com.anz.app.model.AnzNewCustomerAccountModel;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering: Rest API controller class.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@RestController
@RequestMapping("/api/anz")
public class AnzEngineeringController {

	private static final Logger ANZ_LOGGER = LoggerFactory.getLogger(AnzEngineeringController.class);

	@Autowired
	private AnzCustomerBankAccountFacade anzCustomerBankAccountFacade;

	@Autowired
	private AnzCustomerAccountTransactionsFacade anzCustomerAccountTransactionsFacade;

	/**
	 * ANZ Engineering: Controller method is responsible to create ANZ customer
	 * account(s).
	 * 
	 * @param anzNewCustomerAccountDTO
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/new/account")
	public ResponseEntity<?> anzBankNewCustomerAccount(
			@Valid @RequestBody final AnzNewCustomerAccountDTO anzNewCustomerAccountDTO) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzEngineeringController.anzBankNewCustomerAccount: Create new customer account.");
		}
		if (null == anzNewCustomerAccountDTO) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		final AnzNewCustomerAccountModel anzNewCustomerAccountModel = AnzBankAccountMapper
				.anzNewCustomerDtoToEntity(anzNewCustomerAccountDTO);
		if (null == anzNewCustomerAccountModel) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_REQUEST_PROCESSING,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			anzCustomerBankAccountFacade.anzBankNewCustomerAccount(anzNewCustomerAccountModel);
		} catch (final ANZEngineeringException anzEngineeringException) {
			final Throwable exceptionCause = anzEngineeringException.getCause();
			return new ResponseEntity<String>(
					null != exceptionCause ? exceptionCause.getMessage() : HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(
				AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_SUCCESSFUL_MESSAGE_BANK_ACCOUNT_CREATION
						+ anzNewCustomerAccountDTO.getAccountNumber(),
				HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: Controller method is responsible to get customer account
	 * details based on user code.
	 * 
	 * @param userCode
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/customer/accounts")
	public ResponseEntity<?> anzBankingCustomerAccountDetails(@RequestParam final String userCode) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzEngineeringController.anzBankingCustomerAccountDetails: Fetch Anz customer information.");
		}
		if (StringUtils.isEmpty(userCode)) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		List<AnzNewCustomerAccountModel> bankingCustomerAccounts = null;
		try {
			bankingCustomerAccounts = anzCustomerBankAccountFacade.anzBankingCustomerAccountDetails(userCode);
		} catch (final ANZEngineeringException anzEngineeringException) {
			final Throwable exceptionCause = anzEngineeringException.getCause();
			return new ResponseEntity<String>(
					null != exceptionCause ? exceptionCause.getMessage() : HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (CollectionUtils.isEmpty(bankingCustomerAccounts)) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_BANKING_NO_CONTENT_RESPONSE,
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnzNewCustomerAccountModel>>(bankingCustomerAccounts, HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: Controller method is responsible to insert transaction(s)
	 * details for specified account of the Customer.
	 * 
	 * @param anzNewCustomerAccountTransactionsDTO
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/new/transactions")
	public ResponseEntity<?> anzBankCustomerAccountNewTransactions(
			@Valid @RequestBody final AnzNewCustomerAccountTransactionsDTO anzNewCustomerAccountTransactionsDTO) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzEngineeringController.anzBankCustomerAccountNewTransactions: Create Anz customer account transactions.");
		}
		if (null == anzNewCustomerAccountTransactionsDTO
				|| StringUtils.isEmpty(anzNewCustomerAccountTransactionsDTO.getAccountNumber())) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		AnzNewCustomerAccountTransactionsModel anzNewCustomerAccountTransactionsModel = AnzBankAccountTransactionsMapper
				.anzNewCustomerDtoToEntity(anzNewCustomerAccountTransactionsDTO);
		if (null == anzNewCustomerAccountTransactionsModel) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_REQUEST_PROCESSING,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		try {
			anzCustomerAccountTransactionsFacade
					.anzBankCustomerAccountNewTransactions(anzNewCustomerAccountTransactionsModel);
		} catch (final ANZEngineeringException anzEngineeringException) {
			final Throwable exceptionCause = anzEngineeringException.getCause();
			return new ResponseEntity<String>(
					null != exceptionCause ? exceptionCause.getMessage() : HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>(
				AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_SUCCESSFUL_MESSAGE_BANKING_ACCOUNT_TRANSACTION,
				HttpStatus.OK);
	}

	/**
	 * ANZ Engineering: Controller method is responsible to get Customer account
	 * transaction detail(s).
	 * 
	 * @param accountNumber
	 * @return ResponseEntity<?>
	 */
	@GetMapping("/customer/transactions")
	public ResponseEntity<?> anzBankingCustomerAccountTransactions(@RequestParam final Integer accountNumber) {
		if (ANZ_LOGGER.isDebugEnabled()) {
			ANZ_LOGGER.debug("AnzEngineeringController.anzBankingCustomerAccountTransactions: Fetch customer account transactions.");
		}
		if (StringUtils.isEmpty(accountNumber)) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		List<AnzNewCustomerAccountTransactionsModel> anzNewCustomerAccountTransactions = null;
		try {
			anzNewCustomerAccountTransactions = anzCustomerAccountTransactionsFacade
					.anzBankingCustomerAccountTransactions(accountNumber);
		} catch (final ANZEngineeringException anzEngineeringException) {
			final Throwable exceptionCause = anzEngineeringException.getCause();
			return new ResponseEntity<String>(
					null != exceptionCause ? exceptionCause.getMessage() : HttpStatus.INTERNAL_SERVER_ERROR.toString(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (CollectionUtils.isEmpty(anzNewCustomerAccountTransactions)) {
			return new ResponseEntity<String>(
					AnzEngineeringConstants.AnzCustomerAccountConstants.ANZ_ERROR_MESSAGE_BANKING_NO_CONTENT_RESPONSE,
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnzNewCustomerAccountTransactionsModel>>(anzNewCustomerAccountTransactions,
				HttpStatus.OK);
	}
}
