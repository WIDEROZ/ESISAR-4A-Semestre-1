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
Pour allumer la LED : 
```assembly
sbi PORTB 5
sbi $05 5
```

sbi met le bit du registre sélectionné à 1
cbi met le bit du registre sélectionné à 0

Pour éteindre la LED : 
```assembly
cbi PORTB 5
cbi $05 5
```

##### Inversion du mode entrée / sortie du port
Ou si l'on souhaite inverser la direction du port
Mode entrée : 
```assembly
cbi DDRB 5
cbi $04 5
```

Mode sortie : 
```assembly
sbi DDRB 5
sbi $04 5
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

|             | 4X                              | D                                                                | U                             |
| ----------- | ------------------------------- | ---------------------------------------------------------------- | ----------------------------- |
| Valeur      | $3.5 \, \text{mm}$              | $\pm 100 \, \text{ppm}$                                          | $-55 \to 135 °C$              |
| Description | Hauteur du conteneur du crystal | Variation de la précision de la fréquence suivant la température | Température de fonctionnement |

Au bout d'un an l'incertitude du crystal est de $\pm 5 \, \text{ppm}$. 
C'est à dire que la plage de fréquence du crystal sera de : 
$$16 \, MHz \pm \frac{5}{1\, 000\, 000}$$
