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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Click vào Products'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))

'Verify điều hướng đến trang ALL PRODUCTS'
String txtAllProducts=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtAllProducts'))
assert txtAllProducts.equals('ALL PRODUCTS')

'Danh sách sản phẩm được hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/aViewProduct',[('product'):1]))

'Click vào View Product của sản phẩm đầu tiên'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewProduct',[('product'):1]))

'Người dùng được chuyển đến trang chi tiết sản phẩm'
String txtReview=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/aReviews'))
assert txtReview.equals('WRITE YOUR REVIEW')

'Product name hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtProductName'))

'Category hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtCategory'))

'Price hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtPrice'))

'Availibity hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtAvailibility'))

'Condition hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtCondition'))

'Brand hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtBrand'))