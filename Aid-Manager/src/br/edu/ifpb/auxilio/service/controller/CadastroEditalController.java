package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class CadastroEditalController implements Initializable{
	
	@FXML
	private TextField Campo_Titulo;
	
	@FXML
	private TextField Campo_NumeroDoEdital;
	
	@FXML
	private TextField Campo_Vagas;
	
	@FXML
	private TextField Campo_ValorBolsa;
	
	@FXML
	private DatePicker Campo_iniEntregaForm;
	
	@FXML
	private DatePicker Campo_iniInscricoes;
	
	@FXML
	private DatePicker Campo_fimInscricoes;
	
	@FXML
	private DatePicker Campo_fimForm;
	
	@FXML
	private TextField Campo_Descricao;
	
	@FXML
	private MenuButton Campo_TipoAuxilio;
	
	@FXML
	private Button Bt_CadastrarEdital;
	
	@FXML
	private Button Bt_Voltar;
	

	@FXML
	private void btCadastrarInstituicao() throws IOException, ParseException,SQLException{
		
	}
	
	@FXML
	private void btVoltar(){
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
