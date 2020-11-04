package journalplus.journal.auswertung;

import journalplus.journal.*;
import journalplus.journal.vermutung.Vermutung;

public class InfoCount {
	private int info;
	
	public InfoCount(Geist geist) {
		this.info = 0;
		
		for(Beweis b : geist.getBeweise()) if(b.getVermutung() != Vermutung.NICHTS) this.info++;
		if(geist.getStaerke().getVermutung() != Vermutung.NICHTS) this.info++;
		if(geist.getSchwaeche().getVermutung() != Vermutung.NICHTS) this.info++;
		for(Detaileigenschaft d : geist.getDetails()) if(d.getVermutung() != Vermutung.NICHTS) this.info++;
	}
	
	public int get() {
		return this.info;
	}
}
