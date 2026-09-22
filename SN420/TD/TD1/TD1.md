# Exercice 1
#### 1.
Non signé : $[\![0, 2^{n}-1]\!]$ 
Signé : $[\![-2^{n-1}, 2^{n-1}-1]\!]$


# Exercice 2
#### 1.
$$\begin{cases}
1 & 0x5F + 0x1A &= 0x79 &= 112 +9 &= 121 \\
2 & 0xFF + 0x01 &= 0x100 &&= 256 \\
3 & 0x5F + 0x60 &= 0xBF &= 176 + 15 &=191  \\
4 & 0x83 + 0xAB &= 0x12E &= 256 + 32 + 14 &=302
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
$$24\,Mz$$

#### 2.
Une interruption correspond a un jump $\Leftrightarrow$ on à entre $1$ et $10$ cycles pour une interruption
On prend $5$ cycles.

#### 3.

| $\mu C$                 | A                  | B                  | C                  |
| ----------------------- | ------------------ | ------------------ | ------------------ |
| Fréquence $\mu C$ (Mhz) | 32                 | 64                 | 80                 |
| Registres + PC          | (1 + 3) $\times$ 2 | (9 + 3) $\times$ 2 | (5 + 3) $\times$ 2 |
| Calcul + Interrupt      | 20                 | 20                 | 20                 |
| Interruption            | 5                  | 5                  | 5                  |
| Cycles totaux           | 33                 | 49                 | 41                 |
| Fréquence Totale (MHz)  | 0.96               | 1.31               | 1.95               |
| Temps total ($\mu s$)   | 1.04               | 0.76               | 0.51               |

#### 4.

| $\mu C$                 | A                               | B                               | C                               |
| ----------------------- | ------------------------------- | ------------------------------- | ------------------------------- |
| Fréquence $\mu C$ (Mhz) | 32                              | 64                              | 80                              |
| Registres + PC          | ((1 + 3) $\times$ 2) $\times$ 2 | ((9 + 3) $\times$ 2) $\times$ 2 | ((5 + 3) $\times$ 2) $\times$ 2 |
| Calcul + Interrupt      | 20                              | 20                              | 20                              |
| Interruption            | 5                               | 5                               | 5                               |
| Cycles totaux           | 41                              | 73                              | 57                              |
| Fréquence Totale (MHz)  | 0.78                            | 0.88                            | 1.40                            |
| Temps Total ($\mu s$)   | 1.28                            | 1.14                            | 0.71                            |

# Exercice 4
#### 1.
$$\boxed{C = n \log_{2}(n) = 49\,152 \text{ calculs}}$$
$$10C = 491\,520$$
Alors, 
$$\boxed{\frac{10C}{100\times 10^{6}}  \approx 5 \, \text{ms}}$$

#### 2.
$$\boxed{\frac{10C}{1\times 10^{6}}  \approx 0.5 \, \text{s}}$$
Si le signal est en dessous de $2\, Hz$ le calcul est faisable.
Sinon c'est compliqué.

#### 3.
- Échantillonner plus rapidement le signal 
- Réduire le nombre d'échantillons



# Exercice 5
#### 1.
| Algo                   | Addr & boucle      |
| ---------------------- | ------------------ |
| sum                    | j                  |
| signal $\times$ filtre | return addr (jump) |
| i-5+j                  | 10                 |
| signal                 |                    |
| filtre                 |                    |

En cours : 
Boucle : 
$2$ pointeurs (signal et res)
$1$ valeur de comparaison $10$
$1$ compteur $j$

$3$ vars : (signal, sum, filtre)
$1$ variable calcul de multiplication



#### 2.
```C
void moving_average10(int* signal, int* res, int N) {
	int i, j;
	for (i = 0; i < N; ++i){
		int sum = 0;
		for(j = 0; j < 10; ++j){
			... // Ignore out-of-bound access
			sum += signal[i-5+j]*filtre[j];
		}
		res[i] = sum;
	}
}
```

$$10N$$
Nombre de multiplications : 
$$10N \times 1 = 10N$$
Nombre d'additions : 
$$10N \times 3 = 30 N$$
Memory access :
$$10N \times 2 = 20N$$



|                 |                 |
| --------------- | --------------- |
| Multiplications | $1 \times 10N$  |
| Additions       | $3 \times 10 N$ |
| Mem access      | $2 \times 10 N$ |


#### 3.
| $\mu C$                                    | A              | B              | C               |
| ------------------------------------------ | -------------- | -------------- | --------------- |
| Fréquence $\mu C$                          | 32             | 64             | 120             |
| Additions                                  | $30N$          | $30N$          | $30N$           |
| Multiplications                            | $10N$          | $10N$          | $2 \times 10 N$ |
| Mem. Access                                | $2 \times 20N$ | $20N$          | $2 \times 20 N$ |
| Branchements                               | $3 \times 10N$ | $3 \times 10N$ | $3 \times 10N$  |
| Cycles Totaux                              | $110N$         | $90N$          | $120N$          |
| Cycles pour $1024$ échantillons            | $112640$       | $92160$        | $122880$        |
| Fréquence pour $1024$ échantillons (en Hz) | $284$          | $694$          | $977$           |
| Taille maximale du signal                  | $1164$         | $2844$         | $4000$          |

#### 4.
La fréquence maximale de ce filtre est de $901.6 \, \text{Hz}$

#### 5.
$$\frac{F_{\mu C}}{F_{algo}} = kN \Leftrightarrow N=\frac{F_{\mu C}}{kF_{algo}}$$

| $\mu C$         | A         | B         | C        |
| --------------- | --------- | --------- | -------- |
| Fréquence (MHz) | 32        | 64        | 120      |
| $N$             | $1\, 067$ | $2\, 560$ | $3\,693$ |


#### 6.
Le nombre d'opérations dans la boucle interne est bien plus important qu'a l'extérieur :
- $res[i]$ (mem. access)
- for (branch)

