import org.junit.ComparisonFailure;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeleniumWebTests {
    @Test
    public void test1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saltr\\IdeaProjects\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        String s;
        driver.get("https://www.ozon.ru/");

        s = driver.getTitle();
        System.out.println(s);
        try {
            assertEquals("OZON — интернет-магазин. Миллионы товаров по выгодным ценам", s);
        }
        catch (ComparisonFailure e) {
            System.out.println("TEST FAILED!!\n");
            driver.quit();
            return;
        }

        WebElement element = driver.findElementByName("search");
        Rectangle rect = element.getRect();
        System.out.println("Поле для ввода текста search: X=" + rect.getX() + " Y=" + rect.getY()
                + " WIDTH="  + rect.getWidth() + " HEIGHT="  + rect.getHeight()
        );

        element.clear();
        element.sendKeys("Пылесос\t");

        WebElement btn = driver.findElement(By.cssSelector("[type='submit']"));
        btn.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> listElements = driver.findElementsByCssSelector("a.a2g0");

        System.out.println("\nСписок пылесосов:");
        for (WebElement item : listElements) {
            System.out.println(item.getText());
        }

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //driver.quit();
    }

    @Test
    public void test2() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\saltr\\IdeaProjects\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.ozon.ru/");

        List<WebElement> listElements = driver.findElementsByCssSelector("span.j4.j5");

        System.out.println("\nСписок товаров:");
        for (WebElement item : listElements) {
            System.out.println(item.getText());
        }

        driver.quit();
    }
}