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

'Thêm sản phẩm vào giỏ hàng'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aAddToCart',[('product'):1]))
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnContinueShopping'))

'Click nút Cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCart'))

'Verify trang giỏ hàng được hiển thị'
String txtShoppingCart=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtShoppingCart'))
assert txtShoppingCart.equals('Shopping Cart')

'Click nút X tương ứng với sản phẩm cụ thể'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aCartDelete'))

'Sản phẩm được loại khỏi giỏ hàng'
txtCartEmpty=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtCartEmpty'))
assert txtCartEmpty.equals('Cart is empty!')

