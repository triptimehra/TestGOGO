package amazon.testcase;
/**
* Search book with perticular text in amazon.com search 
* @author  Tripti Mehra
* @version 1.0
* @since   2019-08-21
*/
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gogo.main.TestBase;
import gogo.pages.BookPage;
import gogo.pages.HomePage;

public class TC1SearchBookTest extends TestBase{

	HomePage homepage;
	BookPage bookpage;
	
	public TC1SearchBookTest()
	{
	super();
	}
	
	@BeforeMethod
	public void setup()
	{  //Innitiate all classes
		innitialize();
		homepage = new HomePage();
		bookpage = new BookPage();
		
	}
	@Test(priority = 1)
	public void searchBook()
	{  //executing first test case to find details of first book search by given text
		homepage.selectOption();
		homepage.searchBox();
		bookpage.getData();

	}
	
	@AfterMethod
	public void aftertest()
	{
		driver.quit();
	}
	
	
}
