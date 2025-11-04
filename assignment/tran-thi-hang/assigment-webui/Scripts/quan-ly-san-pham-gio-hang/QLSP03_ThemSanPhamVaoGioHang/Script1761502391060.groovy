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
import org.openqa.selenium.WebElement

'Click on Products button'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnProduct'))

'nhấn Add to cart vào sản phẩm đầu tiên'
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 3)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

'Click Continue Shopping button'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnContinueShopping'))

'nhấn Add to cart sản phẩm thứ 2'
WebUI.scrollToElement(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'), 2)
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'), 10)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddSecond'))

'Click View Cart button'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnViewCart'))

'Hai sản phẩm hiển thị trong danh sách giỏ hàng'

List<WebElement> items = WebUI.findWebElements(findTestObject('quan-ly-san-pham-gio-hang/rowItemCart'), 10)
int itemCount = items.size()
assert itemCount == 2


'Kiểm tra giá cả, số lượng, tổng giá được hiển thị đúng kết quả mong đợi'

sanPham1 = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtDescription1'))
assert sanPham1.contains('Blue Top')

price1= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtPrice1'))
assert price1.contains('Rs. 500')

quality1= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtquality1'))
assert quality1.contains('1')

total1= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtCardTotal1'))
assert total1.contains('Rs. 500')

sanPham2 = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtDescription2'))
assert sanPham2.contains('Men Tshirt')

price2= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtPrice2'))
assert price2.contains('Rs. 400')

quality2= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtquality2'))
assert quality2.contains('1')

total2= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtCardTotal2'))
assert total2.contains('Rs. 400')



