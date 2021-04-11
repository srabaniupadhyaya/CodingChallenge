package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productsPage {
	public WebDriver driver;
	By backpack=By.xpath("//*[@class='inventory_item_name'][text()='Sauce Labs Backpack']");
	By addToCartBackPack=By.id("add-to-cart-sauce-labs-backpack");

	By removeBackPackBtn=By.name("remove-sauce-labs-backpack");
	By productsTitle=By.cssSelector("span.title");
	public WebElement getBackPackTitle()
	{
		return driver.findElement(backpack);
	}
	public WebElement getAddToCartBackPack()
	{
		return driver.findElement(addToCartBackPack);
	}
	public WebElement getRemoveBackPackBtn()
	{
		return driver.findElement(removeBackPackBtn);
	}
	public WebElement getProductTitle()
	{
		return driver.findElement(productsTitle);
	}
	public productsPage(WebDriver driver)
	{
		this.driver=driver;
	}

}
