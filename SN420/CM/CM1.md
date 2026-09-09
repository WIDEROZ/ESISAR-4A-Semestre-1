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