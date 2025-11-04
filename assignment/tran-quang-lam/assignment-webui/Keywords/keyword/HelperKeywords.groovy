package keyword
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
		assert actualText.replaceAll("\\s+", " ").trim().equals(txtVerify.replaceAll("\\s+", " ").trim())
	}
	/**
	 * 
	 * @param element
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextEqual(WebElement element , String txtVerify) {
		String actualText = element.getText()
		assert actualText.replaceAll("\\s+", " ").trim().equals(txtVerify.replaceAll("\\s+", " ").trim())
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
		assert actualText.replaceAll("\\s+", " ").trim().contains(txtVerify.replaceAll("\\s+", " ").trim())
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
		assert actualText.replaceAll("\\s+", " ").trim().contains(txtVerify.replaceAll("\\s+", " ").trim())
	}
	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextContainsLower(TestObject testObject , String txtVerify) {
		String actualText = WebUI.getText(testObject)
		assert actualText.trim().replaceAll("\\s+", " ").toLowerCase().contains(txtVerify.trim().replaceAll("\\s+", " ").toLowerCase())
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
	 * @param relativePath
	 * @param fileName
	 * @param timeoutSeconds
	 * @return
	 */
	public static boolean verifyFileDownloadedInProject(String relativePath, String fileName, int timeoutSeconds = 30) {

		// 1. Lấy đường dẫn thư mục gốc của dự án
		String projectDir = RunConfiguration.getProjectDir()

		// 2. Tạo đường dẫn tuyệt đối đến thư mục download
		//    Sử dụng File.separator để tương thích với cả Windows (\) và MacOS/Linux (/)
		String absoluteDownloadPath = projectDir + File.separator + relativePath.replace("/", File.separator)

		File dir = new File(absoluteDownloadPath)
		boolean found = false

		// 3. Tự động tạo thư mục nếu nó chưa tồn tại
		//    Điều này rất quan trọng để tránh lỗi khi chạy lần đầu
		if (!dir.exists()) {
			WebUI.comment("ℹ️ Thư mục download chưa tồn tại. Đang tạo tại: ${absoluteDownloadPath}")
			dir.mkdirs()
		}

		WebUI.comment("🔍 Đang chờ file '${fileName}' tại thư mục: ${absoluteDownloadPath} (tối đa ${timeoutSeconds}s)")

		// 4. Vòng lặp chờ file (logic gốc của bạn)
		for (int i = 0; i < timeoutSeconds; i++) {
			File[] dirContents = dir.listFiles()

			if (dirContents != null && dirContents.length > 0) {
				for (File file : dirContents) {
					// So sánh tên file không phân biệt hoa thường
					if (file.getName().equalsIgnoreCase(fileName)) {
						found = true
						WebUI.comment("✅ File '${fileName}' đã được tìm thấy tại: ${absoluteDownloadPath}")
						break
					}
				}
			}

			if (found) break
				Thread.sleep(1000) // Chờ 1 giây rồi kiểm tra lại
		}

		// 5. Báo cáo kết quả và Assert
		if (!found) {
			WebUI.comment("❌ Không tìm thấy file '${fileName}' trong ${absoluteDownloadPath} sau ${timeoutSeconds}s")
		}

		// Dùng verifyEqual để Test Case bị fail nếu không tìm thấy file
		WebUI.verifyEqual(found, true, FailureHandling.STOP_ON_FAILURE)
		return found
	}
	/**
	 * 
	 * @param testObject
	 * @return
	 */
	public static def verifyAllDisplay(TestObject testObject) {
		List<WebElement> lstViewAllProducts= WebUI.findWebElements(testObject, 0)
		for(WebElement element:lstViewAllProducts) {
			assert element.isDisplayed()
		}
	}
	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyTextAndVisible(TestObject testObject, String txtVerify) {
		assert WebUI.verifyElementVisible(testObject)
		String actualText = WebUI.getText(testObject)
		assert actualText.replaceAll("\\s+", " ").trim().equals(txtVerify.replaceAll("\\s+", " ").trim())
	}
	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyAllContainText(TestObject testObject, String txtVerify) {
		List<WebElement> lstNameProducts=WebUI.findWebElements(testObject, 0)
		for(WebElement element: lstNameProducts) {
			String actualText = element.getText()
			assert actualText.replaceAll("\\s+", " ").trim().contains(txtVerify.replaceAll("\\s+", " ").trim())
		}
	}
	/**
	 * 
	 * @param testObject
	 * @param txtVerify
	 * @return
	 */
	public static def verifyAllEqualText(TestObject testObject, String txtVerify) {
		List<WebElement> lstNameProducts=WebUI.findWebElements(testObject, 0)
		for(WebElement element: lstNameProducts) {
			String actualText = element.getText()
			assert actualText.replaceAll("\\s+", " ").trim().equals(txtVerify.replaceAll("\\s+", " ").trim())
		}
	}
	public static def uploadFileProjectDir(String path, TestObject testObject) {
		String projectDir=RunConfiguration.getProjectDir()
		String filePath=projectDir+path

		WebUI.uploadFile(testObject, filePath)
	}
}
