package pagepackage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int generateRandomNo(int boundaryNumber) {
		Random rnd = new Random(); // need it first before generatRandomNo
		int generatNo = rnd.nextInt(boundaryNumber); // control number
		return generatNo;

	}

	public void selectFromDropdown(WebElement selectElement, String visibleText) {
		Select sel = new Select(selectElement); // need select class for dropdown
		sel.selectByVisibleText(visibleText); // parameterize company= whoever call it, will provide the value

	}

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
