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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

Create table telefone( 
	id_telefone int unsigned auto_increment primary key, 
	telefone_residencial varchar(50), 
	telefone_celular varchar(50), 
	pessoa_id int unsigned not null,
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	constraint fk_telefone_pessoa foreign key(pessoa_id) references pessoa(id_pessoa) 
);

Create table servidor(
	id_servidor int unsigned auto_increment primary key,
	cargo_servidor varchar(30),
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	pessoa_id int unsigned not null,
	constraint fk_servidor_pessoa foreign key(pessoa_id) references pessoa(id_pessoa)
);


Create table instituicaoFinanciadora( 
	id_if int unsigned auto_increment primary key,
	nome_if varchar(40), 
	cnpj varchar(40), 
	orcamento_auxilio double,
    dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	pessoa_id int unsigned not null,
	constraint fk_discente_pessoa foreign key (pessoa_id) references pessoa(id_pessoa)
);

Create table auxilio(

	id_auxilio int unsigned auto_increment primary key,
	tipo_auxilio varchar(40),
	valor_auxilio double,
	validade_Inicial date,
	validade_final date,
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	perfil_socio_id int unsigned not null, 
	constraint fk_familiar_perfilSocio foreign key(perfil_socio_id) references perfilSocioEconomico(id_perfil_socio) 
);
		
Create table documento (
	id_documento int unsigned auto_increment primary key,
	nome_documento varchar(100),
	status_documento varchar(255),
	obs varchar(255),
	dt_modificacao timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	discente_id int unsigned not null,
	constraint fk_documento_discente foreign key(discente_id) references discente(id_discente)
);

Create table chat(
    id_chat int unsigned auto_increment primary key,
    remetente_id int unsigned,
    destinatario_id int unsigned,
    mensagem text,
    dt_modificacao timestamp DEFAULT CURRENT_TIMESTAMP,
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

INSERT INTO servidor (pessoa_id,cargo_servidor)
VALUES (1,'Coordenador');

INSERT INTO servidor (pessoa_id,cargo_servidor)
VALUES (2,'Estagiario');

INSERT INTO servidor (pessoa_id,cargo_servidor)
VALUES (3,'SubCoordenador');


INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educa√ß√£o e Tecnologia','156985465782',199999,1);

INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educa√ß√£o e Tecnologia','156985465782',199999,2);

INSERT INTO instituicaoFinanciadora (nome_if,cnpj,orcamento_auxilio,servidor_id)
VALUES ('Instituto Federal de Educa√ß√£o e Tecnologia','156985465782',199999,3);


INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicita√ß√£o de Auxilio Alimenta√ß√£o',1,1);

INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicita√ß√£o de Auxilio Alimenta√ß√£o',2,2);

INSERT INTO processo (data_requisicao,num_processo,assunto,interessado_id,servidor_id)
VALUES (20/06/2015,'1569','Solicita√ß√£o de Auxilio Alimenta√ß√£o',3,3);


INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Solteiro','Informatica',3,'Integral','Rua:Josefa Trindade','58119-000','Centro','Lagoa de ro√ßa',48,'Escola virgem das gra√ßas','PB','Estava precisando',1);

INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado','Informatica',3,'Integral','Rua:Aberlino ferreira','123456-000','Centro','Esperan√ßa',24,'Catedral','PB','Estava precisando',2);

INSERT INTO Discente (escola_origem,num_cartao_sus,estado_civil,curso,periodo_letivo,turno,endereco,cep,bairro,cidade,num_casa,ponto_ref,estado,motivo_solicitacao,pessoa_id)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado','Informatica','Integral',3,'Rua:Aderlado MAICATU','122346-111','Centro','Esperan√ßa',25,'Catedral','PB','Estava precisando',3);



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
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80,'1999-04-10','2000-05-10','√©',80,'111.123.111', 3);

INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',1);

INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',2);


INSERT INTO dadosbancarios (banco ,agencia ,num_agencia ,discente_id)
VALUES ('caixa', '1009','1338',3);


INSERT INTO perfilsocioeconomico (gastos_luz ,gastos_agua,gastos_telefone,servidor_id,discente_id,situacao_renda_Familiar,moradia,tipo_residencia_familiar,tipo_trabalho, gastos_aluguel,gastos_condominio, 
gastos_financiamento_casa_propria,tipo_moradia)
VALUES (58.45,25.85,52.50,2,2,'Dependente','Sozinho','Pr√≥pria quitada','Trabalho com v√≠nculo empregat√≠cio',0,0,0,'Casa Propia');

