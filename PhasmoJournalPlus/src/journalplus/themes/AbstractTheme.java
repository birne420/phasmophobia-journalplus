package journalplus.themes;

import java.awt.Color;

public abstract class AbstractTheme {
	public abstract String getEinstellungThemePositive();
	public abstract String getEinstellungThemeNegative();
	public abstract String getEinstellungThemeNeutral();
	public abstract String getEinstellungThemeDecent();
	public abstract String getEinstellungThemeSignal();
	public abstract Color getEinstellungThemeAwtBg();
	public abstract Color getEinstellungThemeAwtFg();
	public abstract String getThemeName();
}
