# Exercice 1
#### Question 1
$$Q = \frac{5-0}{2^{10}} = 0.0048828125$$

#### Question 2
$$q = \left\lfloor 0.3 \times \frac{2^{10}}{5} \right\rfloor  = 61$$
$$-0.2 V \Rightarrow q = 0$$
$$q = \left\lfloor 2.8 \times \frac{2^{10}-1}{5}  \right\rfloor = 573$$
$$q = \left\lfloor 4.56 \times \frac{2^{10}-1}{5}  \right\rfloor = 934$$
$$q = \left\lfloor 5.3 \times \frac{2^{10}-1}{5}  \right\rfloor = 1084$$


#### Question 3
$$V = \frac{5}{2^{10}-1}q$$

$$V = \frac{5}{2^{10}-1}\times 123 = 0.6 V$$
$$V = \frac{5}{2^{10}-1}\times 42 = 0.205 V$$
$$V = \frac{5}{2^{10}-1} \times 834= 4.08 V$$

#### Question 4
Format virgule fixe en base $10$ : $1$ pour la partie entière et $3$ pour la partie fractionnaire. ($5V$ au max et un décalage de $0.004$ voir question 1)

Correction : 
$$\begin{cases}
N= V \times k \\
k = \frac{1}{q}
\end{cases}$$

#### Question 5
$$\sum_{i = 0}^{\alpha -1} \alpha_{i}x_{n-i} = y_{n}$$
- $\alpha_{i} = \frac{N_{i}}{2^{15}}$ : $Q_{1, 15}$
- $x_{n-i} = \frac{V_{n-i}}{q} = N_{n-i}$ : $N = V_{in} \times k = \frac{V_{in}}{q}$

Alors, 
$$y_{n} = \sum_{i = 0}^{\alpha-1} \frac{N_{i}V_{n-i}}{2^{15}q}$$
Ainsi, 
$$k' = \frac{1}{2^{15}} \times \frac{1}{q}$$

#### Question 6
$$y_{n} = \sum_{i = 1}^{\alpha-1} \frac{N_{i}}{2^{15}} \frac{V_{n-i}}{q}$$
Il faut faire $15$ bit shifts a droite pour faire une mise à l'echelle du filtre.
Le CNA enlève automatiquement le facteur $\frac{1}{q}$ (sous réserve des mêmes paramètres $V_{\min}, V_{\max}, n$)


# Exercice 2
#### Question 1
$$\boxed{R_{T, -50} = R +\Delta r_{T} = R +\alpha T = 100-50 \times 0.4 = 80}$$
$$\boxed{R_{T, -50} = R +\Delta r_{T} = R +\alpha T = 100+50 \times 0.4 = 120}$$

#### Question 2
$$\boxed{r = \frac{V_e}{V_{s}} \Delta r_{T} = \frac{5}{0.1} \times (50 \times 0.4) = 50 \times 20 = 1000 \, \Omega}$$

#### Question 3
$$\boxed{q = \frac{V_{\max}-(-V_{\max})}{2^{10}-1} = \frac{V_{\max}}{2^{10}-1} = \frac{10}{2^{10}-1} \approx 10 \, mV}$$
$${e = \frac{q}{2} = 5 \, mV}$$

$$V_{s} = e$$
$$\Delta r_{T} = \frac{V_{s}}{V_{e}}r = \frac{e}{V_{e}}r = 1$$
Ainsi, 
$$\Delta r_{T} = 1 = \alpha T \Leftrightarrow \boxed{\varepsilon (T) = 2.5 °C}$$
Cet écrat ne rentre pas dans le cahier des charges.

#### Question 4
$$V_{s} = 100 \frac{V_e \Delta r_{t}}{r}$$
Ainsi, 
$$\boxed{\varepsilon(T) = \frac{V_{s}}{100V_{e} \alpha}r = 0.025 °C}$$

#### Question 5
On pose : $N$ le nombre de variablescomportant des incertitudes et $x_{i}$ le nom de ces variables alors : 
Erreur moyenne :
$$\Delta v_{0}^{2} = \sum_{i = 1}^{N}\left( \frac{\partial v_{0}}{\partial x_{i}} \Delta x_{i} \right)^{2}$$
Erreur pire cas : 
$$\Delta v_{1} = \sum_{i=1}^{N}\left| \frac{\partial v_{1}}{\partial x_{i}}\Delta x_{i} \right|$$
$$V_{s}= 250V_{e} \frac{\Delta r_{T}}{r} + \frac{V_{e}}{2}$$

$$\begin{array}{l}
\Delta v_{0}^{2} &= \left( \frac{\partial V_{s}}{\partial V_{e}} \Delta V_{e} \right)^{2} + \left( \frac{\partial V_{s}}{\partial r}\Delta r \right)^{2}  \\
&= \sqrt{\left( \left( 250 \frac{\Delta r_{T}}{r} +\frac{1}{2} \right)\Delta V_{e}\right)^{2}  + \left( \left(- \frac{250 V_{e} \Delta r_{T}}{r^{2}} \right)\Delta r \right)^{2}}
\end{array}$$
Avec : 
- $V_{e} = 5 \, V$
- $\Delta r_{T} = \alpha T = 0.4T$
- $r = 10 \, k\Omega$
- $\Delta V_{e} = \frac{1}{100}(5-0) = 50 \, mV$
- $\Delta r = \frac{5}{100} \times 10 000 \, \Omega = 500 \, \Omega$

Donc : 
$$\Delta v_{0}^{2} = \sqrt{\frac{1}{400}\left( \frac{T}{100}+\frac{1}{2} \right)^{2}  + \frac{1}{160 \, 000}T^{2}}$$
Pour $50°C$ : 
$$\boxed{\Delta v_{0}^{2} \approx 134 \, mV}$$


$$\boxed{\Delta v_{1} = 175 \, mV}$$

