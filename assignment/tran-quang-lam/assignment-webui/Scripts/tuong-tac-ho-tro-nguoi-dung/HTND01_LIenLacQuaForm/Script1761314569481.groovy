import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

'Click Contact us'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/aContactUs'))

'Verify GET IN TOUCH'
txtGetInTouch=WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtGetInTouch'))
assert txtGetInTouch.equals('GET IN TOUCH')

'Nhập name'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptNameContact'), name)

'Nhập email'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptEmailContact'), email)

'Nhập subject'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptSubject'), subject)

'Nhập message'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/textareaMessage'), message)

'upload file'

String projectDir=RunConfiguration.getProjectDir()
String filePath=projectDir+'/Data Files/fileupload-htnd01.jpg'

WebUI.uploadFile(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptUploadFile'), filePath)

'Nhấn submit'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptSubmitContact'))

'Click nút OK'
WebUI.acceptAlert()

'Verify Success! Your details have been submitted successfully.'
txtSuccess=WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtSuccessContact'))
assert txtSuccess.equals('Success! Your details have been submitted successfully.')

'Click Home'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/aHome'))

'Verify trang chủ hiển thị'
WebUI.verifyElementVisible(findTestObject('tuong-tac-ho-tro-nguoi-dung/imgHome'))
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/imgHome'))