import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTestTask04 {
    @Test
    public void browserTest() throws InterruptedException {
        // эта строка нужна для того, чтобы в переменные операционной системы прописать путь к переменной
        // "webdriver.edge.driver"  - edge - это название браузера в котором будет открывать страницу
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\Desktop\\ВидеоGB\\Unit-Тесты\\Seminar\\5\\TestDrivers\\msedgedriver.exe");
        // создаём экземпляр класса WebDriver - new EdgeDriver() - это значит что будет создан webDriver типа new EdgeDriver()
        // для браузера Edge
        // WebDriver webDriver - Нужен для того, чтобы контактировать с браузером
        WebDriver webDriver = new EdgeDriver();
        // метод .get говорит, чтобы через заданный браузер открыли сайт гугла
        webDriver.get("https://google.com");
        // после запроса .get мы получаем в ответ HTML разметку веб-элементов. Нам нужно отделить элементы (какие нас интересуют)
        // ищем необходимый элемент (поисковая строка) по признаку (имя)
        WebElement searchBox = webDriver.findElement(By.name("q"));
        // найдя нужный элемент (поисковая строка), вбиваем текст
        // .sendKeys отправляем набор символов ("Selenium") в поисковую строку
        searchBox.sendKeys("Selenium");
        // .submit() - этот метод эмулирует нажатие ЭНТЕРа
        searchBox.submit();
        // мы хотим найти элементы по селектору с тегом "div", но т.к. элементов будет много и их надо будет перебрать все,
        // что будут вытащены с веб-страницы, занесём их в список
        // т.к. тут элементов много, то указываем - .findElements (в конце s !!!!)
        List<WebElement> searchResult = webDriver.findElements(By.cssSelector("div"));
        boolean isFind = false; // задаём переменную
        for (WebElement element: searchResult ) {
            if (element.getText().contains("https://www.selenium.dev")){
                isFind = true;
                break;
            }
        }
        // закрываем сессию
        webDriver.quit();
        assertTrue(isFind);
    }
}
