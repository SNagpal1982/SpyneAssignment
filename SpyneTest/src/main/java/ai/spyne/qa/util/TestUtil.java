package ai.spyne.qa.util;

import java.io.File;
import java.io.IOException;

import ai.spyne.qa.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 20; //Mentioned in sec
	public static long IMPLICIT_WAIT = 10;	//Mentioned in sec
	public static String IMAGE_UPLOAD_PAGE_TITLE = "AI Image Upscaler: Upscale Your Image Quality with AI For Free";

	public static String IMAGE_UPSCALER_UPLOAD_URL = "https://www.spyne.ai/image-upscaler/upload";

	public static String IMAGE_UPSCALER_PAGE_TITLE = "td.doubleclick.net";
	public static String IMAGE_UPSCALER_PAGE_URL = "https://www.spyne.ai/image-upscaler/result";

	public static String IMAGE_FILE_PATH_PNG = "\\src\\test\\resources\\TestData\\Sandeep.png";
	public static String IMAGE_FILE_PATH_JPEG = "\\src\\test\\resources\\TestData\\Sandeep.jpeg";
	public static String IMAGE_FILE_PATH_WEBP = "\\src\\test\\resources\\TestData\\Sandeep.webp";
	public static String IMAGE_FILE_PATH_FILE_NOT_FOUND = "\\src\\test\\resources\\TestData\\abc.png";
	public static String IMAGE_FILE_PATH_INVALID_FILE_EXTENSION = "\\src\\test\\resources\\TestData\\InvalidFileExtensionName.txt";
	public static String IMAGE_FILE_PATH_FILE_NOT_FOUND_ERROR_MEESAGE = "File not found.";

	public boolean FileToBeDownloaded(String fileName) {
		File file = new File(prop.getProperty("downloadPath") + "/" + fileName);
		int attempts = 0;
		while (!file.exists() && attempts < 30) { // Wait up to 30 seconds
			try {
				Thread.sleep(1000); // Check every second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			attempts++;
		}
		return file.exists();
	}
}
