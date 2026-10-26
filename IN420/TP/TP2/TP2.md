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



INSERT INTO Famille VALUES('Lion', 'Afrique', false);
INSERT INTO Famille VALUES('Girafe', 'Afrique', true);

INSERT INTO Animal VALUES('L1', 'Roger', '2023-10-26', 'Lion', 'Afrique', 'M1', '12345');
INSERT INTO Animal VALUES('L2', 'Per', '2016-07-13', 'Lion', 'Afrique', 'M1', '56789');
INSERT INTO Animal VALUES('G2', 'Gunilla', '2021-03-05', 'Girafe', 'Afrique', 'M2', '56789');


INSERT INTO AnimalParent VALUES('L2', 'L1');
INSERT INTO AnimalEnfant VALUES('L2', 'L1');
```

#### Question 7
```sql
UPDATE Menu SET qteLegume = qteLegume + 2
WHERE idmenu='M2';
```

#### Question 8
```sql
DELETE FROM AnimalEnfant
WHERE idanimalP = 'L2' or idanimalE = 'L2';

DELETE FROM AnimalParent
WHERE idanimalP = 'L2' or idanimalE = 'L2';

DELETE FROM Animal
WHERE idanimal = 'L2';
```

#### Question 9
On change sélectionne une autre base de donnés : 
```psql
\c postgres
```
On supprime la base de donnés : 
```SQL
DROP DATABASE "tp-zoo";
```

# Exercice 2 : Les employés
## Sélection, ﬁltres, tri et jointures
#### Question 1
```sql
SELECT ename, hiredate FROM Emp
WHERE deptno=20;
```

```sql
 ename |  hiredate  
-------+------------
 SMITH | 1980-12-17
 JONES | 1981-04-02
 SCOTT | 1982-12-09
 ADAMS | 1983-01-12
 FORD  | 1981-12-03
```

#### Question 2
```sql
SELECT ename, job, sal FROM Emp
WHERE sal>2800 and job='MANAGER';
```

```sql
 ename |   job   |   sal   
-------+---------+---------
 JONES | MANAGER | 2975.00
 BLAKE | MANAGER | 2850.00
```

#### Question 3
```sql
SELECT ename, job, sal FROM Emp
WHERE deptno=30
ORDER BY sal ASC, ename DESC;
```

```sql
 ename  |   job    |   sal   
--------+----------+---------
 JAMES  | CLERK    |  950.00
 WARD   | SALESMAN | 1250.00
 MARTIN | SALESMAN | 1250.00
 TURNER | SALESMAN | 1500.00
 ALLEN  | SALESMAN | 1600.00
 BLAKE  | MANAGER  | 2850.00
```

#### Question 4
```sql
SELECT ename, job, sal FROM Emp
WHERE sal>=1290 and ename LIKE 'M%';
```

```sql
 ename  |  job  |   sal   
--------+-------+---------
 MILLER | CLERK | 1300.00
```

#### Question 5
```sql
SELECT ename FROM Emp
WHERE ename BETWEEN 'D' AND 'M'
ORDER BY ename;
```

```sql
 ename 
-------
 FORD
 JAMES
 JONES
 KING
```

#### Question 6
```sql
SELECT ename, job, sal, d.deptno, dname, loc FROM Emp e, Dept d
WHERE e.deptno = d.deptno AND d.loc='DALLAS';
```

```sql
SELECT ename, job, sal, d.deptno, dname, loc FROM Emp e, Dept d
WHERE e.deptno = d.deptno AND d.loc='DALLAS';
 ename |   job   |   sal   | deptno |  dname   |  loc   
-------+---------+---------+--------+----------+--------
 SMITH | CLERK   |  800.00 |     20 | RESEARCH | DALLAS
 JONES | MANAGER | 2975.00 |     20 | RESEARCH | DALLAS
 SCOTT | ANALYST | 3000.00 |     20 | RESEARCH | DALLAS
 ADAMS | CLERK   | 1100.00 |     20 | RESEARCH | DALLAS
 FORD  | ANALYST | 3000.00 |     20 | RESEARCH | DALLAS
