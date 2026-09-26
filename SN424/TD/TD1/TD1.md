# Exercice 1
#### 2.
$$x(t) = \mathrm{Rect}_{T}(t)$$
Alors :
$$X(f) = \int_{-\frac{T}{2}}^{\frac{T}{2}} e^{ -2j\pi ft }\, dt = -\frac{1}{2 \pi j f }[e^{ -2j \pi ft }]_{-\frac{T}{2}}^{\frac{T}{2}} $$
$$= \frac{1}{2 \pi jf} (e^{ -j \pi fT } - e^{ j \pi fT })= T\frac{e^{ j \pi fT } - e^{ - j \pi ft }}{2 j \,\,\, \pi fT} = T \mathrm{sinc}(\pi fT)$$

Ainsi, 
$$\boxed{X(f) = T\mathrm{sinc}(\pi fT)}$$

#### 3.
Pour $T=3$
![[Pasted image 20260924103514.png]]

#### 4.
![[Pasted image 20260924103927.png]]

#### 5.
$$x(t) = \mathrm{Rect}_{T}\left( t-\frac{T}{2} \right) = \mathrm{Rect}_{T}\left( t \right) * \delta\left( \frac{T}{2} \right)$$
$$X(f) = TF[\mathrm{Rect}(t)]\times TF\left[ \delta\left( \frac{T}{2} \right) \right] = T\mathrm{sinc}(\pi fT) \times e^{ -j\pi fT }$$
$$X(f) = T\mathrm{sinc}(\pi fT)e^{ -j\pi fT } = \frac{1}{2j \pi f} (1 - e^{ -2\pi j fT  })$$


#### 6.
![[Pasted image 20260924104849.png]]

![[Pasted image 20260924105155.png]]

![[Pasted image 20260924105252.png]]

#### 7.
$$\begin{array}{ll}
X(f) &= TF[\cos(2\pi f_{0}t)] * TF\left[ \mathrm{Rect}_{T}\left( t-\frac{T}{2} \right) \right]  \\
&=  TF[\cos(2\pi f_{0}t)] * TF\left[ \mathrm{Rect}_{T}\left( t \right) \right] \times TF\left[ \delta\left( \frac{T}{2} \right) \right]  \\
&=  \frac{\delta(f-f_{0}) + \delta(f+f_{0})}{2} * T\mathrm{sinc}(\pi fT) e^{ -2j \pi fT }   \\
&=\frac{T}{2}(\mathrm{sinc}(\pi T (f-f_{0}))e^{ -2j \pi (f-f_{0})T } + \mathrm{sinc}(\pi T (f+f_{0})))e^{ -2j \pi (f+f_{0})T }
\end{array}$$
Ainsi, 
$$\boxed{X(f) = \frac{T}{2}(\mathrm{sinc}(\pi T (f-f_{0}))e^{ -2j \pi (f-f_{0})T } + \mathrm{sinc}(\pi T (f+f_{0}))e^{ -2j \pi (f+f_{0})T })}$$

![[Pasted image 20260924110906.png]]

On observe le signal sur une durée finie. 

# Exercice 2
#### 1.
$$Y(f) = TF[x(-t)^{*}] = \int _{\mathbb{R}} x(-t)^{*}e^{ -2 \pi j ft } \, \mathrm{d}t  $$
$$\underset{t \mapsto -t}{=}- \int _{- \infty}^{+ \infty} x(t)^{*} e^{ 2 \pi j ft } \, \mathrm{d} t $$
$$= \int_{\mathbb{R}} x(t)^{*} (e^{ -2 \pi j ft })^{*} \, \mathrm{d}t = \left( \int_{\mathbb{R}} x(t)e^{ -2 \pi j ft } \, \mathrm{d}t \right)^{*} = X(f)^{*}$$

#### 2.
