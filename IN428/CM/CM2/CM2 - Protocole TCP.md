# I - Étude du protocole TCP
## I.1 Présentation
- Transmission control protocol (1974)
- Normalised by RFC 793

#### Propriétés TCP
- Transfert de message avec séquencement, sans pertes, sans duplications. 
- Service orienté connection
- Service adressant les processus

## I.2 - En-tête TCP
![[Pasted image 20260918134258.png|700]]
- $20 \, o$

## I.3 - Établissement de la connection
#### Début de la communication
![[Pasted image 20260503193330.png|700]]


#### Echanges de donnés
![[Pasted image 20260503193411.png]]

Si le paquet envoyé par $A$ est dupliqué alors, $B$ ignore simplement le deuxième paquet reçu mais envoie un ack. 


#### Fin de la communication
![[Pasted image 20260503193456.png]]



#### Saturation
A tout moment il peut ne plus avoir de place dans le tampon, alors, il ne faut pas que l'émetteur en envoie plus.
Donc dans chaque segment on a une annonce de fenêtre (quantité de place restante dans le tampon).
C'est le champ window dans l'en-tête TCP.
$$[\![0, 1024[\![ \, \, \neq [0, 1024[$$

![[Pasted image 20260423113325.png]]


# II - L'API des sockets TCP
## II.1 - Présentation Générale
#### Etape 1
Le server se déclare au près de la couche transport

#### Etape 2
Connection du premier client

#### Etape 3
Acceptation du premier client par le server

#### Etape 4
Echange des donnés

#### Etape 5
Libération de la connexion

## II.2
#### Phase $1$
Le server invoque $2$ méthodes : 
- socket() : socket d'écoute
- bind($n°$ port)

#### Phase $2$
Le client invoque : 
- socket() : socket de connexion
- connect(IP, port)

#### Phase $3$
Le server invoque la méthode accept()

#### Phase $4$
Le server peut lire et écrire dans la socket de connexion avec des read() et des write(). 

De même pour le client. 

#### Phase $5$
Le server invoque la méthode close() sur le socket de connexion.




