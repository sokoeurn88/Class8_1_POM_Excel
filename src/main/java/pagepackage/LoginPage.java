package pagepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	//POM = not work with BY Class or storing in WebElement

	// class = method and variable = attribute or field
	// java associate = class and object
	
	//constructor form LoginPage to pass driver		//i replaced by driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;	//this.driver = global variable driver
		
	}

	

	// storing element with By Class
	By userNameField = By.xpath("/html/body/div/div/div/form/div[1]/input");
	By userPasswordField = By.xpath("/html/body/div/div/div/form/div[2]/input");
	By userLoginField = By.xpath("/html/body/div/div/div/form/div[3]/button");
	
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[1]/input") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[2]/input") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_BUTTON;
	
	//parameterize String username
	public void insertUserName(String username) {
		USERNAME_ELEMENT.sendKeys(username);
	}
	
	public void insertPassWord(String userpassword) {
		PASSWORD_ELEMENT.sendKeys(userpassword);
	}
	
	public void clickSigninButton() {
		SIGNIN_BUTTON.click();
	}
}
