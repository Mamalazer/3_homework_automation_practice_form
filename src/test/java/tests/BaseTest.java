package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static utils.AllureAttachmentHelper.*;

public class BaseTest {
    @BeforeAll
    public static void setUp() {
        String[] browserSettings = System.getProperty("browser", "chrome 100").split("\\s+");
        Configuration.pageLoadTimeout = 10000;
        Configuration.timeout = 10000;
        Configuration.browser = browserSettings[0];
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.headless = false;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote =  System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud") +"/wd/hub";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setBrowserName(browserSettings[0]);
        capabilities.setVersion(browserSettings[1]);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        attachHtml("HTML");
        addVideo();
        closeWebDriver();
    }

}

