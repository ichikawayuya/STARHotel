package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReserveConfirmPage {
    private final WebDriver driver;
    private final By price = By.id("price");
    private final By dateFrom = By.id("datefrom");
    private final By dateTo = By.id("dateto");
    private final By daysCount = By.id("dayscount");
    private final By headCount = By.id("hc");
    private final By breakfast = By.id("bf_order");
    //private final By breakfastOff = By.id("breakfast_off");
    private final By planA = By.id("plan_a_order");
    private final By planB = By.id("plan_b_order");
    private final By customerName = By.id("gname");
    private final By commit = By.id("commit");
    private final By bfOrder = By.id("bf_order");

    public ReserveConfirmPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getPrice() {
        return driver.findElement(price).getText();
    }
    
    public String getDateFrom() {
        return driver.findElement(dateFrom).getText();
    }

    public String getDateTo() {
        return driver.findElement(dateTo).getText();
    }
    
    public String getDaysCount() {
        return driver.findElement(daysCount).getText();
    }
    //ここから記述
    public String getPerson() {
        return driver.findElement(headCount).getText();
    }
    public boolean existsPlanA() {
        return driver.findElements(planA).size() > 0;
    }
    public String getPlanA(){
        return driver.findElement(planA).getText();
    }
    public boolean existsPlanB(){
        return driver.findElements(planB).size() > 0;
    }

    public String getPlanB(){
         return driver.findElement(planB).getText();
        }

    public String getName(){
        return driver.findElement(customerName).getText();
    }
    public void commit() {
        driver.findElement(commit).click();
    }
    public String getBreakfast() {
        return driver.findElement(bfOrder).getText();
    }

}
