package journalplus.themes;

import java.awt.Color;

public class DarkTheme extends AbstractTheme {
	@Override
	public String getEinstellungThemePositive() { return "#58ad56"; }
	@Override
	public String getEinstellungThemeNegative() { return "#ff1e00"; }
	@Override
	public String getEinstellungThemeNeutral() { return "#6f94b7"; }
	@Override
	public String getEinstellungThemeDecent() { return "#ababab"; }
	@Override
	public String getEinstellungThemeSignal() { return "#ff9e00"; }
	@Override
	public Color getEinstellungThemeAwtBg() { return Color.DARK_GRAY; }
	@Override
	public Color getEinstellungThemeAwtFg() { return Color.WHITE; }
	@Override
	public String getThemeName() { return "dark"; }
}
