import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import atu.testrecorder.ATUTestRecorder;
import evidencias.PDF;
import evidencias.Print;
import evidencias.Video;
import util.Constantes;

public class Test {

	static WebDriver driver;
	ATUTestRecorder recorder;

	String nomeVideo = "Video_Cenário_01_CT01";
	String nomePrint = "printTeste01";

	Video video;
	static Print print;
	

	@Before
	public void setup() throws Exception {
	
	

		System.setProperty("webdriver.chrome.driver", Constantes.PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://toolsqa.com/automation-practice-form/");
		driver.get("http://www.google.com");


		video = new Video(Constantes.CAMINHO_VIDEO, nomeVideo);
		video.inicio();
		print = new Print(driver, Constantes.CAMINHO_PRINTS);

	}

	@org.junit.Test
	public void getScrollStatus() throws Exception {
		
		print.capturar("pagina_inicial");
		
		WebElement textbox =driver.findElement(By.id("lst-ib"));
		textbox.sendKeys("Selenium");
		textbox.submit();
		
		
		
		print.capturar("pagina_inicial");
		
		WebElement textbox2 =driver.findElement(By.id("lst-ib"));
		textbox2.clear();
		textbox2.sendKeys("Appium");
		textbox2.submit();
		
		print.capturar("pagina_inicial");

		
	}

	@After
	public void Close() throws Exception {

		video.fim();
		print.gerarPDF();
		driver.quit();



	}

	public static void printWeb(String nome) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Taking
																					// screenshot
		FileUtils.copyFile(scrFile, new File("C:\\Evidencias_Selenium\\Prints\\" + nome + ".png"));

	}

}