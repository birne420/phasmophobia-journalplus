package journalplus.journal;

import journalplus.journal.vermutung.*;

public enum Beweis implements IVermutung {
	EMF_LEVEL_5 {
		private Vermutung vermutung = Vermutung.NICHTS;
		
		@Override
		public String toString() {
			return "EMF Level 5";
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
	GEISTERBOX {
		private Vermutung vermutung = Vermutung.NICHTS;;
		
		@Override
		public String toString() {
			return "Geisterbox";
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
	FINGERABDRUECKE {
		private Vermutung vermutung = Vermutung.NICHTS;;
		
		@Override
		public String toString() {
			return "Fingerabdrücke";
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
	GEISTERKUGEL {
		private Vermutung vermutung = Vermutung.NICHTS;;
		
		@Override
		public String toString() {
			return "Geisterkugel";
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
	GEISTERBUCH {
		private Vermutung vermutung = Vermutung.NICHTS;;
		
		@Override
		public String toString() {
			return "Geisterbuch";
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
	GEFRIERTEMPERATUREN {
		private Vermutung vermutung = Vermutung.NICHTS;;
		
		@Override
		public String toString() {
			return "Gefriertemperaturen";
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
