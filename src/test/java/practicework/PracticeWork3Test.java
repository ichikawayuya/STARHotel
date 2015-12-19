package practicework;

import core.ChromeDriverTest;
import org.junit.Before;
import org.junit.Test;
import practicework.pages.ReserveConfirmPage;
import practicework.pages.ReserveInputPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PracticeWork3Test extends ChromeDriverTest {
    @Before
    public void setUp() {
        super.setUp();
        // ページ遷移の際に少し待機するため
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testReserveWith1Member() throws InterruptedException {
        File html = new File("reserveApp_Renewal/index.html");
        String url = html.toURI().toString();
        driver.get(url);
        
        ReserveInputPage inputPage = new ReserveInputPage(driver);
        inputPage.setReserveDate("2015", "12", "20"); // TODO 明日以降直近の日曜日に変更してください
//        inputPage.setReserveTerm("3");


        // TODO 残りの処理を記述してください
        inputPage.setBreakfast(false);
        //inputPage.outBreakfast();
        //inputPage.setPlanA();
        inputPage.setPlanB();
        String name = "市川裕也";
        inputPage.setName(name);
        //inputPage.setAgree();
        Thread.sleep(5000);
        //ReserveConfirmPage confirmPage = inputPage.goToNext();

        ReserveConfirmPage confirmPage =  inputPage.setAgree();
        // 2ページ目入力画面
        //Thread.sleep(8000);
        assertThat(confirmPage.getPrice(), is("9750"));
        assertThat(confirmPage.getDateFrom(), is("2015年12月20日")); // TODO 変更してください
        assertThat(confirmPage.getDateTo(), is("2015年12月21日")); // TODO 変更してください
        assertThat(confirmPage.getDaysCount(), is("1"));
        assertThat(confirmPage.existsPlanA(), is(false));
        //assertThat(confirmPage.getPlanA(), is("昼からチェックインプラン"));
        assertThat(confirmPage.existsPlanB(), is(true));
        assertThat(confirmPage.getName(), is(name));
        confirmPage.commit();

        // TODO 残りの処理を記述してください
    }
}
