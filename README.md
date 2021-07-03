#### Problem Statements:
###### Task 1. Q: Compare 2 XML files
###### Task 2. Q. Create a jar file or application for the given task of fata fill in form with iframe

#### Summary
###### Automated the test cases to execute on compare 2 files and fill data in iframe assignement

#### Technologies Used:
###### JDK 1.8, 
###### XMLUnit, 
###### Cucumber with Serenity, 
###### Reporting using ExtentReports, 
###### Maven (Build tool)

#### Testng framework.
###### Executions are controlled as profile based in maven.
###### TestScenarios are defined in Cucumber Feature files
###### Page Object Model design pattern used. Hence separate java object for each screen. This contains respective locators and methods performed on those locators.

#### Reports
###### Extent Report is integrated to the test class - Dynamic html test report is generated in this directory at the end of execution. 
###### Extent reports library used for that purpose.

#### How to run
###### Below is the maven command to initiate the run Task 1 - 
mvn test verify

###### Below is the maven command to initiate the run Task 2 - 
java -jar ./out/artifacts/cucumber_starter_jar/cucumber-starter.jar   

#### About the Framework
###### This automation file mainly focuses on automating some of the use cases for comparing 2 xml filess and fill data in iframe assignemnet
###### Due to tme constarint 0f 24 hours only, was not able to automate more sceanrios, I would create multiple utilities
###### Extent reports are integrated for the report generation and can be found at YogitaAssignment/target/site/serenity/index.html
