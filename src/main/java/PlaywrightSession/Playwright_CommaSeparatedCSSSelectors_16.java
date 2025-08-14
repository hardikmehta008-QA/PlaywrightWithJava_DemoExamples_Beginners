package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_CommaSeparatedCSSSelectors_16 {
    public static void main(String[] args) {
            Playwright pw = Playwright.create();
            Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc = br.newContext();
            Page pg = brc.newPage();
            pg.navigate("https://academy.naveenautomationlabs.com/");

            //Comma separated CSS Selectors and Xpath Union
            /*pg.locator("a:has-text('Login'), a:has-text('LogIn'), " +
                    "a:has-text('Signin'), a:has-text('SignIn')").click();*/

            Locator imp_ele = pg.locator("a:has-text('Courses'), a:has-text('Demo Site')");
            System.out.println("COUNT := " + imp_ele.count());
            if(imp_ele.count() == 3)
            {
                System.out.println("PASS...");
            }else
            {
                System.out.println("FAIL...");
            }

    }
}
