package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.ifpb.auxilio.actions.ActionDiscente;
import br.edu.ifpb.auxilio.actions.ActionInstituicaoFinanciadora;
import br.edu.ifpb.auxilio.actions.ActionPessoa;
import br.edu.ifpb.auxilio.actions.ActionServidor;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.service.validacao.ErrorFactory;
import br.edu.ifpb.auxilio.service.validacao.Validar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroInstituicaoFinanciadoraController {
	
	@FXML
	private TextField Campo_NomeInstituicao;
	
	@FXML
	private TextField Campo_CNPJ;
	
	@FXML
	private TextField Campo_Orcamento;
	
	@FXML
	private TextField Campo_Servidor;
	
	@FXML
	private Button Bt_CadastrarInstituicao;
	
	@FXML
	private Button Bt_Voltar;
	
	@FXML
	private void btCadastrarInstituicao() throws IOException, ParseException,SQLException{
		 
		try {    
		    ActionInstituicaoFinanciadora actionIf = new ActionInstituicaoFinanciadora();
		    ActionServidor actionServidor = new ActionServidor();

		    InstituicaoFinanciadora i = new InstituicaoFinanciadora();
			
			i.setCnpj(Campo_CNPJ.getText());
			i.setOrcamentoAuxilio(Double.parseDouble(Campo_Orcamento.getText()));
			i.setNomeIF(Campo_NomeInstituicao.getText());
			i.setServidor(actionServidor.getById(actionServidor.getId(Campo_Servidor.getText())));
			
			
		    
			int validacao = Validar.InstituicaoFinanciadora(i);
			if(validacao == Validar.VALIDACAO_OK){
				actionIf.insert(i);	
				
			}
			else{
				Erro erro = ErrorFactory.getErrorFromIndex(validacao);
				System.out.println(erro.getMensagem());
				
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@FXML
	private void btVoltar(){
		
	}
	

}
