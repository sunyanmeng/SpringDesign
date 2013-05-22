package cn.dl;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class CircularCoreFunction implements AppConstants {

	private static CircularCoreFunction uniqueInstance;
	private HashMap<Text_Var, Double> allText = new HashMap<Text_Var, Double>();
	private HashMap<Combo_Var, Integer> allCombo = new HashMap<Combo_Var, Integer>();
	private DecimalFormat df = new DecimalFormat("#0.00");

	private double dEsti, d, D, gama, Rm, ts, F1, Fn, h, D2, D1, t, Fs, R, tp,
			Fj, n, n1, C, Fpie, Fpie2, H0, H01, H02, fj, fn, f1, Hj, Hb, Hn,
			H1, actualh, L, tmin, tmax, tu0, S, Smin, b, CB, Fc, fe, fr, K;
	private int N, fixedModeIndex, rodOrSleeveIndex;

	public static CircularCoreFunction getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new CircularCoreFunction();
		}
		return uniqueInstance;
	}

	public void getAllText1() {
		allText.put(Text_Var.Fn, Fn = Double.parseDouble(CircularSection.FnText.getText()));
		if (Fn == 0.0) {
			error("最大负荷");
			return;
		}
		CircularSection.prompt.setVisible(false);
		dEsti = Math.sqrt(0.0328 * allText.get(Text_Var.Fn));
		CircularSection.dCombo.removeAll();
		for (int i = 0; i < dValue.length; i++) {
			if (dEsti > dValue[i]) {
				continue;
			}
			CircularSection.dCombo.add(dValue[i] + "");
			CircularSection.dCombo.select(0);
		}
		CircularSection.dCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				/*updated(Double.parseDouble(CircularSection.dCombo
						.getItem(CircularSection.dCombo.getSelectionIndex())));
				checkinAllVars();
				showData();*/
				getAllText();
			}

		});
		getAllText();
	}
	public void getAllText() {

		allText.put(Text_Var.Rm, Rm = Double.parseDouble(CircularSection.RmText.getText()));
		allText.put(Text_Var.ts, ts = Double.parseDouble(CircularSection.tsText.getText()));
		allText.put(Text_Var.F1, F1 = Double.parseDouble(CircularSection.F1Text.getText()));
		allText.put(Text_Var.Fn, Fn = Double.parseDouble(CircularSection.FnText.getText()));
		allText.put(Text_Var.h, h = Double.parseDouble(CircularSection.hText.getText()));
		allText.put(Text_Var.D2, D2 = Double.parseDouble(CircularSection.D2Text.getText()));
		allText.put(Text_Var.D1, D1 = Double.parseDouble(CircularSection.D1Text.getText()));
		allText.put(Text_Var.t, t = Double.parseDouble(CircularSection.tText.getText()));
		allText.put(Text_Var.Fs, Fs = Double.parseDouble(CircularSection.FsText.getText()));
		allText.put(Text_Var.R, R = Double.parseDouble(CircularSection.RText.getText()));
		allText.put(Text_Var.tp, tp = Double.parseDouble(CircularSection.tpText.getText()));
		allText.put(Text_Var.Fj, Fj = Double.parseDouble(CircularSection.FjText.getText()));
		allText.put(Text_Var.n, n = Double.parseDouble(CircularSection.nText.getText()));
		allText.put(Text_Var.n1, n1 = Double.parseDouble(CircularSection.n1Text.getText()));
		allText.put(Text_Var.C, C = Double.parseDouble(CircularSection.CText.getText()));
		allText.put(Text_Var.Fpie,
				Fpie = Double.parseDouble(CircularSection.FpieText.getText()));
		allText.put(Text_Var.Fpie2,
				Fpie2 = Double.parseDouble(CircularSection.Fpie2Text.getText()));
		allText.put(Text_Var.H0, H0 = Double.parseDouble(CircularSection.H0Text.getText()));
		allText.put(Text_Var.H01,
				H01 = Double.parseDouble(CircularSection.H01Text.getText()));
		allText.put(Text_Var.H02,
				H02 = Double.parseDouble(CircularSection.H02Text.getText()));
		allText.put(Text_Var.fj, fj = Double.parseDouble(CircularSection.fjText.getText()));
		allText.put(Text_Var.fn, fn = Double.parseDouble(CircularSection.fnText.getText()));
		allText.put(Text_Var.f1, f1 = Double.parseDouble(CircularSection.f1Text.getText()));
		allText.put(Text_Var.Hj, Hj = Double.parseDouble(CircularSection.HjText.getText()));
		allText.put(Text_Var.Hb, Hb = Double.parseDouble(CircularSection.HbText.getText()));
		allText.put(Text_Var.Hn, Hn = Double.parseDouble(CircularSection.HnText.getText()));
		allText.put(Text_Var.H1, H1 = Double.parseDouble(CircularSection.H1Text.getText()));
		allText.put(Text_Var.actualh,
				L = Double.parseDouble(CircularSection.actualhText.getText()));
		allText.put(Text_Var.L, L = Double.parseDouble(CircularSection.LText.getText()));
		allText.put(Text_Var.tmin,
				tmin = Double.parseDouble(CircularSection.tminText.getText()));
		allText.put(Text_Var.tmax,
				tmax = Double.parseDouble(CircularSection.tmaxText.getText()));
		allText.put(Text_Var.tu0,
				tu0 = Double.parseDouble(CircularSection.tu0Text.getText()));
		allText.put(Text_Var.S, S = Double.parseDouble(CircularSection.SText.getText()));
		allText.put(Text_Var.Smin,
				Smin = Double.parseDouble(CircularSection.SminText.getText()));
		allText.put(Text_Var.b, b = Double.parseDouble(CircularSection.bText.getText()));
		allText.put(Text_Var.CB, CB = Double.parseDouble(CircularSection.CBText.getText()));
		allText.put(Text_Var.Fc, Fc = Double.parseDouble(CircularSection.FcText.getText()));
		allText.put(Text_Var.fe, fe = Double.parseDouble(CircularSection.feText.getText()));
		allText.put(Text_Var.fr, fr = Double.parseDouble(CircularSection.frText.getText()));
		allText.put(Text_Var.K, K = Double.parseDouble(CircularSection.KText.getText()));

		verifyd();

	}

	public void getAllCombo() {
		allCombo.put(Combo_Var.endType, CircularSection.endTypeCombo.getSelectionIndex());
		allCombo.put(Combo_Var.springMaterial,
				CircularSection.springMaterialCombo.getSelectionIndex());
		allCombo.put(Combo_Var.d, CircularSection.dCombo.getSelectionIndex());
		if (CircularSection.dCombo.getItemCount() > 0)
			d = Double.parseDouble(CircularSection.dCombo.getItem(CircularSection.dCombo
					.getSelectionIndex()));
		allCombo.put(Combo_Var.D, CircularSection.DCombo.getSelectionIndex());
		D = Double.parseDouble(CircularSection.DCombo.getItem(CircularSection.DCombo
				.getSelectionIndex()));
		allCombo.put(Combo_Var.N, CircularSection.NCombo.getSelectionIndex());
		N = Integer.parseInt(CircularSection.NCombo.getItem(CircularSection.NCombo
				.getSelectionIndex()));
		allCombo.put(Combo_Var.fixedMode,
				fixedModeIndex = CircularSection.fixedModeCombo.getSelectionIndex());
		allCombo.put(Combo_Var.rodOrSleeve,
				rodOrSleeveIndex = CircularSection.rodOrSleeveCombo.getSelectionIndex());

		verifyd();
	}

	private void verifyd() {
		if (Fn == 0.0) {
			error("最大负荷");
			return;
		}
		CircularSection.prompt.setVisible(false);
		dEsti = Math.sqrt(0.0328 * allText.get(Text_Var.Fn));
		if (dEsti >= 0.5 && dEsti <= 17.0) {
			Rm = RmValue[getdRange(Double.parseDouble(df.format(dEsti)
					.toString()))][allCombo.get(Combo_Var.springMaterial)];
			ts = 0.55 * Rm;
			D = DValue[allCombo.get(Combo_Var.D)];
			C = D / dEsti;
			K = (4.0 * C - 1.0) / (4.0 * C - 4.0) + 0.615 / C;
			if (F1 == 0.0) {
				error("最小负荷");
				return;
			}
			CircularSection.prompt.setVisible(false);
			gama = allText.get(Text_Var.F1) / allText.get(Text_Var.Fn);
			tp = Rm * getR(gama);
			// CircularSection.dCombo.removeAll();
			if (dEsti >= Math.pow(8 * Fn * D / (Math.PI * tp), 1 / 3)) {
				/*for (int i = 0; i < dValue.length; i++) {
					if (dEsti > dValue[i]) {
						continue;
					}
					CircularSection.dCombo.add(dValue[i] + "");
					CircularSection.dCombo.select(0);
				}
				CircularSection.dCombo.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						updated(Double.parseDouble(CircularSection.dCombo
								.getItem(CircularSection.dCombo.getSelectionIndex())));
						checkinAllVars();
						showData();
					}

				});*/
				updated(Double.parseDouble(CircularSection.dCombo.getItem(0).toString()));
				checkinAllVars();
				showData();
			} else {
				error("最大负荷");
				CircularSection.prompt.setVisible(false);
				return;
			}
		}

	}

	/*
	 * d 验证成功后，重新计算各个变量 形参为材料直径d的值
	 */
	protected void updated(double value) {
		d = value;
		Rm = RmValue[getdRange(d)][allCombo.get(Combo_Var.springMaterial)];
		ts = 0.55 * Rm;
		D = DValue[allCombo.get(Combo_Var.D)];
		if (D <= d) {
			error("材料直径和弹簧中径");
			return;
		}
		CircularSection.prompt.setVisible(false);
		CircularSection.tText.setToolTipText(df.format(0.28 * D) + " <= t < "
				+ df.format(0.5 * D));
		D2 = D + d;
		D1 = D - d;
		C = D / d;
		if (!validC()) {
			errorPro("旋绕比不合适");
			return;
		}
		CircularSection.prompt.setVisible(false);
		K = (4.0 * C - 1.0) / (4.0 * C - 4.0) + 0.615 / C;
		gama = allText.get(Text_Var.F1) / allText.get(Text_Var.Fn);
		R = getR(gama);
		tp = Rm * R;
		Fs = Math.PI * Math.pow(d, 3.) / (8 * D) * ts; // excel中分母有K，国标没有
		Fj = R * Fs / 0.55;
		if (Fn > Fj) {
			errorPro("弹簧强度不够");
			return;
		}
		CircularSection.prompt.setVisible(false);
		if (h == 0.0) {
			error("工作行程");
			return;
		}
		CircularSection.prompt.setVisible(false);
		Fpie = (Fn - F1) / h;
		n = getn(G * Math.pow(d, 4) / (8 * Fpie * Math.pow(D, 3)));
		n1 = n + 2;
		Fpie2 = G * Math.pow(d, 4) / (8 * Math.pow(D, 3) * n);
		if ((Fpie2 - Fpie) / Fpie > 0.075) {
			errorPro("实际刚度不合适，相差" + df.format((Fpie2 - Fpie) / Fpie * 100)
					+ "%");
			return;
		}
		if (!(t >= 0.28 * D && t < 0.5 * D)) {
			error("节距");
			return;
		}
		H0 = n * t + 1.5 * d;
		fj = Fj / Fpie2;
		fn = Fn / Fpie2;
		f1 = F1 / Fpie2;
		Hj = H0 - fj;
		Hb = (n + 1.5) * d;
		Hn = H0 - fn;
		H1 = H0 - f1;
		H01 = Hb + fn;
		H02 = Hb + fj;
		if (H0 < H01) {
			error("自由高度H0");
			return;
		}
		actualh = H1 - Hn;
		L = Math.sqrt(Math.pow(Math.PI * D, 2) + t * t) * n1;
		tmin = K * 8 * D * F1 / (Math.PI * Math.pow(d, 3));
		tmax = K * 8 * D * Fn / (Math.PI * Math.pow(d, 3));
		switch (N) {
		case 10000:
			tu0 = 0.45 * Rm;
			break;
		case 100000:
			tu0 = 0.35 * Rm;
			break;
		case 1000000:
			tu0 = 0.32 * Rm;
			break;
		case 10000000:
			tu0 = 0.3 * Rm;
			break;

		}
		if (Smin < 1.1 || Smin > 1.3) {
			error("最小安全系数");
			return;
		}
		S = (tu0 + 0.75 * tmin) / tmax;
		if (S < Smin) {
			errorPro("不满足疲劳要求");
			return;
		}
		b = H0 / D;
		fixedModeIndex = CircularSection.fixedModeCombo.getSelectionIndex();

		if (!((fixedModeIndex == 2 && b > 0.4 && b <= 5.3)
				|| (fixedModeIndex == 1 && b > 0.4 && b <= 3.7) || (fixedModeIndex == 0
				&& b > 0.4 && b <= 2.6))) {
			errorPro("b(高径比)不满足要求");
			return;

		}
		CB = getCB(b, fixedModeIndex);
		Fc = CB * Fpie2 * H0;
		if (rodOrSleeveIndex == 1 && Fn > Fc) {
			errorPro("Fn(最大工作负荷)太大");
			return;
		}
		fe = 3.56 * d * Math.sqrt(G / rho) / (n * Math.pow(D, 2));
		fr = 1;
		if (fe / fr <= 10) {
			errorPro("有共振风险");
		}
		CircularSection.prompt.setVisible(false);
	}

	/*
	 * 验证旋绕比C是否合法
	 */
	private boolean validC() {
		if (d >= 0.2 && d <= 0.5 && C >= 7 && C <= 14) {
			return true;
		}
		if (d > 0.5 && d <= 1.1 && C >= 5 && C <= 12) {
			return true;
		}
		if (d > 1.1 && d <= 2.5 && C >= 5 && C <= 10) {
			return true;
		}
		if (d > 2.5 && d <= 7.0 && C >= 4 && C <= 9) {
			return true;
		}
		if (d > 7.0 && d <= 16 && C >= 4 && C <= 8) {
			return true;
		}
		if (d > 16 && C >= 4 && C <= 16) {
			return true;
		}
		return false;
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
		allText.put(Text_Var.ts, Double.parseDouble(df.format(ts)));
		allText.put(Text_Var.F1, Double.parseDouble(df.format(F1)));
		allText.put(Text_Var.Fn, Double.parseDouble(df.format(Fn)));
		allText.put(Text_Var.h, Double.parseDouble(df.format(h)));
		allText.put(Text_Var.D2, Double.parseDouble(df.format(D2)));
		allText.put(Text_Var.D1, Double.parseDouble(df.format(D1)));
		allText.put(Text_Var.t, Double.parseDouble(df.format(t)));
		allText.put(Text_Var.Fs, Double.parseDouble(df.format(Fs)));
		allText.put(Text_Var.R, Double.parseDouble(df.format(R)));
		allText.put(Text_Var.tp, Double.parseDouble(df.format(tp)));
		allText.put(Text_Var.Fj, Double.parseDouble(df.format(Fj)));
		allText.put(Text_Var.n, Double.parseDouble(df.format(n)));
		allText.put(Text_Var.n1, Double.parseDouble(df.format(n1)));
		allText.put(Text_Var.C, Double.parseDouble(df.format(C)));
		allText.put(Text_Var.Fpie, Double.parseDouble(df.format(Fpie)));
		allText.put(Text_Var.Fpie2, Double.parseDouble(df.format(Fpie2)));
		allText.put(Text_Var.H0, Double.parseDouble(df.format(H0)));
		allText.put(Text_Var.H01, Double.parseDouble(df.format(H01)));
		allText.put(Text_Var.H02, Double.parseDouble(df.format(H02)));
		allText.put(Text_Var.fj, Double.parseDouble(df.format(fj)));
		allText.put(Text_Var.fn, Double.parseDouble(df.format(fn)));
		allText.put(Text_Var.f1, Double.parseDouble(df.format(f1)));
		allText.put(Text_Var.Hj, Double.parseDouble(df.format(Hj)));
		allText.put(Text_Var.Hb, Double.parseDouble(df.format(Hb)));
		allText.put(Text_Var.Hn, Double.parseDouble(df.format(Hn)));
		allText.put(Text_Var.H1, Double.parseDouble(df.format(H1)));
		allText.put(Text_Var.actualh, Double.parseDouble(df.format(actualh)));
		allText.put(Text_Var.L, Double.parseDouble(df.format(L)));
		allText.put(Text_Var.tmin, Double.parseDouble(df.format(tmin)));
		allText.put(Text_Var.tmax, Double.parseDouble(df.format(tmax)));
		allText.put(Text_Var.tu0, Double.parseDouble(df.format(tu0)));
		allText.put(Text_Var.S, Double.parseDouble(df.format(S)));
		allText.put(Text_Var.Smin, Double.parseDouble(df.format(Smin)));
		allText.put(Text_Var.b, Double.parseDouble(df.format(b)));
		allText.put(Text_Var.CB, Double.parseDouble(df.format(CB)));
		allText.put(Text_Var.Fc, Double.parseDouble(df.format(Fc)));
		allText.put(Text_Var.fe, Double.parseDouble(df.format(fe)));
		allText.put(Text_Var.fr, Double.parseDouble(df.format(fr)));
		allText.put(Text_Var.K, Double.parseDouble(df.format(K)));

		updateAllText();
	}

	/*
	 * 更新HashMap中的值到页面
	 */
	private void updateAllText() {
		CircularSection.RmText.setText(allText.get(Text_Var.Rm).toString());
		CircularSection.tsText.setText(allText.get(Text_Var.ts).toString());
		CircularSection.F1Text.setText(allText.get(Text_Var.F1).toString());
		CircularSection.FnText.setText(allText.get(Text_Var.Fn).toString());
		CircularSection.hText.setText(allText.get(Text_Var.h).toString());
		CircularSection.D2Text.setText(allText.get(Text_Var.D2).toString());
		CircularSection.D1Text.setText(allText.get(Text_Var.D1).toString());
		CircularSection.tText.setText(allText.get(Text_Var.t).toString());
		CircularSection.FsText.setText(allText.get(Text_Var.Fs).toString());
		CircularSection.RText.setText(allText.get(Text_Var.R).toString());
		CircularSection.tpText.setText(allText.get(Text_Var.tp).toString());
		CircularSection.FjText.setText(allText.get(Text_Var.Fj).toString());
		CircularSection.nText.setText(allText.get(Text_Var.n).toString());
		CircularSection.n1Text.setText(allText.get(Text_Var.n1).toString());
		CircularSection.CText.setText(allText.get(Text_Var.C).toString());
		CircularSection.FpieText.setText(allText.get(Text_Var.Fpie).toString());
		CircularSection.Fpie2Text.setText(allText.get(Text_Var.Fpie2).toString());
		CircularSection.H0Text.setText(allText.get(Text_Var.H0).toString());
		CircularSection.H01Text.setText(allText.get(Text_Var.H01).toString());
		CircularSection.H02Text.setText(allText.get(Text_Var.H02).toString());
		CircularSection.fjText.setText(allText.get(Text_Var.fj).toString());
		CircularSection.fnText.setText(allText.get(Text_Var.fn).toString());
		CircularSection.f1Text.setText(allText.get(Text_Var.f1).toString());
		CircularSection.HjText.setText(allText.get(Text_Var.Hj).toString());
		CircularSection.HbText.setText(allText.get(Text_Var.Hb).toString());
		CircularSection.HnText.setText(allText.get(Text_Var.Hn).toString());
		CircularSection.H1Text.setText(allText.get(Text_Var.H1).toString());
		CircularSection.actualhText.setText(allText.get(Text_Var.actualh).toString());
		CircularSection.LText.setText(allText.get(Text_Var.L).toString());
		CircularSection.tminText.setText(allText.get(Text_Var.tmin).toString());
		CircularSection.tmaxText.setText(allText.get(Text_Var.tmax).toString());
		CircularSection.tu0Text.setText(allText.get(Text_Var.tu0).toString());
		CircularSection.SText.setText(allText.get(Text_Var.S).toString());
		CircularSection.SminText.setText(allText.get(Text_Var.Smin).toString());
		CircularSection.bText.setText(allText.get(Text_Var.b).toString());
		CircularSection.CBText.setText(allText.get(Text_Var.CB).toString());
		CircularSection.FcText.setText(allText.get(Text_Var.Fc).toString());
		CircularSection.feText.setText(allText.get(Text_Var.fe).toString());
		CircularSection.frText.setText(allText.get(Text_Var.fr).toString());
		CircularSection.KText.setText(allText.get(Text_Var.K).toString());
	}

	/*
	 * 计算上限应力系数 R
	 */
	private double getR(double gama) {
		if (gama < 0.15) {
			return 0.3175;
		} else if (gama < 0.25) {
			return 0.3371;
		} else if (gama < 0.35) {
			return 0.3593;
		} else if (gama < 0.45) {
			return 0.3846;
		} else if (gama < 0.55) {
			return 0.4138;
		} else if (gama < 0.65) {
			return 0.4478;
		} else if (gama < 0.75) {
			return 0.4878;
		} else if (gama < 0.85) {
			return 0.5357;
		} else {
			return 0.5941;
		}
	}

	/*
	 * 计算稳定系数CB
	 */
	private double getCB(double bV, int index) {
		return CBValue[index][getbRange(bV)];
	}

	/*
	 * 返回b所在位置
	 */
	private int getbRange(double b) {
		if (b < 2.75) {
			return 0;
		} else if (b < 2.85) {
			return 1;
		} else if (b < 2.95) {
			return 2;
		} else if (b < 3.05) {
			return 3;
		} else if (b < 3.15) {
			return 4;
		} else if (b < 3.25) {
			return 5;
		} else if (b < 3.35) {
			return 6;
		} else if (b < 3.45) {
			return 7;
		} else if (b < 3.55) {
			return 8;
		} else if (b < 3.65) {
			return 9;
		} else if (b < 3.75) {
			return 10;
		} else if (b < 3.85) {
			return 11;
		} else if (b < 3.95) {
			return 12;
		} else if (b < 4.05) {
			return 13;
		} else if (b < 4.15) {
			return 14;
		} else if (b < 4.25) {
			return 15;
		} else if (b < 4.35) {
			return 16;
		} else if (b < 4.45) {
			return 17;
		} else if (b < 4.55) {
			return 18;
		} else if (b < 4.65) {
			return 19;
		} else if (b < 4.75) {
			return 20;
		} else if (b < 4.85) {
			return 21;
		} else if (b < 4.95) {
			return 22;
		} else if (b < 5.05) {
			return 23;
		} else if (b < 5.15) {
			return 24;
		} else if (b < 5.25) {
			return 25;
		} else if (b < 5.35) {
			return 26;
		} else if (b < 5.45) {
			return 27;
		} else if (b < 5.55) {
			return 28;
		} else if (b < 5.65) {
			return 29;
		} else if (b < 5.75) {
			return 30;
		} else if (b < 5.85) {
			return 31;
		} else if (b < 5.95) {
			return 32;
		} else if (b < 6.1) {
			return 33;
		} else if (b < 6.3) {
			return 34;
		} else if (b < 6.5) {
			return 35;
		} else if (b < 6.7) {
			return 36;
		} else if (b < 6.9) {
			return 37;
		} else if (b < 7.1) {
			return 38;
		} else if (b < 7.3) {
			return 39;
		} else if (b < 7.5) {
			return 40;
		} else if (b < 7.7) {
			return 41;
		} else if (b < 7.9) {
			return 42;
		} else if (b < 8.1) {
			return 43;
		} else if (b < 8.3) {
			return 44;
		} else if (b < 8.5) {
			return 45;
		} else if (b < 8.7) {
			return 46;
		} else if (b < 8.9) {
			return 47;
		} else if (b < 9.1) {
			return 48;
		} else if (b < 9.3) {
			return 49;
		} else if (b < 9.5) {
			return 50;
		} else if (b < 9.7) {
			return 51;
		} else if (b < 9.9) {
			return 52;
		} else {
			return 53;
		}
	}

	/*
	 * 返回d所在位置
	 */
	private int getdRange(double d) {
		if (d >= 0.5 && d <= 0.8) {
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
		CircularSection.prompt.setVisible(true);
		CircularSection.prompt.setText("错误: " + pos + " 的值不合法");
		SWTResourceManager.getColor(SWT.COLOR_RED);
	}

	private void errorPro(String pos) {
		CircularSection.prompt.setVisible(true);
		CircularSection.prompt.setText(pos);
		SWTResourceManager.getColor(SWT.COLOR_RED);
	}
	
	private void showData() {
		
		double Fs = Double.parseDouble(CircularSection.FsText.getText());
		double Fpie2 = Double.parseDouble(CircularSection.Fpie2Text.getText());
		
		CircularSection.HsPicText.setText(df.format(Fs / Fpie2
				+ Double.parseDouble(CircularSection.HbText.getText()))
				+ "");
		CircularSection.tPicText.setText(CircularSection.tText.getText());
		if (CircularSection.dCombo.getItemCount() <= 0) {
			CircularSection.dPicText.setText("0.0");
		} else {
			CircularSection.dPicText.setText(CircularSection.dCombo
					.getItem(CircularSection.dCombo.getSelectionIndex()));
		}
		CircularSection.DPicText.setText(CircularSection.DCombo.getItem(CircularSection.DCombo
				.getSelectionIndex()));
		CircularSection.FsPicText.setText(CircularSection.FsText.getText());
		CircularSection.F2PicText.setText(CircularSection.FnText.getText());
		CircularSection.F1PicText.setText(CircularSection.F1Text.getText());
		CircularSection.H2PicText.setText(CircularSection.H02Text.getText());
		CircularSection.H1PicText.setText(CircularSection.H01Text.getText());
		CircularSection.H0PicText.setText(CircularSection.H0Text.getText());
		
		Table table = CircularSection.table;
		table.removeAll();
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
		tableItem.setText(new String[] { "16", "质量", "m", df.format(Math.PI * Math.pow(Double.parseDouble(CircularSection.dCombo.getItem(CircularSection.dCombo.getSelectionIndex())), 2) * Double.parseDouble(CircularSection.LText.getText()) * rho / 4), "kg"});
	}

}
