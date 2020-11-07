package journalplus.main.settings;

import java.awt.Color;

import journalplus.gui.themes.ActualTheme;

public class Settings {
	public static final String EINSTELLUNG_VERSION_STRING = "v1.41";
	
	public static final String EINSTELLUNG_TITEL = "Phasmophobia - JournalPlus ";
	public static final String EINSTELLUNG_TITEL_SEPARATOR = " / ";
	public static final String EINSTELLUNG_UPDATE_URL = "https://raw.githubusercontent.com/birne420/phasmophobia-journalplus/master/PhasmoJournalPlus/versions/update.json";

	private static int scalingFactor = SettingsIO.getWindowSizeScale();
	public static int EINSTELLUNG_FENSTER_X = (int) (scalingFactor * Math.pow(4, 2));
	public static int EINSTELLUNG_FENSTER_Y = (int) (scalingFactor * Math.pow(3, 2));

	public static boolean EINSTELLUNG_GEISTERLISTE_LIVE = SettingsIO.getLiveList();
	
	public static ActualTheme EINSTELLUNG_THEME = SettingsIO.getTheme();
	public static String EINSTELLUNG_THEME_POSITIVE = EINSTELLUNG_THEME.getEinstellungThemePositive();
	public static String EINSTELLUNG_THEME_NEGATIVE = EINSTELLUNG_THEME.getEinstellungThemeNegative();
	public static String EINSTELLUNG_THEME_NEUTRAL = EINSTELLUNG_THEME.getEinstellungThemeNeutral();
	public static String EINSTELLUNG_THEME_DECENT = EINSTELLUNG_THEME.getEinstellungThemeDecent();
	public static String EINSTELLUNG_THEME_SIGNAL = EINSTELLUNG_THEME.getEinstellungThemeSignal();
	public static Color EINSTELLUNG_THEME_AWTBG = EINSTELLUNG_THEME.getEinstellungThemeAwtBg();
	public static Color EINSTELLUNG_THEME_AWTFG = EINSTELLUNG_THEME.getEinstellungThemeAwtFg();

	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA = SettingsIO.getAuswertungFaktorDefJa();
	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_VERJA = SettingsIO.getAuswertungFaktorVerJa();
	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_VERNEIN = SettingsIO.getAuswertungFaktorVerNein();
	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN = SettingsIO.getAuswertungFaktorDefNein();
	
	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA2 = SettingsIO.getAuswertungFaktorDefJa2();
	public static double EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN2 = SettingsIO.getAuswertungFaktorDefNein2();
}
