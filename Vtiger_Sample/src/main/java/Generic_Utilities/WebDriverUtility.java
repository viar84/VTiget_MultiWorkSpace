package Generic_Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility
{
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForElementToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void mouseOverElement(WebDriver driver,WebElement elemnet) 
	{
		Actions act =  new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

}
