package TestcasesWithExtReport;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC17 extends ReUse{

	public static void main(String[] args) throws IOException {
		InitializeDriver();
		String path="/Users/nchillal/Documents/ShwetaWorkspace1/Reports/TC17.html";
		InitializePath(path);
		launch("https://login.salesforce.com/","TC17");
		login();
		Wait();
		WebElement op=findElement(By.xpath("//a[@title='Opportunities Tab']"),"opportunity tab");
		clickButton(op,"Opportunity Tab");
		WebElement pipe=findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"),"Opportunity pipeline");
		clickButton(pipe,"Opportunity pipeline");
		WebElement header=findElement(By.xpath("//h1[@class='noSecondHeader pageType']"),"Opportunity pipeline header image");
		System.out.println("Header present  :"+header.isDisplayed());
		End();
		EndReport();
	}

}
