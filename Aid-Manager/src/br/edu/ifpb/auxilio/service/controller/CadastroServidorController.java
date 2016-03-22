package br.edu.ifpb.auxilio.service.controller;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.edu.ifpb.auxilio.entidade.Pessoa;
import br.edu.ifpb.auxilio.entidade.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroServidorController implements Initializable{
	
	@FXML
	private TextField Campo_NomeServidor;
	
	@FXML
	private TextField Campo_RgServidor;
	
	@FXML
	private TextField Campo_SUAPServidor;
	
	@FXML
	private TextField Campo_EmailServidor;
	
	@FXML
	private TextField Campo_CpfServidor;
	
	@FXML
	private TextField Campo_CargoServidor;
	
	@FXML
	private MenuButton Campo_SexoServidor;
	
	@FXML
	private DatePicker Campo_NascimentoServidor;
	
	@FXML
	private PasswordField Campo_SenhaServidor;
	
	@FXML
	private PasswordField Campo_ConfSenhaServidor;
	
	@FXML
	private Button Bt_CadastrarServidor;
	
	@FXML
	private Button Bt_VoltarCadastroServidor;
	
	@FXML
	private void btCadastrarServidor() throws IOException, ParseException,SQLException{
	
		
		try {
			Servidor servidor = new Servidor();
			Pessoa p = new Pessoa();
			
			Servidor s = new Servidor();
			
			s.setNomePessoa(Campo_NomeServidor.getText());
			s.setRg(Campo_RgServidor.getText());
			s.setMatricula(Campo_SUAPServidor.getText());
			s.setEmail(Campo_EmailServidor.getText());
			s.setCpf(Campo_CpfServidor.getText());
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			s.setDataNasc((java.util.Date)formatter.parse(Campo_NascimentoServidor.getValue().toString()));
			s.setSexo(Campo_SexoServidor.getText());
			s.setCargoServidor(Campo_CargoServidor.getText());
			s.setSenha(Campo_SenhaServidor.getText());
			
			System.out.println("oi");
			
			s.setIdPessoa(p.insert(s));
			servidor.insert(s);
			
			
			    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("br/edu/ifpb/auxilio/ui/forms/LoginPessoa.fxml"));
				
			    Scene telaLoginServidor = new Scene(root);
				
				Main.primaryStage.setTitle("Servidor");
				Main.primaryStage.setScene(telaLoginServidor);
				
				Main.primaryStage.show(); 
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
