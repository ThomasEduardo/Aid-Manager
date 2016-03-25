package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.edu.ifpb.auxilio.actions.ActionDiscente;
import br.edu.ifpb.auxilio.actions.ActionPessoa;
import br.edu.ifpb.auxilio.actions.ActionServidor;
import br.edu.ifpb.auxilio.entidade.Discente;
import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.entidade.Servidor;
import br.edu.ifpb.auxilio.service.validacao.ErrorFactory;
import br.edu.ifpb.auxilio.service.validacao.Validar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroDiscenteController implements Initializable{

	
	@FXML
	private TextField Campo_NomeDiscente;
	
	@FXML
	private TextField Campo_RgDiscente;
	
	@FXML
	private TextField Campo_Matricula;
	
	@FXML
	private TextField Campo_EmailDiscente;
	
	@FXML
	private TextField Campo_CPFDiscente;
	
	@FXML
	private MenuButton Campo_SexoDiscente;
	
	@FXML
	private DatePicker Campo_NascDiscente;
	
	@FXML
	private TextField Campo_SenhaDiscente;
	
	@FXML
	private TextField Campo_ConfSenhaDiscente;
	
	@FXML
	private Button Bt_CadastrarDiscente;
	
	@FXML
	private Button Bt_VoltarCadastroDiscente;
	
	@FXML
	private void btCadastrarDiscente() throws IOException, ParseException,SQLException{
	
		
		try {
		    ActionDiscente actionDiscente = new ActionDiscente();
		    ActionPessoa actionPerson = new ActionPessoa();
		    

			Discente d = new Discente();
			
			d.setNomePessoa(Campo_NomeDiscente.getText());
			d.setRg(Campo_RgDiscente.getText());
			d.setMatricula(Campo_Matricula.getText());
			d.setEmail(Campo_EmailDiscente.getText());
			d.setCpf(Campo_CPFDiscente.getText());
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			d.setDataNasc((java.util.Date)formatter.parse(Campo_NascDiscente.getValue().toString()));
			d.setSexo(Campo_SexoDiscente.getText());
			d.setSenha(Campo_SenhaDiscente.getText());
			
			int validacao = Validar.Discente(d);

			if (validacao == Validar.VALIDACAO_OK) {
				d.setIdPessoa(actionPerson.insert(d));
				actionDiscente.insert(d);
				System.out.println("oi");
			
			} else{
				
				Erro erro = ErrorFactory.getErrorFromIndex(validacao);
				System.out.println(erro.getMensagem());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	
}
