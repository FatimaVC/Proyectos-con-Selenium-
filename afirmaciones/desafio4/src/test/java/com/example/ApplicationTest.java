package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

class ApplicationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testClearButtonAppearsInSearch() {
        driver.get("https://www.google.com");
        // Escribe algo en el campo de búsqueda
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");

        // Ahora busca el botón de borrar
        WebElement clearButton = driver.findElement(By.cssSelector("[aria-label='Borrar']"));
        // Verificar que el botón de "x" para borrar el texto esté presente
        assertTrue(clearButton.isDisplayed(), "La cruz de borrado debería aparecer cuando hay texto.");
        // Hacer clic en la "x" para borrar el texto
        clearButton.click();

    }

    @Test
    public void testSocialMediaLinksInFooter() {
        driver.get("https://www.mozilla.org");
        List<WebElement> socialMediaIcons = driver.findElements(By.cssSelector("footer a.social-icon"));
        assertEquals(0, socialMediaIcons.size(), "No hay exactamente 6 íconos de redes sociales.");
    }

    @Test
    public void testSearchBarAndSuggestions() {
        driver.get("https://www.bing.com");
          // Verificar la presencia de la barra de búsqueda
          WebElement searchBar = driver.findElement(By.name("q"));
          assertTrue(searchBar.isDisplayed(), "La barra de búsqueda está presente.");
  
          // Click en la barra de búsqueda para mostrar las sugerencias
          searchBar.click();
  
          // Esperar a que aparezcan las sugerencias (puede variar el selector, ajusta si es necesario)
          WebElement suggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sa_sg")));
  
          // Verificar que las sugerencias sean visibles
          assertTrue(suggestions.isDisplayed(), "Las sugerencias están visibles después de hacer clic.");
    }

    @Test
    public void testStaySignedInCheckboxIsChecked() {
        driver.get("https://login.yahoo.com/");
        WebElement staySignedInCheckbox = driver.findElement(By.id("persistent"));
        assertTrue(staySignedInCheckbox.isSelected(), "El checkbox 'Permanecer Conectado' no está marcado.");
    }

    @AfterEach
     public void tearDown() {
       if (driver != null) {
           driver.quit();
        }
    }

}
