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

'Nhập name Signup '
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptName'), name)

'Nhập email address Signup'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptEmail'), email)

'Nhấn Signup'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnSignup'))

'Verify Enter account information hiển thị'
String txtEnterAccount=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtEnterAccountInformation'))
assert txtEnterAccount.equals('ENTER ACCOUNT INFORMATION')

'Chọn title'
WebUI.check(findTestObject('quan-ly-tai-khoan/dang-ky/iptTitle'))

'Verify name'
String txtName=WebUI.getAttribute(findTestObject('quan-ly-tai-khoan/dang-ky/txtName'),'value')
assert txtName.equals(name)

'Verify email'
String txtEmail=WebUI.getAttribute(findTestObject('quan-ly-tai-khoan/dang-ky/txtEmail'),'value')
assert txtEmail.equals(email)

'Nhập password'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptPassword'), password)

'Chọn Days'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/slcDays'), days, false)

'Chọn Months'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/slcMonths'), months, false)

'Chọn Years'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/slcYears'), years, false)

'Chọn checkbox Sign up for our newsletter!'
WebUI.check(findTestObject('quan-ly-tai-khoan/dang-ky/iptNewsletter'))

'Chọn checkbox Receive special offers from our partners!'
WebUI.check(findTestObject('quan-ly-tai-khoan/dang-ky/iptOptin'))

'Nhập first name'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptFirstName'), firstName)

'Nhập last name'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptLastName'), lastName)

'Nhập company'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptCompany'), company)

'Nhập address 1'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptAddress1'), address1)

'Nhập address 2'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptAddress2'), address2)

'Chọn select country'
WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/slcCountry'), country, false)

'Nhập state'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptState'), state)

'Nhập city'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptCity'), city)

'Nhập zipcode'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptZipcode'), zipcode)

'Nhập mobile number'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptMobileNumber'), mobileNumber)

'Click Create Account!'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnCreateAccount'))

'Verify ACCOUNT CREATED! hiển thị'
txtCreatedAccount=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtCreatedAccount'))
assert txtCreatedAccount.equals("ACCOUNT CREATED!")

'Click nút Continue'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnContinue'))

'Verify Logged in as username hiển thị'
String txtLoggedIn=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtLoggedIn'))
assert txtLoggedIn.contains('Logged in as')


GlobalVariable.email=email
GlobalVariable.password=password

//'Click nút Delete Account'
//WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/aDeleteAccount'))
//
//'Verify ACCOUNT DELETED! hiển thị'
//txtDeleteAccount=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-ky/txtDeleteAccount'))
//assert txtDeleteAccount.equals("ACCOUNT DELETED!")
//
//'Click nút Continue'
//WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnContinue'))