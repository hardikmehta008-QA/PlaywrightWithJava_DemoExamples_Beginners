package PlaywrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class Playwright_SelectingVisibleElements_13 {
    public static void main(String[] args) {
        try {
            Playwright pw = Playwright.create();
            Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc = br.newContext();
            Page pg = brc.newPage();
            //pg.navigate("https://www.letskodeit.com/practice");
            pg.navigate("https://www.myntra.com/");

            //(1) button:visible
            // (2) button >> visible=true
            List<String> linkText = pg.locator("a:visible").allInnerTexts();
            for (int i = 0; i < linkText.size(); i++) {
                System.out.println("All Link Text is := " + linkText.get(i));
            }

            int imgCount = pg.locator("xpath=//img >> visible=true").count();
            System.out.println("IMAGE COUNT := " + imgCount);

            List<String> amazonLink = pg.locator("a:has-text('Myntra')").allInnerTexts();
            for (int i = 0; i < amazonLink.size(); i++) {
                System.out.println("AMAZON LINK := " + amazonLink.get(i));
            }

            //pg.locator("xpath=//span[@class='a-button-inner']//span[contains(text(), 'Sign in')]").click();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
