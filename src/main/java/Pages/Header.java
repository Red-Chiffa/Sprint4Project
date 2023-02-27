package Pages;

import org.openqa.selenium.By;

public class Header {
    // кнопка Яндекс левый верхний угол страницы
    private final By headerLogoYandexButton = By.className("Header_LogoYandex__3TSOI");

    //кнопка самокат левый верхний угол страницы, справа от кнопки Яндекс
    private final By headerLogoScooterButton = By.className("Header_LogoScooter__3lsAR");

    // кнопка Заказать правый верхний угол, слева от кнопки  Статус заказа
    private final By headerOrderButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");

    //кнопка Статус заказа правый верхний угол
    private final By headerOrderStatusButton = By.className("Header_Link__1TAG7");
    //поле ввода номера заказа правый верхний угол, слева от кнопки Go!
    private final By inputOrderNumber = By.className("Input_Input__1iN_Z Header_Input__xIoUq");

    //кнопка "Go!" правый верхний угол
    private final By goButton = By.className("Button_Button__ra12g Header_Button__28dPO");
}
