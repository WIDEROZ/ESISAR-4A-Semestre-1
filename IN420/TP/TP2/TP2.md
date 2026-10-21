# Exercice 1 : Zoo
## Question 1
#### Entitée faible
Zoo(<u>idZoo</u>, nom)
Enclos(<u>idEnclos, <span class="souligne-dash">idZoo</span></u>, nom, surface)

$$\text{Enclos}[\text{idZoo}] \subseteq \text{Zoo}[\text{idZoo}]$$

#### Cardinalité 1..1
Menu(<u>idMenu</u>, qteViande, qteLegume)
Famille(<u>race, origine</u>, ami)
Animal(<u>idAnimal</u>, nom, dateNaissance, <span class="souligne-dash">race</span>, <span class="souligne-dash">origin</span>, <span class="souligne-dash">idMenu</span>)

$$\begin{cases}
\text{Animal}[\text{idMenu}] \subseteq \text{Menu}[\text{idMenu}] \\
\text{Animal}[\text{(race, origine)}] \subseteq \text{Famille}[\text{(race, origine)}]
\end{cases}$$

#### Cardinalité 0..1
Animal(<u>idAnimal</u>, nom, dateNaissance, <span class="souligne-dash">race</span>, <span class="souligne-dash">origin</span>, <span class="souligne-dash">idMenu</span>)
Enclos(<u>idEnclos, <span class="souligne-dash">idZoo</span></u>, nom, surface)

Occupe(<span class="souligne-double">idAnimal</span>, <span class="souligne-dash">idEnclos, idZoo</span>)

$$\begin{cases}
\text{Occupe}[\text{idAnimal}] \subseteq \text{Animal}[\text{idAnimal}] \\
\text{Occupe}[\text{idEnclos}] \subseteq \text{Enclos}[\text{idEnclos}]
\end{cases}$$


#### Tables ajoutés
Ces tables ont étés ajoutés pour faire la relation parent enfant de l'Animal : 
AnimalParent(<span class="souligne-double">idAnimalP</span>, <span class="souligne-dash">idAnimalE</span>)
AnimalEnfant(<span class="souligne-double">idAnimalE</span>, <span class="souligne-dash">idAnimalP</span>)


#### Question 2
```SQL
CREATE TABLE Zoo (
    idZoo CHAR(5),
    nom VARCHAR(20),
    CONSTRAINT pk_Zoo PRIMARY KEY(idZoo));


CREATE TABLE Enclos (
    idEnclos CHAR(5), idZoo CHAR(5),
    nom VARCHAR(20), surface INTEGER,
    CONSTRAINT pk_Enclos PRIMARY KEY(idEnclos, idZoo),
    CONSTRAINT fk_Zoo FOREIGN KEY (idZoo) REFERENCES Zoo(idZoo));
    


CREATE TABLE Menu (
    idMenu CHAR(5),
    qteViande REAL,
    qteLegume REAL, 
    CONSTRAINT pk_Menu PRIMARY KEY(idMenu));

CREATE TABLE Famille (
    race VARCHAR(20),
    origine VARCHAR(20),
    ami BOOLEAN,
    CONSTRAINT pk_Famille PRIMARY KEY(race, origine));


CREATE TABLE Animal (
    idAnimal CHAR(5),
    nom VARCHAR(20),
    dateNaissance DATE,
    race VARCHAR(20),
    origine VARCHAR(20),
    idMenu CHAR(5),
    CONSTRAINT pk_Animal PRIMARY KEY(idAnimal), 
    CONSTRAINT fk_Animal_Famille FOREIGN KEY(race, origine) REFERENCES Famille(race, origine),
    CONSTRAINT fk_Animal_Menu FOREIGN KEY(idMenu) REFERENCES Menu(idMenu));


CREATE TABLE AnimalParent (
    idAnimalP CHAR(5),
    idAnimalE CHAR(5),
    CONSTRAINT pk_AnimalParent PRIMARY KEY(idAnimalP),
    CONSTRAINT fk_AnimalParent FOREIGN KEY(idAnimalP) REFERENCES Animal(idAnimal),
    CONSTRAINT fk_AnimalEnfant FOREIGN KEY(idAnimalE) REFERENCES Animal(idAnimal));


CREATE TABLE AnimalEnfant (
    idAnimalP CHAR(5),
    idAnimalE CHAR(5),
    CONSTRAINT pk_AnimalEnfant PRIMARY KEY(idAnimalE), 
    CONSTRAINT fk_AnimalEnfant FOREIGN KEY(idAnimalE) REFERENCES Animal(idAnimal),
    CONSTRAINT fk_AnimalParent FOREIGN KEY(idAnimalP) REFERENCES Animal(idAnimal));




CREATE TABLE occupe (
    idAnimal CHAR(5),
    idEnclos CHAR(5),
    idZoo CHAR(5),
    CONSTRAINT pk_occupe PRIMARY KEY(idAnimal),
    CONSTRAINT fk_occupe_Animal FOREIGN KEY(idAnimal) REFERENCES animal(idAnimal),
    CONSTRAINT fk_occupe_Enclos FOREIGN KEY(idEnclos, idZoo) REFERENCES enclos(idEnclos, idZoo));
```

#### Question 3
![[Pasted image 20261021114824.png]]

#### Question 4
Responsable(<u>numBadge</u>, nom, prenom)
Animal(<u>idAnimal</u>, nom, dateNaissance, <span class="souligne-dash">race</span>, <span class="souligne-dash">origin</span>, <span class="souligne-dash">idMenu</span>, <span class="souligne-dash">numBadge</span>)

$$\text{Animal}[\text{numBadge}] \subseteq \text{Responsable}[\text{numBadge}]$$

#### Queston 5
```SQL
CREATE TABLE Responsable (
    numBadge CHAR(5),
    nom VARCHAR(20),
    prenom VARCHAR(20),
    CONSTRAINT pk_responsable PRIMARY KEY(numBadge));

ALTER TABLE Animal ADD numBadge CHAR(5);

ALTER TABLE Animal ADD CONSTRAINT fk_Animal_Responsable FOREIGN KEY(numBadge) REFERENCES Responsable(numBadge);
```

#### Question 6
```SQL
INSERT INTO Zoo VALUES ('Z1', 'Zoo de Valence');

INSERT INTO Enclos VALUES ('E1','Z1', 'Royaume des Lions', 2300);
INSERT INTO Enclos VALUES ('E2','Z1', 'Savane', 1200);

INSERT INTO Menu VALUES ('M1', 7.5, 0);
INSERT INTO Menu VALUES ('M2', 0, 40 );

INSERT INTO  Responsable VALUES('12345','DURAND', 'Olivier');
INSERT INTO  Responsable VALUES('56789','DUPOND', 'Nathalie');
```

