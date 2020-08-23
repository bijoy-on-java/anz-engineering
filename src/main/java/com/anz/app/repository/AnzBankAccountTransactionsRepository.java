package com.anz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anz.app.model.AnzNewCustomerAccountTransactionsModel;

/**
 * ANZ Engineering: Repository interface holds methods to manipulate operations on customer bank account transactions.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Repository
public interface AnzBankAccountTransactionsRepository
		extends JpaRepository<AnzNewCustomerAccountTransactionsModel, Integer> {

	/**
	 * ANZ Engineering: Method is responsible to fetch customer bank transactions details
	 * based on the user code.
	 * 
	 * @param accountNumber
	 * @return List<AnzNewCustomerAccountTransactionsModel>
	 */
	@Query(value = "select * from customer_account_transactions where account_number=?1", nativeQuery = true)
	List<AnzNewCustomerAccountTransactionsModel> anzBankingCustomerAccountTransactions(final Integer accountNumber);
}
