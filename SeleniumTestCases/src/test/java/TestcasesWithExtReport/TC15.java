/*Click on opportunities link from the main menu
Verify opportunities drop down is present*/
package TestcasesWithExtReport;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class TC15 extends ReUse{
public static void main(String[] args) throws IOException {
	InitializeDriver();
	String path="/Users/nchillal/Documents/ShwetaWorkspace1/Reports/TC15.html";
	InitializePath(path);
	launch("https://login.salesforce.com/","TC15");
	login();
	Wait();
	WebElement op=findElement(By.xpath("//a[@title='Opportunities Tab']"),"opportunity tab");
	clickButton(op,"Opportunity Tab");
	WebElement menu=findElement(By.name("fcf"),"menu");
	clickButton(menu,"menu");
	WebElement dropdown = findElement(By.xpath("//select[@title='View:']"),"View"); 
	Select select = new Select(dropdown); 
	java.util.List<WebElement> options = select.getOptions(); 
	for(WebElement item:options) 
	{ 

		System.out.println("Dropdown values are "+ item.getText());   
		logger.log(LogStatus.PASS," DropDowm List Items Are"+item.getText());
	} 
	End();
	EndReport();
}
}
