Create database aidManager;
use aidManager;

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
	tipoServidor varchar(200),
	idPessoa int unsigned not null,
	constraint fk_servidor_pessoa foreign key(idPessoa) references pessoa(idPessoa)
);


Create table instituicaoFinanciadora( 
	idIF int unsigned auto_increment primary key,
	nomeIF varchar(40), 
	cnpj varchar(40), 
	orcamentoAuxilio double, 
	idServidor int unsigned not null, 
	constraint fk_instituicaFinanciadora_servidor foreign key(idServidor) references servidor(idServidor)
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
	constraint fk_discente_pessoa foreign key (idPessoa) references pessoa(idPessoa)
);

Create table auxilio(
	idAuxilio int unsigned auto_increment primary key,
	tipoAuxilio varchar(40),
	valorAuxilio double,
	validadeInicial date,
	validadeFinal date,
	idInstituicaoFinanciadora int unsigned,
	idProcesso int unsigned not null,
	constraint fk_auxilio_IF foreign key(idInstituicaoFinanciadora) references instituicaoFinanciadora(idIF),
	constraint fk_auxilio_processo foreign key(idProcesso) references processo(idProcesso)
);

Create table edital(
	idEdital int unsigned auto_increment primary key,
	iniInscricoes date,
	fimInscricoes date,
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
    obs varchar(255),
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
	obs varchar(255),
	financiamentoCasaPropria double,
    idServidor int unsigned not null,
    idDiscente int unsigned not null,
    constraint fk_perfilsocioeconomico_servidor foreign key(idServidor) references servidor(idServidor),
    constraint fk_perfilsocioeconomico_Discente foreign key(idDiscente) references discente(idDiscente)
 );


Create table Familiar( 
	idFamiliar int unsigned auto_increment primary key, 
	nome varchar(70), 
	idade int unsigned, 
	grauDeInstrucao int unsigned, 
	profissao varchar(70), 
	renda double,
	doenca varchar(255),
	idPerfilSocio int unsigned not null, 
	constraint fk_composicaoRendaFamiliar_idPerfilSocio foreign key(idPerfilSocio) references perfilSocioEconomico(idPerfilSocio) 
);
		
Create table documento (
	idDocumentacao int unsigned auto_increment primary key,
	nomeDocumento varchar(100),
	status varchar(255),
	obs varchar(255),
	idDiscente int unsigned not null,
	constraint fk_documentacao_discente foreign key(idDiscente) references discente(idDiscente)
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
Create table bkpResultados ( 
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
INSERT INTO pessoa (nomePessoa,rg,matricula,`dataNasc`, `sexo`, `senha`, `email`, `cpf`)
VALUES ('Fanny Vieira Medeiros', 4179958, 121,'2000-08-10','feminino','123','fannyvieira@gmail.com','701.199.264-23');

INSERT INTO pessoa (nomePessoa,rg,matricula,`dataNasc`, `sexo`, `senha`, `email`, `cpf`)
VALUES ('Rayla Medeiros da Silva', 4279958, 122,'1999-08-17','feminino','123','raylamedeiiros@gmail.com','123.456.234-45');

INSERT INTO pessoa (nomePessoa,rg,matricula,`dataNasc`, `sexo`, `senha`, `email`, `cpf`)
VALUES ('Mateus Rhan Oliveira', 4379958, 123,'1999-06-25','Masculino','123','mateus.oliveira@gmail.com','345.678.990-67');


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

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,`periodoLetivo`, `turno`, `endereco`, `cep`, `bairro`, `cidade`, `numCasa`, `pontoRef`, `estado`, `motivoSolicitacao`,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Solteiro',16,'Informatica',3,'Integral','Rua:Josefa Trindade','58119-000','Centro','Lagoa de roça',48,'Escola virgem das graças','PB','Estava precisando',1,1);

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,`periodoLetivo`, `turno`, `endereco`, `cep`, `bairro`, `cidade`, `numCasa`, `pontoRef`, `estado`, `motivoSolicitacao`,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado',16,'Informatica',3,'Integral','Rua:Aberlino ferreira','123456-000','Centro','Esperança',24,'Catedral','PB','Estava precisando',2,2);

INSERT INTO Discente (escolaOrigem,numCartaoSus,estadoCivil,idade,curso,`periodoLetivo`, `turno`, `endereco`, `cep`, `bairro`, `cidade`, `numCasa`, `pontoRef`, `estado`, `motivoSolicitacao`,idPessoa,idResultados)
VALUES ('Dom Manoel Palmeira da Rocha','1256945','Casado',16,'Informatica','Integral',3,'Rua:Aderlado MAICATU','122346-111','Centro','Esperança',25,'Catedral','PB','Estava precisando',3,2);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,1,1,1,1);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,2,2,2,2);

