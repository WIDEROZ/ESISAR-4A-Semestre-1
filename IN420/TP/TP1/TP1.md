# Partie I - Analyse du Robot de Cuisine



# Partie II - Et si on ajoutait une nouvelle fonctionnalité?
#### Question 5
Du côté de la modélisation, le robot ne peux pas être eteint lorsqu'il est dans le mode `SLOW_COOK` et `COOK` ce qui pose un problème si l'utilisateur à lancé le programme `SLOW_COOK` ou `COOK` par mégarde et qu'il ne peux pas l'arrêter. 

Du côté de l'implémentaton, tous les cas ne sont pas traités dans les méthodes. 
Par exemple dans la méthode : `switchOff()`, si le robot est dans l'état `SLOW_COOK`, l'utilisateur n'est pas prévenu que le robot est toujours dans l'état `SLOW_COOK` et qu'il ne peux pas s'étteindre, ce qui peut-être dangereux, si l'utilsateur ne se rend pas compte que le robot n'est pas éteint. 
De plus il manque aussi il manque aussi le traitement des cas non existants (else).


# Partie III - Analyse de la qualité du code


# Partie IV - Mise en place d'un logger
#### Question 7
La qualité du code s'améliore à la place d'obtenir 15 problèmes on obtiens uniquement $2$ problèmes. 
IMAGE

# Partie V - Test et couverture du code
#### Question 8
Il y a le même nombre de problèmes mais le pourcentage de couverture est plus élevé.

