# [Rates API tests](https://ratesapi.io/documentation) 
  
### Getting started (list of needed tools)  
##### Java, Java SDK  
* version 8 or higher  
* [official documentation](https://docs.oracle.com/javase/11/docs/)  
  
##### Maven  
* version: 3.5.*  or higher
* [official documentation](http://maven.apache.org/guides/)  
  
##### All dependencies from POM.xml  
```sh  
$ mvn dependency:resolve  
```  

### Documentation  
```sh  
$ -generate javadoc: mvn javadoc:javadoc  
```  
  
### Test Reports  
```sh  
$ turn on reports mode: mvn site -DgenerateReports=false  
$ run tests: mvn test 
$ generate reports: mvn surefire-report:report-only 
```  
![alt text](https://artofimmersion.files.wordpress.com/2014/11/theoffice_dundermifflincom_fuse.jpg)

