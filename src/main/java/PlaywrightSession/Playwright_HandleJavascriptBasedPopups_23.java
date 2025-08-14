package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_HandleJavascriptBasedPopups_23 {
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        Page page = brc.newPage();
        page.onDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            //dialog.accept();
            //dialog.dismiss();
            dialog.accept("This is my PROMPT, Please accept...");
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.click("//button[text()='Click for JS Alert']");
        String resultMessage = page.locator("//p[@id='result']").textContent();
        System.out.println(resultMessage);

        page.click("//button[text()='Click for JS Confirm']");
        resultMessage = page.locator("//p[@id='result']").textContent();
        System.out.println(resultMessage);

        page.click("//button[text()='Click for JS Prompt']");
        resultMessage = page.locator("//p[@id='result']").textContent();
        System.out.println(resultMessage);

    }
}
