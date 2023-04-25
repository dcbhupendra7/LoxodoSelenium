package stepDefinition;

import BaseClass.BaseClass;
import LoxodoWebsite.PageObject.Inbound.InboundPage;
import LoxodoWebsite.PageObject.Inbound.InboundRequestPage;
import LoxodoWebsite.PageObject.Login.LoginPagePageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class StepDefinitionImplementation extends BaseClass {

    public LoginPagePageObject loginPage;
    public InboundPage inbound;
    public InboundRequestPage inboundRequest;
    //given is like beforeclass
    @Given("Launch the loxodo website")
    //function name should be given text with underline
    public void launch_the_loxodo_website() throws IOException {
        loginPage= gotoWebsite();
    }
    //to include regular expression in given tag mention ^ at first and $ at end
    @Given("^Logged in with tenant (.+) , username (.+) and password (.+)$")
    public void logged_in_with_tenant_username_password(String tenant, String username, String password){
         inbound = loginPage.loginTOApplication(tenant, username, password);

    }


    @When("click latest request on  request and release")
    public void click_latest_request_and_release() throws InterruptedException {
        inboundRequest.sortByDateCreated();
        inboundRequest.releaseInboundRequest();
        inboundRequest.clickOnZoneSelection();
        inboundRequest.chooseZone();

    }

    @And("Click on no option to create receive task")
    public void click_on_no_to_create_receive_task(){
        inboundRequest.generateReceiveTask();
        inboundRequest.clickOnStartReceiving();
    }


    @Then("^(.+) message gets displayed$")
    public void success_message_gets_displayed(String message){
        inboundRequest.verifyRequestRelease(message);
    }
}
