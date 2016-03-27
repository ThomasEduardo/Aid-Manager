package br.edu.ifpb.auxilio.service.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
	
	private Pattern pattern;
	private Pattern patternLetras;
	private Pattern patternPassword;
	private Matcher matcher;
	private Pattern patternRg;
	private Pattern patternProcesso;
	

	private static final String STRING_PATTERN = "[0-9a-zA-ZáàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ. ]*";
	private static final String STRING_PATTERN_SOMENTE_LETRAS = "[a-zA-ZáàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ. ]*";
	private static final String STRING_PATTERN_RG = "[0-9]{1}."+"[0-9]{3}." + "[0-9]{3}";
	private static final String STRING_PATTERN_PROCESSO = "[0-9]{5}."+"[0-9]{6}." + "[0-9]{4}-"+ "[0-9]{2}";

	// Verifica se há, ao menos:
	// - um número;
	// - uma letra minúscula;
	// - uma letra maiúscula.
	// O tamanho deve está entre 6 e 20 caracteres.
	private static final String PASSWORD_PATTERN = "[0-9a-zA-ZáàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ]{6,20}";

	public StringValidator() {
		pattern = Pattern.compile(STRING_PATTERN);
		patternLetras = Pattern.compile(STRING_PATTERN_SOMENTE_LETRAS);
		patternPassword = Pattern.compile(PASSWORD_PATTERN);
		patternRg = Pattern.compile(STRING_PATTERN_RG);
		patternProcesso = Pattern.compile(STRING_PATTERN_PROCESSO);
		
	}

	
	public boolean validate(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = pattern.matcher(value.trim());
		return matcher.matches();
	}
	
	public boolean validateProcesso(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = patternProcesso.matcher(value.trim());
		return matcher.matches();
	}
	
	public boolean validateSomenteLetras(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = patternLetras.matcher(value.trim());
		return matcher.matches();
	}

	public boolean validate(final String value, int tamanho) {
		boolean isValidate = validate(value);
		return (isValidate && value.length() == tamanho);
	}

	public boolean validate(final String value, int tamanhoMenor,
			int tamanhoMaior) {
		
		return (value.length() >= tamanhoMenor && value.length() <= tamanhoMaior);
		
	}

	public boolean validate(String pattern, final String value,
			int tamanhoMenor, int tamanhoMaior) {
		return (validate(value) && (value.length() >= tamanhoMenor && value
				.length() <= tamanhoMaior));
	}
	

	public boolean validatePassword(final String password) {
		if (password == null || password.trim().equals(""))
			return false;
		matcher = patternPassword.matcher(password);
		return matcher.matches();
	}
	public boolean validateRg(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = patternRg.matcher(value.trim());
		return matcher.matches();
	}

}
