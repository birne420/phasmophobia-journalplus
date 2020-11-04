package journalplus.main.settings;

import java.awt.Color;

import journalplus.themes.*;

public class Settings {
	public static final String EINSTELLUNG_VERSION_STRING = "v1.34[prior1]";
	
	public static final String EINSTELLUNG_TITEL = "Phasmophobia - JournalPlus " + EINSTELLUNG_VERSION_STRING;
	public static final String EINSTELLUNG_TITEL_SEPARATOR = " / ";

	private static int scalingFactor = SettingsIO.getWindowSizeScale();
	public static int EINSTELLUNG_FENSTER_X = (int) (scalingFactor * Math.pow(4, 2));
	public static int EINSTELLUNG_FENSTER_Y = (int) (scalingFactor * Math.pow(3, 2));

	public static boolean EINSTELLUNG_GEISTERLISTE_LIVE = SettingsIO.getLiveList();
	
	public static AbstractTheme EINSTELLUNG_THEME = SettingsIO.getTheme();
	public static String EINSTELLUNG_THEME_POSITIVE = EINSTELLUNG_THEME.getEinstellungThemePositive();
	public static String EINSTELLUNG_THEME_NEGATIVE = EINSTELLUNG_THEME.getEinstellungThemeNegative();
	public static String EINSTELLUNG_THEME_NEUTRAL = EINSTELLUNG_THEME.getEinstellungThemeNeutral();
	public static String EINSTELLUNG_THEME_DECENT = EINSTELLUNG_THEME.getEinstellungThemeDecent();
	public static String EINSTELLUNG_THEME_SIGNAL = EINSTELLUNG_THEME.getEinstellungThemeSignal();
	public static Color EINSTELLUNG_THEME_AWTBG = EINSTELLUNG_THEME.getEinstellungThemeAwtBg();
	public static Color EINSTELLUNG_THEME_AWTFG = EINSTELLUNG_THEME.getEinstellungThemeAwtFg();
}
