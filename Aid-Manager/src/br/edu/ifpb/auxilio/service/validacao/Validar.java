package br.edu.ifpb.auxilio.service.validacao;
import br.edu.ifpb.auxilio.entidade.Pessoa;


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

		int validacao = VALIDACAO_OK;
		String nomePessoa = pessoa.getNomePessoa();
		String cpf = pessoa.getCpf();
		// Date nascimento = pessoa.getNascimento();
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

		/*if (!stringValidator.validate(urlLattes, 255))
			return CodeErroQManager.URL_LATTES_INVALIDO; Validar Rg*/ 
		
		if (!stringValidator.validate(sexo,9))
			return ErrorFactory.SEXO_INVALID0;

		return VALIDACAO_OK;
	}
	
	
	

}
