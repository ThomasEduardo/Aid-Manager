  CREATE DATABASE biblioteca;
  
  use biblioteca;

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
		idPessoa int unsigned,
		constraint fk_telefone_pessoa foreign key(idPessoa) references pessoa(idPessoa) 
	);
	
	Create table servidor(
		  idServidor int unsigned auto_increment primary key,
		  cargoServidor varchar(30),
		  idPessoa int unsigned,
		  constraint fk_servidor_pessoa foreign key(idPessoa) references pessoa(idPessoa)
	);
	
	
	Create table assistenteSocial(
    
		idAssistenteSocial int unsigned auto_increment primary key,
		idServidor int unsigned,
		constraint fk_assistenteSocial_Servidor foreign key(idServidor) references servidor(idServidor)
    
    );

	Create table TecnicoAdmin(
    
		idTecnicoAdmin int unsigned auto_increment primary key,
		idServidor int unsigned,
		constraint fk_tecnicoAdmin_Servidor foreign key(idServidor) references servidor(idServidor)
    );
	
	Create table instituicaoFinanciadora( 
		idIF int unsigned auto_increment primary key,
		nomeIF varchar(40), 
		cnpj varchar(40), 
		orcamentoAuxilio double, 
		idTecnicoAdmin int unsigned, 
		constraint fk_instituicaFinanciado_tecnicoAdmin foreign key(idTecnicoAdmin) references tecnicoAdmin(idTecnicoAdmin) 
	);
	Create table auxilio(
    
        idAuxilio int unsigned auto_increment primary key,
        tipoAuxilio varchar(40),
        valorAuxilio double,
        validadeInicial date,
        validadeFinal date,
        idInstituicaoFinanciadora int unsigned,
        idTecnicoAdmin int unsigned,
        constraint fk_auxilio_IF foreign key(idInstituicaoFinanciadora) references instituicaoFinanciadora(idIF),
        constraint fk_auxilio_TecnicoAdmin foreign key(idTecnicoAdmin) references tecnicoAdmin(idTecnicoAdmin)

    );
	
	 Create table processo(
     
        idProcesso int unsigned auto_increment primary key,
        dataRequisicao date,
        obs varchar(255),
        numProcesso varchar(50),
        assunto varchar(255),
        parecer varchar(255),
        idInteressado int unsigned,
        idServidor int unsigned,
        constraint fk_processo_interessado foreign key(idInteressado) references pessoa(idPessoa),
        constraint fk_processo_servidor foreign key(idServidor) references servidor(idServidor)
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
		idProcesso int unsigned,
		constraint fk_edital_processo foreign key(idProcesso) references processo(idProcesso) 
		
	);
	
		Create table dadosBancarios(
		
		idDadosBancarios int unsigned,
		banco varchar(255),
		agencia varchar(255),
		numAgencia varchar(255)
		
		);
	