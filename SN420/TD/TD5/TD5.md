# Exercice 1
#### 1
RX/TX
![[Pasted image 20261106215534.png|503]]


RX = 01111
TX = 11001

#### 2
Initialisation
Transmettre
Recevoir
Déinitialisation

#### 3
T\_sym : Temps d'un bit
```
transmit(tx){
	write(start);
	wait(T_sym);
	for bit in tx:
		write(bit);
		wait(T_sym);
}
```

```
recieve(){
	rx = lire(pin);
	while(rx == start);
	wait(1.5*T_sym);
	rx = lire(pin)
	i = 0;
	while(rx != stop){
		message[i] = rx;
		wait(T_sym);
		rx = lire(pin);
		i++;
	}
	retrun message;
}
```

# Exercice 2
#### 1.
![[Pasted image 20261106230156.png]]

![[Pasted image 20261106230219.png]]

#### 3
01101001 - Demande de lecture de l'afficheur
00010011 - 1er ligne, 3eme colonne
01100111 - 

# Exercice 3
#### 2
Bit de start
12 bits d'ID

