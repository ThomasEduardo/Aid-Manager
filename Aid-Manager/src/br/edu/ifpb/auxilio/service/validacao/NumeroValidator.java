package br.edu.ifpb.auxilio.service.validacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroValidator {
	
	private Pattern pattern;
	private Pattern patternEspacos;
	private Matcher matcher;

	private static final String STRING_PATTERN = "[0-9]*";
	private static final String STRING_PATTERN_ESPAÇO = "[0-9 ]*";

	public NumeroValidator() {
		pattern = Pattern.compile(STRING_PATTERN);
		patternEspacos = Pattern.compile(STRING_PATTERN_ESPAÇO);
	}


	public boolean validate(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = pattern.matcher(value.trim());
		return matcher.matches();
	}
	
	public boolean validateEspacos(final String value) {
		if (value == null || value.trim().equals(""))
			return false;
		matcher = patternEspacos.matcher(value.trim());
		return matcher.matches();
	}

	public boolean validate(final String value, int tamanho) {
		return (validate(value) 
				&& value.length() == tamanho);
	}

	public boolean validate(final String value, int tamanhoMenor, 
			int tamanhoMaior) {
		
		return (validate(value) 
				&& (value.length() >= tamanhoMenor 
					&& value.length() <= tamanhoMaior));
	}

	public boolean isInteiroPositivo(int valor) {
		return (valor >= 0);
	}

	public boolean isDoublePositivo(double valor) {
		return (valor >= 0);
	}
	
	public boolean isMaiorZero(int valor) {
		return (valor > 0);
	}
	
	

}
