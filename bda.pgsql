\c postgres;

drop database projetparking;
create database projetparking;

\c projetparking;

create table admin(
    idadmin serial,
    nameadmin varchar(50) not null unique,
    passwordadmin varchar(50) not null,
    PRIMARY KEY (idadmin)
);

create table client(
    idclient serial,
    nameclient varchar(50) not null unique,
    passwordclient varchar(50) not null,
    PRIMARY KEY (idclient)
);

create table vehicul(
    idvehicul serial,
    idclient int not null,
    typevehicul varchar(50) not null,
    marquevehicul varchar(50) not null,
    modelvehicul varchar(50) not null,
    colorvehicul varchar(50) not null,
    matriculationvahicul varchar(50) not null,
    longvehicul int not null,
    largvehicul int not null,
    hautvehicul int not null,
    poidvehicul int not null,
    PRIMARY KEY (idvehicul)
);

create table slotparking(
    idslot serial,
    nameslot varchar(50) not null,
    longslot int not null,
    largslot int not null,
    hautslot int not null,
    poidslot int not null,
    PRIMARY KEY (idslot)
);

create table reservation(
    idreservation serial,
    idclient int not null,
    idvehicul int not null,
    idslot int not null,
    datereservation timestamp default CURRENT_TIMESTAMP not null,
    heure int not null,
    duree int not null,
    valide boolean default true,
    PRIMARY KEY (idreservation)
);

alter table vehicul add FOREIGN KEY (idclient) REFERENCES client (idclient);

alter table reservation add FOREIGN KEY (idclient) REFERENCES client (idclient);
alter table reservation add FOREIGN KEY (idvehicul) REFERENCES vehicul (idvehicul);
alter table reservation add FOREIGN KEY (idslot) REFERENCES slotparking (idslot);

insert into admin values (default,'admin','admin');

insert into client values (default,'cedric','753teA');
insert into client values (default,'tsiky','753teA');

insert into vehicul values(default,1,'classic','bmw','MT700','noir','034T',200,100,200,250);
insert into vehicul values(default,1,'camion','honda','GT4','blanc','011C',400,100,350,1000);
insert into vehicul values(default,2,'classic','forde','RS','noir','069F',200,100,200,150);
insert into vehicul values(default,2,'moto','sct','4000M','rouge','ff4C',100,50,100,150);

insert into slotparking values(default,'A',300,150,250,500);
insert into slotparking values(default,'B',150,150,250,200);
insert into slotparking values(default,'copy-A',150,150,150,200);
