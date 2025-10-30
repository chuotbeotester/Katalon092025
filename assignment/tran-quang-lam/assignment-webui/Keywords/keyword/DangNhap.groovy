package keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class DangNhap {
	public static def signin(String email, String password) {

		'Nhập email'
		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptEmail'), email)

		'Nhập password'
		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-nhap/iptPassword'), password)

		'Click nút Login'
		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-nhap/btnLogin'))

		'Verify Logged in as username hiển thị'
		String txtLoggedIn=WebUI.getText(findTestObject('quan-ly-tai-khoan/dang-nhap/txtLoggedIn'))
		assert txtLoggedIn.contains('Logged in as')
	}
}
