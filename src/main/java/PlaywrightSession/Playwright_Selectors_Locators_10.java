package PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

public class Playwright_Selectors_Locators_10 {
    public static void main(String[] arg) {
        try (Playwright pw = Playwright.create()) {
            Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc = browser.newContext();
            Page pg = brc.newPage();
            pg.navigate("https://www.orangehrm.com/30-day-free-trial");

            //text  locators
            Locator textLocator= pg.locator("text=We Just Need a Few Details.");
            System.out.println("Text Locators := " + textLocator.textContent());

            //More than 2 text locators available
            //pg.locator("text=Contact Sales").last().click();
            //System.out.println("Contact Sales Title := " + pg.title());

            //Using "has-text" Method for print the header text.
            String header1 = pg.locator("div.free-trial-page-slider-content h1:has-text('Revolutionize Your Human Resource Management Experience!')").textContent();
            System.out.println(header1);

            //Parent-Child Locators
            pg.locator("p.privacy-policy a:has-text('Privacy Policy')").click();
            Thread.sleep(5000);
            //String newPageTitle = pg.title();
            //System.out.println("Privacy Policy Title := " + newPageTitle);

            /*//List of locators, print all the locators and click on any particular locator
            Locator links = pg.locator("text=Privacy Policy");
            for(int i=0; i<links.count(); i++)
            {
               String text = links.nth(i).textContent();
               System.out.println(text);
                if(text.contains("DPF Privacy Policy"))
                {
                    links.nth(i).click();
                    break;
                }

            }
            Thread.sleep(5000);
            System.out.println("User is able to click the link....");*/


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
