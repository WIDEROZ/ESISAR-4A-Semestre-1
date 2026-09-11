# I - Rappels
## 1 - Fonctionnement d'Ethernet
#### Format adresse MAC
![[Pasted image 20260911140321.png]]
- Multicast : adresses IPV6 ou IPV4 $\to$ ethernet
- Unicast : Les $3$ premiers octets sont un OUI (Organisation Unit Identifier) : 
  Exemple : 
  + 00:01:42 : cisco
  + 00:08:83 : hp
+ Les $3$ derniers octets sont des numéros uniques pour ces OUI

#### Trame Ethernet
![[Pasted image 20260911140555.png|700]]
- PREAMBLE : Les $8$ premiers octets servent a la synchronisation
- Adresse de destination/source : Adresse MAC
- Longueur / Type : Si le champ est supérieur à $0x0600$ c'est un type (Signification différente suivant DIX ou 802.3)
- Données (de $46o$ à $1500o$)
- FCS : Frame Check Sequence (Checksum de $4o$) 

###### Taille min. / max. de la trame ethernet
- $\min = 72\, o$ (éviter les collisions)
- $\max = 1518\, o$

## 2 - IPv4
![[Pasted image 20260911142555.png]]
- Taille de $20\, o$ pour l'en tête IP

# II - UDP
## 1 - Intro
- RFC768
- Sans garantie de transmission
- Rapide

## 3 - En-tête
![[Pasted image 20260911143412.png]]
- $2^{16}-1 = 65535$ : Nombre de Ports disponibles

#### Cas d'utilisation d'UDP
- Server de temps (server NTP : Network time protocol)
- DNS

#### Calcul de l'Overhead UDP
Soit $P_{1}$ qui envoie un message UDP de $5$ octets à $P_{2}$
- Au niveau Ethernet, compter le nombre d'octets totaux échangés
- De même pour IP


![[Pasted image 20260911151242.png]]

Ethernet : 
$$\begin{array}{c}
\underbrace{22} &+& \underbrace{20}& +& \underbrace{8} &  +  & \underbrace 5\\
\text{En-tête Ethernet}&&\text{En-tête IP}&&\text{En-tête }&&\text{Message}
\end{array}$$
$$=55o$$
Or comme $55 < 72$ (Taille minimale pour une trame ethernet) alors, la taille de la trame ethernet est de $\boxed{72o}$

IP : 
$$33o$$


# III - Réaliser un programme communiquant par UDP
## 1 - Présentation générale

### Client
#### Phase $1$
Le server se déclare au près de la couche de transport

#### Phase $2$
Le client envoie un message sur le server.

#### Phase $3$
Le server lit le message

#### Phase $4$
Le server répond

### Server
#### Phase $1$
Le programme server invoque : socket(), bind(4000)

#### Phase $2$
Le programme client invoque socket(), send()

#### Phase $3$
le server invoque la méthode receive()

#### Phase $4$
Le server invoque la methode send()



#### Socket
Le socket est un structure qui contient une file de message et le process.


