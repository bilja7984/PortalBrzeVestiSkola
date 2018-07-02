
package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegionsPage extends Page {
    
    public void clickOnAddRegionButton() {
        
        clickOnElement(By.className("btn"));
    }
    
    public void sendTextInTitleField() {
        
        sendTextOnField(By.id("title"), Helper.getRandomText());    
    }
    
    public void clickOnSaveRegionButton() {
        
        clickOnElement(By.id("save-region-button"));
    }
    
    public void addNewRegion() {
        
        clickOnAddRegionButton();
        sendTextInTitleField();
        clickOnSaveRegionButton();
    }
    
    public void clickOnEditButton (WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }
    
    public void clickOnDisableButton(WebElement row) {
        
        WebElement disableButton = row.findElement(By.cssSelector("a[title='Disable']"));
        disableButton.click();
        
    }
    
    public void clickOnDeleteButton(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("a[title='Delete']"));
        deleteButton.click();
        
    }
    
    private List<WebElement> getRowsFromTable() {
        WebElement tBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    private WebElement chooseFirstCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);
        return firstRow;
    }

    private WebElement chooseLastCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    public void editFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        clickOnEditButton(firstRow);
        sendTextOnField(By.id("title"));
        clickOnSaveRegionButton();
    }
    
}
