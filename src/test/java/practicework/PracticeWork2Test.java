package practicework;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import practicework.pages.ReserveConfirmPage;
import practicework.pages.ReserveInputPage;
import core.ChromeDriverTest;

public class PracticeWork2Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testReserveWith9MmebersUsingPageObject() throws Exception {
        File html = new File("reserveApp_Renewal/index.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        // 1ページ目入力画面
        ReserveInputPage inputPage = new ReserveInputPage(driver);
        inputPage.setReserveDate("2015", "12", "26");  // TODO 明日以降直近の土曜日に変更してください
        inputPage.setReserveTerm("1");
        inputPage.setPerson("9");

        inputPage.setBreakfast(true);
        //inputPage.outBreakfast();
        inputPage.setPlanA();
        inputPage.setPlanB();
        String name = "市川裕也";
        inputPage.setName(name);



        // TODO 残りの処理を記述してください

        ReserveConfirmPage confirmPage = inputPage.goToNext();
        Thread.sleep(8000);
        // 2ページ目入力画面
        assertThat(confirmPage.getPrice(), is("105750"));
        assertThat(confirmPage.getDateFrom(), is("2015年12月26日")); // TODO 変更してください
        assertThat(confirmPage.getDateTo(), is("2015年12月27日")); // TODO 変更してください
        assertThat(confirmPage.getDaysCount(), is("1"));
        //ここから記述
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.getPerson(), is("9"));
        assertThat(confirmPage.getPlanA(), is("昼からチェックインプラン"));
        assertThat(confirmPage.getName(), is(name));


        // TODO 残りの処理を記述してください
    }
}
