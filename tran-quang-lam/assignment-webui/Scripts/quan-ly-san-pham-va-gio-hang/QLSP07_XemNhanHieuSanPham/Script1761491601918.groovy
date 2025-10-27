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

'Click nút Products'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))

'Nhãn hiệu được hiển thị ở phía trái side bar'
String txtBrandSideBar=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtBrandSideBar'))
assert txtBrandSideBar.equals('BRANDS')

'Click lên bất kỳ tên nhãn hiệu'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aBrandProducts',[('brand'):brand]))

'Người dùng được điều hướng đến trang nhãn hiệu và nhãn hiệu của sản phẩm hiển thị thành công'
txtBrandName=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtBrandName'))
assert txtBrandName.toLowerCase().contains(brand.toLowerCase())

'Trên phía trái side bar, click lên bất kỳ link nhãn hiệu'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aBrandProducts',[('brand'):brand2]))

'Người dùng được điều hướng đến trang nhãn hiệu và có thể xem sản phẩm'
String txtBrandName=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtBrandName'))
assert txtBrandName.toLowerCase().contains(brand2.toLowerCase())
assert WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/aViewProduct',[('product'):3]))