```

#### Question 7
```sql
SELECT d.deptno, dname, loc FROM Emp e, Dept d
WHERE e.deptno = d.deptno AND e.job IN ('CLERK', 'SALESMAN','ANALYST');
```

```sql
 deptno |   dname    |   loc    
--------+------------+----------
     10 | ACCOUNTING | NEW YORK
     20 | RESEARCH   | DALLAS
     20 | RESEARCH   | DALLAS
     20 | RESEARCH   | DALLAS
     20 | RESEARCH   | DALLAS
     30 | SALES      | CHICAGO
     30 | SALES      | CHICAGO
     30 | SALES      | CHICAGO
     30 | SALES      | CHICAGO
     30 | SALES      | CHICAGO
```

#### Question 8
```sql
SELECT ename, sal, d.deptno, loc FROM Emp e, Dept d
WHERE e.deptno = d.deptno AND loc IN ('DALLAS', 'CHICAGO') AND sal>=1000;
```

```sql
 ename  |   sal   | deptno |   loc   
--------+---------+--------+---------
 ALLEN  | 1600.00 |     30 | CHICAGO
 WARD   | 1250.00 |     30 | CHICAGO
 JONES  | 2975.00 |     20 | DALLAS
 MARTIN | 1250.00 |     30 | CHICAGO
 BLAKE  | 2850.00 |     30 | CHICAGO
 SCOTT  | 3000.00 |     20 | DALLAS
 TURNER | 1500.00 |     30 | CHICAGO
 ADAMS  | 1100.00 |     20 | DALLAS
 FORD   | 3000.00 |     20 | DALLAS
```

#### Question 9
```sql
SELECT empno, ename, hiredate FROM Emp
WHERE hiredate<'1981-11-30'
ORDER BY ename;
```

```sql
 empno | ename  |  hiredate  
-------+--------+------------
  7499 | ALLEN  | 1981-02-20
  7698 | BLAKE  | 1981-05-01
  7782 | CLARK  | 1981-06-09
  7566 | JONES  | 1981-04-02
  7839 | KING   | 1981-11-17
  7654 | MARTIN | 1981-09-28
  7369 | SMITH  | 1980-12-17
  7844 | TURNER | 1981-09-08
  7521 | WARD   | 1981-02-22
```

## Sous-requêtes et hiérarchie
#### Question 10
```sql
SELECT ename, sal FROM Emp as employee
WHERE sal>(
SELECT sal FROM Emp as manager
WHERE employee.mgr=manager.empno)
;
```

```sql
 ename |   sal   
-------+---------
 SCOTT | 3000.00
 FORD  | 3000.00
```

#### Question 11
```sql
SELECT ename FROM Emp as employee
WHERE hiredate<(
SELECT hiredate FROM Emp as manager
WHERE employee.mgr=manager.empno)
;
```

```sql
 ename 
-------
 SMITH
 ALLEN
 WARD
 JONES
 BLAKE
 CLARK
```

#### Question 12
```sql
SELECT d.dname FROM Dept AS d
WHERE NOT EXISTS (
	SELECT * FROM Emp AS e
	WHERE e.deptno = d.deptno AND e.job = 'ANALYST'
);
```

```sql
   dname    
------------
 ACCOUNTING
 SALES
 OPERATIONS
```

#### Question 13
```sql
SELECT ename FROM Emp
WHERE empno IN (
	SELECT empno FROM Emp
	WHERE mgr IN (
		SELECT empno FROM Emp
		WHERE job='CLERK'
		)
		INTERSECT
	SELECT empno FROM Emp
	WHERE mgr IN (
		SELECT empno FROM Emp
		WHERE job='SALESMAN'
		)
)
;
```

```sql
 ename 
-------
```

#### Question 14
```sql
SELECT ename, sal FROM Emp
WHERE sal>(
	SELECT MAX(sal) FROM Emp
	WHERE ename='JONES' or ename='MARTIN'
);
```

```sql
 ename |   sal   
-------+---------
 SCOTT | 3000.00
 KING  | 5000.00
 FORD  | 3000.00
