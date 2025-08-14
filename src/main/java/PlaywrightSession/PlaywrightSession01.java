package PlaywrightSession;

import com.microsoft.playwright.*;

public class PlaywrightSession01 {
    public static  void  main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser browser =  pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://playwright.dev/java/docs/intro");
        String title = page.title();
        System.out.println("Page Title is:= " + title);

        String url = page.url();
        System.out.println("URL is:= " + url);
        //browser.close();
        //pw.close();
    }
}
