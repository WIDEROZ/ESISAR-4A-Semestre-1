# II - Conception synchrone
Sans aléas la sortie vaudrait $1$


#### Capture involontaire des aléas
Pour éviter la capture d'aléas : 
![[Pasted image 20260918105508.png]]
Il faut que : 
$$\boxed{T_{clk} > T_{basc} + T_{\text{comb\_max}} + T_{setup}}$$

#### skew
Le skew est le temps entre deux mêmes fronts d'horloges à un endroit différent dans le circuit (longeur du cable / capacité)

#### Métastabilité
La métastabilité est un phénomène qui se manifèste lorsqu'un signal d'entré change d'état dans la plage de temps du $T_{\text{setup}}$ ainsi, le signal est dans un état intermédiaire :
![[Pasted image 20261028164327.png|337]]
Au bout d'un certain temps $T$ la métastabilité se résout d'elle même (Il existe tout de même une probabilité très faible pour qu'elle ne se résolve pas)
![[Pasted image 20261028161943.png|509]]

#### Synchroniseur double
Une solution pouvant réduire les ocurences du problème de métastabilité peut être d'introduire un synchroniseur double à l'entrée du circuit, de manière à bloquer l'état métastable entre les deux flips-flops en attendant que le problème se résolve : 
![[Pasted image 20261028164705.png|408]]

#### Handshaking
![[Pasted image 20261028165617.png|536]]


#### Nombre de flip-flops dans une machine à états
$$n_{FF} > \log_{2}(n_{State})$$
