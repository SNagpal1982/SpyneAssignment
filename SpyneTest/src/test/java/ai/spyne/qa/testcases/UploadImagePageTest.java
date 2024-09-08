package ai.spyne.qa.testcases;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ai.spyne.qa.base.TestBase;
import ai.spyne.qa.pages.ImageUpscalerPage;
import ai.spyne.qa.pages.UploadImagePage;
import ai.spyne.qa.util.TestUtil;

public class UploadImagePageTest extends TestBase {
	UploadImagePage uploadImage;
	ImageUpscalerPage imageUpscaler;

	public UploadImagePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		uploadImage = new UploadImagePage();
	}

	@Test(priority = 1)
	public void uploadImageNavigationTest() {
		String actualTitle = uploadImage.validateUploadImagePageTitle();
		String expectedTitle = TestUtil.IMAGE_UPLOAD_PAGE_TITLE;
		Assert.assertEquals(actualTitle, expectedTitle, "Spyne Upload Image page -  Titile is not matched.");

		String actualUrl = uploadImage.validateUploadImagePageUrl();
		String expectedUrl = prop.getProperty("url");
		Assert.assertEquals(actualUrl, expectedUrl, "Spyne Upload Image page - URL is not matched.");
	}

	@Test(priority = 2)
	public void uploadImageFileNotFoundTest()
			throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		String filePath = System.getProperty("user.dir") + TestUtil.IMAGE_FILE_PATH_FILE_NOT_FOUND;
		String actualErrorMessage = uploadImage.UploadImagePageFileNotFound(filePath);
		boolean flag = actualErrorMessage.contains(TestUtil.IMAGE_FILE_PATH_FILE_NOT_FOUND_ERROR_MEESAGE);

		Assert.assertTrue(flag, "File Not Found pop-up is not found.");
	}

	@Test(priority = 3)
	public void uploadImageJpeg_Test() throws IOException, InterruptedException, AWTException {
		String filePath = System.getProperty("user.dir") + TestUtil.IMAGE_FILE_PATH_JPEG;
		ImageUpscalerPage imageUpscaler = uploadImage.uploadImagePage(filePath);
		String actualTille = imageUpscaler.ImageUpscalerPageUrl();
		String expectedTitle = TestUtil.IMAGE_UPSCALER_UPLOAD_URL;
		Assert.assertEquals(actualTille, expectedTitle);

		boolean flag = imageUpscaler.validateUploadedImageJpeg();
		Assert.assertTrue(flag);

//		flag = imageUpscaler.validateUploadedImageJpegFormat();
//		Assert.assertTrue(flag);				
	}

	@Test(priority = 4)
	public void uploadImagePng_Test() throws IOException, InterruptedException, AWTException {
		String filePath = System.getProperty("user.dir") + TestUtil.IMAGE_FILE_PATH_PNG;
		ImageUpscalerPage imageUpscaler = uploadImage.uploadImagePage(filePath);
		String actualTille = imageUpscaler.ImageUpscalerPageUrl();
		String expectedTitle = TestUtil.IMAGE_UPSCALER_UPLOAD_URL;
		Assert.assertEquals(actualTille, expectedTitle);

		boolean flag = imageUpscaler.validateUploadedImagePng();
		Assert.assertTrue(flag);

//		flag = imageUpscaler.validateUploadedImageJpegFormat();
//		Assert.assertTrue(flag);
	}

	@Test(priority = 6)
	public void uploadImageWebp_Test() throws IOException, InterruptedException, AWTException {
		String filePath = System.getProperty("user.dir") + TestUtil.IMAGE_FILE_PATH_WEBP;
		ImageUpscalerPage imageUpscaler = uploadImage.uploadImagePage(filePath);
		String actualTille = imageUpscaler.ImageUpscalerPageUrl();
		String expectedTitle = TestUtil.IMAGE_UPSCALER_UPLOAD_URL;
		Assert.assertEquals(actualTille, expectedTitle);

		boolean flag = imageUpscaler.validateUploadedImageWebp();
		Assert.assertTrue(flag);

//		flag = imageUpscaler.validateUploadedImageWebpFormat();
//		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
