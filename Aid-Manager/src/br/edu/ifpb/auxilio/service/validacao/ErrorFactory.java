package br.edu.ifpb.auxilio.service.validacao;

public class ErrorFactory {
	

	private ErrorFactory() {}

	/*
	 * Error status: Aluno.
	 */
	public static final int REGISTRO_DUPLICADO = 1;
	public static final int ALUNO_NAO_ENCONTRADO = 2;
	public static final int NOME_ALUNO_INVALIDO = 3;
	public static final int MATRICULA_ALUNO_INVALIDA = 4;
	public static final int CHAVE_CONFIRMACAO_INVALIDA = 5;
	public static final int NOME_MATRICULA_ALUNO_INVALIDOS = 6;
	public static final int ACESSO_ALUNO_NAO_PERMITIDO = 7;
	
	/*
	 * Error status: Curso.
	 */
	public static final int ID_CURSO_INVALIDO = 8;
	public static final int NOME_CURSO_INVALIDO = 9;
	
	/*
	 * Error status: Usu�rio.
	 */
	public static final int NOME_USUARIO_INVALIDO = 10;
	public static final int EMAIL_USUARIO_INVALIDO = 11;
	public static final int SENHA_USUARIO_INVALIDA = 12;
	public static final int KEY_CONFIRMATION_INVALIDA = 13;
	
	/*
	 * Error status: Dia da Refei��o.
	 */
	public static final int ID_DIA_REFEICAO_INVALIDO = 14;
	public static final int ID_ALUNO_INVALIDO = 15;
	public static final int ID_DIA_INVALIDO = 16;
	public static final int ID_REFEICAO_INVALIDA = 17;
	
	/*
	 * Confirma��o da Refei��o.
	 */
	public static final int CONFIRMACAO_REFEICAO_INVALIDA = 18;
	
	/*
	 * Pretens�o da Refei��o
	 */
	public static final int PRETENSAO_REFEICAO_NAO_ENCONTRADA = 19;
	
	/*
	 * Realiza��o da Refei��o
	 */
	public static final int REFEICAO_REALIZADA_NAO_ENCONTRADA = 20;
	
	public static final int IMPOSSIVEL_CRIPTOGRAFAR_VALOR = 21;
	
	
	/*
	 * Mapa de erros: c�digo e mensagem.
	 */
	private static final Map<Integer, String> mapErrors = generateErrorMapping();

	private final static Map<Integer, String> generateErrorMapping() {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		hashMap.put(REGISTRO_DUPLICADO, "Registro duplicado.");
		hashMap.put(ALUNO_NAO_ENCONTRADO, "Aluno n�o encontrado.");		
		hashMap.put(NOME_ALUNO_INVALIDO, "Nome do aluno inv�lido.");
		hashMap.put(CHAVE_CONFIRMACAO_INVALIDA, "Chave confirma��o inv�lida.");
		hashMap.put(MATRICULA_ALUNO_INVALIDA, "Matr�cula do aluno inv�lida.");		
		hashMap.put(ID_CURSO_INVALIDO, "Curso inv�lido.");
		hashMap.put(NOME_CURSO_INVALIDO, "Nome do curso inv�lido.");
		hashMap.put(NOME_USUARIO_INVALIDO, "Nome do usu�rio inv�lido.");
		hashMap.put(EMAIL_USUARIO_INVALIDO, "E-mail do usu�rio inv�lido.");
		hashMap.put(SENHA_USUARIO_INVALIDA, "Senha do usu�rio inv�lida.");
		hashMap.put(ID_ALUNO_INVALIDO, "Aluno inv�lido.");
		hashMap.put(ID_DIA_INVALIDO, "Dia inv�lido.");
		hashMap.put(ID_REFEICAO_INVALIDA, "Refei��o inv�lida.");
		hashMap.put(IMPOSSIVEL_CRIPTOGRAFAR_VALOR, "Imposs�vel criptografar valor.");
		hashMap.put(KEY_CONFIRMATION_INVALIDA, "Chave de confirma��o inv�lida.");
		hashMap.put(ID_DIA_REFEICAO_INVALIDO, "Dia da Refei��o inv�lido.");
		hashMap.put(CONFIRMACAO_REFEICAO_INVALIDA, "Confirma��o da refei��o inv�lida.");
		hashMap.put(NOME_MATRICULA_ALUNO_INVALIDOS, "Nome e matr�cula do aluno inv�lidos.");
		hashMap.put(PRETENSAO_REFEICAO_NAO_ENCONTRADA, "Pretens�o da refei��o n�o encontrada.");
		hashMap.put(ACESSO_ALUNO_NAO_PERMITIDO, "Acesso n�o permitido. Dados de login n�o conferem.");
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
