package LoxodoWebsite.Loxodo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.ReceiveTask.ReceiveTask;

public class LoxodoLogin extends BaseClass {
	@Test()
	public void inboundRequest()
//	public void inboundRequest((HashMap<String, String> input)

			throws IOException, InterruptedException {
		{

			InboundPage inbound = loginPage.loginTOApplication("soundcore","bhupendra@soundcore.com","bhupendra");
//						InboundPage inbound = loginPage.loginTOApplication(input.get("tenant"), input.get("username"), input.get("password"));

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
			inboundRequest.sortByDateCreated();
			inboundRequest.releaseInboundRequest();
			inboundRequest.clickOnZoneSelection();
			inboundRequest.chooseZone();
			inboundRequest.generateReceiveTask();
			inboundRequest.clickOnStartReceiving();
			driver.quit();
			
		}

	}

	@Test(dependsOnMethods= {"inboundRequest"})
	public void receiveTaskProcess() throws InterruptedException, IOException {
		gotoWebsite();
		InboundPage inbound = loginPage.loginTOApplication("soundcore","bhupendra@soundcore.com","bhupendra");

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
	}

	@Test(dataProvider = "getLoginDetails")
	public void loginWithDifferentData(HashMap<String, String> input) throws IOException {
		gotoWebsite();
		loginPage.loginTOApplication(input.get("tenant"), input.get("username"), input.get("password"));
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getLoginDetails() throws IOException {

		List<HashMap<String, String>>data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//data//LoginDetails.json");
		return new Object[][] {{ data.get(0) },{ data.get(1) } };
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("tenant", "soundcore");
//		map.put("username", "bhupendra@soundcore.com");
//		map.put("password", "bhupendra");
	}

}
