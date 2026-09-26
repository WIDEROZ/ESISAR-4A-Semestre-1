
#### Définitions 
- ASIC : Application Specific Integrated Circuit
- FPGA : Field-Programmable Gate Array
- eFPGA : embeded FPGA
- DSP : Digital Signal Processor

#### SoPC
SoPC : System on Programmable Chip
Utilisation de processeurs dans les FPGA (Intel, ARM)


#### DSP vs FPGA
![[Pasted image 20260911103820.png]]

#### HLS (High level synthesis)
Outil permettant de transformer les algorithmes en RTL (Vivado HLx)

Lire : 
Conceptions de circuits numériques de S.derrien (Archive 2023)

# Rappels
- Logique Combinatoire/Sequentielle
- Machine à état
- FPGA
- Flot de conception
- Diapo SN360


### 1 - Machine de mealy pour la détection de fronts montants
![[Pasted image 20260918102439.png]]

#### Etape 1 - Définition du codage de l'état

| Etat | s(t) |
| ---- | ---- |
| s0   | 0    |
| s1   | 1    |


#### Etape 2 - Obtention de la table de vérité
| s(t) | i   | s(t+1) | o   |
| ---- | --- | ------ | --- |
| 0    | 0   | 0      | 0   |
| 0    | 1   | 1      | 1   |
| 1    | 0   | 0      | 0   |
| 1    | 1   | 1      | 0   |

#### Etape 3 - Equation logiques
$$\begin{cases}
s(t+1)& =  i \\
o& = \neg s(t) \wedge i
\end{cases}$$

#### Etape 4 - Obtention du circuit
![[Pasted image 20260918103734.png]]

Pour tout $\pi \in \mathbb{R}$ 

