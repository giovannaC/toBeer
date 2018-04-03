package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;


public class menu extends Shell {
	
	private String args[] = {""};

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			menu shell = new menu(display);
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
	public menu(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Button btnCadastrar = new Button(this, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Se apertar o botão cadastrar, ele vai para a interface de cadastro
				cadastro.main(args);
			}
		});
		btnCadastrar.setBounds(10, 111, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Se apertar o botão do desenho, ele vai para a interface de créditos
				creditos.main(args);
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(menu.class, "/imagens/tobeer.png"));
		btnNewButton.setBounds(55, 10, 309, 95);
		
		Button btnSair = new Button(this, SWT.NONE);
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Se apertar o botão Sair, ele sai
				System.exit(0);
			}
		});
		btnSair.setBounds(349, 226, 75, 25);
		btnSair.setText("Sair");
		
		Button btnEntrar = new Button(this, SWT.NONE);
		btnEntrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Se apertar o botão entrar, ele vai para a interface de entrar
				entrar.main(args);
			}
		});
		btnEntrar.setBounds(108, 111, 75, 25);
		btnEntrar.setText("Entrar");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("SWT Application");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
