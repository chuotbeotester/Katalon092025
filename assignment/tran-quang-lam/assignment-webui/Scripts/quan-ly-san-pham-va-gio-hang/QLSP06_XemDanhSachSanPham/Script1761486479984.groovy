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

'Danh mục được hiển thị ở phía trái side bar'
String txtCategory=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtCategorySideBar'))
assert txtCategory.equals('CATEGORY')

'Click danh mục Women'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aWomen'))

'Click lên danh mục bất kỳ dưới link Women ví dụ:Dress'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aCategoryWomenProducts',[('categorySub'):'Dress']))

'Trang danh mục và text xác nhận WOMEN - TOPS PRODUCTS được hiển thị'
HelperKeywords.verifyTextEqualLower(findTestObject('quan-ly-san-pham-va-gio-hang/txtWomenProducts'), 'WOMEN -  Dress PRODUCTS')

'Trên phía trái side bar, click lên bất kỳ link danh mục phụ của danh mục Men'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aMen'))
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aCategoryMenProducts',[('category'):'Men', ('categorySub'):'Tshirts']))

'Người dùng được điều hướng đến trang danh mục'
HelperKeywords.verifyTextEqualLower(findTestObject('quan-ly-san-pham-va-gio-hang/txtWomenProducts'), 'MEN -  Tshirts PRODUCTS')
