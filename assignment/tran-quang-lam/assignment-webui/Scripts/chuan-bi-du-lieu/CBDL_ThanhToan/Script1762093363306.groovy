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
import keyword.HelperKeywords

import org.openqa.selenium.Keys as Keys

'Click nút Cart'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aViewCart'))

'Trang giỏ hàng được hiển thị'
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtShoppingCart'), 'Shopping Cart')

'Click nút Proceed To Checkout'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aProceedToCheckout'))

'Verify Địa chỉ chi tiết và Đánh giá đơn hàng của bạn '
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtAddressDetails'), "Address Details")
HelperKeywords.verifyTextEqual(findTestObject('dat-hang-va-thanh-toan/txtReviewYourOrder'), "Review Your Order")

'Nhập miêu tả trong textarea comment'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/textareaComment'), comment)

'Click nút place order'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/aPlaceOrder'))

'Nhập Name on card'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/iptNameOnCard'), nameOnCard)

'Nhập Card Number'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/iptCardNumber'), cardNumber)

'Nhập CVC'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/iptCvc'), cvc)

'Nhập expiration date months'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/iptExpiryMonth'), expiryMonth)

'Nhập expiration date years'
WebUI.setText(findTestObject('dat-hang-va-thanh-toan/iptExpiryYear'), expiryYear)

'Click nút Pay and Confirm Order'
WebUI.click(findTestObject('dat-hang-va-thanh-toan/btnPayAndConfirmOrder'))