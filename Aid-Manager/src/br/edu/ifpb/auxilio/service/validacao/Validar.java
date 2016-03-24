package br.edu.ifpb.auxilio.service.validacao;
import java.util.Date;

import br.edu.ifpb.auxilio.entidade.*;


public class Validar {
	
	private static StringValidator stringValidator = new StringValidator();
	private static NumeroValidator numeroValidator = new NumeroValidator();
	private static EmailValidator emailValidator = new EmailValidator();
	private static DataValidator dataValidator = new DataValidator();

	public static int VALIDACAO_OK = 0;
	
	public static int login(String matricula,String senha) {
		boolean valido = false;
		
		// Matrícula(somente números),devem ser maiores que 1 e menors que 11.
				if (numeroValidator.validate(matricula,1,11))
					valido = true;
				if (!valido)
					return ErrorFactory.MATRICULA_USUARIO_INVALIDA;

				if (!stringValidator.validate(senha))
					return ErrorFactory.SENHA_USUARIO_INVALIDA;

				
				
		return VALIDACAO_OK;
		
	}
	
	public static int pessoa(Pessoa pessoa) {

		String nomePessoa = pessoa.getNomePessoa();
		String cpf = pessoa.getCpf();
		//Date nascimento = pessoa.getDataNasc();
		String matricula = pessoa.getMatricula();
		String email = pessoa.getEmail();
		String Rg = pessoa.getRg();
		String sexo = pessoa.getSexo();
		String senha = pessoa.getSenha();
		
		

		if (!stringValidator.validateSomenteLetras(nomePessoa))
			return ErrorFactory.NOME_USUARIO_INVALIDO;

		if (!CPFValidator.validaCnpj(cpf))
			return ErrorFactory.CPF_USUARIO_INVALID0;
		
		if(!stringValidator.validatePassword(senha))
			return ErrorFactory.SENHA_USUARIO_INVALIDA;

		if (!numeroValidator.validate(matricula,1,11))
			return ErrorFactory.MATRICULA_USUARIO_INVALIDA;

		if (!emailValidator.validate(email))
			return ErrorFactory.EMAIL_USUARIO_INVALIDO;
		
		/*if (!dataValidator.validate(value))
			return ErrorFactory.EMAIL_USUARIO_INVALIDO;*/

		if (!stringValidator.validateRg(Rg))
			//return CodeErroQManager.URL_LATTES_INVALIDO; 
		
		if (!stringValidator.validate(sexo,9))
			return ErrorFactory.SEXO_INVALID0;

		return VALIDACAO_OK;
	}
	
	public static int servidor(Servidor servidor) {

		int validacao = VALIDACAO_OK;
		
		String cargoServidor = servidor.getCargoServidor();

		validacao = pessoa(servidor);
		if (validacao != VALIDACAO_OK)
			return validacao;

		if (!stringValidator.validateSomenteLetras(cargoServidor))
			return ErrorFactory.NOME_USUARIO_INVALIDO;
		

		return VALIDACAO_OK;
	}
	
