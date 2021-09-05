package commonLibs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {

	private Connection connection;
	
	public void openConnection(String server,int portnumber,String database, String username, String password) throws SQLException {
		String connectionString = String.format("jdbc:mysql://%s:%d/%s",server,portnumber,database);
		connection = DriverManager.getConnection(connectionString,username,password);
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public Object[][] executeSqlSelectQuery(String sqlQuery) throws SQLException {
		Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = stmt.executeQuery(sqlQuery);
		resultSet.last();
		int rowCount = resultSet.getRow();
		int columnCount = resultSet.getMetaData().getColumnCount();
		Object [][] data = new Object[rowCount][columnCount];
		for(int row=1; row<=rowCount;row++) {
			for(int cell=0;cell<=columnCount;cell++) {
				data[row-1][cell-1] =resultSet.getString(cell);
			}
		}
		
		
		/*
		 * 		
		 String connectionString = String.format("jdbc:mysql://%s:%d/%s",host,portnumber,database);
		connection = DriverManager.getConnection(connectionString,username,password);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sqlQuery)ResultSet resultSet = stmt.executeQuery(select * from empinfo where location='buffalo');
		while(rs.next()){
		   String baseUrl = "http://login.salesforce.com";
	        System.setProperty("webdriver.chrome.driver","C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get(baseUrl);   
	        driver.findElement(By.xpath("")).sendKeys(rs.getString(""));
	        driver.findElement(By.xpath("")).sendKeys(rs.getString(""));
		}


		 * 
		 * */
	
		return data;
	}
}
