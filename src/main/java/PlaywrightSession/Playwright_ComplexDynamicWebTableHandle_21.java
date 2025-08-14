package PlaywrightSession;

import com.microsoft.playwright.*;

import java.util.List;

public class Playwright_ComplexDynamicWebTableHandle_21 {
    public static Page pg;
    public  static  void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        pg = brc.newPage();
        pg.navigate("https://demo.guru99.com/test/web-table-element.php");
        Locator rowLocator = pg.locator("//table[@class='dataTable']//tr[2]");
        List<String> allRowData= rowLocator.allTextContents();
        for(String e:allRowData)
        {
            System.out.print(e);
        }
        Locator allRowLocatorData = pg.locator("//table[@class='dataTable']//tr");
        allRowLocatorData.locator(":scope").
                allInnerTexts().forEach(e -> System.out.println(e) );
        System.out.println("*************************************************************");

        //rowLocator.locator(":scope", new Locator.LocatorOptions().setHasText("Apollo Hospitals")).allTextContents();

        BrowserContext brc1 = br.newContext();
        Page pg1 = brc1.newPage();
        pg1.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
        Locator rowData = pg1.locator("//table[@id='example']//tr");
        rowData.locator(":scope", new Locator.LocatorOptions()
                .setHasText("Angelica Ramos")).
                locator(".dt-select-checkbox").click();
        System.out.println("2nd Data Table Data....:=");
        rowData.locator(":scope")
                .allInnerTexts().forEach( s1 -> System.out.println(s1));




    }
}
