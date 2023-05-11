package LoxodoWebsite.Loxodo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.cucumber.java.hu.De;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import LoxodoWebsite.AbstractComponent.Retry;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import LoxodoWebsite.PageObject.ReceiveTask.ReceiveTask;




public class LoxodoLogin extends BaseClass {
	@Test()
	public void inboundRequest()
//	public void inboundRequest((HashMap<String, String> input)

			throws IOException, InterruptedException {

		{
			InboundPage inbound = loginPage.loginTOApplication("soundcore", "bhupendra@soundcore.com", "bhupendra");

			InboundRequestPage inboundRequest = inbound.openInboundPage();
			inboundRequest.openInboundRequestPage();
			inboundRequest.clickOnInboundRequestAdd();
			inboundRequest.sendExtid("inboundExtid-");
			inboundRequest.sendPoid("inboundPoid-");
			inboundRequest.clickOnStartDateSelection();
			inboundRequest.selectTodayFromSelection();
			inboundRequest.clickOnEndDateSelection();
			inboundRequest.selectTodayFromSelection();
			inboundRequest.clickOnNextButton();
			inboundRequest.getShippingCompanyName();
			inboundRequest.getSupplierCompanyName();
			inboundRequest.getShippingEmail();
			inboundRequest.getSupplierEmail();
			inboundRequest.clickOnNextButton();
			inboundRequest.clickOnLineAddButton(1);
			inboundRequest.itemEnter("Regular");
			inboundRequest.addItemsOnRequest();
			inboundRequest.updateQty("100");
			inboundRequest.saveInboundRequest();
//			inboundRequest.verifyRequestAddition();
			inboundRequest.sortByDateCreated();
			inboundRequest.releaseInboundRequest();
			inboundRequest.clickOnZoneSelection();
			inboundRequest.chooseZone();
			inboundRequest.generateReceiveTask();
			inboundRequest.clickOnStartReceiving();

		}

	}

	@Test(dependsOnMethods = { "inboundRequest" },retryAnalyzer=Retry.class)
	public void receiveTaskProcess() throws InterruptedException, IOException {

		gotoWebsite();
		InboundPage inbound = loginPage.loginTOApplication("soundcore", "bhupendra@soundcore.com", "bhupendra");

//		InboundPage inbound = new InboundPage(driver);
		inbound.openInboundPage();
		ReceiveTask receiveTask = new ReceiveTask(driver);
		receiveTask.clickOnReceiveTask();
		receiveTask.selectLatestReceiveTask();
		receiveTask.startReceiveTaskProcess();
		receiveTask.sendBinLocation();
		receiveTask.scanLineItems();
		receiveTask.addLineItem();
		receiveTask.confirmScannedLineItems();
		receiveTask.clickOkOnConfirmationHeaderOkButton();
		receiveTask.clickOnReceiveTaskDoneButton();
		receiveTask.receiveTaskComplete();
	}

	@Test(dataProvider = "getLoginDetails")
	public void loginWithDifferentData(HashMap<String, String> input) throws IOException {
		gotoWebsite();
		loginPage.loginTOApplication(input.get("tenant"), input.get("username"), input.get("password"));
//		loginPage.getDashboard();
	}

	@DataProvider
	public Object[][] getLoginDetails() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//data//LoginDetails.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("tenant", "soundcore");
//		map.put("username", "bhupendra@soundcore.com");
//		map.put("password", "bhupendra");
	}

	@Test
	public void printDataFromExcelFile() throws IOException {
		ArrayList alist=getExcelData("Develop");
		int size= alist.size();
		for(int i=0;i<size;i++){
			System.out.println(alist.get(i));

		}
	}
	@Test
	public void seleniumGrid() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.136:4444"),capabilities);
		driver.get("https://automationteststore.com/");
		System.out.println(driver.getTitle());
	}


}
