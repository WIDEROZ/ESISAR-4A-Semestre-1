# I - Définitions
"Les signaux discrets" : dans ce cours le seront en temps
On parlera de signaux quantifiés lorsqu'ils seront discretisés en amplitude.
$$$$
#### Produit scalaire
$$\left< x | y \right> = \int _{-\infty}^{+ \infty} x(t)y^{*}(t) \, dt $$
#### Autocorrelation
$$R_{XX}(\tau) = \int _{-\infty}^{+ \infty} x(t) x^{*}(t - \tau) \, dt $$

#### Intercorrelation
$$R_{XY}(\tau) = \int _{-\infty}^{+ \infty} x(t)y^{*}(t-\tau) \, dt $$

#### Convolution
$$x(t) * y(t) = \int _{- \infty}^{+ \infty} x(\tau)y(t-\tau) \, d\tau $$


# II -Transformée de fourrier
#### Définition
$$\boxed{X(f) = \int _{-\infty}^{+ \infty} x(t) e^{ -2 \pi jft } \, dt }$$

#### Propriétés
Homotétie : 
$$TF(x(at)) = \frac{1}{\left| a\right|} X\left( \frac{f}{a} \right)$$
Transltation : 
$$TF(x(t-\tau)) = X(f) e^{ -j 2\pi f\tau }$$
Modulation : 
$$TF(x(t) e^{ 2 \pi f_{0}t }) = X(f + f_{0})$$
Convolution : 
$$TF(x(t) * y(t)) = X(f) \times Y(f)$$

Multiplication : 
$$TF(x(t) \times y(t)) = X(f) * Y(f)$$

#### Transformés usuelles

![[Pasted image 20260909140605.png]]

#### Différentes transformés de fourrier
![[Pasted image 20260909140631.png]]

#### FFT
![[Pasted image 20260909141147.png]]

# III - Transformée de Laplace
#### Définition
On pose : $p = \sigma + j 2\pi f$
$$X(p)=  \int_{0}^{+ \infty} x(t) e^{ -p t } \, dt $$

#### Dérivation
$$TL\left( \frac{d^{(n)}}{d t^{n}} x(t) \right) = p^{n}X(p) - \sum_{k = 0}^{n-1}p^{k} \frac{d^{(n-k-1)}}{dt^{n-k-1}} x(0)$$

#### Théorème de la valeur initiale / finale
$$\lim_{ t \to 0 } x(t) = \lim_{ p \to \infty } pX(p)$$
$$\lim_{ t \to \infty } x(t) = \lim_{ p \to 0 }pX(p) $$

#### Tansformés de Laplace usuelles
![[Pasted image 20260909141733.png]]


## Filtrage
$$H(f) = \left| H(f)\right| e^{ j \varphi(t) }$$
#### Temps de propagations
$$\begin{cases}
\tau_{\phi}(t) = - \frac{\varphi(t)}{2\pi f} \\
\tau_{g}(t) = -\frac{1}{2\pi} \frac{d \varphi(t)}{df}
\end{cases}$$
#### Filtre a phase linéaire
$$\tau_{\phi}(t) = \tau_{g}(t)$$

#### Critère de shanon
$$f_{e}> 2f_{\max}$$
![[Pasted image 20260909145100.png]]


#### Échantillonneur Bloqueur
Bloqueur d'ordre $0$ 
![[Pasted image 20260909145429.png]]