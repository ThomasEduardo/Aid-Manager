
use aidManager;

Create table  pessoa(
	id_pessoa int unsigned auto_increment primary key,
	nome_pessoa varchar(255),
	rg varchar(20),
	matricula varchar(30),
	data_nasc date,
	sexo varchar(20),
	senha varchar(30),
	email varchar(40),
	cpf varchar(40),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

Create table telefone( 
	id_telefone int unsigned auto_increment primary key, 
	telefone_residencial varchar(50), 
	telefone_celular varchar(50), 
	pessoa_id int unsigned not null,
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	constraint fk_telefone_pessoa foreign key(pessoa_id) references pessoa(id_pessoa) 
);

Create table servidor(
	id_servidor int unsigned auto_increment primary key,
	cargo_servidor varchar(30),
	tipo_servidor varchar(200),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	pessoa_id int unsigned not null,
	constraint fk_servidor_pessoa foreign key(pessoa_id) references pessoa(id_pessoa)
);


Create table instituicaoFinanciadora( 
	id_if int unsigned auto_increment primary key,
	nome_if varchar(40), 
	cnpj varchar(40), 
	orcamento_auxilio double,
    dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
	servidor_id int unsigned not null, 
	constraint fk_instituicaFinanciadora_servidor foreign key(servidor_id) references servidor(id_servidor)
);

Create table processo(
	id_processo int unsigned auto_increment primary key,
	data_requisicao date,
	obs varchar(255),
	num_processo varchar(50),
	assunto varchar(255),
	parecer varchar(255),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	interessado_id int unsigned not null,
	servidor_id int unsigned not null,
	constraint fk_processo_interessado foreign key(interessado_id) references pessoa(id_pessoa),
	constraint fk_processo_servidor foreign key(servidor_id) references servidor(id_servidor)
);


Create table Discente ( 
	id_discente int unsigned auto_increment primary key, 
	escola_origem varchar(60), 
	org_expeditor varchar(60), 
	num_cartao_sus varchar(60), 
	estado_civil varchar(60), 
	curso varchar(60),
	periodo_letivo int,
	turno varchar(60), 
	endereco varchar(60),
	cep varchar(60),
	bairro varchar(60), 
	cidade varchar(60),
	num_casa int,
	ponto_ref varchar(50),
	estado varchar(60),
	motivo_solicitacao varchar(255),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	pessoa_id int unsigned not null,
	constraint fk_discente_pessoa foreign key (pessoa_id) references pessoa(id_pessoa)
);

Create table auxilio(

	id_auxilio int unsigned auto_increment primary key,
	tipo_auxilio varchar(40),
	valor_auxilio double,
	validade_Inicial date,
	validade_final date,
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	instituicaoFinanciadora_id int unsigned,
	processo_id int unsigned not null,
	constraint fk_auxilio_IF foreign key(instituicaoFinanciadora_id) references instituicaoFinanciadora(id_if),
	constraint fk_auxilio_processo foreign key(processo_id) references processo(id_processo)
	
);

Create table edital(
	id_edital int unsigned auto_increment primary key,
	ini_inscricoes date,
	fim_inscricoes date,
	ini_entrega_form date ,
	ano int,
	fim_form date,
	descricao varchar(255),
	titulo varchar(100),
	valor_bolsa_discente double,
	vagas_bolsistas int,
	num_edital varchar(50),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	processo_id int unsigned not null,
	constraint fk_edital_processo foreign key(processo_id) references processo(id_processo) 
);

Create table dadosBancarios(
	id_dados_bancarios int unsigned auto_increment primary key,
	banco varchar(255),
	agencia varchar(255),
	num_agencia varchar(255),
    saldo double,
    obs varchar(255),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    discente_id int unsigned not null,
    constraint fk_dadosBancarios_Discente foreign key(discente_id) references discente(id_discente)
);

Create table PerfilSocioEconomico(
	id_perfil_socio int unsigned auto_increment primary key,
	situacao_renda_Familiar varchar(255),
	moradia varchar(255),
	tipo_moradia varchar(255),
	tipo_residencia_familiar varchar(255),
	tipo_trabalho varchar(255),
	gastos_aluguel double,
	gastos_condominio double,
	gastos_luz double,
	gastos_agua double,
	gastos_telefone double,
	obs varchar(255),
	gastos_financiamento_casa_propria double,
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    servidor_id int unsigned not null,
    discente_id int unsigned not null,
    constraint fk_perfilsocioeconomico_servidor foreign key(servidor_id) references servidor(id_servidor),
    constraint fk_perfilsocioeconomico_Discente foreign key(discente_id) references discente(id_discente)
 );


Create table Familiar( 
	id_familiar int unsigned auto_increment primary key, 
	nome_familiar varchar(70), 
	idade_familiar int unsigned, 
	grau_de_instrucao int unsigned, 
	profissao varchar(70), 
	renda double,
	doenca varchar(255),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	perfil_socio_id int unsigned not null, 
	constraint fk_familiar_perfilSocio foreign key(perfil_socio_id) references perfilSocioEconomico(id_perfil_socio) 
);
		
Create table documento (
	id_documento int unsigned auto_increment primary key,
	nome_documento varchar(100),
	status_documento varchar(255),
	obs varchar(255),
	dt_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	discente_id int unsigned not null,
	constraint fk_documento_discente foreign key(discente_id) references discente(id_discente)
);

		