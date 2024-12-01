create database db_estacionamento_trab_final owner postgres;
create extension postgis;


-------------

create table tb_estacionamento (
	id serial primary key,
	nome varchar(255) UNIQUE,
	preco_per_minute float,
	area geometry	
);

create table tb_veiculo (
	id serial,	
	placa varchar(255) UNIQUE
);

create table ponto(
	id serial primary key,
	dt_ponto timestamp,
	placa varchar(255)  references tb_veiculo (placa),
	localizacao geometry
);
-------------------
--estacionamentos

INSERT into tb_estacionamento (nome,preco_per_minute,area) values ('Estacionamento 1',1.2,st_geomfromtext('POLYGON((0 0,0 1,1 1,1 0,0 0))',4326));
INSERT into tb_estacionamento (nome,preco_per_minute,area) values ('Estacionamento 2',3,st_geomfromtext('POLYGON((2 2,2 3,3 3,3 2,2 2))',4326));
INSERT into tb_estacionamento (nome,preco_per_minute,area) values ('Estacionamento 3',5,st_geomfromtext('POLYGON((4 4,4 5,5 5,5 4,4 4))',4326));

--------------

select case when (st_within(localizacao,(select area from tb_estacionamento where id=1))=true)
		then (select nome from tb_estacionamento where id=1)
            when(st_within(localizacao,(select area from tb_estacionamento where id=2))=true)
		then (select nome from tb_estacionamento where id=2)
	    when(st_within(localizacao,(select area from tb_estacionamento where id=3))=true)
		then (select nome from tb_estacionamento where id=3)
	end as verifica,
	st_astext(localizacao) as localizacao,
	placa,
	tb_estacionamento.preco_per_minute as preco,
	dt_ponto as tempo
	from ponto 
	join tb_estacionamento on (tb_estacionamento.nome = case when (st_within(localizacao,(select area from tb_estacionamento where id=1))=true)
		then (select nome from tb_estacionamento where id=1)
            when(st_within(localizacao,(select area from tb_estacionamento where id=2))=true)
		then (select nome from tb_estacionamento where id=2)
	    when(st_within(localizacao,(select area from tb_estacionamento where id=3))=true)
		then (select nome from tb_estacionamento where id=3)
	end)
	where placa=?
-------------------
select case when (st_within(localizacao,(select area from tb_estacionamento where id=1))=true)
		then (select nome from tb_estacionamento where id=1)
            when(st_within(localizacao,(select area from tb_estacionamento where id=2))=true)
		then (select nome from tb_estacionamento where id=2)
	    when(st_within(localizacao,(select area from tb_estacionamento where id=3))=true)
		then (select nome from tb_estacionamento where id=3)
	    else 'N/A'
	end as verifica,
	st_astext(localizacao) as localizacao,
	placa,
	tb_estacionamento.preco_per_minute as preco,
	dt_ponto as tempo
	from ponto 
	join tb_estacionamento on (TRUE)
	where placa=?