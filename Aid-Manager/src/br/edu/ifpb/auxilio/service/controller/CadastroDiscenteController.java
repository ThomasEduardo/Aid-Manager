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
	private TextField Campo_NomeCompleto;
	
	@FXML
	private TextField Campo_Rg;
	
	@FXML
	private TextField Campo_Matricula;
	
	@FXML
	private TextField Campo_Email;
	
	@FXML
	private TextField Campo_Cpf;
	
	@FXML
	private MenuButton MenuBt_Sexo;
	
	@FXML
	private DatePicker Campo_Data;
	
	@FXML
	private TextField Campo_Senha;
	
	@FXML
	private TextField Campo_ConfirmarSenha;
	
	@FXML
	private TextField Campo_Curso;
	
	@FXML
	private TextField Campo_Turno;
	
	@FXML
	private TextField Campo_EstadoCivil;
	
	@FXML
	private TextField Campo_CartaoSUS;
	
	@FXML
	private TextField Campo_SerieIntegrado;
	
	@FXML
	private MenuButton MenuBt_EscolaOrigem;
	
	@FXML
	private TextField Campo_EnderecoAluno;
	
	@FXML
	private TextField Campo_Num;
	
	@FXML
	private TextField Campo_Apt;
	
	@FXML
	private TextField Campo_Bairro;
	
	@FXML
	private TextField Campo_CEP;
	
	@FXML
	private TextField Campo_Cidade;
	
	@FXML
	private TextField Campo_Estado;
	
	@FXML
	private TextField Campo_PontoDeReferência;
	
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
			
			d.setNomePessoa(Campo_NomeCompleto.getText());
			d.setRg(Campo_Rg.getText());
			d.setMatricula(Campo_Matricula.getText());
			d.setEmail(Campo_Email.getText());
			d.setCpf(Campo_Cpf.getText());
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			d.setDataNasc((java.util.Date)formatter.parse(Campo_Data.getValue().toString()));
			d.setSexo(MenuBt_Sexo.getText());
			d.setSenha(Campo_Senha.getText());
			d.setCurso(Campo_Curso.getText());
			d.setTurno(Campo_Turno.getText());
			d.setEstadoCivil(Campo_EstadoCivil.getText());
			d.setNumCartaoSus(Campo_CartaoSUS.getText());
			d.setPeriodoLetivo(Integer.parseInt(Campo_SerieIntegrado.getText()));
			d.setEscolaOrigem(MenuBt_EscolaOrigem.getTypeSelector());
			d.setEndereco(Campo_EnderecoAluno.getText());
			d.setNumCasa(Integer.parseInt(Campo_Num.getText()));
			d.setBairro(Campo_Bairro.getText());
			d.setCep(Campo_CEP.getText());
			d.setCidade(Campo_Cidade.getText());
			d.setEstado(Campo_Estado.getText());
			d.setPontoRef(Campo_PontoDeReferência.getText());
			
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
