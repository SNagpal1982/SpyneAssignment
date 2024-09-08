package ai.spyne.qa.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.spyne.qa.base.TestBase;

public class ImageUpscalerPage extends TestBase {

	// Object Repository
	@FindBy(xpath = "//img[contains(@src,'.jpeg')]")
	WebElement uploadedImageJpeg;

	@FindBy(xpath = "//img[contains(@src,'.png')]")
	WebElement uploadedImagePng;

	@FindBy(xpath = "//img[contains(@src,'.webp')]")
	WebElement uploadedImageWebp;

	@FindBy(xpath = "//p[contains(text(),'JPEG')]")
	WebElement uploadedImageFormatJpeg;

	@FindBy(xpath = "//p[contains(text(),'PNG')]")
	WebElement uploadedImageFormatPng;

	@FindBy(xpath = "//p[contains(text(),'WEBP')]")
	WebElement uploadedImageFormatWebp;

	@FindBy(xpath = "//button[contains(@class,'px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50 px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50')]")
	WebElement processImageBtn;

	// Initializing the Page Objects
	public ImageUpscalerPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Operation
	public String ImageUpscalerPageTitle() {
		return driver.getTitle();
	}

	public String ImageUpscalerPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean validateUploadedImageJpeg() {
		return uploadedImageJpeg.isDisplayed();
	}

	public boolean validateUploadedImagePng() {
		return uploadedImagePng.isDisplayed();
	}

	public boolean validateUploadedImageWebp() {
		return uploadedImageWebp.isDisplayed();
	}

	public boolean validateUploadedImageJpegFormat() {
		return uploadedImageFormatJpeg.isSelected();
	}

	public boolean validateUploadedImagePngFormat() {
		return uploadedImageFormatPng.isSelected();
	}

	public boolean validateUploadedImageWebpFormat() {
		return uploadedImageFormatWebp.isSelected();
	}

	public boolean ImageUpscalerPageProcessBtnIsEnable() throws InterruptedException {
		return processImageBtn.isEnabled();
	}

	public ProcessImagePage ImageUpscalingProcessStart() throws IOException, InterruptedException {
		Thread.sleep(10000);
		processImageBtn.click();
		Thread.sleep(10000);
		return new ProcessImagePage();
	}

}
