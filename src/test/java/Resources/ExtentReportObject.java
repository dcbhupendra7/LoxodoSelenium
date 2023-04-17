package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportObject {
	public static ExtentReports getReportObject() {
	String filePath= System.getProperty("user.dir")+"//reports/index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(filePath);
	reporter.config().setReportName("Loxodo Web Automation Report");
	reporter.config().setDocumentTitle("Test Results");
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Bhupendra");
	return extent;
}
}
