package gogo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import gogo.main.TestBase;

public class BookPage extends TestBase{
//find element storing title of first book
@FindBy(xpath = "//a[@class = 'a-link-normal a-text-normal']//span")
WebElement title;
//find element storing author of first book
@FindBy(xpath = "//span[text()='by ']/following-sibling::a")
WebElement author;
//find element storing booktype of first book
@FindBy(xpath = "//a[@class = 'a-size-base a-link-normal a-text-bold']")
WebElement bookType;
//find element storing price of first book
@FindBy(xpath = "//span[@class = 'a-price-whole']")
WebElement price;

public BookPage()
{   //innitaite class
	PageFactory.initElements(driver, this);
	}

public void getData()
{
	//Showing all details of first book
System.out.println("Title is " + title.getText());	
System.out.println("Author is " + author.getText());
System.out.println("BookType is " + bookType.getText());
System.out.println("Price is " + price.getText());
Assert.assertNotNull(title);
}

}
