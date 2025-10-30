package keyword
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.nio.file.*

import internal.GlobalVariable

public class HelperKeywords {
	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextEqual(TestObject testObject , String txtVerify) {
		String actualText = WebUI.getText(testObject)
		assert actualText.equals(txtVerify)
	}
	/**
	 * 
	 * @param element
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextEqual(WebElement element , String txtVerify) {
		String actualText = element.getText()
		WebUI.comment('Tên của sản phẩm:'+actualText)
		assert actualText.equals(txtVerify)
	}

	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextEqualLower(TestObject testObject , String txtVerify) {
		String actualText = WebUI.getText(testObject)
		assert actualText.trim().replaceAll("\\s+", " ").toLowerCase().equals(txtVerify.trim().replaceAll("\\s+", " ").toLowerCase())
	}

	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */


	public static def verifyTextContains(TestObject testObject , String txtVerify) {
		String actualText = WebUI.getText(testObject)
		assert actualText.contains(txtVerify)
	}


	/**
	 * 
	 * @param element
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextContains(WebElement element , String txtVerify) {
		String actualText = element.getText()
		WebUI.comment('Tên của sản phẩm:'+actualText)
		assert actualText.contains(txtVerify)
	}
	/**
	 * 
	 * @param testObject
	 * @return
	 */
	public static def clickJavascript(TestObject testObject) {
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 10)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
	}
	/**
	 * 
	 * @param downloadPath
	 * @param fileName
	 * @param timeoutSeconds
	 * @return
	 */
	public static def verifyFileDownloaded(String downloadPath, String fileName, int timeoutSeconds = 30) {
		File dir = new File(downloadPath)
		boolean found = false

		// Chờ tối đa timeoutSeconds giây cho đến khi file xuất hiện
		for (int i = 0; i < timeoutSeconds; i++) {
			File[] dirContents = dir.listFiles()
			if (dirContents != null && dirContents.length > 0) {
				for (File file : dirContents) {
					if (file.getName().equalsIgnoreCase(fileName)) {
						found = true
						WebUI.comment("✅ File '${fileName}' đã được tải thành công tại: ${downloadPath}")
						break
					}
				}
			}
			if (found) break
				Thread.sleep(1000) // chờ 1 giây rồi kiểm tra lại
		}

		// Nếu hết thời gian mà vẫn chưa thấy file
		if (!found) {
			WebUI.comment("❌ Không tìm thấy file '${fileName}' trong ${downloadPath} sau ${timeoutSeconds}s")
		}

		WebUI.verifyEqual(found, true, FailureHandling.STOP_ON_FAILURE)
		return found
	}
}
