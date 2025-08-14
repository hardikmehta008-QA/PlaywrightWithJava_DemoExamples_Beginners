package PlaywrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Playwright_HandleBrowserWindowPopUpAndTab_29 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        /*BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("MyVideos/"))
                .setRecordVideoSize(1020, 600));*/
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.orangehrm.com/30-day-free-trial");
        //(1) Open a New Tab/Window/PopUP after clicking on link on the Parent page.
        Page popUPPage = page.waitForPopup(() ->{
            page.click("//img[@alt='youtube']");
        });
        popUPPage.waitForLoadState();
        System.out.println("POP UP PAGE URL :=" + popUPPage.url());
        System.out.println("POP UP PAGE TITLE :=" + popUPPage.title());
        popUPPage.close();
        System.out.println("Original Page Title :=" + page.title());

        //(2) Open a New BLANK TAB/Window and enter the new URL:
        /*Page popUPPage = page.waitForPopup(() ->{
            page.click("a[target='_blank']"); //Open a new tab window
        });
        popUPPage.waitForLoadState();
        popUPPage.navigate("https://www.google.com");
        System.out.println("POP UP PAGE TITLE :=" + popUPPage.title());
        System.out.println("POP UP PAGE URL :=" + popUPPage.url());
        popUPPage.close();
        System.out.println("Original Page Title :=" + page.title());
        page.close();*/

        /*page.close();
        context.close();
        playwright.close();*/


    }
}
