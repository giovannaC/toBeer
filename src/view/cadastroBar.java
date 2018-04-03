package view;


import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import controle.*;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;

public class cadastroBar extends Shell {
	
	private String args[] = {""};
	
	estadoControle estado = new estadoControle();
	
	cidadeControle cidade = new cidadeControle();

	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();

	enderecoControle endereco = new enderecoControle();
	
	pubControle bar = new pubControle();
	
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
	private Text txtLogradouro;
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
			cadastroBar shell = new cadastroBar(display);
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
	public cadastroBar(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setBounds(10, 10, 55, 15);
		lblNome.setText("Nome");
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(10, 31, 255, 21);
		
		Label lblTipoDeLogradouro = new Label(this, SWT.NONE);
		lblTipoDeLogradouro.setBounds(10, 65, 110, 15);
		lblTipoDeLogradouro.setText("Tipo de Logradouro");
		
		txtTipoLogradouro = new Text(this, SWT.BORDER);
		txtTipoLogradouro.setToolTipText("Ex: Av, Rua...");
		txtTipoLogradouro.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtTipoLogradouro.setBounds(10, 86, 78, 21);
		
		Label lblLogradouro = new Label(this, SWT.NONE);
		lblLogradouro.setBounds(141, 65, 62, 15);
		lblLogradouro.setText("Logradouro");
		
		txtLogradouro = new Text(this, SWT.BORDER);
		txtLogradouro.setBounds(151, 86, 176, 21);
		
		Label lblNumero = new Label(this, SWT.NONE);
		lblNumero.setBounds(341, 65, 55, 15);
		lblNumero.setText("Numero");
		
		txtNumero = new Text(this, SWT.BORDER);
		txtNumero.setBounds(341, 86, 76, 21);
		
		Label lblComplemento = new Label(this, SWT.NONE);
		lblComplemento.setBounds(10, 116, 78, 15);
		lblComplemento.setText("Complemento");
		
		txtComplemento = new Text(this, SWT.BORDER);
		txtComplemento.setToolTipText("Ex: Casa, Ap...");
		txtComplemento.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtComplemento.setBounds(10, 137, 76, 21);
		
		Label lblBairro = new Label(this, SWT.NONE);
		lblBairro.setBounds(141, 116, 55, 15);
		lblBairro.setText("Bairro");
		
		txtBairro = new Text(this, SWT.BORDER);
		txtBairro.setBounds(141, 137, 110, 21);
		
		Label lblCep = new Label(this, SWT.NONE);
		lblCep.setBounds(286, 116, 55, 15);
		lblCep.setText("CEP");
		
		txtCep = new Text(this, SWT.BORDER);
		txtCep.setToolTipText("Ex: 13506-621");
		txtCep.setBounds(286, 137, 76, 21);
		
		Label lblHoraDeFuncionamento = new Label(this, SWT.NONE);
		lblHoraDeFuncionamento.setBounds(10, 247, 129, 15);
		lblHoraDeFuncionamento.setText("Hora de Funcionamento");
		
		Label lblBreveDescrio = new Label(this, SWT.NONE);
		lblBreveDescrio.setBounds(183, 289, 94, 15);
		lblBreveDescrio.setText("Breve Descri\u00E7\u00E3o");
		
		txtDescricao = new Text(this, SWT.BORDER);
		txtDescricao.setToolTipText("M\u00E1ximo 300 caracteres");
		txtDescricao.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtDescricao.setBounds(183, 310, 234, 52);
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				cadastro.main(args);
			}
		});
		btnVoltar.setBounds(10, 368, 75, 25);
		btnVoltar.setText("Voltar");
		
		DateTime timeAbre = new DateTime(this, SWT.BORDER | SWT.TIME);
		timeAbre.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		timeAbre.setBounds(59, 268, 80, 24);
		
		DateTime timeFecha = new DateTime(this, SWT.BORDER | SWT.TIME);
		timeFecha.setBounds(59, 314, 80, 24);
		
		Label lblAbre = new Label(this, SWT.NONE);
		lblAbre.setBounds(10, 277, 28, 15);
		lblAbre.setText("Abre:");
		
		Label lblFecha = new Label(this, SWT.NONE);
		lblFecha.setBounds(10, 323, 34, 15);
		lblFecha.setText("Fecha:");
		createContents();
		
		Label lblCidade = new Label(this, SWT.NONE);
		lblCidade.setBounds(10, 172, 55, 15);
		lblCidade.setText("Cidade");
		
		txtCidade = new Text(this, SWT.BORDER);
		txtCidade.setBounds(10, 193, 110, 21);
		
		Label lblEstado = new Label(this, SWT.NONE);
		lblEstado.setBounds(141, 172, 55, 15);
		lblEstado.setText("Estado");
		
		Combo cmbEstado = new Combo(this, SWT.NONE);
		cmbEstado.setItems(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"});
		cmbEstado.setBounds(141, 193, 55, 23);
		cmbEstado.select(1);
		
		Label lblTelefoneCelularcontato = new Label(this, SWT.NONE);
		lblTelefoneCelularcontato.setBounds(222, 172, 140, 15);
		lblTelefoneCelularcontato.setText("Telefone Celular(contato)");
		
		txtTelefone = new Text(this, SWT.BORDER);
		txtTelefone.setToolTipText("DDD+N\u00DAMERO\r\nEx: 11999999999");
		txtTelefone.setBounds(222, 193, 105, 21);
		
		Label lblSenha = new Label(this, SWT.NONE);
		lblSenha.setBounds(222, 226, 55, 15);
		lblSenha.setText("Senha");
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setToolTipText("6 caracteres");
		txtSenha.setBounds(222, 247, 76, 21);
		
		Button btnSalvar = new Button(this, SWT.NONE);
		btnSalvar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//SE FOR PRESSIONADO O BOTÃO SALVAR ELE PEGA TODOS OS CONETUDOS DOS TEXTOS, GRAVA EM VARIÁVEIS E INSERE NO BANCO DE DADOS
				nomeBar = txtNome.getText();
				nomeTipoLogradouro = txtTipoLogradouro.getText();
				enderecoLogradouro = txtLogradouro.getText();
				enderecoNumero = Integer.parseInt(txtNumero.getText());
				enderecoComplemento = txtComplemento.getText();
				bairro = txtBairro.getText();
				cep = txtCep.getText();
				descricaoBar = txtDescricao.getText();
				openHora = timeAbre.getHours();
				openMin = timeAbre.getMinutes();
				openSec = timeAbre.getSeconds();
						openBar = openHora + ":" + openMin + ":" + openSec;
				closeHora = timeFecha.getHours();
				closeMin = timeFecha.getMinutes();
				closeSec = timeFecha.getSeconds();
						closeBar = closeHora + ":" + closeMin + ":" + closeSec;
				telefoneBar = txtTelefone.getText();
				senhaBar = txtSenha.getText();
				nomeCidade = txtCidade.getText();
				siglaEstado = cmbEstado.getText();
				
				// **************** inserer no BD ****************
				estado.insereDados(null , siglaEstado);
				idEstado = estado.buscaId(siglaEstado);
				cidade.insereDados(nomeCidade, idEstado);
				idCidade = cidade.buscaId(nomeCidade);
				tipoLogradouro.insereDados(nomeTipoLogradouro);
				idTipoLogradouro = tipoLogradouro.buscaId(nomeTipoLogradouro);
				endereco.insereDados(idTipoLogradouro, idCidade, enderecoLogradouro, enderecoNumero, enderecoComplemento, bairro, cep);
				idEndereco = endereco.buscaId(enderecoLogradouro);
				bar.insereDados(nomeBar, idEndereco, openBar, closeBar, descricaoBar, 0, telefoneBar, senhaBar);
				dispose();
				JOptionPane.showMessageDialog(null, "Cadastro salvo!!");
				
			}
		});
		btnSalvar.setBounds(342, 368, 75, 25);
		btnSalvar.setText("Salvar");
		
		
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(453, 442);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