INSERT INTO auxilio (valorAuxilio ,validadeInicial ,validadeFinal ,idInstituicaoFinanciadora ,idTecnicoAdmin,idProcesso,idDiscente)
VALUES (80.00,14/02/2015,14/02/2016,3,3,3,3);
INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,`iniEntregaForm`, `fimForm`, `descricao`,`valorBolsaDiscente`,  `numEdital`,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios',80,'1999-07-10','2000-08-10','uie',80,'123.107.341', 1);

INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,`iniEntregaForm`, `fimForm`, `descricao`,`valorBolsaDiscente`,  `numEdital`,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios',80,'2000-08-10','2000-09-10',' ',80,'999.807.901',2);


INSERT INTO edital (iniInscricoes,FimInscricoes ,ano ,titulo ,vagasBolsistas,iniEntregaForm, `fimForm`, `descricao`,`valorBolsaDiscente`,  `numEdital`,idProcesso  )
VALUES (14/02/2015,21/02/2015,2015, 'Edital de  auxilios', 80,'1999-04-10','2000-05-10','é',80,'111.123.111', 3);

INSERT INTO dadosbancarios (banco ,agencia ,numAgencia ,idDiscente  )
VALUES ('caixa', '1009','1338',1);

INSERT INTO dadosbancarios (banco ,agencia ,numAgencia ,idDiscente  )
VALUES ('caixa', '1009','1338',2);


INSERT INTO dadosbancarios (banco ,agencia ,numAgencia ,idDiscente  )
VALUES ('caixa', '1009','1338',3);


INSERT INTO perfilsocioeconomico (luz ,agua,telefone ,idAssistenteSocial ,idDiscente,`situacaoRendaFamiliar`, `moradia`, `residenciaFamiliar`, `situacaoTrabalho`, `aluguel`, `condominio`, 
 `financiamentoCasaPropria`,situacaoMoradia)
VALUES (58.45,25.85,52.50,2,2,'Dependente','Sozinho','Própria quitada','Trabalho com vínculo empregatício',0,0,0,'Casa Propia');

INSERT INTO perfilsocioeconomico (luz ,agua,telefone ,idAssistenteSocial ,idDiscente,`situacaoRendaFamiliar`, `moradia`, `residenciaFamiliar`, `situacaoTrabalho`, `aluguel`, `condominio`, 
 `financiamentoCasaPropria`,situacaoMoradia )
VALUES (58.45,25.85,52.50,3,3,'Dependente','Sozinho','Arrimo da família','Trabalho com vínculo empregatício',0,0,0,'Casa Propia');

INSERT INTO perfilsocioeconomico (situacaoMoradia,luz,agua,telefone,idAssistenteSocial,idDiscente,`situacaoRendaFamiliar`, `moradia`, `residenciaFamiliar`, `situacaoTrabalho`, `aluguel`, `condominio`, 
 `financiamentoCasaPropria`)
VALUES ('Casa Propria',58.50,25.45,50.40,1,1,'arrimo da familia','Sozinho','Própria quitada','Trabalho com vínculo empregatício',0,0,0);
 
INSERT INTO situacaoSaude (membro ,doenca ,idPerfilSocioEconomico )
VALUES ('nenhum', 'nenhuma', 1);

INSERT INTO situacaoSaude (membro ,doenca ,idPerfilSocioEconomico )
VALUES ('nenhum', 'nenhuma', 2);

INSERT INTO situacaoSaude (membro ,doenca ,idPerfilSocioEconomico )
VALUES ('nenhum', 'nenhuma', 3);


