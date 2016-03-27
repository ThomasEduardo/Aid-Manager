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

		/*if (!CPFValidator.validaCnpj(cpf))
			return ErrorFactory.CPF_USUARIO_INVALID0;*/
		
		if(!stringValidator.validatePassword(senha))
			return ErrorFactory.SENHA_USUARIO_INVALIDA;

		if (!numeroValidator.validate(matricula))
			return ErrorFactory.MATRICULA_USUARIO_INVALIDA;

		if (!emailValidator.validate(email))
			return ErrorFactory.EMAIL_USUARIO_INVALIDO;
		
		/*if (!dataValidator.validate(value))
			return ErrorFactory.EMAIL_USUARIO_INVALIDO;*/

		if (!stringValidator.validateRg(Rg))
			return ErrorFactory.RG_INVALID0; 
		
		/*if (!stringValidator.validate(sexo,11))
			return ErrorFactory.SEXO_INVALID0;*/

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
		     return ErrorFactory.ESCOLA_ORIGEM_INVALIDA;
		//if (!stringValidator.validateLetraDigito(orgExpeditor))
		if (!numeroValidator.validateEspacos(numCartaoSus))
			return ErrorFactory.NUM_CARTAO_SUS_INVALIDO;
		if (!stringValidator.validateSomenteLetras(curso))
			return ErrorFactory.CURSO_INVALIDO;
		if (!numeroValidator.isInteiroPositivo(numCasa))
			return ErrorFactory.NUM_CASA_INVALIDA;
		if (!stringValidator.validateSomenteLetras(pontoRef))
			return ErrorFactory.PONTO_REF_INVALIDO;
	    if (!stringValidator.validateSomenteLetras(estado))
	    	return ErrorFactory.ESTADO_INVALIDO;
	    if (!stringValidator.validateSomenteLetras(motivoSolicitacao))
	    	return ErrorFactory.MOTIVO_SOLICITACAO_INVALIDO;
		if (!stringValidator.validate(estadoCivil,1,12))
			return ErrorFactory.ESTADO_CIVIL_INVALIDO;
		if (!numeroValidator.isInteiroPositivo(periodoLetivo))
			return ErrorFactory.PERIODO_LETIVO_INVALIDO;
		if (!stringValidator.validateSomenteLetras(turno))
			return ErrorFactory.TURNO_INVALIDO;
			if (endereco != null && cep != null && cidade != null && bairro != null) {
				/*if (!stringValidator.validate(endereco))
					return ErrorFactory.ENDERECO_INVALIDO;*/

				if (!numeroValidator.validate(cep,8))
					return ErrorFactory.CEP_INVALIDO;

				if (!stringValidator.validateSomenteLetras(cidade))
					return ErrorFactory.CIDADE_INVALIDA;
				if (!stringValidator.validate(bairro));
				return ErrorFactory.BAIRRO_INVALIDO;
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
				return ErrorFactory.BANCO_INVALIDO;
			
			if (!numeroValidator.validate(numAgencia, 6))
				return ErrorFactory.NUM_AGENCIA_INVALIDA;
			
			if (!stringValidator.validateSomenteLetras(agencia))
				return ErrorFactory.AGENCIA_INVALIDA;
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
				return ErrorFactory.NOME_DOCUMENTO_INVALIDO;
			
			if (!stringValidator.validate(status))
				return ErrorFactory.STATUS_DOCUMENTO_INVALIDO;
			
			if (!stringValidator.validateSomenteLetras(obs))
				return ErrorFactory.OBS_DOCUMENTO_INVALIDO;
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

			/*validacao = processo(edital);
			if (validacao != VALIDACAO_OK)
				return validacao;*/

			if (!dataValidator.datesInOrder(iniInscricoes, fimInscricoes))
				return ErrorFactory.FAIXA_DATA_INSCRICOES_INVALIDA;
			
			if (!dataValidator.datesInOrder(iniEntregaForm, fimForm))
				return ErrorFactory.FAIXA_DATA_INSCRICOES_INVALIDA;
			
			if (!numeroValidator.isInteiroPositivo(ano))
				return ErrorFactory.ANO_INVALIDO;
			
			if(!numeroValidator.isInteiroPositivo(vagasBolsistas))
				return ErrorFactory.VAGAS_BOLSISTAS_INVALIDA;
			
			if(!numeroValidator.isDoublePositivo(valorBolsaDiscente))
				return ErrorFactory.VALOR_BOLSA_DISCENTE_INVALIDA;
			
			if(!stringValidator.validateSomenteLetras(titulo))
				return ErrorFactory.TITULO_INVALIDO;
			
			if(!stringValidator.validateSomenteLetras(descricao))
				return ErrorFactory.DESCRICAO_INVALIDA;
			
			if(!numeroValidator.validate(numEdital))
				return ErrorFactory.NUM_EDITAL_INVALIDO;
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
				return ErrorFactory.NOME_FAMILIAR_INVALIDO;
			
			if (!numeroValidator.isInteiroPositivo(idade))
				return ErrorFactory.IDADE_FAMILIAR_INVALIDA;
			
			if (!numeroValidator.isInteiroPositivo(grauDeInstrucao))
				return ErrorFactory.GRAU_DE_INSTRUCAO_FAMILIAR_INVALIDA;
			
			if (!stringValidator.validateSomenteLetras(profissao))
				return ErrorFactory.PROFISSAO_FAMILIAR_INVALIDA;
			
			if (!stringValidator.validateSomenteLetras(doenca))
				return ErrorFactory.DOENCA_FAMILIAR_INVALIDA;
			
			if (!numeroValidator.isDoublePositivo(renda))
				return ErrorFactory.RENDA_FAMILIAR_INVALIDA;
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
				return ErrorFactory.NOME_IF_INVALIDO;
			
			if (!CNPJValidator.isCNPJ(cnpj))
				return ErrorFactory.CNPJ_INVALIDO;
			
			if (!numeroValidator.isDoublePositivo(orcamentoAuxilio))
				return ErrorFactory.ORCAMENTO_AUXILIO_INVALIDO;
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
			
            String dataRequisicao = processo.getDataRequisicao().toString();
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

			/*if (!stringValidator.validate(obs))
				return ErrorFactory.OBS_PROCESSO_INVALIDO;*/
			
			if (!numeroValidator.validate(numProcesso,20))
				return ErrorFactory.NUM_PROCESSO_INVALIDO;
			
			/*if (!stringValidator.validateSomenteLetras(assunto))
				return ErrorFactory.ASSUNTO_INVALIDO;*/
			
			/*if (!stringValidator.validateSomenteLetras(parecer))
				return ErrorFactory.PARECER_INVALIDO;*/
			 // if (!dataValidator.validate(dataRequisicao))
			
		}

		return VALIDACAO_OK;
	}
	

}
