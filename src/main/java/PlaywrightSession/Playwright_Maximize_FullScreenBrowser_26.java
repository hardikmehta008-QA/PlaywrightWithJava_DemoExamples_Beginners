package PlaywrightSession;

import com.microsoft.playwright.*;

import java.awt.*;

public class Playwright_Maximize_FullScreenBrowser_26 {
    public  static void main(String[] args)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println(width + ":" + height);

        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext(new Browser.NewContextOptions().
                setViewportSize(width, height));
        Page page = brc.newPage();
        page.navigate("https://academy.naveenautomationlabs.com/");
        System.out.println(page.title());
    }
}
