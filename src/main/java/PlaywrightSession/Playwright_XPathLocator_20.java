package PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class Playwright_XPathLocator_20 {
    public static Page pg;
    public static void main(String[] args) {
        try {
            Playwright pw = Playwright.create();
            Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext brc = br.newContext();
            //pg = brc.newPage();
            /*pg.onDialog(dialog -> {
                String text = dialog.message();
                System.out.println(text);
                //dialog.accept();
                dialog.dismiss();
            });*/
            /*pg.navigate("https://www.amazon.com/");
            //Click on "Continue shopping" button
            pg.locator("xpath=//button[contains(text(), 'Continue shopping')]").click();
            Thread.sleep(3000);
            //Click on Pop-up "Dismiss" button
            pg.click("xpath=//span[@class='a-button-inner']");
           //pg.locator("xpath=//span[@class='a-button-inner']").first().click();
           // pg.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).first().click();

           *//*Locator searchBox = pg.locator("xpath=//input[@id='twotabsearchtextbox']");
            searchBox.fill("Mobile Phones");
            searchBox.press("Enter");*//*

            Locator totlaAmazonLinks = pg.locator("//a[contains(text(),'Amazon')]");
            System.out.println("Totla Amazon Link is := " + totlaAmazonLinks.count());
            List<String> textList = totlaAmazonLinks.allInnerTexts();
            for(String e:textList)
            {
                System.out.println(e);
            }*/

            BrowserContext brc1 = br.newContext();
            Page pg1 = brc1.newPage();
            pg1.navigate("https://selectorshub.com/xpath-practice-page/");
            pg1.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
            Locator userRole = pg1.locator("//a[text()='Joe.Root']/parent::td/following-sibling::td");
            System.out.println("USER ROLE IS := " + userRole.first().textContent());

            /*Locator checkBoxes = pg1.locator("//table[@id='resultTable']//input[@type='checkbox']");
            for(int i=0; i<checkBoxes.count(); i++)
            {
                checkBoxes.nth(i).click();
            }*/
            //Index of xpath
            // (//table[@id='resultTable']//input[@type='checkbox'])[3]
            // (//table[@id='resultTable']//input[@type='checkbox'])[last()]
            // (//table[@id='resultTable']//input[@type='checkbox'])[position()=5]

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
