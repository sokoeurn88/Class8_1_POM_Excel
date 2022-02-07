package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pagepackage.AddContactPage;
import pagepackage.DashboardPage;
import pagepackage.LoginPage;
import utilpackage.BrowserFactory;
import utilpackage.ExcelReader;

public class AddContactTest {

	WebDriver driver;
	
	//create constructor form ExcelReader
	ExcelReader exlRead = new ExcelReader("TestData\\excel data.xlsx");
	
	

	// Test Data
	String Full_NAME = exlRead.getCellData("AddContactInf", "FullName", 2);		//exlRead to connect with local variable Full_Name
	String COMPANY_NAME = exlRead.getCellData("AddContactInf", "CompanyName", 2);
	String EMAIL = exlRead.getCellData("AddContactInf", "Email", 2);
	String PHONE_NUMBER = exlRead.getCellData("AddContactInf", "Phone", 2);
	String ADDRESS = exlRead.getCellData("AddContactInf", "Address", 2);
	String CITY = exlRead.getCellData("AddContactInf", "City", 2);
	String STATE = exlRead.getCellData("AddContactInf", "State", 2);
	String ZIP = exlRead.getCellData("AddContactInf", "Zip", 2);
		
	String COUNTRY = exlRead.getCellData("AddContactInf", "Country", 2);
	

	@Test // very important, without it will not run
	public void validUserShouldBeAbleToAddCustomer() {

		// for new separate AddCustomerTest, first launch browser
		driver = BrowserFactory.init(); // how establish driver

		// need login second, it is called login data
		LoginPage login = PageFactory.initElements(driver, LoginPage.class); // only driver = parameter, LoginPage.Class
																				// = where it going to
		login.insertUserName("demo@techfios.com");
		login.insertPassWord("abc123");
		login.clickSigninButton();

		// need land on Dash board page
		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickAddCustomerButton();

		// need call AddContactPage
		// Mock or test data
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class); // now we pass drive in
																								// AddContactTest, we
																								// also need driver in
																								// AddContackPage by
																								// creating constructor
		addContactPage.insertFullName(Full_NAME);
		addContactPage.selectCompany(COMPANY_NAME);
		addContactPage.insertEmail(EMAIL);
		addContactPage.insertPhone(PHONE_NUMBER);
		addContactPage.insertAddress(ADDRESS);
		addContactPage.insertCity(CITY);
		addContactPage.insertState(STATE);
		addContactPage.insertZip(ZIP);
		
		addContactPage.selectCountry(COUNTRY);
		addContactPage.clickSaveButton();
		
		addContactPage.verifyProfilePage();
		
		dashboard.clickListCutomerButton();
		
//		addContactPage.verifyEnterName();
		addContactPage.verifyEnterNameAndDelete();
		

	}
	
	@AfterMethod
	public void tearDown() {
	driver.close();
	}

}
