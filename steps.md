1.  [] Download adn install JDK on computer (you need to have an Oracle account)
>>> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
2.  [] Install spring boot Dashboad extention in VSC
3.  [] Install Java extention Pack in VSC
4.  [] Generate Spring boot app:
>>> Crtl+p > spring boot initializr ...
>>>https://www.youtube.com/watch?v=5mpHejytgFE
https://www.youtube.com/watch?v=hxiWXe5oMrI
6.   [] Install Maven
>>> sudo apt update
>>> sudo apt install maven
7. []  [] Support VSC
>>> https://code.visualstudio.com/docs/java/java-build

<<<<<<SETUP ENV>>>>>>
1.  []
2.  [] Install VSC ext:
>>> Spring initializr Java Support
>>> Spring Boot Tools
>>> Spring Boot Snippets (optional)
>>> Spring Boot Extention Pack
>>> Spring Boot Dashboard
>>> Lombok Annotation Support (Tenten sa fem boule preskeu 24 Heures)
>>> Debugger for Java (optional)


1.  [] Create a postgresql database: "geotechdb"
2.  [] Generate Spring Boot appp
>>> Crtl+p 
>>> Spring boot initializr : Create Mave project
>>> 2.4.3
>>> Java
>>> com.example
>>> geotech
>>> JAR
>>> 11
>>> Spring Web + Lombok + Spring Data JPA + PosgreSQL Driver + Spring Boot DevTools  + thymeleaf + validation + Spring Security + test +thymeleaf-layout-dialect
3.  [] Set up database connection in application.properties and and test connection
>>>spring.datasource.url=jdbc:postgresql://localhost:5432/geotechdb
>>>spring.datasource.username=postgres
>>>spring.datasource.password=postgres
4.  [] Create Models, Controllers, Entities, Repositories, Services packages.

5.  [] Create User entity (a class)
8.  [] Create UserRepository entity (an interface)
9.  [] Create service package
10. [] Create UserRepositoryTests.java
11. [] properties.java
>>>spring.jpa.hibernate.ddl-auto=create
10. [] Test in order to create the user table in the db
12. [] Create UserController (a class)
13. [] Test with Postman
14. [] Create CustomUserDetails, CustomUserDetailsServices, WebSecurityConfig

<<<<<<<Spring Boot Database Migrations with Flyway>>>>>>>
1.  []
2.  []
3.  []
<<<<<<<Create User Login & Registration with Spring Security>>>>>>>
1.  []
2.  []
3.  []





https://medium.com/@tariqul.islam.rony/spring-boot-with-visual-studio-code-visual-studio-code-part-2-7943febb52f8