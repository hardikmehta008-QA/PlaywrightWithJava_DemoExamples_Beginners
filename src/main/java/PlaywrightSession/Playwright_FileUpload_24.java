package PlaywrightSession;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Playwright_FileUpload_24 {
    public  static void main(String[] args) throws InterruptedException {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
        /*BrowserContext brc = br.newContext();
        Page page = brc.newPage();
        page.navigate("https://demo.guru99.com/test/upload/");
        //input type=file
        page.setInputFiles("//input[@id='uploadfile_0']",
                Paths.get("C:\\Users\\Hardik.Mehta\\OneDrive - Nitor Infotech Pvt. Ltd\\Desktop\\71moNzBJv+L._SL1500_.jpg"));
        page.click("//input[@id='terms']");
        page.click("//button[@id='submitbutton']");
        String fileUploadMessage = page.locator("//h3[@id='res']").textContent();
        System.out.println(fileUploadMessage);
*/
        BrowserContext brc1 = br.newContext();
        Page page1 = brc1.newPage();
        page1.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        //Select SINGLE-1 FILE Upload
        page1.setInputFiles("//input[@id='filesToUpload']",
                Paths.get("C:\\Users\\Hardik.Mehta\\Downloads\\generated_test_cases.xlsx"));
        String fileUploadMessage = page1.locator("//ul[@id='fileList']").textContent();
        System.out.println(fileUploadMessage);
        Thread.sleep(4000);
        page1.setInputFiles("//input[@id='filesToUpload']", new Path[0]);
        System.out.println("Upload file is unselected......");

        //Select MULTIPLE FILE Upload
        page1.setInputFiles("//input[@id='filesToUpload']",
                new Path[]{
                        Paths.get("C:\\Users\\Hardik.Mehta\\Downloads\\a3-2.jpg"),
                        Paths.get("C:\\Users\\Hardik.Mehta\\Downloads\\a4-2.jpg"),
                        Paths.get("C:\\Users\\Hardik.Mehta\\Downloads\\a5-2.jpg"),
                });
        String fileUploadMessage2 = page1.locator("//ul[@id='fileList']").textContent();
        System.out.println(fileUploadMessage2);

        //Run-time File-Upload


    }
}
