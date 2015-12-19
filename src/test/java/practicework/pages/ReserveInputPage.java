package practicework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReserveInputPage {
    private final WebDriver driver;
    private final By reserveYear = By.id("reserve_year");
    private final By reserveMonth = By.id("reserve_month");
    private final By reserveDay = By.id("reserve_day");
    private final By reserveTerm = By.id("reserve_term");
    private final By goToNext = By.id("goto_next");
    //ここから追記
    private final By datePick = By.id("datePick");
    private final By headCount = By.id("headcount");
    private final By breakfastOn = By.id("breakfast_on");
    private final By breakfastOff = By.id("breakfast_off");
    private final By planA = By.id("plan_a");
    private final By planB = By.id("plan_b");
    private final By customerName = By.id("guestname");
    private final By nextPage = By.id("goto_next");
    private final By agree = By .id("agree_and_goto_next");
    //ここまで追記
    public ReserveInputPage(WebDriver driver) {
        this.driver = driver;
    }

    private void setReserveYear(String value) {
        WebElement element = driver.findElement(reserveYear);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveMonth(String value) {
        WebElement element = driver.findElement(reserveMonth);
        element.clear();
        element.sendKeys(value);
    }

    private void setReserveDay(String value) {
        WebElement element = driver.findElement(reserveDay);
        element.clear();
        element.sendKeys(value);
    }
    
    public void setReserveDate(String year, String month, String day) {
        WebElement element = driver.findElement(datePick);
        element.clear();
        element.sendKeys(year + "/" + month + "/" + day);
        element.sendKeys(Keys.RETURN);
    }

    public void setReserveTerm(String value) {
        WebElement element = driver.findElement(reserveTerm);
        element.clear();
        element.sendKeys(value);
    }
    public void setPerson(String value){
        WebElement element = driver.findElement(headCount);
        element.clear();
        element.sendKeys(value);
    }
    public void setBreakfast(Boolean on){
        if(on){
            WebElement element = driver.findElement(breakfastOn);
            element.click();
        }else{
            WebElement element = driver.findElement(breakfastOff);
            element.click();
        }
    }
    public void outBreakfast(){
        WebElement element = driver.findElement(breakfastOff);
        element.click();
    }
    public void setPlanA(){
        WebElement plan = driver.findElement(planA);
        if(!plan.isSelected()){
            plan.click();
        }
    }

    public void setPlanB(){
        WebElement plan = driver.findElement(planB);
        if(!plan.isSelected()){
            plan.click();
        }
    }
    public void setName(String value){
        WebElement input = driver.findElement(customerName);
        input.clear();
        input.sendKeys(value);
    }
    public  ReserveConfirmPage setAgree(){
        WebElement plan = driver.findElement(agree);
        if(!plan.isSelected()){
            plan.click();
        }
        return new ReserveConfirmPage(driver);
    }


    public ReserveConfirmPage goToNext() {
        driver.findElement(goToNext).click();
        return new ReserveConfirmPage(driver);
    }
}
