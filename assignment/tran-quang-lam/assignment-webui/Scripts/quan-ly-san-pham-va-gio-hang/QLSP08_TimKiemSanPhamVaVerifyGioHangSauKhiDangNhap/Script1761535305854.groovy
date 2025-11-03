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
import keyword.DangNhap as DangNhap
import keyword.HelperKeywords as HelperKeywords
import keyword.ProductAndCartObject as ProductAndCartObject
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

'Click vào Products'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aProducts'))

'Verify điều hướng đến trang ALL PRODUCTS'
HelperKeywords.verifyTextEqual(findTestObject('quan-ly-san-pham-va-gio-hang/txtAllProducts'), 'ALL PRODUCTS')

'Nhập tên sản phẩm lên ô input'
WebUI.setText(findTestObject('quan-ly-san-pham-va-gio-hang/iptSearchProduct'), searchName)

'Click nút tìm kiếm'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/btnSearch'))

'SEARCHED PRODUCTS hiển thị thành công'
String txtSearchedProducts = WebUI.getText(findTestObject('quan-ly-san-pham-va-gio-hang/txtSearchedProducts'))

assert txtSearchedProducts.equals('SEARCHED PRODUCTS')

'Các sản phẩm liên quan được hiển thị thành công'
HelperKeywords.verifyAllContainText(findTestObject('quan-ly-san-pham-va-gio-hang/txtNameProducts'), searchName)

'Thêm tất cả sản phẩm vào giỏ hàng'
ProductAndCartObject.addToCartAllProduct()

'Click nút Cart'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCart'))

'Các sản phẩm đều được thêm vào giỏ hàng'
HelperKeywords.verifyAllContainText(findTestObject('quan-ly-san-pham-va-gio-hang/txtCartDescription'), searchName)

'Click nút Signup/Login'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aSignupLogin'))

'Gửi chi tiết đăng nhập'
WebUI.callTestCase(findTestCase('chuan-bi-du-lieu/CBDL_DangNhapTaiKhoan'), [('email') : email, ('password') : password])

'Đi đến trang giỏ hàng'
WebUI.click(findTestObject('quan-ly-san-pham-va-gio-hang/aViewCart'))

'Tất cả sản phẩm được hiển thị sau khi đăng nhập'
HelperKeywords.verifyAllContainText(findTestObject('quan-ly-san-pham-va-gio-hang/txtCartDescription'), searchName)

