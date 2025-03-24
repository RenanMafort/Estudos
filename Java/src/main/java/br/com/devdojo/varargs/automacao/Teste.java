//package br.com.devdojo.varargs.automacao;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Teste {
//    public static void main(String[] args) {
//        // Configurar o WebDriver (neste exemplo, usando o Chrome)
//        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\driver1\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        // Abrir o Google
//        driver.get("https://www.google.com");
//
//        // Localizar o elemento da barra de pesquisa
//        driver.findElement(By.name("q")).sendKeys("Exemplo de pesquisa");
//
//        // Enviar a pesquisa
//        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
//
//        // Fechar o WebDriver
//        driver.quit();
//    }
//}
