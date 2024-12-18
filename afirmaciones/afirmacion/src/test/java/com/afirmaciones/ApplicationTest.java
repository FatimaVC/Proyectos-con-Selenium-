package com.afirmaciones;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class ApplicationTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        assertEquals("Google", title, "El título de la página debería ser 'Google'");
    }

    @Test
    public void testGoogleLogoClass() {
        driver.get("https://www.google.com");
        WebElement logo = driver.findElement(By.cssSelector("img[alt=Google]"));
        String logoClass = logo.getAttribute("class");
        assertNotEquals("logo-class", logoClass, "La clase real es 'lnXdpd'");
    }

    @Test
    public void testSearchInputFirstSuggestion() {
        driver.get("https://www.google.com");
        // Localiza el campo de entrada de búsqueda y escribe "hotmail"
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("hotmail");
        // Espera hasta que la primera sugerencia del desplegable sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstSuggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox'] li:nth-child(1)")));
        // Verifica que la primera opción del desplegable sea "hotmail"
        String firstSuggestionText = firstSuggestion.getText();
        assertTrue(firstSuggestionText.toLowerCase().contains("hotmail"),
                "La primera opción del desplegable debería ser 'hotmail'");

    }

    @Test
    public void testBotonLogin(){
        driver.get("https://www.google.com/intl/es-419/gmail/about/");
        // Localiza el campo de entrada de búsqueda y escribe "hotmail"
        WebElement botonLogin = driver.findElement(By.cssSelector("a[data-label=header]"));
        String button = botonLogin.getAttribute("class");
        assertFalse(button.contains("btn-login"), "El botón tiene la clase 'btn-login'.");
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            // Espera 5 segundos antes de cerrar el navegador
            Thread.sleep(5000);
            driver.quit();
        }
    }
}