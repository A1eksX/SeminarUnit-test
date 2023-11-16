import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // эта строка нужна для того, чтобы в переменные операционной системы прописать путь к переменной
        // "webdriver.edge.driver"  - edge - это название браузера в котором будет открывать страницу
        System.setProperty("webdriver.edge.driver", "C:\\Users\\1\\Desktop\\ВидеоGB\\Unit-Тесты\\Seminar\\5\\TestDrivers\\msedgedriver.exe");
        // создаём экземпляр класса WebDriver - new EdgeDriver() - это значит что будет создан webDriver типа new EdgeDriver()
        // для браузера Edge
        // WebDriver webDriver - Нужен для того, чтобы контактировать с браузером
        WebDriver webDriver = new EdgeDriver(); // ChromeDriver();
        // метод .get говорит, чтобы через заданный браузер открыли сайт гугла
        webDriver.get("https://google.com");
        // после запроса .get мы получаем в ответ HTML разметку веб-элементов. Нам нужно отделить элементы, кто нас интересуют
        // ищем необходимый элемент (поисковая строка) по признаку (имя)
        WebElement searchBox = webDriver.findElement(By.name("q"));
        // найдя нужный элемент (поисковая строка), вбиваем текст
        // .sendKeys отправляем набор символов ("GeekBrains") в поисковую строку
        searchBox.sendKeys("GeekBrains");
        // .submit() - этот метод эмулирует нажатие ЭНТЕРа
        searchBox.submit();
        // вызываем поток, который "Фризит" на 10 секунд
        Thread.sleep(10000);
        // .quit() - завершает сессию(закрывает браузер)
        // .quit() - ВСЕГДА ОБЯЗАТЕЛЬНО прописывать когда работаешь с файлами, потоками...
        webDriver.quit();
    }


}
