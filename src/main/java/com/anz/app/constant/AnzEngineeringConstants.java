package com.anz.app.constant;

/**
 * ANZ Engineering: Interface contains Constant(s) used for ANZ Banking
 * Application.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
public interface AnzEngineeringConstants {

	/**
	 * ANZ Engineering: Interface definition to hold controller constants.
	 *
	 */
	public interface AnzCustomerAccountConstants {

		public static final String ANZ_SUCCESSFUL_MESSAGE_BANK_ACCOUNT_CREATION = "ANZ account: Customer account have been created successfully. And the account number is: ";

		public static final String ANZ_SUCCESSFUL_MESSAGE_BANKING_ACCOUNT_TRANSACTION = "ANZ transactions: Customer new transaction details have been created.";

		public static final String ANZ_ERROR_MESSAGE_UNPROCESSABLE_ENTITY = "ANZ error: Unprocessable entity, please enter valid input request data.";

		public static final String ANZ_ERROR_MESSAGE_REQUEST_PROCESSING = "ANZ error: Request processing error, please try again.";

		public static final String ANZ_ERROR_MESSAGE_BANKING_NO_CONTENT_RESPONSE = "ANZ error: No content available.";
	}

}
