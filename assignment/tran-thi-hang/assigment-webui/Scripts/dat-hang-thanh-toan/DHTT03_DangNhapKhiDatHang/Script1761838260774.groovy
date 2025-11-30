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



'Click Signup Login button'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnSignUpLogin'))

'Nhập email'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmailDangNhap'), email)

'Nhập password'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPasswordDangNhap'), password)

'Click button Login'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))


'Verify hien thi hiển thị “Logged in as username" hiển thị ở góc trên'
actualTextName = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtLoginUserName'))
assert actualTextName.equals('Logged in as ' + name)


'Lấy tên sản phẩm, giá của sản phẩm cần thêm vào giỏ hàng'
productPrice= WebUI.getText(findTestObject('dat-hang-thanh-toan/txtGiaSanPhamBlueTop'))
productName = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtTenSanPhamBlueTop'))

'Thêm sản phẩm vào giỏ hàng'
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 3)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

WebUI.waitForElementVisible(findTestObject('quan-ly-san-pham-gio-hang/btnContinueShopping'), 10)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnContinueShopping'))

'Click Cart button'
WebUI.click(findTestObject('dat-hang-thanh-toan/btnCart'))

'Verify that cart page is displayed'
WebUI.verifyElementVisible(findTestObject('dat-hang-thanh-toan/pageCart'))

'Click Proceed To Checkout button'
WebUI.click(findTestObject('dat-hang-thanh-toan/btn_ProccedCheckout'))


'Xác minh địa chỉ giao hàng và phần xem lại đơn hàng'
CustomKeywords.'test.AddressDetail.verifyDeliveryAddress'(firstname, lastname, address, city, selectCountry, state, zipcode, phonenumber)

//Xem lại tên sản phẩm
cartProductName = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtSanPhamCart'))
assert cartProductName.equals(productName)

'Nhập ghi chú vào ô Comment'
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptComment'),comment)

'nhấn Place Order'
WebUI.click(findTestObject('dat-hang-thanh-toan/btnPlaceHolder'))

'Enter payment details: Name on Card, Card Number, CVC, Expiration date'

'Nhập thông tin thanh toán: Tên chủ thẻ'
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptNameOnCard'), nameOnCard)

'Nhập Số thẻ'
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptCardNumber'), cardNumber)

'Nhập CVC'
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptCVC'), CVC)

'Nhập Ngày hết hạn'
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptExpirationMonth'), ExpirationMonth)
WebUI.setText(findTestObject('dat-hang-thanh-toan/iptExpirationYear'), ExpirationYear)

'Nhấn ‘Pay Confirm Order'
WebUI.click(findTestObject('dat-hang-thanh-toan/btnPayConfirmOrder'))

'Xác minh thông báo Your order has been placed successfully!'
String actualTextMessage = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtMessageOrderConfirm'))
assert actualTextMessage.contains('Congratulations! Your order has been confirmed!')

//'Click button Delete Account'
//WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnDeleteAccount'))
//
//'Verify hien thi “ACCOUNT DELETED!”'
//accountDeleted = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtAccountDeleted'))
//assert accountDeleted.equals('ACCOUNT DELETED!')