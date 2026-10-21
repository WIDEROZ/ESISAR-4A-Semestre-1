# Ennoncé
La société de tirage de photos numériques sur l'internet PhotoNum désire revoir son application de gestion de photos afin de pouvoir offrir de nouveaux services à ses clients. Pour cela, elle envisage d'utiliser une base de donnés relationnelle. 
Un client, identifié par son adresse mail, est décrit par ses nom et prénom, son adresse postale, ainsi qu'un mot de passe, pour son authentification à la connexion au site de PhotoNum.
Chaque client identifié peut télécharger sess fichiers image, identifiés par leur chemin d'accès sur le serveur, afin de pouvoir commander des tirages. Un certain nombre d'informations sur les conditions de la prise de vue sont ajoutés à chaque fichier image : l'appareil photo et l'objectif utilisés, la distance focale, la sesnsibilité ISO, l'ouverture, la vitesse d'obturaton et les dimensions de l'image.
Un album, identifié de façon unique, est une collection de photos, Il comporte un titre et un éventuel sous-titre. Pour un libre, le client précise quelle photo, parmi celles contenues dans le livre, doit figurer sur la couverture. 
Chaque photo contenue dans un album ou dans un livre est identifié par son numéro d'ordre et correspond à un fichier image téléchargé. De plus, un titre et un commentaire sont associés à chaque photo d'un album ou d'un livre. 

#### I - Faire le modèle entité/association de l'application PhotoNum
![[Pasted image 20261014165607.png]]

#### II - Ecrire le schéma relationnel
##### 1 - Sous entités
$$\begin{array}{l}
\text{Album}(\underline{\text{id}}, \text{titre}) \\
\text{Livre}(\underline{\underline{\text{id}}}, \text{préface}, \text{postface}) \\
\text{Livre}[\text{id}] \subseteq \text{Album}[id]
\end{array}$$

#### 2 - Entités faibles
$$
\begin{array}{l}
\text{Album}(\underline{\text{id}}, \text{titre}) \\
\text{Photo}(\underline{\text{id}, \text{numéro d'ordre}}, \text{Titre}, \text{Commentaire}) \\
\text{Photo}[\text{id}] \subseteq \text{Album}[id]
\end{array}
$$
![[Pasted image 20261014171533.png]]
##### 3 - Cardinalités 1..1
$$\begin{array}{l}
\text{Fichier}
\end{array}$$
