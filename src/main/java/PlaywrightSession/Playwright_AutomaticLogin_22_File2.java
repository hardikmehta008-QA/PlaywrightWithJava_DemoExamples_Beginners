package PlaywrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Playwright_AutomaticLogin_22_File2 {
    public  static  void  main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext(new Browser.NewContextOptions().
                setStorageStatePath(Paths.get("applicationLogin.json")));
        Page pg = br.newPage();
        pg.navigate("https://academy.naveenautomationlabs.com/");
    }
}
