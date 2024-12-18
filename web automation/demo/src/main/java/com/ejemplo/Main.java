package com.ejemplo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Configuramos la propiedad
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chrome\\chromedriver.exe");
        // Crear una nueva instancia del navegador Chrome
        WebDriver driver = new ChromeDriver();
        // Abre Google
        driver.get("http://www.google.com");
        // Navega hacia GitHub
        driver.navigate().to("https://github.com/");
        // Retrocede en el historial del navegador (vuelve a Google)
        driver.navigate().back();
        // Avanza en el historial del navegador (vuelve a GitHub)
        driver.navigate().forward();
        // Cierra el navegador
        driver.quit();
    }
}