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

'Click on Products button'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnProduct'))

'Verify điều hướng đến trang ALL PRODUCTS  thành công'
allProduct = WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtAllProducts'))
assert allProduct.equalsIgnoreCase('All Products')

'Kiểm tra list sản phẩm được hiển thị'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-gio-hang/listSanPham'))

'Click on View Product button đầu tiên'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnViewProduct'))


'Người dùng được đưa đến trang chi tiết sản phẩm'
WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-gio-hang/viewProductDetail'))

'Chi tiết sản phẩm được hiển thị: tên sản phẩm'
productName = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtTenSanPham'))
assert productName.equals('Blue Top')

'Chi tiết sản phẩm được hiển thị Category'
category = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtCategory'))
assert category.equals('Category: Women > Tops')

'Kiểm tra Chi tiết sản phẩm được hiển thị price'
price = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtPrice'))
assert price.equals('Rs. 500')

'Chi tiết sản phẩm được hiển thị availability'
availability= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtAvailability'))
assert availability.equals('Availability: In Stock')

'Chi tiết sản phẩm được hiển thị tình trạng'
condition= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtCondition'))
assert condition.equals('Condition: New')

'Chi tiết sản phẩm được hiển thị thương hiệu'
bland= WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtBland'))
assert bland.equals('Brand: Polo')