INSERT INTO residentesMoradia (idRm ,residentes ,idPerfilSocio )
VALUES (2,'5',1);

INSERT INTO residentesMoradia (idRm ,residentes ,idPerfilSocio )
VALUES (3,'5',2);

INSERT INTO residentesMoradia (idRm ,residentes ,idPerfilSocio )
VALUES (4,'5',3);

INSERT INTO composicaoRendaFamiliar (nome ,idade,grauDeInstrucao ,idPerfilSocio ,profissao , renda)
VALUES ('Joao Francisco', 48,'Ensino Fundamental',1,'agricutor',588.50);

INSERT INTO composicaoRendaFamiliar (nome ,idade,grauDeInstrucao ,idPerfilSocio ,profissao , renda)
VALUES ('Joao Francisco', 48,'Ensino Fundamental',2,'agricutor',588.50);

INSERT INTO composicaoRendaFamiliar (nome ,idade,grauDeInstrucao ,idPerfilSocio ,profissao , renda)
VALUES ('Joao Francisco', 48,'Ensino Fundamental',3,'agricutor',588.50);


INSERT INTO documentacao (nomeDocumentacao ,status_Documento ,idDiscente )
VALUES ('RG, CPF, Registro', 'Ok',1);

INSERT INTO documentacao (nomeDocumentacao ,status_Documento ,idDiscente )
VALUES ('RG, CPF, Registro', 'Ok',2);

INSERT INTO documentacao (nomeDocumentacao ,status_Documento ,idDiscente )
VALUES ('RG, CPF, Registro', 'Ok',3);


DELETE from Documentacao where idDocumentacao <=3;
DELETE from ComposicaoRendaFamiliar where idCrf <= 3;
DELETE from ResidentesMoradia where idRm <= 4;
DELETE from SituacaoSaude where idSituacaoSaude <= 3;
DELETE from PerfilSocioEconomico where idPerfilSocio <= 3;
DELETE from DadosBancarios where idDadosBancarios <= 3;
DELETE from Edital where idEdital <= 3;
DELETE from Auxilio where idAuxilio <= 3;
DELETE from Discente where idDiscente <= 3;
DELETE from Resultados where idResultados <= 3;
DELETE from Processo where idProcesso <= 3;
DELETE from InstituicaoFinanciadora where idIF <= 3;
DELETE from TecnicoAdmin where idTecnicoAdmin <= 3;
DELETE from AssistenteSocial where idAssistenteSocial <= 3;
DELETE from Servidor where idServidor <= 3;
DELETE from Telefone where idTelefone <= 3;
DELETE from Pessoa where idPessoa <= 3;




/*--------------- INSERTS ---------------------------*/
Delimiter $$
Create trigger tr_insertDb before insert
on dadosBancarios 
for each row
begin
    select idDAdosBancarios into @id from dadosBancarios where (banco = new.banco and agencia = new.agencia and numAgencia = new.numAgencia and saldo = new.saldo);
    if (@id != 0) then
       set new.idDadosBancarios = @id;
    end if;
end $$
delimiter ;



delimiter $$
Create trigger tr_insertAssistente before insert
on assistenteSocial
for each row
begin 
	select idAssistenteSocial into @id from assistenteSocial where idServidor=new.idServidor;
    if(@id != 0) then
     set new.idAssistenteSocial = @id;
    end if;
    
end $$
delimiter ;

delimiter $$
Create trigger tr_insertAuxilio before insert
on auxilio
for each row
begin 
	select idAuxilio into @id from auxilio where (tipoAuxilio = new.tipoAuxilio and valorAuxilio = new.valorAuxilio and validadeInicial = new.validadeInicial and validadeFinal = new.validadeFinal and idInstituicaoFinanciadora = new.idInstituicaoFinanciadora and idTecnicoAdmin = new.idTecnicoAdmin and idProcesso = new.idProcesso and idDiscente = new.idDiscente);
    if(@id != 0) then
     set new.idAuxilio = @id;
    end if;
    
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertCrf before insert
on composicaoRendaFamiliar
for each row
begin
	Select idCrf into @id from composicaoRendaFamiliar where(nome = new.nome and idade = new.idade and
                                                             grauDeInstrucao = new.grauDeInstrucao and 
                                                             profissao = new.profissao and 
                                                             renda = new.renda and 
															 idPerfilSocio = new.idPerfilSocio);
    if (@id != 0) then
       set new.idCrf = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertDiscente before insert
