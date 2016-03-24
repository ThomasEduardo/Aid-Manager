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
	public static final int NUM_AGENCIA_INVALIDO = 29;
	public static final int AGENCIA_INVALIDA = 30;
	
	/*
	 * Error status: Documento.
	 */
	
	public static final int NOME_DOCUMENTO_INVALIDO = 31;
	public static final int STATUS_DOCUMENTO_INVALIDO = 32;
	public static final int OBS_DOCUMENTO_INVALIDA = 33;
	
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
	
	public static final int NOME_IF_INVALIDA = 48;	
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
	public static final int OBS_PS_INVALIDA = 71;
	
	/*
	 * Error status: PerfilSocioEconomico
	 */
	public static final int OBS_PROCESSO_INVALIDA= 72;
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
		hashMap.put(ID_CURSO_INVALIDO, "Curso inv�lido.");
		hashMap.put(NOME_CURSO_INVALIDO, "Nome do curso inv�lido.");
		hashMap.put(NOME_USUARIO_INVALIDO, "Nome do usu�rio inv�lido.");
		hashMap.put(EMAIL_USUARIO_INVALIDO, "E-mail do usu�rio inv�lido.");
		hashMap.put(SENHA_USUARIO_INVALIDA, "Senha do usu�rio inv�lida.A senha deve conter no m�nimo 6 caracteres e no m�ximo 20\n E deve conter apenas caracteres e n�meros");
		hashMap.put(ID_ALUNO_INVALIDO, "Aluno inv�lido.");
		hashMap.put(ID_DIA_INVALIDO, "Dia inv�lido.");
		hashMap.put(ID_REFEICAO_INVALIDA, "Refei��o inv�lida.");
		hashMap.put(IMPOSSIVEL_CRIPTOGRAFAR_VALOR, "Imposs�vel criptografar valor.");
		hashMap.put(KEY_CONFIRMATION_INVALIDA, "Chave de confirma��o inv�lida.");
		hashMap.put(ID_DIA_REFEICAO_INVALIDO, "Dia da Refei��o inv�lido.");
		hashMap.put(CONFIRMACAO_REFEICAO_INVALIDA, "Confirma��o da refei��o inv�lida.");
		//hashMap.put(NOME_MATRICULA_ALUNO_INVALIDOS, "Nome e matr�cula do aluno inv�lidos.");
		hashMap.put(PRETENSAO_REFEICAO_NAO_ENCONTRADA, "Pretens�o da refei��o n�o encontrada.");
		//hashMap.put(ACESSO_ALUNO_NAO_PERMITIDO, "Acesso n�o permitido. Dados de login n�o conferem.");
		hashMap.put(REFEICAO_REALIZADA_NAO_ENCONTRADA, "Refei��o realizada n�o encotrada.");
		
				
		return hashMap;
	}

	public static final Erro getErrorFromIndex(int index) {
		
		Erro error = new Erro();
		error.setCodigo(index);
		error.setMensagem(mapErrors.get(index));
		
		return error;
	}

}
