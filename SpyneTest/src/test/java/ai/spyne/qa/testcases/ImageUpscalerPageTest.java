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

public class ImageUpscalerPageTest extends TestBase {

	UploadImagePage uploadImagePage;
	ImageUpscalerPage imageUpscalerPage;
	ProcessImagePage processImagePage;

	public ImageUpscalerPageTest() throws IOException {
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
	public void ImageScalerProcessTest() throws IOException, InterruptedException {
		ProcessImagePage processImagePage = imageUpscalerPage.ImageUpscalingProcessStart();
		boolean flag = processImagePage.IsUploadsBtnDisplayed();
		Assert.assertTrue(flag, "Image Upsclaer Page - Upload button is not displayed.");

		flag = processImagePage.IsUploadsBtnEnable();
		Assert.assertTrue(flag, "Image Upsclaer Page - Upload button is not enabled.");

		flag = processImagePage.IsDownloadBtnDisplayed();
		Assert.assertTrue(flag, "Image Upsclaer Page - Download button is not displayed.");

		flag = processImagePage.IsDownloadBtnEnable();
		Assert.assertTrue(flag, "Image Upsclaer Page - Download button is not enabled.");

		flag = processImagePage.IsProcessBtnDisplayed();
		Assert.assertTrue(flag, "Image Upsclaer Page - Process button is not displayed.");

		flag = processImagePage.IsProcessBtnEnable();
		Assert.assertTrue(!flag, "Image Upsclaer Page - Process button is enabled.");

		flag = processImagePage.IsSliderBtnDisplayed();
		Assert.assertTrue(flag, "Image Upsclaer Page - Slider button is not displayed.");

		flag = processImagePage.IsSliderBtnEnable();
		Assert.assertTrue(flag, "Image Upsclaer Page - Slider button is not enabled.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
