package view;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import controle.cidadeControle;
import controle.encontroControle;
import controle.enderecoControle;
import controle.estadoControle;
import controle.loginControle;
import controle.pessoaControle;
import controle.procuraControle;
import controle.pubControle;
import controle.tipoLogradouroControle;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;

public class perfilBarPublico extends Shell {
	
	estadoControle estado = new estadoControle();
	cidadeControle cidade = new cidadeControle();
	tipoLogradouroControle tipoLogradouro = new tipoLogradouroControle();
	enderecoControle endereco = new enderecoControle();
	pubControle bar = new pubControle();
	loginControle login = new loginControle();
	encontroControle encontro = new encontroControle();
	procuraControle procura = new procuraControle();
	pessoaControle pessoa = new pessoaControle();
	
	ResultSet bdEstado;
	ResultSet bdCidade;
	ResultSet bdTipoLogradouro;
	ResultSet bdEndereco;
	ResultSet bdBar;
	ResultSet bdLogin;
	ResultSet bdEncontro;
	ResultSet bdProcura;
	ResultSet bdPessoa;
	
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
	public String checkIn;
		int inHora;
		int inMin;
		int inSec;
	public String checkOut;
		int outHora;
		int outMin;
		int outSec;
	public String dirigir;
	public String telPessoa;
	public String nomePessoa = "";
	
	public int idEstado;
	public int idCidade;
	public int idEndereco;
	public int idTipoLogradouro;
	public int idBar;
	public int idPessoa;
	
