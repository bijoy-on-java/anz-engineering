package com.anz.app.mapper;

import com.anz.app.dto.AnzNewCustomerAccountTransactionsDTO;
import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering: ANZ customer bank account transactions mapper is used to map
 * new ANZ customer data to corresponding entity object in database table.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
public class AnzBankAccountTransactionsMapper {

	/**
	 * ANZ Engineering: Mapper method is responsible to convert input request to
	 * corresponding database response model object.
	 * 
	 * @param anzNewCustomerAccountTransactionsDTO
	 * @return AnzNewCustomerAccountTransactionsModel
	 */
	public static AnzNewCustomerAccountTransactionsModel anzNewCustomerDtoToEntity(
			AnzNewCustomerAccountTransactionsDTO anzNewCustomerAccountTransactionsDTO) {
		return new AnzNewCustomerAccountTransactionsModel()
				.setAccountNumber(anzNewCustomerAccountTransactionsDTO.getAccountNumber())
				.setAccountName(anzNewCustomerAccountTransactionsDTO.getAccountName())
				.setValueDate(anzNewCustomerAccountTransactionsDTO.getValueDate())
				.setCurrency(anzNewCustomerAccountTransactionsDTO.getCurrency())
				.setDebitAmount(anzNewCustomerAccountTransactionsDTO.getDebitAmount())
				.setCreditAmount(anzNewCustomerAccountTransactionsDTO.getCreditAmount())
				.setDebitOrCredit(anzNewCustomerAccountTransactionsDTO.getDebitOrCredit())
				.setTransactionNarative(anzNewCustomerAccountTransactionsDTO.getTransactionNarative());
	}
}
