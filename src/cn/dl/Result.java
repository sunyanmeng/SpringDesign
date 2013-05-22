package cn.dl;

import java.text.DecimalFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class Result implements AppConstants {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	private DecimalFormat df = new DecimalFormat("#0.00");
	private Text HsText;
	private Text tText;
	private Text dText;
	private Text DText;
	private Text FsText;
	private Text F2Text;
	private Text F1Text;
	private Text H2Text;
	private Text H1Text;
	private Text H0Text;
	
	private double Fs;
	private double Fpie2;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Fs = Double.parseDouble(CircularSection.FsText.getText());
		Fpie2 = Double.parseDouble(CircularSection.Fpie2Text.getText());
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setModified(true);
		shell.setSize(599, 877);
		shell.setText("\u8BA1\u7B97\u7ED3\u679C");
		shell.setLayout(new FormLayout());
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setLayout(null);
		FormData fd_canvas = new FormData();
		fd_canvas.left = new FormAttachment(0, 31);
		fd_canvas.right = new FormAttachment(0, 542);
		fd_canvas.top = new FormAttachment(0, 11);
		canvas.setLayoutData(fd_canvas);
		canvas.setEnabled(false);
		canvas.setBackgroundImage(SWTResourceManager.getImage("res\\result.jpg"));
		
		HsText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		HsText.setText(df.format(Fs / Fpie2 + Double.parseDouble(CircularSection.HbText.getText())) + "");
		HsText.setBounds(135, 46, 63, 23);
		
		tText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		tText.setEditable(false);
		tText.setText(CircularSection.tText.getText());
		tText.setBounds(147, 371, 63, 23);
		
		dText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		dText.setText(CircularSection.dCombo.getItem(CircularSection.dCombo.getSelectionIndex()));
		dText.setBounds(362, 338, 63, 23);
		
		DText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		DText.setText(CircularSection.DCombo.getItem(CircularSection.DCombo.getSelectionIndex()));
		DText.setBounds(438, 243, 63, 23);
		
		FsText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		FsText.setEditable(false);
		FsText.setText(CircularSection.FsText.getText());
		FsText.setBounds(330, -3, 52, 17);
		
		F2Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		F2Text.setEditable(false);
		F2Text.setText(CircularSection.FnText.getText());
		F2Text.setBounds(373, 20, 63, 17);
		
		F1Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		F1Text.setEditable(false);
		F1Text.setText(CircularSection.F1Text.getText());
		F1Text.setBounds(412, 43, 63, 17);
		
		Label lblNewLabel = formToolkit.createLabel(canvas, "t=", SWT.NONE);
		lblNewLabel.setBounds(128, 374, 13, 17);
		
		Label lblNewLabel_1 = formToolkit.createLabel(canvas, "d=", SWT.NONE);
		lblNewLabel_1.setBounds(344, 344, 33, 17);
		
		Label lblNewLabel_2 = formToolkit.createLabel(canvas, "D=", SWT.NONE);
		lblNewLabel_2.setBounds(457, 230, 18, 17);
		
		Label lblNewLabel_3 = formToolkit.createLabel(canvas, "Hs=", SWT.NONE);
		lblNewLabel_3.setBounds(108, 49, 24, 17);
		
		Label lblNewLabel_4 = formToolkit.createLabel(canvas, "H2=", SWT.NONE);
		lblNewLabel_4.setBounds(128, 86, 33, 17);
		
		H2Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H2Text.setText(CircularSection.H02Text.getText());
		H2Text.setBounds(157, 83, 63, 23);
		
		Label lblNewLabel_5 = formToolkit.createLabel(canvas, "H1=", SWT.NONE);
		lblNewLabel_5.setBounds(147, 116, 25, 17);
		
		H1Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H1Text.setText(CircularSection.H01Text.getText());
		H1Text.setBounds(178, 110, 63, 23);
		
		Label lblNewLabel_6 = formToolkit.createLabel(canvas, "H0=", SWT.NONE);
		lblNewLabel_6.setBounds(180, 147, 24, 17);
		
		H0Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H0Text.setText(CircularSection.H0Text.getText());
		H0Text.setBounds(209, 141, 63, 23);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		fd_canvas.bottom = new FormAttachment(table, -6);
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(0, 421);
		fd_table.bottom = new FormAttachment(100, -10);
		fd_table.left = new FormAttachment(0, 10);
		fd_table.right = new FormAttachment(0, 573);
		table.setLayoutData(fd_table);
		table.setFont(SWTResourceManager.getFont("宋体", 14, SWT.NORMAL));
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(54);
		tableColumn.setText("\u5E8F\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(186);
		tableColumn_1.setText("\u53C2\u6570\u540D\u79F0");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(96);
		tableColumn_2.setText("\u4EE3\u53F7");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.CENTER);
		tableColumn_3.setWidth(131);
		tableColumn_3.setText("\u6570\u503C");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.CENTER);
		tableColumn_4.setWidth(85);
		tableColumn_4.setText("\u5355\u4F4D");
		
		showData();
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}
	private void showData() {
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "1", "旋绕比", "C", CircularSection.CText.getText(), "--"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "2", "曲度系数", "K", CircularSection.KText.getText(), "--"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "3", "弹簧中径", "D", CircularSection.DCombo.getItem(CircularSection.DCombo.getSelectionIndex()), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "4", "压并负荷", "Fb", (Double.parseDouble(CircularSection.FpieText.getText()) * (Double.parseDouble(CircularSection.H0Text.getText()) - Double.parseDouble(CircularSection.HbText.getText()))) + "", "N"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "5", "压并高度", "Hb", CircularSection.HbText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "6", "试验负荷下的高度", "Hs", df.format(Fs / Fpie2 + Double.parseDouble(CircularSection.HbText.getText())) + "", "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "7", "抗拉强度", "Rm", CircularSection.RmText.getText(), "MPa"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "8", "压并应力", "tb", df.format(Double.parseDouble(CircularSection.FsText.getText()) * 8.0 * Double.parseDouble(CircularSection.DCombo.getItem(CircularSection.DCombo.getSelectionIndex())) / (Math.PI * Math.pow(Double.parseDouble(CircularSection.dCombo.getItem(CircularSection.dCombo.getSelectionIndex())), 3))), "MPa"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "9", "工作应力", "t1", CircularSection.tminText.getText(), "MPa"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "10", "试验应力", "ts", CircularSection.tsText.getText(), "MPa"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "11", "刚度", "F'", CircularSection.FpieText.getText(), "N/mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "12", "自振频率", "fe", CircularSection.feText.getText(), "Hz"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "13", "强迫振动频率", "fr", CircularSection.frText.getText(), "--"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "14", "循环次数", "N", CircularSection.NCombo.getItem(CircularSection.NCombo.getSelectionIndex()), "次"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "15", "展开长度", "L", CircularSection.LText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "16", "质量", "m", Math.PI * Math.pow(Double.parseDouble(CircularSection.dCombo.getItem(CircularSection.dCombo.getSelectionIndex())), 2) * Double.parseDouble(CircularSection.LText.getText()) * rho / 4 + "", "kg"});
	}
}
