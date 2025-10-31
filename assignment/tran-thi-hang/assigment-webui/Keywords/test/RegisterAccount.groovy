package test

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

public class RegisterAccount {
	@Keyword
	def fillSignupForm(String name, String email) {
		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptName'), name)
		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptEmail'), email)
		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnSignUp'))
	}

	@Keyword
	def fillAccountForm(String password, String day, String month, String year, String firstname, String lastname, String address, String selectCountry, String state, String city, String zipcode, String phonenumber) {

		//		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/radTitlle'))

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptPasssword'), password)

		WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectDay'), day, false)

		WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectMonth'), month , false)

		WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/selectYear'), year, false)

		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/checkboxNewLetter'))

		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/checkboxReceive'))

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptFirstName'), firstname)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptLastName'), lastname)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptAddress'), address)

		WebUI.selectOptionByValue(findTestObject('quan-ly-tai-khoan/dang-ky/iptContry'), selectCountry , false)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptState'), state)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptCity'), city)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptZipCode'), zipcode)

		WebUI.setText(findTestObject('quan-ly-tai-khoan/dang-ky/iptMobile'), phonenumber)

		WebUI.click(findTestObject('quan-ly-tai-khoan/dang-ky/btnCreateAccount'))
	}
	@Keyword
	def verifyDeliveryAddress(String firstname, String lastname, String address, String city, String selectCountry, String phonenumber) {
		// Lấy toàn bộ text từ khối Delivery Address
		String actualText = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtDeliveryAddress')).toLowerCase()

		// Gom tất cả giá trị kỳ vọng
		List<String> expectedValues = [
			firstname,
			lastname
			address,
			city,
			selectCountry,
			phonenumber
		]

		//Kiểm tra từng giá trị có xuất hiện trong text thực tế không
		for (String value : expectedValues) {
			WebUI.verifyEqual(actualText.contains(value.toLowerCase()), true, FailureHandling.STOP_ON_FAILURE)
		}
	}
}
