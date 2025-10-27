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

' Verify Login to your account được hiển thị'
textLoginAccount = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-nhap/txtLoginAccount'))
assert textLoginAccount.equals('Login to your account')

'Nhập email'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmailDangNhap'), email)

'Nhập password'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPasswordDangNhap'), password)

'Click button Login'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))

'Verify hien thi hiển thị “Logged in as username'
actualTextName = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtLoginUserName'))
assert actualTextName.equals('Logged in as ' + name)

'Click button Log Out'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogOut'))

'Verify Login to your account được hiển thị'
textLoginAccount = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-nhap/txtLoginAccount'))
assert textLoginAccount.equals('Login to your account')