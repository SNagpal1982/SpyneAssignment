package ai.spyne.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ai.spyne.qa.base.TestBase;
import ai.spyne.qa.pages.ImageUpscalerPage;
import ai.spyne.qa.pages.ProcessImagePage;
import ai.spyne.qa.pages.UploadImagePage;
import ai.spyne.qa.util.TestUtil;

public class ProcessImagePageTest extends TestBase {

	UploadImagePage uploadImagePage;
	ImageUpscalerPage imageUpscalerPage;

	public ProcessImagePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException, AWTException {
		initialization();
		uploadImagePage = new UploadImagePage();
		imageUpscalerPage = uploadImagePage
				.uploadImagePage(System.getProperty("user.dir") + TestUtil.IMAGE_FILE_PATH_JPEG);
	}

	@Test(priority = 1)
	public void ValidateDownloadedFile() throws IOException, InterruptedException {
		ProcessImagePage processImagePage = imageUpscalerPage.ImageUpscalingProcessStart();
		String fileName = TestUtil.IMAGE_FILE_PATH_JPEG;
		fileName.substring(fileName.lastIndexOf('/') + 1);
		boolean flag = processImagePage.validateDownloadedFile(fileName);
		Assert.assertTrue(flag);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
