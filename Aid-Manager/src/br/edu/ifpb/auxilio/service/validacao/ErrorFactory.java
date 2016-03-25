package br.edu.ifpb.auxilio.service.validacao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.entidade.Servidor;

public class ErrorFactory {
	

	private ErrorFactory() {}

	/*
	 * Error status: Pessoa.
	 */
	public static final int REGISTRO_DUPLICADO = 1;
	public static final int USUARIO_NAO_ENCONTRADO = 2;
	public static final int NOME_USUARIO_INVALIDO = 3;
	public static final int MATRICULA_USUARIO_INVALIDA = 4;
	public static final int EMAIL_USUARIO_INVALIDO = 5;
	public static final int SENHA_USUARIO_INVALIDA = 6;
	public static final int CPF_USUARIO_INVALID0 = 7;
	public static final int SEXO_INVALID0 = 8;
	public static final int RG_INVALID0 = 9;
	
	
	/*
	 * Error status: Servidor.
	 */
	public static final int CARGO_SERVIDOR_INVALIDO = 10;
	
	/*
	 * Error status: Discente.
	 */
	public static final int ESCOLA_ORIGEM_INVALIDA = 13;
	public static final int ORG_EXPEDITOR_INVALIDO = 14; 
	public static final int NUM_CARTAO_SUS_INVALIDO = 15; 
	public static final int ESTADO_CIVIL_INVALIDO = 16; 
	public static final int CURSO_INVALIDO = 17;
	public static final int PERIODO_LETIVO_INVALIDO = 18;
	public static final int TURNO_INVALIDO = 19; 
	public static final int ENDERECO_INVALIDO = 20;
	public static final int CEP_INVALIDO = 21; 
	public static final int BAIRRO_INVALIDO = 22; 
	public static final int CIDADE_INVALIDA = 23;
	public static final int NUM_CASA_INVALIDA = 24;
	public static final int PONTO_REF_INVALIDO = 25; 
	public static final int ESTADO_INVALIDO = 26;
	public static final int MOTIVO_SOLICITACAO_INVALIDO = 27; 
	
	
	/*
	 * Error status: Dados Bancarios.
	 */
	public static final int BANCO_INVALIDO = 28;
	public static final int NUM_AGENCIA_INVALIDA = 29;
	public static final int AGENCIA_INVALIDA = 30;
	
	/*
	 * Error status: Documento.
	 */
	
	public static final int NOME_DOCUMENTO_INVALIDO = 31;
	public static final int STATUS_DOCUMENTO_INVALIDO = 32;
	public static final int OBS_DOCUMENTO_INVALIDO = 33;
	
	/*
	 * Error Status: edital.
	 * 
	 */
	
	public static final int ANO_INVALIDO = 34;
	public static final int DESCRICAO_INVALIDA = 35;
	public static final int TITULO_INVALIDO = 36;
	public static final int VALOR_BOLSA_DISCENTE_INVALIDA = 37;
	public static final int VAGAS_BOLSISTAS_INVALIDA = 38;
	public static final int NUM_EDITAL_INVALIDO = 39;
	public static final int FAIXA_DATA_INSCRICOES_INVALIDA = 40;
	public static final int FAIXA_DATA_FORM_INVALIDA = 41;
	
	/*
	 * Error status: familiar
	 */
	public static final int NOME_FAMILIAR_INVALIDO = 42; 
	public static final int IDADE_FAMILIAR_INVALIDA = 43; 
	public static final int GRAU_DE_INSTRUCAO_FAMILIAR_INVALIDA = 44; 
	public static final int PROFISSAO_FAMILIAR_INVALIDA= 45;
	public static final int RENDA_FAMILIAR_INVALIDA = 46;
	public static final int DOENCA_FAMILIAR_INVALIDA = 47;
	
	/*
	 * Error status: Instituicao Financiadora
	 */
	
	public static final int NOME_IF_INVALIDO = 48;	
	public static final int CNPJ_INVALIDO = 49;
	public static final int ORCAMENTO_AUXILIO_INVALIDO = 50;  
	
	/*
	 * Error status: PerfilSocioEconomico
	 */
	
	public static final int RENDA_FAMILIAR_TOTAL_INVALIDA= 60;
	public static final int MORADIA_INVALIDA = 61;
	public static final int SITUACAO_MORADIA_INVALIDA= 62;
	public static final int RESIDENCIA_FAMILIAR_INVALIDA = 63;
	public static final int SITUACAO_TRABALHO_INVALIDA= 64;
	public static final int ALUGUEL_INVALIDO = 65;
	public static final int CONDOMINIO_INVALIDO = 66;
	public static final int LUZ_INVALIDA = 67;
	public static final int AGUA_INVALIDA = 68;
	public static final int TELEFONE_INVALIDO = 69;
	public static final int FINANCIAMENTO_CASA_PROPRIA_INVALIDO = 70;
	public static final int OBS_PS_INVALIDO = 71;
	
