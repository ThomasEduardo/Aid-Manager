package br.edu.ifpb.auxilio.service.controller;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginController implements Initializable {
	
	
	@FXML
	private Button bt_Cadastrar;
	
	@FXML
	private ImageView logoPessoa;
	
	@FXML
	private TextField Campo_EmailMatricula;
	
	@FXML
	private PasswordField Campo_Senha;
	
	@FXML
	private Button Bt_Entrar;
	
	@FXML
	private Button Bt_VoltarLogin;
	
	private String perfil = TelaInicialController.perfil;

	@FXML
	private void btEntrar() throws IOException{
		
	
		
	    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("br/edu/ifpb/auxilio/ui/forms/LoginPessoa.fxml"));
		
	    Scene telaLoginServidor = new Scene(root);
		
		Main.primaryStage.setTitle("Servidor");
		Main.primaryStage.setScene(telaLoginServidor);
		
		Main.primaryStage.show(); 
	}
	
	@FXML
	private void btCadastrar() throws IOException{
		
		  Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("br/edu/ifpb/auxilio/ui/forms/CadastroServidor.fxml"));
		  
		  Scene telaCadastroServidor = new Scene(root);
		  
		  Main.primaryStage.setTitle("Cadastro de Servidor");
		  Main.primaryStage.setScene(telaCadastroServidor);
			
		  Main.primaryStage.show(); 
		
	}
	
	

	@FXML
	private void btVoltarLogin() throws IOException{
		
			
		
	    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("br/edu/ifpb/auxilio/ui/forms/TelaInicial.fxml"));
		
	    Scene telaInicial = new Scene(root);
		
		Main.primaryStage.setTitle("Aid Manager");
		Main.primaryStage.setScene(telaInicial);
		
		Main.primaryStage.show(); 
	}
	
	private void perfil(){
		if(perfil.equals("Servidor")){
			
			
			Image img = new Image("br/edu/ifpb/auxilio/recursos/imagens/Servidor.png");
			logoPessoa.setImage(img);
			
		}
		else {
			//Pesquisar um logo pra discente
			logoPessoa.setVisible(true);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		perfil();
		
	}
	

	
	

}
