package PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator;

import java.util.List;

public class Playwright_LocatorsConcept_09 {
    public static void main(String[] arg){
        try (Playwright pw = Playwright.create()) {
            Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc1 = browser.newContext();
            Page pg1 = brc1.newPage();
            pg1.navigate("https://www.orangehrm.com/30-day-free-trial");
            //Multiple Element
            //Locator contactSales = pg1.locator("text=Contact Sales").last();
              //      contactSales.hover();
                //    contactSales.click();

            //Multiple Element
            /* pg1.navigate("https://academy.naveenautomationlabs.com/");
            Locator loginBtn = pg1.locator("xpath=//*[contains(text(), 'Login')]");
            int totalLogin = loginBtn.count();
            System.out.println(totalLogin);
            loginBtn.first().click();*/

            //Multiple Elements
            Locator countryOptions = pg1.locator("select#Form_getForm_Country");
            System.out.println("Total Country :- " + countryOptions.count());
            /*for(int i=0; i<countryOptions.count(); i++)
            {
                String text = countryOptions.nth(i).textContent();
                System.out.println("Country Values is := " + text);
            }*/
            List<String> optionsTextList = countryOptions.allTextContents();
            for(String e:optionsTextList)
            {
                System.out.println(e);
            }
    }
}
}
