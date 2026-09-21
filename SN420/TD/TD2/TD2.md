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
Pour la deuxième le printf va lire le dico sans s'arrêter (car pas de caractère \0)

