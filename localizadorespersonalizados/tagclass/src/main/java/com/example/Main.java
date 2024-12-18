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
         
        // Abrir la página de Tiendamia
        driver.get("https://tiendamia.com/pe/");

        // Localizar el elemento por TAG + clase y enviar texto
        WebElement tagClass = driver.findElement(By.cssSelector("a.solo_ar"));
        tagClass.click();

        driver.navigate().to("https://www.google.com.pe");

         // Localizar el elemento por TAG + atributo y enviar texto
        WebElement tagClassAtrib = driver.findElement(By.cssSelector("a[target=_top]"));
        tagClassAtrib.click();

        driver.navigate().to("https://pe.linkedin.com");
        
         // Localizar el elemento por TAG + clase + atributoy enviar texto
        WebElement tagClassAtributo = driver.findElement(By.cssSelector("input.text-color-text[autocomplete =current-password]"));
        tagClassAtributo.sendKeys("hello");
    }
}