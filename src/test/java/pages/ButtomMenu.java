package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;
import common.CommonMethods;

public class ButtomMenu extends BasePage {

	public ButtomMenu(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='/careers/']")
	private WebElement companyCareers;

	@FindBy(css="#onetrust-close-btn-container .onetrust-close-btn-handler")
	private WebElement closeCookiesButton;
	
	public void clickOnCareersLink()
	{
		CommonMethods.scrollToTheObject(companyCareers, driver);
		companyCareers.click();
	}
}