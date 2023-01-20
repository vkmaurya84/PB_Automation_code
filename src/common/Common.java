package common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import objectRepo.LoginPage;

public class Common {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Properties userData;
	public static Properties message;
	public static ImageDiff diff;
	public static LoginPage log;
	
	public static String name;
	public static String email;
	public static String mobile;

	
	public static void browserSetup() throws IOException
	{
		
//		 Browser Data 
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\common\\commonBrowserData.properties");
		prop.load(fis);
		
//		Message data
		message = new Properties();
		FileInputStream msgInput = new FileInputStream(System.getProperty("user.dir")+"\\src\\common\\ExpectedMsg.properties");
		message.load(msgInput);
		
//		User General Data
		userData = new Properties();
		FileInputStream generalData = new FileInputStream(System.getProperty("user.dir")+"\\src\\common\\UserDataFile.properties");
		userData.load(generalData);
		
		switch(prop.getProperty("browserName"))
		{
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 1);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--headless");
			
			driver = new ChromeDriver(options);
			break;
			
		case "mozilla":
			
			System.setProperty("webdriver.gecko.driver", prop.getProperty("mozillaPath"));
			
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", true);
			
			driver = new FirefoxDriver(opt);
			break;
			
		case "edge":
			
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgePath"));
			EdgeOptions edgeOptions =new EdgeOptions();
//			  edgeOptions.addArguments("headless");
			driver = new EdgeDriver(edgeOptions);
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://web.cardbyte.ai/login");
		driver.get(prop.getProperty("PBURL"));
		driver.manage().window().maximize();
	}
	
	
	public static void login() throws IOException
	{
		log = new LoginPage(driver);
		log.email(userData.getProperty("userName"));
		log.password(userData.getProperty("password"));
		log.submit();
	}
	
	public static void logout()
	{
		log.currentuser();
		log.userlogout();
	}
	
	public static void explicitWait(WebElement element)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		 w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static String currentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
	}
	
	public static String futureDate()
	{
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 2);
		dt = c.getTime();
		String futureDate = formatter.format(dt); 
//		System.out.println(futureDate);
		return futureDate;
	}
	
	
	public static void validateScreen(String imageName) throws InterruptedException, IOException
	{
		Thread.sleep(1000);

		Screenshot screenshot=new AShot().takeScreenshot(driver);
		
		
//		ImageIO.write(screenshot.getImage(),"PNG",new File(prop.getProperty("pathOld")+ imageName));		// previously take screen shot to compare new screens
		

		ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\ActualImage\\"+ imageName));

		Thread.sleep(1000);

		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\ExpectedImage\\"+ imageName));

		BufferedImage actualImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\ActualImage\\"+ imageName));

		Thread.sleep(2000);

		ImageDiffer imgDiff = new ImageDiffer();

		diff = imgDiff.makeDiff(actualImage, expectedImage);

//		BufferedImage diffImage = diff.getDiffImage();
		ImageIO.write(diff.getMarkedImage(),"PNG", new File(System.getProperty("user.dir")+"\\ComparedImage\\"+ imageName));
		
		
	}
	
	
	public static ExtentReports extentReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("ITM Automation Results");
		reporter.config().setDocumentTitle("ITM Test Results");
		
		ExtentReports  extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
	
	public static void getFailedTestCaseScreenshot(String testCaseName) throws IOException, InterruptedException
	{
//		TakesScreenshot screen = (TakesScreenshot)driver1;
		Screenshot screenshot=new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png"));

		Thread.sleep(1000);
//		File source = screen.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}
	
	
	
	public static void readDataFromFile() throws CsvValidationException, IOException
	{
		CSVReader reader = new CSVReader(new FileReader(prop.getProperty("CSV_file")));
		String[] cell;
		
		int i =0;
		
		cell=reader.readNext();
		
				name = cell[i];
				email = cell[i+1];
				mobile = cell[i+2];
				
				System.out.println(email+", "+ mobile+ ", "+ name);
				
				
	}

	
}

