package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
        // Configuramos la propiedad
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
        
        // Crear una instancia de ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Crear una instancia de WebDriver con las opciones configuradas
        WebDriver driver = new ChromeDriver(options);
        // Cast the WebDriver instance to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

        // Maximizar la ventana del navegador
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            // Abrir la página de Wikipedia
            driver.get("https://www.google.com/intl/es-419/gmail/about/");
            // Localizar y hacer clic en los elementos por ID
            WebElement acceder_btn = driver.findElement(By.partialLinkText("Acceder"));
            safeClick(driver, acceder_btn);
            // Esperar unos segundos para que la página cargue completamente
            Thread.sleep(2000);
            // Localizar un input por su atributo 'id' y escribir texto
            WebElement correoInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
            safeSendKeys(driver, correoInput, "melisaa562@gmail.com");
            correoInput.sendKeys(Keys.ENTER);
            // Esperar unos segundos para que la página cargue completamente
            Thread.sleep(4000);
            // Localizar un input por su atributo 'name' y escribir texto
            WebElement passInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("Passwd")));
            safeSendKeys(driver, passInput, "1011200");
            passInput.sendKeys(Keys.ENTER);

            // Navegar a Wikipedia
            driver.navigate().to("https://www.wikipedia.org/");
            // Localizar un input por su atributo 'id' y escribir texto
            WebElement searchInput = driver.findElement(By.id("searchInput"));
            safeSendKeys(driver, searchInput, "elemento quimico");
            searchInput.sendKeys(Keys.ENTER);
            // Esperar unos segundos para que la página cargue completamente
            Thread.sleep(2000);
            // Localizar un botón por su atributo 'text' y hacer clic en él
            WebElement element = driver.findElement(By.partialLinkText("Hidrógeno"));
            safeClick(driver, element);

            // Esperar unos segundos para que la página cargue completamente
            Thread.sleep(3000);
            // Navegar al diccionario de la RAE
            driver.navigate().to("https://www.rae.es/");
            // Localizar un input por su atributo 'id' y escribir texto
            WebElement searchInput2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("termino2")));
            safeSendKeys(driver, searchInput2, "fe");
            driver.findElement(By.id("edit-submit")).click();

        } catch (Exception e) {
            System.out.println("No se pudieron encontrar todos los elementos: " + e.getMessage());
        } finally {
            System.out.println("El programa ha finalizado");
            // Cerrar el navegador
            driver.quit();
        }

    }

    private static void safeClick(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    private static void safeSendKeys(WebDriver driver, WebElement element, String keys) {
        try {
            element.sendKeys(keys);
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(keys);
        }
    }
}



