# 1 - Préparation individuelle
#### 1 - Escapade dans la documentation
|                     |            | Document           | Section | Page |
| ------------------- | ---------- | ------------------ | ------- | ---- |
| **Microcontrôleur** | ATmega328P | User Manual UNO R3 | 3.2     | 2    |
| **Port LED**        | PB5        | User Manual UNO R3 | 5       | 10   |
| **Pin LED**         | D13        | User Manual UNO R3 | 5       | 10   |

#### 2 - PB5 et D13
|         |                                                          | Document | Page |
| ------- | -------------------------------------------------------- | -------- | ---- |
| **PB5** | Le port PB5 est un registre du microcontrôleur           | Pinout   | 1    |
| **D13** | Le port D13 est un port GPIO utilisé par l'API d'arduino | Pinout   | 1    |

#### 3 - Configuration des registres pour la LED
Grâce au tableau 13-1 à la page 60 de la datasheet du microcontrôleur : ATmega328P, on peut controller l'état de la sortie de la LED. 
![[Pasted image 20261004174721.png]]

| Description                                |           | Document             | Section | Page |
| ------------------------------------------ | --------- | -------------------- | ------- | ---- |
| Allumer la LED (La mettre en sortie haute) | Bit 5 = 1 | ATmega328P Datasheet | 13.4.2  | 72   |
| Mettre le port en mode output              | Bit 5 = 1 | ATmega328P Datasheet | 13.4.3  | 72   |

![[Pasted image 20261004175032.png]]

#### 4 - Inverser le port PB5
L’énoncé est ambigu on distingue alors deux choix :
- Inverser la valeur de la LED
- Inverser la direction des donnés du registre (mode entrée ou sortie)

![[Pasted image 20261004180630.png]]
(Datasheet ATmega328P, Section 30, Page 280)
##### Inversion de la LED
```assembly
sbi $03, 5
sbi PINB, 5
```


#### 5 - Identification de l'oscillateur
| Référence                   | Document           | Section | Page |
| --------------------------- | ------------------ | ------- | ---- |
| ECS-160-20-4X-DU Oscillator | User Manual UNO R3 | 3.1     | 7    |

#### 6 - Précision des champs de l'oscillateur
![[Pasted image 20261004182932.png]]
![[Pasted image 20261004184641.png]]

|             | ECS    | 160                    | 20                 |
| ----------- | ------ | ---------------------- | ------------------ |
| Valeur      |        | $16.000 \, \text{MHz}$ | $20 \, \text{pF}$  |
| Description | Marque | Fréquence du crystal   | Capacité de charge |

|             | 4X                            | D                                                                | U                             |
| ----------- | ----------------------------- | ---------------------------------------------------------------- | ----------------------------- |
| Valeur      | $3.5 \, \text{mm}$            | $\pm 100 \, \text{ppm}$                                          | $-55 \to 135 °C$              |
| Description | Hauteur du package du crystal | Variation de la précision de la fréquence suivant la température | Température de fonctionnement |

Au bout d'un an l'incertitude du crystal est de $\pm 5 \, \text{ppm}$. 
C'est à dire que la plage de fréquence du crystal sera de : 
$$16 \, MHz \pm \frac{5}{1\, 000\, 000}$$

# 2 - GPIO
Fait un : 
```ino
#include
```


#### 1. PORTB
![[PORTB.bmp]]

#### 2 - PINB
![[PINB.bmp]]




#### Methode la plus rapide pour faire clignoter la LED
La méthode la plus rapide est celle avec le changement de registre PORTB. 
PINB fait :
```assembly
sbi 0x03, 5
cbi 0x03, 5
```
PORTB fait :
Fait un : 
```assembly
sbi 0x03, 5
cbi 0x03, 5
```
C'est le même registre modifié.
