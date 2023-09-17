create database jspshop;
use jspshop;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     20/05/2023 12:02:09                          */
/*==============================================================*/


drop table if exists Categorie;

drop table if exists Commande;

drop table if exists LigneCommande;

drop table if exists Produit;

drop table if exists User;

/*==============================================================*/
/* Table: Categorie                                             */
/*==============================================================*/
create table Categorie
(
   idCategorie          int not null auto_increment,
   name                 varchar(254),
   primary key (idCategorie)
);

/*==============================================================*/
/* Table: Commande                                              */
/*==============================================================*/
create table Commande
(
   idCommande           int not null auto_increment,
   idUser               int not null,
   totalprd             int,
   totalqte             int,
   primary key (idCommande)
);

/*==============================================================*/
/* Table: LigneCommande                                         */
/*==============================================================*/
create table LigneCommande
(
   idCommande           int not null auto_increment,
   idProduit            int not null,
   qteCommandee         int,
   remise               float,
   primary key (idCommande, idProduit)
);

/*==============================================================*/
/* Table: Produit                                               */
/*==============================================================*/
create table Produit
(
   idProduit            int not null auto_increment,
   idCategorie          int not null,
   title                varchar(254),
   description          varchar(254),
   price                float,
   discount             float,
   rating               float,
   stock                int,
   brand                varchar(254),
   thumbnail            varchar(254),
   image1               varchar(254),
   image2               varchar(254),
   image3               varchar(254),
   image4               varchar(254),
   primary key (idProduit)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   idUser               int not null auto_increment,
   firstname            varchar(254),
   lastname             varchar(254),
   email                varchar(254),
   maidenName           varchar(254),
   gender               varchar(254),
   phone                varchar(254),
   username             varchar(254),
   password             varchar(254),
   birthdate            datetime,
   image                varchar(254),
   height               int,
   weight               int,
   address              varchar(254),
   primary key (idUser)
);

alter table Commande add constraint FK_association3 foreign key (idUser)
      references User (idUser) on delete restrict on update restrict;

alter table LigneCommande add constraint FK_association2 foreign key (idCommande)
      references Commande (idCommande) on delete restrict on update restrict;

alter table LigneCommande add constraint FK_association31 foreign key (idProduit)
      references Produit (idProduit) on delete restrict on update restrict;

alter table Produit add constraint FK_association1 foreign key (idCategorie)
      references Categorie (idCategorie) on delete restrict on update restrict;



      0	31	23:19:50	update lignecommande set idProduit=12 where idProduit>30	
      Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column. 
 To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.016 sec

