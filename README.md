# ToDoMvc-Test-Automation

### Test automation framework
- This is a Maven based Cucumber TestNG framework
- pom.xml has all dependencies and build configuration pointing to testng.xml

The following folder `src/test/java/toDoList` contains the following class:

- `Hooks` - consists of the before and after hooks. This launches and kills the specific browser driver.
- `RunnerTest` - contains the CucumberOptions which runs the BDD's
- `StepDefintion` - contains the respective step definitions of feature file

The following folder `src/test/java/features` contains the following class:

`ToDoListActions.feature` - consists of the test scenarios authored in Gherkin format

The following folder `src/main/resources` consists of properties file storing all global data values(base url, browser etc..)
 
The following folder `src/main/resources/browserDrivers` contains browser drivers

The following folder `src/main/java/utils` contains the following class:

`BrowserSetup` - This contains the condition use a given browser based on what is set to browser within `GlobalData.properties`

The following folder `src/main/java/pages` contains the following class:

`ToDoPage` - This contains the page objects and re-usable functions of To Do List page




### Test Execution


- Create a new TestNG run configuration in Intellij with Test kind as Suite pointing to path of testng.xml suite
  and trigger run to execute the `ToDoListActions.feature` test scenarios
   
- Alternatively, execute via CLI by passing maven build command `mvn test` to trigger the `ToDoListActions.feature` test scenarios

- Upon completion of test execution, a report is generated in the folder `/test-output/cucumber-reports` with
  title `ToDoListExecutionReport` in HTML format    


