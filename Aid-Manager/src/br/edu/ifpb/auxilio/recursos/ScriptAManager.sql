		CREATE DATABASE aidManager;
		USE aidManager;
		
		Create table  pessoa(
				idPessoa int unsigned auto_increment primary key,
				nomePessoa varchar(255),
				rg varchar(20),
				matricula varchar(30),
				dataNasc date,
				sexo varchar(20),
				senha varchar(30),
				email varchar(40),
				cpf varchar(40)

		);
	
		Create table telefone( 
				idTelefone int unsigned auto_increment primary key, 
				telefoneResidencial varchar(50), 
				telefoneCelular varchar(50), 
				idPessoa int unsigned not null,
				constraint fk_telefone_pessoa foreign key(idPessoa) references pessoa(idPessoa) 
		);
	
		Create table servidor(
				  idServidor int unsigned auto_increment primary key,
				  cargoServidor varchar(30),
				  idPessoa int unsigned not null,
				  constraint fk_servidor_pessoa foreign key(idPessoa) references pessoa(idPessoa)
		);
	
	
		Create table assistenteSocial(
    
				idAssistenteSocial int unsigned auto_increment primary key,
				idServidor int unsigned not null,
				constraint fk_assistenteSocial_Servidor foreign key(idServidor) references servidor(idServidor)
    
		);

		Create table TecnicoAdmin(
    
				idTecnicoAdmin int unsigned auto_increment primary key,
				idServidor int unsigned not null,
				constraint fk_tecnicoAdmin_Servidor foreign key(idServidor) references servidor(idServidor)
		);
	
		Create table instituicaoFinanciadora( 
		
				idIF int unsigned auto_increment primary key,
				nomeIF varchar(40), 
				cnpj varchar(40), 
				orcamentoAuxilio double, 
				idTecnicoAdmin int unsigned not null, 
				constraint fk_instituicaFinanciado_tecnicoAdmin foreign key(idTecnicoAdmin) references tecnicoAdmin(idTecnicoAdmin)
				
		);

	
		Create table processo(
     
				idProcesso int unsigned auto_increment primary key,
				dataRequisicao date,
				obs varchar(255),
				numProcesso varchar(50),
				assunto varchar(255),
				parecer varchar(255),
				idInteressado int unsigned not null,
				idServidor int unsigned not null,
				constraint fk_processo_interessado foreign key(idInteressado) references pessoa(idPessoa),
				constraint fk_processo_servidor foreign key(idServidor) references servidor(idServidor)
				
		);
		create table resultados ( 
				idResultados int unsigned auto_increment primary key, 
				tipoauxilio VARCHAR(30),
				idProcesso int unsigned not null,
				constraint fk_resultados_processo foreign key(idProcesso) references processo(idProcesso)
		);
		Create table Discente ( 

				idDiscente int unsigned auto_increment primary key, 
				escolaOrigem varchar(60), 
				orgExpeditor varchar(60), 
				numCartaoSus varchar(60), 
				estadoCivil varchar(60), 
				idade int, 
				curso varchar(60),
				periodoLetivo int,
				turno varchar(60), 
				endereco varchar(60),
				cep varchar(60),
				bairro varchar(60), 
				cidade varchar(60),
				numCasa int,
				pontoRef varchar(50),
				estado varchar(60),
				motivoSolicitacao varchar(255),
				idPessoa int unsigned not null,
				idResultados int unsigned not null,
				constraint fk_discente_pessoa foreign key (idPessoa) references pessoa(idPessoa),
				constraint fk_discente_resultados foreign key (idResultados) references Resultados(idResultados)
		);
		
		
		Create table auxilio(
    
				idAuxilio int unsigned auto_increment primary key,
				tipoAuxilio varchar(40),
				valorAuxilio double,
				validadeInicial date,
				validadeFinal date,
				idInstituicaoFinanciadora int unsigned,
				idTecnicoAdmin int unsigned,
    			idProcesso int unsigned not null,
                idDiscente int unsigned not null,
				constraint fk_auxilio_IF foreign key(idInstituicaoFinanciadora) references instituicaoFinanciadora(idIF),
				constraint fk_auxilio_TecnicoAdmin foreign key(idTecnicoAdmin) references tecnicoAdmin(idTecnicoAdmin),
    			constraint fk_auxilio_processo foreign key(idProcesso) references processo(idProcesso),
                constraint fk_auxilio_Discente foreign key(idDiscente) references discente(idDiscente)

		);
		Create table edital(
		
				idEdital int unsigned auto_increment primary key,
				iniInscricoes date,
				FimInscricoes date,
				iniEntregaForm date ,
				ano int,
				fimForm date,
				descricao varchar(255),
				titulo varchar(100),
				valorBolsaDiscente double,
				vagasBolsistas int,
				numEdital varchar(50),
				idProcesso int unsigned not null,
				constraint fk_edital_processo foreign key(idProcesso) references processo(idProcesso) 
		
		);
		Create table dadosBancarios(
		
				idDadosBancarios int unsigned auto_increment primary key,
				banco varchar(255),
				agencia varchar(255),
				numAgencia varchar(255),
                saldo double,
                idDiscente int unsigned not null,
                constraint fk_dadosBancarios_Discente foreign key(idDiscente) references discente(idDiscente)
		
		);
		Create table PerfilSocioEconomico(
		    
		    
				idPerfilSocio int unsigned auto_increment primary key,
				situacaoRendaFamiliar varchar(255),
				moradia varchar(255),
				situacaoMoradia varchar(255),
				residenciaFamiliar varchar(255),
				situacaoTrabalho varchar(255),
				aluguel double,
				condominio double,
				luz double,
				agua double,
				telefone double,
				financiamentoCasaPropria double,
                idAssistenteSocial int unsigned not null,
                idDiscente int unsigned not null,
                constraint fk_perfilsocioeconomico_Assistentesocial foreign key(idAssistenteSocial) references assistenteSocial(idAssistenteSocial),
                constraint fk_perfilsocioeconomico_Discente foreign key(idDiscente) references discente(idDiscente)
          
		);
		Create table situacaoSaude(
		    
		    idSituacaoSaude int unsigned auto_increment primary key,
			membro varchar(50),
			doenca varchar(50),
			idPerfilSocioEconomico int unsigned not null,
		    constraint fk_situacaoSaude_perfilSocio foreign key (idPerfilSocioEconomico) references perfilSocioEconomico(idPerfilSocio)
		);
		Create table residentesMoradia(
			    idRm int unsigned,
				residentes varchar(255),
				idPerfilSocio int unsigned not null,
			    constraint fk_residentesMoradia_perfilSocio foreign key(idPerfilSocio) references perfilSocioEconomico(idPerfilSocio)
			    
		);

		Create table composicaoRendaFamiliar( 
			idCrf int unsigned auto_increment primary key, 
			nome varchar(70), 
			idade int unsigned, 
			grauDeInstrucao int unsigned, 
			profissao varchar(70), 
			renda double,
			idPerfilSocio int unsigned not null, 
			constraint fk_composicaoRendaFamiliar_idPerfilSocio foreign key(idPerfilSocio) references perfilSocioEconomico(idPerfilSocio) 
		);
		
		Create table documentacao (
			
			idDocumentacao int unsigned auto_increment primary key,
			nomeDocumentacao varchar(100),
			status_Documento varchar(255),
			obs varchar(255),
			iddiscente int unsigned not null,
			constraint fk_documentacao_discente foreign key(idDiscente) references discente(idDiscente)

		);
		Create table DiscentePre ( 

				idDiscentePre int unsigned auto_increment primary key, 
				escolaOrigem varchar(60), 
				orgExpeditor varchar(60), 
				numCartaoSus varchar(60), 
				estadoCivil varchar(60), 
				idade int, 
				curso varchar(60),
				periodoLetivo int,
				turno varchar(60), 
				endereco varchar(60),
				cep varchar(60),
				bairro varchar(60), 
				cidade varchar(60),
				numCasa int,
				pontoRef varchar(50),
				estado varchar(60),
				motivoSolicitacao varchar(255),
				idPessoa int unsigned not null,
				idResultados int unsigned not null,
				constraint fk_discentePre_pessoa foreign key (idPessoa) references pessoa(idPessoa),
				constraint fk_discentePre_resultados foreign key (idResultados) references Resultados(idResultados)
		);
		
		/*----------------- Tabelas de backup -------------------------*/
		Create table  bkpPessoa(
				idPessoa int unsigned auto_increment primary key,
				nomePessoa varchar(255),
				rg varchar(20),
				matricula varchar(30),
				dataNasc date,
				sexo varchar(20),
				senha varchar(30),
				email varchar(40),
				cpf varchar(40)

		);
	
		Create table bkpTelefone( 
				idTelefone int unsigned auto_increment primary key, 
				telefoneResidencial varchar(50), 
				telefoneCelular varchar(50), 
				idPessoa int unsigned not null,
				constraint fk_bkpTelefone_Pessoa foreign key(idPessoa) references bkpPessoa(idPessoa) 
		);
	
		Create table bkpServidor(
				  idServidor int unsigned auto_increment primary key,
				  cargoServidor varchar(30),
				  idPessoa int unsigned not null,
				  constraint fk_bkpServidor_pessoa foreign key(idPessoa) references bkpPessoa(idPessoa)
		);
	
	
		Create table bkpAssistenteSocial(
    
				idAssistenteSocial int unsigned auto_increment primary key,
				idServidor int unsigned not null,
				constraint fk_bkpAssistenteSocial_Servidor foreign key(idServidor) references bkpServidor(idServidor)
    
		);

		Create table bkpTecnicoAdmin(
    
				idTecnicoAdmin int unsigned auto_increment primary key,
				idServidor int unsigned not null,
				constraint fk_bkpTecnicoAdmin_Servidor foreign key(idServidor) references bkpServidor(idServidor)
		);
	
		Create table bkpInstituicaoFinanciadora( 
		
				idIF int unsigned auto_increment primary key,
				nomeIF varchar(40), 
				cnpj varchar(40), 
				orcamentoAuxilio double, 
				idTecnicoAdmin int unsigned not null, 
				constraint fk_bkpInstituicaFinanciado_tecnicoAdmin foreign key(idTecnicoAdmin) references bkpTecnicoAdmin(idTecnicoAdmin)
				
		);

	
		Create table bkpProcesso(
     
				idProcesso int unsigned auto_increment primary key,
				dataRequisicao date,
				obs varchar(255),
				numProcesso varchar(50),
				assunto varchar(255),
				parecer varchar(255),
				idInteressado int unsigned not null,
				idServidor int unsigned not null,
				constraint fk_bkpProcesso_interessado foreign key(idInteressado) references bkpPessoa(idPessoa),
				constraint fk_bkpProcesso_servidor foreign key(idServidor) references bkpServidor(idServidor)
				
		);
		create table bkpResultados ( 
				idResultados int unsigned auto_increment primary key, 
				tipoauxilio VARCHAR(30),
				idProcesso int unsigned not null,
				constraint fk_bkpResultados_processo foreign key(idProcesso) references bkpProcesso(idProcesso)
		);
		Create table bkpDiscente ( 

				idDiscente int unsigned auto_increment primary key, 
				escolaOrigem varchar(60), 
				orgExpeditor varchar(60), 
				numCartaoSus varchar(60), 
				estadoCivil varchar(60), 
				idade int, 
				curso varchar(60),
				periodoLetivo int,
				turno varchar(60), 
				endereco varchar(60),
				cep varchar(60),
				bairro varchar(60), 
				cidade varchar(60),
				numCasa int,
				pontoRef varchar(50),
				estado varchar(60),
				motivoSolicitacao varchar(255),
				idPessoa int unsigned not null,
				idResultados int unsigned not null,
				constraint fk_bkpDiscente_pessoa foreign key (idPessoa) references bkpPessoa(idPessoa),
				constraint fk_bkpDiscente_resultados foreign key (idResultados) references bkpResultados(idResultados)
		);
		
		
		Create table bkpAuxilio(
    
				idAuxilio int unsigned auto_increment primary key,
				tipoAuxilio varchar(40),
				valorAuxilio double,
				validadeInicial date,
				validadeFinal date,
				idInstituicaoFinanciadora int unsigned,
				idTecnicoAdmin int unsigned,
    			idProcesso int unsigned not null,
                idDiscente int unsigned not null,
				constraint fk_bkpAuxilio_IF foreign key(idInstituicaoFinanciadora) references bkpInstituicaoFinanciadora(idIF),
				constraint fk_bkpAuxilio_TecnicoAdmin foreign key(idTecnicoAdmin) references bkpTecnicoAdmin(idTecnicoAdmin),
    			constraint fk_bkpAuxilio_processo foreign key(idProcesso) references bkpProcesso(idProcesso),
                constraint fk_bkpAuxilio_Discente foreign key(idDiscente) references bkpDiscente(idDiscente)

		);
		Create table bkpEdital(
		
				idEdital int unsigned auto_increment primary key,
				iniInscricoes date,
				FimInscricoes date,
				iniEntregaForm date ,
				ano int,
				fimForm date,
				descricao varchar(255),
				titulo varchar(100),
				valorBolsaDiscente double,
				vagasBolsistas int,
				numEdital varchar(50),
				idProcesso int unsigned not null,
				constraint fk_bkpEdital_processo foreign key(idProcesso) references bkpProcesso(idProcesso) 
		
		);
		Create table bkpDadosBancarios(
		
				idDadosBancarios int unsigned auto_increment primary key,
				banco varchar(255),
				agencia varchar(255),
				numAgencia varchar(255),
                saldo double,
                idDiscente int unsigned not null,
                constraint fk_bkpDadosBancarios_Discente foreign key(idDiscente) references bkpDiscente(idDiscente)
		
		);
		Create table bkpPerfilSocioEconomico(
		    
		    
				idPerfilSocio int unsigned auto_increment primary key,
				situacaoRendaFamiliar varchar(255),
				moradia varchar(255),
				situacaoMoradia varchar(255),
				residenciaFamiliar varchar(255),
				situacaoTrabalho varchar(255),
				aluguel double,
				condominio double,
				luz double,
				agua double,
				telefone double,
				financiamentoCasaPropria double,
                idAssistenteSocial int unsigned not null,
                idDiscente int unsigned not null,
                constraint fk_bkpPerfilsocioeconomico_Assistentesocial foreign key(idAssistenteSocial) references bkpAssistenteSocial(idAssistenteSocial),
                constraint fk_bkpPerfilsocioeconomico_Discente foreign key(idDiscente) references bkpDiscente(idDiscente)
          
		);
		Create table bkpSituacaoSaude(
		    
		    idSituacaoSaude int unsigned auto_increment primary key,
			membro varchar(50),
			doenca varchar(50),
			idPerfilSocioEconomico int unsigned not null,
		    constraint fk_bkpSituacaoSaude_perfilSocio foreign key (idPerfilSocioEconomico) references bkpPerfilSocioEconomico(idPerfilSocio)
		);
		Create table bkpResidentesMoradia(
			    idRm int unsigned,
				residentes varchar(255),
				idPerfilSocio int unsigned not null,
			    constraint fk_bkpResidentesMoradia_perfilSocio foreign key(idPerfilSocio) references bkpPerfilSocioEconomico(idPerfilSocio)
			    
		);

		Create table bkpComposicaoRendaFamiliar( 
			idCrf int unsigned auto_increment primary key, 
			nome varchar(70), 
			idade int unsigned, 
			grauDeInstrucao int unsigned, 
			profissao varchar(70), 
			renda double,
			idPerfilSocio int unsigned not null, 
			constraint fk_bkpComposicaoRendaFamiliar_idPerfilSocio foreign key(idPerfilSocio) references bkpPerfilSocioEconomico(idPerfilSocio) 
		);
		
		Create table bkpDocumentacao (
			
			idDocumentacao int unsigned auto_increment primary key,
			nomeDocumentacao varchar(100),
			status_Documento varchar(255),
			obs varchar(255),
			iddiscente int unsigned not null,
			constraint fk_bkpDocumentacao_discente foreign key(idDiscente) references bkpDiscente(idDiscente)

		);
