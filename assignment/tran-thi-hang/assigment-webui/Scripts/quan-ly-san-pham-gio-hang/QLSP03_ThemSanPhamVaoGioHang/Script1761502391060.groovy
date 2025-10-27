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

'2. Click on Products button'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnProduct'))

'Di chuột lên sản phẩm đầu tiên'
WebUI.mouseOver(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

'nhấn Add to cart'
WebUI.scrollToElement(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 4)
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 3)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

'Click Continue Shopping button'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnContinueShopping'))

'Di chuột lên sản phẩm thứ hai'
WebUI.mouseOver(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'))

'nhấn Add to cart'
WebUI.scrollToElement(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'), 2)
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'), 10)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'))

'Click View Cart button'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnViewCart'))

'Hai sản phẩm hiển thị trong danh sách giỏ hàng'
sanPham1= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/SanPhamBlueTop'))
assert sanPham1.contains('Blue Top')

sanPham2= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/sanPhamMenShip'))
assert sanPham2.contains('Men Tshirt')
