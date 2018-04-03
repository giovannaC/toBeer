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
import controle.encontroControle;
import controle.enderecoControle;
import controle.estadoControle;
import controle.grupoControle;
import controle.pessoaControle;
import controle.procuraControle;
import controle.pubControle;
import controle.tipoLogradouroControle;
import controle.loginControle;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;


public class perfilPessoaPessoal extends Shell {
	
	private String args[] = {""};
		
	pessoaControle pessoa = new pessoaControle();
	enderecoControle endereco = new enderecoControle();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	cidadeControle cidade = new cidadeControle();
	estadoControle estado = new estadoControle();
	loginControle login = new loginControle();
	grupoControle grupo = new grupoControle();
	procuraControle procura = new procuraControle();
	encontroControle encontro = new encontroControle();
	pubControle bar = new pubControle();

	
	ResultSet bdPessoa;
	ResultSet bdEndereco;
	ResultSet bdTipoLogradouro;
	ResultSet bdEstado;
	ResultSet bdCidade;
	ResultSet bdLogin;
	ResultSet bdGrupo;
	ResultSet bdEncontro;
	ResultSet bdBar;
	
	public int idPessoa;
	public int idEndereco;
	public int idTipoLogradouro;
	public int idCidade;
	public int idEstado;
	public int idGrupo;
	public int idBar;
	public int idEncontro;

	public String nomePessoa = " ";
	public String telefonePessoa = " ";
	public String enderecoPessoa = " ";
	public String nascimentoPessoa = " ";
	public String genPessoa = " ";
	public String nomeEndereco = " ";
	public String tipoLogradouroNome = " ";
	public int numeroEndereco;
	public String enderecoComplemento = " ";
	public String enderecoBairro = " ";
	public String cidadeNome = " ";
	public String estadoSigla = " ";
	public String cep = " ";
	public String nomeGrupo = "";
	public String procuraGrupo;
	public String procuraBar;
	public String nomeBar = "";
	
