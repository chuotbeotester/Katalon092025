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

public class AddressDetail {

	@Keyword
	def verifyDeliveryAddress(String firstname, String lastname, String address, String city, String selectCountry,String state, String zipcode, String phonenumber) {
		// Lấy toàn bộ text từ khối Delivery Address
		String actualText = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtDeliveryAddress')).toLowerCase()

		// Gom tất cả giá trị kỳ vọng
		List<String> expectedValues = [
			firstname,
			lastname,
			address,
			city,
			selectCountry,
			state,
			zipcode,
			phonenumber
		]

		//Kiểm tra từng giá trị có xuất hiện trong text thực tế không
		for (String value : expectedValues) {
			WebUI.verifyEqual(actualText.contains(value.toLowerCase()), true, FailureHandling.STOP_ON_FAILURE)
		}
	}
	@Keyword
	def verifyBillingAddress(String firstname, String lastname, String address, String city, String selectCountry,String state, String zipcode, String phonenumber) {
		// Lấy toàn bộ text từ khối Delivery Address
		String actualText = WebUI.getText(findTestObject('dat-hang-thanh-toan/txtBillingAddress')).toLowerCase()

		// Gom tất cả giá trị kỳ vọng
		List<String> expectedValues = [
			firstname,
			lastname,
			address,
			city,
			selectCountry,
			state,
			zipcode,
			phonenumber
		]

		//Kiểm tra từng giá trị có xuất hiện trong text thực tế không
		for (String value : expectedValues) {
			WebUI.verifyEqual(actualText.contains(value.toLowerCase()), true, FailureHandling.STOP_ON_FAILURE)
		}
	}
}
