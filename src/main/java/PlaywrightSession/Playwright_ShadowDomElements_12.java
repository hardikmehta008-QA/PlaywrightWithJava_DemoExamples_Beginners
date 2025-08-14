package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_ShadowDomElements_12 {
    public  static void main(String[] args) {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        Page pg = brc.newPage();
        pg.navigate("https://books-pwakit.appspot.com/");
        pg.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
        String text = pg.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(text);

        BrowserContext brc2 = br.newContext();
        Page pg2 = brc2.newPage();
        pg2.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
        pg2.frameLocator("#pact").locator("div#app2 input#pizza").fill("Peppy Panner Veg Pizza with RED PAPRIKA");

    }
}
