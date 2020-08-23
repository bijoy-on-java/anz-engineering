package com.anz.app.mapper;

import com.anz.app.dto.AnzNewCustomerAccountDTO;
import com.anz.app.model.AnzNewCustomerAccountModel;

/**
 * ANZ Engineering: ANZ customer bank account mapper is used to map new ANZ
 * customer data to corresponding entity object in database table.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 */
public class AnzBankAccountMapper {

	/**
	 * ANZ Engineering: Mapper method is responsible to convert input request to
	 * corresponding database response model object.
	 * 
	 * @param anzNewCustomerAccountDTO
	 * @return AnzNewCustomerAccountModel
	 */
	public static AnzNewCustomerAccountModel anzNewCustomerDtoToEntity(
			final AnzNewCustomerAccountDTO anzNewCustomerAccountDTO) {
		return new AnzNewCustomerAccountModel().setAccountNumber(anzNewCustomerAccountDTO.getAccountNumber())
				.setAccountName(anzNewCustomerAccountDTO.getAccountName())
				.setAccountType(anzNewCustomerAccountDTO.getAccountType())
				.setBalanceDate(anzNewCustomerAccountDTO.getBalanceDate())
				.setCurrency(anzNewCustomerAccountDTO.getCurrency())
				.setOpeningAvailableBalance(anzNewCustomerAccountDTO.getOpeningAvailableBalance())
				.setUserCode(anzNewCustomerAccountDTO.getUserCode());
	}
}
