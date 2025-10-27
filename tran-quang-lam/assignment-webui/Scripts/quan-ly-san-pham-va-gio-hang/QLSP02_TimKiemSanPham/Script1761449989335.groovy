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

'Click vào Products'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))

'Verify điều hướng đến trang ALL PRODUCTS'
String txtAllProducts=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtAllProducts'))
assert txtAllProducts.equals('ALL PRODUCTS')

'Nhập tên sản phẩm lên ô input'
WebUI.setText(findTestObject('quan-ly-san-pham-va-gio-hang/iptSearchProduct'), searchName)

'Click nút tìm kiếm'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnSearch'))

'SEARCHED PRODUCTS hiển thị thành công'
String txtSearchedProducts=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtSearchedProducts'))
assert txtSearchedProducts.equals('SEARCHED PRODUCTS')

'Các sản phẩm liên quan được hiển thị thành công'
String productNameList=findTestData('quan-ly-san-pham-va-gio-hang').getValue('productName', 2)
def  expectedProducts=productNameList.split(',').collect { it.trim() }
for(String products: expectedProducts) {
	String txtProductName=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtSearchProductsName',[('productName'):products]))
	assert txtProductName.contains(searchName)
}
