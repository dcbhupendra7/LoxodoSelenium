package LoxodoWebsite.Loxodo;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import LoxodoWebsite.AbstractComponent.AbstractComponent;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import LoxodoWebsite.PageObject.Outbound.OutboundPage;
import LoxodoWebsite.PageObject.Outbound.OutboundRequestPage;
import LoxodoWebsite.PageObject.ReceiveTask.ReceiveTask;

public class LoxodoLogin extends BaseClass {
	@Test(dataProvider = "getLoginDetails")
	public void inboundRequest(HashMap<String, String> input)
			throws IOException, InterruptedException {
		{

			InboundPage inbound = loginPage.loginTOApplication(input.get("tenant"), input.get("username"), input.get("password"));
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
		}

	}

	@Test(dependsOnMethods = { "inboundRequest" })
	public void receiveTaskProcess() throws InterruptedException {
		InboundPage inbound = new InboundPage(driver);
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

	@DataProvider
	public Object[][] getLoginDetails() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tenant", "soundcore");
		map.put("username", "bhupendra@soundcore.com");
		map.put("password", "bhupendra");
		return new Object[][] {{ map } };
	}

}
