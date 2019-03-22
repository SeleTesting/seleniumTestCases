package TestcasesWithExtReport;

import java.io.IOException;

/*Launch and Login 
Click on Accounts link on the home page
On the accounts page in Tools area, click on Merge Accounts link. Enter the <Account name> in the text box of merge accounts page and click Find accounts button. 
Entered <Account name> should result in atleast 2 or more account links. Select first two account links displayed in the list and click on Next button
Click on Merge button on Merge by accounts step 2 page. Click on OK button on the pop up.*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
public class TC13 extends ReUse
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
	InitializeDriver();
	String path="/Users/nchillal/Documents/ShwetaWorkspace1/Reports/TC13.html";
	InitializePath(path);
	launch("https://login.salesforce.com/","TC13");
	login();
	Wait();
	WebElement acct=findElement(By.xpath("//a[contains(@title,'Accounts Tab')]"),"Account Tab");
	clickButton(acct,"Account Tab");
	
	WebElement merge=findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"),"merge");
	clickButton(merge,"Merge Account");
	WebElement Add=findElement(By.xpath("//div[@class='pbWizardBody']//input[1]"),"Add");
	enterText(Add,"Add Account 1","ABC");
	WebElement srch=findElement(By.name("srchbutton"),"Search");
	clickButton(srch,"Search button");
	Thread.sleep(4000);
	WebElement select1=findElement(By.id("cid0"),"check0");
	selectCheckBox(select1,"check1");
	WebElement select2=findElement(By.id("cid1"),"check1");
	selectCheckBox(select2,"check2");
	Wait();
	try {
		
	if(findElement(By.id("cid2"),"check2").isDisplayed())
	{ WebElement select3=findElement(By.id("cid2"),"check2");
		if(select3.isSelected())
		{
			select3.click();
		}
	}}
	catch(Exception e)
	{
		System.out.println("Element not present");
	}
	WebElement Next=findElement(By.name("goNext"),"go next button");
	clickButton(Next,"go next button");
	Wait();
	WebElement Mergebtn=findElement(By.name("save"),"Merge button");
	clickButton(Mergebtn,"Merge button");
	Alert alert=driver.switchTo().alert();
	alert.accept();
	WebElement MergedAccount=findElement(By.xpath("//a[@href='/0011U00000K5c4H'][contains(text(),'ABC')]"),"Merged Account");
	System.out.println(" Merged   "+MergedAccount.isDisplayed());
	
	End();
	EndReport();
}
}
