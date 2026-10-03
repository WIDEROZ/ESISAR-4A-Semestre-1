# I - Rappels sur les processus
## 1 - Processus et organisation mémoire ('80s)

![[Pasted image 20261002114806.png]]
stack : adresses mémoires ou va piocher le PC pour avoir les instructions.
heap : allocation dynamique
bss : on en a pas parlé
data : global variables
text : code

#### 1.2 - Création d'un processus
Commandes fork 

#### 1.3 - Création d'un processus
```java
public class Example{
	static int a;
	static int b;
	
	public static void main(String[] args){
		a = 1;
		b = 2;
		int c = a+b;
		System.out.println("c=" + c);
	}
}
```

#### 2. Threads
Dans un processus il est possible de créerr plusiuers threads
#### 3. Synchronisation des threads
##### 3.1 - Exercice
Calculer : 
$$f(n) = \sum_{k = 0}^{n} \frac{1}{k} - \ln(n)$$
On suppose que l'on possède $T$ treads : 
$$f(n) = \sum_{i = 0}^{n-1}\sum_{k=(T-1) i /n}^{(T-1) (i+1)/n} \frac{1}{k} -\ln(n) $$


##### 3.2 La réantrance du code (Threadsafe)
Un code est dit threadsafe si il supporte une execution multithreading. 