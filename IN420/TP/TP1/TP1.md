# Partie I - Analyse du Robot de Cuisine
#### Question 1
![[IN420/TP/TP1/Images/Screens/Question 1.png]]

#### Question 2
![[IN420/TP/TP1/Images/Screens/Question 2.png]]

# Partie II - Et si on ajoutait une nouvelle fonctionnalité?
#### Question 3
![[Question 3 Class Diagram.png]]

![[IN420/TP/TP1/Images/Screens/Question 3 State Diagram.png]]


#### Question 5
Du côté de la modélisation, le robot ne peux pas être eteint lorsqu'il est dans le mode `SLOW_COOK` et `COOK` ce qui pose un problème si l'utilisateur à lancé le programme `SLOW_COOK` ou `COOK` par mégarde et qu'il ne peux pas l'arrêter. 

Du côté de l'implémentaton, tous les cas ne sont pas traités dans les méthodes. 
Par exemple dans la méthode : `switchOff()`, si le robot est dans l'état `SLOW_COOK`, l'utilisateur n'est pas prévenu que le robot est toujours dans l'état `SLOW_COOK` et qu'il ne peux pas s'étteindre, ce qui peut-être dangereux, si l'utilsateur ne se rend pas compte que le robot n'est pas éteint. 
De plus il manque aussi il manque aussi le traitement des cas non existants (else).
Il existe aussi des cas redondants.  


# Partie III - Analyse de la qualité du code
#### Question 6
Il y a en tout $15$ problèmes critiques résumés en deux types : 
- Remplacer print classique par un Logger
- Il y a plusieurs lignes de code redondantes

On peut donc en déduire qu'une seule partie de l'analyse a été prévue. 
![[Question 6.1.png]]
![[Question 6.2.png]]

# Partie IV - Mise en place d'un logger
#### Question 7
La qualité du code s'améliore à la place d'obtenir 15 problèmes on obtiens uniquement $2$ problèmes. 
![[Question 7.png]]

# Partie V - Test et couverture du code
#### Question 8
Il y a le même nombre de problèmes mais le pourcentage de couverture est plus élevé.

# Partie VI - Refactoring du code
#### Question 9
Le principal intérêt du state pattern est de basculer d'un état à un autre en prenant en compte l'état précédent sans avoir besoin de savoir par quel état intermédiaire passer.
Dans notre cas cela pourrait être utile de passer de l'état `COOK` à l'état `OFF` sans avoir besoin de savoir qu'il faut transiter par l'état `ON`.

#### Question 10
Le diagramme de classes donné dans la Figure 2 semble respecter le modèle général donné dans le patron de conception : 
- Context : CookBot
- State : CookBotState
- Concrete States : `CookState`, `OnState`, `OffState`

Utiliser une interface plutôt qu'une classe abstraite semble plus approprié dans cette situation car les états n'ont aucun comportement en communs donc chaque état est autonome.

#### Question 11
![[IN420/TP/TP1/Images/Screens/Question 11.png]]
#### Question 12
SonarQube pas installé
