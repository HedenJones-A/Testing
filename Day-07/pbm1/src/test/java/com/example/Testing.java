package com.example;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
// import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {

    @Test
public void test1() throws Exception {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://economictimes.indiatimes.com/?from=mdr");
    driver.manage().window().maximize();
    Thread.sleep(3000);

    WebElement mutualfunds = driver.findElement(By.linkText("Mutual Funds"));
    mutualfunds.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,250)", "");

    WebElement dropdown1 = driver.findElement(By.name("amc"));
    dropdown1.click();
    Select sel1 = new Select(dropdown1);
    sel1.selectByVisibleText("Canara Robeco");

    Thread.sleep(2000);
    WebElement dropdown2 = driver.findElement(By.name("schemenm"));
    dropdown2.click();
    Select sel2 = new Select(dropdown2);
    sel2.selectByVisibleText("Canara Robeco Bluechip Equity Direct-G");

    WebElement button = driver.findElement(By.linkText("Get Details"));
    button.click();
    Thread.sleep(5000);

    // Switching to the newly opened tab
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1)); // Switching to the second tab

    WebElement installment = driver.findElement(By.xpath("//*[@id='installment_type']/li"));
    System.out.println(driver.getCurrentUrl());
    installment.click();
    driver.findElement(By.xpath("//*[@id='installment_type']/li/ul/li[1]")).click();

    WebElement instamt = driver.findElement(By.xpath("//*[@id='installment_amt']/li"));
    System.out.println(driver.getCurrentUrl());
    instamt.click();
    driver.findElement(By.xpath("//*[@id='installment_amt']/li/ul/li[3]")).click();

    WebElement period = driver.findElement(By.xpath("//*[@id='installment_period']/li"));
    System.out.println(driver.getCurrentUrl());
    period.click();
    driver.findElement(By.xpath("//*[@id='installment_period']/li/ul/li[4]")).click();

}


        






    // @AfterTest
    // public void exit(){
    //     driver.quit();
    // }
}
