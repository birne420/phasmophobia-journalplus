package journalplus.journal;

public enum Geist {
	SPIRIT {
		@Override
		public String toString() {
			return "Spirit";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERBOX,
				Beweis.FINGERABDRUECKE,
				Beweis.GEISTERBUCH
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.KEINE;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.KANN_MIT_RAEUCHERSTAEBCHEN_VORUEBERGEHEND_GESTOPPT_WERDEN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.GEWOEHNLICH,
				Detaileigenschaft.STARK,
				Detaileigenschaft.GEFAEHRLICH,
				Detaileigenschaft.RAEUCHERSTAEBCHEN_WIRKSAM
			};
		}
	},
	GESPENST {
		@Override
		public String toString() {
			return "Gespenst";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.FINGERABDRUECKE,
				Beweis.GEFRIERTEMPERATUREN,
				Beweis.GEISTERBOX
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.BERUEHRT_NIE_DEN_BODEN_KEINE_FUSSABDRUECKE;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.SALZ;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.GEFAEHRLICH,
				Detaileigenschaft.SCHWEBT,
				Detaileigenschaft.KEINE_FUSSABDRUECKE
			};
		}
	},
	PHANTOM {
		@Override
		public String toString() {
			return "Phantom";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.EMF_LEVEL_5,
				Beweis.GEISTERKUGEL,
				Beweis.GEFRIERTEMPERATUREN
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.SENKT_VERSTAND_STARK_BEIM_ANSCHAUEN;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.KANN_DURCH_FOTOGRAFIEREN_VORUEBERGEHEND_GESTOPPT_WERDEN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.VERSTAND_STARK_BEEINFLUSST,
				Detaileigenschaft.OUIJABOARD
			};
		}
	},
	POLTERGEIST {
		@Override
		public String toString() {
			return "Poltergeist";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERBOX,
				Beweis.FINGERABDRUECKE,
				Beweis.GEISTERKUGEL
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.WIRFT_VIELE_OBJEKTE_AUF_EINMAL;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.INEFFEKTIV_IN_LEEREN_RAEUMEN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.LAUT,
				Detaileigenschaft.MANIPULIERT_UMGEBUNG
			};
		}
	},
	BANSHEE {
		@Override
		public String toString() {
			return "Banshee";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.EMF_LEVEL_5,
				Beweis.FINGERABDRUECKE,
				Beweis.GEFRIERTEMPERATUREN
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.JAGT_JEWEILS_NUR_EINE_PERSON;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.ANGST_VOR_KRUZIFIX;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.AGGRESSIV,
				Detaileigenschaft.STALKT,
				Detaileigenschaft.KRUZIFIX_WIRKSAM
			};
		}
	},
	DSCHINN {
		@Override
		public String toString() {
			return "Dschinn";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERBOX,
				Beweis.GEISTERKUGEL,
				Beweis.EMF_LEVEL_5
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.BEWEGT_SICH_SCHNELL_WENN_OPFER_WEIT_WEG;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.KEINE_MACHT_OHNE_STROM;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.TERRITORIAL_ANGRIFF_BEI_BEDRAENGNIS,
				Detaileigenschaft.SCHNELL,
				Detaileigenschaft.BRAUCHT_STROM
			};
		}
	},
	MARE {
		@Override
		public String toString() {
			return "Mare";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERBOX,
				Beweis.GEISTERKUGEL,
				Beweis.GEFRIERTEMPERATUREN
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.GREIFT_BEVORZUGT_IM_DUNKELN_AN;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.GREIFT_SELTEN_BEI_LICHT_AN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.NACHTAKTIV,
				Detaileigenschaft.HASST_LICHT
			};
		}
	},
	REVENANT {
		@Override
		public String toString() {
			return "Revenant";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.EMF_LEVEL_5,
				Beweis.FINGERABDRUECKE,
				Beweis.GEISTERBUCH
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.WIRD_SCHNELLER_BEIM_JAGEN;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.BEWEGT_SICH_BEI_VERSTECKEN_LANGSAM;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.LANGSAM,
				Detaileigenschaft.STARK,
				Detaileigenschaft.HEFTIGE_WAHLLOSE_ANGRIFFE
			};
		}
	},
	SHADE {
		@Override
		public String toString() {
			return "Shade";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.EMF_LEVEL_5,
				Beweis.GEISTERKUGEL,
				Beweis.GEISTERBUCH
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.SCHWER_ZU_ENTDECKEN;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.KEINE_ANGRIFFE_AUF_MEHRERE_LEUTE;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.SCHUECHTERN,
				Detaileigenschaft.NUR_AKTIV_BEI_EINZELNEN_PERSONEN
			};
		}
	},
	DAEMON {
		@Override
		public String toString() {
			return "Dämon";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERBOX,
				Beweis.GEISTERBUCH,
				Beweis.GEFRIERTEMPERATUREN
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.GREIFT_UNGEWOEHNLICH_OFT_AN;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.ERFOLGREICHE_BEFRAGUNG_DURCH_OUIJA_BOARD_VERRINGERT_NICHT_DEN_VERSTAND;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.STARK,
				Detaileigenschaft.GEFAEHRLICH,
				Detaileigenschaft.HEFTIGE_WAHLLOSE_ANGRIFFE,
				Detaileigenschaft.UNGEWOEHNLICH_VIELE_ANGRIFFE,
				Detaileigenschaft.OUIJABOARD
			};
		}
	},
	YUREI {
		@Override
		public String toString() {
			return "Yurei";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.GEISTERKUGEL,
				Beweis.GEISTERBUCH,
				Beweis.GEFRIERTEMPERATUREN
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.STAERKERER_EINFLUSS_AUF_VERSTAND;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.KANN_MIT_RAEUCHERSTAEBCHEN_LAENGERE_ZEIT_GESTOPPT_WERDEN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.RAEUCHERSTAEBCHEN_WIRKSAM,
				Detaileigenschaft.VERSTAND_STARK_BEEINFLUSST
			};
		}
	},
	ONI {
		@Override
		public String toString() {
			return "Oni";
		}

		@Override
		public Beweis[] getBeweise() {
			return new Beweis[] {
				Beweis.EMF_LEVEL_5,
				Beweis.GEISTERBOX,
				Beweis.GEISTERBUCH
			};
		}

		@Override
		public Staerke getStaerke() {
			return Staerke.SCHNELLE_OBJEKTBEWEGUNG_UND_GRUPPENAKTIV;
		}

		@Override
		public Schwaeche getSchwaeche() {
			return Schwaeche.DURCH_HOHE_AKTIVITAET_LEICHT_ZU_ERKENNEN;
		}

		@Override
		public Detaileigenschaft[] getDetails() {
			return new Detaileigenschaft[] {
				Detaileigenschaft.SEHR_AKTIV,
				Detaileigenschaft.MANIPULIERT_UMGEBUNG
			};
		}
	};
	
	public abstract String toString();
	public abstract Beweis[] getBeweise();
	public abstract Staerke getStaerke();
	public abstract Schwaeche getSchwaeche();
	public abstract Detaileigenschaft[] getDetails();
}
