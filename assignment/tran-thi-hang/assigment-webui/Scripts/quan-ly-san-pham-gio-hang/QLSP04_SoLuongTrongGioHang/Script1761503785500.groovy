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

'Nhấp vào Xem sản phẩm cho bất kỳ sản phẩm nào trên trang chủ'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnViewProductAny'))

'Chi tiết sản phẩm đã được mở'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-gio-hang/viewProductDetailAny'))

'Tăng số lượng lên 4'
WebUI.clearText(findTestObject('quan-ly-san-pham-gio-hang/btnQuanlityProduct'))
WebUI.setText(findTestObject('quan-ly-san-pham-gio-hang/btnQuanlityProduct'), productQuantity)

'Nhấp vào nút Thêm vào giỏ hàng'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddToCartDetail'))

'Nhấp vào nút Xem giỏ hàng'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnViewCart'))

'sản phẩm được hiển thị trong trang giỏ hàng với số lượng chính xác'
String quantityProduct = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtQualityProductCart'))
assert quantityProduct.equals(productQuantity)