/*----------------------- INSERTS ---------------------------- BY:MATHEUS*/
		
		INSERT INTO pessoa (nomePessoa,rg,matricula)
VALUES ('Fanny Vieira Medeiros', 4179958, 121);

INSERT INTO pessoa (nomePessoa,rg,matricula)
VALUES ('Rayla Medeiros da Silva', 4279958, 122);

INSERT INTO pessoa (nomePessoa,rg,matricula)
VALUES ('Mateus Rhan Oliveira', 4379958, 123);

INSERT INTO telefone (idPessoa,telefoneCelular,telefoneResidencial)
VALUES (1,'9954684','33364859');

INSERT INTO telefone (idPessoa,telefoneCelular,telefoneResidencial)
VALUES (2,'9854684','32364859');

INSERT INTO telefone (idPessoa,telefoneCelular,telefoneResidencial)
VALUES (3,'9754684','31364859');

INSERT INTO servidor (idPessoa,cargoServidor)
VALUES (1,'Coordenador');

INSERT INTO servidor (idPessoa,cargoServidor)
VALUES (2,'Estagiario');

INSERT INTO servidor (idPessoa,cargoServidor)
VALUES (3,'SubCoordenador');

INSERT INTO assistenteSocial (idServidor)
VALUES (1);

INSERT INTO assistenteSocial (idServidor)
VALUES (2);

