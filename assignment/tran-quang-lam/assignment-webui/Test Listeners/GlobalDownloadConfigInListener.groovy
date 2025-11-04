import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver

import java.io.File

class GlobalDownloadConfigInListener {

	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase	
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
	}
	
    @BeforeTestSuite
    def configureDownloadDirectory(TestSuiteContext testSuiteContext) {
        println "********************************************************"
        println "---!!! TEST LISTENER [FIX LỖI RESUME V_FINAL] ĐANG CHẠY !!!---"
        println "********************************************************"

        String currentSuiteId = testSuiteContext.getTestSuiteId()
        String targetSuiteId = "Test Suites/TS04_DatHangVaThanhToan"

        if (currentSuiteId.equalsIgnoreCase(targetSuiteId)) {

            println "********************************************************"
            println "---!!! TEST LISTENER [FIX LỖI RESUME V_FINAL] ĐANG CHẠY CHO SUITE: ${currentSuiteId} !!!---"
            println "********************************************************"

            String projectDir = RunConfiguration.getProjectDir().replace("/", File.separator)
            String downloadPath = projectDir + File.separator + "Data Files" + File.separator + "download files"

            // ✅ Tạo ChromeOptions với đầy đủ cờ tắt bảo mật
            ChromeOptions options = new ChromeOptions()
            Map<String, Object> prefs = new HashMap<>()

            // Cài đặt download cơ bản
            prefs.put("profile.default_content_settings.popups", 0)
            prefs.put("download.prompt_for_download", false)
            prefs.put("download.default_directory", downloadPath)

            // Cài đặt tắt Safe Browsing (để fix lỗi 'Resume')
            prefs.put("safebrowsing.enabled", false)
            prefs.put("safebrowsing.disable_download_protection", true)
            prefs.put("download.directory_upgrade", true) // Báo Chrome dùng engine download mới

            options.setExperimentalOption("prefs", prefs)

            // Cờ (Arguments) để tắt Safe Browsing và các lớp bảo mật khác
            options.addArguments("--start-maximized")
            options.addArguments("--disable-extensions")
            options.addArguments("--safebrowsing-disable-download-protection")
            options.addArguments("--no-sandbox")
            options.addArguments("--disable-dev-shm-usage")
            options.addArguments("--disable-web-security")
            options.addArguments("--allow-running-insecure-content")

            // ✅ Tạo WebDriver thủ công
            WebDriver driver = new ChromeDriver(options)
            DriverFactory.changeWebDriver(driver)

        } else {
            println "********************************************************"
            println "---!!! Bỏ qua Listener trình duyệt tùy chỉnh cho Suite: ${currentSuiteId} ---!!!"
            println "********************************************************"
            // Không làm gì cả, để Katalon tự mở trình duyệt mặc định
        }
    }

    @AfterTestSuite
    def tearDown(TestSuiteContext testSuiteContext) {
        println "---🧹 Đóng trình duyệt sau Test Suite---"
        DriverFactory.closeWebDriver()
    }
}
