# Exercice 1
On est en 32 Bits
#### 1.
$5$ symmboles

#### 2.
| Symbole | Calcul                    | Taille (en  bit) | Taille (en octet) | Emplacement mémoire |
| ------- | ------------------------- | ---------------- | ----------------- | ------------------- |
| tabs    | $4 \times 32$             | 128              | $16$              | $0\text{x}20000000$ |
| tab1    | $5 \times 8 + 4 \times 8$ | 72               | $9$               | $0\text{x}20000010$ |
| tab2    | $8 \times 8$              | 64               | $8$               | $0\text{x}20000019$ |
| tab3    | $4 \times 16$             | 64               | $8$               | $0\text{x}20000021$ |
| tab4    | $4 \times 8$              | 32               | $4$               | $0\text{x}20000029$ |

#### 3.
| Little Endian$_{(16)}$ | Adresse      | Big Endian$_{(16)}$ |
| ---------------------- | ------------ | ------------------- |
| $10$                   | $0x20000000$ | $20$                |
| $00$                   | $0x20000001$ | $00$                |
| $00$                   | $0x20000002$ | $00$                |
| $20$                   | $0x20000003$ | $10$                |
|                        | $\vdots$     |                     |
| 00                     | $0x20000010$ | 00                  |
| 01                     | $0x20000011$ | 01                  |
| F1                     | $0x20000012$ | F1                  |
|                        | $\vdots$     |                     |
|                        |              |                     |


#### 4.
NON


#### 5.
```C
void *tabs[] = {tab1, tab2, tab3, tab4};
char tab1[] = {0x00, 0x01, 0xf1, 'S'+0x20, 98, 'a', 'b', 'c', '\0'};
char tab2[] = {'B', 'o', 'n', 'j', 'o', 'u', 'r', '\0'};
unsigned short tab3[] = ...;
short tab4[] = ...;
```


# Exercice 2
#### 1.
On pose $N=13900$

|                | MEM      |
| -------------- | -------- |
|                |          |
| $+7N \uparrow$ |          |
| $0x37$         | abatee   |
| $0x30$         | abaque   |
|                | ?        |
| $+4N \uparrow$ | $\vdots$ |
| dico           | $0x30$   |
|                |          |


|        | MEM    |
| ------ | ------ |
|        |        |
| $+6n$  |        |
| dico+6 | abatee |
| dico   | abaque |



#### 2.
Pour le cas 1 :
Pour stocker l'adresse : $4$
Pour stocker le mot : $7$
$$(4+7)N = 11N = 152.9 \, kB$$


Pour le cas 2 :
Pour stocker le mot : $6$
$$6N = 83.4 \, kB$$

#### 3.
Pas assez de mémoire flash pour le cas $1$
Mais assez de SRAM (adresse des pointeurs) : 
$$4N = 55,6 \, kB$$

#### 4.
On peux changer la taille des mots pour le première.
Pour la deuxième le printf va lire le dico sans s'arrêter (car pas de caractère `\0`)


# Exercice 4
#### 1.
$$\begin{cases}
\max &:& 2^{E-1} + 2^{-F} \\
\min &:& -2^{E-1}&
\end{cases}$$

#### 2.
$$\begin{array}{c}
\text{E}&\text{F}&Q_{2.6}&\text{Décimal} \\
10&000111 & -2 + 2^{-4} + 2^{-5} + 2^{-6}&-1.890625 \\
00&110100 & 2^{-1} + 2^{-2} + 2^{-4}&0.8125 \\
01&011000 & 2^{0} + 2^{-2} + 2^{-3}&1.375 \\
11&000100 & -2^{1} + 2^{0} + 2^{-4}&-0.9375
\end{array}$$

On divise sinon le chiffre hexa par $2^{F}$. 

#### 3.
$$\begin{array}{c}
\text{Decimal}&\text{E}&\text{F}&\text{Hexa}\\
\pi&011&00100 &0x64 \\
-\pi&100&11100 &0x9c & \text{complément à 2} \\
\sqrt{2}=1.41421&001&01101&0x2D \\
1.5&001&10000&0x30 \\
-1.2345&110&11001&0xD9 & \text{complément à 2}
\end{array}$$

#### 4.
$$\frac{15}{128}_{Q_{1.7}}$$
$$\frac{100}{128} \times \frac{64}{128} = \frac{50}{128}_{Q1.7}$$
$$\frac{84 \times 65}{128^{2}} = \frac{5460}{128^{2}} \text{ or } 5460 = 1010101010100$$
Alors $5460\gg 7 = 42$ ainsi $\frac{5460}{128^{2}} = \frac{42}{128}$
$$\frac{8}{128} \div \frac{96}{128} = \frac{10}{128}$$
