package StepDefinitions;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import mail.AutoMailSent;


public class LoginSteps {

	WebDriver driver = null;

	@Before
	public void browsersetup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	//Background

	@Given("^user is on home page \"([^\"]*)\"$")
	public void user_is_on_home_page_something(String strArg1) {
		driver.get(strArg1);

	}
	//scenario1	

	@When("^Clicks on signup$")
	public void clicks_on_signup() {
		driver.findElement(By.xpath("//*[@id=\"responsive-navbar-nav\"]/div[1]/a[2]/button")).click();
	}

	@Then("^register page opened$")
	public void register_page_opened() {
		String curl,purl;
		curl="https://inexpo.netlify.app/registerone";
		//https://inexpo.netlify.app/registerone

		purl = driver.getCurrentUrl();
		//System.out.println(purl);
		if(curl.equals(purl))
		{
			System.out.println("Register page opened");

		}
		else
		{
			System.out.println("Page not found");
		}
	}

	//scenario2

	@Given("^user fullname (.+)$")
	public void user_fullname(String fullname) 
	{
		driver.findElement(By.id("name")).sendKeys(fullname);;
	}

	@And("^user email (.+)$")
	public void user_email(String emailid) {

		driver.findElement(By.id("email")).sendKeys(emailid);

	}

	@And("^user username (.+)$")
	public void user_username(String username){

		driver.findElement(By.id("username")).sendKeys(username);

	}

	@And("^user password (.+)$")
	public void user_password(String password) {

		driver.findElement(By.id("password")).sendKeys(password);

	}

	@And("^user number (.+)$")
	public void user_number(String contactnumbers) {
		driver.findElement(By.id("mobileNumber")).sendKeys(contactnumbers);;


	}
	@Then("^clicks on signup register$")
	public void clicks_on_signup_register() {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[8]/input"));
		btn.click();
		//*[@id="containerpad"]/div/div/div/div/form/div[8]/input
	}


	//****************Scenario 3 - blank fields **********************************

	@Given("^user clicks on sign up without any detail$")
	public void user_clicks_on_sign_up_without_any_detail() 
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[8]/input"));
		btn.click();
	}


	//****************Scenario 4 - full name test **********************************

	@Given("^user enters fullname with (.+)$")
	public void user_enters_fullname_with_numbers(String numorchar) 
	{
		driver.findElement(By.id("name")).sendKeys(numorchar);
	}

	@Then("^Expected error msg \"([^\"]*)\"$")
	public void expected_error_msg_something(String strArg1)
	{
		// clicking on sign up button
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[8]/input"));
		btn.click();

		// checking error msg
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		String fullerr = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[3]/small")).getText();
		System.out.println(fullerr);

		if(fullerr.equals(strArg1))
		{ 
			System.out.println("test pass");
		} 
		else 
		{
			System.out.println("check code");
		}
	}

	//******************Email test********************************


	@Given("^user enters email without@gmail (.+)$")
	public void user_enters_email_withoutgmail(String email)
	{
		driver.findElement(By.id("email")).sendKeys(email);
	}


	@Then("^Expected error emailmsg \"([^\"]*)\"$")
	public void expected_error_emailmsg_something(String strArg1) 
	{
		String emailerr = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[4]/small")).getText();

		if(emailerr.equals(strArg1))
		{ 
			System.out.println("test pass");
		} 
		else 
		{
			System.out.println("check code");
		}

	}


	//************ username test *********

	@Given("^user enters username (.+) and clicks on sign up$")
	public void user_enters_username_and_clicks_sign_up(String username)
	{
		WebElement btn;

		driver.findElement(By.id("username")).sendKeys(username);


		// clicking on sign up button
		btn = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[8]/input"));
		btn.click();

		String usererr = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[5]/small")).getText();


		if(usererr.equals("* Username must be minimum 6 to 14 characters"))
		{
			System.out.println("enter min characters: "+username);
		}
		else if(usererr.equals("* Enter a Valid Username"))
		{
			System.out.println("using entered wrong username or greater than 14 characters : "+username);
		}
	}


	//*************** password test ***********************


	@Given("^user enters (.+) and clicks on sign up$")
	public void user_enters_and_clicks_on_sign_up(String password)
	{
		String passmin,atleastone,atleastsym,atleastnum,min,sym,num,lowup;


		driver.findElement(By.id("password")).sendKeys(password);

		// clicking on sign up button
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[8]/input"));
		btn.click();


		// 

		passmin = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[6]/div/div/small[1]")).getText();//min charac

		atleastone = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[6]/div/div/small[2]")).getText(); // atleast one charac 

		atleastsym = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[6]/div/div/small[3]")).getText();

		atleastnum = driver.findElement(By.xpath("//*[@id=\"containerpad\"]/div/div/div/div/form/div[6]/div/div/small[4]")).getText();

		// expected msgs

		min="* Password length must be 8 to 15 characters";

		lowup = "* Include atleast one lowercase and uppercase letter";

		sym= "* Include atleast one symbol i.e.@,#,$,%,^, & ,-,+,= ";

		num="* Include atleast one number";

		if(passmin.equals(min))
		{
			System.out.println("min password charac entered: "+password);
		}
		else if(passmin.equals(min))
		{
			System.out.println("please enter 8 to 16 characters: "+password);
		}

		else if(atleastone.equals(lowup)&& atleastsym.equals(sym) && atleastnum.equals(num)) // if user enters all small but 8 chara
		{
			System.out.println("atleast one should be capital and include number and special charac: "+password);
		}
		else if(atleastone.equals(lowup)&& atleastsym.equals(sym) && atleastnum.equals(num) && passmin.equals(min))
		{
			System.out.println("please include upper and lower char along with symbols: "+password);
		}

		else if(atleastone.equals(lowup)&& atleastsym.equals(sym) && atleastnum.equals(num) && passmin.equals(min))
		{
			System.out.println("Atleast one num or symbol: "+password);
		}
		else
		{
			System.out.println("password satisfies the conditions: "+password);
		}

	}
	
	@After
	public void mail()
	{
		System.out.println("Sending Mail Please Wait");
		// constructor
		AutoMailSent sm = new AutoMailSent();
		
	}

}
