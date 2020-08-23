package com.anz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anz.app.model.AnzNewCustomerAccountModel;

/**
 * ANZ Engineering: Repository interface holds methods to manipulate operations
 * on customer bank accounts.
 * 
 * @author Bijoy Baral
 * @since Saturday, August 22, 2020 10:00 am
 *
 */
@Repository
public interface AnzBankAccountRepository extends JpaRepository<AnzNewCustomerAccountModel, String> {

	/**
	 * ANZ Engineering: Method is responsible to fetch customer bank details
	 * based on the user code.
	 * 
	 * @param userCode
	 * @return List<AnzNewCustomerAccountModel>
	 */
	@Query(value = "select * from customer_accounts where user_code = ?1", nativeQuery = true)
	public List<AnzNewCustomerAccountModel> anzBankingCustomerAccountDetails(final String userCode);
}
