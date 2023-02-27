package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static Config.AppConfig.URL_HOME_PAGE;
import static org.openqa.selenium.By.*;

public class OrderPage {

    private final WebDriver driver;
    //кнопка "Да, все привыкли"
    private final By coocki = id("rcc-confirm-button");
    //поле ввода имени
    private final By inputName = xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    //поле ввода фамилии
    private final By inputSurname = xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    //поле ввода адреса
    private final By inputAddress = xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    //поле ввода телефона
    private final By inputTelNumber = xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    //поле выбора станции, раскрытие выпадающего списка
    private final By metroStation = xpath("//div[@class='Order_Form__17u6u']/div[4]");
    //поле выбора станции, выбор элемента списка
    private final By metroStationChoice = xpath("//div[@class='select-search__select']/ul/li/button/div[2]");
    //кнопка "Далее"
    private final By nextPageButton = xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //поле для ввода даты
    private final By calendarDate = xpath("//div[@class='Order_Form__17u6u']/div/div/div/input");
    //поле выбора периода аренды, раскрытие выпадающего списка
    private final By rentTime = xpath("//div[@class='Dropdown-control']");
    //поле выбора периода аренды, выбор элемента списка
    private final By rentalDurationChoice = xpath("//div[@class='Dropdown-menu']/div[2]");
    //выбор цвета для тестового набора
    private final By scooterColour = xpath("//div[@class='Order_Checkboxes__3lWSI']/label[1]");
    //поле ввода комментария
    private final By userComment = xpath("//div[@class='Input_InputContainer__3NykH']/input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //кнопка "Заказать"
    private final By orderButton = xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    //кнопка "Да"
    private final By confirmButton = xpath("//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");
    //Заказ оформлен
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // форматируем дату для поля
    String date = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату и прибавляем к ней 2 дня

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startPage() {
        driver.get(URL_HOME_PAGE);
    }
    public void findCheckAndClickOrderButton(By buttonAddress) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(buttonAddress));
        Object elementOrderButton = driver.findElement(buttonAddress);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementOrderButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(buttonAddress));
        driver.findElement(buttonAddress).click();
    }
    public void coockiClose(){
        driver.findElement(coocki).click();
    }
    public void userName(String name){
        driver.findElement(inputName).sendKeys(name);
    }
    public void userSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }
    public void userAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }
    public void userPhone(String phone) {
        driver.findElement(inputTelNumber).sendKeys(phone);
    }
    public void metroStation() {
        driver.findElement(metroStation).click();
    }
    public void metroStationChoice() {
        driver.findElement(metroStationChoice).click();
    }
    public void nextPageButton() {
        driver.findElement(nextPageButton).click();
    }
    public void calendarDate() {
        driver.findElement(calendarDate).click();
        driver.findElement(calendarDate).sendKeys(date);
        driver.findElement(calendarDate).sendKeys(Keys.ENTER);

    }
    public void rentalDuration() {
        driver.findElement(rentTime).click();
        driver.findElement(rentalDurationChoice).click();
    }
    public void scooterColour() {
        driver.findElement(scooterColour).click();
    }
    public void userComment(String comment) {
        driver.findElement(userComment).sendKeys(comment);
    }
    public void orderButton() {
        driver.findElement(orderButton).click();
    }
    public void confirmButton() {
        driver.findElement(confirmButton).click();
    }


}

