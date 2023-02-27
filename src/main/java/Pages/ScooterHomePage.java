package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;


public class ScooterHomePage {
    private final WebDriver driver;

    //кнопка "Заказать" под цепочкой статусов заказа
    private final By orderButton = className("Button_Button__ra12g Button_UltraBig__UU3Lp");
    //Вопросы о важном:
    //Сколько это стоит? И как оплатить?
    private final By question1 = id("accordion__heading-0");
    //ответ: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private final By answer1 = id("accordion__panel-0");

    //Хочу сразу несколько самокатов! Так можно?
    private final By question2 = id("accordion__heading-1");

    //ответ: Пока что у нас так: один заказ — один самокат.
    //Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private final By answer2 = id("accordion__panel-1");

    //Как рассчитывается время аренды?
    private final By question3 = id("accordion__heading-2");

    //ответ: Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня.
    //Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.
    //Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private final By answer3 = id("accordion__panel-2");

    //Можно ли заказать самокат прямо на сегодня?
    private final By question4 = id("accordion__heading-3");

    //ответ: Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private final By answer4 = id("accordion__panel-3");

    //Можно ли продлить заказ или вернуть самокат раньше?
    private final By question5 = id("accordion__heading-4");

    //ответ: Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private final By answer5 = id("accordion__panel-4");

    //Вы привозите зарядку вместе с самокатом?
    private final By question6 = id("accordion__heading-5");

    //ответ: Самокат приезжает к вам с полной зарядкой.
    //Этого хватает на восемь суток — даже если будете кататься без передышек и во сне.
    //Зарядка не понадобится.
    private final By answer6 = id("accordion__panel-5");

    //Можно ли отменить заказ?
    private final By question7 = id("accordion__heading-6");

    //ответ:Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private final By answer7 = id("accordion__panel-6");

    //Я жизу за МКАДом, привезёте?
    private final By question8 = id("accordion__heading-7");

    //ответ: Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private final By answer8 = id("accordion__panel-7");

   public ScooterHomePage(WebDriver driver) {
            this.driver = driver;
    }


    //проверка что при нажатии на кнопку заказать (под цепочкой статуса заказа) переход на страницу заказа
    public void jumpToOrderPage(){
        driver.findElement(orderButton).click();
        String expected = "https://qa-scooter.praktikum-services.ru/";
        String actual = driver.getCurrentUrl();
        assertEquals(expected, actual);
    }

}
