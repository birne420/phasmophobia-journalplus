package journalplus.journal.auswertung;

import journalplus.journal.*;
import journalplus.main.settings.Settings;
import journalplus.utility.BasicUtility;

public class GeistEvaluator {
	private double beweisFaktor = 1;
	private double staerkeFaktor = 1;
	private double schwaecheFaktor = 1;
	private double detailFaktor = 1;

	private static final double faktorDJ = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA;
	private static final double faktorVJ = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERJA;
	private static final double faktorVN = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERNEIN;
	private static final double faktorDN = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN;
	
	private static final double faktorDJ2 = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA2;
	private static final double faktorDN2 = Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN2;
	
	public GeistEvaluator(Geist geist) {
		Beweis[] geistBeweise = geist.getBeweise();
		Staerke geistStaerke = geist.getStaerke();
		Schwaeche geistSchwaeche = geist.getSchwaeche();
		Detaileigenschaft[] geistDetaileigenschaften = geist.getDetails();
		
		for(Beweis geistBeweis : geistBeweise) {
			switch(geistBeweis.getVermutung()) {
				case DEFINITIV_JA:
					this.beweisFaktor *= faktorDJ2;
					break;
				case VERMUTLICH_JA:
					this.beweisFaktor *= faktorVJ;
					break;
				case VERMUTLICH_NEIN:
					this.beweisFaktor *= faktorVN;
					break;
				case DEFINITIV_NEIN:
					this.beweisFaktor *= faktorDN;
					break;
				case NICHTS: default: break;
			}
		}

		switch(geistStaerke.getVermutung()) {
			case DEFINITIV_JA:
				this.staerkeFaktor *= faktorDJ;
				break;
			case VERMUTLICH_JA:
				this.staerkeFaktor *= faktorVJ;
				break;
			case VERMUTLICH_NEIN:
				this.staerkeFaktor *= faktorVN;
				break;
			case DEFINITIV_NEIN:
				this.staerkeFaktor *= faktorDN2;
				break;
			case NICHTS: default: break;
		}

		switch(geistSchwaeche.getVermutung()) {
			case DEFINITIV_JA:
				this.schwaecheFaktor *= faktorDJ;
				break;
			case VERMUTLICH_JA:
				this.schwaecheFaktor *= faktorVJ;
				break;
			case VERMUTLICH_NEIN:
				this.schwaecheFaktor *= faktorVN;
				break;
			case DEFINITIV_NEIN:
				this.schwaecheFaktor *= faktorDN2;
				break;
			case NICHTS: default: break;
		}
		
		for(Detaileigenschaft geistDetaileigenschaft : geistDetaileigenschaften) {
			switch(geistDetaileigenschaft.getVermutung()) {
				case DEFINITIV_JA:
					this.detailFaktor *= faktorDJ;
					break;
				case VERMUTLICH_JA:
					this.detailFaktor *= faktorVJ;
					break;
				case VERMUTLICH_NEIN:
					this.detailFaktor *= faktorVN;
					break;
				case DEFINITIV_NEIN:
					this.detailFaktor *= faktorDN2;
					break;
				case NICHTS: default: break;
			}
		}
	}
	
	public double get() { return BasicUtility.runden(beweisFaktor * staerkeFaktor * schwaecheFaktor * detailFaktor, 2); }
}
