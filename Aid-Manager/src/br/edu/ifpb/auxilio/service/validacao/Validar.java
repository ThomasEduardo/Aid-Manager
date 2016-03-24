package br.edu.ifpb.auxilio.service.validacao;

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
	
	
	
	
	

}
