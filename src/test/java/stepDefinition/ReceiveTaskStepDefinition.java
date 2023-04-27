package stepDefinition;

import BaseClass.BaseClass;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import LoxodoWebsite.PageObject.ReceiveTask.ReceiveTask;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ReceiveTaskStepDefinition extends BaseClass {
    public LoginPagePageObject loginPage;
    public InboundPage inbound;
    public ReceiveTask receiveTask;
    public InboundRequestPage inboundRequest;
    @Given("Launch the loxodo website")
    public void launch_the_loxodo_website() throws IOException {
        loginPage=gotoWebsite();
    }

    @Given("^Login with (.+) ,  (.+) and (.+)$")
    public void login_with_tenant_username_and_password(String tenant, String email, String password){
        inbound= loginPage.loginTOApplication(tenant,email,password);

    }
    @Given("open inbound request")
    public void open_inbound_request(){
        inboundRequest=  inbound.openInboundPage();

    }
    @Given("click on last receive task")
    public void click_on_last_receive_task(){
        receiveTask  = new ReceiveTask(driver);
    }
    @When("Start the task and receive confirm items")
    public void start_task_and_receive_confirm_items() throws InterruptedException {
        receiveTask.selectLatestReceiveTask();
        receiveTask.startReceiveTaskProcess();
        receiveTask.sendBinLocation();
        receiveTask.scanLineItems();
        receiveTask.addLineItem();
        receiveTask.confirmScannedLineItems();
        receiveTask.clickOkOnConfirmationHeaderOkButton();
    }
    @Then("Receive task should gets completed and done button close the task.")
    public void receive_task_should_gets_completed() throws InterruptedException {
        receiveTask.clickOnReceiveTaskDoneButton();
        receiveTask.receiveTaskComplete();
    }


}
