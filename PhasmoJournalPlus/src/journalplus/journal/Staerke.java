package journalplus.journal;

import journalplus.journal.vermutung.*;

public enum Staerke implements IVermutung {
	KEINE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Keine.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Spirit
	BERUEHRT_NIE_DEN_BODEN_KEINE_FUSSABDRUECKE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Berührt nie den Boden wodurch es nicht durch Fußabdrücke gefunden werden kann.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Gespenst
	SENKT_VERSTAND_STARK_BEIM_ANSCHAUEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Senkt den Verstand stark wenn es angesehen wird.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Phantom
	WIRFT_VIELE_OBJEKTE_AUF_EINMAL {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es kann viele Objekte auf einmal werfen.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Poltergeist
	JAGT_JEWEILS_NUR_EINE_PERSON {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es jagt jeweils nur eine Person.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Banshee
	BEWEGT_SICH_SCHNELL_WENN_OPFER_WEIT_WEG {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es bewegt sich schneller wenn sein Opfer weit weg ist.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Dschinn
	GREIFT_BEVORZUGT_IM_DUNKELN_AN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Greift bevorzugt in der Dunkelheit an.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Mare
	WIRD_SCHNELLER_BEIM_JAGEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es wird schneller, wenn es sein Opfer jagt.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Revenant
	SCHWER_ZU_ENTDECKEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Der Geist ist schwer zu entdecken (zeigt sich sehr selten).";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Shade
	GREIFT_UNGEWOEHNLICH_OFT_AN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Greift ungewöhnlich oft an.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Dämon
	STAERKERER_EINFLUSS_AUF_VERSTAND {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es hat einen stärkeren Einfluss auf den Geisteszustand.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}, //Yurei
	SCHNELLE_OBJEKTBEWEGUNG_UND_GRUPPENAKTIV {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Objekte werden mit großer Geschwindigkeit bewegt; Hohe Aktivität wenn Leute in der Nähe sind.";
		}

		@Override
		public String toString() {
			return getInfoString();
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	}; //Oni
	
	public abstract String getInfoString();
	public abstract String toString();
}
