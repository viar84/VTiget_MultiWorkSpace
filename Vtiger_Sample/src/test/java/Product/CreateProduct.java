package Product;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utilities.ExcelUtility;
import Generic_Utilities.FileUtility;
import Generic_Utilities.JavaUtility;
import Generic_Utilities.WebDriverUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable
	{
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
		String proName = eLib.getDataFromExcelFile("Product", 0,0)+rno;
		driver.get(url);
		wLib.waitForElementToLoad(driver);
		login.loginToApp(userName, password);
		
		home.clickProdLink();
		CreateProductPage prodPage = new CreateProductPage(driver);
		prodPage.clickCreateProduct();
		prodPage.addProduct(proName);
		 
		Thread.sleep(2000);
	
		home.mouseHoverSignOut(driver);
		Thread.sleep(2000);
		home.ClickSignOut();
	}

}