on discente
for each row
begin
	Select idDiscente into @id from Discente where(escolaOrigem = new.escolaOrigem and
                                                   orgExpeditor = new.orgExpeditor and
                                                   numCartaoSUS = new.numCartaoSUS and 
                                                   estadoCivil = new.estadoCivil and
                                                   idade = new.idade and 
                                                   curso = new.curso and 
                                                   periodoLetivo = new.periodoLetivo and 
                                                   turno = new.turno and 
                                                   endereco = new.endereco and 
                                                   cep = new.cep and
                                                   bairro = new.bairro and
                                                   cidade = new.cidade and 
                                                   numCasa = new.numCasa and 
                                                   pontoRef = new.pontoRef and
                                                   estado = new.Estado and
                                                   motivoSolicitacao = new.motivoSolicitacao and
                                                   idPessoa = new.idPessoa and 
                                                   idResultados = new.idResultados);
    if (@id != 0) then
       set new.idDiscente = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertDocumentacao before insert
on documentacao
for each row
begin
	Select idDocumentacao into @id from Documentacao where(nomeDocumentacao = new.nomeDocumentacao and
                                                   status_Documento = new.status_Documento and
                                                   obs = new.obs and 
                                                   idDiscente = new.idDiscente);
    if (@id != 0) then
       set new.idDocumentacao = @id;
    end if;
end $$
delimiter ;


Delimiter $$
Create trigger tr_insertEdital before insert
on edital
for each row
begin
	Select idEdital into @id from edital where(	   iniInscricoes = new.iniInscricoes and
                                                   fimInscricoes = new.fimInscricoes and
                                                   iniEntregaForm = new.iniEntregaForm and 
                                                   ano = new.ano and
                                                   fimForm = new.fimForm and 
                                                   descricao = new.descricao and 
                                                   titulo = new.titulo and 
                                                   valorBolsaDiscente = new.valorBolsaDiscente and 
                                                   vagasBolsistas = new.vagasBolsistas and
                                                   numEdital = new.numEdital and
                                                   idProcesso = new.idProcesso);
    if (@id != 0) then
       set new.idEdital = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertIF before insert
on instituicaoFinanciadora
for each row
begin
	Select idIF into @id from instituicaoFinanciadora where(
                                                           nomeIF = new.nomeIF and
                                                           cnpj = new.cnpj and
                                                           orcamentoAuxilio = new.orcamentoAuxilio and
                                                           idTecnicoAdmin = new.idTecnicoAdmin);
    if (@id != 0) then
       set new.idIF = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertPs before insert
on perfilSocioEconomico
for each row
begin
	Select idPerfilSocio into @id from perfilSocioEconomico where(
														   situacaoRendaFamiliar= new.situacaoRendaFamiliar and
                                                           moradia = new.moradia and
                                                           situacaoMoradia = new.situacaoMoradia and
                                                           residenciaFamiliar = new.residenciaFamiliar and
                                                           situacaoTrabalho = new.situacaoTrabalho and
                                                           aluguel = new.aluguel and
                                                           condominio = new.condominio and
                                                           luz = new.luz and
                                                           agua = new.agua and
                                                           telefone = new.telefone and
                                                           financiamentoCasaPropria = new.FinanciamentoCasaPropria 
                                                           and idAssistenteSocial = new.idAssistenteSocial and
                                                           idDiscente = new.idDiscente);
    if (@id != 0) then
       set new.idPerfilSocio = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertPessoa before insert
on pessoa
for each row
begin
	Select idPessoa into @id from pessoa where( nomePessoa = new.nomePessoa and
                                                                      rg = new.rg and
                                                                      matricula = new.Matricula and
                                                                      dataNasc = new.dataNasc and
                                                                      sexo = new.sexo and
                                                                      senha = new.senha and
                                                                      email = new.email and
                                                                      cpf = new.cpf);
    if (@id != 0) then
       set new.idPessoa = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertRm before insert
