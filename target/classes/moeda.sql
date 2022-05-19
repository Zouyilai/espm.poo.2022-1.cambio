create database espm;

create table moeda (
	`id_moeda` varchar(40) not null,
	`tx_nome` varchar(50) not null,
    `tx_simbolo` varchar(5) not null,
    primary key `pk_moeda` (`id_moeda`)
);

insert into moeda values ("6f3ef6ac-d789-11ec-9d64-0242ac120002", "Real", "BRL");