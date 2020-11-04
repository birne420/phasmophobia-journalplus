package journalplus.journal;

import journalplus.journal.vermutung.*;

public enum Detaileigenschaft implements IVermutung {
	GEWOEHNLICH {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Gew�hnlich";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	STARK {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Stark";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	GEFAEHRLICH {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Gef�hrlich";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	LAUT {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Laut";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	AGGRESSIV {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Aggressiv";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	SCHNELL {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Schnell";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	LANGSAM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Langsam";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	SEHR_AKTIV {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Sehr aktiv";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	SCHUECHTERN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Sch�chtern";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	
	RAEUCHERSTAEBCHEN_WIRKSAM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "R�ucherst�chen stoppen Aktivit�t";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	KRUZIFIX_WIRKSAM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Angst vor Kruzifix";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	OUIJABOARD {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Ouijaboard beschw�rt Geist/Ouijaboard-Befragung beeinflusst nicht den Verstand";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},

	VERSTAND_STARK_BEEINFLUSST {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Verstand stark beeinflusst";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	MANIPULIERT_UMGEBUNG {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Manipuliert/Ver�ndert die Umgebung";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	TERRITORIAL_ANGRIFF_BEI_BEDRAENGNIS {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Territoriale Angriffe bei Bedr�ngnis";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	HEFTIGE_WAHLLOSE_ANGRIFFE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Heftige, wahllose Angriffe";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	UNGEWOEHNLICH_VIELE_ANGRIFFE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Ungew�hnlich viele Angriffe";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	NUR_AKTIV_BEI_EINZELNEN_PERSONEN {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Nur bei einzelnen Personen aktiv";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	
	SCHWEBT {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Schwebt";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	KEINE_FUSSABDRUECKE {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Keine Fu�abdr�cke";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	
	NACHTAKTIV {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Nur bei Dunkelheit aktiv";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	BRAUCHT_STROM {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Keine Aktivit�t ohne Strom";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	HASST_LICHT {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Ereignisse beschr�nken sich auf Dunkelheit";
		}

		@Override
		public void setVermutung(Vermutung neueVermutung) {
			this.vermutung = neueVermutung;
		}

		@Override
		public Vermutung getVermutung() {
			return this.vermutung;
		}
	},
	STALKT {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "Stalkt nur eine Person";
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
	
	public abstract String toString();
}
