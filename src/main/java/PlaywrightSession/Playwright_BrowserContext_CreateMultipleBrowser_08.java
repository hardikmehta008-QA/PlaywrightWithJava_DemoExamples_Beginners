package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_BrowserContext_CreateMultipleBrowser_08 {
    public static void main(String[] args) {
        try (Playwright pw = Playwright.create()) {
            Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc1 = browser.newContext();
            Page pg1 = brc1.newPage();
            pg1.navigate("https://www.orangehrm.com/30-day-free-trial");
            pg1.fill("#Form_getForm_Name", "TestPlaywright");
            pg1.fill("#Form_getForm_Email", "pwautomation@yopmail.com");
            pg1.fill("#Form_getForm_Contact","+91 23908-76541");
            pg1.locator("#Form_getForm_Country").selectOption("India");
            /*
            // Locate the checkbox using its selector
            Locator captchaCheckbox = pg1.locator("xpath=//span[@id='recaptcha-anchor']"); // Replace with your actual selector
            captchaCheckbox.check(); // Check the CAPTCHA checkbox
            System.out.println("CAPTCHA checkbox checked.");*/
            System.out.println("Browser Context-1 Title is:= " + pg1.title());

            BrowserContext brc2 = browser.newContext();
            Page pg2 = brc2.newPage();
            pg2.navigate("https://www.pluralsight.com/individuals/pricing");
            System.out.println("Browser Context-2 Title is:= " + pg2.title());
            //pg2.locator("xpath=//input[@name='q']").fill("Mobiles");

        }
    }
}
