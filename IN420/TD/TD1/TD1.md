| Nom                    | Qui-est-ce         | Que fait-il                          | Qu'a t-il droit de le faire           |
| ---------------------- | ------------------ | ------------------------------------ | ------------------------------------- |
| Client                 | Acheteur           | Dépose ses articles sur la caisse    | Payer, Donner un coupon               |
| Caissier               | Employé de magasin | Assure le paiment des articles       | Il scanne des articles, fini la vente |
| Responsable du magasin | Employé            | Assure la disponibilité de la caisse | Initialiser les caisses               |


#### Question 3
Cas d'utilisation :
CU100

| But                                    | Acteur   | Pré-conditions                                                                                | Scénario                                                                                                                                                                     | Post-condition                                    | Exeptions                                                                                                                           |
| -------------------------------------- | -------- | --------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| Comptabiliser l'article dans une liste | Caissier | Le client dépose au moins  article a l'attention du caissier, le caisse doit être initialisée | 1 : Le caissier scane l'article<br>2 : Si le client souhaite faire scaner un article.<br>3 : Le caissier enregistre l'article<br>4 : fin SI<br>5 : La caisse affiche le prix | La caisse à enregistré le numéro d'identification | Numéro d'enregistrement non reconnu<br>Le client change d'avis<br>Le client se fait tuer <br>Le client fait une crise cardiaque<br> |
