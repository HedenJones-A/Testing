package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// import dev.failsafe.internal.util.Assert;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

// import org.junit.Test;

public class Testing {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();

    }
    @Test
    public void test1()throws Exception{
        // System.out.println( "Hello World!" );
        // WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com/#");
        Thread.sleep(3000);
        
        WebElement category=driver.findElement(By.linkText("Laptops"));
        category.click();
        Thread.sleep(3000);

        WebElement laptop=driver.findElement(By.linkText("MacBook air"));
        laptop.click();
        Thread.sleep(3000);

        WebElement addtocart=driver.findElement(By.linkText("Add to cart"));
        addtocart.click();
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        WebElement cart=driver.findElement(By.linkText("Cart"));
        cart.click();
        Thread.sleep(3000);

        String title=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).getText();
        // String price=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[3]")).getText();
        // System.out.println(title+" : $"+price);
        Assert.assertTrue(title.contains("MacBook air"));
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//*[@id='login2']")).click();
        driver.findElement(By.xpath("//*[@id='loginusername']")).sendKeys("Testalpha");
        driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys("Test@123");
        driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();




    }
}