```


#### Question 15
```sql
	SELECT dname FROM Dept as d
	WHERE NOT EXISTS (
		SELECT empno FROM Emp as e
		WHERE e.deptno = d.deptno
	)
	;
```

```sql
   dname    
------------
 OPERATIONS
```

#### Question 16
```sql
SELECT ename FROM Emp as employee
WHERE EXISTS (
	SELECT empno FROM Emp as e, Dept as d
	WHERE employee.sal>e.sal
	AND e.deptno = d.deptno
	AND d.deptno = '30'
);
```

```sql
 ename  
--------
 ALLEN
 WARD
 JONES
 MARTIN
 BLAKE
 CLARK
 SCOTT
 KING
 TURNER
 ADAMS
 FORD
 MILLER
```

#### Question 17
```sql
SELECT ename FROM Emp
WHERE empno IN (
	SELECT DISTINCT mgr FROM Emp
);
```

```sql
 ename 
-------
 JONES
 BLAKE
 CLARK
 SCOTT
 KING
 FORD
```

#### Question 18
```sql
SELECT empno, ename, job, sal, comm FROM Emp
WHERE empno IN (
	SELECT mgr FROM Emp
	WHERE comm IS NOT NULL
);
```

```sql
 empno | ename |   job   |   sal   | comm 
-------+-------+---------+---------+------
  7698 | BLAKE | MANAGER | 2850.00 |     
```

#### Question 19
```sql
SELECT
e.ename AS nom,
e.sal AS salaire,
s.grade AS echelle_salaire,
manager.ename AS superieur, 
d.deptno AS num_dept, 
d.loc AS ville_dept
FROM Emp AS e
LEFT OUTER JOIN Salgrade AS s
ON e.sal BETWEEN s.losal AND s.hisal
LEFT OUTER JOIN Emp AS manager
ON e.mgr = manager.empno
LEFT OUTER JOIN Dept AS d
ON e.deptno = d.deptno
ORDER BY e.sal, e.ename
;
```

```sql
  nom   | salaire | echelle_salaire | superieur | num_dept | ville_dept 
--------+---------+-----------------+-----------+----------+------------
 SMITH  |  800.00 |               1 | FORD      |       20 | DALLAS
 JAMES  |  950.00 |               1 | BLAKE     |       30 | CHICAGO
 ADAMS  | 1100.00 |               1 | SCOTT     |       20 | DALLAS
 MARTIN | 1250.00 |               2 | BLAKE     |       30 | CHICAGO
 WARD   | 1250.00 |               2 | BLAKE     |       30 | CHICAGO
 MILLER | 1300.00 |               2 | CLARK     |       10 | NEW YORK
 TURNER | 1500.00 |               3 | BLAKE     |       30 | CHICAGO
 ALLEN  | 1600.00 |               3 | BLAKE     |       30 | CHICAGO
 CLARK  | 2450.00 |               4 | KING      |       10 | NEW YORK
 BLAKE  | 2850.00 |               4 | KING      |       30 | CHICAGO
 JONES  | 2975.00 |               4 | KING      |       20 | DALLAS
 FORD   | 3000.00 |               4 | JONES     |       20 | DALLAS
 SCOTT  | 3000.00 |               4 | JONES     |       20 | DALLAS
 KING   | 5000.00 |               5 |           |       10 | NEW YORK
```


## Agrégats et regroupement
#### Question 20
```sql
SELECT d.deptno, d.dname, d.loc
FROM Dept AS d
NATURAL RIGHT OUTER JOIN Emp AS e
GROUP BY d.deptno, d.dname, d.loc
HAVING COUNT(e.empno) > 3 AND d.loc != 'CHICAGO'
;
```

```sql
 deptno |  dname   |  loc   
--------+----------+--------
     20 | RESEARCH | DALLAS
