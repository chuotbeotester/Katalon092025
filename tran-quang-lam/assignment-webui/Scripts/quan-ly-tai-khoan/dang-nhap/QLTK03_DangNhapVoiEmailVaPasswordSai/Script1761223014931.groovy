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

'Nhập email sai'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmail'), emailWrong)

'Nhập password sai'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPassword'), password)

'Click nút Login'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))

'Verify Your email or password is incorrect! hiển thị'
String txtIncorrect=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-nhap/txtIncorrect'))
assert txtIncorrect.equals('Your email or password is incorrect!')

'Nhập email'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmail'), email)

'Nhập password sai'
WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPassword'), password)

'Click nút Login'
WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))

'Verify Your email or password is incorrect! hiển thị'
txtIncorrect=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-nhap/txtIncorrect'))
assert txtIncorrect.equals('Your email or password is incorrect!')