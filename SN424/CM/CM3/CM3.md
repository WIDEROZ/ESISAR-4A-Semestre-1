# Bande de base
![[Pasted image 20261009133122.png]]
$$\boxed{x(t) = \sum_{k = 0}^{+ \infty} a_{k} \delta(t-kT) * h(t)}$$


# Emetteur sur fréquence porteuse
![[Pasted image 20261009132540.png]]


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