INSERT INTO perfilsocioeconomico (gastos_luz ,gastos_agua,gastos_telefone,servidor_id,discente_id,situacao_renda_Familiar,moradia,tipo_residencia_familiar,tipo_trabalho, gastos_aluguel,gastos_condominio, 
gastos_financiamento_casa_propria,tipo_moradia)
VALUES (58.45,25.85,52.50,3,3,'Dependente','Sozinho','Arrimo da fam√≠lia','Trabalho com v√≠nculo empregat√≠cio',0,0,0,'Casa Propia');


 
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
VALUES (1,2,'Oi linda voc√™ √© linda linda');
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
Create trigger tr_UpdateServidor before update
on servidor
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateAuxilio before update
on auxilio
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateDiscente before update
on discente
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateDocumento before update
on documento
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateEdital before update
on edital
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateFamiliar before update
on familiar
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateIF before update
on instituicaoFinanciadora
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdatePs before update
on perfilSocioEconomico
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;


delimiter $$
Create trigger tr_UpdateProcesso before update
on processo
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdateTelefone before update
on telefone
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_UpdatePessoa before update
on pessoa
for each row
begin
    
    set new.dt_modificacao = now();

END $$
delimiter ;

delimiter $$
Create trigger tr_encriptaSenha before insert
on pessoa
for each row
begin
   set new.senha = MD5(new.senha);
end $$
delimiter ;

delimiter $$
Create trigger tr_DeleteDiscente before delete
on discente
for each row
begin
    delete from dadosBancarios where discente_id = old.id_discente;
    delete from documentacao where discente_id = old.id_discente;
    delete from perfilSocioEconomico where discente_id = old.id_discente;
    
END $$
delimiter ;




delimiter $$
Create trigger tr_DeletePerfilSocioEconomico before delete
on perfilSocioEconomico
for each row
begin

	delete from familiar where perfil_socio_id = old.id_perfil_socio;
 
    
    

END $$

delimiter ;


delimiter $$
Create trigger tr_DeletePessoa before delete
on pessoa
for each row
begin

	delete from telefone where pessoa_id = old.id_pessoa;
    delete from servidor where pessoa_id = old.id_pessoa;
    delete from discente where pessoa_id = old.id_pessoa;
    delete from Processo where interessado_id = old.id_pessoa;
	delete from chat where remetente_id = old.id_pessoa;
    
    

END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteIF before delete
on instituicaofinanciadora
for each row
begin

	delete from auxilio where instituicaoFinanciadora_id = old.id_if;
    
  
END $$
delimiter ;


delimiter $$
Create trigger tr_DeleteServidor before delete
on servidor
for each row
begin
  
    delete from processo where servidor_id = old.id_servidor;
	delete from instituicaoFinanciadora where servidor_id = old.id_servidor;
	delete from perfilSocioEconomico where servidor_id = old.id_servidor;
  
    
END $$
delimiter ;


delimiter $$
Create trigger tr_DeleteProcesso before delete
on processo
for each row
begin

	delete from auxilio where processo_id = old.id_Processo;
    delete from edital where  processo_id = old.id_Processo;
  
    
    
end $$
delimiter ;
















/*-----------------------------------------Function-------------------------------*/
DELIMITER $$  
 DROP FUNCTION IF EXISTS `fun_valida_usuario`$$  
 CREATE FUNCTION `fun_valida_usuario`(p_matricula VARCHAR(20)  
                , p_senha VARCHAR(50) ) RETURNS INT(1)  
 BEGIN  
 DECLARE l_ret            INT(1) DEFAULT 0;  
     SET l_ret = IFNULL((SELECT DISTINCT 1  
                       FROM pessoa  
                      WHERE matricula = p_matricula 
                       AND senha = MD5(p_senha)),0);                           
 RETURN l_ret;  
 END$$  
 DELIMITER ; 
/*------------------------SELECTS----------------------------------*/
 
 /*-Verifica se a renda È menor que 1,5 por pessoa-*/
