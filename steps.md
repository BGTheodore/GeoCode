1.  [] Download and install JDK on computer (you need to have an Oracle account)
>>> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
2.  [] Install spring boot Dashboad extention in VSC
3.  [] Install Java extention Pack in VSC
4.  [] Generate Spring boot app:
>>> Crtl+p > spring boot initializr ...
>>>https://www.youtube.com/watch?v=5mpHejytgFE
https://www.youtube.com/watch?v=hxiWXe5oMrI
6.   [] Install Maven (Pour la gestion des dependances)
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

<<<<<<<Validation request boby>>>>>>>
1.  []
2.  []
3.  []
https://www.youtube.com/watch?v=pjA9Pc7aTic




https://medium.com/@tariqul.islam.rony/spring-boot-with-visual-studio-code-visual-studio-code-part-2-7943febb52f8


Logic conception:
https://medium.com/sprang/validation-and-exception-handling-with-spring-ba44b3ee0723

image logik la:
https://www.toptal.com/java/spring-boot-rest-api-error-handling

exemple prog:
https://github.com/RameshMF/todo-management-spring-boot/blob/master/src/main/java/net/guides/springboot/todomanagement/controller/TodoController.java


<<<<<Frontend>>>>>
# 1.  [] Download Coreui admin template
>>>https://coreui.io/react/demo/3.1.0/dark/#/dashboard
>>>https://coreui.io/react/?affChecked=1#compare
# 2.  [] install app's dependencies
$ npm install
# 3.  [] serve with hot reload at localhost:3000.
$ npm start    
OR
$ npm run serve
# 4.  [] build for production with minification
$ npm run build



<<<Unit test>>>
# 1.  []https://www.baeldung.com/spring-boot-testing


<<<keycloak react>>>
https://www.youtube.com/watch?v=q50LxyGtEf0
>>> to start on port 8090
$ sudo ./bin/standalone.sh  -Djboss.socket.binding.port-offset=10

admin
admin

<<<keycloak spring boot>>>
https://www.youtube.com/watch?v=4b-wZN-6SsU



<<<Deploy aws>>>
# 1.  [] add in pom.xml
<finalName>spring-boot-aws-exe</finalName>
# 2.  [] generate jar
$ mvn clean install

https://www.youtube.com/watch?v=LJkkFx7zJJQ