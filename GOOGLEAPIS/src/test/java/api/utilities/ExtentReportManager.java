package api.utilities;

//Extent report 5.x

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener
{
	private static ThreadLocal<ExtentTest> testM = new ThreadLocal<>();
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;


	public static ExtentTest getTest()  
	{
		return testM.get();

	}

	public void onStart(ITestContext testContext)
	{		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-Report-"+timeStamp+".html";

		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//specify location of the report

		sparkReporter.config().setDocumentTitle("GoogleAPIAutomation"); // Title of report
		sparkReporter.config().setReportName("GoogleAPIAutomation"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "GoogleAPIAutomation");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Saurabh");
	}



    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getMethod().getGroups());
        testM.set(test); 
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        getTest().log(Status.FAIL, "Test Failed");
        getTest().log(Status.FAIL, result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, "Test Skipped");
        getTest().log(Status.SKIP, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();
    }

}
