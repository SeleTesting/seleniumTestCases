package TestcasesWithExtReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC11 extends ReUse{
	public static void main(String args[]) throws InterruptedException, IOException
	{
		InitializeDriver();
		String path="/Users/nchillal/Documents/ShwetaWorkspace1/Reports/TC11.html";
		InitializePath(path);
		launch("https://login.salesforce.com/","TC11");
		login();
		Thread.sleep(4000);
		WebElement acc=findElement(By.xpath("//a[contains(@title,'Accounts Tab')]"),"Account tab");
		clickButton(acc,"Account Tab");
		WebElement createnew=findElement(By.linkText("Create New View"),"Create new");
		clickButton(createnew,"create new");
		WebElement firstname= findElement(By.name("fname"),"Firstnmae");
		enterText(firstname,"Firstnmae","Ann");
		Wait();
		WebElement click=findElement(By.name("save"),"save");
		clickButton(click,"save");
		Wait();
		WebElement selectmenu=findElement(By.xpath("//select[@title='View:']"),"Account Dropdown");
		Select select=new Select(selectmenu);
		select.selectByVisibleText("Ann");	
		logger.log(LogStatus.PASS, "Name displayed");
		System.out.println("Name is Displayed");
		End();
		EndReport();
	}
}
