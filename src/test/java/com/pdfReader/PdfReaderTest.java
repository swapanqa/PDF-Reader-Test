package com.pdfReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PdfReaderTest {
	
	
	

	@Test
	public void readerPdfTest() throws IOException {
		
		

		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 + "/src/main/java/driver/chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf");
		
		//String currentUrl =driver.getCurrentUrl();
		
		//System.out.println(currentUrl);
		
		
		//URL url = new URL(currentUrl);
		 URL url = new URL("file:///C:/Users/Mamun/Downloads/Citi%20Card%20Application%20-%20Final%20Summary.pdf");
		
		InputStream is =url.openStream();
		
		BufferedInputStream pdfParse = new BufferedInputStream(is);
		
		PDDocument document = null;
		
		
		document = PDDocument.load(pdfParse);
		
		String context = new PDFTextStripper().getText(document);
		
		System.out.println(context);
		
		
		Assert.assertTrue(context.contains("SALMA AKTER"));
		//Assert.assertTrue(context.contains("Personal Information"));
		//Assert.assertTrue(context.contains("Email"));
		
	}


}
