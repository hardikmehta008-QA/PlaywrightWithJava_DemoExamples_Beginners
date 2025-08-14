package PlaywrightSession;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Playwright_TraceViewer_CaptureScreenshots_07 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
            Page page = context.newPage();
            /*page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Name")).fill("PlaywrightAutomation");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).fill("pwautomation@yopmail.com");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).fill("Pw@112233");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Enter your number")).fill("+91 23908-76541");
            //page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
            //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
            //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Profile")).click();*/
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("#microfe-popup-login").contentFrame().getByText("Log in").click();
            //page.pause();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Continue with email")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Email address")).fill("pwautomation@yopmail.com");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.TEXTBOX, new FrameLocator.GetByRoleOptions().setName("Password")).fill("Pw@112233");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
                page.locator("#collabIframe").contentFrame().getByRole(AriaRole.LINK, new FrameLocator.GetByRoleOptions().setName("Go To Store")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Profile")).click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        }
    }
}
