package PlaywrightSession;

import com.microsoft.playwright.*;

public class Playwright_RelativeCSSSelectors_17 {
    public  static  Page pg;
    public  static void main(String[] args)
    {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        pg = brc.newPage();
        pg.navigate("https://selectorshub.com/xpath-practice-page/");
        // left of, right of, below, above, near,
        //near: input:near(:text('Can you enter name here through automation '))
        //(1) left-of
        pg.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().click();
        userSelect("Jasmine.Morgan");
        userSelect("Kevin.Mathews");

        //(2) right-of
        //select:right-of(:text('Choose a car'))
        String userRoles = pg.locator("td:right-of(:text('John.Smith'))").first().textContent();
        System.out.println("ROLE := " + userRoles);
        System.out.println("User Role := " + getUserRole("Jasmine.Morgan"));
        //(3)above
        String aboveUser = pg.locator("a:above(:text('John.Smith'))").first().textContent();
        System.out.println("Above USER := " + aboveUser);
        //(4)below
        String belowUser = pg.locator("a:below(:text('John.Smith'))").first().textContent();
        System.out.println("Below USER := " + belowUser);

        //Fill the Form
        Locator emailUser = pg.locator("input:below(:text('User Email'))").first();
        emailUser.click();
        emailUser.fill("testing@gmail.com");
        Locator passwordUser = pg.locator("input:below(:text('Password'))").first();
        passwordUser.click();
        passwordUser.fill("Test123");
        Locator companyUser = pg.locator("xpath=//input[@name='company']").first();
        companyUser.click();
        companyUser.fill("MY TEST COMPANY");
        Locator mobileUesr = pg.locator("xpath=//input[@name='mobile number']").first();
        mobileUesr.click();
        mobileUesr.fill("9988776655");

    }

    public  static  void  userSelect(String userName)
    {
        pg.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
    }
    public  static String getUserRole(String userName1)
    {
        return pg.locator("td:right-of(:text('"+userName1+"'))").first().textContent();
    }

}
