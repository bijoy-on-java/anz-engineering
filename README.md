Project Name
-------------
ANZ Engineering Sample Project

Abstract Overview
------------------
This sample project has following implementation:
1. REST API to create new bank account(s)
   Request type: POST
   Output type: TEXT
   Request URL: http://localhost:8080/api/anz/new/account
   Input:
   {
	"accountNumber":7000,
	"accountName":"Test Account Name",
	"accountType":"Savings Account",
	"balanceDate":"2011-08-22",
	"currency":"AUD",
	"openingAvailableBalance":20040000000,
	"userCode":"BK"
   }
   Output: ANZ account: Customer account have been created successfully. And the account number is: 9000
2. REST API to support listing of account(s) of a user.
   Request type: GET
   Output type: JSON
   Request URL: http://localhost:8080/api/anz/customer/accounts?userCode=BK
   Output:
   [
    {
        "id": 3,
        "accountNumber": 7000,
        "accountName": "Test Account Name",
        "accountType": "Savings Account",
        "balanceDate": "2011-08-22T00:00:00.000+00:00",
        "currency": "AUD",
        "openingAvailableBalance": 20040000000,
        "userCode": "BK"
    }
   ]
3. REST API to create bank account(s) transactions.
   Request type: GET
   Input type: JSON
   Output type: TEXT
   Request URL: http://localhost:8080/api/anz/new/transactions
   Input:
   {
	"accountNumber": 8000,
	"accountName":"Test Account Name",
	"valueDate":"2011-08-22",
	"currency":"AUD",
	"debitAmount":12,
	"creditAmount":20040000000,
	"debitOrCredit":"Credit",
	"transactionNarative":"Test Transaction Narrative"
   }
   Output: ANZ transactions: Customer new transaction details have been created.
2. REST API to create bank account(s) transactions.
   Request type: GET
   Output type: JSON
   Request URL: http://localhost:8080/api/anz/customer/transactions?accountNumber=8000
   Output:
   {
	"accountNumber": 8000,
	"accountName":"Test Account Name",
	"valueDate":"2011-08-22",
	"currency":"AUD",
	"debitAmount":12,
	"creditAmount":20040000000,
	"debitOrCredit":"Credit",
	"transactionNarative":"Test Transaction Narrative"
   }

Prerequisites/ Installing
--------------------------
Following tools and technologies are used/required to implement, build and run this project.
1. 	Java 1.8
2. 	MySQL 5.7.26
3. 	Spring Boot 2.1.1.RELEASE
4. 	JSON
5. 	Cucumber BDD
4. 	Mockito API
5. 	Unit test using JUnit 
6. 	JUnit code coverage
7. 	Docker
8. 	Tomcat
9. 	REST API using JSON request/response
10. Eclipse IDE
11. Github repository
12. Google Chrome Postman client to test end point(s)
13. Swagger2
14. Spring Security
12. Windows 10 OS

You need to install, configure and setup above in your system.

Build / Deployment
-------------------
You can follow the steps below in order to build and run this project in your local machine.
1. Clone the project from the repository by executing following command to you local workspace by using GIT tools:
   git clone https://github.com/bijoy-on-java/banking-application-sample-project.git
2. Resolve all compilation issues in your local dev environment using Eclipse/IntelliJ IDE.
3. Run 'mvn clean package' or 'mvn clean install' or 'mvn install' from project root directory
4. Once the project successfully build run the project using 'mvn spring-boot:run'. Spring boot maven plugin allow you this to run your
   application quickly.
    
Design Specification and REST API Data flow
-------------------------------------------
AnzEngineeringController -> AnzCustomerBankAccountFacade -> AnzBankAccountServiceImpl -> AnzBankAccountRepository

AnzEngineeringController -> AnzCustomerAccountTransactionsFacade -> AnzBankAccountTransactionsServiceImpl -> AnzBankAccountTransactionsRepository

1. AnzEngineeringController.class accept(s) accepts user input and respective data set intercepted by application servlet specification. Then controller pass to Facade layer BankingApplicationFacadeImpl.class
2. Data set flow through facade layer AnzCustomerBankAccountFacade.class implementation to service later AnzBankAccountTransactionsServiceImpl.class
3. Finally AnzBankAccountTransactionsServiceImpl.class call database layer AnzBankAccountTransactionsRepository.class to read the user content for MySQL database.
4. Here database layer setup configuration can be fetched from application.properties config file.

   
Rest API end points with JSON request and response object
----------------------------------------------------------
These are the end point(s) developed for this exercise:

