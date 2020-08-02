# [Rates API tests](https://ratesapi.io/documentation) 
Automatic tests of Rates API, written with Java, JUnit, Gherkin, Cucumber and REST assured.

All test cases covered here can be found on this [google spreadsheet](https://docs.google.com/spreadsheets/d/1L5r1G63Q5_N3PjcZaHY8alf7g0mO8gHUYNIfT3t1y84/edit?usp=sharing).
  
### Getting started (list of needed tools)  
##### Java, Java SDK  
* version 8 or higher  
* [official documentation](https://docs.oracle.com/javase/8/docs/)  
  
##### Maven  
* version: 3.5.*  or higher
* [official documentation](http://maven.apache.org/guides/)  

### Run chosen tests
To execute every test, use the command below:
```sh  
mvn test  
```                         

### Test Reports  
To generate a maven surefire test report, use the commands below:
```sh  
mvn site -DgenerateReports=false  
mvn surefire-report:report-only 
```  
You can find the report in the path _target/site/surefire-report.html_
### Code documentation  
A tool called [javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html) was used to create the documentation. To generate it, use the command below: 
```sh  
mvn javadoc:javadoc  
```  