	/*
	 * Error status: PerfilSocioEconomico
	 */
	public static final int OBS_PROCESSO_INVALIDO= 72;
    public static final int NUM_PROCESSO_INVALIDO = 73;
	public static final int ASSUNTO_INVALIDO= 74; 
	public static final int PARECER_INVALIDO = 75;

	
	
	public static final int IMPOSSIVEL_CRIPTOGRAFAR_VALOR = 78;
	
	
	/*
	 * Mapa de erros: c�digo e mensagem.
	 */
	private static final Map<Integer, String> mapErrors = generateErrorMapping();

	private final static Map<Integer, String> generateErrorMapping() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(REGISTRO_DUPLICADO, "Registro duplicado.");
		hashMap.put(USUARIO_NAO_ENCONTRADO, "Aluno n�o encontrado.");		
		hashMap.put(NOME_USUARIO_INVALIDO, "Nome do aluno inv�lido.");
		hashMap.put(MATRICULA_USUARIO_INVALIDA, "Matr�cula inserida inv�lida.");		
		hashMap.put(CPF_USUARIO_INVALID0, "Cpf inv�lido.");
		hashMap.put(SEXO_INVALID0, "Sexo inv�lido.");
		hashMap.put(EMAIL_USUARIO_INVALIDO, "E-mail do usu�rio inv�lido.");
		hashMap.put(SENHA_USUARIO_INVALIDA, "Senha do usu�rio inv�lida.A senha deve conter no m�nimo 6 caracteres e no m�ximo 20\n E deve conter apenas caracteres e n�meros");
		hashMap.put(RG_INVALID0, "Rg inv�lido.");
		hashMap.put(CARGO_SERVIDOR_INVALIDO, "Cargo do servidor inv�lido. Certifique de ter inserido apenas letras.");
		hashMap.put(ESCOLA_ORIGEM_INVALIDA, "Escola de origem inv�lida. Certifique de ter inserido apenas letras.");
		hashMap.put(IMPOSSIVEL_CRIPTOGRAFAR_VALOR, "Imposs�vel criptografar valor.");
		hashMap.put(ORG_EXPEDITOR_INVALIDO, "Org�o expeditor.");
		hashMap.put(NUM_CARTAO_SUS_INVALIDO, "Numero do cart�o do sus inv�lido. O n�mero deve conter apenas 15 digitos");
		hashMap.put(ESTADO_CIVIL_INVALIDO, "Estado civil inv�lido.Deve conter apenas letras com tamanho inferior a 12");
		//hashMap.put(NOME_MATRICULA_ALUNO_INVALIDOS, "Nome e matr�cula do aluno inv�lidos.");
		hashMap.put(CURSO_INVALIDO, "Curso inv�lido.Deve conter apenas letras");
		//hashMap.put(ACESSO_ALUNO_NAO_PERMITIDO, "Acesso n�o permitido. Dados de login n�o conferem.");
		hashMap.put(PERIODO_LETIVO_INVALIDO, "Perido letivo inv�lido. O n�mero deve ser um inteiro positivo");
		hashMap.put(TURNO_INVALIDO, "Turno inv�lido. Insira apenas letras");
		hashMap.put(ENDERECO_INVALIDO, "Endere�o inv�lido.");
		hashMap.put(CEP_INVALIDO, "Cep inv�lido. Insira apenas n�meros.O cep deve ter tamanho inferior a 8");
		hashMap.put(BAIRRO_INVALIDO, "Bairro inv�lido.");
		hashMap.put(CIDADE_INVALIDA, "Cidade inv�lida. Insira apenas letras");
		hashMap.put(NUM_CASA_INVALIDA, "N�mero de casa inv�lido.O n�mero deve ser um inteiro positivo");
		hashMap.put(PONTO_REF_INVALIDO, "Ponto de refer�ncia inv�lido.");
		hashMap.put(ESTADO_INVALIDO, "Estado inv�lido.Insira apenas letras");
		hashMap.put(MOTIVO_SOLICITACAO_INVALIDO, "Motivo de solicita��o inv�lido.");
		hashMap.put(BANCO_INVALIDO, "Banco inv�lido. Insira apenas n�meros.");
		hashMap.put(NUM_AGENCIA_INVALIDA, "N�mero de agencia inv�lida.Insira apenas n�meros");
		hashMap.put(AGENCIA_INVALIDA, "Agencia inv�lida.Insira apenas letras.");
		hashMap.put(NOME_DOCUMENTO_INVALIDO, "Nome do documento inv�lido.Insira apenas letras");
		hashMap.put(STATUS_DOCUMENTO_INVALIDO, "Status do documento inv�lido.");
		hashMap.put(OBS_DOCUMENTO_INVALIDO, "Observa��o de documento inv�lida.");
		hashMap.put(ANO_INVALIDO, "Ano inv�lido.O n�mero deve ser um inteiro positivo.");
		hashMap.put(DESCRICAO_INVALIDA, "Descri��o inv�lida.");
		hashMap.put(TITULO_INVALIDO, "T�tulo inv�lido.");
		hashMap.put(VALOR_BOLSA_DISCENTE_INVALIDA, "Valor da bolsa do discente inv�lida.");
		hashMap.put(VAGAS_BOLSISTAS_INVALIDA, "Vagas destinadas a bolsistas inv�lida.");
		hashMap.put(NUM_EDITAL_INVALIDO, "N�mero de edital inv�lido.");
		hashMap.put(FAIXA_DATA_INSCRICOES_INVALIDA, "Faixa de data de inscri��es inv�lida.");
		hashMap.put(FAIXA_DATA_FORM_INVALIDA, "Daixa de data de formul�rios inv�lida.");
		hashMap.put(NOME_FAMILIAR_INVALIDO, "Nome do familiar inv�lido.");
		hashMap.put(IDADE_FAMILIAR_INVALIDA, "Idade do familiar inv�lido.");
		hashMap.put(GRAU_DE_INSTRUCAO_FAMILIAR_INVALIDA, "Grau de instru��o do familiar inv�lido.");
		hashMap.put(PROFISSAO_FAMILIAR_INVALIDA, "Profiss�o do familiar inv�lida.");
		hashMap.put(RENDA_FAMILIAR_INVALIDA, "Renda do familiar inv�lida.");
		hashMap.put(DOENCA_FAMILIAR_INVALIDA, "Doen�a do familiar inv�lida.");
		hashMap.put(NOME_IF_INVALIDO, "Nome da institui��o financiadora inv�lido.");
		hashMap.put(CNPJ_INVALIDO, "CNPJ inv�lido.");
		hashMap.put(ORCAMENTO_AUXILIO_INVALIDO, "Or�amento do aux�lio inv�lido.");
		hashMap.put(RENDA_FAMILIAR_TOTAL_INVALIDA, "Renda inv�lida.");
		hashMap.put(MORADIA_INVALIDA, "Moradia inv�lida.");
		hashMap.put(SITUACAO_MORADIA_INVALIDA, "Situa��o de moradia inv�lida.");
		hashMap.put(RESIDENCIA_FAMILIAR_INVALIDA, "Resid�ncia familiar inv�lida.");
		hashMap.put(SITUACAO_TRABALHO_INVALIDA, "Situa��o em rela��o ao trabalho inv�lida.");
		hashMap.put(ALUGUEL_INVALIDO, "Gastos com aluguel inv�lido.");
		hashMap.put(CONDOMINIO_INVALIDO, "Gastos com condominio invalido.");
		hashMap.put(LUZ_INVALIDA, "Gastos com luz inv�lido.");
		hashMap.put(AGUA_INVALIDA, "Gastos com �gua inv�lido.");
		hashMap.put(TELEFONE_INVALIDO, "Gastos com telefone inv�lido.");
		hashMap.put(FINANCIAMENTO_CASA_PROPRIA_INVALIDO, "Gastos com o financiamento da casa pr�pia inv�lido.");
		hashMap.put(OBS_PS_INVALIDO, "Observa��o do perfil socio econ�mico inv�lido.");
		hashMap.put(OBS_PROCESSO_INVALIDO, "Observa��o do processo inv�lido.");
		hashMap.put(NUM_PROCESSO_INVALIDO, "N�mero de processo inv�lido.");
		hashMap.put(ASSUNTO_INVALIDO, "Assunto inv�lido.");
		hashMap.put(PARECER_INVALIDO, "Parecer inv�lido.");
		
				
		return hashMap;
	}

	public static final Erro getErrorFromIndex(int index) {
		
		Erro error = new Erro();
		error.setCodigo(index);
		error.setMensagem(mapErrors.get(index));
		
		return error;
	}

}
