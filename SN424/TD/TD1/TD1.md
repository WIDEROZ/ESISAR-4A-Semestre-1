# I - Transformée de fourrier et signaux
## Exercice 1
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


# II - Transformée de Laplace et système L.I.T.
## Exercice 3
#### Question 1
Loi des mailles : 
$$V_{e} = V_{s} + V_{c} $$
Alors en dérivant cette expression : 
$$\frac{d}{dt} V_{e}(t) = \frac{d}{dt}V_{s}(t) + \frac{i_{c}}{C} = \frac{d}{dt} V_{s}(t) + \frac{V_{s}}{RC}$$
Ainsi, 
$$\boxed{RC\frac{dV_{e}}{dt}(t) = RC\frac{dV_{s}}{dt}(t) + V_{s}(t)}$$

#### Question 2
Pont diviseur de tension ou par l'équation différentielle :
$${V_{s} (p) = \frac{R}{R + \frac{1}{p C}} V_{e}(p) = \frac{pRC}{1+pRC} V_{e}(p)}$$

$$\boxed{H(p) = \frac{\frac{p}{\omega_{0}}}{1+\frac{p}{\omega_{0}}}} \text{ avec } \omega_{0} = \frac{1}{RC}$$

#### Question 3
$$\boxed{H(f) = \frac{j \frac{f}{f_{0}}}{1+ j\frac{f}{f_{0}}} }\text{ avec }f_{0} = \frac{1}{2 \pi RC}$$
$$\begin{cases}
\left| H(\omega)\right| \underset{\omega \to 0}{=} 0 \\
\left| H(\omega)\right| \underset{\omega \to \infty}{=} 1
\end{cases} \text{ ainsi c'est un filtre } \boxed{\text{passe haut}}$$
On a : 
$$\left| H(f) \right| = \frac{\frac{f}{f_{0}}}{\sqrt{1 + \left( \frac{f}{f_{0}} \right)^{2}}}$$
$$G_{db}(f_{c}) = 20\log(\left| H(f_{c}) \right|) = -3 \, dB$$
Alors, 
$$ \frac{\left( \frac{f_{c}}{f_{0}} \right)^{2}}{1+\left( \frac{f_{c}}{f_{0}} \right)^{2}} = \frac{1}{2}$$
Ainsi, 
$$\boxed{f_{c} = f_{0} = \frac{1}{2 \pi RC}}$$

#### Question 4
Par le théorème de la valeur initiale et finale : 
$$\lim_{ t \to 0 } V_{s}(t) = \lim_{ p \to + \infty } p V_{s}(p) = + \infty$$
$$\lim_{ t \to + \infty } V_{s}(t) = \lim_{ p \to 0 } pV_{s}(p) = 0$$

#### Question 5
On pose : $u(t) = \begin{cases}1&\text{si }t \in [0, + \infty[\\0&\text{sinon}\end{cases}$
$$H(p) = \frac{p}{\omega_{0}+p} = 1- \frac{\omega_{0}}{\omega_{0}+p}$$
$$\boxed{{V_{s}(t) = \delta(t) -\omega_{0} e^{ -\omega_{0}t }u(t)= \delta(t)-\frac{1}{RC}e^{ -\frac{t}{RC} }}u(t)}$$
#### Question 6
$$V_{s}(p)=  \frac{1}{\omega_{0}+p}$$
$$\lim_{ t \to 0 } V_{s}(t) = \lim_{ p \to + \infty } p V_{s}(p) = 1$$
$$\lim_{ t \to + \infty } V_{s}(t) = \lim_{ p \to 0 } pV_{s}(p) = 0$$


#### Question 7
On pose : $u(t) = \begin{cases}1&\text{si }t \in [0, + \infty[\\0&\text{sinon}\end{cases}$

Alors,
$$H(p) = \frac{p}{\omega_{0}+p} \Leftrightarrow V_{s}(p)=  \frac{1}{\omega_{0}+p}$$
Ainsi : 
$$\boxed{V_{s}(t) = e^{ -\omega_{0} t }u(t)= e^{ - \frac{t}{RC} }u(t)}$$


## Exercice 4
#### Question 1
$$i(t) = i_{c}(t) + i_{r}(t) = C \frac{dV_{s}}{dt}(t)  + \frac{V_{s}(t)}{R}$$
Ainsi, 
$$\boxed{RC\frac{dV_{s}}{dt}(t) +  V_{s}(t) = R\frac{dq(t)}{dt}}$$

#### Question 2
$$\left( RCp+ 1 \right)V_{s}(p) = Rp\,q(p)$$
Ainsi, 
$$\boxed{H(p) = \frac{Rp}{1+ RCp}}$$

#### Question 3
$$\boxed{H(f) = \frac{2 \pi Rjf}{1+2 \pi RCjf}}$$
$$\boxed{H(\omega) = \frac{R j\omega}{1+RC j \omega} = H_{0} \frac{j \frac{\omega}{\omega_{0}}}{1+ j \frac{\omega}{\omega_{0}}}} \text{ avec : } \begin{cases}
H_{0} = \frac{1}{C} \\
\omega_{0} = \frac{1}{RC}
\end{cases}$$



#### Question 4
$$\lim_{ t \to 0} V_{s}(t) = \lim_{ p \to + \infty } pV_{s}(p) = H_{0} = \frac{1}{C}$$
$$\lim_{ t \to +\infty } V_{s}(t) = \lim_{ p \to 0 } pV_{s}(p) = 0$$

#### Question 5
$$V_{s}(p)= \frac{H_{0}}{\omega_{0} + p}$$
Ainsi, 
$$\boxed{V_{s}(t) = H_{0}e^{ -\omega_{0}t } = \frac{1}{C} e^{ -\frac{1}{RC}t }}$$

#### Question 6
Th de superposition. 
$$\boxed{V_{s}(t) = H_{0}(e^{ -\omega_{0}(t-1) } - 0.5 e^{ -\omega_{0}(t-2) } + 0.1 e^{ -\omega_{0}(t-3) })}$$
