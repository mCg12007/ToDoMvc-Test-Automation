package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.List;

import static utils.LoadProp.getProperty;

 public class ToDoPage extends BaseDriver {

    // Page Element Locators
    By header=By.xpath("//header/h1");
    By inputField=By.className("new-todo");
    By footer=By.className("info");
    By listItems=By.xpath("//ul[@class='todo-list']/li");
    By unToggledItem=By.xpath("//li[@class='todo']");
    By itemValue=By.xpath("//label");
    By toggledItem=By.xpath("//li[@class='todo completed']");
    By toggleItem=By.xpath("./preceding-sibling::input[@class='toggle']");
    By removeItem=By.xpath("./following-sibling::button[@class='destroy']");
    By toggleAll=By.xpath("//label[@for='toggle-all']");
    By itemFooterCount=By.className("todo-count");
    By clearCompleted=By.className("clear-completed");


    List<String> unToggledItemsList=new ArrayList<>();
    List<String> toggledItemsList=new ArrayList<>();

    public void getToDoPage() {
        driver.get(getProperty("url"));
    }

     public boolean isHeaderDisplayed(String headerText) {
        return driver.findElement(header).getText().equalsIgnoreCase(headerText);
     }

     public boolean isPlaceHolderTextDisplayed(String placeHolderText) {
         return driver.findElement(inputField).getAttribute("placeholder").equalsIgnoreCase(placeHolderText);
     }

     public boolean isFooterDisplayed(){
        return driver.findElement(footer).isDisplayed();
     }


     public boolean checkItemCount() {
        long itemCount= driver.findElements(unToggledItem).stream().filter(item -> !item.getAttribute("class").contains("completed")).count();
         return driver.findElement(itemFooterCount).getText().contains(String.valueOf(itemCount));
     }

     public void enterItem(String unToggledItem) {
        driver.findElement(inputField).sendKeys(unToggledItem+ Keys.ENTER);
         unToggledItemsList.add(unToggledItem);
     }

     public void enterMultipleItems(DataTable table){
         List<List<String>> tableRow=table.asLists(String.class);
         tableRow.forEach(column->enterItem(column.get(0)));
     }


     public boolean isItemsInList(String toggleType) {
         boolean itemFlag=true;
         if(toggleType.equalsIgnoreCase("untoggled")){
         List<WebElement> toDoList=driver.findElements(unToggledItem);
             for (WebElement listItem:toDoList) {
                 if (!unToggledItemsList.stream().filter(unToggledItem -> unToggledItem.contains(listItem.getText())).findAny().isPresent()) {
                     itemFlag = false;
                     break;
                 }
             }
         }
         if(toggleType.equalsIgnoreCase("toggled")){
             List<WebElement> toDoList=driver.findElements(toggledItem);
             for (WebElement listItem:toDoList) {
                 if (!toggledItemsList.stream().filter(unToggledItem -> unToggledItem.contains(listItem.getText())).findAny().isPresent()) {
                     itemFlag = false;
                     break;
                 }
             }
         }
        return itemFlag;
     }

     public void clickTab(String tabText) {
        driver.findElement(By.linkText(tabText)).click();
     }

     public boolean noItemsDisplayed(String toggleType) {
        if(toggleType.equalsIgnoreCase("untoggled")) {
            return !(driver.findElements(unToggledItem).size() > 0);
        }
        else{
            return !(driver.findElements(toggledItem).size() > 0);
        }
     }

     public void toggleItem(String itemName) {
        List<WebElement> items=driver.findElements(By.xpath((unToggledItem.toString()
                +itemValue.toString()).replaceAll("By.xpath: ","")));
         for (WebElement item:items) {
             if(item.getText().equalsIgnoreCase(itemName)){
                 item.findElement(toggleItem).click();
             }
         }
         unToggledItemsList.removeIf(item->item.equalsIgnoreCase(itemName));
         toggledItemsList.add(itemName);
     }

     public void clickToggleAll() {
        driver.findElement(toggleAll).click();
     }

     public boolean isItemsToggled() {
        boolean toggleFlag=true;
        List<WebElement> items=driver.findElements(listItems);
         for (WebElement item:items) {
             if(!item.getAttribute("class").contains("completed")){
                 toggleFlag=false;
                 break;
             }
         }
     return toggleFlag;
     }

     public boolean isClearBtnDisplayed() {
        return driver.findElement(clearCompleted).isDisplayed();
     }

     public void clickClearButton() {
        driver.findElement(clearCompleted).click();
     }

     public void removeItem(String itemName) {
         List<WebElement> items=driver.findElements(By.xpath((listItems.toString()
                 +itemValue.toString()).replaceAll("By.xpath: ","")));
         for (WebElement item:items) {
             if(item.getText().equalsIgnoreCase(itemName)){
                 JavascriptExecutor js=(JavascriptExecutor)driver;
                 js.executeScript("arguments[0].click();",item.findElement(removeItem));
             }
         }
         unToggledItemsList.removeIf(item->item.equalsIgnoreCase(itemName));
         toggledItemsList.removeIf(item->item.equalsIgnoreCase(itemName));
     }

     public boolean isItemDisplayed(String itemName) {
        boolean itemFlag=false;
         List<WebElement> items=driver.findElements(By.xpath((listItems.toString()
                 +itemValue.toString()).replaceAll("By.xpath: ","")));
         for (WebElement item:items) {
             if(item.getText().equalsIgnoreCase(itemName)){
                 itemFlag=true;
                 break;
             }
         }
         return itemFlag;
     }
 }