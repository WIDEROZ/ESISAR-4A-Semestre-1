# Exercice 1
#### Question 1-2-3
```
x = 4eme bit a 1;
x = 4eme bit a 0;
a = lecture du 4eme bit de x uniquement;
```


#### Question 4
```
GPIOA_CRL = (GPIOA_CRL & (~((1<<12) | (1<<13) | (1<<15)))) | (1 << 14);
GPIOA_CRL = (GPIOA_CRL & (~((1<<20) | (1<<21) | (1<<23)))) | (1 << 22);
```

#### Question 5
```
A = GPIO_CRL;
A = A & (~ (7<<5));
  = A | (1 << 4);
```

# Exercice 3
#### Question 1
##### a.
Le microcontrolleur accepte jusqu'a $16 \, MHz$ de fréquence d'horloge

##### b.
15.9.2 - CTC Mode

##### c.
15.9.2 : 
Alors, 
On prend $N=64$ (prescaler) : 
$$\text{OCR1A} = \frac{f_{clk}}{2 N \, f_{OCR1A}}-1 = 124$$

##### d.
Register $A$ (TCCR1A) : $0000\, 0100$ 
Register $B$ (TCCR1B) : $0000 \, 1011$
Register $C$ (TCCR1C) : $0000 \, 0000$
TCNT1 : 0
$OCRA1$ : 124
TIMSK1 : $0000 \, 0010$
TIFR1 : 0


#### Question 2
##### a.
Période max de comptage :
$$2^{32} = 4.2949673 \times 10^{9}$$

##### b.
- Time base unit
- Counting mode
- Clock source
- Debug Mode


##### c.
Couples de valeurs possibles : 

| Préscaler | upcounter |
| --------- | --------- |
| 1         | 16000     |
| 2         | 8000      |
| 4         | 4000      |
| 5         | 3200      |
| 8         | 2000      |
| 10        | 1600      |
| 16        | 1000      |
| 20        | 800       |
| 25        | 640       |
| 32        | 500       |
| 40        | 400       |
| 50        | 320       |
| 64        | 250       |
| 80        | 200       |
| 100       | 160       |
| ?         |           |
| 160       | 100       |
| 200       | 80        |
| 250       | 64        |
| 320       | 50        |
| 400       | 40        |
| 500       | 32        |
| 640       | 25        |
| 800       | 20        |
| 1000      | 16        |
| 2000      | 8         |
| 4000      | 4         |
| 8000      | 2         |
| 16000     | 1         |
|           |           |



Valeures possibles : 
$$[\![1, 2^{16}]\!]$$


$$\text{OCR1A} = \frac{f_{clk}}{2 N \, f_{OCR1A}}-1 = 124$$
	