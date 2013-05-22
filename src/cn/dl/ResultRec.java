package cn.dl;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ResultRec {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	private Text bText;
	private Text DText;
	private Text D2Text;

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(680, 860);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("微软雅黑", 11, SWT.NORMAL));
		table.setBounds(10, 346, 652, 466);
		formToolkit.adapt(table);
		formToolkit.paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setWidth(54);
		tblclmnNewColumn.setText("\u5E8F\u53F7");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(186);
		tblclmnNewColumn_1.setText("\u53C2\u6570\u540D\u79F0");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setWidth(96);
		tblclmnNewColumn_2.setText("\u4EE3\u53F7");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setWidth(223);
		tblclmnNewColumn_3.setText("\u6570\u503C");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setWidth(85);
		tblclmnNewColumn_4.setText("\u5355\u4F4D");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBounds(84, 10, 486, 311);
		formToolkit.adapt(canvas);
		formToolkit.paintBordersFor(canvas);
		canvas.setBackgroundImage(SWTResourceManager.getImage("res\\recular.png"));
		
		Label lblNewLabel = formToolkit.createLabel(canvas, "b", SWT.NONE);
		lblNewLabel.setBounds(113, 196, 27, 17);
		
		bText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		bText.setText(RectangularSection.bText.getText());
		bText.setBounds(101, 212, 34, 23);
		
		Label lblNewLabel_1 = formToolkit.createLabel(canvas, "D=", SWT.NONE);
		lblNewLabel_1.setBounds(194, 13, 18, 17);
		
		DText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		DText.setText(RectangularSection.DText.getText());
		DText.setBounds(218, 10, 63, 23);
		
		Label lblNewLabel_2 = formToolkit.createLabel(canvas, "D2=", SWT.NONE);
		lblNewLabel_2.setBounds(175, 64, 27, 17);
		
		D2Text = formToolkit.createText(canvas, "New Text", SWT.NONE);
		D2Text.setText(RectangularSection.D2Text.getText());
		D2Text.setBounds(207, 58, 63, 23);

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
		tableItem.setText(new String[] { "1", "垂直弹簧轴线边长", "a", RectangularSection.aCombo.getItem(RectangularSection.aCombo.getSelectionIndex()), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "2", "平行弹簧轴线边长", "b", RectangularSection.bText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "3", "旋绕比", "C", RectangularSection.CCombo.getItem(RectangularSection.CCombo.getSelectionIndex()), "--"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "4", "弹簧中径", "D", RectangularSection.DText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "5", "弹簧刚度", "K", RectangularSection.KText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "6", "最小负荷变形", "f1", RectangularSection.f1Text.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "7", "最大负荷变形", "fn", RectangularSection.fnText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "8", "有效圈数", "n", RectangularSection.fnText.getText(), "无量纲"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "9", "总圈数", "n1", RectangularSection.n1Text.getText(), "无量纲"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "10", "弹簧外径", "D2", RectangularSection.D2Text.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "11", "弹簧内经", "D1", RectangularSection.D1Text.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "12", "弹簧节距t", "t", RectangularSection.tText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "13", "间距", "δ", RectangularSection.deltaText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "14", "螺旋角", "α", RectangularSection.alphaText.getText(), "弧度"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "15", "自由高度", "H0", RectangularSection.H0Text.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "16", "压并高度", "Hb", RectangularSection.HbText.getText(), "mm"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "17", "展开长度", "L", RectangularSection.LText.getText(), "kg"});
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "18", "端部结构", "--", RectangularSection.endTypeCombo.getItem(RectangularSection.endTypeCombo.getSelectionIndex()), "不适用"});
	}
}
