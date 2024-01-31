# 🏰 DungeonsCLI

## Résumé :

Dans une première partie, ce README vous indiquera le déroulement d'une partie classique, avec
certaines précisions. Puis des informations générales sur le fonctionnement du jeu. 
Puis pour finir le fonctionnement de certains objets qui sont présents dans le jeu a des buts de test.

> ***Note :*** *Il n'y a pas de descriptif des commandes, cela est due au fait qu'il est possible de voir la liste des commandes disponibles a chaque instant 
directement en jeu avec la commande `help`.*

## Déroulement d'une partie :

Dès le début du jeu, le jeu vous demandera le nom de votre personnage de maximum 24 caractères,
une fois votre nom défini et valide, il vous sera demandé de choisir la classe de votre personnage parmi la 
selection affichée. Entrez le nom de la classe afin de le sélectionner ( l'entrée n'est pas stricte, le nom
peut être en majuscules, minuscules et avoir des espaces entre chaque mot ). 

Une fois votre personnage de créé, vous arriverez dans le menu, où vous pouvez sélectionner un donjon, ou alors
visualiser votre inventaire.

> **Note Importante :** Lorsque vous visualisez votre inventaire, vous êtes dans un état a part ! Afin de quitter l'inventaire et retourner dans l'êtat précédent, utilisez la commande qui est destiné a cet effet !

Si vous décidez d'entrer dans un donjon, vous serez présenté avec le contenu de la salle actuelle et avec un en-tête vous indiquant si vous pourrez quitter le donjon à l'issue de la salle.
Vous pouvez a tout moment ouvrir votre inventaire afin d'utiliser, équiper, déséquiper des objets.
Si vous décidez d'attaquer un ennemi, vous pouvez le faire avec ou sans utiliser de compétence. Celles-ci sont disponibles grace a votre classe ou bien avec un objet que vous avez équipé.
Vous pouvez les visualisez avec la commande qui est disponible a cet effet. En attaquant vous serez présenté avec un récapitulatif de tout ce qui s'est passé du moment ou vous avez attaqué, jusqu'a votre prochaine interaction.
Lorsque vous aurez tué les ennemies présents dans la salle, s'il est possible de quitter le donjon, il vous sera demander si vous voulez vraiment quitter ou continuer,
s'il n'est pas possible de quitter le donjon à cette salle, la suivante sera automatiquement lancée. Si vous arrivez à compléter le donjon en entier, vous serez renvoyé au menu principal avec les récompenses du donjon s'il y en a.

Si vous mourez au cours d'un combat, un message s'affichera et vous demandera si vous voulez être réanimé, si vous le désirez, utilisez la commande a cet effet.
Néanmoins, il faut garder en mémoire que vous perdrez une partie de votre inventaire et redescendrez à 1 point de vie. Il est vivement suggéré d'utiliser des objets qui soignent à ce moment-là.

## Informations Générales :

* Dans ce jeu, l'ensemble des entrées utilisateurs se font sous forme de commandes, qui ont une syntaxe précise, a l'exception de la phase de création du personnage.
* A tout moment, l'utilisateur peut voir les commandes disponibles grâce à la commande `help`
* Les entités qu'elles soient alliés ou ennemies dans les donjons n'ont pas de compétences spéciales, mais seulement leurs coups de bases, attention quand même les coups critiques sont possibles pour ces entités.
* Les coups critiques dépendent de votre *chance* dans vos statistiques, de ce fait un joueur ou une entité plus chanceuse, est plus apte à faire des coups critiques souvent, doublant le taux de dégâts infligés.
* Les phases de combat sont en tour par tour, dans le sens suivant `Joueur -> Alliés -> Ennemis`.
* Certains monstres peuvent laisser tomber des objets a leurs morts, néanmoins il y a un taux de chance pour que cet objet tombe, si vous trouvez un objet qui est tombé, vous en serez notifié dans le récapitulatif d'entre-deux tours.
* Certains objets sont à des fins de DEBUG afin de pouvoir expérimenter sur le jeu sans avoir a passer des sessions entières pour avoir les objets notamment l'objet appelé `ALL-MIGHT`.

## Objets et classes de DEBUG

### Classe
La classe **Dieu vivant** est disponible a des fins de test, cette classe vous donne des statistiques de 999 dans tous les domaines, et de ce fait, vous tuerez tous les enemies en un coup. Cela permet de passer plus rapidement les donjons pour tester des objets donnés par certains monstres et faire le déroulement du jeu en un coup.

### Objets 
Certains objets sont disponibles à des fins de test, pour pouvoir progresser plus rapidement.

* **ALL-MIGHT :** Une fois utilisé, cet objet vous donne tous les objets disponibles dans le jeu.
* **Potion d'expérience :** Donne au joueur un certain nombre d'expérience aléatoire une fois utilisé.
* **Pomme d'or :** Vous redonne 100 HP ( Points de vie ).

