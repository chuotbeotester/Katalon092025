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
import internal.GlobalVariable
import keyword.DangKy
import keyword.DeleteAccount
import keyword.HelperKeywords
import keyword.ThemSanPhamVaoGioHang

import org.openqa.selenium.Keys as Keys

'Click nút Signup/Login'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/btnSignupLogin'))

//Điền tất cả thông tin trong signup và tạo mới tài khoản
WebUI.callTestCase(findTestCase('chuan-bi-du-lieu/CBDL_DangKyTaiKhoan'), [('name') : name, ('email') : email, ('password') : password
        , ('days') : days, ('months') : months, ('years') : years, ('firstName') : firstName, ('lastName') : lastName, ('company') : company, ('address1') : address1
        , ('address2') : address2, ('country') : country, ('state') : state, ('city') : city, ('zipcode') : zipcode, ('mobileNumber') : mobileNumber])


'Thêm sản phẩm vào giỏ hàng'
ThemSanPhamVaoGioHang.addProductToCart(product)

'Click nút Cart'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aViewCart'))

'Trang giỏ hàng được hiển thị'
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtShoppingCart'), 'Shopping Cart')

'Click nút Proceed To Checkout'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aProceedToCheckout'))

'Kiểm tra địa chỉ giao hàng giống địa chỉ được điền ở trong đăng ký tài khoản'
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtAddress1Delivery'), address1)
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtAddress2Delivery'), address2)

'Kiểm tra địa chỉ trong hóa đơn giống địa chỉ được điền ở trong đăng ký tài khoản'
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtAddress1Billing'), address1)
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtAddress2Billing'), address2)

'Delete account'
DeleteAccount.accountDelete()