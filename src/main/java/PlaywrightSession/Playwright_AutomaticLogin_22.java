package PlaywrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Playwright_AutomaticLogin_22 {
    public  static  void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        Page page = brc.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        page.click("//a[text()='Login']");
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//strong[text()='Log in']").click();
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//button[text()=' Continue with email']").click();
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//input[@id='input-email']").click();
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//input[@id='input-email']").fill("automationpw@yopmail.com");
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//input[@id='input-password']").click();
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//input[@id='input-password']").fill("Pw@112233");
        page.frameLocator("//iframe[@id='microfe-popup-login']")
                .locator("//button[text()='Next']").click();

        //Automatic Login (No need to write Login Steps) in Playwright - Java
        brc.storageState(new BrowserContext.StorageStateOptions()
                .setPath(Paths.get("applicationLogin.json")));

    }
}
