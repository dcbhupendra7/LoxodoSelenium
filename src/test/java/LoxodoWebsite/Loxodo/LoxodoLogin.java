package LoxodoWebsite.Loxodo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	@Test
	public void inboundRequest() throws IOException, InterruptedException {
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
			inboundRequest.sortByDateCreated();
			inboundRequest.releaseInboundRequest();
			inboundRequest.clickOnZoneSelection();
			inboundRequest.chooseZone();
			inboundRequest.generateReceiveTask();
			inboundRequest.clickOnStartReceiving();
		}

	}

	// this test method is depend on inboundRequest method
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
//		driver.close();
	}

}
