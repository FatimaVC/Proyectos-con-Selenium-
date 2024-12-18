package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAlert() {
        // Navegar hacia la página
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

        // Cambiar al iframe donde está el botón "Try it"
        driver.switchTo().frame("iframeResult");

        // Hacer clic en el botón "Try it"
        driver.findElement(By.tagName("button")).click();

        // Manejar la alerta, ingresar texto y aceptar
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Fátima");
        alert.accept();

        // Verificar que el texto ingresado aparece en la página
        String result = driver.findElement(By.id("demo")).getText();
        Assertions.assertTrue(result.contains("Fátima"), "El texto no se actualizó correctamente.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
