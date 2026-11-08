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
$\text{Album}(\underline{\text{idAlbum}}, \text{titre})$
Photo(<span class="souligne-double">idAlbum</span><u>, numéro d'ordre</u>, titre, commentaire)
$\text{Photo}[\text{idAlbum}] \subseteq \text{Album}[idAlbum]$

##### 3 - Cardinalités 1..1
Fichier(<u>chemin</u>, conditions, <span class="souligne-dash">mail</span>)
Fichier$[\text{mail}]$ $\subseteq$ Client$[\text{mail}]$

Photo(<span class="souligne-double">idAlbum</span><u>, numéro d'ordre</u>, titre, commentaire, <span class="souligne-dash">chemin</span>)
Photo$[\text{chemin}]$ $\subseteq$ Fichier$[\text{chemin}]$

Livre(<span class="souligne-double">idAlbum</span>, préface, postface, <span class="souligne-dash">numero</span>)
Livre$[\text{numero}]$ $\subseteq$ Photo$[\text{numero}]$

##### 4 - Cardinalités 0..1
$\text{Album}(\underline{\text{idAlbum}}, \text{titre})$
$\text{SousTitre}(\underline{sousTitre})$

Table internal : 
R(<span class="souligne-double">id</span>, <span class="souligne-dash">sousTitre</span>)

Livre(<span class="souligne-double">idAlbum</span>, préface, postface)
Photo(<u>numéro d'ordre</u>, titre, commentaire)

Table internal : 
R(<span class="souligne-double">numéro d'ordre</span>, <span class="souligne-dash">idAlbum</span>)

##### 5 - Table internals


<span class="souligne-"></span>