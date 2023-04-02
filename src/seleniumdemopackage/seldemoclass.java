package seleniumdemopackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class seldemoclass {
	WebDriver driver;
	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	@BeforeSuite
	@Parameters({"browser", "url"})
	public void launchUrl(@Optional("chrome")String browser, @Optional("http://github.com")String url) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mugundhan\\Documents\\eclipse lib files\\driverfolder/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
		}}
		
	//@Parameters({"username", "password"})
	@Test(dataProvider="user")
	public void login(String username, String password) throws InterruptedException {	
		driver.manage().window().maximize();
		//System.out.println(yess);
		driver.findElement(By.cssSelector("[href=\"/login\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("login_field")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name("commit")).click();
	
}
	@DataProvider(name = "user")
	public Object[][] data(){
		Object[][] drive = new Object[3][2];
		
		drive[0][0] = "don1";
		drive[0][1] = "wer";
		
		drive[1][0] = "don2";
		drive[1][1] = "wer1";
		
		drive[2][0] = "don12";
		drive[2][1] = "sdf";
		
		return drive;
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}