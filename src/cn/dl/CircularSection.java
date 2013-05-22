package cn.dl;

import java.text.DecimalFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

public class CircularSection implements AppConstants {
	// private static HashMap<Text_Var, Double> allText = new HashMap<Text_Var,
	// Double>();
	// private static HashMap<Combo_Var, Integer> allCombo = new
	// HashMap<Combo_Var, Integer>();
	private static final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private DecimalFormat df = new DecimalFormat("#0.00");
	public static Text RmText;
	public static Text tsText;
	public static Text F1Text, F1PicText;
	public static Text FnText;
	public static Text hText;
	public static Text D2Text;
	public static Text D1Text;
	public static Text tText, tPicText;
	public static Text FsText, FsPicText;
	public static Text RText;
	public static Text tpText;
	public static Text FjText;
	public static Text nText;
	public static Text n1Text;
	public static Text CText;
	public static Text FpieText;
	public static Text Fpie2Text;
	public static Text H0Text;
	public static Text H01Text;
	public static Text H02Text;
	public static Text fjText;
	public static Text fnText;
	public static Text f1Text;
	public static Text HjText;
	public static Text HbText;
	public static Text HnText;
	public static Text H1Text;
	public static Text actualhText;
	public static Text LText;
	public static Text tminText;
	public static Text tmaxText;
	public static Text tu0Text;
	public static Text SText;
	public static Text SminText;
	public static Text bText;
	public static Text CBText;
	public static Text FcText;
	public static Text feText;
	public static Text frText;
	public static Text KText;
	public static Text prompt;

	public static Text HsPicText;
	public static Text dPicText;
	public static Text DPicText;
	public static Text F2PicText;
	public static Text H2PicText;
	public static Text H1PicText;
	public static Text H0PicText;

	public static Combo endTypeCombo;
	public static Combo springMaterialCombo;
	public static Combo dCombo;
	public static Combo DCombo;
	public static Combo NCombo;
	public static Combo fixedModeCombo;
	public static Combo rodOrSleeveCombo;

	public static Table table;
	public static Button lastBtn = null;
	public static Button nextBtn = null;
	public static Button outputButton;
	public static boolean init;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public void open(final boolean init1) {
		init = init1;
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display, SWT.MIN);
		shell.setSize(712, 669);
		shell.setImage(SWTResourceManager.getImage("res\\icon.png"));
		shell.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setText("\u5706\u67F1\u87BA\u65CB\u538B\u7F29\u5F39\u7C27\u8BBE\u8BA1");

		/*
		 * ÉèÖÃÑ¡Ïî¿¨
		 */

		final TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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
		tabFolder.setBounds(10, 10, 673, 542);

		TabItem initItem = new TabItem(tabFolder, SWT.NONE);
		initItem.setText("\u539F\u59CB\u6761\u4EF6");
		Group initGroup = new Group(tabFolder, SWT.NONE);
		initGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout initLayout = new GridLayout(3, false);
		initLayout.verticalSpacing = 10;
		initLayout.marginTop = 10;
		initGroup.setLayout(initLayout);
		initGroup.setText("Ô­Ê¼Ìõ¼þÊäÈë");

		TabItem processItem = new TabItem(tabFolder, SWT.NONE);
		processItem.setText("\u8BA1\u7B97\u8FC7\u7A0B");
		Group processGroup = new Group(tabFolder, SWT.NONE);
		processGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout gl_processGroup = new GridLayout(6, false);
		gl_processGroup.verticalSpacing = 17;
		gl_processGroup.marginTop = 10;
		processGroup.setLayout(gl_processGroup);
		processGroup.setText("\u8BA1\u7B97\u8FC7\u7A0B");
		processItem.setControl(processGroup);

		TabItem resultItem = new TabItem(tabFolder, SWT.NONE);
		resultItem.setText("\u8BA1\u7B97\u7ED3\u679C");
		Group resultGroup = new Group(tabFolder, SWT.NONE);
		resultGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout resultLayout = new GridLayout(3, false);
		resultLayout.verticalSpacing = 17;
		resultLayout.marginTop = 10;
		resultGroup.setLayout(resultLayout);
		resultGroup.setText("\u8BA1\u7B97\u7ED3\u679C");
		resultItem.setControl(resultGroup);

		TabItem strengthCheckItem = new TabItem(tabFolder, SWT.NONE);
		strengthCheckItem.setText("\u75B2\u52B3\u5F3A\u5EA6\u6821\u6838");
		Group strengthCheckGroup = new Group(tabFolder, SWT.NONE);
		strengthCheckGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout strengthCheckLayout = new GridLayout(3, false);
		strengthCheckLayout.verticalSpacing = 17;
		strengthCheckLayout.marginTop = 10;
		strengthCheckGroup.setLayout(strengthCheckLayout);
		strengthCheckGroup.setText("\u75B2\u52B3\u5F3A\u5EA6\u6821\u6838");
		strengthCheckItem.setControl(strengthCheckGroup);

		TabItem stableCheckItem = new TabItem(tabFolder, SWT.NONE);
		stableCheckItem.setText("\u7A33\u5B9A\u6027\u6821\u6838");
		Group stableCheckGroup = new Group(tabFolder, SWT.NONE);
		stableCheckGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout stableCheckLayout = new GridLayout(3, false);
		stableCheckLayout.verticalSpacing = 17;
		stableCheckLayout.marginTop = 10;
		stableCheckGroup.setLayout(stableCheckLayout);
		stableCheckGroup.setText("\u7A33\u5B9A\u6027\u6821\u6838");
		stableCheckItem.setControl(stableCheckGroup);

