package journalplus.journal.vermutung;

public enum Vermutung {
	NICHTS {
		@Override
		public String toString() {
			return "Nichts";
		}
	},
	DEFINITIV_JA {
		@Override
		public String toString() {
			return "Ja";
		}
	},
	VERMUTLICH_JA {
		@Override
		public String toString() {
			return "Vermutlich ja";
		}
	},
	VERMUTLICH_NEIN {
		@Override
		public String toString() {
			return "Vermutlich nein";
		}
	},
	DEFINITIV_NEIN {
		@Override
		public String toString() {
			return "Nein";
		}
	};
	
	public abstract String toString();
}
