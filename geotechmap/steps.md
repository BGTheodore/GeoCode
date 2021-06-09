1. L'appli aura frontend et backend
So 2 folders associated
Backend: Appli Java
Frontend: Appli React
IDE: Visual Studio Code



<<<BACKEND>>>
1.  [] Download and install JDK on computer (you need to have an Oracle account)
>>> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
2.  [] Install spring boot Dashboad extension in VSC
>>> Spring initializr Java Support
>>> Spring Boot Tools 
>>> Spring Boot Snippets (optional)
>>> Spring Boot Extension Pack
>>> Spring Boot Dashboard
>>> Lombok Annotation Support 
>>> Debugger for Java (optional)

4.  [] Generate Spring boot app:
>>> Crtl+p > spring boot initializr ...
>>>https://www.youtube.com/watch?v=5mpHejytgFE
https://www.youtube.com/watch?v=hxiWXe5oMrI
6.   [] Install Maven (Pour la gestion des dependances)
>>> sudo apt update
>>> sudo apt install maven
7. []  [] Support VSC
>>> https://code.visualstudio.com/docs/java/java-build

Maven: Gestion de dependances
manager---> mvn ..code..



<<<integration react spring boot >>>
https://bezkoder.com/integrate-reactjs-spring-boot/













<<<integration Map>>>
https://medium.datadriveninvestor.com/getting-started-building-location-based-gis-rest-apis-with-java-ca28a8869af3

$ yarn add react react-dom leaflet
$ yarn add react-leaflet




======================================
- li tres couteux pou kouvri tout zone nan planet la.
- mete yon systeme d'index 
- limiter zone nan.
- analyse des risque: dresser yon matrice des risques; relever risques yo; analyser yo en termes de probabilte et impack
(depassemnet de budget)
x:risque
y; probalité
-initialisation projet: nou pa fe etudes de faisabilité:convaincre moun yo keu projet a faisable menm si sa paret evident.
- nou pa besoin non fonctionnels yo.(couleur des pages, langue, )
- securite a fe partie de besoin fonctionnel, performance tou.
- a la de analyse des besoins fok gen redaction des cas d'utilisation
- pou cas 'utilisation: tel cas + description ; then classer yo par odre d'utiliation.
nan premier sprint la ou pran CU ki pi important an.
- selon limen scrum suffisant
- pou deploiment fok pou creer yon user ki gen moins privilege: li pa ka creer base, modifier base, creer table, etc.
- manke des couche : ex: DTO; ladanl ou fe pagination tou (attibut: page size, nbre items par page, list de items)
- comprann patter spring yo
- apercu de liste de failles ki konn genyen nan chak couche
- use API keycloak la

=======================================================================
- Super admin: CRUD validator + CRUD institution + CRUD type d'essais
- validator : check essais + CRUD user de son institutions
- data entry : CRUD ses essais
- Visitor : READ all
=======================================================================
- Contexte
    + Introduction générale
    + Importance de la géotechnique
        * Production et gestion des données géotechniques en Haïti
            <> Microzonage
            <> Les problèmes actuels dans la production et gestion des données
    + Problématique
    + Panorama du projet

- Présentation du projet
    + Objectifs 
    + Justificatif de son caractère innovant
    + Analyse des risques
        * Risques sur le plan social
        * Risques sur le plan technique
        * Risques sur le plan économique

- État de l'art 
    + Les BDD géotechniques dans le monde
    + Existant en Haïti
        * Cartographie Géotechnique du LNBTP	16
        * Ancien projet de l’URGéo	
    + Avantages d’un Système de gestion des Informations Géotechniques
    + La solution proposée
        * Les apports de cette solution    
        * Entrée du système
        * Sortie du système

- Exigences à réaliser
    + Besoins fonctionnels
        * Webmap
        * Moteur de recherche
        * Performances
        * Sécurité
    + Exigences non-fonctionnelles
        * Application mobile
        * Langue
        * Couleur des pages
    + IHM/API
        * Plateforme des administrateurs
        * Plateforme visiteur
        * API 
    + Étude de faisabilité
        * Quelle est la portée du projet ?
        * Quelles sont les exigences du projet ?
        * Quel est le résultat des différentes évaluations ?

- Démarche projet
    + Activités d'ingénierie logicielle
    + Methode de gestion de projet
        * Perspective de réalisation
    + Roles et responsabilités
    + Outils
    + Gestion déploiement/configuration
    + Contraintes et risques
    + Planification
    + Budget

- Conception et implementation
    + Architecture matérielle et logicielle
    + Conception du code source
    + Implémentation d’une BDD géotechniques
        * Numérisation des données
        * Intégration de ces données dans une BDD
    + Utilisation d’un SIG
    + Visualisation des données
    + Perspective de réalisation

- Plan de tests

- Conclusion générale
    + Extention du projet
    + Bilan

- Références et bibliographie


=======================
DOCKER
========================
https://www.youtube.com/watch?v=e3YERpG2rMs&t=46s

1. create Dockerfile in root directory
2. add final name in pom.xml
3. create jar file [right click on maven projet and install]
4. create the docker image
$ docker build -t geotechmap.jar .
5. to see all images
5. create docker-compose.yml
$ docker image ls
6. to run docker image (on port 9090 of our localhost)
$ docker run -p 9090:8080 geotechmap.jar

7. to clean project
$ mvn clean install -DskipTests=true
or
./mvnw clean install -DskipTests

docker-compose up

7. to remove all runing containers
$ docker rm $(docker ps -a -q)
7. The Compose file provides a way to document and configure all of the application's service dependencies
$docker-compose up
{
    stop service: systemctl stop postgresql
    start service: systemctl start postgresql
    show status of service: systemctl status postgresql
}

docker exec -it postgres /bin/bash
psql -h localhost -U postgres
psql -d postgres
psql -h localhost -U postgres
CREATE DATABASE geotechdb;