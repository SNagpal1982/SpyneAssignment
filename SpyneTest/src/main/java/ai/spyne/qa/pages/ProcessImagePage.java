package ai.spyne.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.spyne.qa.base.TestBase;
import ai.spyne.qa.util.TestUtil;

public class ProcessImagePage extends TestBase {

	@FindBy(xpath = "//label[contains(@class,'w-full h-full flex gap-1 items-center cursor-pointer')]")
	WebElement processImagePageUploadBtn;

	@FindBy(xpath = "//button[contains(@class,'px-3 bg-blue-8 border border-1 border-blue rounded-lg text-blue text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs')]")
	WebElement processImagePageDownloadBtn;

	@FindBy(xpath = "//button[contains(@class,'px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50 px-10 blue-btn text-center hidden md:inline-flex items-center xl:text-sm lg:text-xs disabled:opacity-50')]")
	WebElement processImagePageProcessBtn;

	@FindBy(xpath = "//div[@class='__rcs-handle-button']")
	WebElement processImagePageSliderBtn;

	TestUtil testUtil;

	public ProcessImagePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean IsUploadsBtnEnable() {
		return processImagePageUploadBtn.isEnabled();

	}

	public boolean IsUploadsBtnDisplayed() {
		return processImagePageUploadBtn.isDisplayed();

	}

	public boolean IsDownloadBtnEnable() {
		return processImagePageDownloadBtn.isEnabled();

	}

	public boolean IsDownloadBtnDisplayed() {
		return processImagePageDownloadBtn.isDisplayed();

	}

	public boolean IsProcessBtnEnable() {
		return processImagePageProcessBtn.isEnabled();
	}

	public boolean IsProcessBtnDisplayed() {
		return processImagePageProcessBtn.isDisplayed();
	}

	public boolean IsSliderBtnEnable() {
		return processImagePageSliderBtn.isEnabled();
	}

	public boolean IsSliderBtnDisplayed() {
		return processImagePageSliderBtn.isDisplayed();
	}

	public boolean validateDownloadedFile(String fileName) throws IOException {
		processImagePageDownloadBtn.click();
		testUtil = new TestUtil();
		return testUtil.FileToBeDownloaded(fileName);
	}

}
