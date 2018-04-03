package view;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;

import controle.*;
//import classes.*; // nao usei class e acho

public class cadastroPessoa extends Shell {
	
	private String args[] = {""};

	estadoControle estado = new estadoControle();
	classes.estado estadoClass = new classes.estado();
	cidadeControle cidade = new cidadeControle();
	classes.cidade cidadeClass = new classes.cidade();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	classes.tipoLogradouro tipoLogradouroClass = new classes.tipoLogradouro();
	enderecoControle endereco = new enderecoControle();
	classes.endereco enderecoClass = new classes.endereco();
	pessoaControle pessoa = new pessoaControle ();
	
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
	public int idEstado;
	public int idCidade;
	public int idEndereco;
	public int idTipoLogradouro;
	
	private Text txtNome;
	private Text txtTipoLogradouro;
	private Text txtLogradouro;
	private Text txtNumero;
	private Text txtComplemento;
	private Text txtBairro;
	private Text txtCep;
	private Text txtTelefone;
	private Text txtSenha;
	private Text txtCidade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			cadastroPessoa shell = new cadastroPessoa(display);
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
	public cadastroPessoa(Display display) {
		super(display, SWT.SHELL_TRIM);
		setSize(450, 401);
		
		Label lblError2 = new Label(this, SWT.NONE);
		lblError2.setEnabled(false);
		lblError2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblError2.setBounds(141, 216, 186, 15);
		lblError2.setText("Proibido para menores de 18 anos");
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setText("Nome *");
		lblNome.setBounds(10, 10, 55, 15);
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 31, 255, 21);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Tipo de Logradouro");
		label_1.setBounds(10, 65, 110, 15);
		
		txtTipoLogradouro = new Text(this, SWT.BORDER);
		txtTipoLogradouro.setToolTipText("Ex: Av, Rua...");
		txtTipoLogradouro.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtTipoLogradouro.setBounds(10, 86, 78, 21);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Logradouro");
		label_2.setBounds(141, 65, 62, 15);
		
		txtLogradouro = new Text(this, SWT.BORDER);
		txtLogradouro.setBounds(141, 86, 176, 21);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Numero");
		label_3.setBounds(341, 65, 55, 15);
		
		txtNumero = new Text(this, SWT.BORDER);
		txtNumero.setBounds(341, 86, 76, 21);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Complemento");
		label_4.setBounds(10, 116, 78, 15);
		
		txtComplemento = new Text(this, SWT.BORDER);
		txtComplemento.setToolTipText("Ex: Casa, Ap...");
		txtComplemento.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtComplemento.setBounds(10, 137, 76, 21);
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setText("Bairro");
		label_5.setBounds(141, 116, 55, 15);
		
		txtBairro = new Text(this, SWT.BORDER);
		txtBairro.setBounds(141, 137, 110, 21);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setText("CEP");
		label_6.setBounds(286, 116, 55, 15);
		
		txtCep = new Text(this, SWT.BORDER);
		txtCep.setToolTipText("Ex: 13506-621");
		txtCep.setBounds(286, 137, 76, 21);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setText("Cidade");
		label_7.setBounds(10, 161, 55, 15);
		
		txtCidade = new Text(this, SWT.BORDER);
		txtCidade.setBounds(10, 182, 110, 21);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setText("Estado");
		label_8.setBounds(141, 161, 55, 15);
		
		Combo cmbEstado = new Combo(this, SWT.NONE);
		cmbEstado.setItems(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
		cmbEstado.setBounds(141, 182, 91, 23);
		cmbEstado.select(1);
		
		Label lblDataDeNascimento = new Label(this, SWT.NONE);
		lblDataDeNascimento.setBounds(10, 216, 130, 15);
		lblDataDeNascimento.setText("Data de Nascimento *");
		
		DateTime dateNascimento = new DateTime(this, SWT.BORDER);
		dateNascimento.setBounds(10, 237, 80, 24);
		
		Label lblTelefone = new Label(this, SWT.NONE);
		lblTelefone.setBounds(141, 268, 55, 15);
		lblTelefone.setText("Telefone *");
		
		txtTelefone = new Text(this, SWT.BORDER);
		txtTelefone.setToolTipText("DDD+N\u00DAMERO\r\nEx: 11999999999");
		txtTelefone.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtTelefone.setBounds(141, 289, 110, 21);
		
		Label lblGnero = new Label(this, SWT.NONE);
		lblGnero.setBounds(286, 246, 55, 15);
		lblGnero.setText("G\u00EAnero");
		
		Button btnMasculino = new Button(this, SWT.RADIO);
		btnMasculino.setBounds(286, 267, 90, 16);
		btnMasculino.setText("Masculino");
		
		Button btnFeminino = new Button(this, SWT.RADIO);
		btnFeminino.setBounds(286, 291, 90, 16);
		btnFeminino.setText("Feminino");
		
		Label lblSenha = new Label(this, SWT.NONE);
		lblSenha.setBounds(10, 268, 55, 15);
		lblSenha.setText("Senha *");
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setToolTipText("6 caracteres");
		txtSenha.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtSenha.setBounds(12, 289, 76, 21);
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				cadastro.main(args);
			}
		});
		btnVoltar.setBounds(10, 327, 75, 25);
		btnVoltar.setText("Voltar");
		
		
		Button btnSalvar = new Button(this, SWT.NONE);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//SE FOR PRESSIONADO O BOTÃO SALVAR ELE PEGA TODOS OS CONETUDOS DOS TEXTOS, GRAVA EM VARIÁVEIS E INSERE NO BANCO DE DADOS
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
				
				if (btnMasculino.getSelection() == true){
					genPessoa = "M";
				}else{
					genPessoa = "F";
				}
				
				senhaPessoa = txtSenha.getText();		
				
				
				
				// **************** inserer no BD ****************
				estado.insereDados(null , siglaEstado);
				idEstado = estado.buscaId(siglaEstado);
				cidade.insereDados(nomeCidade, idEstado);
				idCidade = cidade.buscaId(nomeCidade);
				tipoLogradouro.insereDados(nomeTipoLogradouro);
				idTipoLogradouro = tipoLogradouro.buscaId(nomeTipoLogradouro);
				endereco.insereDados(idTipoLogradouro, idCidade, enderecoLogradouro, enderecoNumero, enderecoComplemento, bairro, cep);
				idEndereco = endereco.buscaId(enderecoLogradouro);
				pessoa.insereDados(idEndereco, nomePessoa, nascimentoPessoa, telPessoa, genPessoa, senhaPessoa);
				//************************************************
				dispose();
				JOptionPane.showMessageDialog(null, "Cadastro salvo!!");
				
				
			}
		});
		btnSalvar.setBounds(342, 327, 75, 25);
		btnSalvar.setText("Salvar");
		
		Label lblCamposObrigatrios = new Label(this, SWT.NONE);
		lblCamposObrigatrios.setBounds(188, 332, 153, 15);
		lblCamposObrigatrios.setText("* Campos obrigat\u00F3rios");
		

	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 342);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