INSERT INTO assistenteSocial (idServidor)
VALUES (3);

INSERT INTO TecnicoAdmin (idServidor)
VALUES (1);

INSERT INTO TecnicoAdmin (idServidor)
VALUES (2);

INSERT INTO TecnicoAdmin (idServidor)
VALUES (3);


INSERT INTO instituicaoFinanciadora (nomeIF,cnpj,orcamentoAuxilio,idTecnicoAdmin)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,1);

INSERT INTO instituicaoFinanciadora (nomeIF,cnpj,orcamentoAuxilio,idTecnicoAdmin)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,2);

INSERT INTO instituicaoFinanciadora (nomeIF,cnpj,orcamentoAuxilio,idTecnicoAdmin)
VALUES ('Instituto Federal de Educação e Tecnologia','156985465782',199999,3);


INSERT INTO processo (dataRequisicao,numProcesso,assunto,idInteressado,idServidor)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',1,1);

INSERT INTO processo (dataRequisicao,numProcesso,assunto,idInteressado,idServidor)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',2,2);

INSERT INTO processo (dataRequisicao,numProcesso,assunto,idInteressado,idServidor)
VALUES (20/06/2015,'1569','Solicitação de Auxilio Alimentação',3,3);


INSERT INTO resultados (tipoauxilio,idProcesso)
VALUES ('Alimentação',1);

