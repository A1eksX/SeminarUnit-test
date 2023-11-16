import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.assertj.core.api.Assertions.*;

/**
 * Нужно написать сквозной тест с использованием Selenium, который авторизует пользователя
 * на сайте https://www.saucedemo.com/.
 * Данные для входа - логин: "standard_user", пароль: "secret_sauce".
 * Проверить, что авторизация прошла успешно и отображаются товары.
 * Вам необходимо использовать WebDriver для открытия страницы и методы sendKeys() для ввода данных в поля формы,
 * и submit() для отправки формы. После этого, проверьте, что на странице отображаются продукты (productsLabel.getText() = "Products").
 */
public class SeleniumTask05Test {
    @Test
    public void testAuthorizztion(){
        String login = "standard_user";
        String password = "secret_sauce";

        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\Desktop\\ВидеоGB\\Unit-Тесты\\Seminar\\5\\TestDrivers\\msedgedriver.exe");
        WebDriver webDriver = new EdgeDriver();
        webDriver.get("https://www.saucedemo.com/");

        WebElement loginBox = webDriver.findElement(By.id("user-name"));
        loginBox.sendKeys(login);

        WebElement passwordBox = webDriver.findElement(By.id("password"));
        passwordBox.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click(); // .click() имитирует нажатие клавиши мыши

        // Ищем элемент HTML кода, где есть класс(class) "title"
        WebElement productLabel = webDriver.findElement(By.className("title"));
        String findText = productLabel.getText(); // из класса (class = "title") - <span class="title">Products</span>
        //  в переменную findText запишется значение этого класса, а именно "Products"
        // из класса, при помощи .getText() вытаскиваем текст "Products"

        webDriver.quit();  // закрываем браузер
        assertThat(findText).isEqualTo("Products");

    }
}
