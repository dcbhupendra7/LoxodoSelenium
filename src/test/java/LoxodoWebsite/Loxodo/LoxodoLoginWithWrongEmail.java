package LoxodoWebsite.Loxodo;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;

public class LoxodoLoginWithWrongEmail extends BaseClass{
	@Test
	public void loginWithWrongEmail() {
		loginPage.loginTOApplication("soundcore", "b@soundcore.com", "bhupendra");
		Assert.assertEquals("The username is incorrect.", loginPage.getErrorMessage());
		
	}
	@Test
	public void loginWithWrongPassword() {
		loginPage.loginTOApplication("soundcore", "bhupendra@soundcore.com", "bhp");
		Assert.assertEquals("The password is incorrect.", loginPage.getErrorMessage());

	}
	@Test
	public void loginWithCorrectDetails() {
		loginPage.loginTOApplication("soundcore", "bhupendra@soundcore.com", "bhupendra");
		

	}

}
