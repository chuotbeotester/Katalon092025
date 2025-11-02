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

'Nhập đầy đủ thông tin vào form Sign Up và tạo tài khoản'
//dùng CustomKeyWord RegisterAccount
CustomKeywords.'test.RegisterAccount.fillSignupForm'(name, email)
CustomKeywords.'test.RegisterAccount.fillAccountForm'(password, day, month, year, firstname, lastname, address, selectCountry, state, city, zipcode, phonenumber)

'Verify hiển thị ACCOUNT CREATED!'
accountCreated = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtAccountCreated'))
assert accountCreated.equalsIgnoreCase('Account Created!')

'Click button Continue'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnContinue'))

'Verify hien thi hiển thị “Logged in as username" hiển thị ở góc trên'
actualTextName = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtLoginUserName'))
assert actualTextName.equals('Logged in as ' + name)

'Thêm sản phẩm vào giỏ hàng'
WebUI.waitForElementClickable(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'), 3)
WebUI.click(findTestObject('quan-ly-san-pham-gio-hang/btnAddFirst'))

'Click View Cart button'

WebUI.click(findTestObject('dat-hang-thanh-toan/btnCart'))

'Verify that cart page is displayed'
WebUI.verifyElementVisible('dat-hang-thanh-toan/pageCart')

'Click Proceed To Checkout button'
WebUI.click(findTestObject('dat-hang-thanh-toan/btn_ProccedCheckout'))


'Xác minh địa chỉ giao hàng và phần xem lại đơn hàng'
//CustomKeywords.'test.RegisterAccount.verifyDeliveryAddress'(firstname, lastname, address, city, selectCountry, phonenumber)


'Click button Delete Account'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnDeleteAccount'))

'Verify hien thi “ACCOUNT DELETED!”'
accountDeleted = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtAccountDeleted'))
assert accountDeleted.equals('ACCOUNT DELETED!')
