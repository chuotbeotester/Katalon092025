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


'Verify  New User Signup! được hiển thị'
textNewUser = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtNewSignUp'))
assert textNewUser.equals('New User Signup!')

'Nhập name'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptName'), name)

'Nhập email'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptEmail'), email)

'Click button [Sign up]'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnSignUp'))

'Verify  Name'
nameUI = WebUI.getAttribute(findTestObject('quan-ly-tai-khoan/dang-ky/txtName'), 'value')
assert nameUI.equals(name)

'Verify Email'
emailUI = WebUI.getAttribute(findTestObject('quan-ly-tai-khoan/dang-ky/txtEmail'), 'value')
assert emailUI.equals(email)

'Click chọn Tỉtle'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/radTitlle'))

'Nhập password'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptPasssword'), password)

'Chọn Day'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectDay'), day, false)

'Chọn Month'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectMonth'), month , false)

'Chọn year'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectYear'), year, false)

'Click vào checkbox New Letter'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/checkboxNewLetter'))

'Click vào checkbox Receive'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/checkboxReceive'))

'Nhập firstname'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptFirstName'), firstname)

'Nhập lastname'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptLastName'), lastname)

'Nhập adđress'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptAddress'), address)

'Chọn Country'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/iptContry'), selectCountry , false)

'Nhập state'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptState'), state)

'Nhập city'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptCity'), city)

'Nhập zipcode'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptZipCode'), zipcode)

'Nhập phone number'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptMobile'), phonenumber)

'click button [Create Account]'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnCreateAccount'))

'Verify hiển thị ACCOUNT CREATED!'
accountCreated = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtAccountCreated'))
assert accountCreated.equalsIgnoreCase('Account Created!')

'Click button Continue'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnContinue'))

'Verify hien thi hiển thị “Logged in as username'
actualTextName = WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtLoginUserName'))
assert actualTextName.equals('Logged in as ' + name)


GlobalVariable.name = name
GlobalVariable.email =email
GlobalVariable.password = password
