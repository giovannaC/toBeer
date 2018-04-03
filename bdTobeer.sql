/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     26/05/2017 10:01:32                          */
/*==============================================================*/



/*==============================================================*/
/* Table: CIDADE                                                */
/*==============================================================*/
create table CIDADE
(
   CIDADEID             int not null auto_increment,
   ESTADOID             int,
   CIDADENOME           varchar(50),
   primary key (CIDADEID)
);

/*==============================================================*/
/* Table: ENDERECO                                              */
/*==============================================================*/
create table ENDERECO
(
   ENDERECOID           int not null auto_increment,
   TIPOLOGRADOUROID     int,
   CIDADEID             int,
   ENDERECOLOGRADOURO   varchar(100),
   ENDERECONUMERO       int,
   ENDERECOCOMPLEMENTO  varchar(250),
   ENDERECOBAIRRO       varchar(100),
   ENDERECOCEP          varchar(10),
   primary key (ENDERECOID)
);


/*==============================================================*/
/* Table: ESTADO                                                */
/*==============================================================*/
create table ESTADO
(
   ESTADOID             int not null auto_increment,
   ESTADONOME           varchar(50),
   ESTADOSIGLA          varchar(2),
   primary key (ESTADOID)
);


/*==============================================================*/
/* Table: PESSOA                                                */
/*==============================================================*/
create table PESSOA
(
   PESSOAID             int not null auto_increment,
   ENDERECOID			int,
   PESSOANOME           varchar(100),
   PESSOADATANASCIMENTO date,
   PESSOATELEFONE       varchar(11),
   PESSOAGENERO			varchar(2),
   PESSOASENHA			varchar(6),
   
   primary key (PESSOAID)
);


/*==============================================================*/
/* Table: TIPOLOGRADOURO                                        */
/*==============================================================*/
create table TIPOLOGRADOURO
(
   TIPOLOGRADOUROID     int not null auto_increment,
   TIPOLOGRADOURONOME   varchar(25),
   primary key (TIPOLOGRADOUROID)
);

/*==============================================================*/
/* Table: BAR                                     */
/*==============================================================*/
create table BAR
(
   BARID     		int not null auto_increment,
   ENDERECOID   	int,
   BARNOME			varchar(200),
   BAROPEN			time,
   BARCLOSE			time,
   BARDESCRICAO		varchar(500),
   BARCLASSIFICACAO	float,
   BARTELEFONE		varchar(12),
   BARSENHA			varchar(6),
   primary key (BARID)
);


/*==============================================================*/
/* Table: GRUPO                                            */
/*==============================================================*/
create table GRUPO
(
   GRUPOID				int not null auto_increment,
   PESSOAID             int,
   BARID				int,
   GRUPONOME			varchar(150),
   GRUPOSENHA			varchar(6),
   GRUPOMAX				int,
   GRUPOHORARIO			varchar(11),
   
   primary key (GRUPOID)
);

/*==============================================================*/
/* Table: ENCONTRO                                            */
/*==============================================================*/
create table ENCONTRO
(
   ENCONTROID 			int not null auto_increment,
   BARID				int,
   PESSOAID				int,
   GRUPOID				int,
   ENCONTROCHECKIN		varchar(11),
   ENCONTROCHECKOUT		varchar(11),
   ENCONTRODIRIGIR		varchar(3),
   
   primary key (ENCONTROID)
);

/*==============================================================*/
/* Table: LOGIN                                         */
/*==============================================================*/
create table LOGIN
(
   LOGINID				int not null auto_increment,
   TELEFONE				varchar(11),
   primary key (LOGINID)
);

/*==============================================================*/
/* Table: PROCURA                                         */
/*==============================================================*/
create table PROCURA
(
   PROCURAID				int not null auto_increment,
   PROCURABAR				varchar(200),
   PROCURAGRUPO				varchar(150),
   primary key (PROCURAID)
);



alter table ESTADO comment 'Utilizado para Guardar as informações do Estado';

alter table CIDADE add constraint FK_REFERENCE_1 foreign key (ESTADOID)
      references ESTADO (ESTADOID);

alter table ENDERECO add constraint FK_REFERENCE_2 foreign key (TIPOLOGRADOUROID)
      references TIPOLOGRADOURO (TIPOLOGRADOUROID) on delete restrict on update restrict;

alter table ENDERECO add constraint FK_REFERENCE_3 foreign key (CIDADEID)
      references CIDADE (CIDADEID) on delete restrict on update restrict;
      
alter table PESSOA add constraint FK_REFERENCE_4 foreign key (ENDERECOID)
	  references ENDERECO (ENDERECOID) on delete restrict on update restrict;
      
alter table BAR add constraint FK_REFERENCE_5 foreign key (ENDERECOID)
      references ENDERECO (ENDERECOID) on delete restrict on update restrict;
      
alter table GRUPO add constraint FK_REFERENCE_6 foreign key (PESSOAID)
	  references PESSOA (PESSOAID) on delete restrict on update restrict;

alter table ENCONTRO add constraint FK_REFERENCE_7 foreign key (BARID)
	  references BAR (BARID) on delete restrict on update restrict;

alter table ENCONTRO add constraint FK_REFERENCE_8 foreign key (PESSOAID)
	  references PESSOA (PESSOAID) on delete restrict on update restrict;
      
alter table ENCONTRO add constraint FK_REFERENCE_9 foreign key (GRUPOID)
	  references GRUPO (GRUPOID) on delete restrict on update restrict;
      
alter table GRUPO add constraint FK_REFERENCE_10 foreign key (BARID)
	  references BAR (BARID) on delete restrict on update restrict;

set foreign_key_checks = 0;
