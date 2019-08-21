package gogo.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import gogo.main.TestBase;

public class HomePage extends TestBase {
//location search dropdown
@FindBy(xpath = "//div[contains(@class,'nav-search-scope nav-sprite')]//select")
WebElement dropDown;
//Locating searchbox
@FindBy(id = "twotabsearchtextbox")
WebElement searchbox;
//location search button
@FindBy(xpath = "//div[contains(@class,'nav-search-submit nav-sprite')]/input")
WebElement selectoption;

public HomePage()
{   //innitaite class & page factory elements
	PageFactory.initElements(driver, this);
	}
public void selectOption()
{   
	//Select books from dropdown box
	driver.switchTo().defaultContent();
	searchbox.click();
	dropDown.click();
	Select select = new Select(dropDown);
	//Selecting element for book
	select.selectByValue("search-alias=stripbooks-intl-ship");
	
}
public BookPage searchBox()
{   //Typing the book name you want to search
	searchbox.sendKeys(prop.getProperty("search"));
	selectoption.click();
	return new BookPage();
	}

}
