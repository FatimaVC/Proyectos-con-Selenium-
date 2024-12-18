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
          WebElement firstElement= driver.findElement(By.id("js-link-box-en"));
          // Reemplaza "el parametro" con el ID real
          firstElement.click();

          // Navegar a GitHub
          driver.navigate().to("https://github.com/");
          
          // Localizar un input por su atributo 'name' y escribir texto
          WebElement searchInput = driver.findElement(By.name("user_email"));
          searchInput.sendKeys("Mail de prueba para Selenium");

          // Localizar un input por su atributo 'textlink' y hacer click
          WebElement signUpButton = driver.findElement(By.partialLinkText("Signup"));
          signUpButton.click();

          // Cierra el navegador
          driver.quit(); 
    }
}