package ScooterTests;
import Pages.OrderPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.openqa.selenium.By.cssSelector;

@RunWith(Parameterized.class)
public class PlaceOrderTest{
    WebDriver driver = new ChromeDriver();
//    WebDriver driver = new FirefoxDriver();

    final By buttonAddress;
    final String name;
    final String secondName;
    final String address;
    final String number;
    final String comment;

    public PlaceOrderTest(By buttonAddress, String name, String secondName, String address, String number, String comment) {
        this.buttonAddress = buttonAddress;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.number = number;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getPage() {
        return new Object[][] {
                {cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g"), "Маша", "Иванова", "Ленина 15", "89993331122", "спааать"},
                {cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"), "Андрей", "Базлов", "Вавилоав 93", "89993332211", "фррр"},
        };
    }

    @Test
    public void checkOrderForm() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.startPage();
        objOrderPage.findCheckAndClickOrderButton(buttonAddress);
        objOrderPage.coockiClose();
        objOrderPage.userName(name);
        objOrderPage.userSurname(secondName);
        objOrderPage.userAddress(address);
        objOrderPage.userPhone(number);
        objOrderPage.metroStation();
        objOrderPage.metroStationChoice();
        objOrderPage.nextPageButton();
        objOrderPage.calendarDate();
        objOrderPage.rentalDuration();
        objOrderPage.scooterColour();
        objOrderPage.userComment(comment);
        objOrderPage.orderButton();
        objOrderPage.confirmButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
