package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

public class creditos extends Shell {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			creditos shell = new creditos(display);
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
	public creditos(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label lblCreateBy = new Label(this, SWT.NONE);
		lblCreateBy.setBounds(171, 32, 55, 15);
		lblCreateBy.setText("Create by");
		
		Label lblGiovannaCazelatoPires = new Label(this, SWT.NONE);
		lblGiovannaCazelatoPires.setBounds(143, 64, 134, 15);
		lblGiovannaCazelatoPires.setText("Giovanna Cazelato Pires");
		
		Label lblBiancaPrivati = new Label(this, SWT.NONE);
		lblBiancaPrivati.setBounds(143, 96, 134, 15);
		lblBiancaPrivati.setText("         Bianca Privati");
		
		Label lblStefanyLacroux = new Label(this, SWT.NONE);
		lblStefanyLacroux.setBounds(143, 129, 134, 15);
		lblStefanyLacroux.setText("       Stefany Lacroux");
		
		Label lblProfAlessandro = new Label(this, SWT.NONE);
		lblProfAlessandro.setBounds(124, 166, 182, 15);
		lblProfAlessandro.setText("Prof\u00BA Alessandro Viola Pizzoleto");
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
