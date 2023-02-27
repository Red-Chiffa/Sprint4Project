package ScooterTests;
import Config.AppConfig;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.id;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class FAQTest {

 //  WebDriver driver;
    private final By coocki = id("rcc-confirm-button");
    private final String question;
    private final String answer;
    private static final String question1 = "accordion__heading-0";
    //ответ: Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private static final String answer1 = "accordion__panel-0";

    //Хочу сразу несколько самокатов! Так можно?
    private static final String question2 = "accordion__heading-1";

    //ответ: Пока что у нас так: один заказ — один самокат.
    //Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private static final String answer2 = "accordion__panel-1";

    //Как рассчитывается время аренды?
    private static final String question3 = "accordion__heading-2";

    //ответ: Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня.
    //Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.
    //Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private static final String answer3 = "accordion__panel-2";

    //Можно ли заказать самокат прямо на сегодня?
    private static final String question4 = "accordion__heading-3";

    //ответ: Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private static final String answer4 = "accordion__panel-3";

    //Можно ли продлить заказ или вернуть самокат раньше?
    private static final String question5 = "accordion__heading-4";

    //ответ: Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private static final String answer5 = "accordion__panel-4";

    //Вы привозите зарядку вместе с самокатом?
    private static final String question6 = "accordion__heading-5";

    //ответ: Самокат приезжает к вам с полной зарядкой.
    //Этого хватает на восемь суток — даже если будете кататься без передышек и во сне.
    //Зарядка не понадобится.
    private static final String answer6 = "accordion__panel-5";

    //Можно ли отменить заказ?
    private static final String question7 = "accordion__heading-6";

    //ответ:Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private static final String answer7 = "accordion__panel-6";

    //Я жизу за МКАДом, привезёте?
    private static final String question8 = "accordion__heading-7";

    //ответ: Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private static final String answer8 = "accordion__panel-7";
    WebDriver driver = new ChromeDriver();
//    WebDriver driver = new FirefoxDriver();
    public FAQTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    @Before
    public void setUp() {
      //  WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.URL_HOME_PAGE);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));

   }

   @Parameterized.Parameters
   public static Object[][] getTestData () {
       return new Object[][]{
           {question1, answer1},
           {question2, answer2},
           {question3, answer3},
           {question4, answer4},
           {question5, answer5},
           {question6, answer6},
           {question7, answer7},
           {question8, answer8}
       };
   }
            //проверка вопросов о важном: при клике на вопрос ответ становится видимым
   @Test
   public void checkAnswersIsDisplayed () {

         new WebDriverWait(driver, Duration.ofSeconds(3))
               .until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));


       driver.findElement(coocki).click();
       WebElement element = driver.findElement(By.id(question));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
       element.click();

       assertTrue(driver.findElement(By.id(answer)).isDisplayed());
   }
   @After
   public void tearDown() {
        driver.quit();
   }
}