	public static int Discente(Discente discente) {

		int validacao = VALIDACAO_OK;
		
	    String escolaOrigem = discente.getEscolaOrigem();
		String orgExpeditor = discente.getOrgExpeditor();
		String numCartaoSus = discente.getNumCartaoSus();
		String estadoCivil = discente.getEstadoCivil();
		String curso = discente.getCurso();
		int periodoLetivo = discente.getPeriodoLetivo();
		String turno = discente.getTurno();
		String endereco = discente.getEndereco();
		String cep = discente.getCep();
		String bairro = discente.getBairro();
		String cidade = discente.getCidade();
		int numCasa = discente.getNumCasa();
		String pontoRef = discente.getPontoRef();
		String estado = discente.getEstado();
		String motivoSolicitacao = discente.getMotivoSolicitacao();

		validacao = pessoa(discente);
		if (validacao != VALIDACAO_OK)
			return validacao;

		if (!stringValidator.validateSomenteLetras(escolaOrigem))
			//return ErrorFactory.NOME_USUARIO_INVALIDO;
		//if (!stringValidator.validateLetraDigito(orgExpeditor))
		if (!numeroValidator.validate(numCartaoSus,1,15))
		if (!stringValidator.validateSomenteLetras(curso))
		if (!numeroValidator.isInteiroPositivo(numCasa))
		if (!stringValidator.validate(pontoRef))
	    if (!stringValidator.validateSomenteLetras(estado))
	    if (!stringValidator.validate(motivoSolicitacao))
		if (!stringValidator.validate(estadoCivil,1,12))
		if (!numeroValidator.isInteiroPositivo(periodoLetivo))
		if (!stringValidator.validateSomenteLetras(turno))
			if (endereco != null && cep != null && cidade != null && bairro != null) {
				if (!stringValidator.validate(endereco, 255))
					//return CodeErroQManager.ENDERECO_INVALIDO;

				if (!numeroValidator.validate(cep,1,8))
					//return CodeErroQManager.CEP_INVALIDO;

				if (!stringValidator.validateSomenteLetras(cidade))
					//return CodeErroQManager.TELEFONE_INVALIDO;
				if (!stringValidator.validate(bairro));
			}
		
		
		

		return VALIDACAO_OK;
	}
	
	public static int dadosBancarios(DadosBancarios dadosBancarios) {

		int validacao = VALIDACAO_OK;

		if (dadosBancarios != null) {

			Discente discente = dadosBancarios.getDiscente();
			String banco = dadosBancarios.getBanco();
			String numAgencia = dadosBancarios.getNumAgencia();
			String agencia = dadosBancarios.getAgencia();
			

			validacao = Discente(discente);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validateSomenteLetras(banco))
				//return CodeErroQManager.OPERACAO_CONTA_INVALIDA;

			if (!numeroValidator.validate(numAgencia, 6));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
			if (!stringValidator.validateSomenteLetras(agencia));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
		}

