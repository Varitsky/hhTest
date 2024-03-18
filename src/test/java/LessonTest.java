import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LessonTest {

  protected static final Logger logger =  LogManager.getLogger(LessonTest.class);

  @AfterClass
  public static void close() {
    PageObject.shutdownDriver();
  }

  @Test(description = "проверяем возможность логина после неверного ввода пароля")
  public void login() {

    var page = new PageObject();
    assertTrue(page.isLoginPresent(), "нет div login");

    logger.log(Level.INFO, "Вводим данные для входа и проверяем что после логина появляется app-logo");
    assertTrue(page.inputLoginName("standard_user")
        .inputPassword("wrongPassword")
        .clickLoginButton()
        .inputPassword("secret_sauce")
        .clickLoginButton()
        .isAppLogoPresent());
  }
}
