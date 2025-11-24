import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcase {
	
	WebDriver driver = new EdgeDriver();
	
	Connection con;
	
	Statement stmt;
	
	ResultSet rs;

	String myWebSite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	
	String CustomerFirstNameInDataBase;
	String CustomerLastNameInDataBase;
	String Email;
	String password;
	
	@BeforeTest
	
	public void myBeforeTest() throws SQLException {
		
		driver.get(myWebSite);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root" ,"root");

	}
	
	@Test(priority = 1, enabled = true)

	public void AddNewRecord() throws SQLException {

		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city,postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (999, 'Abc Company', 'ali', 'ahmad', '962797700235', '123 Main St', 'Los Angeles',69541,'Spain', 1370, 50000.00)";

		stmt = con.createStatement();

		int rowInserted = stmt.executeUpdate(query);

	}
	
	@Test(priority = 3)

	public void ReadData() throws SQLException {

		String query = "select * from customers where customerNumber =999 ";
		stmt = con.createStatement();

		rs = stmt.executeQuery(query);

		System.out.println(rs);

		while (rs.next()) {
			int customerNumberInDataBase = rs.getInt("customerNumber");

			CustomerFirstNameInDataBase = rs.getString("contactFirstName").toString().trim();

			CustomerLastNameInDataBase = rs.getString("contactLastName").toString().trim();


			Email = CustomerFirstNameInDataBase + CustomerLastNameInDataBase + "@gmail.com";

			password = "123!#P@ssw0rd";

		}

	}
	
	@Test(priority = 2, enabled = true)

	public void updateData() throws SQLException {

		String query = "UPDATE customers SET contactLastName = 'asaad' WHERE customerNumber = 999;";

		stmt = con.createStatement();

		int rowInserted = stmt.executeUpdate(query);

	}
	
	
	@Test(priority = 4, enabled = true)

	public void deleteData() throws SQLException {

		String query = "delete from customers where customerNumber =999";

		stmt = con.createStatement();

		int rowInserted = stmt.executeUpdate(query);

	}

}
