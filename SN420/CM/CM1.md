# I - Définitions
#### Définition - Système embarqué
Ensemble de materiel et logiciel réalisant une ou plusieurs taches plus ou moins sévères. 

#### Définition - Microcontroleur (MCU, $\mu C$)
Circuit capable d'executer un programme et qui dispose d'interfaces avec le monde extérieur.

- Programmable (contient un microprocesseur MCP, $\mu P$)
- Communiquant
- Polyvalent
- Autonome

#### Définition ISA
Instruction Set Architecture
- RISC
- CISC

# II - Spécificités logicielles
## 1 - Langages
#### Text
| Assembleur        | C                                       |
| ----------------- | --------------------------------------- |
| `.section .text ` | Défini une section de code executable   |
| `.global toto`    | `void/int/char* toto(...);`             |
| `.weak toto`      | `__attribute__((weak)) void toto(...);` |

#### Data
| Assembleur        | C                                                   |
| ----------------- | --------------------------------------------------- |
| `.section .data ` | Défini une section contenant des donnés modifiables |
| `.global toto`    | `int/char* toto;`                                   |
| `.weak toto`      | `__attribute__((weak)) int/char* toto;`             |

#### Read Only Data

| Assembleur          | C                                             |
| ------------------- | --------------------------------------------- |
| `.section .rodata ` |                                               |
| `.global toto`      | `const int/char* toto;`                       |
| `.weak toto`        | `__attribute__((weak)) const int/char* toto;` |

pour : 
```C
const char* toto;
```
la donnée constante est la valeur de la chaine toto.
pour : 
```C
const* char toto;
```
la donnée constante est l'adresse de la chaine toto.


## 2 - Interruptions
#### Définition
Fonction asynchrone, ne prenant aucun argument et ne renvoyant aucune valeur appellée materiellement sur un évenement.
Son but est d'interrompre le programme en cours. 

#### Variable Volatile
Une variable volatile permet de signaler au compilateur que cette variable est suceptible de changer de valeur à n'importe quel moment. 

#### Interrupt & Boot Vector - Interrupt Vector Table - Vectored Interrupt Controller
Un microcontrolleur démarre à une adresse fixe, les interruptions sont a des adresses fixes connues. Ces adresses sont regroupés dans la table des interruptions (Interrupt & Boot Vector - Interrupt Vector Table - Vectored Interrupt Controller)


#### ABI (Applicatioon Binary Interface)
Interface de bas niveau entre les applications du système d'exploitation, entre une application et une bibliothèque ou bien entre différentes parties d'une même application.


## II - Documentation chez ST
![[Pasted image 20260914104048.png]]

## III - GPIO
![[Pasted image 20260914113528.png]]
#### Slew rate
C'est la vitesse à laquelle monte le signal (en prenant en distance les volts)
![[Pasted image 20260914111318.png]]

#### I/O Modes
![[Pasted image 20260914112139.png]]

# IV - Interruptions


# V - Timers
![[Pasted image 20260921111347.png]]

# VI - CAN
## 1 - Définition
Pas de quantification : 
$$q = \frac{V_{\max}-V_{\min}}{2^{n}-1}$$
## 2 - Bruits
Bruits à connaitre : 
- Bruits de quantification
- Bruit thermique
- Couplage et CEM

#### Bruit thermique
Relation de Nyquist : 
$$V_{b}^{2} = 4k_{b}TR \Delta f$$
- $V_{b}$ : Variance de la tension aux bornes de la résistance 
- $k_{b}$ : Constante de Boltzman
- $T$ : Température de l'expérience
- $R$ : Résistance
- $\Delta f$ : Bande passante considérée

## 3 - Propagation des incertitudes
Cas moyen : 
$$\Delta y^{2} = \sum_{i = 1}^{n} \left( \frac{\partial f}{\partial x_{i}} \Delta x_{i} \right)^{2}$$
Pire cas : 
$$\Delta y = \sum_{i = 1}^{n} \left| \frac{\partial f}{\partial x_{i}} \right| \Delta x_{i} $$


# VII - CNA
## 1 - Définition
Résultat de la convesion : 
$$V_{out} = \frac{N}{2^{n}-1}(V_{\max} - V_{\min}) + V_{\min}$$
Pas de quantification : 
$$q = \frac{V_{\max}-V_{\min}}{2^{n}-1}$$

# VIII - DMA


# IV - Horloge
