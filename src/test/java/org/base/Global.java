package org.base;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.Result;
import cucumber.api.Scenario;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Global {

	public static WebDriver driver;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Logger logger;
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static File file;

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void enterData(WebElement webElement, String data) {
		webElement.sendKeys(data);
	}

	public static void clickButton(WebElement webElement) {
		webElement.click();
	}
	public static void gettext(WebElement webElement) {
		webElement.getText();
	}
	public static void clearText(WebElement webElement) {
		webElement.clear();
	}
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static Properties readPropertyFileData() {
		try {
			fileInputStream = new FileInputStream(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Global_Data.properties"));
			properties = new Properties();
			try {
				properties.load(fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	public static String readData(int rowNo, int cellNo) throws IOException {
		String name = null;
		try {
			fileInputStream = new FileInputStream(
					new File("D:/Automation/Projects/SalesIntel/src/test/resources/Excel_Data/TestData.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet("Sheet_1");
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		int type = cell.getCellType();
		if (type == 1) {
			name = cell.getStringCellValue();
		} else if (type == 0) {
			boolean cellF = DateUtil.isCellDateFormatted(cell);
			if (cellF == true) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat fr = new SimpleDateFormat("dd-MMM-yy");
				name = fr.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				name = String.valueOf(l);
			}
		}
		return name;

	}

	public static void readCompleteDataFromEXcel() throws IOException {
		try {
			fileInputStream = new FileInputStream(
					new File("D:/Automation/Projects/SalesIntel/src/test/resources/Excel_Data/TestData.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileInputStream.close();
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet("Sheet_1");
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row2 = sheet.getRow(i);
			for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
				Cell cell2 = row2.getCell(j);
				System.out.println(cell2);
			}
		}
	}

	public static Logger readLog4jData() {
		logger = Logger.getLogger(Global.class);
		try {
			PropertyConfigurator.configure(new FileInputStream(
					new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Log4j.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logger;
	}

	public static void generateJVMReport(String jsonFile) {
		Configuration configuration = new Configuration(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\CucumberReports"),
				"Salesforce Site Automation");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("OS Name", System.getProperty("os.name"));
		try {
			configuration.addClassifications("Host Name", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		builder.generateReports();

	}

	public static void generateReport(String fileLoc) {
		try {
			file = new File(fileLoc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentHtmlReporter = new ExtentHtmlReporter(fileLoc);
		extentHtmlReporter.config().setDocumentTitle("Sales force site Automation Testing");
		extentHtmlReporter.config().setReportName("Sales force site Automation Test Report");
		extentHtmlReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("Browser_Name", "Chrome");
		extentReports.setSystemInfo("OS_Name", System.getProperty("os.name"));
		try {
			extentReports.setSystemInfo("Host_Name", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void generateTestReport(Scenario scenario) throws IOException {
		String scenarioName = null;
		Result.Type status = scenario.getStatus();
		switch (status) {
		case PASSED:
			scenarioName = scenario.getName();
			test = extentReports.createTest(scenarioName.split("application")[1]);
			test.createNode(scenarioName);
			test.log(Status.PASS, scenario.getName());
			break;
		case FAILED:
			scenarioName = scenario.getName();
			test = extentReports.createTest(scenarioName.split("application")[1]);
			test.createNode(scenarioName);
			test.log(Status.FAIL, scenario.getName());
			test.fail("Failure Screenshot").log(Status.INFO, "Screenshot",
					MediaEntityBuilder.createScreenCaptureFromPath(file.getAbsolutePath()).build());
			break;
		default:
			test = extentReports.createTest(scenarioName.split("application")[1]);
			test.createNode(scenarioName);
			test.log(Status.SKIP, scenario.getName());
			break;
		}

	}

	public void tearDown() {
		extentReports.flush();
	}

	public static String ReadDatafromJson(String arg1, String arg2) throws Throwable {

		FileReader fileReader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData_Folder\\TestData.json");
		JSONParser jsonParser=new JSONParser();
		Object parse = jsonParser.parse(fileReader);

		JSONObject jsonObject=(JSONObject) parse;
		Object object = jsonObject.get(arg1);

		JSONObject jsonObject1=(JSONObject) object;

		return jsonObject1.get(arg2).toString();
	}
}
