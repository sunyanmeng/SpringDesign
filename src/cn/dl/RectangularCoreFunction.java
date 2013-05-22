package cn.dl;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class RectangularCoreFunction implements AppConstants {

	private static RectangularCoreFunction uniqueInstance;
	private HashMap<Text_Var, Double> allText = new HashMap<Text_Var, Double>();
	private HashMap<Combo_Var, Integer> allCombo = new HashMap<Combo_Var, Integer>();
	private DecimalFormat df = new DecimalFormat("#0.00");

	private double D, gama, Rm, F1, Fn, h, D2, D1, t, tp, n, n1, C, H0, fn, f1,
			Hb, L, b, K, delta, alpha, a, beta, tao;

	public static RectangularCoreFunction getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new RectangularCoreFunction();
		}
		return uniqueInstance;
	}

	public void getAllText() {

		allText.put(Text_Var.Rm,
				Rm = Double.parseDouble(RectangularSection.RmText.getText()));
		allText.put(Text_Var.tp,
				tp = Double.parseDouble(RectangularSection.tpText.getText()));
		allText.put(Text_Var.F1,
				F1 = Double.parseDouble(RectangularSection.F1Text.getText()));
		allText.put(Text_Var.Fn,
				Fn = Double.parseDouble(RectangularSection.FnText.getText()));
		allText.put(Text_Var.h,
				h = Double.parseDouble(RectangularSection.hText.getText()));
		allText.put(Text_Var.b,
				b = Double.parseDouble(RectangularSection.bText.getText()));
		allText.put(Text_Var.D,
				D = Double.parseDouble(RectangularSection.DText.getText()));
		allText.put(Text_Var.K,
				K = Double.parseDouble(RectangularSection.KText.getText()));
		allText.put(Text_Var.f1,
				f1 = Double.parseDouble(RectangularSection.f1Text.getText()));
		allText.put(Text_Var.fn,
				fn = Double.parseDouble(RectangularSection.fnText.getText()));
		allText.put(Text_Var.n,
				n = Double.parseDouble(RectangularSection.nText.getText()));
		allText.put(Text_Var.D2,
				D2 = Double.parseDouble(RectangularSection.D2Text.getText()));
		allText.put(Text_Var.D1,
				D1 = Double.parseDouble(RectangularSection.D1Text.getText()));
		allText.put(Text_Var.t,
				t = Double.parseDouble(RectangularSection.tText.getText()));
		allText.put(
				Text_Var.delta,
				delta = Double.parseDouble(RectangularSection.deltaText
						.getText()));
		allText.put(
				Text_Var.alpha,
				alpha = Double.parseDouble(RectangularSection.alphaText
						.getText()));
		allText.put(Text_Var.n1,
				n1 = Double.parseDouble(RectangularSection.n1Text.getText()));
		allText.put(Text_Var.H0,
				H0 = Double.parseDouble(RectangularSection.H0Text.getText()));
		allText.put(Text_Var.Hb,
				Hb = Double.parseDouble(RectangularSection.HbText.getText()));
		allText.put(Text_Var.L,
				L = Double.parseDouble(RectangularSection.LText.getText()));

		verifytao();

	}

	public void excepta() {
		a = Double.parseDouble(RectangularSection.aCombo
				.getItem(RectangularSection.aCombo.getSelectionIndex()));
		RectangularSection.CCombo.removeAll();
		if (a <= 1.) {
			RectangularSection.CCombo.add("8");
			RectangularSection.CCombo.add("10");
			RectangularSection.CCombo.add("12");
		} else if (a <= 2.4) {
			RectangularSection.CCombo.add("8");
			RectangularSection.CCombo.add("10");
		} else if (a <= 16) {
			RectangularSection.CCombo.add("8");
		}
		RectangularSection.CCombo.select(0);
		RectangularSection.CCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getAllCombo();
			}

		});
		getAllCombo();
	}

	public void getAllCombo() {
		allCombo.put(Combo_Var.endType,
				RectangularSection.endTypeCombo.getSelectionIndex());
		allCombo.put(Combo_Var.springMaterial,
				RectangularSection.springMaterialCombo.getSelectionIndex());
		allCombo.put(Combo_Var.a, RectangularSection.aCombo.getSelectionIndex());
		a = Double.parseDouble(RectangularSection.aCombo
				.getItem(RectangularSection.aCombo.getSelectionIndex()));
		allCombo.put(Combo_Var.C, RectangularSection.CCombo.getSelectionIndex());

		verifytao();
	}

	private void verifytao() {
		RectangularSection.bText.setToolTipText(4 * a + " < b < " + 5 * a);
		if (Fn == 0.0) {
			error("最大负荷");
			return;
		}
		if (F1 == 0.0) {
			error("最小负荷F1");
			return;
		}
		if (h == 0.0) {
			error("工作行程h");
			return;
		}
		if (b <= 4 * a || b >= 5 * a) {
			error("垂直轴线边长b");
			return;
		}
		Rm = RmValue[getdRange(Double.parseDouble(RectangularSection.aCombo
				.getItem(RectangularSection.aCombo.getSelectionIndex())))][allCombo
				.get(Combo_Var.springMaterial)];
		tp = 9.55 * Rm;

		update(Double.parseDouble(RectangularSection.CCombo
				.getItem(RectangularSection.CCombo.getSelectionIndex())));
		checkinAllVars();
		showData();
	}

	private void update(double CV) {
		C = CV;
		D = C * a;
		if (C == 8.) {
			beta = 0.27 * b / a + 2.95;
		}
		if (C == 10.) {
			beta = 0.3 * b / a + 2.7;
		}
		if (C == 12.) {
			beta = 0.3 * b / a + 2.65;
		}
		tao = beta * Fn * D / (a * b * Math.sqrt(a * b));
		if (tao > tp) {
			errorPro("请重新选择边长a、b及旋绕比C");
			return;
		}
		K = (Fn - F1) / h;
		f1 = F1 / K;
		fn = h + f1;
		gama = 3.1 * b / a - 1.7;
		n = getn(G * fn * a * Math.pow(b / a, 2) / (gama * Fn * Math.pow(C, 3)));
		n1 = n + 2;
		D2 = D + a;
		D1 = D - a;
		RectangularSection.tText.setToolTipText(df.format(0.28 * D2)
				+ " <= t <= " + df.format(0.5 * D2));
		if (t < 0.28 * D2 || t > 0.5 * D2 || t < b) {
			error("弹簧节距t");
			return;
		}
		delta = t - b;
		alpha = Math.atan(t / (Math.PI * D));
		switch (RectangularSection.endTypeCombo.getSelectionIndex()) {
		case 0:
			H0 = n * t + 3 * b;
			Hb = (n + 3) * b;
			L = n1 * Math.PI * D;
			break;
		case 1:
			H0 = n * t + 1.5 * b;
			Hb = (n + 1.5) * b;
			L = n1 * Math.PI * D;
			break;
		}
		RectangularSection.btnNewButton.setVisible(true);
		RectangularSection.prompt.setVisible(false);
	}

	/*
	 * n（有效圈数） 取就近圆整
	 */
	private double getn(double the) {
		for (int i = 0; i < nValue.length; i++) {
			if (the == nValue[i]) {
				return nValue[i];
			} else if (the > nValue[i]) {
				continue;
			}
			if (Math.abs(the - nValue[i]) > Math.abs(the - nValue[i - 1])) {
				return nValue[i - 1];
			} else {
				return nValue[i];
			}
		}
		return -1.;

	}

	/*
	 * 把所有变量存入HashMap中
	 */
	private void checkinAllVars() {
		allText.put(Text_Var.Rm, Double.parseDouble(df.format(Rm)));
		allText.put(Text_Var.F1, Double.parseDouble(df.format(F1)));
		allText.put(Text_Var.Fn, Double.parseDouble(df.format(Fn)));
		allText.put(Text_Var.h, Double.parseDouble(df.format(h)));
		allText.put(Text_Var.D2, Double.parseDouble(df.format(D2)));
		allText.put(Text_Var.D1, Double.parseDouble(df.format(D1)));
		allText.put(Text_Var.t, Double.parseDouble(df.format(t)));
		allText.put(Text_Var.tp, Double.parseDouble(df.format(tp)));
		allText.put(Text_Var.n, Double.parseDouble(df.format(n)));
		allText.put(Text_Var.n1, Double.parseDouble(df.format(n1)));
		allText.put(Text_Var.H0, Double.parseDouble(df.format(H0)));
		allText.put(Text_Var.fn, Double.parseDouble(df.format(fn)));
		allText.put(Text_Var.f1, Double.parseDouble(df.format(f1)));
		allText.put(Text_Var.Hb, Double.parseDouble(df.format(Hb)));
		allText.put(Text_Var.L, Double.parseDouble(df.format(L)));
		allText.put(Text_Var.b, Double.parseDouble(df.format(b)));
		allText.put(Text_Var.D, Double.parseDouble(df.format(D)));
		allText.put(Text_Var.K, Double.parseDouble(df.format(K)));
		allText.put(Text_Var.alpha, Double.parseDouble(df.format(alpha)));
		allText.put(Text_Var.delta, Double.parseDouble(df.format(delta)));

		updateAllText();
	}

	/*
	 * 更新HashMap中的值到页面
	 */
	private void updateAllText() {
		RectangularSection.RmText.setText(allText.get(Text_Var.Rm).toString());
		RectangularSection.F1Text.setText(allText.get(Text_Var.F1).toString());
		RectangularSection.FnText.setText(allText.get(Text_Var.Fn).toString());
		RectangularSection.hText.setText(allText.get(Text_Var.h).toString());
		RectangularSection.D2Text.setText(allText.get(Text_Var.D2).toString());
		RectangularSection.D1Text.setText(allText.get(Text_Var.D1).toString());
		RectangularSection.tText.setText(allText.get(Text_Var.t).toString());
		RectangularSection.tpText.setText(allText.get(Text_Var.tp).toString());
		RectangularSection.nText.setText(allText.get(Text_Var.n).toString());
		RectangularSection.n1Text.setText(allText.get(Text_Var.n1).toString());
		RectangularSection.H0Text.setText(allText.get(Text_Var.H0).toString());
		RectangularSection.fnText.setText(allText.get(Text_Var.fn).toString());
		RectangularSection.f1Text.setText(allText.get(Text_Var.f1).toString());
		RectangularSection.HbText.setText(allText.get(Text_Var.Hb).toString());
		RectangularSection.LText.setText(allText.get(Text_Var.L).toString());
		RectangularSection.bText.setText(allText.get(Text_Var.b).toString());
		RectangularSection.DText.setText(allText.get(Text_Var.D).toString());
		RectangularSection.KText.setText(allText.get(Text_Var.K).toString());
		RectangularSection.alphaText.setText(allText.get(Text_Var.alpha)
				.toString());
		RectangularSection.deltaText.setText(allText.get(Text_Var.delta)
				.toString());
	}

	/*
	 * 返回d所在位置
	 */
	private int getdRange(double d) {
		if (d <= 0.8) {
			return 0;
		} else if (d >= 0.81 && d <= 1.0) {
			return 1;
		} else if (d >= 1.01 && d <= 1.30) {
			return 2;
		} else if (d >= 1.31 && d <= 1.40) {
			return 3;
		} else if (d >= 1.41 && d <= 1.60) {
			return 4;
		} else if (d >= 1.61 && d <= 2.0) {
			return 5;
		} else if (d >= 2.01 && d <= 2.50) {
			return 6;
		} else if (d >= 2.51 && d <= 2.70) {
			return 7;
		} else if (d >= 2.71 && d <= 3.0) {
			return 8;
		} else if (d >= 3.01 && d <= 3.20) {
			return 9;
		} else if (d >= 3.21 && d <= 3.50) {
			return 10;
		} else if (d >= 3.51 && d <= 4.0) {
			return 11;
		} else if (d >= 4.01 && d <= 4.20) {
			return 12;
		} else if (d >= 4.21 && d <= 4.50) {
			return 13;
		} else if (d >= 4.51 && d <= 4.70) {
			return 14;
		} else if (d >= 4.71 && d <= 5.0) {
			return 15;
		} else if (d >= 5.01 && d <= 5.60) {
			return 16;
		} else if (d >= 5.61 && d <= 6.0) {
			return 17;
		} else if (d >= 6.01 && d <= 6.50) {
			return 18;
		} else if (d >= 6.51 && d <= 7.0) {
			return 19;
		} else if (d >= 7.01 && d <= 8.0) {
			return 20;
		} else if (d >= 8.01 && d <= 9.0) {
			return 21;
		} else if (d >= 9.01 && d <= 10.0) {
			return 22;
		} else if (d >= 10.01 && d <= 12.0) {
			return 23;
		} else if (d >= 12.01 && d <= 14.0) {
			return 24;
		} else if (d >= 14.01 && d <= 15.0) {
			return 25;
		} else if (d >= 15.01 && d <= 17.0) {
			return 26;
		} else {
			return -1;
		}
	}

	private void error(String pos) {
		RectangularSection.prompt.setVisible(true);
		RectangularSection.prompt.setText("错误: " + pos + " 的值不合法");
		SWTResourceManager.getColor(SWT.COLOR_RED);
	}

	private void errorPro(String pos) {
		RectangularSection.prompt.setVisible(true);
		RectangularSection.prompt.setText(pos);
		SWTResourceManager.getColor(SWT.COLOR_RED);
	}

	private void showData() {
		
		RectangularSection.bPicText.setText(RectangularSection.bText.getText());
		RectangularSection.DPicText.setText(RectangularSection.DText.getText());
		RectangularSection.D2PicText.setText(RectangularSection.D2Text.getText());
		
		Table table = RectangularSection.table;
		table.removeAll();
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {
				"1",
				"垂直弹簧轴线边长",
				"a",
				RectangularSection.aCombo.getItem(RectangularSection.aCombo
						.getSelectionIndex()), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "2", "平行弹簧轴线边长", "b",
				RectangularSection.bText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {
				"3",
				"旋绕比",
				"C",
				RectangularSection.CCombo.getItem(RectangularSection.CCombo
						.getSelectionIndex()), "--" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "4", "弹簧中径", "D",
				RectangularSection.DText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "5", "弹簧刚度", "K",
				RectangularSection.KText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "6", "最小负荷变形", "f1",
				RectangularSection.f1Text.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "7", "最大负荷变形", "fn",
				RectangularSection.fnText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "8", "有效圈数", "n",
				RectangularSection.fnText.getText(), "无量纲" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "9", "总圈数", "n1",
				RectangularSection.n1Text.getText(), "无量纲" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "10", "弹簧外径", "D2",
				RectangularSection.D2Text.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "11", "弹簧内经", "D1",
				RectangularSection.D1Text.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "12", "弹簧节距t", "t",
				RectangularSection.tText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "13", "间距", "δ",
				RectangularSection.deltaText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "14", "螺旋角", "α",
				RectangularSection.alphaText.getText(), "弧度" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "15", "自由高度", "H0",
				RectangularSection.H0Text.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "16", "压并高度", "Hb",
				RectangularSection.HbText.getText(), "mm" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "17", "展开长度", "L",
				RectangularSection.LText.getText(), "kg" });
		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {
				"18",
				"端部结构",
				"--",
				RectangularSection.endTypeCombo
						.getItem(RectangularSection.endTypeCombo
								.getSelectionIndex()), "不适用" });
	}

}
