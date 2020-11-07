package journalplus.gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;

import journalplus.main.settings.Settings;
import journalplus.utility.GridBagConstraintsPattern;
import journalplus.utility.HTMLTextFormatUtility;

public abstract class BasicPanel extends JPanel implements IThemeInfluenced {
	private static final long serialVersionUID = 1L;
	
	public static final String WINDOW_TITLE = Settings.EINSTELLUNG_TITEL;

	public static final String POSITIVE_COLOR = Settings.EINSTELLUNG_THEME_POSITIVE;
	public static final String NEGATIVE_COLOR = Settings.EINSTELLUNG_THEME_NEGATIVE;
	public static final String PRIMARY_COLOR = Settings.EINSTELLUNG_THEME_NEUTRAL;
	public static final String SECONDARY_COLOR = Settings.EINSTELLUNG_THEME_DECENT;
	public static final String ACCENT_COLOR = Settings.EINSTELLUNG_THEME_SIGNAL;

	public static final Insets MARGIN_DEFAULT = new Insets(5, 5, 5, 5);
	public static final Insets MARGIN_LIGHTSIDED = new Insets(5, 10, 5, 5);
	public static final Insets MARGIN_SIDED = new Insets(5, 20, 5, 5);
	
	public static final String HTML_START = HTMLTextFormatUtility.START;
	public static final String HTML_END = HTMLTextFormatUtility.END;
	public static final String HTML_STRCOLOR(String text, String color) {
		return HTMLTextFormatUtility.STRCOLOR(text, color);
	}
	
	public static final GridBagConstraintsPattern GBCPATTERN_DEFAULT = new GridBagConstraintsPattern(1, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_DEFAULT, GridBagConstraints.CENTER);
	public static final GridBagConstraintsPattern GBCPATTERN_DEFAULT_DETERMINANT = new GridBagConstraintsPattern(1, 1, GridBagConstraints.HORIZONTAL, 1, 1, MARGIN_DEFAULT, GridBagConstraints.CENTER);
	public static final GridBagConstraintsPattern GBCPATTERN_SIDED = new GridBagConstraintsPattern(1, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_SIDED, GridBagConstraints.CENTER);
	public static final GridBagConstraintsPattern GBCPATTERN_SIDED_DETERMINANT = new GridBagConstraintsPattern(1, 1, GridBagConstraints.HORIZONTAL, 1, 1, MARGIN_SIDED, GridBagConstraints.CENTER);
}
