PJE-A Plagiat VEMP
==================

*VEMP = Veïs, Eddy, Marc, Pape*

PJE A - Master 1 Informatique - 2016-2017 - Université Lille 1

Contributeurs
-------------
* Veïs Oudjail
* Eddy El Khatib
* Marc Baloup
* Pape Badiane

Liens
---------------
* https://gitlab-etu.fil.univ-lille1.fr/baloup/PJEA-Plagiat (intranet Lille 1 seulement)
* https://github.com/marcbal/PJEA-Plagiat (dépôt privé)
* http://ci.pandacube.fr/job/PJEA-Plagiat_dev (Intégration continue de la branche `dev` sur un serveur Jenkins)

Développement
-------------
Version de Java : 1.8

Utiliser de préférence Eclipse Neon pour la configuration du projet (en plus de celle apportée par la configuration de Maven). Utiliser l'option d'importation "General/Existing project into workspace" et non "Maven/Existing maven project".

Évolution du projet
-------------------

### Premier rendu **v1.0** du 6 octobre

Compare simplement les fichiers deux à deux, avec un algorithme simple. Une hiérarchie de classe permet facilement de switcher d'un algorithme à un autre juste en changeant la classe du comparateur appelé dans le `main()`.

Algorithmes développés :

* `StrictEqualsFilesComparator` : 100% quand les fichiers sont identiques (sauf commentaires et caractères non-imprimables), sinon 0% (le plus simple)
* `NaiveSuccessivesTokensFileComparator` : Compare les fichiers tokens par tokens.
Plus techniquement : divise le nombre de paire de tokens identique d'un fichier à l'autre par le nombre total de token du fichier qui en a le plus. Les tokens sont comparés dans l'ordre, donc l'ajout ou suppression d'une ligne de code au début d'un des fichier réduit drastiquement le
pourcentage de similitude.

### Deuxième rendu **v2.0** du 20 octobre
Compare les fichiers deux à deux, avec un algorithme d'alignement.
Ajout d'une classe permettant la génération de l'empreinte du fichiers.  
Pour ce faire, les algorithmes utilisé pour le générateur sont :

* `RabinHashCodeBuilder` : Permet de creer les hashs suivant le formalisme de Rabin.

* `WinnowingFootprintBuilder` : Permet de creer les empreintes suivant de Winnowing avec les fenetres glissantes.

Par ailleurs, les méthodes de comparaisons utilisés sont les suivantes :

* `AlignmentFileComparator` : Comparaison de deux fichiers avec l'algorithmes d'alignement de Needleman-Wunsch


### Troisième rendu **v3.0** du 10 novembre
* Ajout de test
* Ajout du serveur d'intégration ... 
