package PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Playwright_VideoRecording_28 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("MyVideos/"))
                    .setRecordVideoSize(1280,720));
            // Start tracing before creating / navigating a page.
           /* context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));*/
            Page page = context.newPage();

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
            System.out.println(page.title());
            /*page.locator("//a[text()='Go To Store']").first().click();
            page.locator("//div[@class='dropdown dropdown-right']/a/*[last()]").first().click();
            page.locator("//div[@class='dropdown dropdown-right']/*[last()]/*[last()-1]")
                    .first().click();
            Locator firstName = page.locator("//input[@id='name']");
            firstName.click();
            System.out.println(firstName.textContent());*/

            // Stop tracing and export it into a zip archive.
            //context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        context.close();
        page.close();
        playwright.close();

    }
}
