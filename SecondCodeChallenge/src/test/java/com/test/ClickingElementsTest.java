package com.test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.factory.DriverFactory;
import com.utils.InternetPage;

import junit.framework.Assert;

public class ClickingElementsTest extends DriverFactory{
	
	@Test(enabled=true)
	public void addRemoveButtonsTest() {
		InternetPage ipage = new InternetPage(driver);
		int count = ipage.addRemovingButton();
		Assert.assertEquals("Ups! You did not click the button well", count, 9);
	}
	
	@Test(enabled=true)
	public void contexMenuTest() throws AWTException {
		InternetPage ipage = new InternetPage(driver);
		String message = ipage.checkingContextMenu();
		Assert.assertEquals("Ups! Something went wrong", message, "You selected a context menu");
	}
	
	@Test(enabled=true)
	public void floatMenuTest() {
		InternetPage ipage = new InternetPage(driver);
		ipage.clickingFloatingMenu();
		for(int i=1; i<5;i++) {
			System.out.println("case "+i);
			String currentUrl = ipage.getCurrentUlr();
			System.out.println("current url "+currentUrl);
			String newUrl = ipage.clickingFloatingMenuButtons(i);
			System.out.println("new url "+newUrl);
			Assert.assertNotSame("You didn't click on any button", currentUrl, newUrl);
		}
	}
	
	@Test(enabled=true)
	public void formAuthenticationTest() {
		String message = null;
		InternetPage ipage = new InternetPage(driver);
		message= ipage.validAuthentication();
		Assert.assertEquals("Ops! Something went wrong with authentication", message, "You logged into a secure area!");
		message= ipage.invalidAuthentication();
		Assert.assertEquals("Ops! You shouldn't authenticate with invalid user", message, "Your username is invalid!");
	}
	
	@Test(enabled=true)
	public void multepleWindowsTest() {
		InternetPage ipage = new InternetPage(driver);
		int pages = ipage.multipleWindows();
		System.out.println("Pages "+pages);
		Assert.assertEquals("You did not open the expected amount of tabs", pages, 6);
	}
	
	@Test(enabled = true)
	public void horizontalSlideTest() {
		InternetPage ipage = new InternetPage(driver);
		String focus = ipage.movingHorizontalSlide();
		Assert.assertEquals("Ops! You did not drag the slider to correct value", focus, "4.5");
	}

}
