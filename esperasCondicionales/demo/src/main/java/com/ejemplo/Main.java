package com.ejemplo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Main {
    public static void main(String[] args) {
          // Configuramos la propiedad
          System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
          // Crear una nueva instancia del navegador Chrome
          WebDriver driver = new ChromeDriver();
          // Abre Google
          driver.get("http://www.google.com");
          // Maximizar pantalla
          driver.manage().window().maximize();
          // Navegar a Wikipedia
          driver.navigate().to("https://es.wikipedia.org");
          // Configurar tiempo de espera fuido
          Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
          .withTimeout(Duration.ofSeconds(10))
          .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
          WebElement buscarInfo = wait.until(e -> e.findElement(By.cssSelector("input.cdx-text-input__input")));
          buscarInfo.sendKeys("programar",Keys.ENTER);
          
    }    
}