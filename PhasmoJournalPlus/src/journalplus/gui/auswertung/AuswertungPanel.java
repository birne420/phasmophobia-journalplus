package journalplus.gui.auswertung;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;
import journalplus.journal.*;
import journalplus.journal.auswertung.*;
import journalplus.journal.vermutung.Vermutung;
import journalplus.utility.BasicUtility;
import journalplus.utility.gridbagconstraints.GridBagConstraintsUtility;

public class AuswertungPanel extends BasicPanel {
	private static final long serialVersionUID = 1L;
	
	private Object[] rankingListe;

	private boolean istIrgendwasGesetzt() {
		for(Beweis b : Beweis.values()) {
			if(b.getVermutung() != Vermutung.NICHTS) return true;
		}
		for(Staerke s : Staerke.values()) {
			if(s.getVermutung() != Vermutung.NICHTS) return true;
		}
		for(Schwaeche s : Schwaeche.values()) {
			if(s.getVermutung() != Vermutung.NICHTS) return true;
		}
		for(Detaileigenschaft d : Detaileigenschaft.values()) {
			if(d.getVermutung() != Vermutung.NICHTS) return true;
		}
		return false;
	}
	private String buildBeweisString_Helper(Beweis[] beweise) {
		StringBuilder sb = new StringBuilder();
		for(Beweis b : beweise) if(b.getVermutung() == Vermutung.DEFINITIV_JA) sb.append(b.toString() + ", ");
		return sb.toString().substring(0, sb.toString().length() - 2);
	}
	private String buildBeweisString(Geist geist) {
		StringBuilder sb = new StringBuilder();
		Beweis[] beweise = geist.getBeweise();
		int ja = 0;
		for(int i = 0; i < beweise.length; i++) {
			if(beweise[i].getVermutung() == Vermutung.DEFINITIV_JA) ja++;
		}
		switch(ja) {
		case 0:
			return HTML_STRCOLOR("0 Beweise", NEGATIVE_COLOR);
		case 1:
			return HTML_STRCOLOR("1 Beweis", POSITIVE_COLOR) + " (" + buildBeweisString_Helper(beweise) + ")";
		case 2:
			return HTML_STRCOLOR("2 Beweise", POSITIVE_COLOR) + " (" + buildBeweisString_Helper(beweise) + ")";
		case 3:
			return HTML_STRCOLOR("3 Beweise", ACCENT_COLOR) + " (" + buildBeweisString_Helper(beweise) + ")";
		}
		return sb.toString().substring(0, sb.toString().length() - 2);
	}
	
	public AuswertungPanel() {
		this.setLayout(new GridBagLayout());
		
		this.rankingListe = new Ranking().get();
		Geist maxGeist = (Geist) this.rankingListe[0];
		double maxPoints = new GeistEvaluator(maxGeist).get();
		
		double zgW = -1;
		int infoCountTotal = 0;
		int fuehrend = 0;
		
		if(istIrgendwasGesetzt()) {
			for(int i = 0; i < this.rankingListe.length; i++) {
				Geist geist = (Geist) this.rankingListe[i];
				double score = new GeistEvaluator(geist).get();
				int infoCount = new InfoCount(geist).get();
				if(score != 0) {
					infoCountTotal += infoCount;
					if(score == maxPoints) fuehrend++;
					else if(zgW == -1) zgW = score;
						
					this.add(new JLabel(HTML_START + HTML_STRCOLOR(geist.toString(), PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, i + 1, GBCPATTERN_SIDED_DETERMINANT));
					this.add(new JLabel(HTML_START + HTML_STRCOLOR(score + " Punkte", ACCENT_COLOR) + HTML_END), GridBagConstraintsUtility.build(1, i + 1, GBCPATTERN_SIDED_DETERMINANT));
					this.add(new JLabel(HTML_START + BasicUtility.runden((score / maxPoints) * 100, 2) + "%" + HTML_END), GridBagConstraintsUtility.build(2, i + 1, GBCPATTERN_SIDED_DETERMINANT));
					this.add(new JLabel(HTML_START + infoCount + " " + (infoCount == 1 ? "Hinweis" : "Hinweise") + " einbezogen" + HTML_END), GridBagConstraintsUtility.build(3, i + 1, GBCPATTERN_SIDED_DETERMINANT));
					
					//Beweise anzeigen
					this.add(new JLabel(HTML_START + this.buildBeweisString(geist) + HTML_END), GridBagConstraintsUtility.build(4, i + 1, GBCPATTERN_SIDED_DETERMINANT));
				}
			}
		}
		double eindeutigkeitswert = (maxPoints - zgW) / maxPoints;
		
		if(infoCountTotal != 0) {
			if(fuehrend > 1) {
				this.add(new JLabel(HTML_START + "Der Geist konnte nicht eindeutig ermittelt werden:" + HTML_END), GridBagConstraintsUtility.build(0, 0, 4, 1, GridBagConstraints.HORIZONTAL, 1, 1, MARGIN_SIDED));
			} else {
				this.add(new JLabel(HTML_START + "Der Geist scheint ein " + HTML_STRCOLOR(maxGeist.toString(), NEGATIVE_COLOR) + " " + HTML_STRCOLOR("(" + maxPoints + " Punkte, EdkW " + BasicUtility.runden(eindeutigkeitswert * 100, 2) + ")", SECONDARY_COLOR) + " zu sein. Es wurden " + HTML_STRCOLOR(infoCountTotal + " Hinweise", PRIMARY_COLOR) + " berücksichtigt." + HTML_END), GridBagConstraintsUtility.build(0, 0, 4, 1, GridBagConstraints.HORIZONTAL, 1, 1, MARGIN_SIDED));
			}
		} else {
			this.add(new JLabel("Ohne weitere Eingaben kann keine Auswertung erfolgen."), GridBagConstraintsUtility.build(0, 0, 4, 1, GridBagConstraints.HORIZONTAL, 1, 1, MARGIN_SIDED));
		}

		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
	}
}