```

#### Question 21
```sql
SELECT d.dname, COUNT(e.empno) AS nbre_max_employes
FROM Dept AS d
NATURAL RIGHT OUTER JOIN Emp AS e
GROUP BY d.dname
HAVING COUNT(e.empno)=(
	SELECT MAX(nbre_emp_per_dept)
    FROM (
        SELECT COUNT(*) AS nbre_emp_per_dept
        FROM Emp
        GROUP BY deptno
	    )
	)
;
```

```sql
 dname | nbre_max_employes 
-------+-------------------
 SALES |                 6
```

#### Question 22
Facile : 
```sql
SELECT manager.ename,
COUNT(manager.ename) AS Nb_subordonnes
FROM Emp AS manager
LEFT OUTER JOIN Emp AS subordonnes
ON manager.empno = subordonnes.mgr
WHERE subordonnes.mgr IS NOT NULL
GROUP BY manager.ename
ORDER BY Nb_subordonnes
;
```

```sql
 ename | nb_subordonnes 
-------+----------------
 FORD  |              1
 CLARK |              1
 SCOTT |              1
 JONES |              2
 KING  |              3
 BLAKE |              5
```

Difficile : 
```sql
SELECT manager.ename,
COUNT(subordonnes.mgr) AS Nb_subordonnes
FROM Emp AS manager
LEFT OUTER JOIN Emp AS subordonnes
ON manager.empno = subordonnes.mgr
GROUP BY manager.ename
ORDER BY Nb_subordonnes
;
```

```sql
 ename  | nb_subordonnes 
--------+----------------
 ALLEN  |              0
 MARTIN |              0
 JAMES  |              0
 ADAMS  |              0
 TURNER |              0
 MILLER |              0
 SMITH  |              0
 WARD   |              0
 CLARK  |              1
 FORD   |              1
 SCOTT  |              1
 JONES  |              2
 KING   |              3
 BLAKE  |              5
```

#### Question 23
```sql
SELECT
d.dname,
e.job,
SUM(e.sal) AS Total_salaire,
COUNT(e.empno) AS Nb_employes,
AVG(e.sal) AS Salaire_moyen

FROM Dept as d

LEFT OUTER JOIN Emp as e 
ON d.deptno = e.deptno

GROUP BY d.dname, e.job
HAVING COUNT(e.job)>=2
;
```

```sql
  dname   |   job    | total_salaire | nb_employes |     salaire_moyen     
----------+----------+---------------+-------------+-----------------------
 SALES    | SALESMAN |       5600.00 |           4 | 1400.0000000000000000
 RESEARCH | ANALYST  |       6000.00 |           2 | 3000.0000000000000000
 RESEARCH | CLERK    |       1900.00 |           2 |  950.0000000000000000
```

#### Question 24
```sql
SELECT
d.dname,
e.job,
SUM(e.sal) AS Total_salaire,
COUNT(e.empno) AS Nb_employes,
AVG(e.sal) AS Salaire_moyen

FROM Dept as d

LEFT OUTER JOIN Emp as e 
ON d.deptno = e.deptno

GROUP BY d.dname, e.job

ORDER BY Nb_employes DESC, d.dname, e.job
;

```

```sql
   dname    |    job    | total_salaire | nb_employes |     salaire_moyen     
------------+-----------+---------------+-------------+-----------------------
 SALES      | SALESMAN  |       5600.00 |           4 | 1400.0000000000000000
 RESEARCH   | ANALYST   |       6000.00 |           2 | 3000.0000000000000000
 RESEARCH   | CLERK     |       1900.00 |           2 |  950.0000000000000000
 ACCOUNTING | CLERK     |       1300.00 |           1 | 1300.0000000000000000
 ACCOUNTING | MANAGER   |       2450.00 |           1 | 2450.0000000000000000
 ACCOUNTING | PRESIDENT |       5000.00 |           1 | 5000.0000000000000000
 RESEARCH   | MANAGER   |       2975.00 |           1 | 2975.0000000000000000
 SALES      | CLERK     |        950.00 |           1 |  950.0000000000000000
 SALES      | MANAGER   |       2850.00 |           1 | 2850.0000000000000000
 OPERATIONS |           |               |           0 |                      
