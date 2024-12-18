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
           
          // Abrir la página de Wikipedia
          driver.get("https://www.wikipedia.org");
  
          // Encuentra el primer elemento por su ID y haz clic en él
          WebElement searchInput= driver.findElement(By.name("search"));
          // Reemplaza "el parametro" con el ID real
          searchInput.sendKeys("Prueba");
  
          // Cierra el navegador
          driver.quit(); 
    }
}