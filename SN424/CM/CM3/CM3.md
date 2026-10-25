# Bande de base
![[Pasted image 20261009133122.png]]
$$\boxed{x(t) = \sum_{k = 0}^{+ \infty} a_{k} \delta(t-kT) * h(t)}$$


# Emetteur sur fréquence porteuse
![[Pasted image 20261015090538.png]]


#### Densité spectrale de puissance
Soit $(s_{n})$ la sortie du mapping (qui est stationnaire au sens large)
$$Y_{x}(f) = \left( \frac{\sigma_{s}^{2}}{T} + \frac{2}{T} \sum_{k = 1}^{+ \infty} \Gamma_{s}(k) \cos(2\pi kfT) + \frac{\left| m_{s}\right|^{2}}{T} \sum_{k = - \infty}^{+ \infty} \delta\left( f-\frac{k}{T} \right) \right) \left| H(f)\right|^{2}$$
- $m_{s} = \mathbb{E}(S_{n})$ : La valeur moyenne des symboles $s_{n}$
- $\sigma_{s}^{2} = \mathbb{E}(\left| s_{n} - m_{s}\right|^{2})$
- $\Gamma_{s}(k) = \mathbb{E}((s_{n}-m_{s})(s_{n-k}-m_{s})^{*})$ : Covariance des symboles $s_{n}$


$$\frac{1}{T} \left| H(f)\right|^{2} \sum_{k} R_{aa}(k) e^{ -2 \pi j fkT } + \frac{1}{T^{2}} \left| \mu_{a}\right|^{2} \sum_{k} \left| H\left( \frac{k}{T} \right)\right|^{2} \delta\left( f-\frac{k}{T} \right)$$

- $\mu_{a}$ est le premier moment des $a_{k}$
- $R_{aa}(k)$ est l'autocorrelation des $a_{k}$

#### Filtre adapté (Filtre pour le Récepteur)
Ce filtre permet de maximiser le rapport bruit/signal. 
Il réalise l'intercorelation entre le signal reçu et le filtre d'emission décalé : $h(t-t_{0})$
$$\boxed{R_{rh}(\tau) = \int_{\mathbb{R}} r(t)h(t-t_{0}-\tau) \, \mathrm{d}t }$$
# I - Signaux en bande étroite
Toutes les modulations peuvent être représentés par : 
$$x(t) = a(t) \cos(2 \pi f_{0}t + \varphi(t))$$
ou par un signal en quadrature
$$x(t) = \tilde{x}_{1}(t)\cos(2 \pi  f_{0}t) - \tilde{x}_{Q}(t)\sin(2 \pi f_{0}t)$$
- $\tilde{x}_{1} = a(t) \cos(\varphi(t))$ : Composante en phase
- $\tilde{x}_{Q} = a(t)\sin(\varphi(t))$ : Composante en quadrature


#### Symétrie Hermitienne
$$\boxed{X(f) = X^{*}(-f)}$$
#### Valeur principale de cauchy
$$vp(x(t)) = \lim_{ \varepsilon \to 0 } \left\{  \int_{- \infty}^{t-\varepsilon} x(\tau) \, \mathrm{d}\tau + \int_{t+\varepsilon}^{+ \infty} x(\tau) \, \mathrm{d}\tau    \right\} $$


#### Transformée de Hilbert
$$\boxed{x_{H}(t) = vp(x(t) * h(t))}$$
- $vp$ : valeur principale au sens de Cauchy
- $h(t) = \frac{1}{\pi t}$ : Le filtre de hilbert
Transformée de fourrier de $h$ : 
$$H(f) = -j \, \mathrm{sgn}(f) $$

#### Signal analytique
Le signal analytique $x_{a}(t)$ d'un signal à bande étroite $x(t)$ s'obtiens comme suit : 
$$\boxed{x_{a}(t) = x(t) + jx_{h}(t)}$$
La transformée de fourrier du signal analytique :
$$X_{a}(f) = \begin{cases}
2X(f) &\text{pour }f \geq 0 \\
0 & \text{sinon}
\end{cases}$$
![[Pasted image 20261015085238.png]]

#### Enveloppe complexe
$$\boxed{\tilde{x}(t) = x_{a}(t) e^{ -j 2 \pi f_{0}t }}$$
![[Pasted image 20261015085219.png|584]]

#### Récapituatif
![[Pasted image 20261015085432.png]]

# II - Signaux en Bande de base
#### Expression du signal en bande de base
Tout sinal modulé peut se représenter de cette manière
$$\begin{array}{l}
x(t) &= a(t) \cos(2 \pi f_{0}t + \varphi(t)) \\
&=\tilde{x}_{1}(t)\cos(2 \pi f_{0}t) - \tilde{x}_{Q}\sin(2 \pi f_{0}t)
\end{array}$$
alors, 
$$\boxed{\begin{array}{l}
\tilde{x}(t) &= a(t)e^{ j \varphi(t) }&\text{Enveloppe complexe} \\
&=\tilde{x}_{1}(t) + j \tilde{x}_{Q}(t)&\text{Signal analytique}
\end{array}}$$
#### Modulateur I/Q
![[Pasted image 20261015090648.png]]

#### Démodulateur I/Q
$$\tilde{x}(t) = LPF(2x(t)e^{ -2 \pi j f_{0}t }) = \tilde{x}_{1}(t) + j \tilde{x}_{Q}(t)$$
![[Pasted image 20261015091713.png]]

#### Modulations
$$\begin{cases}
1:&x(t) = Am(t) \cos(2\pi f_{0}t) \\
2:&x(t) = A(1+k_{a}m(t))\cos(2 \pi f_{0} t) \\
3:&x(t) = Am(t) \cos(2 \pi f_{0}t) \pm Am_{H}(t) \sin(2 \pi f_{0} t) \\
4:&x(t) = \text{pas d'expression}
\end{cases}$$
1 : Double Bande sans porteuse
2 : Double Bande avec porteuse
3 : Bande latérale unique
4 : Bande latérale réduite
