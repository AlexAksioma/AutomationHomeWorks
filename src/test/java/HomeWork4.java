import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork4 {
    WebDriver wd;

    @BeforeMethod
    public  void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void tableHW(){
        List<WebElement> elementsTable = wd.findElements(By.cssSelector("#customers tr:nth-child(4) td"));
        System.out.println(elementsTable.size());
        for(int i=0; i< elementsTable.size(); i++) {
            WebElement element = elementsTable.get(i);
            System.out.println(element.getText());
        }
        for(int i=0; i< elementsTable.size(); i++) {
            WebElement element = elementsTable.get(i);
            if(element.getText().equals("Mexico")){
                System.out.println("Text 'Mexico' is there");
                return;
            }
        }
        Assert.assertTrue(elementsTable.get(2).getText().equals("Mexico"));
    }

    @Test
    public void tableHW2(){
        List<WebElement> elementsTableRow = wd.findElements(By.cssSelector("#customers tr"));
        int amountTableRows = elementsTableRow.size();
        System.out.println("amount of table rows = "+amountTableRows);
        System.out.println("===============================");

        List<WebElement> elementsTableCol = wd.findElements(By.cssSelector("#customers tr th"));
        System.out.println("amount of table cols = "+elementsTableCol.size());
        System.out.println("===============================");

        List<WebElement> elementsTableContentRow3 = wd.findElements(By.cssSelector("#customers tr:nth-child(3) td"));
        for(int i=0; i<elementsTableContentRow3.size(); i++){
            WebElement elementRow3 = elementsTableContentRow3.get(i);
            System.out.println(i+1+" "+elementRow3.getText());
        }

        System.out.println("===============================");
        List<WebElement> elementsTableContentLastCol = wd.findElements(By.cssSelector("#customers tr td:last-child"));
        WebElement elementTh = wd.findElement(By.cssSelector("#customers tr th:last-child"));
        System.out.println(elementTh.getText());
        for(int i=0; i<elementsTableContentLastCol.size(); i++){
            WebElement content = elementsTableContentLastCol.get(i);
            System.out.println(content.getText());
        }

        System.out.println("===============================");
        List<WebElement> elementsTableContentNames = wd.findElements(By.cssSelector("#customers tr td:nth-child(2)"));
        for(int i=0; i<elementsTableContentNames.size(); i++) {
            WebElement elementName = elementsTableContentNames.get(i);
            if(elementName.getText().equals("Philip Cramer")){
                System.out.println("number of row with name Philip Cramer = "+(i+1));
                return;
            }
        }

    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }

}
