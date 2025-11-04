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

'Scroll xuống footer'
WebUI.scrollToElement(findTestObject('tuong-tac-ho-tro-nguoi-dung/footer'), 0)

'Verify Subscription hiển thị thành công'
HelperKeywords.verifyTextEqual(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtSubscription'), 'SUBSCRIPTION')

'Nhập email'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptEmailHome'), email)

'Click nút mũi tên'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnSubscribe'))

'Verify You have been successfully subscribed!'
HelperKeywords.verifyTextEqual(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtSuccessHome'), 'You have been successfully subscribed!')