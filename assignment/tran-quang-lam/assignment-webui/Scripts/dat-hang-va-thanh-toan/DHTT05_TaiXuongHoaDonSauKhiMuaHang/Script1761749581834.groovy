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

'Thêm sản phẩm vào giỏ hàng'
ThemSanPhamVaoGioHang.addProductToCart(product)

'Click nút Cart'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aViewCart'))

'Trang giỏ hàng được hiển thị'
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtShoppingCart'), 'Shopping Cart')

'Click nút Proceed To Checkout'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aProceedToCheckout'))

'Click nút Register/Login'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aRegisterLogin'))

'Thực hiện các bước đăng ký'
DangKy.signup(name, email, password, days, months, years, firstName, lastName, company, address1, address2, country, state, city, zipcode, mobileNumber)

'Thục hiện các bước thanh toán'
ThanhToan.pay(comment,  nameOnCard,  cardNumber,  cvc,  expiryMonth, expiryYear)

'Click nút Download Invoice'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aDownloadInvoice'))

'Kiểm tra thông báo hóa đơn được tải xuống thành công'
HelperKeywords.verifyFileDownloaded("C:\\Users\\DELL\\Downloads", "invoice.txt")



'Thực hiện delete account'
DeleteAccount.accountDelete()

'Click nút Continue'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/btnContinue'))

''