INSERT INTO resultados (tipoauxilio,idProcesso)
VALUES ('Alimentação',2);

INSERT INTO resultados (tipoauxilio,idProcesso)
VALUES ('Alimentação',3);

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Solteiro',16,'Informatica',1,1);

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado',16,'Informatica',2,2);

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado',16,'Informatica',3,2);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,1,1,1,1);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,2,2,2,2);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,3,3,3,3);
INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80, 1);

INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80, 2);

INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80, 3);

INSERT INTO dadosbancarios (banco ,agencia ,numAgencia ,idDiscente  )
VALUES ('caixa', '1009','1338',1);

INSERT INTO dadosbancarios (banco ,agencia ,numAgencia ,idDiscente  )
VALUES ('caixa', '1009','1338',2);

/*-------------------DELETS E DROPS --------------------- BY:RAYLA*/

Delete from documentacao where (idDocumentacao >=1 and idDocumentacao <= 3);
DELETE from ComposicaoRendaFamiliar where (idCrf >= 1 and idCrf <= 3);
DELETE from ResidentesMoradia where (idRm >= 1 and idRm <= 4);
DELETE from SituacaoSaude where (idSituacaoSaude and idSituacaoSaude <= 3);
DELETE from PerfilSocioEconomico where (idPerfilSocio >= 1 and idPerfilSocio <= 3);
DELETE from DadosBancarios where (idDadosBancarios >= 1 and idDadosBancarios <= 3);
DELETE from Edital where (idEdital >= 1 and idEdital <= 3);
DELETE from Auxilio where (idAuxilio>= 1 and idAuxilio <= 3);
DELETE from Discente where (idDiscente>=1 and idDiscente <= 3);
DELETE from Resultados where (idResultados >=1 and idResultados <= 3);
DELETE from Processo where (idProcesso>=1 and idProcesso <= 3);
DELETE from InstituicaoFinanciadora where (idIF>=1 and idIF <= 3);
DELETE from TecnicoAdmin where (idTecnicoAdmin>=1 and idTecnicoAdmin <= 3);
DELETE from AssistenteSocial where (idAssistenteSocial>=1 and idAssistenteSocial <= 3);
DELETE from Servidor where (idServidor >=1 and idServidor <= 3);
DELETE from Telefone where (idTelefone>=1 and idTelefone <= 3);
DELETE from Pessoa where (idPessoa >=1 and idPessoa <= 3);



DROP TABLE Documentacao;
DROP TABLE ComposicaoRendaFamiliar;
DROP TABLE ResidentesMoradia;
DROP TABLE SituacaoSaude;
DROP TABLE PerfilSocioEconomico;
DROP TABLE DadosBancarios;
DROP TABLE Edital;
DROP TABLE Auxilio;
DROP TABLE Discente;
DROP TABLE Resultados;
DROP TABLE Processo;
DROP TABLE InstituicaoFinanciadora;
DROP TABLE TecnicoAdmin;
DROP TABLE AssistenteSocial;
DROP TABLE Servidor;
DROP TABLE Telefone;
DROP TABLE Pessoa;


		