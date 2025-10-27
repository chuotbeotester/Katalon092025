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
import org.openqa.selenium.WebElement

'Scroll đến cuối trang'
WebUI.scrollToElement(findTestObject('quan-ly-san-pham-va-gio-hang/txtSubscription'), 0)

'RECOMMENDED ITEMS được hiển thị thành công'
String txtRecommendItems=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtRecommendItems'))
assert txtRecommendItems.equals('RECOMMENDED ITEMS')

'Click nút add to cart của sản phẩm đề xuất'
TestObject addToCartObj = findTestObject('quan-ly-san-pham-va-gio-hang/aAddToCartRecommend', [('product') : product])
WebElement addToCartElement = WebUI.findWebElement(addToCartObj, 10)
WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(addToCartElement))

'Click nút view cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCartProducts'))

'Sản phẩm được hiển thị trong giỏ hàng'
assert WebUI.verifyElementVisible(findTestObject('quan-ly-san-pham-va-gio-hang/txtCartDescription'))