on residentesMoradia
for each row
begin
	Select idRm into @id from residentesMoradia where(            residentes = new.residentes and
                                                                      idPerfilSocio = new.idPerfilSocio);
    if (@id != 0) then
       set new.idRm = @id;
    end if;
end $$

delimiter ;

Delimiter $$
Create trigger tr_insertResultados before insert
on resultados
for each row
begin
	Select idResultados into @id from resultados where( 
                                                                      tipoAuxilio = new.tipoAuxilio and
                                                                      idProcesso = new.idProcesso);
    if (@id != 0) then
       set new.idResultados = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertServidor before insert
on servidor
for each row
begin
	Select idServidor into @id from servidor where(        cargoServidor = new.cargoServidor and
                                                           idPessoa = new.idPessoa);
    if (@id != 0) then
       set new.idServidor = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertSituacaoSaude before insert
on situacaoSaude
for each row
begin
	Select idSituacaoSaude into @id from situacaoSaude where(        membro = new.membro and
                                                                     doenca = new.doenca and
                                                                     idPerfilSocioEconomico = new.idPerfilSocioEconomico);
    if (@id != 0) then
       set new.idSituacaoSaude = @id;
    end if;
end $$
delimiter ;

Delimiter $$
Create trigger tr_insertTecnicoAdmin before insert
on tecnicoAdmin
for each row
begin
	Select idTecnicoAdmin into @id from tecnicoAdmin where(idServidor = new.idServidor );
    if (@id != 0) then
       set new.idTecnicoAdmin = @id;
    end if;
end $$
delimiter ;



Delimiter $$
Create trigger tr_insertTelefone before insert
on telefone
for each row
begin
	Select idTelefone into @id from telefone where(telefoneResidencial = new.telefoneResidencial and
                                                  telefoneCelular = new.telefoneCelular and
                                                  idPessoa = new.idPessoa);
    if (@id != 0) then
       set new.idTelefone = @id;
    end if;
end $$
delimiter ;

delimiter $$
Create trigger tr_insertProcesso before insert
on processo
for each row
begin
 
 	Select idProcesso into @id from processo where( dataRequisicao = new.dataRequisicao and
                                                    obs = new.obs and
                                                    numProcesso = new.numProcesso and
                                                    assunto = new.assunto and
                                                    parecer = new.parecer and
                                                    idInteressado = new.idInteressado and
        											idServidor = new.idServidor);
    if (@id != 0) then
       set new.idProcesso = @id;
    end if;

end $$
delimiter ;

/*-------------------delets-----------------------------*/

delimiter $$
Create trigger tr_DeleteDiscente before delete
on discente
for each row
begin
    insert into bkpDiscente (idDiscente,`escolaOrigem`, `orgExpeditor`, `numCartaoSus`, `estadoCivil`, `idade`, `curso`, `periodoLetivo`, `turno`, `endereco`, `cep`, `bairro`,`cidade`,`numCasa`, `pontoRef`,`estado`, `motivoSolicitacao`,`idPessoa`, `idResultados`) VALUES (old.idDiscente,old.`escolaOrigem`, old.`orgExpeditor`, old.`numCartaoSus`,old.`estadoCivil`, old.`idade`, old.`curso`, old.`periodoLetivo`, old.`turno`, old.`endereco`, old.`cep`, old.`bairro`, old.`cidade`, old.`numCasa`, old.`pontoRef`, old.`estado`, old.`motivoSolicitacao`, old.`idPessoa`, old.`idResultados`);
	delete from auxilio where idDiscente = old.idDiscente;
    delete from dadosBancarios where idDiscente = old.idDiscente;
    delete from documentacao where idDiscente = old.idDiscente;
    delete from perfilSocioEconomico where idDiscente = old.idDiscente;
    
END $$
delimiter ;




