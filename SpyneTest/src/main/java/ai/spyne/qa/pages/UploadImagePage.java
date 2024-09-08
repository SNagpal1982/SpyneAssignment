package ai.spyne.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.spyne.qa.base.TestBase;

public class UploadImagePage extends TestBase {

	// Object Repositories
	@FindBy(xpath = ".//button[contains(@class,'primary-btn flex gap-2 items-center mx-auto rounded-lg')]")
	WebElement uploadImageBtn;

	@FindBy(css = "p[class='blue-btn m-auto w-52 h-[45px] cursor-pointer']")
	WebElement fileInput;

//	@FindBy(xpath=".//button[contains(@class,'primary-btn flex gap-2 items-center mx-auto rounded-lg')]")
//	WebElement uploadButton;

	// Initializing the Page Objects
	public UploadImagePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Operation
	public String validateUploadImagePageTitle() {
		return driver.getTitle();
	}

	public String validateUploadImagePageUrl() {
		return driver.getCurrentUrl();
	}

	public ImageUpscalerPage uploadImagePage(String filePath) throws IOException, InterruptedException, AWTException {

		Thread.sleep(5000);
		uploadImageBtn.click();
		Thread.sleep(5000);
		Robot robot = new Robot();

		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Thread.sleep(5000);
		// Paste the file path into the file dialog
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		return new ImageUpscalerPage();
	}

	public String UploadImagePageFileNotFound(String filePath)
			throws IOException, InterruptedException, AWTException, UnsupportedFlavorException {
		Thread.sleep(5000);
		uploadImageBtn.click();
		Thread.sleep(5000);
		Robot robot = new Robot();

		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Thread.sleep(5000);
		// Paste the file path into the file dialog
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		// Copy the Error Message from the Error dialog
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(1000);

		String ErrorMessage = (String) clipboard.getData(DataFlavor.stringFlavor);
		// Press Enter to close the Error dialog
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		return ErrorMessage;

	}

	public ImageUpscalerPage validateUploadImagePage(String filePath)
			throws IOException, InterruptedException, AWTException {
		Thread.sleep(5000);
		uploadImageBtn.click();
		Thread.sleep(5000);
		Robot robot = new Robot();

		StringSelection stringSelection = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Thread.sleep(5000);
		// Paste the file path into the file dialog
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Press Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		return new ImageUpscalerPage();

	}

}