# 1.  [] Créer des transactions pour les requêtes de la BD.
# 2.  [] Implémenter une système de cache.
# 3.  [] Gérer les groupes et les droits d'accèss.
# 4.  [] Le visiteur doit pouvoir rechercher un essai.
# 5.  [] Ajouter des couche d'abstaction pouvant faciliter les motifications à venir.
# 6.  [] Créer les tests
# 7.  [] Essayer de dépoyer
# 8.  [] Permettre l'utilisation de l'application en mode hors service.
# 9.  [] Coder le UI du visiteur.
# 10. [] Prendre en compte les commentaires de a réunion du 17 Mai.
# 11. [] Ecrire la fin du chapitre 3 du document et le chapitre 4.
# 12. [] Réaliser le Power Point de la présentation finale.
# 13. [] Ajouter les champs 'Département, commune & section comminale' dans l'etité coordonné que l'on va renomm' 'Position' et aussi dans les diagrammes.
# 14. [] Finaliser le UI de l'administrateur
# 15. [] Traduire les champs des table en français.
# 16. [] Générer fake données pour l'application Spring Boot
# 17. [] Configurer tous les API dans un fichier postman.
# 18. [] Gerer les messages d'erreur des API
# 19. [] Upload/download un PDF à partir du UI.

<<<___Questions pour la réunion du Vendredi 14.05.2021;21:00:00-23:59:59__>>>
# 1.  [] Est-ce que le super aministrateur va manipuler l'interface de Keycloak ?
# 2.  [] Lorsque l'administrateur ajoute les coordonnées d;un essai, il rentre la latitude dans un champs, puis la ongitude dans un autre champ; oubien il placce le point sur la carte et on récupère les coordonnées ?
# 3.  [] Comment offrir à l'adminitrateur la possibilité de modifier les informations basique de son compte (nom, prénom, adress,...) ?
# 4.  [] Le visiteur doit pouvoir rechercher un essai; Comment gérer l'implémentation du oteur de recherche ? quels sont les mots clés à stocker ?
# 5.  [] Comment permettre l'utilisation de l'application en mode hors ligne ?
# 6.  [] Quel est la meileur facon d'utiliser Keycloak ? Via un container de docker ou l'installer en local ? Comment va-t-on le déployer ?
# 7.  [] Lorsque l'on fait l'audit dans Sring Boot, comment on récupère l'utilisateur qui est est stocké dans Keygloak
# 8.  [] Quand on modifie, les champs 'created_aby' & 'createdDate' deviennent null
# 9.  [] QuelSRID utiliser ?
# 10. [] Comment filtrer les données pours les administarteurs par defaut? (date de création ? alphabétique ??)
# 11. [] 
# 12. [] 
# 13. [] 
# 14. [] 
# 15. [] 



--------------------
map la ap genere cote server
Java : map server
minimum : 1 map; afficher 1 essai, calculer distance entre essais, afficher detay sou essais;
diferencier differencent type d'essais yo ak des marqueurs de couleur diff.
4 server: appication- Bd - fichier - map
fok gen yon schema pou deploiement system nan.
MAP SERVER

recuperer point geospacial


fok nou gen yon gen yon bd ki gen point geo tout communune

TRAVAY
travail stoker kelke point and rechercher 
lap antre yon zone, lap gad si jwenn essai ou pas.

fe tyon schema ki gen departement, communes, ...