		return VALIDACAO_OK;
	}
	
	public static int documento(Documento documento) {

		int validacao = VALIDACAO_OK;

		if (documento != null) {

			Discente discente = documento.getDiscente();
			String nomeDocumento = documento.getNomeDocumento();
			String status = documento.getStatus();
			String obs = documento.getObs();

			validacao = Discente(discente);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validateSomenteLetras(nomeDocumento))
				//return CodeErroQManager.OPERACAO_CONTA_INVALIDA;
			if (!stringValidator.validate(status));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
			if (!stringValidator.validateSomenteLetras(obs));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
		}

		return VALIDACAO_OK;
	}
	
	public static int edital(Edital edital) {

		int validacao = VALIDACAO_OK;

		if (edital != null) {

			Date iniInscricoes = edital.getIniInscricoes();
			Date fimInscricoes = edital.getFimInscricoes();
			Date iniEntregaForm = edital.getIniEntregaForm();
			int ano = edital.getAno();
			Date fimForm = edital.getFimForm();
			String descricao = edital.getDescricao();
			String titulo = edital.getTitulo();
			double valorBolsaDiscente = edital.getValorBolsaDiscente();
			int vagasBolsistas = edital.getVagasBolsistas();
			String numEdital = edital.getNumEdital();

			validacao = processo(edital);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!dataValidator.datesInOrder(iniInscricoes, fimInscricoes))
				//return CodeErroQManager.OPERACAO_CONTA_INVALIDA;
			if (!dataValidator.datesInOrder(iniEntregaForm, fimForm));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
			if (!numeroValidator.isInteiroPositivo(ano));
				//return CodeErroQManager.NUMERO_CONTA_INVALIDO;
			if(!numeroValidator.isInteiroPositivo(vagasBolsistas));
			if(!numeroValidator.isDoublePositivo(valorBolsaDiscente));
			if(!stringValidator.validateSomenteLetras(titulo));
			if(!stringValidator.validate(descricao));
			if(!numeroValidator.validate(numEdital));
		}

		return VALIDACAO_OK;
	}
	
	public static int Familiar(Familiar familiar) {

		int validacao = VALIDACAO_OK;

		if (familiar != null) {

			String nome = familiar.getNome();
			int idade = familiar.getIdade();
			int grauDeInstrucao = familiar.getGrauDeInstrucao();
			String profissao = familiar.getProfissao();
			double renda = familiar.getRenda();
			String doenca = familiar.getDoenca();
			PerfilSocioEconomico ps = familiar.getPs();

			validacao = PerfilSocioEconomico(ps);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validateSomenteLetras(nome))
			if (!numeroValidator.isInteiroPositivo(idade))
			if (!numeroValidator.isInteiroPositivo(grauDeInstrucao));
			if (!stringValidator.validateSomenteLetras(profissao));
			if (!stringValidator.validateSomenteLetras(doenca));
			if (!numeroValidator.isDoublePositivo(renda));
		}

		return VALIDACAO_OK;
	}
	
	
	public static int InstituicaoFinanciadora(InstituicaoFinanciadora instf) {

		int validacao = VALIDACAO_OK;

		if (instf != null) {

			String nomeIF = instf.getNomeIF();
			String cnpj = instf.getCnpj();
			double orcamentoAuxilio = instf.getOrcamentoAuxilio();
			Servidor servidor = instf.getServidor(); 

			validacao = servidor(servidor);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validateSomenteLetras(nomeIF))
			if (!CNPJValidator.isCNPJ(cnpj))
			if (!numeroValidator.isDoublePositivo(orcamentoAuxilio));
		}

		return VALIDACAO_OK;
	}
    
	
	public static int PerfilSocioEconomico(PerfilSocioEconomico ps) {

		int validacao = VALIDACAO_OK;

		if (ps != null) {

			String situacaoRendaFamiliar = ps.getSituacaoRendaFamiliar();
			String moradia = ps.getMoradia();
			String situacaoMoradia = ps.getSituacaoMoradia();
			String residenciaFamiliar = ps.getResidenciaFamiliar();
			String situacaoTrabalho = ps.getSituacaoTrabalho();
			double aluguel = ps.getAluguel();
			double condominio = ps.getCondominio();
		    double luz = ps.getLuz();
			double agua = ps.getAgua();
			double telefone = ps.getTelefone();
			double financiamentoCasaPropria = ps.getFinanciamentoCasaPropria();
			String obs = ps.getObs();
			Servidor servidor = ps.getServidor();
			Discente discente = ps.getDiscente();

			validacao = servidor(servidor);
			if (validacao != VALIDACAO_OK)
				return validacao;
			
			validacao = Discente(discente);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validateSomenteLetras(situacaoRendaFamiliar))
			if (!stringValidator.validateSomenteLetras(moradia))
			if (!stringValidator.validateSomenteLetras(residenciaFamiliar));
			if (!stringValidator.validateSomenteLetras(situacaoMoradia));
		    if (!stringValidator.validateSomenteLetras(situacaoTrabalho));
		    if (!numeroValidator.isDoublePositivo(aluguel));
		    if (!numeroValidator.isDoublePositivo(condominio))
		    if (!numeroValidator.isDoublePositivo(luz))
		    if (!numeroValidator.isDoublePositivo(agua))
		    if (!numeroValidator.isDoublePositivo(telefone))
		    if (!numeroValidator.isDoublePositivo(financiamentoCasaPropria))
		    if (!stringValidator.validate(obs));
		    	
			
		}

		return VALIDACAO_OK;
	}
	
	public static int processo(Processo processo) {

		int validacao = VALIDACAO_OK;

		if (processo != null) {
			
           // Date dataRequisicao = processo.getDataRequisicao();
			String obs = processo.getObs();
			String numProcesso = processo.getNumProcesso();
			String assunto = processo.getParecer();
			String parecer = processo.getParecer();
			Pessoa interessado = processo.getInteressado();
			Servidor servidor = processo.getServidor();
		
			validacao = servidor(servidor);
			if (validacao != VALIDACAO_OK)
				return validacao;
			
			validacao = pessoa(interessado);
			if (validacao != VALIDACAO_OK)
				return validacao;

			if (!stringValidator.validate(obs))
			if (!numeroValidator.validate(numProcesso))
			if (!stringValidator.validate(assunto));
			if (!stringValidator.validateSomenteLetras(parecer));
			
		}

		return VALIDACAO_OK;
	}
	

}
