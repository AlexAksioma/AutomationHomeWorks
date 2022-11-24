import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork3 {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/login");
    }

    @Test
    public void testLogin_Home(){
        //WebElement webElementHome = wd.findElement(By.cssSelector("[href='/home']"));
        WebElement webElementHome = wd.findElement(By.cssSelector(".navbar-component_nav__1X_4m a:nth-child(2)"));
        WebElement webElementHome1 = wd.findElement(By.cssSelector("#root a:nth-child(2)"));
        WebElement webElementHome2 = wd.findElement(By.cssSelector("#root>.navbar-component_nav__1X_4m>a:nth-child(2)"));
        System.out.println("it's element= "+webElementHome1.getText());
        webElementHome2.click();
    }

    @Test
    public void testLogin_Email(){
        //WebElement webElementEmail = wd.findElement(By.name("email"));
        WebElement webElementEmail = wd.findElement(By.cssSelector("[name=email]"));

        List<WebElement> elementsEmail = wd.findElements(By.cssSelector(".login_login__3EHKB input"));
        System.out.println("size collection = "+elementsEmail.size());
        WebElement webElementEmail1 = elementsEmail.get(0);

        WebElement webElementEmail2 = wd.findElement(By.cssSelector("form input:first-child"));

        Assert.assertTrue(webElementEmail2.getAttribute("name").equals("email"),"hi");
        System.out.println("it's element = "+webElementEmail2.getAttribute("name"));
    }

    @Test
    public void testLogin_Password(){
        WebElement webElementPassword = wd.findElement(By.name("password"));

        WebElement webElementPassword1 = wd.findElement(By.cssSelector("[name=password]"));

        WebElement webElementPassword2 = wd.findElement(By.cssSelector("[name=password][placeholder='Password']"));

        Assert.assertEquals("password",webElementPassword1.getAttribute("name"));

        System.out.println("it's element = "+webElementPassword2.getTagName()+" name "+webElementPassword2.getAttribute("name"));
   }

    @Test
    public void testLogin_ButtonLogin(){
        WebElement webElementButtonLogin = wd.findElement(By.name("login"));

        WebElement webElementButtonLogin1 = wd.findElement(By.cssSelector("[type=submit][name=login]"));
        Assert.assertEquals("Login",webElementButtonLogin1.getText());

        WebElement webElementButtonLogin2 = wd.findElement(By.cssSelector(".login_login__3EHKB button"));
        System.out.println("it's element = "+webElementButtonLogin2.getText());
        Assert.assertEquals("Login",webElementButtonLogin2.getText());

    }

    @Test
    public void testLogin_ButtonRegistration(){
        WebElement webElementButtonRegistration = wd.findElement(By.name("registration"));
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
