package cn.dl;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class MainMenu {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.MIN);
		shell.setImage(SWTResourceManager.getImage("res\\icon.png"));
		shell.setSize(630, 436);
		shell.setBackgroundImage(SWTResourceManager.getImage("res\\mainbg.jpg"));
		shell.setText("\u5706\u67F1\u87BA\u65CB\u538B\u7F29\u5F39\u7C27\u8BBE\u8BA1\u8F6F\u4EF6");
		
		Button btnNewButton = new Button(shell, SWT.FLAT);
		btnNewButton.setFont(SWTResourceManager.getFont("ËÎÌו", 16, SWT.BOLD));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				CircularSection main = new CircularSection();
				main.open(true);
			}
		});
		btnNewButton.setBounds(21, 84, 115, 64);
		btnNewButton.setText("\u5706\u5F62\u622A\u9762");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setFont(SWTResourceManager.getFont("ËÎÌו", 16, SWT.BOLD));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				RectangularSection main = new RectangularSection();
				main.open(true);
			}
		});
		btnNewButton_1.setBounds(21, 283, 115, 64);
		btnNewButton_1.setText("\u77E9\u5F62\u622A\u9762");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
