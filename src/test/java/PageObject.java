import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {

  private static WebDriver driver;
  protected static final Logger logger =  LogManager.getLogger(PageObject.class);
  private static final By LOGIN_INPUT_FIELD = By.cssSelector("input[type='text']");
  private static final By PASSWORD_INPUT_FIELD = By.cssSelector("input[type='password']");
  private static final By LOGIN_BUTTON = By.cssSelector("input[class='submit-button btn_action']");
  private static final By DIV_ON_LOGIN_PAGE = By.cssSelector("div[class='login_logo']");
  private static final By DIV_AFTER_LOGIN_PAGE = By.cssSelector("div[class='app_logo']");
  private static final String url = "https://www.saucedemo.com/";


  public PageObject() {

    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromeDriver");
    driver = new ChromeDriver();
    driver.get(url);
    logger.log(Level.INFO, "переходим на сайт" + url);
  }

  public PageObject inputLoginName(String login) {

    logger.log(Level.INFO, "Вводим логин: " + login);
    driver.findElement(LOGIN_INPUT_FIELD).clear();
    driver.findElement(LOGIN_INPUT_FIELD).sendKeys(login);
    return this;
  }

  public PageObject inputPassword(String password) {

    logger.log(Level.INFO, "Вводим пароль: " + password);
    driver.findElement(PASSWORD_INPUT_FIELD).clear();
    driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    return this;
  }

  public PageObject clickLoginButton() {

    logger.log(Level.INFO, "Кликаем на кнопку логин");
    driver.findElement(LOGIN_BUTTON).click();
    return this;
  }

  public boolean isLoginPresent() {

    logger.log(Level.INFO, "Проверяем, что есть элемент login-logo");
    return driver.findElement(DIV_ON_LOGIN_PAGE).isDisplayed();
  }

  public boolean isAppLogoPresent() {

    logger.log(Level.INFO, "Проверяем, что появился элемент app-logo");
    return driver.findElement(DIV_AFTER_LOGIN_PAGE).isDisplayed();
  }

  public static void shutdownDriver() {
    driver.quit();
  }
}
