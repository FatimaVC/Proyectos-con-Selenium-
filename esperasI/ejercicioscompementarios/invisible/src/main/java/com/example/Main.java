package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static void main(String[] args) {
         // Configuramos la propiedad
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
            
         // Crear una nueva instancia del navegador Chrome
         WebDriver driver = new ChromeDriver();
         
         // Maximizar la ventana del navegador
         driver.manage().window().maximize();

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

         // Abrir la página de Google y esperar a que aparezca el cuadro de búsqueda
         driver.get("https://www.google.com.pe");
         
         // Abrir la página de netflix
         driver.navigate().to("https://cyzone.tiendabelcorp.com.pe/?utmi_cp=GlowArtperu");
         WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=Estoy buscando...]")));
         search.click();
    }
}