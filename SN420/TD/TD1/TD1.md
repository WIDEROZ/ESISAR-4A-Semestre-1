# Exercice 2
### 1.
$$\begin{cases}
1 & 0x5F + 0x1A = 95 + 31 = 126 = 0111 \, 1001 = 0x79 \\
2 & 0xFF + 0x01 = 0x100 \\
3 & 0x5F + 0x60 = 95 + 96 = 191 = 0xBF = 0b1001 \, 1111 \\
4 & 0x83 + 0xAB = 0x12E = 0b1 \, 0010 \, 1110
\end{cases}$$

#### 2.
$$\begin{array}
&&C&N&Z&V \\
1&0&0&0&0 \\
2&1&0&1&0 \\
3&0&1&0&1 \\
4&1&0&0&1
\end{array}$$

#### 3.
Résultat : $2n$ bits max

#### 4.
$$\begin{cases}
1&0x10 \times 0x03 = 48 = 0x30 & \text{Valide}\\
2& 0x5F \times 0x0A = 95 \times 10 = 950 = 0x3B6& \text{Dépassement} \\
3& 0x80 \times 0x80 = 0x00&\text{Dépassement signé}
\end{cases}$$

# Exercice 3
#### 1.
$$24\times 10^{6} Hz$$
#### 2.
Une interruption correspond a un jump $\Leftrightarrow$ on à entre $1$ et $10$ cycles pour une interruption
On prend $5$ cycles.

#### 3.
| $\mu C$            | A                        | B                                 | C                                  |
| ------------------ | ------------------------ | --------------------------------- | ---------------------------------- |
| $MHz$              | 32                       | 64                                | 80                                 |
| Save reg.          | PC                       | 8 reg                             | 4 reg                              |
| Temps Cycle        | $2\times (3+1)=8$ cycles | $2\times (3 + 1 + 8) = 24$ cycles | $2 \times( 3 + 1 + 4) = 16$ cycles |
| Temps interruption | 20 cycles                | 20 cycles                         | 20 cycles                          |
| Total              | 33                       | 43                                | 35                                 |
Le micro 
#### 4.
| $\mu C$            | A                                | B                                         | C                                           |
| ------------------ | -------------------------------- | ----------------------------------------- | ------------------------------------------- |
| $MHz$              | 32                               | 64                                        | 80                                          |
| Save reg.          | PC                               | 8 reg                                     | 4 reg                                       |
| Temps Cycle        | $2\times (3+1)=2\times 8$ cycles | $2\times (3 + 1 + 8) = 2\times 24$ cycles | $2 \times( 3 + 1 + 4) = 2 \times 16$ cycles |
| Temps interruption | 20 cycles                        | 20 cycles                                 | 20 cycles                                   |
| Total              | 41                               | 61                                        | 45                                          |

# Exercice 5
#### 1.
Boucle : 
$2$ pointeurs (signal et res)
$1$ valeur de comparaison $10$
$1$ compteur $j$

$3$ vars : (signal, sum, filtre)
$1$ variable calcul de multiplication

#### 2.
$$10N \text{ itérations de la boucle interne}$$

$1$ : $j++$
2 : $i-5+j$
1 : signal * filtre
$1$ :  sum += ...

mem access :
signal\[i-5+j\] et filtre\[j\]

#### 3.

