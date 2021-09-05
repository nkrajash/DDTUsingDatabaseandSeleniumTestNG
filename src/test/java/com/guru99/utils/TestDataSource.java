package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DatabaseUtils;

public class TestDataSource {

	@DataProvider()
	public Object[][] getData(){
		Object[][] data = new Object[3][2]; 
		
		data[0][0] = "mngr332061";
		data[0][1] = "bUqened";
		
		data[1][0] =  "mngr332061";
		data[1][1] = "bUqened";
		
		data[2][0] =  "mngr332061";
		data[2][1] = "bUqened";
		
		return data;
	}
	
	@DataProvider()
	public Object[][] getDataFromDatabase() throws Exception{
		Object[][] data = new Object[3][2];
		DatabaseUtils databaseUtils = new DatabaseUtils();
		
		String server = "localhost";
		int portNumber = 3306;
		String database ="Guru99TestData";
		String username = "root";
		String password = "admin@1234";
		
		databaseUtils.openConnection(server, portNumber, database, username, password);
		String sqlQuery = "select * from users;";
		data= databaseUtils.executeSqlSelectQuery(sqlQuery);
		databaseUtils.closeConnection();
		
		return data;
	}
}

/*
1.
Question 1
Which annotation is used to pass multiple set test data to a test case?

1 / 1 point

@TestSource


@DataProvider


@TestProvider


@DataSuplier

Correct
Correct! @DataProvider annotation is used to pass multiple test data to a test case

2.
Question 2
The Data-Driven testing approach lets you?

1 / 1 point

Reading from Database


Reading from Excel sheet


Test a feature or functionality with multiple sets of test data where data can be any external source like Excel or Database

Correct
Correct! Testing a feature/functionality with multiple sets of test data is data-driven testing. 

3.
Question 3
Which is a better approach to test a feature or functionality?

1 / 1 point

Writing a test script once and passing multiple test data to test combination of positive and negative scenarios


Writing multiple scripts for each set of test data

Correct
Writing a test script once and passing multiple test data to test combination of positive and negative scenarios
Correct! This approach increases reusability of the code

4.
Question 4
What is the return type of statement.executeQuery(sqlQuery) method

1 / 1 point

"DataTable"


"ResultSet" 

Correct
Correct! The return type of statement.executeQuery() method is ResultSet  

*/
