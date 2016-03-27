package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.edu.ifpb.auxilio.actions.ActionDiscente;
import br.edu.ifpb.auxilio.actions.ActionInstituicaoFinanciadora;
import br.edu.ifpb.auxilio.actions.ActionPessoa;
import br.edu.ifpb.auxilio.actions.ActionProcesso;
import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.service.validacao.ErrorFactory;
import br.edu.ifpb.auxilio.service.validacao.Validar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class CadastroAuxilioController implements Initializable{

	@FXML
	private DatePicker Campo_ValidadeInicial;
	
	@FXML
	private DatePicker Campo_ValidadeFinal;
	
	@FXML
	private TextField Campo_ValorBolsa;
	
	@FXML
	private TextField Campo_tipoAuxilio;
	
	
	@FXML
	private TextField Campo_NumProcesso;
	
	@FXML
	private TextField Campo_Instituicao;
	
	@FXML
	private Button Bt_Voltar;
	
	@FXML
	private Button Bt_CadastrarAuxilio;
	
	
	
	@FXML
	private void btCadastrarAuxilio() throws IOException, ParseException,SQLException{
	
		
		try {
		    ActionProcesso actionProcesso = new ActionProcesso();
		    ActionInstituicaoFinanciadora actionInstituicao = new ActionInstituicaoFinanciadora();
		    
		    Auxilio a = new Auxilio();
			
		    a.setTipoAuxilio(Campo_tipoAuxilio.getText());
		    a.setP(actionProcesso.getById(actionProcesso.getId(Campo_NumProcesso.getText())));
		    a.setIF(actionInstituicao.getById(actionInstituicao.getId(Campo_Instituicao.getText())));
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			a.setValidadeInicial((java.util.Date)formatter.parse(Campo_ValidadeInicial.getValue().toString()));
			a.setValidadeInicial((java.util.Date)formatter.parse(Campo_ValidadeFinal.getValue().toString()));
			a.setValorAuxilio(Double.parseDouble(Campo_ValorBolsa.getText()));
			
			
			/*int validacao = Validar

			if (validacao == Validar.VALIDACAO_OK) {
				d.setIdPessoa(actionPerson.insert(d));
				actionDiscente.insert(d);
				System.out.println("oi");
			
			} else{
				
				Erro erro = ErrorFactory.getErrorFromIndex(validacao);
				System.out.println(erro.getMensagem());
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@FXML
	private void btVoltar() throws IOException, ParseException,SQLException{
		
	}
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
