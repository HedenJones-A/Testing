package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //drivers

        //Edge
        WebDriverManager.edgedriver().setup();
        WebDriver edge=new EdgeDriver();

        // Google
        WebDriverManager.chromedriver().setup();
        WebDriver google=new ChromeDriver();

        // firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox=new FirefoxDriver();
    
        // opening browsers
        google.get("http://google.com");
        edge.get("http://google.com");
        firefox.get("http://google.com");



        
    }
}
