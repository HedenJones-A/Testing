package com.example;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
// import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
    WebDriver driver;
    @BeforeTest
    public void beforetest(){
        WebDriverManager.chromedriver().setup();
        
    }
    @Test(dataProvider = "dat")
    public void test1(String username,String password)throws Exception{
        driver=new ChromeDriver();
        driver.get("http://dbankdemo.com/bank/login");
        driver.manage().window().maximize();
        // Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);

        driver.findElement(By.xpath("//*[@id='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String home=driver.findElement(By.xpath("//*[@id='home-menu-item']")).getText();
        Assert.assertTrue(home.contains("Home"));
        System.out.print(home);
        

    }
    @Test
    public void test2(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='deposit-menu-item']")).click();
        WebElement sel1=driver.findElement(By.xpath("//*[@id='selectedAccount']"));
        Select sele=new Select(sel1);
        sele.selectByVisibleText("Individual Checking(standard checking) (Savings)");
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("5000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,250)");
        String deposit=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
        Assert.assertTrue(deposit.contains("$5000.00"));
        System.out.println(deposit);
        
        
    }
    @Test
    public void test3(){
        driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//*[@id='withdraw-menu-item']")).click();
        WebElement sel1=driver.findElement(By.xpath("//*[@id='selectedAccount']"));
        Select sele=new Select(sel1);
        sele.selectByVisibleText("Individual Checking(standard checking) (Savings)");
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("3000");
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,250)");
        String withdrawl=driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
        Assert.assertTrue(withdrawl.contains("$-3000.00"));
        System.out.println(withdrawl);

    }
    @DataProvider(name="dat")
    public Object[][] fetchData() throws IOException
    {
        Object[][] data=new Object[1][2];
        data[0][0]="S@gmail.com";
        data[0][1]="P@ssword12";
        return data;
    }
}
