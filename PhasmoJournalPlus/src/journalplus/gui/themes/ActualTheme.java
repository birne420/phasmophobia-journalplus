package journalplus.gui.themes;

import java.awt.Color;

public class ActualTheme {
	private String name;
	private String id;
	
	private String positive;
	private String negative;
	private String neutral;
	private String decent;
	private String signal;
	private Color awtBg;
	private Color awtFg;
	
	public ActualTheme(String name, String id, String positive, String negative, String neutral, String decent, String signal, Color awtBg, Color awtFg) {
		this.name = name;
		this.id = id;
		
		this.positive = positive;
		this.negative = negative;
		this.neutral = neutral;
		this.decent = decent;
		this.signal = signal;
		
		this.awtBg = awtBg;
		this.awtFg = awtFg;
	}
	public String getEinstellungThemePositive() { return this.positive; }
	public String getEinstellungThemeNegative() { return this.negative; }
	public String getEinstellungThemeNeutral() { return this.neutral; }
	public String getEinstellungThemeDecent() { return this.decent; }
	public String getEinstellungThemeSignal() { return this.signal; }
	public Color getEinstellungThemeAwtBg() { return this.awtBg; }
	public Color getEinstellungThemeAwtFg() { return this.awtFg; }
	public String getThemeName() { return this.name; }
	public String getThemeId() { return this.id; }
}
