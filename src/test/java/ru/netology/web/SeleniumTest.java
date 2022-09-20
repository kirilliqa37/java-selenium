package ru.netology.web;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.By.cssSelector;




public class SeleniumTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();

    }
    @BeforeEach
    void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    @AfterEach
    void teardown() {
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
        driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+79998887766");
        driver.findElement(cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(cssSelector("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id= 'order-success']")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV2() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        //driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
        driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+79998887766");
        driver.findElement(cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(cssSelector("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector(".input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV3() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
        //driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+79998887766");
        driver.findElement(cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(cssSelector("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector(".input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV4() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
        driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+79998887766");
        driver.findElement(cssSelector("button")).click();
        String expected = "Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй";
        String actual = driver.findElement(By.cssSelector(".input_invalid ")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV5() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("button")).click();
        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector(".input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV6() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Ivanov Ivan");
        driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+79998887766");
        driver.findElement(cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(cssSelector("button")).click();
        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String actual = driver.findElement(By.cssSelector(".input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }
    @Test
    void shouldTestV7() {
        driver.get("http://localhost:9999/");
        WebElement form = driver.findElement(cssSelector("form"));
        driver.findElement(cssSelector("[data-test-id='name'] input")).sendKeys("Иванов Иван");
        driver.findElement(cssSelector("[data-test-id='phone'] input")).sendKeys("+7999888776");
        driver.findElement(cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(cssSelector("button")).click();
        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String actual = driver.findElement(By.cssSelector(".input_invalid .input__sub")).getText().trim();
        assertEquals(expected, actual);
    }

}