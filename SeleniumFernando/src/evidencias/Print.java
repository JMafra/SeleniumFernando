package evidencias;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

public class Print {
	
	 WebDriver driver;
	 String pathPrint;
	 ArrayList <String>prints;
	 PDF pdf;
	
	
	
	public Print(WebDriver driver, String pathPrint) {
		this.driver=driver;
		this.pathPrint=pathPrint;
		this.prints = new ArrayList();
		
		
		
		
		
	}
	
	
	public  void capturar(String namePrint) throws IOException {
		
		 DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // Taking
																					// screenshot
		FileUtils.copyFile(scrFile, new File(pathPrint+ namePrint +"_"+dateFormat.format(date)+ ".png"));
		prints.add(pathPrint+ namePrint +"_"+dateFormat.format(date)+ ".png");
		//System.out.println(pathPrint+ namePrint +"_"+dateFormat.format(date)+ ".png");

	}
	
	public  void gerarPDF() throws IOException {
	redimensiona();
		
		 pdf= new PDF("C:/Evidencias_Selenium/PDF/Relatorio_Selenium_BETA.pdf",prints);
	}
	
public static void redimensiona() throws IOException{
		
		File folder = new File("C:/Evidencias_Selenium/Prints/");
		Thumbnails.of(folder.listFiles()).size(500, 493).outputFormat("png").toFiles(Rename.NO_CHANGE);

}
}