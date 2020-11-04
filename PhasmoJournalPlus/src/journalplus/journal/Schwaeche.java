package journalplus.journal;

import journalplus.journal.vermutung.*;

public enum Schwaeche implements IVermutung {
	KANN_MIT_RAEUCHERSTAEBCHEN_VORUEBERGEHEND_GESTOPPT_WERDEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es wird vor�bergehend gestoppt, wenn der Raum ausger�uchert wird.";
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
	SALZ {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Giftige Reaktion auf Salz.";
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
	KANN_DURCH_FOTOGRAFIEREN_VORUEBERGEHEND_GESTOPPT_WERDEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Kann durch Fotografieren vor�bergehend gestoppt werden.";
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
	INEFFEKTIV_IN_LEEREN_RAEUMEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es ist ein einem leeren Raum fast ineffektiv.";
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
	ANGST_VOR_KRUZIFIX {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es f�rchtet das Krizifix und ist weniger aggressiv in seinem Umkreis.";
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
	KEINE_MACHT_OHNE_STROM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Dem Ort seinen Strom zu entziehen hintert es am Nutzen seiner F�higkeiten.";
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
	GREIFT_SELTEN_BEI_LICHT_AN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Schaltet man die Lichter ein ist die Chance auf einen Angriff eher gering.";
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
	BEWEGT_SICH_BEI_VERSTECKEN_LANGSAM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Versteckt man sich vor ihm, bewegt es sich sehr langsam.";
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
	KEINE_ANGRIFFE_AUF_MEHRERE_LEUTE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es gibt keine Angriffe auf mehrere Menschen zusammen.";
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
	ERFOLGREICHE_BEFRAGUNG_DURCH_OUIJA_BOARD_VERRINGERT_NICHT_DEN_VERSTAND {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Erfolgreiche Befragungen des Ouija-Boards �ber den D�mon verringern nicht den Geisteszustand.";
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
	}, //D�mon
	KANN_MIT_RAEUCHERSTAEBCHEN_LAENGERE_ZEIT_GESTOPPT_WERDEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Es wird l�ngere Zeit keine Bewegung geben, wenn der Raum ausger�uchert wird.";
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
	DURCH_HOHE_AKTIVITAET_LEICHT_ZU_ERKENNEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String getInfoString() {
			return "Sehr hohe Aktivit�tsrate.";
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
	};
	
	public abstract String getInfoString();
	public abstract String toString();
}