delimiter $$
Create trigger tr_DeletePerfilSocioEconomico before delete
on perfilSocioEconomico
for each row
begin
    INSERT INTO `bkpperfilsocioeconomico`(idPerfilSocio,`situacaoRendaFamiliar`, `moradia`, `situacaoMoradia`, `residenciaFamiliar`, `situacaoTrabalho`, `aluguel`,           `condominio`, `luz`, `agua`, `telefone`, `financiamentoCasaPropria`, `idAssistenteSocial`, `idDiscente`) VALUES (old.idPerfilSocio,old.`situacaoRendaFamiliar`, old.`moradia`,                  old.`situacaoMoradia`, old.`residenciaFamiliar`, old.`situacaoTrabalho`, old.`aluguel`,old.`condominio`, old.`luz`, old.`agua`, old.`telefone`,                              old.`financiamentoCasaPropria`,old.`idAssistenteSocial`,old.`idDiscente`);
	delete from composicaoRendaFamiliar where idPerfilSocio = old.idPerfilSocio;
    delete from residentesMoradia where idPerfilSocio = old.idPerfilSocio;
    delete from situacaoSaude where idPerfilSocioEconomico = old.idPerfilSocio;
    
    

END $$

delimiter ;


delimiter $$
Create trigger tr_DeleteResultados before delete
on resultados
for each row
begin
    INSERT INTO `bkpresultados`(idResultados,`tipoauxilio`, `idProcesso`) VALUES (old.idResultados,old.tipoAuxilio,old.idProcesso);
	delete from discente where idResultados = old.idResultados;
   
    
END $$
delimiter ;

delimiter $$
Create trigger tr_DeletePessoa before delete
on pessoa
for each row
begin
    INSERT INTO `bkppessoa`(idPessoa,`nomePessoa`, `rg`, `matricula`, `dataNasc`, `sexo`, `senha`, `email`, `cpf`) VALUES (old.idPessoa,old.nomePessoa,old.rg,
    old.matricula,old.dataNasc,old.sexo,old.senha,old.email,old.cpf);
	delete from telefone where idPessoa = old.idPessoa;
    delete from servidor where idPessoa = old.idPessoa;
    delete from discente where idPessoa = old.idPessoa;
    delete from Processo where idInteressado = old.idPessoa;
    
    

END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteIF before delete
on instituicaofinanciadora
for each row
begin
    INSERT INTO `bkpinstituicaofinanciadora`(idIF,`nomeIF`, `cnpj`, `orcamentoAuxilio`, `idTecnicoAdmin`) VALUES (old.idIF,old.`nomeIF`, old.`cnpj`, old.`orcamentoAuxilio`,                     old.`idTecnicoAdmin`);
	delete from auxilio where idinstituicaoFinanciadora = old.idIF;
    
  
END $$
delimiter ;


delimiter $$
Create trigger tr_DeleteServidor before delete
on servidor
for each row
begin
    INSERT INTO `bkpservidor`(idServidor,`cargoServidor`, `idPessoa`) VALUES (old.idServidor,old.cargoServidor,old.idPessoa);
	delete from assistenteSocial where idServidor = old.idServidor;
    delete from tecnicoAdmin where idServidor = old.idServidor;
    delete from processo where idServidor = old.idServidor;
  
    
END $$
delimiter ;


delimiter $$
Create trigger tr_DeleteTecnicoAdmin before delete
on tecnicoAdmin
for each row
begin
    INSERT INTO `bkptecnicoadmin`(idtecnicoAdmin,`idServidor`) VALUES (old.idtecnicoAdmin,old.idServidor);
	delete from auxilio where idtecnicoAdmin = old.idTecnicoAdmin;
    delete from instituicaoFinanciadora where idTecnicoAdmin = old.idTecnicoAdmin;
    
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteProcesso before delete
on processo
for each row
begin
     INSERT INTO `bkpprocesso`(idProcesso,`dataRequisicao`, `obs`, `numProcesso`, `assunto`, `parecer`, `idInteressado`, `idServidor`) VALUES (old.idProcesso,old.DataRequisicao,old.obs,old.`numProcesso`, old.`assunto`, old.`parecer`, old.`idInteressado`, old.`idServidor`);
	delete from auxilio where idProcesso = old.idProcesso;
    delete from edital where idProcesso = old.idProcesso;
    delete from resultados where idProcesso = old.idProcesso;
   
    
    
end $$
delimiter ;


