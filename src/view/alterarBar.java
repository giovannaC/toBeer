package view;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import controle.cidadeControle;
import controle.enderecoControle;
import controle.estadoControle;
import controle.loginControle;
import controle.pubControle;
import controle.tipoLogradouroControle;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class alterarBar extends Shell {
	
	//private String args[] = {""};
	
	estadoControle estado = new estadoControle();
	cidadeControle cidade = new cidadeControle();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	enderecoControle endereco = new enderecoControle();
	pubControle bar = new pubControle();
	loginControle login = new loginControle();
	
	ResultSet bdEndereco;
	ResultSet bdTipoLogradouro;
	ResultSet bdEstado;
	ResultSet bdCidade;
	ResultSet bdLogin;
	ResultSet bdBar;
	
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
	
	private Text txtNome;
	private Text txtTipoLogradouro;
	private Text txtEnderecoLogradouro;
	private Text txtNumero;
	private Text txtComplemento;
	private Text txtBairro;
	private Text txtCep;
	private Text txtDescricao;
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
			alterarBar shell = new alterarBar(display);
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
	public alterarBar(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Nome");
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
		
		txtEnderecoLogradouro = new Text(this, SWT.BORDER);
		txtEnderecoLogradouro.setBounds(141, 76, 176, 21);
		
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
		label_7.setText("Hora de Funcionamento");
		label_7.setBounds(0, 237, 129, 15);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setText("Breve Descri\u00E7\u00E3o");
		label_8.setBounds(173, 279, 94, 15);
		
		txtDescricao = new Text(this, SWT.BORDER);
		txtDescricao.setToolTipText("M\u00E1ximo 300 caracteres");
		txtDescricao.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtDescricao.setBounds(173, 300, 234, 52);
		
		Button button = new Button(this, SWT.NONE);
		button.setText("Voltar");
		button.setBounds(0, 358, 75, 25);
		
		DateTime timeOpen = new DateTime(this, SWT.BORDER | SWT.TIME);
		timeOpen.setBounds(49, 258, 80, 24);
		
		DateTime timeClose = new DateTime(this, SWT.BORDER | SWT.TIME);
		timeClose.setBounds(49, 304, 80, 24);
		
		Label label_9 = new Label(this, SWT.NONE);
		label_9.setText("Abre:");
		label_9.setBounds(0, 267, 28, 15);
		
		Label label_10 = new Label(this, SWT.NONE);
		label_10.setText("Fecha:");
		label_10.setBounds(0, 313, 34, 15);
		
		Label label_11 = new Label(this, SWT.NONE);
		label_11.setText("Cidade");
		label_11.setBounds(0, 162, 55, 15);
		
		txtCidade = new Text(this, SWT.BORDER);
		txtCidade.setBounds(0, 183, 110, 21);
		
		Label label_12 = new Label(this, SWT.NONE);
		label_12.setText("Estado");
		label_12.setBounds(131, 162, 55, 15);
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
		combo.setBounds(131, 183, 55, 23);
		combo.select(1);
		
		Label label_13 = new Label(this, SWT.NONE);
		label_13.setText("Telefone Celular(contato)");
		label_13.setBounds(212, 162, 140, 15);
		
		txtTelefone = new Text(this, SWT.BORDER);
		txtTelefone.setToolTipText("DDD+N\u00DAMERO\r\nEx: 11999999999");
		txtTelefone.setBounds(212, 183, 105, 21);
		
		Label label_14 = new Label(this, SWT.NONE);
		label_14.setText("Senha");
		label_14.setBounds(212, 216, 55, 15);
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setToolTipText("6 caracteres");
		txtSenha.setBounds(212, 237, 76, 21);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				bdLogin = login.buscaDados();
				try {
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nomeBar = txtNome.getText();
				nomeTipoLogradouro = txtTipoLogradouro.getText();
				enderecoLogradouro = txtEnderecoLogradouro.getText();
				enderecoNumero = Integer.parseInt(txtNumero.getText());
				enderecoComplemento = txtComplemento.getText();
				bairro = txtBairro.getText();
				cep = txtCep.getText();
				descricaoBar = txtDescricao.getText();
				openHora = timeOpen.getHours();
				openMin = timeOpen.getMinutes();
				openSec = timeOpen.getSeconds();
						openBar = openHora + ":" + openMin + ":" + openSec;
				closeHora = timeClose.getHours();
				closeMin = timeClose.getMinutes();
				closeSec = timeClose.getSeconds();
						closeBar = closeHora + ":" + closeMin + ":" + closeSec;
				telefoneBar = txtTelefone.getText();
				senhaBar = txtSenha.getText();
				nomeCidade = txtCidade.getText();
				siglaEstado = combo.getText();
				
				// **************** inserer no BD ****************
				estado.insereDados(null , siglaEstado);
				idEstado = estado.buscaId(siglaEstado);
				cidade.insereDados(nomeCidade, idEstado);
				idCidade = cidade.buscaId(nomeCidade);
				tipoLogradouro.alteraDados(nomeTipoLogradouro, idTipoLogradouro);
				endereco.alteraDados(idTipoLogradouro, idCidade, enderecoLogradouro, enderecoNumero, enderecoComplemento, bairro, cep, idEndereco);
				bar.alteraDados(nomeBar, idEndereco, openBar, closeBar, descricaoBar, 0, telefoneBar, senhaBar, idBar);
				dispose();
			}
		});
		button_1.setText("Ok");
		button_1.setBounds(332, 358, 75, 25);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 429);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
