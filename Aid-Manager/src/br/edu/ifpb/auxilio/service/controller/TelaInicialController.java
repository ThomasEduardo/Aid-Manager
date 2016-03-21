package br.edu.ifpb.auxilio.service.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable {
	
	private static String perfil;
	
	@FXML
	private Button Bt_servidor;
	
	@FXML
	private Button Bt_Discente;
	
	@FXML
	private void btServidor() throws IOException{
		perfil = "Servidor";

		
		
	   Parent root2 = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/LoginScreen.fxml"));
		
		Scene loginMonitorScreen = new Scene(root2);
		Main.primaryStage.setTitle("Servidor");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show(); 
	}
	
	
	@FXML
	private void btDiscente() throws IOException{
		perfil = "Discente";
		Parent root2 = FXMLLoader.load(getClass().getResource("/findMe/UI/FXML/LoginScreen.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root2);
		
		Main.primaryStage.setTitle("Discente");
		Main.primaryStage.setScene(loginSupervisorScreen);
		Main.primaryStage.show();
	}
	
	

}
