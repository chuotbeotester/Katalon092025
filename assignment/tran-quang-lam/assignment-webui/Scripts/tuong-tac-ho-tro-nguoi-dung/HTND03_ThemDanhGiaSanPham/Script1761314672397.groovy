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

'Click vào Products'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/aProducts'))

'Verify điều hướng đến trang ALL PRODUCTS'
String txtAllProducts=WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtAllProducts'))
assert txtAllProducts.equals('ALL PRODUCTS')

'Click nút View Product'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/aViewProduct',[('product'):product]))

'Verify Write Your Review'
String txtReview=WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/aReviews'))
assert txtReview.equals('WRITE YOUR REVIEW')

'Nhập name'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptNameProduct'),name)

'Nhập email'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptEmailProduct'),email)

'Nhập review'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/textareaReview'), review)

'Click submit'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnSubmitProduct'))

'Verify Thank you for your review'
String txtThankYou=WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtThankYou'))
assert txtThankYou.equals('Thank you for your review.')