```

#### Question 25
```sql
SELECT EXTRACT(YEAR FROM e.hiredate) AS Annee, COUNT(e.empno) AS Nb_Employes
FROM Emp AS e
GROUP BY Annee
ORDER BY Annee
;
```

```sql
 annee | nb_employes 
-------+-------------
  1980 |           1
  1981 |          10
  1982 |           2
  1983 |           1
```

#### Question 26
Facile : 
```sql
SELECT
d.dname,
AVG(e.sal) AS Salaire_moyen
FROM Dept AS d
LEFT OUTER JOIN Emp e
ON d.deptno = e.deptno
WHERE e.sal IS NOT NULL
GROUP BY d.dname
;
```

```sql
   dname    |     salaire_moyen     
------------+-----------------------
 ACCOUNTING | 2916.6666666666666667
 SALES      | 1566.6666666666666667
 RESEARCH   | 2175.0000000000000000

```

Difficile :
```sql
SELECT
d.dname,
CONCAT(ROUND(AVG(e.sal), 2), ' dollars') AS Salaire_moyen
FROM Dept AS d
LEFT OUTER JOIN Emp e
ON d.deptno = e.deptno
WHERE e.sal IS NOT NULL
GROUP BY d.dname
;
```

```sql
   dname    |  salaire_moyen  
------------+-----------------
 ACCOUNTING | 2916.67 dollars
 SALES      | 1566.67 dollars
 RESEARCH   | 2175.00 dollars
```


#### Question 27
Facile : 
```sql
SELECT
d.dname,
SUM(e.sal) AS SALAIRE,
SUM(e.comm) AS COMMISSION
FROM Dept AS d
LEFT OUTER JOIN Emp e
ON d.deptno = e.deptno
GROUP BY d.dname
;
```

```sql
   dname    | salaire  | commission 
------------+----------+------------
 ACCOUNTING |  8750.00 |           
 SALES      |  9400.00 |    2200.00
 OPERATIONS |          |           
 RESEARCH   | 10875.00 |           
```

Difficile :
```sql
SELECT
d.dname,
CONCAT(COALESCE(SUM(e.sal), '0.00'), ' dollars') AS SALAIRE,
CONCAT(COALESCE(SUM(e.comm), '0.00'), ' dollars') AS COMMISSION
FROM Dept AS d
LEFT OUTER JOIN Emp e
ON d.deptno = e.deptno
GROUP BY d.dname
;
```

```sql
   dname    |     salaire      |   commission    
------------+------------------+-----------------
 ACCOUNTING | 8750.00 dollars  | 0.00 dollars
 SALES      | 9400.00 dollars  | 2200.00 dollars
 OPERATIONS | 0.00 dollars     | 0.00 dollars
 RESEARCH   | 10875.00 dollars | 0.00 dollars

```

#### Question 28
```sql
SELECT
    TABLE_MIN.dname AS Moins_cher,
    TABLE_MIN.salaire_min AS mini,
    TABLE_MAX.dname AS Plus_cher,
    TABLE_MAX.salaire_max AS maxi
FROM (
	 SELECT d.dname, SUM(e.sal) AS salaire_min
     FROM Dept d
     JOIN Emp e ON d.deptno = e.deptno
     GROUP BY d.deptno, d.dname
     HAVING SUM(e.sal) = (
         SELECT MIN(total_sal)
         FROM (
             SELECT SUM(sal) AS total_sal
             FROM Emp
             GROUP BY deptno
         )
     )) TABLE_MIN,
    (
     SELECT d.dname, SUM(e.sal) AS salaire_max
     FROM Dept d
     JOIN Emp e ON d.deptno = e.deptno
     GROUP BY d.deptno, d.dname
     HAVING SUM(e.sal) = (
         SELECT MAX(total_sal)
         FROM (
             SELECT SUM(sal) AS total_sal
             FROM Emp
             GROUP BY deptno
         )
     )) TABLE_MAX;
```

```sql
 moins_cher |  mini   | plus_cher |   maxi   
------------+---------+-----------+----------
 ACCOUNTING | 8750.00 | RESEARCH  | 10875.00
```