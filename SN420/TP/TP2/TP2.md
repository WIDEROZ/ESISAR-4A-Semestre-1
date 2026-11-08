## 2.1 - Préparation individuelle
#### 1 - Informations Générales de la carte
Série : STM32 Nucleo-64
Produit : NUCLEO-F103RB
Microcontrôleur : STM32F103RB
Taille de la mémoire flash : $128 \, Kb$ (Lettre $B$ à la fin Databrief NUCLEO-xxxxRx - Chapitre 1.2)

#### 2 - Nombre de timers
Il existe $7$ timers dans le microcontrôleur : STM32F103RB (Datasheet STM32F103RB, page 1, Features)

#### 3 - Timer 2
|                       | Information        |
| --------------------- | ------------------ |
| Prescaler             | Taille : $16$ bits |
| Registre de comptage  | Taille : $12$ bits |
| Registres de contrôle | Nombre : $4$       |
Datasheet STM32F103RB
2.3.15 - General-purpose timers (TIMx)

#### 4 - TIM_Base_InitTypeDef
User Manual - HAL library STM32F1
36.1.1 - TIM_Base_InitTypeDef

| Type     | Field             |
| -------- | ----------------- |
| uint32_t | Prescaler         |
| uint32_t | CounterMode       |
| uint32_t | Period            |
| uint32_t | ClockDivision     |
| uint32_t | RepetitionCounter |
| uint32_t | AutoReloadPreload |

#### 5 - TIM2_CR1
Microcontrôleur Reference Manual
15.4.1 - TIMx control register 1 (TIMx_CR1)

$16$ bits control register :
000

| 9        | 8        | 7    | 6        | 5        | 4   | 3   | 2   | 1    | 0   |
| -------- | -------- | ---- | -------- | -------- | --- | --- | --- | ---- | --- |
| CDK\[1\] | CDK\[0\] | ARPE | CMS\[1\] | CMS\[0\] | DIR | OPM | URS | UDIS | CEN |
| rw       | rw       | rw   | rw       | rw       | rw  | rw  | rw  | rw   | rw  |
CDK (Clock Division) : 
$00$ : $t_{DTS} = t_{CK\_INT}$
$01$ : $t_{DTS} = 2 \times t_{CK\_INT}$
$10$ : $t_{DTS} = 4 \times t_{CK\_INT}$
$11$ : Reserved

ARPE (Auto-reload preload enable) :
$0$ : TIMx_ARR register is not buffered
$1$ : TIMx_ARR register is buffered

CMS (Center-aligned mode selection) :
$00$ : Edge-aligned mode (count regarding the DIR bit)
$01$ : Center-aligned mode $1$
$10$ : Center-aligned mode $2$
$11$ : Center-aligned mode $3$

DIR (Direction) : 
$0$ : Upcounter
$1$ : Downcounter

#### 6 - Calcul des paramètres pour obtenir $10 \, kHz$
Prescaler : TIM_Base_InitTypeDef::Prescaler
$$\frac{64\, MHz}{6\,400} = 10 \, kHz$$
Alors, 
$$\text{TIM\_Base\_InitTypeDef::Prescaler} = 6399$$


Period : TIM_Base_InitTypeDef::Period
$$\frac{1 \, MHz}{10\,000} = 1 \, Hz$$
Alors, 
$$\text{TIM\_Base\_InitTypeDef::Period} = 9 \, 999$$

ClockDivision : TIM_Base_InitTypeDef::ClockDivision
$$\text{TIM\_Base\_InitTypeDef::ClockDivision} = 0$$
On ne divise pas la clock.

#### 7 - GPIO Pin for LED
User Manual STM32 Nucleo-64 boards
Chapter 7.6 - p.24

| Pin name (signal) | Pin | STM32 Pin |
| ----------------- | --- | --------- |
| D13               | 21  | PA5       |
| D13               | 34  | PB13      |

#### 8 - GPIO_InitTypeDef
User Manual - HAL library STM32F1
page 27 : 3.11.2 - GPIO
page 225 : 20.1.1 - GPIO_InitTypeDef

| Type     | Field | Value               |
| -------- | ----- | ------------------- |
| uint32_t | Pin   | GPIO_PIN_13         |
| uint32_t | Mode  | GPIO_MODE_OUTPUT_PP |
| uint32_t | Pull  | GPIO_PULLUP         |
| uint32_t | Speed | GPIO_SPEED_LOW      |

36.1.11


