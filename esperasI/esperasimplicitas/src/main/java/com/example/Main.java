package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
            // Configuramos la propiedad
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
            
            // Crear una nueva instancia del navegador Chrome
            WebDriver driver = new ChromeDriver();
            
            // Maximizar la ventana del navegador
            driver.manage().window().maximize();
             
            // Abrir la página de google
            driver.get("https://www.google.com.pe");
    
            // Configurar tiempo de espera implícito
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Navegar a LinkedIn
            driver.navigate().to("https://pe.linkedin.com/");

            // Intentar encontrar el botón "Iniciar Sesión"
            WebElement signInButton = driver.findElement(By.cssSelector("a[data-tracking-control-name=guest_homepage-basic_nav-header-signin]"));
            signInButton.click();

            // Configurar tiempo de espera implícito
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            
            // Navegar a Github
            driver.navigate().to("https://github.com/login");

            // Intentar encontrar el botón "Iniciar Sesión"
            WebElement emailInput = driver.findElement(By.id("login_field"));
            emailInput.sendKeys("mailprueba");
            
            // Navegar a Wikipedia
            driver.navigate().to("https://es.wikipedia.org");
            WebElement buscarInfo = driver.findElement(By.cssSelector("input.cdx-text-input__input"));
            buscarInfo.sendKeys("programar",Keys.ENTER);

            
        }
}