		TabItem resonanceCheckItem = new TabItem(tabFolder, SWT.NONE);
		resonanceCheckItem.setText("\u5171\u632F\u6821\u6838");
		Group resonanceCheckGroup = new Group(tabFolder, SWT.NONE);
		resonanceCheckGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridLayout resonanceCheckLayout = new GridLayout(3, false);
		resonanceCheckLayout.verticalSpacing = 17;
		resonanceCheckLayout.marginTop = 10;
		resonanceCheckGroup.setLayout(resonanceCheckLayout);
		resonanceCheckGroup.setText("\u5171\u632F\u6821\u6838");
		resonanceCheckItem.setControl(resonanceCheckGroup);

		TabItem tableOutputItem = new TabItem(tabFolder, SWT.NONE);
		tableOutputItem.setText("\u8868\u683C\u8F93\u51FA");
		Group tableOutputGroup = new Group(tabFolder, SWT.NONE);
		tableOutputGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tableOutputGroup.setText("\u8868\u683C\u8F93\u51FA");
		tableOutputItem.setControl(tableOutputGroup);

		TabItem picOutputItem = new TabItem(tabFolder, SWT.NONE);
		picOutputItem.setText("\u56FE\u5F62\u8F93\u51FA");
		Group picOutputGroup = new Group(tabFolder, SWT.NONE);
		picOutputGroup.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		picOutputGroup.setText("\u56FE\u5F62\u8F93\u51FA");
		picOutputItem.setControl(picOutputGroup);

		/*
		 * Ô­Ê¼Ìõ¼þ
		 */

		new Label(initGroup, SWT.NONE);
		Label lblNewLabel_3 = formToolkit.createLabel(initGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		lblNewLabel_3.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_3.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		new Label(initGroup, SWT.NONE);

		Label endTypeLabel = formToolkit.createLabel(initGroup,
				"\u7AEF\u90E8\u5F62\u5F0F", SWT.NONE);
		endTypeLabel.setAlignment(SWT.CENTER);
		endTypeLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		endTypeLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		GridData gd_endTypeLabel = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_endTypeLabel.widthHint = 213;
		endTypeLabel.setLayoutData(gd_endTypeLabel);

		Label lblNewLabel_1 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_1.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_1.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		GridData gd_lblNewLabel_1 = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel_1.widthHint = 140;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);

		endTypeCombo = new Combo(initGroup, SWT.READ_ONLY);
		endTypeCombo.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		endTypeCombo.setItems(new String[] { "\u652F\u6491\u57082\u5708" });
		GridData gd_endTypeCombo = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_endTypeCombo.widthHint = 175;
		endTypeCombo.setLayoutData(gd_endTypeCombo);
		formToolkit.adapt(endTypeCombo);
		formToolkit.paintBordersFor(endTypeCombo);
		endTypeCombo.select(0);

