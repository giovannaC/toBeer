package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class cadastro extends Shell {
	
	private String args[] = {""};

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			cadastro shell = new cadastro(display);
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
	public cadastro(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Button btnBar = new Button(this, SWT.NONE);
		btnBar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				cadastroBar.main(args);
			}
		});
		btnBar.setBounds(81, 71, 93, 56);
		btnBar.setText("Bar");
		
		Button btnPessoa = new Button(this, SWT.NONE);
		btnPessoa.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
				cadastroPessoa.main(args);
			}
		});
		btnPessoa.setBounds(256, 71, 93, 56);
		btnPessoa.setText("Pessoa");
		
		Button btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 226, 75, 25);
		btnVoltar.setText("Voltar");
		
		Button btnSair = new Button(this, SWT.NONE);
		btnSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(349, 226, 75, 25);
		btnSair.setText("Sair");
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
