package br.edu.ifpb.auxilio.service.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
	
	public static String perfil;

	@FXML
	private Button Bt_servidor;
	
	@FXML
	private Button Bt_Discente;
	
	@FXML
	private void btServidor() throws IOException{
		
		perfil = "Servidor";		
		
	    Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("br/edu/ifpb/auxilio/ui/forms/LoginPessoa.fxml"));
		
	    Scene telaLoginServidor = new Scene(root2);
		
		Main.primaryStage.setTitle("Servidor");
		Main.primaryStage.setScene(telaLoginServidor);
		
		Main.primaryStage.show(); 
	}
	
	
	@FXML
	private void btDiscente() throws IOException{
		perfil = "Discente";
		Parent root2 = FXMLLoader.load(getClass().getResource("ui/forms/LoginPessoa.fxml"));
		
		Scene telaLoginDiscente = new Scene(root2);
		
		Main.primaryStage.setTitle("Discente");
		Main.primaryStage.setScene(telaLoginDiscente);
		Main.primaryStage.show();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	


}
