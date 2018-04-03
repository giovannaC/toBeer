package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import controle.encontroControle;
import controle.grupoControle;
import controle.loginControle;
import controle.pessoaControle;
import controle.procuraControle;
import controle.pubControle;

import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class perfilGrupo extends Shell {
	
	pubControle bar = new pubControle();
	grupoControle grupo = new grupoControle();
	procuraControle procura = new procuraControle();
	loginControle login = new loginControle();
	pessoaControle pessoa = new pessoaControle();
	encontroControle encontro = new encontroControle();
	
	ResultSet bdGrupo;
	ResultSet bdProcura;
	ResultSet bdBar;
	ResultSet bdLogin;
	ResultSet bdPessoa;
	
	public String nomeBar;
	public String nomeGrupo;
	public String horaEncontro;
	public int maxGrupo;
	public String senhaGrupo;
	public String telPessoa;
	public String nomePessoa = "";
	
	public int idGrupo;
	public int idBar;
	public int idPessoa;
	
	
	private Text txtSenha;
	private Text txtMembros;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			perfilGrupo shell = new perfilGrupo(display);
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
	public perfilGrupo(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNomeDoBar = new Label(this, SWT.NONE);
		lblNomeDoBar.setBounds(10, 41, 140, 15);
		lblNomeDoBar.setText("Nome do bar de encontro:");
		
		Label lblNomeBar = new Label(this, SWT.NONE);
		lblNomeBar.setBounds(156, 41, 55, 15);
		lblNomeBar.setText("New Label");
		
		Label lblNomeDoGrupo = new Label(this, SWT.NONE);
		lblNomeDoGrupo.setBounds(10, 10, 94, 15);
		lblNomeDoGrupo.setText("Nome do grupo:");
		
		Label lblNomeGrupo = new Label(this, SWT.NONE);
		lblNomeGrupo.setBounds(106, 10, 55, 15);
		lblNomeGrupo.setText("New Label");
		
		Label lblHoraDoEncontro = new Label(this, SWT.NONE);
		lblHoraDoEncontro.setBounds(10, 73, 151, 15);
		lblHoraDoEncontro.setText("Hora do encontro do grupo:");
		
		Label lblGrupoHorario = new Label(this, SWT.NONE);
		lblGrupoHorario.setBounds(167, 73, 55, 15);
		lblGrupoHorario.setText("New Label");
		
		Label lblMximoDePessoas = new Label(this, SWT.NONE);
		lblMximoDePessoas.setBounds(10, 101, 222, 15);
		lblMximoDePessoas.setText("M\u00E1ximo de pessoas permitidas no grupo:");
		
		Label lblGrupoMax = new Label(this, SWT.NONE);
		lblGrupoMax.setBounds(236, 101, 55, 15);
		lblGrupoMax.setText("New Label");
		
		Label lblEntrarNoGrupo = new Label(this, SWT.NONE);
		lblEntrarNoGrupo.setBounds(10, 134, 94, 15);
		lblEntrarNoGrupo.setText("Entrar no grupo?");
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setToolTipText("Se n\u00E3o houver senha deixe em branco");
		txtSenha.setBounds(10, 206, 76, 21);
		
		Label lblSenha = new Label(this, SWT.NONE);
		lblSenha.setBounds(10, 183, 55, 15);
		lblSenha.setText("Senha");
		
		Button btnSim = new Button(this, SWT.RADIO);
		btnSim.setSelection(true);
		btnSim.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtSenha.setEnabled(true);
			}
		});
		btnSim.setBounds(10, 161, 41, 16);
		btnSim.setText("Sim");
		
		Button btnNao = new Button(this, SWT.RADIO);
		btnNao.setBounds(57, 161, 41, 16);
		btnNao.setText("N\u00E3o");
		
		txtMembros = new Text(this, SWT.READ_ONLY | SWT.WRAP);
		txtMembros.setBounds(318, 38, 106, 111);
		
		
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				procura.excluiDados();
				System.out.println("procura excluido!");
				dispose();
			}
		});
		btnVoltar.setBounds(10, 237, 75, 25);
		btnVoltar.setText("Voltar");
		
		
		
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				bdProcura = procura.buscaDados();
				try {
					while(bdProcura.first()){
						nomeGrupo = bdProcura.getString("PROCURAGRUPO");
						lblNomeGrupo.setText(nomeGrupo);
						break;
					}
					bdGrupo = grupo.buscaDados(nomeGrupo);
					while(bdGrupo.first()){
						idGrupo = bdGrupo.getInt("GRUPOID");
						idBar= bdGrupo.getInt("BARID");
						maxGrupo = bdGrupo.getInt("GRUPOMAX");
						lblGrupoMax.setText(Integer.toString(maxGrupo));	
						horaEncontro = bdGrupo.getString("GRUPOHORARIO");
						lblGrupoHorario.setText(horaEncontro);
						do{
							idPessoa = bdGrupo.getInt("PESSOAID");
							bdPessoa = pessoa.buscaDados(idPessoa);
							while(bdPessoa.first()){
								nomePessoa = nomePessoa + bdPessoa.getString("PESSOANOME") + "\n";
								break;
							}
						}while(bdGrupo.next());
						break;
					}
					bdBar = bar.buscaDadosNome(nomeBar);
					while(bdBar.first()){
						nomeBar = bdBar.getString("BARNOME");
						lblNomeBar.setText(nomeBar);
						break;
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void shellClosed(ShellEvent e) {
				procura.excluiDados();
				System.out.println("procura excluido!");
				dispose();
			}
		});
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnSim.getSelection() == true){
					senhaGrupo = txtSenha.getText();
					bdLogin = login.buscaDados();
					try {
						while(bdLogin.first()){
							telPessoa = bdLogin.getString("TELEFONE");
							break;
						}
						bdPessoa = pessoa.buscaDados(telPessoa);
						while(bdPessoa.first()){
							idPessoa = bdPessoa.getInt("PESSOAID");
							break;
						}
						bdProcura = procura.buscaDados();
						while(bdProcura.first()){
							nomeGrupo = bdProcura.getString("PROCURAGRUPO");
							lblNomeGrupo.setText(nomeGrupo);
							break;
						}
						bdGrupo = grupo.buscaDados(nomeGrupo);
						while(bdGrupo.first()){
							if(senhaGrupo.equals(bdGrupo.getString("GRUPOSENHA")) ){
								grupo.insereDados(idPessoa, idBar, nomeGrupo, senhaGrupo, maxGrupo, horaEncontro);
								encontro.insereDados(idBar, idPessoa, idGrupo, horaEncontro, null, null);
								JOptionPane.showMessageDialog(null, "Você entrou no grupo " + nomeGrupo);
								procura.excluiDados();
								dispose();							
							}else{
								JOptionPane.showMessageDialog(null, "SENHA INCORRETA!!");
							}
							break;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else{
					System.out.println("nao esta participando do grupo!");
					procura.excluiDados();
					dispose();
				}
			}
		});
		btnOk.setBounds(349, 237, 75, 25);
		btnOk.setText("Ok");
		
		Label lblMembros = new Label(this, SWT.NONE);
		lblMembros.setBounds(318, 17, 55, 15);
		lblMembros.setText("Membros");
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 311);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
