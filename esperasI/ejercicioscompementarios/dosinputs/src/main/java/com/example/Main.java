package com.example;

import org.openqa.selenium.By;
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
        
        // Abrir la página de netflix
        driver.get("https://www.netflix.com/login");

        /* Intentar encontrar el botón "Iniciar Sesión"
        WebElement email = driver.findElement(By.id(":r0:"));
        email.sendKeys("ana@hotmail.com"); */

        // Intentar encontrar el input "Email"
        WebElement email = driver.findElement(By.cssSelector("[data-uia=login-field]"));
        email.sendKeys("ana@hotmail.com");
    
        // Intentar encontrar el segundo input "Contraseña"
        WebElement password = driver.findElement(By.cssSelector("[data-uia=password-field]"));
        password.sendKeys("SegundoElementoEncontrado");
    }
    
}