package PlaywrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Playwright_DownloadFile_25 {
    public static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        BrowserContext brc = br.newContext();
        Page page = brc.newPage();
        page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");
        Download downloadFile =page.waitForDownload(()-> {page.click("//a[text()='chromedriver_win32.zip']");});
        System.out.println("Download URL := " + downloadFile.url());
        //System.out.println(downloadFile.page().title());
        //String path = downloadFile.path().toString();
        //System.out.println("Download Path := " + path);
        downloadFile.saveAs(Paths.get("C:\\Users\\Hardik.Mehta\\Downloads\\Test_chromedriver.zip"));

        //For Actual file name printed.
        System.out.println(downloadFile.suggestedFilename());

        //Cancel download file --> downloadFile.cancel();
        //If any failure is occurred or not while download the file --> downloadFile.failure();



    }
}
