# credit-card-system
This system will accept credit card related data, will apply luhn validation and create the account details of user. It also provides get all customers Data API that is helpful to retrieve the data.

This is a spring-boot application that uses in-memory Database H2 to store and retrieve the Data.

#Technologies Stack Used in this API

1) Spring Boot 2.6.4
2) Spring Security 2.6.4
3) Spring Data JPA 2.6.4
4) H2 Database 1.4.200
5) Tomcat Embed
6) JUnit 5
7) Maven 3.6.3
8) Java 11

Run the Project
#Option 1:

1) clone the repository on your system
2) run mvn clean: install to install all the dependencies
3) Go to Application.java and start the application.
4) In order to run through maven use mvn spring-boot:run
5) In order to check the application is up and running click on /actuator/health API. You can use browser or postman or below curl command (for example: on localhost) hit the below command:
   curl --location --request GET 'http://localhost:8080/actuator/health'

or you can use the command line with below commands

$ git clone 
$ git pull
$ mvn: clean install
$ mvn spring-boot:run