delimiter $$
Create trigger tr_DeleteAssistenteSocial before delete
on assistenteSocial
for each row
begin
    INSERT INTO `bkpassistentesocial`(idAssistenteSocial,`idServidor`) VALUES (old.idAssistenteSocial,old.idServidor);
	delete from perfilSocioEconomico where idAssistenteSocial = old.idAssistenteSocial;
    

END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteCrf before delete
on composicaoRendaFamiliar
for each row
begin
    INSERT INTO `bkpcomposicaorendafamiliar`(idCrf,`nome`, `idade`, `grauDeInstrucao`, `profissao`, `renda`,             `idPerfilSocio`) VALUES (old.idCrf,old.`nome`,old.`idade`,old.`grauDeInstrucao`,old.`profissao`,old.`renda`,old.`idPerfilSocio`);
    
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteDadosBancarios before delete
on dadosBancarios
for each row
begin
   INSERT INTO `bkpdadosbancarios`(idDAdosBancarios,`banco`, `agencia`, `numAgencia`, `saldo`, `idDiscente`) VALUES (OLD.idDAdosBancarios,old.`banco`, old.`agencia`, old.`numAgencia`, old.`saldo`, old.`idDiscente`);
    
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteDocumentacao before delete
on documentacao
for each row
begin
 INSERT INTO `bkpdocumentacao`(idDocumentacao,`nomeDocumentacao`, `status_Documento`, `obs`, `iddiscente`) VALUES (old.idDocumentacao,old.`nomeDocumentacao`, old.`status_Documento`, old.`obs`, old.`iddiscente`);
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteEdital before delete
on edital
for each row
begin
 		INSERT INTO `bkpedital`(idEdital,`iniInscricoes`, `FimInscricoes`, `iniEntregaForm`, `ano`, `fimForm`, `descricao`, `titulo`, `valorBolsaDiscente`, `vagasBolsistas`, `numEdital`, `idProcesso`) VALUES ( old.idEdital,old.`iniInscricoes`,old.`FimInscricoes`, old.`iniEntregaForm`, old.`ano`, old.`fimForm`, old.`descricao`, old.`titulo`, old.`valorBolsaDiscente`, old.`vagasBolsistas`, old.`numEdital`, old.`idProcesso`);
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteResidentesMoradia before delete
on residentesMoradia
for each row
begin
    INSERT INTO `bkpresidentesmoradia`(idRm,`residentes`, `idPerfilSocio`) VALUES (old.idRm,old.`residentes`,old.`idPerfilSocio`);
	
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteSituacaoSaude before delete
on situacaoSaude
for each row
begin
    INSERT INTO `bkpsituacaosaude`(idSituacaoSaude,`membro`, `doenca`, `idPerfilSocioEconomico`) VALUES (old.idSituacaoSaude,old.membro,old.doenca,old.idPerfilSocioEconomico);
	
END $$
delimiter ;

delimiter $$
Create trigger tr_DeleteTelefone before delete
on telefone
for each row
begin
    INSERT INTO `bkptelefone`(idTelefone,`telefoneResidencial`, `telefoneCelular`, `idPessoa`) VALUES (old.idTelefone,old.`telefoneResidencial`, old.`telefoneCelular`, old.`idPessoa`);
	
END $$
delimiter ;


/*------------------------------------------UPDATES -------------------------------*/

delimiter $$
Create trigger tr_updateSaldo before update 
on dadosBancarios
for each row
begin

	Select idInstituicaoFinanciadora into @id from auxilio 
    where idDiscente = old.idDiscente;
	update instituicaoFinanciadora 
    set orcamentoAuxilio = orcamentoAuxilio - new.saldo 
    where idIF = @id;

end $$
DELIMITER ;

