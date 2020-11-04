package journalplus.themes;

import java.awt.Color;

public class DefaultTheme extends AbstractTheme {
	@Override
	public String getEinstellungThemePositive() { return "#58ad56"; }
	@Override
	public String getEinstellungThemeNegative() { return "#ff3700"; }
	@Override
	public String getEinstellungThemeNeutral() { return "#395f7f"; }
	@Override
	public String getEinstellungThemeDecent() { return "#ababab"; }
	@Override
	public String getEinstellungThemeSignal() { return "#ff9e00"; }
	@Override
	public Color getEinstellungThemeAwtBg() { return null; }
	@Override
	public Color getEinstellungThemeAwtFg() { return null; }
	@Override
	public String getThemeName() { return "default"; }
}
