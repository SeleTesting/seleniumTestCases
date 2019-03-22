package TestcasesWithExtReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReUse {
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;

	// Driver Initialization
	public static void InitializeDriver()
	{
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		driver=new ChromeDriver();

	}
	public static void InitializePath(String path)
	{
		report=new ExtentReports(path);	
	}
	//Launching Browser
	public static void launch(String url,String logfilename)
	{
		driver.get(url);
		driver.manage().window().maximize();
		logger=report.startTest(logfilename);
	}
	/* Name         : findElement
	 * Arguments    : loction:Location of the object
	 *                objName:Name of the object
	 * Created date : 21Mar2019
	 * Last Modified: 21Mar2019
	 * Created		:Shweta Sapare           
	 * */
	public static WebElement findElement(By location,String objName)
	{
		WebElement obj=null;
		try
		{
			obj=driver.findElement(location);
			System.out.println("pass : "+objName+" found on page");
			logger.log(LogStatus.PASS," "+objName+"found on page  ");
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("fail : "+objName+" could not found on page");
			logger.log(LogStatus.FAIL," "+objName+ "could not find on page  ");
			
		}
		return obj;
	}

	public static void login() throws IOException
	{
		String path=("/Users/nchillal/Documents/Book2.xls");
		String[][] recData=readExceldata(path,"Sheet3");
		for(int i=0;i<recData.length;i++)
		{
			for(int j=0;j<recData[0].length;j++)
			{		
		WebElement un=findElement(By.xpath("//*[@id='username']"),"User Name");
		enterText(un,"userName",recData[i][j]);
		WebElement pass=findElement(By.xpath("//*[@id='password']"),"Pass Word");
		enterText(pass,"PassWrod",recData[i][j+1]);
		WebElement rem=findElement(By.xpath("//*[@id='rememberUn']"),"Remember Me");
		selectCheckBox(rem,"RememberMe");
		WebElement lgn=findElement(By.xpath("//input[@value='Log In']"),"Login");
		clickButton(lgn,"Login");
		j++;
			}
		}
	}
	/* Name         : enterText
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void enterText(WebElement obj,String objName,String textvalue)
	{
		if(obj==null)
			return;
		if(obj.isDisplayed())
		{
			obj.sendKeys(textvalue);
			System.out.println("pass : "+textvalue+" enter in "+objName);
			logger.log(LogStatus.PASS,"entered succesfully  "+textvalue);
		}
		else
		{
			System.out.println("Fail : "+objName+" could not be bound ");	
			logger.log(LogStatus.FAIL,"Incorrect  "+textvalue);
		}
	}
	//Wait time
	public static void Wait()
	{
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	/*Title :select checkBox
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void selectCheckBox(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				if(!obj.isSelected())
				{
					obj.click();
				}
				System.out.println("Pass : checkbox "+objName+" selected ");
				logger.log(LogStatus.PASS," "+objName+ "selected ");
			}}
		catch(org.openqa.selenium.NoSuchElementException e)

		{
			System.out.println("Fail "+objName+" Could not be found ");
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
		}
	}
	public static void selectOptionButton(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				if(!obj.isSelected())
				{
					obj.click();
				}
				System.out.println("Pass : Option button "+objName+" selected ");
				logger.log(LogStatus.PASS," "+objName+ "selected ");
			}
		}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Fail "+objName+" Could not be found ");
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
		}
	}
	/* Name         : clickButton
	 * Arguments    : obj:Name of the WebElement
	 *                objName:Name of the object(user defined)
	 *                textvale:Text to be entered
	 * Last Modified: 21Mar2019           
	 * */
	public static void clickButton(WebElement obj,String objName)
	{
		if(obj==null)
			return;
		try {
			if(obj.isDisplayed())
			{
				obj.click();
				System.out.println("Pass : "+objName+" click ");
				logger.log(LogStatus.PASS," "+objName+"  click ");
			}}
		catch(org.openqa.selenium.NoSuchElementException e)
		{
			System.out.println("Fail "+objName+"Could not be found");	
			logger.log(LogStatus.FAIL," "+objName+" Could not be found");
			
		
		}
	}
	
	public static void end(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL,result.getThrowable());
		}
	}
	//ending report
	public static void EndReport()
	{
		report.endTest(logger);
		report.flush();
		System.out.println("end report");
		driver.quit();
	}
	//Reading data from Excel file
	public static String[][] readExceldata(String dataTablepath,String sheetname) throws IOException
	{
		File xlFile=new File(dataTablepath);
		FileInputStream xldoc=new FileInputStream(xlFile);
		HSSFWorkbook wb=new HSSFWorkbook(xldoc);
		HSSFSheet sheet=wb.getSheet(sheetname);
		int iRowcount=sheet.getLastRowNum()+1;
		int iColcount=sheet.getRow(0).getLastCellNum();
		String[][]xldata=new String[iRowcount][iColcount];
		for(int i=0;i<iRowcount;i++)
		{
			for(int j=0;j<iColcount;j++)
			{
				xldata[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return xldata;
	}
	public static void End()
	{
		driver.close();
	}
}
