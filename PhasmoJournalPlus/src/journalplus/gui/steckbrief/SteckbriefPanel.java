package journalplus.gui.steckbrief;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;
import journalplus.journal.Beweis;
import journalplus.journal.Detaileigenschaft;
import journalplus.journal.Geist;
import journalplus.journal.Schwaeche;
import journalplus.journal.Staerke;
import journalplus.journal.auswertung.GeistEvaluator;
import journalplus.journal.vermutung.Vermutung;
import journalplus.utility.gridbagconstraints.*;

public class SteckbriefPanel extends BasicPanel {
	private static final long serialVersionUID = 1L;
	
	private Beweis[] geistBeweise;
	private Staerke geistStaerke;
	private Schwaeche geistSchwaeche;
	private Detaileigenschaft[] geistDetails;

	public SteckbriefPanel(Geist geist) {
		this.geistBeweise = geist.getBeweise();
		this.geistStaerke = geist.getStaerke();
		this.geistSchwaeche = geist.getSchwaeche();
		this.geistDetails = geist.getDetails();
		
		this.setLayout(new GridBagLayout());

		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Geist", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 0, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + HTML_STRCOLOR(geist.toString(), NEGATIVE_COLOR) + HTML_END), GridBagConstraintsUtility.build(1, 0, GBCPATTERN_SIDED_DETERMINANT));

		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Beweise", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 1, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + geistBeweiseToString() + HTML_END), GridBagConstraintsUtility.build(1, 1, GBCPATTERN_SIDED_DETERMINANT));

		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Stärke", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 2, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + this.geistStaerke.toString() + HTML_STRCOLOR(" (" + this.geistStaerke.getVermutung().toString() + ")", (this.geistStaerke.getVermutung() == Vermutung.NICHTS) ? SECONDARY_COLOR : ACCENT_COLOR) + HTML_END), GridBagConstraintsUtility.build(1, 2, GBCPATTERN_SIDED_DETERMINANT));

		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Schwäche", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 3, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + this.geistSchwaeche.toString() + HTML_STRCOLOR(" (" + this.geistSchwaeche.getVermutung().toString() + ")", (this.geistSchwaeche.getVermutung() == Vermutung.NICHTS) ? SECONDARY_COLOR : ACCENT_COLOR) + HTML_END), GridBagConstraintsUtility.build(1, 3, GBCPATTERN_SIDED_DETERMINANT));

		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Details", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 4, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + geistDetailsToString() + HTML_END), GridBagConstraintsUtility.build(1, 4, GBCPATTERN_SIDED_DETERMINANT));
		
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Wertungspunkte", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 5, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + new GeistEvaluator(geist).get() + HTML_END), GridBagConstraintsUtility.build(1, 5, GBCPATTERN_SIDED_DETERMINANT));
	
		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
	}

	private String geistBeweiseToString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.geistBeweise.length; i++) {
			sb.append(this.geistBeweise[i].toString() + HTML_STRCOLOR(" (" + this.geistBeweise[i].getVermutung().toString() + ")", (this.geistBeweise[i].getVermutung() == Vermutung.NICHTS) ? SECONDARY_COLOR : ACCENT_COLOR) + ", ");
		}
		return sb.toString().substring(0, sb.toString().length() - 2);
	}
	private String geistDetailsToString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < this.geistDetails.length; i++) {
			sb.append(this.geistDetails[i].toString() + HTML_STRCOLOR(" (" + this.geistDetails[i].getVermutung().toString() + ")", (this.geistDetails[i].getVermutung() == Vermutung.NICHTS) ? SECONDARY_COLOR : ACCENT_COLOR) + ", ");
		}
		return sb.toString().substring(0, sb.toString().length() - 2);
	}
}
