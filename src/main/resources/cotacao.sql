
create table cotacao (
	`id_cotacao` varchar(64) not null,
	`id_moeda` varchar(64) not null,
    `dt_data` date not null,
    `vr_valor` decimal(14,4) not null,
    primary key `pk_cotacao` (`id_cotacao`)
);