	private Text txtProcuraGrupo;
	private Text txtProcuraBar;
	private Text txtGrupo;
	private Text txtEncontro;
	private Text txtNomeDoGrupo;
	private Text txtNomeDoBar;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			
			Display display = Display.getDefault();
			perfilPessoaPessoal shell = new perfilPessoaPessoal(display);
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
	public perfilPessoaPessoal(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setText(" ");
		lblNome.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		lblNome.setBounds(10, 24, 414, 28);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Grupos cadastrado");
		label_1.setBounds(10, 82, 106, 15);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Encontros marcados");
		label_2.setBounds(284, 82, 117, 15);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//se sair da conta ele exclui os dados de login
				login.excluiDados();
				dispose();
			}
		});
		button_2.setText("Sair da conta");
		button_2.setBounds(91, 490, 75, 25);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//entra na interface de alterar os dados da pessoa
				alterarPessoa.main(args);
			}
		});
		button_3.setText("Alterar dados");
		button_3.setBounds(10, 490, 75, 25);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// exclui a conta da pessoa
				try{
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telefonePessoa = bdLogin.getString("TELEFONE");
						break;
					}
					bdPessoa = pessoa.buscaDados(telefonePessoa);
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
					tipoLogradouro.excluiDados(idTipoLogradouro);
					cidade.excluiDados(idCidade);
					estado.excluiDados(idEstado);
					endereco.excluiDados(idEndereco);
					pessoa.excluiDados(idPessoa);
					JOptionPane.showMessageDialog(null, "Conta excluida!!");
					login.excluiDados();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_4.setText("Excluir conta");
		button_4.setBounds(172, 490, 75, 25);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Dados da conta");
		label_3.setBounds(10, 356, 90, 15);
		
		txtProcuraGrupo = new Text(this, SWT.BORDER);
		txtProcuraGrupo.setToolTipText("Pesquisar um grupo pelo nome");
		txtProcuraGrupo.setBounds(10, 287, 126, 21);
				
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//procura o grupo pelo nome
				procuraGrupo = txtProcuraGrupo.getText();
				procura.insereDados(null, procuraGrupo);
				perfilGrupo.main(args);
			}
		});
		btnOk.setText("Ok");
		btnOk.setBounds(142, 285, 27, 25);
		
		Button btnProcurarBar = new Button(this, SWT.NONE);
		btnProcurarBar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//procura o bar pelo nome
				procuraBar = txtProcuraBar.getText();
				procura.insereDados(procuraBar, null);
				perfilBarPublico.main(args);
			}
		});
		btnProcurarBar.setText("Ok");
		btnProcurarBar.setBounds(407, 285, 27, 24);
		
		Label lblEndereco = new Label(this, SWT.NONE);
		lblEndereco.setText(" ");
		lblEndereco.setBounds(10, 377, 391, 15);
		
		Label lblTelefone = new Label(this, SWT.NONE);
		lblTelefone.setText(" ");
		lblTelefone.setBounds(10, 398, 315, 15);
		
		Label lblNascimento = new Label(this, SWT.NONE);
		lblNascimento.setText(" ");
		lblNascimento.setBounds(10, 419, 209, 15);
		
		Label lblGenero = new Label(this, SWT.NONE);
		lblGenero.setText(" ");
		lblGenero.setBounds(10, 440, 218, 15);
		
		Button btnSair = new Button(this, SWT.NONE);
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				login.excluiDados();
				dispose();
			}
		});
		btnSair.setBounds(359, 490, 75, 25);
		btnSair.setText("Sair");
		
		
		Button btnCadastrarNovoGrupo = new Button(this, SWT.NONE);
		btnCadastrarNovoGrupo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cadastroGrupo.main(args);
			}
		});
		btnCadastrarNovoGrupo.setBounds(10, 325, 142, 25);
		btnCadastrarNovoGrupo.setText("Cadastrar novo grupo");
		
		txtProcuraBar = new Text(this, SWT.BORDER);
		txtProcuraBar.setToolTipText("Procurar um bar pelo nome");
		txtProcuraBar.setBounds(284, 287, 117, 21);
		
		Label lblProcurarBar = new Label(this, SWT.NONE);
		lblProcurarBar.setBounds(284, 266, 75, 15);
		lblProcurarBar.setText("Procurar bar:");
		
		Label lblProcurarGrupo = new Label(this, SWT.NONE);
		lblProcurarGrupo.setBounds(10, 266, 90, 15);
		lblProcurarGrupo.setText("Procurar grupo:");
		
		txtGrupo = new Text(this, SWT.READ_ONLY | SWT.WRAP);
		txtGrupo.setBounds(10, 103, 106, 87);
		
		txtEncontro = new Text(this, SWT.READ_ONLY | SWT.WRAP);
		txtEncontro.setBounds(284, 103, 106, 87);
		
		Label lblSairDoGrupo = new Label(this, SWT.NONE);
		lblSairDoGrupo.setBounds(10, 196, 75, 15);
		lblSairDoGrupo.setText("Sair do grupo:");
		
		txtNomeDoGrupo = new Text(this, SWT.BORDER);
		txtNomeDoGrupo.setToolTipText("Nome do grupo");
		txtNomeDoGrupo.setBounds(9, 217, 107, 21);
		
		Button btnSairGrupo = new Button(this, SWT.NONE);
		btnSairGrupo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// essa parte não lembro se eu testei, ela procura o nome do grupo para sair do grupo.
				nomeGrupo = txtNomeDoGrupo.getText();
				if(nomeGrupo != null){
					bdGrupo = grupo.buscaDados(nomeGrupo);
					try {
						while(bdGrupo.first()){
							idGrupo = bdGrupo.getInt("GRUPOID");
							break;
						}
						grupo.excluiDados(idGrupo);
						JOptionPane.showMessageDialog(null, "Você saiu o grupo "+ nomeGrupo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Você nao saiu o grupo, "+ e1.getMessage());
					}
				}else{
					JOptionPane.showMessageDialog(null, "Nome do grupo null!!");
				}
			}
		});
		btnSairGrupo.setBounds(122, 217, 31, 25);
		btnSairGrupo.setText("Sair");
		
		Label lblCancelarEncontro = new Label(this, SWT.NONE);
		lblCancelarEncontro.setBounds(284, 196, 106, 15);
		lblCancelarEncontro.setText("Cancelar encontro:\r\n");
		
		txtNomeDoBar = new Text(this, SWT.BORDER);
		txtNomeDoBar.setToolTipText("Nome do bar");
		txtNomeDoBar.setBounds(284, 217, 106, 21);
		
		Button btnSairBar = new Button(this, SWT.NONE);
		btnSairBar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Essa parte não lembro de ter testado, mas acho que está funcionando
				// Ela procura o nome do bar para desmarcar o encontro.
				nomeBar = txtNomeDoBar.getText();
				if(nomeBar != null){
					bdBar = bar.buscaDadosNome(nomeBar);
					try {
						while(bdBar.first()){
							idBar = bdBar.getInt("BARID");
							break;
						}
					bdEncontro = encontro.buscaDadosBar(idBar);
					while(bdEncontro.first()){
						idEncontro = bdEncontro.getInt("ENCONTROID");
						break;
					}
					encontro.excluiDados(idEncontro);
					JOptionPane.showMessageDialog(null, "Você desmarcou o encontro no bar "+ nomeBar);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Você nao desmarcou o encontro, "+ e1.getMessage());
					}
				}
			}
		});
		btnSairBar.setBounds(396, 215, 41, 25);
		btnSairBar.setText("Sair");
		
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				// Quando entra no perfil, ele pega as informações de login e puxa os dados do usuário para mostrar na tela
				try{
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telefonePessoa = bdLogin.getString("TELEFONE");
						lblTelefone.setText(telefonePessoa);
						//JOptionPane.showMessageDialog(null, "PEGUEI O TELEFONE");
						break;
					}
					//JOptionPane.showMessageDialog(null, "QUERO PEGAR O BDPESSOA");
					bdPessoa = pessoa.buscaDados(telefonePessoa);
					//JOptionPane.showMessageDialog(null, "PEGUEI O BDPESSOA");
					while(bdPessoa.first()){
						idPessoa = bdPessoa.getInt("PESSOAID");
						//JOptionPane.showMessageDialog(null, "ENTREI NO WHILE");
						nomePessoa = bdPessoa.getString("PESSOANOME");
						lblNome.setText(nomePessoa);
						nascimentoPessoa = bdPessoa.getString("PESSOADATANASCIMENTO");
						lblNascimento.setText(nascimentoPessoa);
						genPessoa = bdPessoa.getString("PESSOAGENERO");
						lblGenero.setText(genPessoa);
						idEndereco = bdPessoa.getInt("ENDERECOID");
						break;
					}
					bdEndereco = endereco.buscaDados(idEndereco);
					while(bdEndereco.first()){
						idTipoLogradouro = bdEndereco.getInt("TIPOLOGRADOUROID");
						idCidade = bdEndereco.getInt("CIDADEID");
						nomeEndereco = bdEndereco.getString("ENDERECOLOGRADOURO");
						numeroEndereco = bdEndereco.getInt("ENDERECONUMERO");
						enderecoBairro = bdEndereco.getString("ENDERECOBAIRRO");
						enderecoComplemento = bdEndereco.getString("ENDERECOCOMPLEMENTO");
						cep = bdEndereco.getString("ENDERECOCEP");
						break;
					}
					bdTipoLogradouro = tipoLogradouro.buscaDados(idTipoLogradouro);
					while(bdTipoLogradouro.first()){
						tipoLogradouroNome = bdTipoLogradouro.getString("TIPOLOGRADOURONOME");
						break;
					}
					bdCidade = cidade.buscaDados(idCidade);
					while(bdCidade.first()){
						idEstado = bdCidade.getInt("ESTADOID");
						cidadeNome = bdCidade.getString("CIDADENOME");
						break;
					}
					bdEstado = estado.buscaDados(idEstado);
					while(bdEstado.first()){
						estadoSigla = bdEstado.getString("ESTADOSIGLA");
						break;
					}
					bdEncontro = encontro.buscaDadosPessoa(idPessoa);
					while(bdEncontro.first()){
						do{
							System.out.println("ENTREI NO WHILE2");
							idBar = bdEncontro.getInt("BARID");
							bdBar = bar.buscaDadosId(idBar);
							while(bdBar.first()){
								nomeBar = nomeBar + bdBar.getString("BARNOME") + "\n";
								break;
							}
						}while(bdEncontro.next());
						break;
					}
					bdGrupo = grupo.buscaDadosPessoa(idPessoa);
					while(bdGrupo.first()){
						System.out.println("ENTRO NO WHILE");
						do{
							System.out.println("ENTRO NO WHILE2");
							if(bdGrupo.getString("GRUPONOME") != null){
							nomeGrupo = nomeGrupo + bdGrupo.getString("GRUPONOME") + "\n";
							}else{
								break;
							}
							
						}while(bdGrupo.next());
						
						break;
					}
					enderecoPessoa = tipoLogradouroNome + " " + nomeEndereco + ", " + numeroEndereco + " " + enderecoComplemento + ", " + 
							enderecoBairro + ", " + cidadeNome + " - " + estadoSigla + " " + cep;
					lblEndereco.setText(enderecoPessoa);
					
					txtGrupo.setText(nomeGrupo);
					txtEncontro.setText(nomeBar);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			@Override
			public void shellClosed(ShellEvent e) {
				//quando fecha a janela, ele apaga os dados de login da pessoa
				login.excluiDados();
			}
			@Override
			public void shellDeactivated(ShellEvent e) {
				// aqui é para evitar a repeição do grupo e do bar na tela de perfil, toda hora que ela é desfocada e focada
				nomeGrupo = "";
				nomeBar = "";
			}
		});
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(472, 596);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
