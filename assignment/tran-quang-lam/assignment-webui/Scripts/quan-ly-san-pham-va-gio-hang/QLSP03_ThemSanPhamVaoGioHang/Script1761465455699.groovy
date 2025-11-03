import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import keyword.HelperKeywords
import keyword.ProductAndCartObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

'Click vào Products'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))

'Hover đến sản phẩm đầu tiên'
TestObject productView = findTestObject('quan-ly-san-pham-va-gio-hang/txtViewProduct', [('product') : 1])
WebUI.mouseOver(productView)

'Click Add to cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aAddToCart',[('product'):1]))

'Click nút continue shopping'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnContinueShopping'))

'Hover đến sản phẩm thứ hai'
WebUI.mouseOver(findTestObject('quan-ly-san-pham-va-gio-hang/txtViewProduct', [('product') : 2]))

'Click Add to cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aAddToCart',[('product'):2]))

//Lấy thông tin của cả 2 sản phẩm
Map<String,List<String>> productData= ProductAndCartObject.getProductAndPrice(2)
List<String> lstNameProduct = productData.names
List<String> lstPriceProduct = productData.prices

'Click nút view cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCartProducts'))

for(int i=1;i<=2;i++) {
	//Lấy giá trị từ list
	String name=lstNameProduct[i-1]
	String price=lstPriceProduct[i-1]
	
	'Verify tên sản phẩm thứ ${i}'
	HelperKeywords.verifyTextAndVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtNameCart',[('product'):i]), name)
	
	'Verify prices sản phẩm thứ ${i}'
	HelperKeywords.verifyTextAndVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtPricesCart',[('product'):i]), price)
	assert WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtPricesCart',[('product'):i]))
		
	'Verify quantity sản phẩm thứ ${i}'
	HelperKeywords.verifyTextAndVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtQuantityCart',[('product'):i]), '1')
	
	'Verify total sản phẩm thứ ${i}'
	assert WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtTotalCart',[('product'):i]))
}