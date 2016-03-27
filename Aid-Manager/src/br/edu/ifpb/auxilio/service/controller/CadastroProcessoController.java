package br.edu.ifpb.auxilio.service.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.edu.ifpb.auxilio.actions.ActionInstituicaoFinanciadora;
import br.edu.ifpb.auxilio.actions.ActionPessoa;
import br.edu.ifpb.auxilio.actions.ActionProcesso;
import br.edu.ifpb.auxilio.actions.ActionServidor;
import br.edu.ifpb.auxilio.entidade.Erro;
import br.edu.ifpb.auxilio.entidade.InstituicaoFinanciadora;
import br.edu.ifpb.auxilio.entidade.Processo;
import br.edu.ifpb.auxilio.service.validacao.ErrorFactory;
import br.edu.ifpb.auxilio.service.validacao.Validar;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadastroProcessoController {
	
	@FXML
	private TextField Campo_ProcessoNum;
	
	@FXML
	private TextField Campo_Assunto;
	
	@FXML
	private TextField Campo_Interessado;
	
	@FXML
	private TextField Campo_ServidorResponsavel;
	
	@FXML
	private DatePicker Campo_DataRequisicao;
	
	@FXML
	private Button Bt_CadastrarProcesso;
	
	@FXML
	private Button Bt_Voltar;
	
	@FXML
	private void btCadastrarProcesso() throws IOException, ParseException,SQLException{
		 
		try {    
		    ActionProcesso actionProcesso = new ActionProcesso();
		    ActionPessoa actionPessoa = new ActionPessoa();
		    ActionServidor actionServidor = new ActionServidor();

		    Processo p = new Processo();
			
			p.setAssunto(Campo_Assunto.getText());
			p.setNumProcesso(Campo_ProcessoNum.getText());
			p.setInteressado(actionPessoa.getById(actionPessoa.getId(Campo_Interessado.getText())));
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			p.setDataRequisicao((java.util.Date)formatter.parse(Campo_DataRequisicao.getValue().toString()));
			System.out.println(p.getDataRequisicao());
			p.setServidor(actionServidor.getById(actionServidor.getId(Campo_ServidorResponsavel.getText())));
			p.setParecer("Em trâmite");
			p.setObs("Nenhuma até o momento. 123");
		    
			int validacao = Validar.processo(p);
			if(validacao == Validar.VALIDACAO_OK){
				actionProcesso.insert(p);	
				
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
