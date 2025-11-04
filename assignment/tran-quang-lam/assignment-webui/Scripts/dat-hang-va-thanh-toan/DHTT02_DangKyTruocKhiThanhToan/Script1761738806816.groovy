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
import keyword.ThanhToan
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

//Thực hiện các bước thanh toán
WebUI.callTestCase(findTestCase('chuan-bi-du-lieu/CBDL_ThanhToan'), [('comment') : comment, ('nameOnCard') : nameOnCard, ('cardNumber') : cardNumber
        , ('cvc') : cvc, ('expiryMonth') : expiryMonth, ('expiryYear') : expiryYear])

'Thực hiện delete account'
DeleteAccount.accountDelete()

'Click nút Continue'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/btnContinue'))