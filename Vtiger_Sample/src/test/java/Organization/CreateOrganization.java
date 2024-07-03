package Organization;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.ExcelUtility;
import Generic_Utilities.FileUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import ObjectRepository.CreateOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		 
		int rno = jLib.getRandomNumber();
		 
		String url = fLib.getDataFromPropertyFile("url");
		String userName = fLib.getDataFromPropertyFile("username");
		String password = fLib.getDataFromPropertyFile("password");
		String orgName = eLib.getDataFromExcelFile("Organization", 0,0)+rno;
		String phone = eLib.getDataFromExcelFile("Organization", 0,1);
		String email = eLib.getDataFromExcelFile("Organization", 0,2);
		driver.get(url);
		wLib.waitForElementToLoad(driver);
		login.loginToApp(userName, password);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		home.clickOrgLink();
		createOrg.clickCreateOrg();
		createOrg.addOrg(orgName, phone, email);
		Thread.sleep(2000);
		home.mouseHoverSignOut(driver);
		Thread.sleep(2000);
		home.ClickSignOut();
	}

}