Please Note: Additional method(s) 'Method 1#' and 'Method 3#' created to produce data for listing need and transactional dataset. 

	Method 1# Request Type: POST
	Request URL: http://localhost:8080/banking/v1/save/accounts
	JSON Input:
	{
		"accountNumber" : 791066619,
		"accountName": "AUSavings933",
		"accountType": "Savings",
		"balanceDate": "2018-11-11T11:12:13.123",
		"currency":"AUD",
		"openingAvailableBalance": 88005.51,
		"userCode":"banking-test-user"
	}
	Response:
	Success message and HTTP status code

	Method 2# Request type: GET
	Request URL: http://localhost:8080/banking/v1/customer/accounts?userCode=banking-test-user
	JSON response:
	[
		{
			"accountNumber" : 791066619,
			"accountName": "AUSavings933",
			"accountType": "Savings",
			"balanceDate": "2018-11-11T11:12:13.123",
			"currency":"AUD",
			"openingAvailableBalance": 88005.51,
		}
	
	]


	Method 3# Request Type: POST
	Request URL: http://localhost:8080/banking/v1/save/transactions
	JSON Input:
	{
		"accountNumber" : 585439209,
		"accountName": "Current Account",
		"valueDate": "2018-11-11T11:12:13.123",
		"currency": "SGD",
		"debitAmount":124442.44,
		"creditAmount": 14322.51,
		"debitOrCredit": "Credit",
		"transactionNarative":"First  Transaction"
	}
	Response:
	Success message and HTTP status code


	Method 4# Request Type: GET
	Request URL: http://localhost:8080/banking/v1/customer/transactions?accountNumber=585439209
	JSON Response:
	[
		{
		"accountNumber" : 585439209,
		"accountName": "Current Account",
		"valueDate": "2018-11-11T11:12:13.123",
		"currency": "SGD",
		"debitAmount":124442.44,
		"creditAmount": 14322.51,
		"debitOrCredit": "Credit",
		"transactionNarative":"First  Transaction"
		}
	]

Testing through Swagger-UI:
--------------------------
Note: Please refer to "ANZ Engineering  API Screennshots.docx" for more information about REST API's covered in ANZ Engineering application.
Swagger-UI URL: http://localhost:8080/swagger-ui.html

Running test(s)[End Point Testing and Mockito/Junit with 90% code coverage]
---------------------------------------------------------------------------
Following test has to be performed to check for validation or any exception edge-case scenarios:

	1. All unit test cases have been covered by using Mockito/Junit API.
	2. You can test the application by using Google's Postman plugin client to test REST API's.
	4. The application have been built with following assumption(s):
	   a. Account number should be unique for the user., example: banking-test-user.
	   b. For creating account and transaction dataset, necessary attribute(s) information should be present in the JSON input request.

Build and Deployment
--------------------
	1 . Maven is used to build the project.
	2. Deployment have been done using Spring Boot's embeded Tomcat Apache Server.

Cucumber BDD
------------
Sample feature files have been created for demonstration purpose, considering time factor(s). These features are not automated.

Application deployment using Docker container
---------------------------------------------
In order to build and deploy this application in docker container(s). You need to create two docker container(s) so that they will communicate each other.
	
	1. Docker container for Spring Boot Application.
	2. Docker container for MySQL database.

Following sequence of step's has to be performed for this activity:
	
	1.Start the Docker
	2.Execute the command 'systemctl start docker' for your OS Terminal.
	3.Create a network for communication between these two container(s). Execute the command 
      'docker network create banking-application-network
	4.Using image provided by Dockerhub to run as a container. To achieve this execute this command 'docker container run --name banking-application-mysql-container --network banking-application-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -d mysql:8'
	5.You can verify running status of your container by executing the command docker container logs -f ae (here ae is the first two character(s) of the bytecode generated in previous step.
	6.Next change application.properties file of the Spring boot application in order to use MySQL container name. Here the 	conatiner
      name is 'banking-application-mysql-container'. Then application.properties content will look like:
      	spring.datasource.url=jdbc:mysql://localhost:3306/banking_app?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
		spring.datasource.username=root
		spring.datasource.password=root
		spring.datasource.platform=mysql
		spring.datasource.initialization-mode=always
	7.Now it's time to build your docker image. Execute 'docker image build -t banking-application .'
	   Please note 'banking-application' is the Jar name after you build your project.
	8.Final Step: Run your container in the assigned network, you can execute the command
	   docker container run --network banking-application-network --name banking-application-springboot-container 
	   -p 8080:8080 -d banking-application
	   Now you can test your end point(s) running in Docker Image.
	   
Author(s)
---------
Name: Bijoy Baral

Conclusion(s)
-------------
Hope I have made some positive contribution toward(s) this project. 

Thank you,
Bijoy
   	  

 
