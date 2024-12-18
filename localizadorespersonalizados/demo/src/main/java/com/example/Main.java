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
         
        // Abrir la página de Google
        driver.get("https://www.google.com");

        // Localizar el elemento por TAG + Id y enviar texto
        WebElement tagId = driver.findElement(By.cssSelector("textarea#APjFqb"));
        tagId.sendKeys("hello world");

    }
}