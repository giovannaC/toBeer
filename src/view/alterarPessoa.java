package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import controle.cidadeControle;
import controle.enderecoControle;
import controle.estadoControle;
import controle.loginControle;
import controle.pessoaControle;
import controle.tipoLogradouroControle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class alterarPessoa extends Shell {
	
	estadoControle estado = new estadoControle();
	classes.estado estadoClass = new classes.estado();
	cidadeControle cidade = new cidadeControle();
	classes.cidade cidadeClass = new classes.cidade();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	classes.tipoLogradouro tipoLogradouroClass = new classes.tipoLogradouro();
	enderecoControle endereco = new enderecoControle();
	classes.endereco enderecoClass = new classes.endereco();
	pessoaControle pessoa = new pessoaControle ();
	loginControle login = new loginControle();

	
	ResultSet bdPessoa;
	ResultSet bdEndereco;
	ResultSet bdTipoLogradouro;
	ResultSet bdEstado;
	ResultSet bdCidade;
	ResultSet bdLogin;
	
	public int idPessoa;
	public int idEndereco;
	public int idTipoLogradouro;
	public int idCidade;
	public int idEstado;
	
	
	public String nomePessoa;
	public String nascimentoPessoa;
		public int dia;
		public int mes;
		public int ano;
	public String telPessoa;
	public String genPessoa;
	public String senhaPessoa;
	public String nomeTipoLogradouro;
	public String enderecoLogradouro;
	public int enderecoNumero;
	public String bairro;
	public String enderecoComplemento;
	public String cep;
	public String nomeCidade;
	public String siglaEstado;
	
	private Text txtNome;
	private Text txtTipoLogradouro;
	private Text txtLogradouro;
	private Text txtNumero;
	private Text txtComplemento;
	private Text txtBairro;
	private Text txtCep;
	private Text txtCidade;
	private Text txtTelefone;
	private Text txtSenha;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			alterarPessoa shell = new alterarPessoa(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public alterarPessoa(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Nome *");
		label.setBounds(0, 0, 55, 15);
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(0, 21, 255, 21);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Tipo de Logradouro");
		label_1.setBounds(0, 55, 110, 15);
		
		txtTipoLogradouro = new Text(this, SWT.BORDER);
		txtTipoLogradouro.setToolTipText("Ex: Av, Rua...");
		txtTipoLogradouro.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtTipoLogradouro.setBounds(0, 76, 78, 21);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Logradouro");
		label_2.setBounds(131, 55, 62, 15);
		
		txtLogradouro = new Text(this, SWT.BORDER);
		txtLogradouro.setBounds(131, 76, 176, 21);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Numero");
		label_3.setBounds(331, 55, 55, 15);
		
		txtNumero = new Text(this, SWT.BORDER);
		txtNumero.setBounds(331, 76, 76, 21);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Complemento");
		label_4.setBounds(0, 106, 78, 15);
		
		txtComplemento = new Text(this, SWT.BORDER);
		txtComplemento.setToolTipText("Ex: Casa, Ap...");
		txtComplemento.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtComplemento.setBounds(0, 127, 76, 21);
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setText("Bairro");
		label_5.setBounds(131, 106, 55, 15);
		
		txtBairro = new Text(this, SWT.BORDER);
		txtBairro.setBounds(131, 127, 110, 21);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setText("CEP");
		label_6.setBounds(276, 106, 55, 15);
		
		txtCep = new Text(this, SWT.BORDER);
		txtCep.setToolTipText("Ex: 13506-621");
		txtCep.setBounds(276, 127, 76, 21);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setText("Cidade");
		label_7.setBounds(0, 151, 55, 15);
		
		txtCidade = new Text(this, SWT.BORDER);
		txtCidade.setBounds(0, 172, 110, 21);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setText("Estado");
		label_8.setBounds(131, 151, 55, 15);
		
		Combo cmbEstado = new Combo(this, SWT.NONE);
		cmbEstado.setItems(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
		cmbEstado.setBounds(131, 172, 91, 23);
		cmbEstado.select(1);
		
		Label label_9 = new Label(this, SWT.NONE);
		label_9.setText("Data de Nascimento *");
		label_9.setBounds(0, 206, 130, 15);
		
		DateTime dateNascimento = new DateTime(this, SWT.BORDER);
		dateNascimento.setBounds(0, 227, 80, 24);
		
		Label label_10 = new Label(this, SWT.NONE);
		label_10.setText("Telefone *");
		label_10.setBounds(131, 258, 55, 15);
		
		txtTelefone = new Text(this, SWT.BORDER);
		txtTelefone.setToolTipText("DDD+N\u00DAMERO\r\nEx: 11999999999");
		txtTelefone.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtTelefone.setBounds(131, 279, 110, 21);
		
		Label label_11 = new Label(this, SWT.NONE);
		label_11.setText("G\u00EAnero");
		label_11.setBounds(276, 236, 55, 15);
		
		Button btnMasculino = new Button(this, SWT.RADIO);
		btnMasculino.setText("Masculino");
		btnMasculino.setBounds(276, 257, 90, 16);
		
		Button btnFeminino = new Button(this, SWT.RADIO);
		btnFeminino.setText("Feminino");
		btnFeminino.setBounds(276, 281, 90, 16);
		
		Label label_12 = new Label(this, SWT.NONE);
		label_12.setText("Senha *");
		label_12.setBounds(0, 258, 55, 15);
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setToolTipText("6 caracteres");
		txtSenha.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtSenha.setBounds(2, 279, 76, 21);
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					//EU EXCLUI PARA INSERIR DENOVO, DEPOIS, SE DER TEMPO, EU ARRUMO//
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telPessoa = bdLogin.getString("TELEFONE");
						break;
					}
					bdPessoa = pessoa.buscaDados(telPessoa);
					while(bdPessoa.first()){
						idPessoa = bdPessoa.getInt("PESSOAID");
						idEndereco = bdPessoa.getInt("ENDERECOID");
						break;
					}
					bdEndereco = endereco.buscaDados(idEndereco);
					while(bdEndereco.first()){
						idTipoLogradouro = bdEndereco.getInt("TIPOLOGRADOUROID");
						idCidade = bdEndereco.getInt("CIDADEID");
						break;
					}
					bdCidade = cidade.buscaDados(idCidade);
					while(bdCidade.first()){
						idEstado = bdCidade.getInt("ESTADOID");
						break;
					}
					nomePessoa = txtNome.getText();	
					if(nomePessoa == null){
						JOptionPane.showMessageDialog(null, "Favor inserir o nome.");
					}
					nomeTipoLogradouro = txtTipoLogradouro.getText();
					enderecoLogradouro = txtLogradouro.getText();
					enderecoNumero = Integer.parseInt(txtNumero.getText());				
					enderecoComplemento = txtComplemento.getText();
					bairro = txtBairro.getText();
					cep = txtCep.getText();
					nomeCidade = txtCidade.getText();
					siglaEstado = cmbEstado.getText();
					
					dia = dateNascimento.getDay();
					mes = dateNascimento.getMonth();
					ano = dateNascimento.getYear();
						nascimentoPessoa = ano + "-" + mes + "-" + dia;
						
					telPessoa = txtTelefone.getText();
					
					if (btnMasculino.getEnabled() == true){
						genPessoa = "M";
					}else{
						genPessoa = "F";
					}
					
					senhaPessoa = txtSenha.getText();		
					//******INSERINDO OS DADOS******//
					estado.insereDados(null , siglaEstado);
					idEstado = estado.buscaId(siglaEstado);
					cidade.insereDados(nomeCidade, idEstado);
					idCidade = cidade.buscaId(nomeCidade);
					tipoLogradouro.alteraDados(nomeTipoLogradouro, idTipoLogradouro);
					endereco.alteraDados(idTipoLogradouro, idCidade, enderecoLogradouro, enderecoNumero, enderecoComplemento, bairro, cep, idEndereco);
					pessoa.alteraDados(idEndereco, nomePessoa, nascimentoPessoa, telPessoa, genPessoa, senhaPessoa, idPessoa);
					//*****************************//
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				JOptionPane.showMessageDialog(null, "Dados alterados!!");
				dispose();
			}
		});
		btnOk.setBounds(359, 306, 75, 25);
		btnOk.setText("Ok");
		
		Button btnCancelar = new Button(this, SWT.NONE);
		btnCancelar.setBounds(0, 306, 75, 25);
		btnCancelar.setText("Cancelar");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 369);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