		Label springMaterialLabel = formToolkit.createLabel(initGroup,
				"\u5F39\u7C27\u6750\u6599", SWT.NONE);
		springMaterialLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		springMaterialLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		springMaterialLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		Label lblNewLabel_4 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_4.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_4.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_4.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		springMaterialCombo = new Combo(initGroup, SWT.READ_ONLY);
		springMaterialCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CircularCoreFunction.getInstance().getAllCombo();
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
		maxLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		maxLoadLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxLoadLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_7 = formToolkit.createLabel(initGroup, "N", SWT.NONE);
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_7.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_7.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		FnText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		FnText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText1();
			}
		});
		FnText.setText("0.0");
		GridData gd_FnText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_FnText.widthHint = 191;
		FnText.setLayoutData(gd_FnText);

		Label minLoadLabel = formToolkit.createLabel(initGroup,
				"\u6700\u5C0F\u8D1F\u8377F1", SWT.NONE);
		minLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		minLoadLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		minLoadLabel
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_8 = formToolkit.createLabel(initGroup, "N", SWT.NONE);
		lblNewLabel_8.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_8.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_8.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_8.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		F1Text = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		F1Text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText();
			}
		});
		F1Text.setText("0.0");
		GridData gd_F1Text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_F1Text.widthHint = 191;
		F1Text.setLayoutData(gd_F1Text);

		Label workLengthLabel = formToolkit.createLabel(initGroup,
				"\u5DE5\u4F5C\u884C\u7A0Bh", SWT.NONE);
		workLengthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		workLengthLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		workLengthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_9 = formToolkit
				.createLabel(initGroup, "mm", SWT.NONE);
		lblNewLabel_9.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_9.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_9.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_9.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		hText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		hText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText();
			}
		});
		hText.setText("0.0");
		hText.setToolTipText("");
		GridData gd_hText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_hText.widthHint = 191;
		hText.setLayoutData(gd_hText);
		Label materialDiameterLabel = formToolkit.createLabel(initGroup,
				"\u6750\u6599\u76F4\u5F84d", SWT.NONE);
		materialDiameterLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		materialDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		materialDiameterLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_10 = formToolkit.createLabel(initGroup, "mm",
				SWT.NONE);
		lblNewLabel_10.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_10.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_10.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		dCombo = new Combo(initGroup, SWT.READ_ONLY);
		dCombo.setItems(new String[] {});
		GridData gd_dCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_dCombo.widthHint = 175;
		dCombo.setLayoutData(gd_dCombo);
		formToolkit.adapt(dCombo);
		formToolkit.paintBordersFor(dCombo);
		dCombo.select(0);

		Label mediumDiameterLabel = formToolkit.createLabel(initGroup,
				"\u5F39\u7C27\u4E2D\u5F84D", SWT.NONE);
		mediumDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		mediumDiameterLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		mediumDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_11 = formToolkit.createLabel(initGroup, "mm",
				SWT.NONE);
		lblNewLabel_11.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_11.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_11.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_11.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		DCombo = new Combo(initGroup, SWT.READ_ONLY);
		DCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CircularCoreFunction.getInstance().getAllCombo();
			}
		});
		DCombo.setItems(new String[] { "0.4", "0.5", "0.6", "0.7", "0.8",
				"0.9", "1", "1.2", "1.6", "2", "2.5", "3", "3.5", "4", "4.5",
				"5", "6", "7", "8", "9", "10", "12", "16", "20", "25", "30",
				"35", "40", "45", "50", "55", "60", "70", "80", "90", "100",
				"110", "120", "130", "140", "150", "160", "180", "200", "220",
				"240", "260", "280", "300", "320", "360", "400" });
		GridData gd_DCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_DCombo.widthHint = 175;
		DCombo.setLayoutData(gd_DCombo);
		formToolkit.adapt(DCombo);
		formToolkit.paintBordersFor(DCombo);
		DCombo.select(0);

		Label pitchLabel = formToolkit.createLabel(initGroup,
				"\u8BD5\u7B97\u8282\u8DDDt", SWT.NONE);
		pitchLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		pitchLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		pitchLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_14 = formToolkit.createLabel(initGroup, "mm",
				SWT.NONE);
		lblNewLabel_14.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_14.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_14.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_14.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		tText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		tText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText();
			}
		});
		tText.setText("0.0");
		GridData gd_tText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_tText.widthHint = 191;
		tText.setLayoutData(gd_tText);

		Label loadCycleNumLabel = formToolkit.createLabel(initGroup,
				"\u8D1F\u8377\u5FAA\u73AF\u6B21\u6570N", SWT.NONE);
		loadCycleNumLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		loadCycleNumLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		loadCycleNumLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_37 = formToolkit.createLabel(initGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_37.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_37.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_37.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_37.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		NCombo = new Combo(initGroup, SWT.READ_ONLY);
		NCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CircularCoreFunction.getInstance().getAllCombo();
			}
		});
		NCombo.setItems(new String[] { "10000", "100000", "1000000", "10000000" });
		GridData gd_NCombo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_NCombo.widthHint = 175;
		NCombo.setLayoutData(gd_NCombo);
		formToolkit.adapt(NCombo);
		formToolkit.paintBordersFor(NCombo);
		NCombo.select(0);

		Label userMinSafetyCoefficientLabel = formToolkit.createLabel(
				initGroup,
				"\u8BBE\u5B9A\u6700\u5C0F\u5B89\u5168\u7CFB\u6570Smin",
				SWT.NONE);
		userMinSafetyCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		userMinSafetyCoefficientLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		userMinSafetyCoefficientLabel.setFont(SWTResourceManager.getFont(
				"Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_42 = formToolkit.createLabel(initGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_42.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_42.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_42.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_42.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		SminText = formToolkit.createText(initGroup, "New Text", SWT.NONE);
		SminText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText();
			}
		});
		SminText.setText("0.0");
		SminText.setToolTipText("×îÐ¡°²È«ÏµÊýSmin=1.1~1.3");
		GridData gd_SminText = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_SminText.widthHint = 191;
		SminText.setLayoutData(gd_SminText);

		Label fixedModeLabel = formToolkit.createLabel(initGroup,
				"\u56FA\u5B9A\u65B9\u5F0F", SWT.NONE);
		fixedModeLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		fixedModeLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fixedModeLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_44 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_44.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_44.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_44.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_44.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		fixedModeCombo = new Combo(initGroup, SWT.READ_ONLY);
		fixedModeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CircularCoreFunction.getInstance().getAllCombo();
			}
		});
		fixedModeCombo.setItems(new String[] { "\u4E24\u7AEF\u56FA\u5B9A",
				"\u4E00\u7AEF\u56FA\u5B9A\uFF0C\u4E00\u7AEF\u56DE\u8F6C",
				"\u4E24\u7AEF\u56DE\u8F6C" });
		GridData gd_fixedModeCombo = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_fixedModeCombo.widthHint = 175;
		fixedModeCombo.setLayoutData(gd_fixedModeCombo);
		formToolkit.adapt(fixedModeCombo);
		formToolkit.paintBordersFor(fixedModeCombo);
		fixedModeCombo.select(0);

		Label guideRodSleeveLabel = formToolkit.createLabel(initGroup,
				"\u5BFC\u6746\u6216\u5BFC\u5957", SWT.NONE);
		guideRodSleeveLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		guideRodSleeveLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		guideRodSleeveLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_46 = formToolkit.createLabel(initGroup,
				"\u4E0D\u9002\u7528", SWT.NONE);
		lblNewLabel_46.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_46.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_46.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_46.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		rodOrSleeveCombo = new Combo(initGroup, SWT.READ_ONLY);
		rodOrSleeveCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CircularCoreFunction.getInstance().getAllCombo();
			}
		});
		rodOrSleeveCombo.setItems(new String[] {
				"\u6709\u5BFC\u6746\u6216\u5BFC\u5957",
				"\u65E0\u5BFC\u6746\u6216\u5BFC\u5957" });
		GridData gd_rodOrSleeveCombo = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_rodOrSleeveCombo.widthHint = 175;
		rodOrSleeveCombo.setLayoutData(gd_rodOrSleeveCombo);
		formToolkit.adapt(rodOrSleeveCombo);
		formToolkit.paintBordersFor(rodOrSleeveCombo);
		rodOrSleeveCombo.select(0);
		initItem.setControl(initGroup);

		/*
		 * ¼ÆËã¹ý³Ì
		 */

		new Label(processGroup, SWT.NONE);
		Label lblNewLabel_31 = formToolkit.createLabel(processGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_31.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_31.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblNewLabel_31.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_31.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(processGroup, SWT.NONE);

		new Label(processGroup, SWT.NONE);
		Label lblNewLabel_311 = formToolkit.createLabel(processGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_311.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_311.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblNewLabel_311.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_311.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(processGroup, SWT.NONE);

		Label tensileStrenthLabel = formToolkit.createLabel(processGroup,
				"\u6297\u62C9\u5F3A\u5EA6Rm", SWT.NONE);
		tensileStrenthLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tensileStrenthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		tensileStrenthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		Label lblNewLabel_5 = formToolkit.createLabel(processGroup, "MPa",
				SWT.NONE);
		lblNewLabel_5.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_5.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_5.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		RmText = formToolkit.createText(processGroup, "New Text", SWT.NONE);
		RmText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		RmText.setEditable(false);
		RmText.setText("0.0");
		RmText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label testShearStressLabel = formToolkit.createLabel(processGroup,
				"\u8BD5\u9A8C\u5207\u5E94\u529B\u03C4s", SWT.NONE);
		testShearStressLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		testShearStressLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		testShearStressLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_6 = formToolkit.createLabel(processGroup, "MPa",
				SWT.NONE);
		lblNewLabel_6.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_6.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_6.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		lblNewLabel_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));

		tsText = formToolkit.createText(processGroup, "New Text", SWT.NONE);
		tsText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tsText.setEditable(false);
		tsText.setText("0.0");
		tsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label outsideDiameterLabel = formToolkit.createLabel(processGroup,
				"\u5F39\u7C27\u5916\u5F84D2", SWT.NONE);
		outsideDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		outsideDiameterLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		outsideDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_12 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_12.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_12.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_12.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_12.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		D2Text = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		D2Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		D2Text.setText("0.0");
		D2Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label insideDiameterLabel = formToolkit.createLabel(processGroup,
				"\u5F39\u7C27\u5185\u5F84D1", SWT.NONE);
		insideDiameterLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		insideDiameterLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		insideDiameterLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_13 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_13.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_13.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_13.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_13.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		D1Text = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		D1Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		D1Text.setText("0.0");
		D1Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label testLoadLabel = formToolkit.createLabel(processGroup,
				"\u8BD5\u9A8C\u8D1F\u8377Fs", SWT.NONE);
		testLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1));
		testLoadLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		testLoadLabel.setFont(SWTResourceManager
				.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_15 = formToolkit.createLabel(processGroup, "N",
				SWT.NONE);
		lblNewLabel_15.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_15.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_15.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_15.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		FsText = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		FsText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FsText.setText("0.0");
		FsText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label limitStressCoefficientLabel = formToolkit
				.createLabel(processGroup,
						"\u4E0A\u9650\u5E94\u529B\u7CFB\u6570R", SWT.NONE);
		limitStressCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		limitStressCoefficientLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));
		limitStressCoefficientLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_16 = formToolkit.createLabel(processGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_16.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_16.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_16.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_16.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		RText = formToolkit.createText(processGroup, "New Text", SWT.READ_ONLY);
		RText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		RText.setText("0.0");
		RText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label allowableShearStressLabel = formToolkit.createLabel(processGroup,
				"\u8BB8\u7528\u5207\u5E94\u529B\u03C4p", SWT.NONE);
		allowableShearStressLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		allowableShearStressLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		allowableShearStressLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));

		Label lblNewLabel_17 = formToolkit.createLabel(processGroup, "MPa",
				SWT.NONE);
		lblNewLabel_17.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_17.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_17.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_17.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		tpText = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		tpText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tpText.setText("0.0");
		tpText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label limitLoadLabel = formToolkit.createLabel(processGroup,
				"\u6781\u9650\u8D1F\u8377Fj", SWT.NONE);
		limitLoadLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		limitLoadLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		limitLoadLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_18 = formToolkit.createLabel(processGroup, "N",
				SWT.NONE);
		lblNewLabel_18.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_18.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_18.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_18.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		FjText = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		FjText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FjText.setText("0.0");
		FjText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label effectiveCoilNumberLabel = formToolkit.createLabel(processGroup,
				"\u6709\u6548\u5708\u6570n", SWT.NONE);
		effectiveCoilNumberLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		effectiveCoilNumberLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		effectiveCoilNumberLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_19 = formToolkit.createLabel(processGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_19.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_19.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_19.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_19.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		nText = formToolkit.createText(processGroup, "New Text", SWT.READ_ONLY);
		nText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		nText.setText("0.0");
		nText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label toalCoilNumberLabel = formToolkit.createLabel(processGroup,
				"\u603B\u5708\u6570n1", SWT.NONE);
		toalCoilNumberLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		toalCoilNumberLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		toalCoilNumberLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_20 = formToolkit.createLabel(processGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_20.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_20.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_20.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_20.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		n1Text = formToolkit.createText(processGroup, "New Text", SWT.NONE);
		n1Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		n1Text.setEditable(false);
		n1Text.setText("0.0");
		n1Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label windingRatioLabel = formToolkit.createLabel(processGroup,
				"\u65CB\u7ED5\u6BD4C", SWT.NONE);
		windingRatioLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		windingRatioLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		windingRatioLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_21 = formToolkit.createLabel(processGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_21.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_21.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_21.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_21.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		CText = formToolkit.createText(processGroup, "New Text", SWT.READ_ONLY);
		CText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		CText.setText("0.0");
		CText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label requiredRigidityLabel = formToolkit.createLabel(processGroup,
				"\u8981\u6C42\u521A\u5EA6F'", SWT.NONE);
		requiredRigidityLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		requiredRigidityLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		requiredRigidityLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_22 = formToolkit.createLabel(processGroup, "N/mm",
				SWT.NONE);
		lblNewLabel_22.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_22.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_22.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_22.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		FpieText = formToolkit.createText(processGroup, "New Text",
				SWT.READ_ONLY);
		FpieText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FpieText.setText("0.0");
		FpieText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label actualRigidityLabel = formToolkit.createLabel(processGroup,
				"\u5B9E\u9645\u521A\u5EA6F''", SWT.NONE);
		actualRigidityLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		actualRigidityLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		actualRigidityLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_23 = formToolkit.createLabel(processGroup, "N/mm",
				SWT.NONE);
		lblNewLabel_23.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_23.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_23.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_23.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		Fpie2Text = formToolkit.createText(processGroup, "New Text",
				SWT.READ_ONLY);
		Fpie2Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		Fpie2Text.setText("0.0");
		Fpie2Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label freeHeightLabel = formToolkit.createLabel(processGroup,
				"\u81EA\u7531\u9AD8\u5EA6H0", SWT.NONE);
		freeHeightLabel.setAlignment(SWT.CENTER);
		freeHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		freeHeightLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		freeHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_24 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_24.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_24.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_24.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_24.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		H0Text = formToolkit
				.createText(processGroup, "New Text", SWT.READ_ONLY);
		H0Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		H0Text.setText("0.0");
		H0Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label curvatureCoefficientLabel = formToolkit.createLabel(processGroup,
				"\u66F2\u5EA6\u7CFB\u6570K", SWT.NONE);
		curvatureCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		curvatureCoefficientLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		curvatureCoefficientLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));

		Label lblNewLabel_25 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_25.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_25.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_25.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_25.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		KText = formToolkit.createText(processGroup, "New Text", SWT.READ_ONLY);
		KText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		KText.setText("0.0");
		KText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Label referenceHeight01Label = formToolkit.createLabel(processGroup,
				"\u53C2\u8003\u81EA\u7531\u9AD8\u5EA6H01", SWT.NONE);
		referenceHeight01Label.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		referenceHeight01Label.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		referenceHeight01Label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_26 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_26.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_26.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_26.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_26.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		H01Text = formToolkit.createText(processGroup, "New Text",
				SWT.READ_ONLY);
		H01Text.setText("0.0");
		H01Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		H01Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label referenceHeight02Label = formToolkit.createLabel(processGroup,
				"\u53C2\u8003\u81EA\u7531\u9AD8\u5EA6H02", SWT.NONE);
		referenceHeight02Label.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		referenceHeight02Label.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		referenceHeight02Label.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_27 = formToolkit.createLabel(processGroup, "mm",
				SWT.NONE);
		lblNewLabel_27.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_27.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_27.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_27.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		H02Text = formToolkit.createText(processGroup, "New Text", SWT.NONE);
		H02Text.setEditable(false);
		H02Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		H02Text.setText("0.0");
		H02Text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		new Label(processGroup, SWT.NONE);
		new Label(processGroup, SWT.NONE);
		new Label(processGroup, SWT.NONE);

		/*
		 * ¼ÆËã½á¹û
		 */

		new Label(resultGroup, SWT.NONE);
		Label lblNewLabel_50 = formToolkit.createLabel(resultGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_50.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_50.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblNewLabel_50.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_50.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(resultGroup, SWT.NONE);

		Label limitLoadDeformationLabel = formToolkit.createLabel(resultGroup,
				"\u6781\u9650\u8D1F\u8377\u53D8\u5F62fj", SWT.NONE);
		GridData gd_limitLoadDeformationLabel = new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1);
		gd_limitLoadDeformationLabel.widthHint = 213;
		limitLoadDeformationLabel.setLayoutData(gd_limitLoadDeformationLabel);
		limitLoadDeformationLabel.setAlignment(SWT.CENTER);
		limitLoadDeformationLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		limitLoadDeformationLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));

		Label lblNewLabel_28 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_28.setAlignment(SWT.CENTER);
		lblNewLabel_28.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_28.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_28.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		GridData gd_lblNewLabel_28 = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel_28.widthHint = 140;
		lblNewLabel_28.setLayoutData(gd_lblNewLabel_28);

		fjText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		fjText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fjText.setText("0.0");
		GridData gd_fjText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_fjText.widthHint = 191;
		fjText.setLayoutData(gd_fjText);

		Label maxLoadDeformationLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5927\u8D1F\u8377\u53D8\u5F62fn", SWT.NONE);
		maxLoadDeformationLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		maxLoadDeformationLabel.setAlignment(SWT.CENTER);
		maxLoadDeformationLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxLoadDeformationLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_29 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_29.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_29.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_29.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_29.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		fnText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		fnText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fnText.setText("0.0");
		GridData gd_fnText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_fnText.widthHint = 191;
		fnText.setLayoutData(gd_fnText);

		Label minLoadDeformationLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5C0F\u8D1F\u8377\u53D8\u5F62f1", SWT.NONE);
		minLoadDeformationLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		minLoadDeformationLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		minLoadDeformationLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		minLoadDeformationLabel.setAlignment(SWT.CENTER);

		Label lblNewLabel_30 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_30.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_30.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_30.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_30.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		f1Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		f1Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		f1Text.setText("0.0");
		GridData gd_f1Text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_f1Text.widthHint = 191;
		f1Text.setLayoutData(gd_f1Text);

		Label limitLoadHeightLabel = formToolkit.createLabel(resultGroup,
				"\u6781\u9650\u8D1F\u8377\u9AD8\u5EA6Hj", SWT.NONE);
		limitLoadHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		limitLoadHeightLabel.setAlignment(SWT.CENTER);
		limitLoadHeightLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		limitLoadHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_3111 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_3111
				.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_3111.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_3111.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_3111.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		HjText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		HjText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		HjText.setText("0.0");
		GridData gd_HjText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_HjText.widthHint = 191;
		HjText.setLayoutData(gd_HjText);

		Label pressureHeightLabel = formToolkit.createLabel(resultGroup,
				"\u538B\u5E76\u9AD8\u5EA6Hb", SWT.NONE);
		pressureHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		pressureHeightLabel.setAlignment(SWT.CENTER);
		pressureHeightLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		pressureHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_32 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_32.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_32.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_32.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_32.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		HbText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		HbText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		HbText.setText("0.0");
		GridData gd_HbText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_HbText.widthHint = 191;
		HbText.setLayoutData(gd_HbText);

		Label maxLoadHeightLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5927\u8D1F\u8377\u9AD8\u5EA6Hn", SWT.NONE);
		maxLoadHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		maxLoadHeightLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxLoadHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_33 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_33.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_33.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_33.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_33.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		HnText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		HnText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		HnText.setText("0.0");
		GridData gd_HnText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_HnText.widthHint = 191;
		HnText.setLayoutData(gd_HnText);

		Label minLoadHeightLabel = formToolkit.createLabel(resultGroup,
				"\u6700\u5C0F\u8D1F\u8377\u9AD8\u5EA6H1", SWT.NONE);
		minLoadHeightLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		minLoadHeightLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		minLoadHeightLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_34 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_34.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_34.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_34.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_34.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		H1Text = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		H1Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		H1Text.setText("0.0");
		GridData gd_H1Text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_H1Text.widthHint = 191;
		H1Text.setLayoutData(gd_H1Text);

		Label actualWorkLengthLabel = formToolkit.createLabel(resultGroup,
				"\u5B9E\u9645\u5DE5\u4F5C\u884C\u7A0Bh", SWT.NONE);
		actualWorkLengthLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		actualWorkLengthLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		actualWorkLengthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_35 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_35.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_35.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_35.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_35.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		actualhText = formToolkit.createText(resultGroup, "New Text",
				SWT.READ_ONLY);
		actualhText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		actualhText.setText("0.0");
		GridData gd_actualhText = new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		gd_actualhText.widthHint = 191;
		actualhText.setLayoutData(gd_actualhText);

		Label spreadLengthLabel = formToolkit.createLabel(resultGroup,
				"\u5C55\u5F00\u957F\u5EA6L", SWT.NONE);
		spreadLengthLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		spreadLengthLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		spreadLengthLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));

		Label lblNewLabel_36 = formToolkit.createLabel(resultGroup, "mm",
				SWT.NONE);
		lblNewLabel_36.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_36.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_36.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_36.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		LText = formToolkit.createText(resultGroup, "New Text", SWT.READ_ONLY);
		LText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		LText.setText("0.0");
		GridData gd_LText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_LText.widthHint = 191;
		LText.setLayoutData(gd_LText);

		/*
		 * Æ£ÀÍÇ¿¶ÈÐ£ºË
		 */

		new Label(strengthCheckGroup, SWT.NONE);
		Label lblNewLabel_51 = formToolkit.createLabel(strengthCheckGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_51.setForeground(SWTResourceManager.getColor(0, 153, 255));
		lblNewLabel_51.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		lblNewLabel_51.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_51.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(strengthCheckGroup, SWT.NONE);

		Label minShearStressLabel = formToolkit.createLabel(strengthCheckGroup,
				"\u6700\u5C0F\u5207\u5E94\u529B\u03C4min", SWT.NONE);
		minShearStressLabel.setAlignment(SWT.CENTER);
		GridData gd_minShearStressLabel = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_minShearStressLabel.widthHint = 213;
		minShearStressLabel.setLayoutData(gd_minShearStressLabel);
		minShearStressLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		minShearStressLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_38 = formToolkit.createLabel(strengthCheckGroup,
				"MPa", SWT.NONE);
		lblNewLabel_38.setAlignment(SWT.CENTER);
		lblNewLabel_38.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_38.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_38.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		GridData gd_lblNewLabel_38 = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel_38.widthHint = 140;
		lblNewLabel_38.setLayoutData(gd_lblNewLabel_38);

		tminText = formToolkit.createText(strengthCheckGroup, "New Text",
				SWT.READ_ONLY);
		tminText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tminText.setText("0.0");
		GridData gd_tminText = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_tminText.widthHint = 191;
		tminText.setLayoutData(gd_tminText);

		Label maxShearStressLabel = formToolkit.createLabel(strengthCheckGroup,
				"\u6700\u5927\u5207\u5E94\u529B\u03C4max", SWT.NONE);
		maxShearStressLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		maxShearStressLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		maxShearStressLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_39 = formToolkit.createLabel(strengthCheckGroup,
				"MPa", SWT.NONE);
		lblNewLabel_39.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_39.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_39.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_39.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		tmaxText = formToolkit.createText(strengthCheckGroup, "New Text",
				SWT.READ_ONLY);
		tmaxText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tmaxText.setText("0.0");
		GridData gd_tmaxText = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_tmaxText.widthHint = 191;
		tmaxText.setLayoutData(gd_tmaxText);

		Label fatigueLimitLabel = formToolkit.createLabel(strengthCheckGroup,
				"\u8109\u52A8\u75B2\u52B3\u6781\u9650\u03C4u0", SWT.NONE);
		fatigueLimitLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));
		fatigueLimitLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fatigueLimitLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_40 = formToolkit.createLabel(strengthCheckGroup,
				"MPa", SWT.NONE);
		lblNewLabel_40.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_40.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_40.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_40.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		tu0Text = formToolkit.createText(strengthCheckGroup, "New Text",
				SWT.READ_ONLY);
		tu0Text.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		tu0Text.setText("0.0");
		GridData gd_tu0Text = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_tu0Text.widthHint = 191;
		tu0Text.setLayoutData(gd_tu0Text);

		Label fatigueSafetyCoefficientLabel = formToolkit.createLabel(
				strengthCheckGroup, "\u75B2\u52B3\u5B89\u5168\u7CFB\u6570S",
				SWT.NONE);
		fatigueSafetyCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		fatigueSafetyCoefficientLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		fatigueSafetyCoefficientLabel.setFont(SWTResourceManager.getFont(
				"Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));

		Label lblNewLabel_41 = formToolkit.createLabel(strengthCheckGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_41.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_41.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_41.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_41.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		SText = formToolkit.createText(strengthCheckGroup, "New Text",
				SWT.READ_ONLY);
		SText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		SText.setText("0.0");
		GridData gd_SText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_SText.widthHint = 191;
		SText.setLayoutData(gd_SText);

		/*
		 * ÎÈ¶¨ÐÔÐ£ºË
		 */

		new Label(stableCheckGroup, SWT.NONE);
		Label lblNewLabel_52 = formToolkit.createLabel(stableCheckGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_52.setAlignment(SWT.CENTER);
		lblNewLabel_52.setForeground(SWTResourceManager.getColor(0, 153, 255));
		GridData gd_lblNewLabel_52 = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel_52.widthHint = 140;
		lblNewLabel_52.setLayoutData(gd_lblNewLabel_52);
		lblNewLabel_52.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_52.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(stableCheckGroup, SWT.NONE);

		Label heightDiameterRatioLabel = formToolkit.createLabel(
				stableCheckGroup, "\u9AD8\u5F84\u6BD4b", SWT.NONE);
		heightDiameterRatioLabel.setAlignment(SWT.CENTER);
		GridData gd_heightDiameterRatioLabel = new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1);
		gd_heightDiameterRatioLabel.widthHint = 213;
		heightDiameterRatioLabel.setLayoutData(gd_heightDiameterRatioLabel);
		heightDiameterRatioLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		heightDiameterRatioLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_43 = formToolkit.createLabel(stableCheckGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_43.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_43.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_43.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_43.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		bText = formToolkit.createText(stableCheckGroup, "New Text",
				SWT.READ_ONLY);
		bText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		bText.setText("0.0");
		GridData gd_bText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_bText.widthHint = 191;
		bText.setLayoutData(gd_bText);

		Label stabilityCoefficientLabel = formToolkit.createLabel(
				stableCheckGroup, "\u7A33\u5B9A\u7CFB\u6570CB", SWT.NONE);
		stabilityCoefficientLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		stabilityCoefficientLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		stabilityCoefficientLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));

		Label lblNewLabel_45 = formToolkit.createLabel(stableCheckGroup,
				"\u65E0\u91CF\u7EB2", SWT.NONE);
		lblNewLabel_45.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_45.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_45.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_45.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		CBText = formToolkit.createText(stableCheckGroup, "New Text", SWT.NONE);
		CBText.setEditable(false);
		CBText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		CBText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CircularCoreFunction.getInstance().getAllText();
			}
		});
		CBText.setText("0.0");
		GridData gd_CBText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_CBText.widthHint = 191;
		CBText.setLayoutData(gd_CBText);

		Label stabilityCriticalLoadLabel = formToolkit.createLabel(
				stableCheckGroup,
				"\u7A33\u5B9A\u6027\u4E34\u754C\u8D1F\u8377Fc", SWT.NONE);
		stabilityCriticalLoadLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		stabilityCriticalLoadLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		stabilityCriticalLoadLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ",
				14, SWT.NORMAL));

		Label lblNewLabel_47 = formToolkit.createLabel(stableCheckGroup, "N",
				SWT.NONE);
		lblNewLabel_47.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_47.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_47.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_47.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		FcText = formToolkit.createText(stableCheckGroup, "New Text",
				SWT.READ_ONLY);
		FcText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		FcText.setText("0.0");
		GridData gd_FcText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_FcText.widthHint = 191;
		FcText.setLayoutData(gd_FcText);

		/*
		 * ¹²ÕñÐ£ºË
		 */

		new Label(resonanceCheckGroup, SWT.NONE);
		Label lblNewLabel_53 = formToolkit.createLabel(resonanceCheckGroup,
				"\u5355\u4F4D", SWT.NONE);
		lblNewLabel_53.setAlignment(SWT.CENTER);
		lblNewLabel_53.setForeground(SWTResourceManager.getColor(0, 153, 255));
		GridData gd_lblNewLabel_53 = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_lblNewLabel_53.widthHint = 140;
		lblNewLabel_53.setLayoutData(gd_lblNewLabel_53);
		lblNewLabel_53.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_53.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		new Label(resonanceCheckGroup, SWT.NONE);

		Label selfVibrationFreqLabel = formToolkit.createLabel(
				resonanceCheckGroup, "\u81EA\u632F\u9891\u7387fe", SWT.NONE);
		selfVibrationFreqLabel.setAlignment(SWT.CENTER);
		GridData gd_selfVibrationFreqLabel = new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1);
		gd_selfVibrationFreqLabel.widthHint = 213;
		selfVibrationFreqLabel.setLayoutData(gd_selfVibrationFreqLabel);
		selfVibrationFreqLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		selfVibrationFreqLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_48 = formToolkit.createLabel(resonanceCheckGroup,
				"Hz", SWT.NONE);
		lblNewLabel_48.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_48.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_48.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_48.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		feText = formToolkit.createText(resonanceCheckGroup, "New Text",
				SWT.READ_ONLY);
		feText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		feText.setText("0.0");
		GridData gd_feText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_feText.widthHint = 191;
		feText.setLayoutData(gd_feText);

		Label forceVibrationFreqLabel = formToolkit.createLabel(
				resonanceCheckGroup, "\u5F3A\u8FEB\u9707\u52A8\u9891\u7387fr",
				SWT.NONE);
		forceVibrationFreqLabel.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		forceVibrationFreqLabel.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		forceVibrationFreqLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));

		Label lblNewLabel_49 = formToolkit.createLabel(resonanceCheckGroup,
				"Hz", SWT.NONE);
		lblNewLabel_49.setForeground(SWTResourceManager.getColor(0, 204, 255));
		lblNewLabel_49.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblNewLabel_49.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14,
				SWT.NORMAL));
		lblNewLabel_49.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1));

		frText = formToolkit.createText(resonanceCheckGroup, "New Text",
				SWT.NONE);
		frText.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		frText.setEditable(false);
		frText.setText("0.0");
		GridData gd_frText = new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1);
		gd_frText.widthHint = 191;
		frText.setLayoutData(gd_frText);

		/*
		 * ±í¸ñÊä³ö
		 */

		table = new Table(tableOutputGroup, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
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

		/*
		 * Í¼ÐÎÊä³ö
		 */

		double Fs = Double.parseDouble(CircularSection.FsText.getText());
		double Fpie2 = Double.parseDouble(CircularSection.Fpie2Text.getText());

		Canvas canvas = new Canvas(picOutputGroup, SWT.NONE);
		canvas.setBounds(82, 42, 506, 401);
		formToolkit.adapt(canvas);
		formToolkit.paintBordersFor(canvas);
		canvas.setBackgroundImage(SWTResourceManager
				.getImage("res\\result.jpg"));

		HsPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		HsPicText.setEditable(false);
		HsPicText.setText(df.format(Fs / Fpie2
				+ Double.parseDouble(CircularSection.HbText.getText()))
				+ "");
		HsPicText.setBounds(135, 46, 63, 23);

		tPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		tPicText.setEditable(false);
		tPicText.setText(CircularSection.tText.getText());
		tPicText.setBounds(147, 371, 63, 23);

		dPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		dPicText.setEditable(false);
		if (CircularSection.dCombo.getItemCount() <= 0) {
			dPicText.setText("0.0");
		} else {
			dPicText.setText(CircularSection.dCombo
					.getItem(CircularSection.dCombo.getSelectionIndex()));
		}
		dPicText.setBounds(362, 338, 63, 23);

		DPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		DPicText.setEditable(false);
		DPicText.setText(CircularSection.DCombo.getItem(CircularSection.DCombo
				.getSelectionIndex()));
		DPicText.setBounds(438, 243, 63, 23);

		FsPicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		FsPicText.setEditable(false);
		FsPicText.setText(CircularSection.FsText.getText());
		FsPicText.setBounds(330, -3, 52, 17);

		F2PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		F2PicText.setEditable(false);
		F2PicText.setText(CircularSection.FnText.getText());
		F2PicText.setBounds(373, 20, 63, 17);

		F1PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		F1PicText.setEditable(false);
		F1PicText.setText(CircularSection.F1Text.getText());
		F1PicText.setBounds(412, 43, 63, 17);

		Label lblNewLabel = formToolkit.createLabel(canvas, "t=", SWT.NONE);
		lblNewLabel.setBounds(128, 374, 13, 17);

		Label lblPicNewLabel_1 = formToolkit
				.createLabel(canvas, "d=", SWT.NONE);
		lblPicNewLabel_1.setBounds(344, 344, 33, 17);

		Label lblNewLabel_2 = formToolkit.createLabel(canvas, "D=", SWT.NONE);
		lblNewLabel_2.setBounds(457, 230, 18, 17);

		Label lblPicNewLabel_3 = formToolkit.createLabel(canvas, "Hs=",
				SWT.NONE);
		lblPicNewLabel_3.setBounds(108, 49, 24, 17);

		Label lblPicNewLabel_4 = formToolkit.createLabel(canvas, "H2=",
				SWT.NONE);
		lblPicNewLabel_4.setBounds(128, 86, 33, 17);

		H2PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H2PicText.setEditable(false);
		H2PicText.setText(CircularSection.H02Text.getText());
		H2PicText.setBounds(157, 83, 63, 23);

		Label lblPicNewLabel_5 = formToolkit.createLabel(canvas, "H1=",
				SWT.NONE);
		lblPicNewLabel_5.setBounds(147, 116, 25, 17);

		H1PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H1PicText.setEditable(false);
		H1PicText.setText(CircularSection.H01Text.getText());
		H1PicText.setBounds(178, 110, 63, 23);

		Label lblPicNewLabel_6 = formToolkit.createLabel(canvas, "H0=",
				SWT.NONE);
		lblPicNewLabel_6.setBounds(180, 147, 24, 17);

		H0PicText = formToolkit.createText(canvas, "New Text", SWT.NONE);
		H0PicText.setEditable(false);
		H0PicText.setText(CircularSection.H0Text.getText());
		H0PicText.setBounds(209, 141, 63, 23);

		/*
		 * ÏµÍ³°´Å¥
		 */
		prompt = formToolkit.createText(shell, "", SWT.BORDER | SWT.READ_ONLY);
		prompt.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		prompt.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		prompt.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 14, SWT.NORMAL));
		prompt.setVisible(true);
		prompt.setBounds(10, 581, 354, 27);

		Button btnNewButton = formToolkit.createButton(shell, "\u8FD4 \u56DE",
				SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
				MainMenu.main(null);
			}
		});
		btnNewButton
				.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 16, SWT.NORMAL));
		btnNewButton.setVisible(true);
		btnNewButton.setBounds(576, 573, 107, 47);

		lastBtn = formToolkit.createButton(shell, "\u4E0A\u4E00\u6B65",
				SWT.NONE);
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
		lastBtn.setBounds(370, 573, 97, 47);
		lastBtn.setVisible(false);

		nextBtn = formToolkit.createButton(shell, "\u4E0B\u4E00\u6B65",
				SWT.NONE);
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
		nextBtn.setBounds(473, 572, 97, 48);

		CircularCoreFunction.getInstance().getAllText();
		CircularCoreFunction.getInstance().getAllCombo();

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
