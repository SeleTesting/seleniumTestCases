/*Launch https://www.login.salesforce.com and provide positive <username> and <password> data to SalesForce Application. 
Click on Accounts link on the home page
Select the <view name> from the view drop down list on the account page. Click on the Edit link the accounts page.
Change the <view name> to <new view name>. Select the filters field <Account name>, operator  <contains>, Value <a>.
 Select fields to display, select Last activity text from available Fields and click on Add button. Click on save button.*/




package TestcasesWithExtReport;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;
public class TC12 extends ReUse{
	public static void main(String[] args) throws InterruptedException, IOException {

	InitializeDriver();
	String path="/Users/nchillal/Documents/ShwetaWorkspace1/Reports/TC12.html";
	InitializePath(path);
	launch("https://login.salesforce.com/","TC12");
	login();
	Wait();
	WebElement acct=findElement(By.xpath("//a[contains(@title,'Accounts Tab')]"),"Account Tab");
	clickButton(acct,"Account Tab");
	WebElement selectmenu=findElement(By.name("fcf"),"Account Dropdown");
	Select select=new Select(selectmenu);
	select.selectByVisibleText("Ann");
	System.out.println("Selected name");
	logger.log(LogStatus.PASS,"Selected name");
	Wait();
	//Actions mousehoover=new Actions(driver);
	WebElement edit=findElement(By.linkText("Edit"),"Edit link");
	clickButton(edit,"Edit Link");
	WebElement fname=findElement(By.name("fname"),"view name");
	fname.clear();
	enterText(fname,"Name from dropdown","Ann1");
	Wait();
	WebElement menu=findElement(By.name("fop1"),"Account name");
	Select select1=new Select(menu);
	select1.selectByVisibleText("contains");
	WebElement value=findElement(By.id("fval1"),"Value");
	enterText(value,"Value","a");
	Thread.sleep(4000);
	WebElement field=findElement(By.id("colselector_select_0"),"Available fields");
	Select select2=new Select(field);
	select2.selectByVisibleText("Last Activity");
	Wait();
	WebElement Add=findElement(By.xpath("//a[@id='colselector_select_0_right']//img[@title='Add']"),"Add");
	clickButton(Add,"Add");
	WebElement save=findElement(By.name("save"),"save");
	clickButton(save,"Save");
	Wait();
	WebElement selectmenu1=findElement(By.xpath("//select[@title='View:']"),"");
	Select select3=new Select(selectmenu1);
	select3.selectByVisibleText("Ann1");
	End();
	EndReport();
}
}
