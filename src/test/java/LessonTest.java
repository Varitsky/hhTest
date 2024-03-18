import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LessonTest {

  protected static final Logger logger =  LogManager.getLogger(LessonTest.class);
  static WebDriver driver;

  @BeforeClass
  public void getDriver() {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver");
    driver = new ChromeDriver();
  }

  @AfterClass
  public static void shutdownDriver() {
    driver.quit();
  }
  @Test(description = "проверяем возможность логина после неверного ввода пароля")
  public void login() throws InterruptedException {
    driver.get("https://www.saucedemo.com/");
    logger.log(Level.INFO, "Вводим данные для входа");
    driver.findElement(By.cssSelector("input[class='input_error form_input']")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("user_name");
    driver.findElement(By.cssSelector("input[class='submit-button btn_action']")).click();
    driver.findElement(By.cssSelector("input[type='password']")).clear();
    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[class='submit-button btn_action']")).click();
    Thread.sleep(15000);
  }

  public void isElementPresent() {
    assertFalse(driver.findElement(By.cssSelector("input[type='password']")).isDisplayed());
  }
}
