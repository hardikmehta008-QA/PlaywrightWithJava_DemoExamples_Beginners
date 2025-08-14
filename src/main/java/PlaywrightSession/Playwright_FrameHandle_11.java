package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_FrameHandle_11 {
    public  static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        Page pg = brc.newPage();
        pg.navigate("https://demoqa.com/frames");
        String header = pg.frameLocator("iframe#frame1").locator("h1").textContent();
        System.out.println("This is the iframe sample Heading := " + header);

        BrowserContext brc2 = br.newContext();
        Page pg2 = brc2.newPage();
        pg2.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        pg2.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
        pg2.frameLocator("//iframe[contains(@id, 'frame-one')]")
                .locator("#RESULT_TextField-8").fill("Hardik Mehta");

    }
}
