package view;



import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import controle.pessoaControle;
import controle.pubControle;
import controle.loginControle;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;

import classes.pessoa;

public class entrar extends Shell {
	
	private String args[] = {""};
	
	pubControle bar = new pubControle();
	classes.pub barClass = new classes.pub();
	pessoaControle pessoa = new pessoaControle();
	pessoa pessoaClass = new pessoa();
	loginControle login = new loginControle();
	
	public String telefone;
	public String senha;
	
	
	private Text txtTelefone;
	private Text txtSenha;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			entrar shell = new entrar(display);
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
	public entrar(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setLocation(0, 0);
		composite_1.setSize(414, 139);
		
		Label lblNumeroDeTelefone = new Label(composite_1, SWT.NONE);
		lblNumeroDeTelefone.setLocation(10, 24);
		lblNumeroDeTelefone.setSize(119, 15);
		lblNumeroDeTelefone.setText("Numero de Telefone");
		
		txtTelefone = new Text(composite_1, SWT.BORDER);
		txtTelefone.setLocation(10, 45);
		txtTelefone.setSize(133, 21);
		txtTelefone.setToolTipText("DDD+N\u00DAMERO\r\nEx: 11999999999");
		
		Label lblSenha = new Label(composite_1, SWT.NONE);
		lblSenha.setLocation(10, 75);
		lblSenha.setSize(55, 15);
		lblSenha.setText("Senha");
		
		txtSenha = new Text(composite_1, SWT.BORDER | SWT.PASSWORD);
		txtSenha.setLocation(10, 97);
		txtSenha.setSize(133, 21);
		
		Label lblTipo = new Label(composite_1, SWT.NONE);
		lblTipo.setLocation(177, 24);
		lblTipo.setSize(55, 15);
		lblTipo.setText("Tipo:");
		
		Button btnPessoa = new Button(composite_1, SWT.RADIO);
		btnPessoa.setLocation(177, 47);
		btnPessoa.setSize(90, 16);
		btnPessoa.setSelection(false);
		btnPessoa.setText("Pessoa");
		
		Button btnBar = new Button(composite_1, SWT.RADIO);
		btnBar.setLocation(177, 74);
		btnBar.setSize(90, 16);
		btnBar.setSelection(false);
		btnBar.setText("Bar");
		
		Button btnEntrar = new Button(composite_1, SWT.NONE);
		btnEntrar.setLocation(329, 114);
		btnEntrar.setSize(75, 25);
		btnEntrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				telefone = txtTelefone.getText();
				senha = txtSenha.getText();
				// TESTA SE EXISTE O USUÁRIO E QUE TIPO DE USUÁRIO É, BAR OU PESSOA
				if(btnPessoa.getSelection() == true){
					if(pessoa.loginPessoa(telefone, senha) == true){
						login.insereDados(telefone);
						dispose();
						perfilPessoaPessoal.main(args);
					}else{
						JOptionPane.showMessageDialog(null, "Usuário não cadastrado!!");
					}
				}else{
					if(bar.loginBar(telefone, senha) == true){
						login.insereDados(telefone);
						dispose();
						perfilBarPessoal.main(args);
					}else{
						JOptionPane.showMessageDialog(null, "Bar não cadastrado!!");
					}
				}
			
			}
		});
		btnEntrar.setText("Entrar");
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(0, 190, 75, 25);
		btnVoltar.setText("Voltar");
		
		Button btnSair = new Button(this, SWT.NONE);
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(339, 190, 75, 25);
		btnSair.setText("Sair");
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 266);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