Select count(familiar.id_familiar),sum(familiar.renda) into @qtd_moradores,@renda_total
From familiar 
Inner join perfilSocioEconomico ps
On ps.id_perfil_socio = familiar.perfil_socio_id
Where ps.id_perfil_socio = 2;

Select Pessoa.nome_pessoa, Pessoa.matricula
From Pessoa
Inner Join Discente D
On D.pessoa_id = Pessoa.id_pessoa
where (@renda_total/@qtd_moradores) <= 1320
And D.id_discente = 3;


/*-------------------Discente----------------------*/
/*Consultar Processo ,serve tanto para pessoa quanto para os servidores*/
Select processo.num_processo,
	   processo.assunto,
	   processo.parecer,
	   pessoa.nome_pessoa,
	   pessoa.matricula 
from processo 
inner join pessoa 
	   on processo.interessado_id = pessoa.id_pessoa
where pessoa.matricula = '029';
	   
/*-Visualizar observaÁıes-*/
Select db.obs,
       ps.obs,
       documento.obs,
       processo.obs
from dadosBancarios db
inner join discente 
	on db.discente_id = discente.id_discente
inner join perfilSocioEconomico ps
	on ps.discente_id = discente.id_discente
inner join documento 
	on documento.discente_id = discente.id_discente
inner join processo
    on processo.interessado_id = discente.pessoa_id 
    where discente.id_discente = 2; //Provavelmente pela matricula,sÛ para demonstrar que sÛ vai ser filtrada uma pessoa,GROUP BY
	
/*------Visualizar dadosPessoais-----*/
 Select pessoa.`nome_pessoa`, 
        pessoa.`rg`, 
        pessoa.`matricula`, 
        pessoa.`data_nasc`, 
        pessoa.`sexo`,  
        pessoa.`email`, 
        pessoa.`cpf` ,
        discente.`escola_origem`, 
	    discente.`org_expeditor`, 
        discente.`num_cartao_sus`, 
        discente.`estado_civil`, 
        discente.`curso`, 
        discente.`periodo_letivo`, 
        discente.`turno`, 
        discente.`endereco`, 
        discente.`cep`, 
        discente.`bairro`, 
        discente.`cidade`, 
        discente.`num_casa`, 
        discente.`ponto_ref`, 
        discente.`estado`, 
        discente.`motivo_solicitacao`
       from discente
inner join pessoa
	  on discente.pessoa_id = pessoa.id_pessoa; //filtrar apenas uma pessoa,tambÈm.

/*------Visualizar dadosBancarios-----*/

Select db.`banco`, 
	   db.`agencia`, 
       db.`num_agencia`, 
       db.`saldo`  
from dadosBancarios db
      where db.discente_id = 2;


/*------Visualizar PerfilSocioEconomico-----*/


SELECT ps.`situacao_renda_familiar`, 
       ps.`moradia`, 
       ps.`tipo_Moradia`, 
       ps.`tipo_residencia_familiar`, 
       ps.`tipo_trabalho`, 
       ps.`gastos_aluguel`, 
       ps.`gastos_condominio`, 
       ps.`gastos_luz`, 
       ps.`gastos_agua`, 
       ps.`gastos_telefone`,  
       ps.`gastos_financiamento_casa_propria`, 
       familiar.`nome_familiar`, 
       familiar.`idade_familiar`, 
       familiar.`grau_de_instrucao`,
       familiar.`profissao`, 
       familiar.`renda`,
       familiar.doenca,
       pessoa.nome_pessoa 
FROM `perfilsocioeconomico` ps
inner join familiar
	on familiar.perfil_socio_id = ps.id_perfil_socio
inner join servidor
	on ps.servidor_id = servidor.id_servidor
inner join pessoa
	on pessoa.id_pessoa = servidor.pessoa_id
 where ps.discente_id = 2;
Seleciona duas linhas se vocÍ tiver mais de um valor em um atributo N


/*------ Visualizar Documentacao -----*/

Select  `nome_documento`, 
        `status_documento`
from documento
where documento.discente_id = 2;

/*Visualizar o que foi recebido atÈ o mÍs obs:Verificar se o discente recebeu todos os mÍses e quantos auxÌlios ele recebe*/
select count(aux.id_auxilio) into @quantidade from auxilio aux
inner join processo
	on (aux.processo_id = processo.id_processo) 
	and (processo.interessado_id = 2) 
	and(processo.parecer = 'Aprovado') ;
