package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import controle.cidadeControle;
import controle.enderecoControle;
import controle.estadoControle;
import controle.loginControle;
import controle.pubControle;
import controle.tipoLogradouroControle;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class perfilBarPessoal extends Shell {
	
	private String args[] = {""};
	
	estadoControle estado = new estadoControle();
	cidadeControle cidade = new cidadeControle();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	enderecoControle endereco = new enderecoControle();
	pubControle bar = new pubControle();
	loginControle login = new loginControle();
	
	ResultSet bdEstado;
	ResultSet bdCidade;
	ResultSet bdTipoLogradouro;
	ResultSet bdEndereco;
	ResultSet bdBar;
	ResultSet bdLogin;
	
	public String nomeBar;
	public String openBar;
		int openHora;
		int openMin;
		int openSec;
	public String closeBar;
		int closeHora;
		int closeMin;
		int closeSec;
	public String descricaoBar;
	public float classBar;
	public String telefoneBar;
	public String senhaBar;
	public String enderecoBar;
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
	public int idBar;
	
	private Text txtDescricao;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			perfilBarPessoal shell = new perfilBarPessoal(display);
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
	public perfilBarPessoal(Display display) {
		super(display, SWT.SHELL_TRIM | SWT.BORDER);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setText("ERROR");
		lblNome.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		lblNome.setBounds(10, 10, 414, 28);
		
		Button btnSairDaConta = new Button(this, SWT.NONE);
		btnSairDaConta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				login.excluiDados();
				dispose();
			}
		});
		btnSairDaConta.setBounds(10, 301, 75, 25);
		btnSairDaConta.setText("Sair da conta");
		
		Button btnAlterarDados = new Button(this, SWT.NONE);
		btnAlterarDados.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				alterarBar.main(args);
			}
		});
		btnAlterarDados.setBounds(91, 301, 75, 25);
		btnAlterarDados.setText("Alterar dados");
		
		Button btnExcluirConta = new Button(this, SWT.NONE);
		btnExcluirConta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try{
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telefoneBar = bdLogin.getString("TELEFONE");
						break;
					}
					bdBar = bar.buscaDados(telefoneBar);
					while(bdBar.first()){
						idBar = bdBar.getInt("BARID");
						idEndereco = bdBar.getInt("ENDERECOID");
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
					tipoLogradouro.excluiDados(idTipoLogradouro);
					cidade.excluiDados(idCidade);
					estado.excluiDados(idEstado);
					endereco.excluiDados(idEndereco);
					bar.excluiDados(idBar);
					JOptionPane.showMessageDialog(null, "Conta excluida!!");
					login.excluiDados();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluirConta.setBounds(172, 301, 75, 25);
		btnExcluirConta.setText("Excluir conta");
		
		Button btnSair = new Button(this, SWT.NONE);
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				login.excluiDados();
				dispose();
			}
		});
		btnSair.setBounds(349, 301, 75, 25);
		btnSair.setText("Sair");
		
		Label lblDadosDoBar = new Label(this, SWT.NONE);
		lblDadosDoBar.setBounds(10, 44, 83, 15);
		lblDadosDoBar.setText("Dados do bar:");
		
		Label lblEndereco = new Label(this, SWT.NONE);
		lblEndereco.setBounds(10, 65, 228, 15);
		lblEndereco.setText("Endereco");
		
		Label lblOpen = new Label(this, SWT.NONE);
		lblOpen.setBounds(54, 86, 102, 15);
		lblOpen.setText("Horario de Abrir");
		
		Label lblClose = new Label(this, SWT.NONE);
		lblClose.setBounds(54, 107, 102, 15);
		lblClose.setText("Horario de Fechar");
		
		Label lblAbre = new Label(this, SWT.NONE);
		lblAbre.setBounds(10, 86, 38, 15);
		lblAbre.setText("Abre:");
		
		Label lblFecha = new Label(this, SWT.NONE);
		lblFecha.setBounds(10, 111, 38, 15);
		lblFecha.setText("Fecha:");
		
		Label lblDescriaco = new Label(this, SWT.NONE);
		lblDescriaco.setBounds(10, 150, 55, 15);
		lblDescriaco.setText("Descri\u00E7ao:");
		
		txtDescricao = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.MULTI);
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(10, 171, 414, 87);

		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				try {
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telefoneBar = bdLogin.getString("TELEFONE");
						break;
					}
					bdBar = bar.buscaDados(telefoneBar);
					while(bdBar.first()){
						nomeBar = bdBar.getString("BARNOME");
						openBar = bdBar.getString("BAROPEN");
						closeBar = bdBar.getString("BARCLOSE");
						descricaoBar = bdBar.getString("BARDESCRICAO");
						idEndereco = bdBar.getInt("ENDERECOID");
						break;
					}
					bdEndereco = endereco.buscaDados(idEndereco);
					while(bdEndereco.first()){
						idTipoLogradouro = bdEndereco.getInt("TIPOLOGRADOUROID");
						idCidade = bdEndereco.getInt("CIDADEID");
						enderecoLogradouro = bdEndereco.getString("ENDERECOLOGRADOURO");
						enderecoNumero = bdEndereco.getInt("ENDERECONUMERO");
						bairro = bdEndereco.getString("ENDERECOBAIRRO");
						enderecoComplemento = bdEndereco.getString("ENDERECOCOMPLEMENTO");
						cep = bdEndereco.getString("ENDERECOCEP");
						break;
					}
					bdTipoLogradouro = tipoLogradouro.buscaDados(idTipoLogradouro);
					while(bdTipoLogradouro.first()){
						nomeTipoLogradouro = bdTipoLogradouro.getString("TIPOLOGRADOURONOME");
						break;
					}
					bdCidade = cidade.buscaDados(idCidade);
					while(bdCidade.first()){
						idEstado = bdCidade.getInt("ESTADOID");
						nomeCidade = bdCidade.getString("CIDADENOME");
						break;
					}
					bdEstado = estado.buscaDados(idEstado);
					while(bdEstado.first()){
						siglaEstado = bdEstado.getString("ESTADOSIGLA");
						break;
					}
					
					lblNome.setText(nomeBar);
					enderecoBar = nomeTipoLogradouro + " " + enderecoLogradouro + ", " + enderecoNumero + " " + enderecoComplemento + ", " + 
							bairro + ", " + nomeCidade + " - " + siglaEstado + " " + cep;
					lblEndereco.setText(enderecoBar);
					lblOpen.setText(openBar);
					lblClose.setText(closeBar);
					txtDescricao.setText(descricaoBar);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void shellClosed(ShellEvent e) {
				login.excluiDados();
				dispose();
			}
		});
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 367);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
