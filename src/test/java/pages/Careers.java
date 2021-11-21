package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;

public class Careers extends BasePage {

	public Careers(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".well-open-positions-block .name")
	private List<WebElement> titleElements;
	
	@FindBy(css=".well-open-positions-block .location")
	private List<WebElement> locationElements;

	public Map<String, String> getJobs()
	{
		Map<String, String> map = new HashMap<String, String>();
		
		for(int elementPosition =0; elementPosition < titleElements.size(); elementPosition ++)
		{
			map.put(titleElements.get(elementPosition).getText(), locationElements.get(elementPosition).getText());	
		}
		return map;
	}
}