Select db.agencia, 
	   db.num_agencia, 
	   pessoa.nome_pessoa, 
	   EXTRACT(MONTH FROM CURDATE()) *(@quantidade*80) as total_Gasto 
	   from dadosBancarios db 
	   inner join discente 
			on discente.id_discente = db.discente_id 
	   inner join pessoa 
			on discente.pessoa_id = pessoa.id_pessoa 
		    and pessoa.id_pessoa = 2;

/*-    Visualizar auxÌlios -*/

Select  auxilio.tipo_auxilio,
		auxilio.valor_auxilio,
        auxilio.validade_inicial,
        auxilio.validade_final
from auxilio
inner join processo
	  on auxilio.processo_id = processo.id_processo
inner join pessoa
	 on processo.interessado_id = pessoa.id_pessoa
where pessoa.matricula='029';

/*----------------------------------------------------- SERVIDOR ---------------------------------------------*/

/*-------Visualizar todas as instituiÁıes financiadoras que ele gerencia*/
Select  instf.`nome_if`, 
		instf.`cnpj`, 
		instf.`orcamento_auxilio`
from instituicaoFinanciadora InstF
inner join servidor
 	on instf.servidor_id = servidor.id_servidor and servidor.id_servidor = 2; 
	
/*-Visualizar inst. financiadora por cnpj -*/

Select  instf.`nome_if`, 
		instf.`cnpj`, 
		instf.`orcamento_auxilio`
from instituicaoFinanciadora InstF
inner join servidor
 	on instf.servidor_id = servidor.id_servidor and servidor.id_servidor = 2
where cnpj =  156985465782;

/*-Visualizar pelo nome -*/
Select  instf.`nome_if`, 
		instf.`cnpj`, 
		instf.`orcamento_auxilio`
from instituicaoFinanciadora InstF
inner join servidor
 	on instf.servidor_id = servidor.id_servidor and servidor.id_servidor = 2
where instf.nome_if = 'Instituto Federal de EducaÁ„o e Tecnolog';

/*------------------------- Visualizar todos os auxilios gerenciados --------------*/


Select  auxilio.`tipo_auxilio`, 
	    auxilio.`valor_auxilio`, 
        auxilio.`validade_inicial`, 
        auxilio.`validade_final`, 
        instF.nome_if,
        processo.num_processo,
        pessoa.nome_pessoa
from auxilio
inner join instituicaoFinanciadora instF
	on auxilio.instituicaoFinanciadora_id = instF.id_if
inner join processo
	on auxilio.processo_id = processo.id_processo
inner join 	pessoa
	on processo.interessado_id = pessoa.id_pessoa
where processo.servidor_id = 2; 


/*Quantidade de discentes Cadastrados */

Select count(id_discente) quantidade_discentes_cadastrados from discente 

/*----- Visualizar processos que ele gerencia  ---------*/
Select processo.num_processo,
	   processo.assunto,
	   processo.parecer,
       pessoa.nome_pessoa,
       pessoa.matricula
from processo 
inner join servidor
	   on processo.servidor_id = servidor.id_servidor
inner join pessoa 
	   on processo.interessado_id = pessoa.id_pessoa
where processo.servidor_id = 2;

/*-Visualizar processo pelo n˙mero-*/
Select processo.num_processo,
	   processo.assunto,
	   processo.parecer,
	   pessoa.nome_pessoa,
	   pessoa.matricula 
from processo 
inner join pessoa 
	   on processo.interessado_id = pessoa.id_pessoa
where processo.num_processo = '029';

/*-Visualizar pelo nome do discente-*/

Select processo.num_processo,
	   processo.assunto,
	   processo.parecer,
	   pessoa.nome_pessoa,
	   pessoa.matricula 
from processo 
inner join pessoa 
	   on processo.interessado_id = pessoa.id_pessoa
where pessoa.nome_pessoa like '%Rayla%';

/*-Visualizar todos os discentes que recebem auxÌlio-*/
select processo.num_processo,
	   pessoa.nome_pessoa,
       pessoa.matricula,
       db.agencia,
       db.banco,
       db.num_agencia,
       aux.tipo_auxilio,
       aux.valor_auxilio
from processo
inner join pessoa
	on pessoa.id_pessoa = processo.interessado_id
inner join discente 
	on discente.pessoa_id = pessoa.id_pessoa
