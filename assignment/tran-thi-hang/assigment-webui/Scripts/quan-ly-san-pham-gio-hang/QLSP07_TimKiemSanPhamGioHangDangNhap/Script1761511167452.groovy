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

'Verify điều hướng đến trang ALL PRODUCTS  thành công'
allProduct = WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtAllProducts'))
assert allProduct.equalsIgnoreCase('All Products')

'Nhập tên sản phẩm vào ô tìm kiếm'
WebUI.setText(findTestObject('quan-ly-san-pham-gio-hang/iptSearch'), searchSanPham)

'nhấn nút tìm kiếm'
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnSearch'))

'SEARCHED PRODUCTS  được hiển thị'
String searchTitle = WebUI.getText(findTestObject('quan-ly-san-pham-gio-hang/txtSearchProduct'))
assert searchTitle.equalsIgnoreCase('SEARCHED PRODUCTS')

'Tất cả các sản phẩm liên quan đến tìm kiếm đều hiển thị'
CustomKeywords.'test.SearchProduct.verifyProductsContainKeyword'(searchSanPham)


'Thêm các sản phẩm tìm được vào giỏ hàng'
CustomKeywords.'test.SearchProduct.addButtonCartAll'()


'Nhấn nút ‘Cart’'
WebUI.click(findTestObject('dat-hang-thanh-toan/btnCart'))

'Các sản phẩm đều được thêm vào giỏ hàng'
CustomKeywords.'test.SearchProduct.listViewCart'(searchSanPham)
//List<WebElement> cartItems = WebUI.findWebElements(findTestObject('quan-ly-san-pham-gio-hang/ListViewCart'), 10)
//
//for (WebElement item : cartItems)  {
//	String txtCartDescription = item.getText()
//	assert txtCartDescription.contains(searchSanPham)
//}

'Click Signup Login button'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnSignUpLogin'))

'Nhập email'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmailDangNhap'), email)

'Nhập password'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPasswordDangNhap'), password)

'Click button Login'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))

'Đi đến trang giỏ hàng'
WebUI.click(findTestObject('dat-hang-thanh-toan/btnCart'))

'Tất cả sản phẩm được hiển thị sau khi đăng nhập'
CustomKeywords.'test.SearchProduct.listViewCart'(searchSanPham)
