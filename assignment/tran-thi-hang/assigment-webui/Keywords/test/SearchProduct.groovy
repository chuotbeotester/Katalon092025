package test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebElement
import internal.GlobalVariable

public class SearchProduct {
	@Keyword
	def verifyProductsContainKeyword(String searchSanPham) {
		searchSanPham = searchSanPham.toLowerCase().trim()

		// Lấy danh sách tất cả sản phẩm đang hiển thị
		def productElements = WebUI.findWebElements(findTestObject('quan-ly-san-pham-gio-hang/listProductSearch'), 10)

		// Duyệt từng sản phẩm và kiểm tra có chứa từ khóa tìm kiếm không
		for (def element : productElements) {
			String productName = element.getText().toLowerCase()
			assert productName.contains(searchSanPham)
		}
	}
	@Keyword
	def addButtonCartAll = {
		// Lấy tất cả nút "Add to cart" hiển thị
		List<WebElement> addButtons = WebUI.findWebElements(findTestObject('dat-hang-thanh-toan/btnAddToCardAllSearch'), 10)

		// Lặp qua từng nút và click
		for (WebElement btn : addButtons) {
			WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(btn))
			WebUI.delay(1)
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(btn))
		}
	}
}