inner join dadosBancarios db
	on db.discente_id = discente.id_discente
inner join auxilio aux
	on aux.processo_id = processo.id_processo
where processo.parecer = 'Aprovado';
/*-Visualizar todos os discentes que recebem auxÌlio pelo tipo-*/
select processo.num_processo, 
	   pessoa.nome_pessoa, 
	   pessoa.matricula, 
	   db.agencia, 
	   db.banco, 
	   db.num_agencia, 
	   aux.tipo_auxilio, 
	   aux.valor_auxilio 
from processo
inner join pessoa 
	on pessoa.id_pessoa = processo.interessado_id 
inner join discente 
	on discente.pessoa_id = pessoa.id_pessoa 
inner join dadosBancarios db 
	on db.discente_id = discente.id_discente 
inner join auxilio aux 
	on aux.processo_id = processo.id_processo 
where processo.parecer = 'Aprovado' and aux.tipo_auxilio = 'Transporte' 




/*-Filtrar editais da instituicao financiadora que ele gerencia-*/
SELECT aux.`tipo_auxilio`,
	   edital.`ini_inscricoes`, 
       edital.`fim_inscricoes`, 
       edital.`ini_entrega_form`, 
       edital.`ano`, 
       edital.`fim_form`, 
       edital.`descricao`, 
       edital.`titulo`, 
       edital.`valor_bolsa_discente`, 
       edital.`vagas_bolsistas`, 
       edital.`num_edital`, 
       instF.nome_if 
FROM `auxilio` aux
inner join edital 
	on  edital.processo_id = aux.processo_id
inner join instituicaofinanciadora instf
 	on instf.id_if = aux.instituicaoFinanciadora_id;


/*-Editais por ano-*/
SELECT edital.`ini_inscricoes`, 
       edital.`fim_inscricoes`, 
       edital.`ini_entrega_form`, 
       edital.`ano`, 
       edital.`fim_form`, 
       edital.`descricao`, 
       edital.`titulo`, 
       edital.`valor_bolsa_discente`, 
       edital.`vagas_bolsistas`, 
       edital.`num_edital`, 
       processo.`num_processo` 
FROM `edital` 
inner join processo/*-Todos editais-*/
SELECT edital.`ini_inscricoes`, 
       edital.`fim_inscricoes`, 
       edital.`ini_entrega_form`, 
       edital.`ano`, 
       edital.`fim_form`, 
       edital.`descricao`, 
       edital.`titulo`, 
       edital.`valor_bolsa_discente`, 
       edital.`vagas_bolsistas`, 
       edital.`num_edital`, 
       processo.`num_processo` 
FROM `edital` 
inner join processo
on edital.processo_id = processo.id_processo;

/*-Quantidade de auxÌlios de discente -*/
select count(aux.id_auxilio) quantidade_auxilios from auxilio aux
inner join processo
	on (aux.processo_id = processo.id_processo) and (processo.interessado_id = 2) and(processo.parecer = 'Aprovado');

/*-Quanto tÍm no caixa da instituiÁ„o financiadora dos auxÌlios-*/

SELECT `orcamento_auxilio` FROM `instituicaofinanciadora` 
	where servidor_id=2; 
	
/*-Seleciona as conversas das pessoas -*/	
SELECT  remetente.nome_pessoa ,
	    destinatario.nome_pessoa,
        chat.mensagem, 
        chat.dt_registro enviado_as 
FROM chat 
inner join pessoa remetente
	on chat.remetente_id = remetente.id_pessoa
inner join pessoa destinatario
	on chat.destinatario_id = destinatario.id_pessoa;
	
	
/*-------------------Quantidade de auxÌlios disponÌveis-----------------------------*/	

   Select count(parecer) into @qtde from processo
   	where parecer = 'Aprovado' and assunto = 'RequisiÁ„o de auxÌlios';
    Select (vagas_bolsistas - @qtde) from edital ;
   
    
/*---------------------------Selecionar pessoas modificadas nos ˙ltimos 15 dias,importante para o assistente social------------------------------------------------*/
     
Select processo.num_processo,
       processo.assunto,
       processo.parecer,
       pessoa.matricula,
       pessoa.nome_pessoa
from processo
inner join pessoa
	on pessoa.id_pessoa = processo.interessado_id
where datediff(now(),pessoa.dt_registro)<= 15;



