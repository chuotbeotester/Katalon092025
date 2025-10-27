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
import com.kms.katalon.core.configuration.RunConfiguration

'Click contact us'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnContactUs'))

'Verify GET IN TOUCH được hiển thị'
textGetInTouch = WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txtGetInTouch'))
assert textGetInTouch.equals('Get In Touch')

'Nhập Name'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptName'), name)

'Nhập Email'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptEmail'), email)

'Nhập Subject'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptSubject'), subject)

'Nhập Message vào form liên hệ'
WebUI.setText(findTestObject('tuong-tac-ho-tro-nguoi-dung/iptMessageHere'), message)

'Tải lên một tệp đính kèm (Upload file)'
String projectDir = RunConfiguration.getProjectDir() 
String filePath = projectDir + '/Data Files/download.jpg'
WebUI.uploadFile(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnUploadFile'), filePath)

'Nhấn vào Submit button'
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnSubmit'))

'Nhấn OK trên thông báo xác nhận'
WebUI.acceptAlert()

'Hiển thị message Success! Your details have been submitted successfully.'
actualText = WebUI.getText(findTestObject('tuong-tac-ho-tro-nguoi-dung/txt_Success'))
assert actualText.equals('Success! Your details have been submitted successfully.')

'Nhấn nút Home'	
WebUI.click(findTestObject('tuong-tac-ho-tro-nguoi-dung/btnHome'))

'Verify Người dùng trở lại trang chủ thành công'
WebUI.verifyElementVisible(findTestObject('tuong-tac-ho-tro-nguoi-dung/imgTrangChu'))

