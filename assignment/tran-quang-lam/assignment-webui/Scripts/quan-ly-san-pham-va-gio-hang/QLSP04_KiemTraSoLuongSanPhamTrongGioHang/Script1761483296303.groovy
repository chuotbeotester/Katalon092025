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

'Click view product cho sản phẩm bất kỳ'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewProduct',[('product'):1]))

'Chi tiết sản phẩm được mở'
String txtReview=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/aReviews'))
assert txtReview.equals('WRITE YOUR REVIEW')

'Tăng số lượng lên 4'
WebUI.setText(findTestObject('quan-ly-san-pham-va-gio-hang/iptQuantity'), '4')

'Click nút Add to cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnAddToCart'))

'Click nút view cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCartProducts'))

'Sản phẩm được hiển thị trong giỏ hàng với số lượng chính xác'
txtBtnQuantity=WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtBtnQuantity'))
assert txtBtnQuantity.equals('4')
