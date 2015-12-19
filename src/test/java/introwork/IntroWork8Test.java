package introwork;

import core.ChromeDriverTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

/**
 * 入門課題その8:「画面下のボタンまでスクロールしてみよう」
 */
public class IntroWork8Test extends ChromeDriverTest {
    @Test
    public void testClickOKButton() throws Exception {
        File html = new File("introwork/introWork8.html");
        String url = html.toURI().toString();
        driver.get(url);

        // TODO 以下を削除して、代わりに「Last」ボタンまでスクロールする処理を記述してください
        Actions actions = new Actions(driver);
        WebElement webelement = driver.findElement(By.id("last_button"));
        actions.moveToElement(webelement);
        actions.perform();
        Thread.sleep(8000);
        // TODO ここまで削除してください
    }
}
