package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import br.edu.ifpb.auxilio.actions.ActionEdital;
import br.edu.ifpb.auxilio.actions.ActionInstituicaoFinanciadora;
import br.edu.ifpb.auxilio.actions.ActionProcesso;
import br.edu.ifpb.auxilio.entidade.Auxilio;
import br.edu.ifpb.auxilio.entidade.Edital;
import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.service.validacao.ErrorFactory;
import br.edu.ifpb.auxilio.service.validacao.Validar;
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
	private TextField Campo_anoEdital;
	
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
	private TextField Campo_NumProcesso;
	
	
	@FXML
	private Button Bt_CadastrarEdital;
	
	@FXML
	private Button Bt_Voltar;
	

	@FXML
	private void btCadastrarEdital() throws IOException, ParseException,SQLException{
		
		ActionProcesso actionProcesso = new ActionProcesso();
	    ActionEdital actionEdital = new ActionEdital();
	   
	    Processo p = new Processo();
	   
	    
	    Edital e = new Edital();
	    
	    
	    e.setTitulo(Campo_Titulo.getText());
	    e.setNumEdital(Campo_NumeroDoEdital.getText());
	    e.setValorBolsaDiscente(Double.parseDouble(Campo_ValorBolsa.getText()));
	    e.setVagasBolsistas(Integer.parseInt(Campo_Vagas.getText()));
	    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    e.setIniEntregaForm(((java.util.Date)formatter.parse(Campo_iniEntregaForm.getValue().toString())));
	    e.setIniInscricoes(((java.util.Date)formatter.parse(Campo_iniInscricoes.getValue().toString())));
	    e.setFimForm(((java.util.Date)formatter.parse(Campo_fimForm.getValue().toString())));
	    e.setFimInscricoes(((java.util.Date)formatter.parse(Campo_fimInscricoes.getValue().toString())));
	    e.setDescricao(Campo_Descricao.getText());
	    e.setAno(Integer.parseInt(Campo_anoEdital.getText()));
	    p = (actionProcesso.getById((actionProcesso.getId(Campo_NumProcesso.getText()))));
	    e.setServidor(p.getServidor());
	    e.setAssunto(p.getAssunto());
	    e.setParecer(p.getParecer());
	    e.setIdProcesso(p.getIdProcesso());
	    e.setInteressado(p.getInteressado());
	    e.setDataRequisicao(p.getDataRequisicao());
	    e.setObs(p.getObs());
	    p.setNumProcesso(p.getNumProcesso());
	    
		
	    
		int validacao = Validar.edital(e);

		if (validacao == Validar.VALIDACAO_OK) {
			actionEdital.insert(e);
			System.out.println("oi");
		
		} else{
			
			Erro erro = ErrorFactory.getErrorFromIndex(validacao);
			System.out.println(erro.getMensagem());
		}
		
		
		
	}
	
	@FXML
	private void btVoltar(){
		
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
