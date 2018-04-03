package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controle.encontroControle;
import controle.grupoControle;
import controle.loginControle;
import controle.pessoaControle;
import controle.pubControle;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

public class cadastroGrupo extends Shell {
	//private String args[] = {""};

	grupoControle grupo = new grupoControle();
	pessoaControle pessoa = new pessoaControle ();
	loginControle login = new loginControle();
	pubControle bar = new pubControle();
	encontroControle encontro = new encontroControle();
	
	ResultSet bdPessoa;
	ResultSet bdLogin;
	ResultSet bdBar;
	ResultSet bdGrupo;
	
	public String telPessoa;
	
	public String nomeGrupo;
	public String senhaGrupo;
	public int idGrupo;
	public int idPessoa;
	public int idBar;
	public int maximoBar;
	public String barHorario;
		public int hora;
		public int minuto;
		public int segundo;
	public String barNome;
	public String dirigir;
		
	private Text txtGrupo;
	private Text txtSenha;
	private Text nroMaximoBar;
	private Text txtBar;
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			cadastroGrupo shell = new cadastroGrupo(display);
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
	public cadastroGrupo(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		txtGrupo = new Text(this, SWT.BORDER);
		txtGrupo.setBounds(10, 31, 278, 21);
		
		Label lblNomeGrupo = new Label(this, SWT.NONE);
		lblNomeGrupo.setBounds(10, 10, 77, 15);
		lblNomeGrupo.setText("Nome Grupo");
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setBounds(10, 79, 148, 21);
		
		Label lblSenha = new Label(this, SWT.NONE);
		lblSenha.setBounds(10, 58, 55, 15);
		lblSenha.setText("Senha");
		
		nroMaximoBar = new Text(this, SWT.BORDER);
		nroMaximoBar.setBounds(173, 112, 45, 21);
		
		Label lblNoMaximo = new Label(this, SWT.NONE);
		lblNoMaximo.setText("N\u00BA Max de Pessoas no Grupo");
		lblNoMaximo.setBounds(10, 115, 157, 15);
		
		Label lblH = new Label(this, SWT.NONE);
		lblH.setText("Hor\u00E1rio");
		lblH.setBounds(10, 153, 45, 15);
	
		DateTime dateTime = new DateTime(this, SWT.BORDER | SWT.TIME);
		dateTime.setBounds(61, 144, 80, 24);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Bar de encontro");
		label.setBounds(10, 192, 95, 15);
		
		txtBar = new Text(this, SWT.BORDER);
		txtBar.setBounds(10, 216, 131, 21);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Vai dirigir?");
		label_1.setBounds(201, 192, 55, 15);
		
		Button btnSim = new Button(this, SWT.RADIO);
		btnSim.setText("Sim");
		btnSim.setBounds(202, 218, 45, 16);
		
		Button btnNao = new Button(this, SWT.RADIO);
		btnNao.setText("N\u00E3o");
		btnNao.setBounds(248, 218, 45, 16);
		
		Button btnSalvar = new Button(this, SWT.NONE);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//SE FOR PRESSIONADO O BOTÃO SALVAR ELE PEGA TODOS OS CONETUDOS DOS TEXTOS, GRAVA EM VARIÁVEIS E INSERE NO BANCO DE DADOS
				try {
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telPessoa = bdLogin.getString("TELEFONE");
						break;
					}
					bdPessoa = pessoa.buscaDados(telPessoa);
					while(bdPessoa.first()){
						idPessoa = bdPessoa.getInt("PESSOAID");
						break;
					}
					nomeGrupo = txtGrupo.getText();
					maximoBar = Integer.parseInt(nroMaximoBar.getText());
					senhaGrupo = txtSenha.getText();
					hora = dateTime.getHours();
					minuto = dateTime.getMinutes();
					segundo = dateTime.getSeconds();
							barHorario = hora + ":" + minuto + ":" + segundo;
					barNome = txtBar.getText();
					idBar = bar.buscaId(barNome);
					if(btnSim.getSelection() == true){
						dirigir = "S";
					}else{
						dirigir = "N";
					}
					// **************** inserir no BD ****************
					grupo.insereDados(idPessoa, idBar, nomeGrupo, senhaGrupo, maximoBar, barHorario);
					bdGrupo = grupo.buscaDados(nomeGrupo);
					while(bdGrupo.first()){
						idGrupo = bdGrupo.getInt("GRUPOID");
						break;
					}
					
					encontro.insereDados(idBar, idPessoa, idGrupo, barHorario, null, dirigir);
					//************************************************
					JOptionPane.showMessageDialog(null, "Grupo cadastrado!!");
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Grupo não cadastrado, erro: " + e1.getMessage());
				}
				
			}
		});		
		btnSalvar.setBounds(213, 277, 75, 25);
		btnSalvar.setText("Salvar");
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(12, 277, 75, 25);
		btnVoltar.setText("Voltar");
		

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(459, 370);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}