package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws Exception {
        driver.get("https://www.moneycontrol.com/");
        // Thread.sleep(2000);
        driver.findElement(By.linkText("moneycontrol.com")).click();
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.name("search_str")).sendKeys("Reliance Industres");
        Thread.sleep(3000);
        WebElement reliance=driver.findElement(By.xpath("//*[@id='autosuggestlist']/ul/li[1]/a"));
        reliance.click();

        WebElement mutual=driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/a"));
        Thread.sleep(2000);
        Actions action=new Actions(driver);
        Thread.sleep(1000);
        action.moveToElement(mutual).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='common_header']/div[1]/div[3]/nav/div/ul/li[10]/div/div/ul/li[2]/ul/li[5]/a")).click();
        // driver.findElement(By.linkText("SIP Return")).click();
        // Any test assertions or verifications can be added here
        JavascriptExecutor scroll=(JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,250)");
        WebElement sel1=driver.findElement(By.xpath("//select[@id='ff_id']"));
        Select sel=new Select(sel1);
        sel.selectByVisibleText("Axis Mutual Fund");
        
        scroll.executeScript("window.scrollBy(0,250)");
        WebElement sel2=driver.findElement(By.xpath("//*[@id='im_id']"));
        Select sele1=new Select(sel2);
        sele1.selectByVisibleText("Axis Arbitrage Fund - Direct Plan (D)");
        
        scroll.executeScript("window.scrollBy(0,250)");
        WebElement sel3=driver.findElement(By.xpath("//*[@id='im_id']"));
        Select sele2=new Select(sel3);
        sele2.selectByVisibleText("Axis Arbitrage Fund - Direct Plan (D)");
        
        driver.findElement(By.xpath("//*[@id='invamt']")).sendKeys("100000");
        driver.findElement(By.xpath("//*[@id='stdt']")).sendKeys("2021-08-02");
        driver.findElement(By.xpath("//*[@id='endt']")).sendKeys("2023-08-17");
        driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[2]/div/div[3]/div[2]/div[2]/form/div[8]/input")).click();;
        
        // Select sel1=new Select(driver);


    }

    @AfterTest
    public void afterTest() {
        // driver.quit();
    }
}
