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
			idDiscente int unsigned not null,
			constraint fk_documentacao_discente foreign key(idDiscente) references discente(idDiscente)

		);
		