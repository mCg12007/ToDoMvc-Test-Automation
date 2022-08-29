package toDoList;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ToDoPage;


public class StepDefinition {

    ToDoPage toDoPage=new ToDoPage();// instantiation of To Do class object

    @Given("^user is on the To Do List home page$")
    public void navigateToDoPage() throws InterruptedException {
        toDoPage.getToDoPage();
    }

    @Then("^user should view (.+) header text in To Do page$")
    public void viewToDoHeader(String headerText){
        Assert.assertTrue(toDoPage.isHeaderDisplayed(headerText));
    }

    @And("^user should view (.+) place holder text in To Do field$")
    public void viewPlaceHolderText(String placeHolderText){
        Assert.assertTrue(toDoPage.isPlaceHolderTextDisplayed(placeHolderText));
    }

    @And("^user should view footer below the To Do form$")
    public void viewFooter(){
        Assert.assertTrue(toDoPage.isFooterDisplayed());
    }


    @When("^user enters (.+) in To Do field$")
    public void userEntersItemInToDoField(String toDoItem) {
        toDoPage.enterItem(toDoItem);
    }

    @And("the item count should be updated in the footer")
    public void itemCountInTheFooter() {
        Assert.assertTrue(toDoPage.checkItemCount());
    }

    @When("user enters multiple items to To Do List")
    public void userEntersMultipleItemsToToDoList(DataTable table) {
        toDoPage.enterMultipleItems(table);
    }

    @When("^user clicks on (.+) tab in footer$")
    public void clicksTabInFooter(String tabText) {
        toDoPage.clickTab(tabText);
    }

    @Then("^user should view (.+) items in the list$")
    public void viewItemsInTheList(String toggleType) {
        Assert.assertTrue(toDoPage.isItemsInList(toggleType));
    }

    @Then("^user should not view any (.+) items in the list$")
    public void noItemsInTheList(String toggleType) {
        Assert.assertTrue(toDoPage.noItemsDisplayed(toggleType));
    }

    @When("^user toggles (.+) item in To Do list$")
    public void userTogglesItem(String item) {
        toDoPage.toggleItem(item);
    }

    @When("user clicks on toggle all button")
    public void userClicksOnToggleAllButton() {
        toDoPage.clickToggleAll();
    }

    @Then("user should view all items marked as completed")
    public void viewItemsCompleted() {
        Assert.assertTrue(toDoPage.isItemsToggled());
    }

    @Then("user should view Clear completed button in To Do list")
    public void viewClearCompletedButton() {
        Assert.assertTrue(toDoPage.isClearBtnDisplayed());
    }

    @When("user clicks on Clear completed button")
    public void clicksClearButton() {
        toDoPage.clickClearButton();
    }

    @When("^user clicks on cross button of item (.+)$")
    public void clicksCrossButton(String item) {
        toDoPage.removeItem(item);
    }

    @Then("^user should not view (.+) item in the list$")
    public void shouldNotViewItemInTheList(String item) {
        Assert.assertFalse(toDoPage.isItemDisplayed(item));
    }
}


