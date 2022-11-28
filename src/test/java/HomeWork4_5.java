import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork4_5 {
    WebDriver wd;

    @BeforeMethod
    public  void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void tableHW(){
        /*List<WebElement> elementsTable = wd.findElements(By.cssSelector("#customers tr:nth-child(4) td"));

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

        */
        // get row 4 content
        // check if there is text "Mexico" there
        WebElement element = wd.findElement(By.xpath("//table[@id='customers']//tr[4]"));
        WebElement element1 = wd.findElement(By.xpath("//*[contains(@class,'ws-table-all')]/tbody/tr[4]"));
        System.out.println(element.getText());
        Assert.assertTrue(element.getText().contains("Mexico"));

        Assert.assertEquals(
                wd.findElement(By.xpath("//table//*[text()='Mexico']")).getText(),"Mexico");
    }

    @Test
    public void tableHW2(){
        List<WebElement> elementsTableRow = wd.findElements(By.cssSelector("#customers tr"));

        List<WebElement> elementsTableRow1 = wd.findElements(By.xpath("//table[@id='customers']//tr"));
        List<WebElement> elementsTableRow2= wd.findElements(By.xpath("//*[@class='ws-table-all']//tr"));
        int amountTableRows = elementsTableRow2.size();  // print amount of table rows
        System.out.println("amount of table rows = "+amountTableRows);
        System.out.println("===============================");

        List<WebElement> elementsTableCol = wd.findElements(By.cssSelector("#customers th"));

        List<WebElement> elementsTableCol1 = wd.findElements(By.xpath("//*[@id='customers']/tbody//th"));
        List<WebElement> elementsTableCol2 = wd.findElements(By.xpath("//*[contains(@id,'tomer')]/tbody//th"));
        List<WebElement> elementsTableCol3 = wd.findElements(By.xpath("//*[starts-with(@id,'cus')]/tbody//th"));
        System.out.println("amount of table cols = "+elementsTableCol3.size());
        System.out.println("===============================");

        List<WebElement> elementsTableContentRow3 = wd.findElements(By.cssSelector("#customers tr:nth-child(3) td"));
        /*for(int i=0; i<elementsTableContentRow3.size(); i++){
            WebElement elementRow3 = elementsTableContentRow3.get(i);
            System.out.println(i+1+" "+elementRow3.getText());
        }*/
        for (WebElement e: elementsTableContentRow3) {
            System.out.println(e.getText());
        }

        System.out.println(wd.findElement(By.xpath("//*[contains(@class,'ws-tabl')]//tr[3]")).getText());

        System.out.println(wd.findElement(By.xpath("//table[(@id='customers') and contains(@class,ws-table-all)]//tr[3]")).getText());

        System.out.println(wd.findElement(By.xpath("//table[(@id='customers') and (@class='ws-table-all')]//tr[3]")).getText());


        System.out.println("===============================");
        List<WebElement> elementsTableContentLastCol = wd.findElements(By.cssSelector("#customers td:last-child"));
        WebElement elementTh = wd.findElement(By.cssSelector("#customers tr th:last-child"));
        System.out.println(elementTh.getText());
        for (WebElement element: elementsTableContentLastCol) {
            System.out.println(element.getText());
        }
        System.out.println("-----------------------------------");
        /*for(int i=0; i<elementsTableContentLastCol.size(); i++){
            WebElement content = elementsTableContentLastCol.get(i);
            System.out.println(content.getText());
        }*/
        // print content of last col
        List<WebElement> elementLastCol = wd.findElements(By.xpath("//table[@id='customers']//td[3]"));
        List<WebElement> elementLastCol1 = wd.findElements(By.xpath("//table[@id='customers']//td[last()]"));
        List<WebElement> elementLastCol2 = wd.findElements(By.xpath("//*[contains(@id,'stomers') and starts-with(@class,'ws')]//td[last()]"));
        for (WebElement element:elementLastCol2) {
            System.out.println(element.getText());
        }


        System.out.println("===============================");
        List<WebElement> elementsTableContentNames = wd.findElements(By.cssSelector("#customers tr"));

        List<WebElement> elementsTableContentNames1 = wd.findElements(By.xpath("//table[@id='customers']//tr"));
        List<WebElement> elementsTableContentNames2 = wd.findElements(By.xpath("//*[@class='ws-table-all']/tbody/tr"));
        for(int i=0; i<elementsTableContentNames2.size(); i++) {
            WebElement elementName = elementsTableContentNames2.get(i);
            if(elementName.getText().contains("Philip Cramer")){
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
