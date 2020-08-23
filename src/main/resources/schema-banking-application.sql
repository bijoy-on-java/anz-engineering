schema-banking-application.sql


CREATE TABLE `customer_accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_number` int DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `balance_date` datetime(6) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `opening_available_balance` decimal(19,2) DEFAULT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `customer_account_transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `account_number` int DEFAULT NULL,
  `credit_amount` decimal(19,2) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `debit_amount` decimal(19,2) DEFAULT NULL,
  `debit_or_credit` varchar(255) DEFAULT NULL,
  `transaction_narative` varchar(255) DEFAULT NULL,
  `value_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
