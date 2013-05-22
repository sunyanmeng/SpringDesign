package cn.dl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.swt.widgets.Canvas;

public class RectangularSection implements AppConstants {
	// private static HashMap<Text_Var, Double> allText = new HashMap<Text_Var,
	// Double>();
	// private static HashMap<Combo_Var, Integer> allCombo = new
	// HashMap<Combo_Var, Integer>();
	private static final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	public static Text RmText;
	public static Text tpText;
	public static Text F1Text;
	public static Text FnText;
	public static Text hText;
	public static Text D2Text, D2PicText;
	public static Text D1Text;
	public static Text tText;
	public static Text nText;
	public static Text n1Text;
	public static Text H0Text;
	public static Text fnText;
	public static Text f1Text;
	public static Text HbText;
	public static Text LText;
	public static Text KText;
	public static Text DText, DPicText;

	public static Combo endTypeCombo;
	public static Combo springMaterialCombo;
	public static Combo aCombo;
	public static Combo CCombo;
	public static Text deltaText;
	public static Text alphaText;
	public static Text bText, bPicText;
	public static Text prompt;
	
	public static Table table;
	
	public static Button lastBtn;
	public static Button nextBtn;
	public static Button btnNewButton;
	public static boolean init;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void open(boolean init1) {
		init = init1;
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.MIN);
		shell.setSize(712, 648);
		shell.setImage(SWTResourceManager.getImage("res\\icon.png"));
		shell.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setText("\u5706\u67F1\u87BA\u65CB\u538B\u7F29\u5F39\u7C27\u8BBE\u8BA1");

		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("hhhh");
				if (!init) {
					if (tabFolder.getSelectionIndex() == 0) {
						lastBtn.setVisible(false);
						nextBtn.setVisible(true);
						return;
					}
					if (tabFolder.getSelectionIndex() == (tabFolder
							.getItemCount() - 1)) {
						lastBtn.setVisible(true);
						nextBtn.setVisible(false);
						return;
					}
					lastBtn.setVisible(true);
					nextBtn.setVisible(true);
				} else {
					init = false;
				}
			}
		});
		tabFolder.setBounds(10, 10, 673, 520);
		
		TabItem initItem = new TabItem(tabFolder, SWT.NONE);
		initItem.setText("\u539F\u59CB\u6761\u4EF6");
		
		Group initGroup = new Group(tabFolder, SWT.NONE);
		initGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		initGroup.setLayout(new GridLayout(3, false));
		initGroup.setText("Ô­Ê¼Ìõ¼þÊäÈë");
		
		TabItem resultItem = new TabItem(tabFolder, SWT.NONE);
		resultItem.setText("\u8BA1\u7B97\u8FC7\u7A0B");
		
		GridLayout resultLayout = new GridLayout(6, false);
		resultLayout.verticalSpacing = 17;
		resultLayout.marginTop = 10;
		Group resultGroup = new Group(tabFolder, SWT.NONE);
		resultGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		resultGroup.setLayout(resultLayout);
		resultGroup.setText("¼ÆËã½á¹û");
		resultItem.setControl(resultGroup);
		
		TabItem tableOutputItem = new TabItem(tabFolder, SWT.NONE);
		tableOutputItem.setText("\u8868\u683C\u8F93\u51FA");
		
		Group tableOutputGroup = new Group(tabFolder, SWT.NONE);
		tableOutputGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		// outputGroup.setLayout(new GridLayout(6, false));
		tableOutputGroup.setText("±í¸ñ½á¹û");
		tableOutputItem.setControl(tableOutputGroup);
		
		TabItem picOutputItem = new TabItem(tabFolder, SWT.NONE);
		picOutputItem.setText("\u56FE\u5F62\u8F93\u51FA");
		
		Group picOutputGroup = new Group(tabFolder, SWT.NONE);
		picOutputGroup.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		// outputGroup.setLayout(new GridLayout(6, false));
		picOutputGroup.setText("Í¼ÐÎ½á¹û");
		picOutputItem.setControl(picOutputGroup);
		
		/*
		 * Ô­Ê¼Ìõ¼þ
		 */
		
		new Label(initGroup, SWT.NONE);
		Label lblNewLabel_2 = formToolkit.createLabel(initGroup, "\u5355\u4F4D",
				SWT.NONE);
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		new Label(initGroup, SWT.NONE);

		Label endTypeLabel = formToolkit.createLabel(initGroup,
				"\u7AEF\u90E8\u5F62\u5F0F", SWT.NONE);
		endTypeLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		endTypeLabel.setAlignment(SWT.CENTER);
		endTypeLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		GridData gd_endTypeLabel = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_endTypeLabel.widthHint = 213;
		endTypeLabel.setLayoutData(gd_endTypeLabel);

		Label lblNewLabel_1 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		endTypeCombo = new Combo(initGroup, SWT.READ_ONLY);
		GridData gd_endTypeCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_endTypeCombo.widthHint = 175;
		endTypeCombo.setLayoutData(gd_endTypeCombo);
		endTypeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RectangularCoreFunction.getInstance().getAllCombo();
			}
		});
		endTypeCombo.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		endTypeCombo
				.setItems(new String[] {
						"\u7AEF\u90E8\u5E76\u7D27\uFF0C\u4E0D\u78E8\u5E73\uFF0C\u652F\u6491\u57081\u5708",
						"\u7AEF\u90E8\u5E76\u7D27\uFF0C\u78E8\u5E73\uFF0C\u652F\u6491\u57081\u5708" });
		formToolkit.adapt(endTypeCombo);
		formToolkit.paintBordersFor(endTypeCombo);
		endTypeCombo.select(0);

		Label springMaterialLabel = formToolkit.createLabel(initGroup,
				"\u5F39\u7C27\u6750\u6599", SWT.NONE);
		springMaterialLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		springMaterialLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		springMaterialLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		Label lblNewLabel_4 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		GridData gd_lblNewLabel_4 = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_4.widthHint = 140;
		lblNewLabel_4.setLayoutData(gd_lblNewLabel_4);

		springMaterialCombo = new Combo(initGroup, SWT.READ_ONLY);
		springMaterialCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RectangularCoreFunction.getInstance().getAllCombo();
			}
		});
		springMaterialCombo.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		springMaterialCombo.setItems(new String[] { "(1)FDC\u3001TDC",
				"(2)FDCrV-A\u3001TDCrV-A", "(3)FDCrV-B\u3001TDCrV-B",
				"(4)FDSiMn\u3001TDSiMn", "(5)FDCrSi\u3001TDCrSi", "(6)VDC",
				"(7)VDCrV-A", "(8)VDCrV-B", "(9)VDCrSi" });
		GridData gd_springMaterialCombo = new GridData(SWT.LEFT, SWT.CENTER,
				true, false, 1, 1);
		gd_springMaterialCombo.widthHint = 175;
		springMaterialCombo.setLayoutData(gd_springMaterialCombo);
		formToolkit.adapt(springMaterialCombo);
		formToolkit.paintBordersFor(springMaterialCombo);
		springMaterialCombo.select(0);

		Label maxLoadLabel = formToolkit.createLabel(initGroup,
				"\u6700\u5927\u8D1F\u8377Fn", SWT.NONE);
		maxLoadLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		maxLoadLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_7 = formToolkit.createLabel(initGroup, "N", SWT.NONE);
		lblNewLabel_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		FnText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		FnText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RectangularCoreFunction.getInstance().getAllText();
			}
		});
		FnText.setText("0.0");
		GridData gd_FnText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_FnText.widthHint = 191;
		FnText.setLayoutData(gd_FnText);

		Label minLoadLabel = formToolkit.createLabel(initGroup,
				"\u6700\u5C0F\u8D1F\u8377F1", SWT.NONE);
		minLoadLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		minLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		minLoadLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_8 = formToolkit.createLabel(initGroup, "N", SWT.NONE);
		lblNewLabel_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_8.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_8.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		F1Text = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		F1Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RectangularCoreFunction.getInstance().getAllText();
			}
		});
		F1Text.setText("0.0");
		GridData gd_F1Text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_F1Text.widthHint = 191;
		F1Text.setLayoutData(gd_F1Text);

		Label workLengthLabel = formToolkit.createLabel(initGroup,
				"\u5DE5\u4F5C\u884C\u7A0Bh", SWT.NONE);
		workLengthLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		workLengthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		workLengthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_9 = formToolkit.createLabel(initGroup, "mm", SWT.NONE);
		lblNewLabel_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_9.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		hText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		hText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RectangularCoreFunction.getInstance().getAllText();
			}
		});
		hText.setText("0.0");
		hText.setToolTipText("");
		GridData gd_hText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_hText.widthHint = 191;
		hText.setLayoutData(gd_hText);
		Label materialDiameterLabel = formToolkit.createLabel(initGroup,
				"\u5782\u76F4\u8F74\u7EBF\u8FB9\u957Fa", SWT.NONE);
		materialDiameterLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		materialDiameterLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		materialDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_10 = formToolkit.createLabel(initGroup, "mm", SWT.NONE);
		lblNewLabel_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_10.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_10.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		aCombo = new Combo(initGroup, SWT.READ_ONLY);
		aCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RectangularCoreFunction.getInstance().excepta();
			}
		});
		aCombo.setItems(new String[] {"0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0", "2.1", "2.2", "2.3", "2.4", "2.5", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0", "12.0", "13.0", "14.0", "15.0", "16.0"});
		GridData gd_aCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_aCombo.widthHint = 175;
		aCombo.setLayoutData(gd_aCombo);
		formToolkit.adapt(aCombo);
		formToolkit.paintBordersFor(aCombo);
		aCombo.select(1);

		Label mediumDiameterLabel = formToolkit.createLabel(initGroup,
				"\u5E73\u884C\u8F74\u7EBF\u8FB9\u957Fb", SWT.NONE);
		mediumDiameterLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		mediumDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		mediumDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_11 = formToolkit.createLabel(initGroup, "mm", SWT.NONE);
		lblNewLabel_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_11.setAlignment(SWT.CENTER);
		lblNewLabel_11.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_11.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_11.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		bText = formToolkit.createText(initGroup, "0.0", SWT.NONE);
		bText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RectangularCoreFunction.getInstance().getAllText();
			}
		});
		GridData gd_bText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_bText.widthHint = 191;
		bText.setLayoutData(gd_bText);

		Label windingRatioLabel = formToolkit.createLabel(initGroup,
				"\u65CB\u7ED5\u6BD4C", SWT.NONE);
		windingRatioLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		windingRatioLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		windingRatioLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_21 = formToolkit.createLabel(initGroup,
				"\u65E0\u91CF\u7EB2", SWT.CENTER);
		lblNewLabel_21.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_21.setAlignment(SWT.CENTER);
		lblNewLabel_21.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_21.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_21.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		
		CCombo = new Combo(initGroup, SWT.READ_ONLY);
		CCombo.setItems(new String[] {});
		GridData gd_CCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_CCombo.widthHint = 175;
		CCombo.setLayoutData(gd_CCombo);
		formToolkit.adapt(CCombo);
		formToolkit.paintBordersFor(CCombo);
		CCombo.select(0);
		Label pitchLabel = formToolkit.createLabel(initGroup,
				"\u8BD5\u7B97\u8282\u8DDDt", SWT.NONE);
		pitchLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		pitchLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		pitchLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_14 = formToolkit.createLabel(initGroup, "mm", SWT.NONE);
		lblNewLabel_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_14.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_14.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_14.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		tText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		tText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				RectangularCoreFunction.getInstance().getAllText();
			}
		});
		tText.setText("0.0");
		GridData gd_tText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_tText.widthHint = 191;
		tText.setLayoutData(gd_tText);
		initItem.setControl(initGroup);

		/*
		 * ¼ÆËã¹ý³Ì
		 */
		
		new Label(resultGroup, SWT.NONE);
		Label lblNewLabel = formToolkit.createLabel(resultGroup, "\u5355\u4F4D",
				SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		new Label(resultGroup, SWT.NONE);
		
		new Label(resultGroup, SWT.NONE);
		Label lbl1NewLabel = formToolkit.createLabel(resultGroup, "\u5355\u4F4D",
				SWT.NONE);
		lbl1NewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lbl1NewLabel.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lbl1NewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lbl1NewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		new Label(resultGroup, SWT.NONE);
		
		Label tensileStrenthLabel = formToolkit.createLabel(resultGroup,
				"\u6297\u62C9\u5F3A\u5EA6Rm", SWT.NONE);
		tensileStrenthLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tensileStrenthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		tensileStrenthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		Label lblNewLabel_5 = formToolkit.createLabel(resultGroup, "MPa", SWT.NONE);
		lblNewLabel_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		RmText = formToolkit.createText(resultGroup, "New Text", SWT.NONE);
		RmText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		RmText.setEditable(false);
		RmText.setText("0.0");
		RmText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label testShearStressLabel = formToolkit.createLabel(resultGroup,
				"\u8BB8\u7528\u5207\u5E94\u529B\u03C4p", SWT.NONE);
		testShearStressLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		testShearStressLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		testShearStressLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_6 = formToolkit.createLabel(resultGroup, "MPa", SWT.NONE);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		tpText = formToolkit.createText(resultGroup, "New Text", SWT.NONE);
		tpText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tpText.setEditable(false);
		tpText.setText("0.0");
		tpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label springDiameterLabel = formToolkit.createLabel(resultGroup,
				"\u5F39\u7C27\u4E2D\u5F84D", SWT.NONE);
		springDiameterLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		springDiameterLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		springDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_55 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_55.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_55.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_55.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_55.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		DText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		DText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		DText.setText("0.0");
		DText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label curvatureCoefficientLabel = formToolkit.createLabel(resultGroup,
				"\u5F39\u7C27\u521A\u5EA6K", SWT.NONE);
		curvatureCoefficientLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		curvatureCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		curvatureCoefficientLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_25 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_25.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_25.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_25.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_25.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		KText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		KText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		KText.setText("0.0");
		KText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label minLoadDeformationLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5C0F\u8D1F\u8377\u53D8\u5F62f1", SWT.NONE);
		minLoadDeformationLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		minLoadDeformationLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		minLoadDeformationLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		minLoadDeformationLabel.setAlignment(SWT.CENTER);

		Label lblNewLabel_30 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_30.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_30.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_30.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_30.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		f1Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		f1Text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		f1Text.setText("0.0");
		f1Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label maxLoadDeformationLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5927\u8D1F\u8377\u53D8\u5F62fn", SWT.NONE);
		maxLoadDeformationLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxLoadDeformationLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		maxLoadDeformationLabel.setAlignment(SWT.CENTER);
		maxLoadDeformationLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_29 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_29.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_29.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_29.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_29.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		fnText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		fnText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fnText.setText("0.0");
		fnText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label effectiveCoilNumberLabel = formToolkit.createLabel(resultGroup,
				"\u6709\u6548\u5708\u6570n", SWT.NONE);
		effectiveCoilNumberLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		effectiveCoilNumberLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		effectiveCoilNumberLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_19 = formToolkit.createLabel(resultGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_19.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_19.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_19.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_19.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		nText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		nText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		nText.setText("0.0");
		nText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label outsideDiameterLabel = formToolkit.createLabel(resultGroup,
				"\u5F39\u7C27\u5916\u5F84D2", SWT.NONE);
		outsideDiameterLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		outsideDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		outsideDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_12 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_12.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_12.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_12.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		D2Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		D2Text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		D2Text.setText("0.0");
		D2Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label insideDiameterLabel = formToolkit.createLabel(resultGroup,
				"\u5F39\u7C27\u5185\u5F84D1", SWT.NONE);
		insideDiameterLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		insideDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		insideDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_13 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_13.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_13.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_13.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		D1Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		D1Text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		D1Text.setText("0.0");
		D1Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label lblNewLabel_15 = formToolkit.createLabel(resultGroup,
				"\u95F4\u8DDD\u03B4", SWT.NONE);
		lblNewLabel_15.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_15.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblNewLabel_15.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_16 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_16.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_16.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_16.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_16.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		deltaText = formToolkit.createText(resultGroup, "New Text", SWT.NONE);
		deltaText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		deltaText.setEditable(false);
		deltaText.setText("0.0");
		deltaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label alphaLabel = formToolkit.createLabel(resultGroup,
				"\u87BA\u65CB\u89D2\u03B1", SWT.NONE);
		alphaLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		alphaLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		alphaLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label angelLabel = formToolkit.createLabel(resultGroup, "\u5F27\u5EA6",
				SWT.NONE);
		angelLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		angelLabel.setForeground(SWTResourceManager.getColor(0, 204, 255));
		angelLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		angelLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		alphaText = formToolkit.createText(resultGroup, "New Text", SWT.NONE);
		alphaText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		alphaText.setEditable(false);
		alphaText.setText("0");
		alphaText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label toalCoilNumberLabel = formToolkit.createLabel(resultGroup,
				"\u603B\u5708\u6570n1", SWT.NONE);
		toalCoilNumberLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		toalCoilNumberLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		toalCoilNumberLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_20 = formToolkit.createLabel(resultGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_20.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_20.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_20.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_20.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		n1Text = formToolkit.createText(resultGroup, "New Text", SWT.NONE);
		n1Text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		n1Text.setEditable(false);
		n1Text.setText("0.0");
		n1Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label freeHeightLabel = formToolkit.createLabel(resultGroup,
				"\u81EA\u7531\u9AD8\u5EA6H0", SWT.NONE);
		freeHeightLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		freeHeightLabel.setAlignment(SWT.CENTER);
		freeHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		freeHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_24 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_24.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_24.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_24.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_24.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		H0Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		H0Text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		H0Text.setText("0.0");
		H0Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label pressureHeightLabel = formToolkit.createLabel(resultGroup,
				"\u538B\u5E76\u9AD8\u5EA6Hb", SWT.NONE);
		pressureHeightLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		pressureHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		pressureHeightLabel.setAlignment(SWT.CENTER);
		pressureHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_32 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_32.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_32.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_32.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_32.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		HbText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		HbText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		HbText.setText("0.0");
		HbText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label spreadLengthLabel = formToolkit.createLabel(resultGroup,
				"\u5C55\u5F00\u957F\u5EA6L", SWT.NONE);
		spreadLengthLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		spreadLengthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		spreadLengthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_36 = formToolkit.createLabel(resultGroup, "mm", SWT.NONE);
		lblNewLabel_36.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_36.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_36.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_36.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		LText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		LText.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		LText.setText("0.0");
		LText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		new Label(resultGroup, SWT.NONE);
		new Label(resultGroup, SWT.NONE);
		new Label(resultGroup, SWT.NONE);
		
		/*
		 * Êä³ö½á¹û
		 */
		
		table = new Table(tableOutputGroup, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		table.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 11, SWT.NORMAL));
		table.setBounds(10, 21, 652, 466);
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
		
		Canvas canvas = new Canvas(picOutputGroup, SWT.NONE);
		canvas.setBounds(82, 42, 486, 311);
		formToolkit.adapt(canvas);
		formToolkit.paintBordersFor(canvas);
		canvas.setBackgroundImage(SWTResourceManager.getImage("res\\recular.png"));
		
		Label lblNewLabel_33 = formToolkit.createLabel(canvas, "b=", SWT.NONE);
		lblNewLabel_33.setBounds(81, 215, 21, 17);
		
		bPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		bPicText.setEditable(false);
		bPicText.setText(RectangularSection.bText.getText());
		bPicText.setBounds(101, 212, 34, 23);
		
		Label lblNewLabel_34 = formToolkit.createLabel(canvas, "D=", SWT.NONE);
		lblNewLabel_34.setBounds(200, 13, 18, 17);
		
		DPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		DPicText.setEditable(false);
		DPicText.setText(RectangularSection.DText.getText());
		DPicText.setBounds(218, 10, 63, 23);
		
		Label lblNewLabel_35 = formToolkit.createLabel(canvas, "D2=", SWT.NONE);
		lblNewLabel_35.setBounds(180, 61, 27, 17);
		
		D2PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		D2PicText.setEditable(false);
		D2PicText.setText(RectangularSection.D2Text.getText());
		D2PicText.setBounds(207, 58, 63, 23);
		
		prompt = formToolkit.createText(shell, "", SWT.BORDER | SWT.READ_ONLY);
		prompt.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		prompt.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		prompt.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		prompt.setVisible(true);
		prompt.setBounds(10, 561, 339, 27);
		
		btnNewButton = formToolkit.createButton(shell, "\u8FD4 \u56DE", SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				MainMenu.main(null);
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		btnNewButton.setVisible(true);
		btnNewButton.setBounds(576, 553, 107, 47);
		
		nextBtn = formToolkit.createButton(shell, "\u4E0B\u4E00\u6B65", SWT.NONE);
		nextBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				lastBtn.setVisible(true);
				nextBtn.setVisible(true);
				tabFolder.setSelection(tabFolder.getSelectionIndex() + 1);
				if (tabFolder.getSelectionIndex() == 0) {
					lastBtn.setVisible(false);
					nextBtn.setVisible(true);
					return;
				}
				if (tabFolder.getSelectionIndex() == (tabFolder
						.getItemCount() - 1)) {
					lastBtn.setVisible(true);
					nextBtn.setVisible(false);
					return;
				}
			}
		});
		nextBtn.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		nextBtn.setBounds(470, 553, 97, 47);
		
		lastBtn = formToolkit.createButton(shell, "\u4E0A\u4E00\u6B65", SWT.NONE);
		lastBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				lastBtn.setVisible(true);
				nextBtn.setVisible(true);
				tabFolder.setSelection(tabFolder.getSelectionIndex() - 1);
				if (tabFolder.getSelectionIndex() == 0) {
					lastBtn.setVisible(false);
					nextBtn.setVisible(true);
					return;
				}
				if (tabFolder.getSelectionIndex() == (tabFolder
						.getItemCount() - 1)) {
					lastBtn.setVisible(true);
					nextBtn.setVisible(false);
					return;
				}
			}
		});
		lastBtn.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		lastBtn.setBounds(367, 553, 97, 47);
		
		RectangularCoreFunction.getInstance().getAllText();
		RectangularCoreFunction.getInstance().getAllCombo();

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}