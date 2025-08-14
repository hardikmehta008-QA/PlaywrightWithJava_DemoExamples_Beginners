package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_NthElementSelector_18 {
    public  static Page pg;
    public  static void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        pg = brc.newPage();
        pg.navigate("https://www.bigbasket.com/");
        Locator firstElement = pg.locator("div.pr-4 li a >> nth=0");
        String first_ele = firstElement.textContent();
        System.out.println("First ELEMENT := " + first_ele);

        Locator lastElement = pg.locator("div.pr-4 li a >> nth=-1");
        String last_ele = lastElement.textContent();
        System.out.println("LAST ELEMENT := " + last_ele);

        //Click on First Element Link
        firstElement.click();

    }
}
