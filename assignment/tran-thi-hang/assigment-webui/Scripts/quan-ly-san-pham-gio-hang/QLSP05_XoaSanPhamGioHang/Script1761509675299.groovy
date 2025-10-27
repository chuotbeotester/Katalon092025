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
WebUI.mouseOver(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 10)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

'Nhấp vào nút Giỏ hàng'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnViewCart'))

'Trang giỏ hàng được hiển thị'
cart = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtShoppingCart'))
assert cart.equals('Shopping Cart')

'Nhấp vào nút X tương ứng với sản phẩm cụ thể'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnDelete'))

'sản phẩm vừa được nhấn nút [X] đã được xóa khỏi giỏ hàng'
String cartText = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/listGioHang'))
assert !cartText.contains('Blue Top')