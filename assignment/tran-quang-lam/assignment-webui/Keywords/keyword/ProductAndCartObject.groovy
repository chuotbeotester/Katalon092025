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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class ProductAndCartObject {
	/**
	 * 
	 * @param number
	 * @return
	 */
	@Keyword
	public static Map getProductAndPrice(int number) {
		List<String> lstNameProduct=[]
		List<String> lstPriceProduct=[]
		for(int i=1;i<=number;i++) {
			String txtNameProduct=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtNameProduct',[('product'):i]))
			String txtPriceProduct=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtPriceProduct',[('product'):i]))

			lstNameProduct.add(txtNameProduct)
			lstPriceProduct.add(txtPriceProduct)
		}

		return [names: lstNameProduct, prices: lstPriceProduct]
	}
	public static def addToCartAllProduct() {
		List<WebElement> lstAddToCart = WebUI.findWebElements(findTestObject('quan-ly-san-pham-va-gio-hang/btnAddToCartAll'), 10)
		for (WebElement element : lstAddToCart) {
			WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(element))
			WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnContinueShopping'))
		}
	}
}
