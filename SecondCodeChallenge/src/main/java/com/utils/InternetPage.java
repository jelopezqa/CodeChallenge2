package com.utils;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternetPage extends Wrappers {

	public InternetPage(WebDriver driver) {
		super(driver);
	}
	
	String url="http://the-internet.herokuapp.com";
	//Add/Removing button
	By addRemoveLink = By.xpath("//a[text()='Add/Remove Elements']");
	By deleteButton = By.xpath("//button[text()='Delete']");
	By addElementButton = By.xpath("//button[text()='Add Element']");
	By elementsList = By.xpath("//*[@id='elements']/button");
	//ContextMenu
	By contextMenuLink = By.xpath("//a[text()='Context Menu']");
	By hotSpotBox = By.id("hot-spot");
	//Floating Menu
	By floatingMenuLink = By.xpath("//a[text()='Floating Menu']");
	By homeButton = By.xpath("//a[text()='Home']");
	By newsButton = By.xpath("//a[text()='News']");
	By contactButton = By.xpath("//a[text()='Contact']");
	By aboutButton = By.xpath("//a[text()='About']");
	
	//Form Authentication
	By formAutheticationLink = By.xpath("//a[text()='Form Authentication']");
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.xpath("//button[@type='submit']");
	By logoutButton = By.xpath("//i[text()=' Logout']");
	By successMessage = By.id("flash");
	By failMessage = By.id("flash");
	//MultipleWindows
	By multipleWinLink = By.xpath("//a[text()='Multiple Windows']");
	By clickHereLink = By.xpath("//a[text()='Click Here']");
	By messageWindow = By.xpath("//div[@class='example']/h3");
	//HorizontalSlide
	By horizontalSlideLink = By.xpath("//a[text()='Horizontal Slider']");
	By slider = By.xpath("//div[@class='sliderContainer']/input");
	By slidePercentage = By.id("range");
	
	
	
	public void openingLinks(By locator) {
		if(isDisplayed(locator)) {
			click(locator);
		}else {
			moveTo(locator);
			click(locator);
		}
	}
	
	public void backPageButton() {
		driver.get(url);
	}
	
	public int addRemovingButton() {
		openingLinks(addRemoveLink);
		for(int i=1;i<10;i++) {
			click(addElementButton);
		}
		List<WebElement> getElements = findElements(elementsList);
		int count = getElements.size();
		for(WebElement e : getElements) {
			click(deleteButton);
		}
		backPageButton();
		return count;
	}
	
	public String checkingContextMenu() throws AWTException {
		openingLinks(contextMenuLink);
		String message = rightClick(hotSpotBox);
		backPageButton();
		return message;
	}
	
	public void clickingFloatingMenu() {
		openingLinks(floatingMenuLink);
	}
	
	public String getCurrentUlr() {
		return driver.getCurrentUrl();
	}
	
	public String clickingFloatingMenuButtons(int value) {
		String url = null;
		switch(value){
			case 1:
				click(homeButton);
				url = driver.getCurrentUrl();
				break;
			case 2:
				click(newsButton);
				url = driver.getCurrentUrl();
				break;
			case 3:
				click(contactButton);
				url = driver.getCurrentUrl();
				break;
			case 4:
				click(aboutButton);
				url = driver.getCurrentUrl();
				backPageButton();
				break;
		}
		return url;
		
	}
	
	public String validAuthentication() {
		openingLinks(formAutheticationLink);
		String user = "tomsmith";
		String passwrd = "SuperSecretPassword!";
		type(user, username);
		type(passwrd, password);
		click(loginButton);
		System.out.println(waitMessage(successMessage));
		String message = waitMessage(successMessage).substring(0, 30); 
		return message;
	}
	
	public String invalidAuthentication() {
		String user = "jlopez";
		String passwrd = "SuperSecretPassword!";
		click(logoutButton);
		type(user, username);
		type(passwrd, password);
		click(loginButton);
		System.out.println(waitMessage(successMessage));
		String message = waitMessage(successMessage).substring(0, 25);
		backPageButton();
		return message;
	}
	
	public int multipleWindows() {
		openingLinks(multipleWinLink);
		String parent = driver.getWindowHandle();
		for(int i=1; i<=5; i++) {
			click(clickHereLink);
			System.out.println("Message "+getText(messageWindow)+" for window number "+i);
			driver.switchTo().window(parent);
		}
		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		for(String child:allWindows) {
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		backPageButton();
		return count;
	}
	
	public String movingHorizontalSlide() {
		openingLinks(horizontalSlideLink);
		moveSlider(slider);
		System.out.println("Focus is:"+getText(slidePercentage));
		String message = getText(slidePercentage);
		backPageButton();
		return message;
	}

}