	private Text txtDescricao;
	private Text txtPresenca;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			perfilBarPublico shell = new perfilBarPublico(display);
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
	public perfilBarPublico(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblNome = new Label(this, SWT.NONE);
		lblNome.setText("ERROR");
		lblNome.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		lblNome.setBounds(0, 0, 414, 28);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				procura.excluiDados();
				dispose();
			}
		});
		button_3.setText("Sair");
		button_3.setBounds(10, 322, 75, 25);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("Pessoas que confirmaram presen\u00E7a");
		label_1.setBounds(0, 34, 190, 15);
		
		txtPresenca = new Text(this, SWT.READ_ONLY | SWT.WRAP);
		txtPresenca.setBounds(10, 55, 106, 111);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Dados do bar:");
		label_2.setBounds(196, 34, 83, 15);
		
		Label lblEndereco = new Label(this, SWT.NONE);
		lblEndereco.setText("Endereco");
		lblEndereco.setBounds(196, 59, 228, 15);
		
		Label lblOpen = new Label(this, SWT.NONE);
		lblOpen.setText("Horario de Abrir");
		lblOpen.setBounds(196, 80, 102, 15);
		
		Label lblFecha = new Label(this, SWT.NONE);
		lblFecha.setText("Horario de Fechar");
		lblFecha.setBounds(196, 101, 102, 15);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setText("Abre:");
		label_6.setBounds(152, 80, 38, 15);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setText("Fecha:");
		label_7.setBounds(152, 101, 38, 15);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setText("Descri\u00E7ao:");
		label_8.setBounds(0, 172, 55, 15);
		
		txtDescricao = new Text(this, SWT.READ_ONLY | SWT.WRAP | SWT.MULTI);
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(0, 203, 260, 68);
		
		Label lblVaiDirigindo = new Label(this, SWT.NONE);
		lblVaiDirigindo.setBounds(285, 138, 75, 15);
		lblVaiDirigindo.setText("Vai dirigindo?");
		
		Button btnSim = new Button(this, SWT.RADIO);
		btnSim.setBounds(285, 159, 41, 16);
		btnSim.setText("Sim");
		
		Button btnNao = new Button(this, SWT.RADIO);
		btnNao.setBounds(332, 159, 41, 16);
		btnNao.setText("N\u00E3o");
		
		Button btnPresenca = new Button(this, SWT.CHECK);
		btnPresenca.setBounds(285, 242, 129, 16);
		btnPresenca.setText("Confirmar presen\u00E7a");
		
		Label lblCheckin = new Label(this, SWT.NONE);
		lblCheckin.setBounds(285, 181, 55, 15);
		lblCheckin.setText("Check-in:");
		
		DateTime timeIn = new DateTime(this, SWT.BORDER | SWT.TIME | SWT.SHORT);
		timeIn.setBounds(342, 182, 55, 24);
		
		Label lblCheckout = new Label(this, SWT.NONE);
		lblCheckout.setBounds(285, 213, 65, 15);
		lblCheckout.setText("Check-out");
		
		DateTime timeOut = new DateTime(this, SWT.BORDER | SWT.TIME | SWT.SHORT);
		timeOut.setBounds(352, 212, 55, 24);
		
		
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				
				try {
					bdLogin = login.buscaDados();
					while(bdLogin.first()){
						telPessoa = bdLogin.getString("TELEFONE");
						System.out.println("telPessoa : " + telPessoa);
						break;
					}
					bdPessoa = pessoa.buscaDados(telPessoa);
					while(bdPessoa.first()){
						idPessoa = bdPessoa.getInt("PESSOAID");
						System.out.println("idPessoa : " + idPessoa);
						break;
					}
					bdProcura = procura.buscaDados();
					while(bdProcura.first()){
						nomeBar = bdProcura.getString("PROCURABAR");
						System.out.println("nomeBar : " + nomeBar);
						lblNome.setText(nomeBar);
						break;
					}
					bdBar = bar.buscaDadosNome(nomeBar);
					while(bdBar.first()){
						idBar = bdBar.getInt("BARID");
						System.out.println("idBar : " + idBar);
						telefoneBar = bdBar.getString("BARTELEFONE");
						System.out.println("telefoneBar : " + telefoneBar);
						openBar = bdBar.getString("BAROPEN");
						System.out.println("obenBar : " + openBar);
						lblOpen.setText(openBar);
						closeBar = bdBar.getString("BARCLOSE");
						System.out.println("closeBar : " + closeBar);
						lblFecha.setText(closeBar);
						descricaoBar = bdBar.getString("BARDESCRICAO");
						System.out.println("descricaoBar : " + descricaoBar);
						txtDescricao.setText(descricaoBar);
						idEndereco = bdBar.getInt("ENDERECOID");
						System.out.println("idEndereco : " + idEndereco);
						break;
					}
					bdEndereco = endereco.buscaDados(idEndereco);
					while(bdEndereco.first()){
						idTipoLogradouro = bdEndereco.getInt("TIPOLOGRADOUROID");
						System.out.println("idTipoLogradouro : " + idTipoLogradouro);
						idCidade = bdEndereco.getInt("CIDADEID");
						System.out.println("idCidade : " + idCidade);
						enderecoLogradouro = bdEndereco.getString("ENDERECOLOGRADOURO");
						System.out.println("enderecoLogradouro : " + enderecoLogradouro);
						enderecoNumero = bdEndereco.getInt("ENDERECONUMERO");
						System.out.println("enderecoNumero : " + enderecoNumero);
						bairro = bdEndereco.getString("ENDERECOBAIRRO");
						System.out.println("bairro : " + bairro);
						enderecoComplemento = bdEndereco.getString("ENDERECOCOMPLEMENTO");
						System.out.println("enderecoComplemento : " + enderecoComplemento);
						cep = bdEndereco.getString("ENDERECOCEP");
						System.out.println("cep : " + cep);
						break;
					}
					bdTipoLogradouro = tipoLogradouro.buscaDados(idTipoLogradouro);
					while(bdTipoLogradouro.first()){
						nomeTipoLogradouro = bdTipoLogradouro.getString("TIPOLOGRADOURONOME");
						System.out.println("nomeTipoLogradouro : " + nomeTipoLogradouro);
						break;
					}
					bdCidade = cidade.buscaDados(idCidade);
					while(bdCidade.first()){
						idEstado = bdCidade.getInt("ESTADOID");
						System.out.println("idEstado : " + idEstado);
						nomeCidade = bdCidade.getString("CIDADENOME");
						System.out.println("nomeCidade : " + nomeCidade);
						break;
					}
					bdEstado = estado.buscaDados(idEstado);
					while(bdEstado.first()){
						siglaEstado = bdEstado.getString("ESTADOSIGLA");
						System.out.println("siglaEstado : " + siglaEstado);
						break;
					}
					enderecoBar = nomeTipoLogradouro + " " + enderecoLogradouro + ", " + enderecoNumero + " " + enderecoComplemento + ", " + 
							bairro + ", " + nomeCidade + " - " + siglaEstado + " " + cep;
					lblEndereco.setText(enderecoBar);
					
					bdEncontro = encontro.buscaDadosBar(idBar);
					System.out.println("TO IGNORANDO ESSE WHILE AQUI");
					while(bdEncontro.first()){
						System.out.println("BRINKS TO NAO");
						do{
							System.out.println("ENTREI NO PROCURAR PESSOAS QUE VÃO");
							idPessoa = bdEncontro.getInt("PESSOAID");
							bdPessoa = pessoa.buscaDados(idPessoa);
							while(bdPessoa.first()){
								nomePessoa = nomePessoa + bdPessoa.getString("PESSOANOME") + "\n";
								System.out.println("nomePessoa : " + nomePessoa);
								break;
							}
						}while(bdEncontro.next());
						break;
					}
					txtPresenca.setText(nomePessoa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			@Override
			public void shellClosed(ShellEvent e) {
				procura.excluiDados();
			}
			@Override
			public void shellDeactivated(ShellEvent e) {
				nomePessoa = "";
			}
		});
		
		Button btnOk = new Button(this, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnPresenca.getSelection() == true){
					if(btnSim.getSelection() == true){
						dirigir = "S";
					}else{
						dirigir = "N";
					}
					inHora = timeIn.getHours();
					inMin = timeIn.getMinutes();
					inSec = 0;
						checkIn = inHora + ":" + inMin + ":" + inSec;
					outHora = timeOut.getHours();
					outMin = timeOut.getMinutes();
					outSec = 0;
						checkOut = outHora + ":" + outMin + ":" + outSec;
					//****** CRIANDO ENCONTRO *****//
					encontro.insereDados(idBar, idPessoa, 0, checkIn, checkOut, dirigir);
					//****************************//
					procura.excluiDados();
					dispose();
				}else{
					procura.excluiDados();
					dispose();
				}
			}
		});
		btnOk.setText("Ok");
		btnOk.setBounds(359, 322, 65, 25);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 396);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