delimiter $$
Create trigger tr_updateProcesso before update
on processo 
for each row
begin 
	
    if (new.parecer = 'Aprovado') then
    select idDiscente, escolaOrigem,orgExpeditor,numCartaoSus,estadoCivil,idade,curso,periodoLetivo,turno,
    endereco, cep , bairro , cidade , numCasa , pontoRef , estado , motivoSolicitacao , idPessoa, idResultados 
    into @id,@escolaOrigem,@orgExpeditor,@numCartaoSus,@estadoCivil,@idade,@curso,@periodoLetivo,@turno,
    @endereco, @cep , @bairro , @cidade , @numCasa , @pontoRef , @estado , @motivoSolicitacao ,
    @idPessoa,@idResultados from discentePre where idPessoa = new.idInteressado;
	
	
	
    INSERT INTO `discente`(`idDiscente`, `escolaOrigem`, `orgExpeditor`, `numCartaoSus`, `estadoCivil`, `idade`,         `curso`, `periodoLetivo`, `turno`, `endereco`, `cep`,`bairro`, `cidade`, `numCasa`, `pontoRef`, `estado`,           `motivoSolicitacao`, `idPessoa`, `idResultados`) 
    VALUES ( @escolaOrigem,@orgExpeditor,@numCartaoSus,@estadoCivil,@idade,@curso,@periodoLetivo,@turno,
    @endereco, @cep , @bairro , @cidade , @numCasa , @pontoRef , @estado , @motivoSolicitacao ,
    @idPessoa,@idResultados);
    delete from discentePre where idDiscentePre = @id;
    end if;
end $$
delimiter ;

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


delimiter $$
create trigger tr_updateIF before update
on instituicaoFinanciadora
for each row
begin
    if(new.orcamentoAuxilio < 0 or length(new.cnpj) != 14) then
        set new.idIf = null;
    end if;
    
end $$
delimiter ;

delimiter $$
create trigger tr_updatePerfilSocioEconomico before update
on perfilSocioEconomico
for each row
begin
    if(new.aluguel < 0 or new.condominio <0 or new.luz <0 or new.agua < 0 or new.telefone < 0 or new.financiamentoCasaPropria < 0) then
        set new.idPerfilSocio = null;
    end if;
    
end $$
delimiter ;

delimiter $$
create trigger tr_updatePessoa before update
on pessoa
for each row
begin
    if(length(new.rg)!= 9  or length(new.cpf) != 14 or locate('@',new.email) != 0) then
        set new.idPessoa = null;
    end if;
    
end $$
delimiter ;

delimiter $$
create trigger tr_updateResultados before update
on resultados
for each row
begin
    if(tipoAuxilio != 'Moradia' or tipoAuxilio != 'Alimentacao' or tipoAuxilio != 'Transporte') then
        set new.idResultados = null;
    end if;
    
end $$
delimiter ;

delimiter $$
create trigger tr_updateDiscente before update
on discente
for each row
begin
    if(length(numCartaoSus) != 15 or periodoLetivo < 0 or length(cep) != 9 or numCasa < 0) then
        set new.idDiscente = null;
    end if;
    
end $$
delimiter ;


DROP TABLE Documentacao;
DROP TABLE ComposicaoRendaFamiliar;
DROP TABLE ResidentesMoradia;
DROP TABLE SituacaoSaude;
DROP TABLE PerfilSocioEconomico;
DROP TABLE DadosBancarios;
DROP TABLE Edital;
DROP TABLE Auxilio;
DROP TABLE DiscentePre;
DROP TABLE Discente;
DROP TABLE Resultados;
DROP TABLE Processo;
DROP TABLE InstituicaoFinanciadora;
DROP TABLE TecnicoAdmin;
DROP TABLE AssistenteSocial;
DROP TABLE Servidor;
DROP TABLE Telefone;
DROP TABLE Pessoa;
DROP TABLE bkpDocumentacao;
DROP TABLE bkpComposicaoRendaFamiliar;
DROP TABLE bkpResidentesMoradia;
DROP TABLE bkpSituacaoSaude;
DROP TABLE bkpPerfilSocioEconomico;
DROP TABLE bkpDadosBancarios;
DROP TABLE bkpEdital;
DROP TABLE bkpAuxilio;
DROP TABLE bkpDiscente;
DROP TABLE bkpResultados;
DROP TABLE bkpProcesso;
DROP TABLE bkpInstituicaoFinanciadora;
DROP TABLE bkpTecnicoAdmin;
DROP TABLE bkpAssistenteSocial;
DROP TABLE bkpServidor;
DROP TABLE bkpTelefone;
DROP TABLE bkpPessoa;
