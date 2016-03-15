Create database aidManager;
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

Create table chat(
    id_chat int unsigned auto_increment primary key,
    remetente_id int unsigned,
    destinatario_id int unsigned,
    mensagem text,
    dt_registro timestamp DEFAULT CURRENT_TIMESTAMP,
    constraint fk_chat_remetente foreign key (remetente_id) references pessoa(id_pessoa),
    constraint fk_chat_destinatario foreign key (destinatario_id) references pessoa(id_pessoa)
);

/*-------------------------------------------- INSERTS ------------------------------------------------------------------*/
INSERT INTO pessoa (nome_pessoa,rg,matricula,data_nasc,sexo,senha,email,cpf)
VALUES ('Fanny Vieira Medeiros', 4179958, 121,'2000-08-10','feminino','123','fannyvieira@gmail.com','701.199.264-23');

INSERT INTO pessoa (nome_pessoa,rg,matricula,data_nasc,sexo,senha,email,cpf)
VALUES ('Rayla Medeiros da Silva', 4279958, 122,'1999-08-17','feminino','123','raylamedeiiros@gmail.com','123.456.234-45');

INSERT INTO pessoa (nome_pessoa,rg,matricula,data_nasc,sexo,senha,email,cpf)
VALUES ('Mateus Rhan Oliveira', 4379958, 123,'1999-06-25','Masculino','123','mateus.oliveira@gmail.com','345.678.990-67');


INSERT INTO telefone (pessoa_id,telefone_celular,telefone_residencial)
VALUES (1,'9954684','33364859');

INSERT INTO telefone (pessoa_id,telefone_celular,telefone_residencial)
VALUES (2,'9854684','32364859');

INSERT INTO telefone (pessoa_id,telefone_celular,telefone_residencial)
VALUES (3,'9754684','31364859');

INSERT INTO servidor (pessoa_id,cargo_servidor,tipo_servidor)
VALUES (1,'Coordenador','Assistente Social');

INSERT INTO servidor (pessoa_id,cargo_servidor,tipo_servidor)
VALUES (2,'Estagiario','Tecnico admin');

INSERT INTO servidor (pessoa_id,cargo_servidor,tipo_servidor)
VALUES (3,'SubCoordenador','Tecnico admin');


INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,1);

INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,2);

INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,3);


INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',1,1);

INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',2,2);

INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',3,3);


INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Solteiro','Informatica',3,'Integral','Rua:Josefa Trindade','58119-000','Centro','Lagoa de roça',48,'Escola virgem das graças','PB','Estava precisando',1);

INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado','Informatica',3,'Integral','Rua:Aberlino ferreira','123456-000','Centro','Esperança',24,'Catedral','PB','Estava precisando',2);

INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado','Informatica','Integral',3,'Rua:Aderlado MAICATU','122346-111','Centro','Esperança',25,'Catedral','PB','Estava precisando',3);



INSERT INTO auxilio (valor_auxilio ,validade_inicial ,validade_final ,instituicaoFinanciadora_id,processo_id)
VALUES (80.00,14/02/2015,14/02/2016,1,1);

INSERT INTO auxilio (valor_auxilio ,validade_inicial ,validade_final ,instituicaoFinanciadora_id,processo_id)
VALUES (80.00,14/02/2015,14/02/2016,2,2);

INSERT INTO auxilio (valor_auxilio ,validade_inicial ,validade_final ,instituicaoFinanciadora_id,processo_id)
VALUES (80.00,14/02/2015,14/02/2016,3,3);


INSERT INTO edital (ini_inscricoes,fim_inscricoes ,ano ,titulo ,vagas_bolsistas,ini_entrega_form,fim_form,descricao,valor_bolsa_discente,num_edital,processo_id)
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios',80,'1999-07-10','2000-08-10','uie',80,'123.107.341', 1);

INSERT INTO edital (ini_inscricoes,fim_inscricoes ,ano ,titulo ,vagas_bolsistas,ini_entrega_form,fim_form,descricao,valor_bolsa_discente,num_edital,processo_id)
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios',80,'2000-08-10','2000-09-10',' ',80,'999.807.901',2);


INSERT INTO edital (ini_inscricoes,fim_inscricoes ,ano ,titulo ,vagas_bolsistas,ini_entrega_form,fim_form,descricao,valor_bolsa_discente,num_edital,processo_id)
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80,'1999-04-10','2000-05-10','é',80,'111.123.111', 3);

INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',1);

INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',2);


INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',3);


INSERT INTO perfilsocioeconomico (gastos_luz ,gastos_agua,gastos_telefone,servidor_id,discente_id,situacao_renda_Familiar,moradia,tipo_residencia_familiar,tipo_trabalho, gastos_aluguel,gastos_condominio, 
gastos_financiamento_casa_propria,tipo_moradia)
VALUES (58.45,25.85,52.50,2,2,'Dependente','Sozinho','Própria quitada','Trabalho com vínculo empregatício',0,0,0,'Casa Propia');

INSERT INTO perfilsocioeconomico (gastos_luz ,gastos_agua,gastos_telefone,servidor_id,discente_id,situacao_renda_Familiar,moradia,tipo_residencia_familiar,tipo_trabalho, gastos_aluguel,gastos_condominio, 
gastos_financiamento_casa_propria,tipo_moradia)
VALUES (58.45,25.85,52.50,3,3,'Dependente','Sozinho','Arrimo da família','Trabalho com vínculo empregatício',0,0,0,'Casa Propia');


 
INSERT INTO familiar (nome_familiar,idade_familiar,grau_de_instrucao,perfil_socio_id ,profissao,renda,doenca)
VALUES ('Joao Francisco', 48,'Ensino Fundamental',1,'agricutor',588.50,'Nenhuma');

INSERT INTO familiar (nome_familiar,idade_familiar,grau_de_instrucao,perfil_socio_id ,profissao,renda,doenca)
VALUES ('Joao Francisco', 48,'Ensino Fundamental',2,'agricutor',588.50,'Nenhuma');



INSERT INTO documento (nome_documento ,status_documento ,discente_id )
VALUES ('RG, CPF, Registro', 'Ok',1);

INSERT INTO documento (nome_documento ,status_documento ,discente_id )
VALUES ('RG, CPF, Registro', 'Ok',2);

INSERT INTO documento (nome_documento,status_documento ,discente_id )
VALUES ('RG, CPF, Registro', 'Ok',3);
		

INSERT INTO `chat`(`remetente_id`, `destinatario_id`, `mensagem`)
VALUES (1,2,'Oi linda você é linda linda');
INSERT INTO `chat`(`remetente_id`, `destinatario_id`, `mensagem`)
VALUES (2,1,'Eu sei,sua linda <3');
/*-------------------------------Triggers------------------------------*/
delimiter $$
Create trigger tr_updateSaldo before update 
on dadosBancarios
for each row
begin

	Select instituicaoFinanciadora_id  @id from auxilio 
    where id_discente = old.discente_id;
	update instituicaoFinanciadora 
    set orcamento_auxilio = orcamento_auxilio - new.saldo 
    where id_if = @id;

end $$
DELIMITER ;


delimiter $$
Create trigger tr_updateEdital before update
on edital
for each row
begin
	if(new.ano < 0 or new.valorBolsaDiscente <0 or datediff(new.fimInscricoes,new.iniInscricoes) < 0 or datediff(new.fimForm,new.iniEntregaForm) < 0 or new.vagasBolsistas < 0 )then
    set new.idEdital = null;
    end if;

end $$
delimiter ;

