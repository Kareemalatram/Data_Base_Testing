import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myData {
	
	WebDriver driver = new EdgeDriver();
	
	Connection con;
	
	Statement stmt;
	
	ResultSet rs;
	
	Random rand = new Random();
	
	int randomNumberForTheEmail1 = rand.nextInt(54789);
	int randomNumberForTheEmail2 = rand.nextInt(5312);
	int randomNumberForTheEmail3 = rand.nextInt(500);
	
	int randomNumberForTheEmail = randomNumberForTheEmail1 * randomNumberForTheEmail2 - randomNumberForTheEmail3;
	
	String ExpectedTextForTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	
	String TheLogoutMessage = "You have been logged off your account. It is now safe to leave the computer.";

	
	
	String myWebSite = "https://automationteststore.com/";

	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	
	String CustomerFirstNameInDataBase;
	String CustomerLastNameInDataBase;
	String email;
	String password = "123!#P@ssw0rd";
	String CustomerCountryInDataBase;
	String address;
	String postalCode;
	String loginName;

}
