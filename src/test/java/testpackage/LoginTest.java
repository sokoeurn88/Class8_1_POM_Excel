package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pagepackage.DashboardPage;
import pagepackage.LoginPage;
import utilpackage.BrowserFactory;
import utilpackage.ExcelReader;

public class LoginTest {

	// inherit, obj, by the name of the class

	WebDriver driver;

	

	@Test
	public void verifiedUserShouldBeAbleToLogin() {
		
	

		/*
		 * My self use only BrowserFactory objBF = new BrowserFactory(); objBF.init();
		 * objBF.tearDown();
		 */

		// static void init()

		driver = BrowserFactory.init(); // this driver on left and init() return driver equal to that driver.
		System.out.println(driver.getTitle());
		
//		LoginPage login = new LoginPage();
//		login.insertUserName(username); = not work in way
		
		//create constuctor ExcelReader from Utilpackage
		ExcelReader exlRead = new ExcelReader("TestData\\excel data.xlsx");		//add path from TestData folder as a String
		
		// login data
		String username = exlRead.getCellData("LoginInf", "UserName", 2);		//connect to test dat in excel
		String userpassword = exlRead.getCellData("LoginInf", "PassWord", 2);
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);	//only driver = parameter, LoginPage.Class = where it going to
		login.insertUserName(username);
		login.insertPassWord(userpassword);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		
		BrowserFactory.tearDown();
	}

}
