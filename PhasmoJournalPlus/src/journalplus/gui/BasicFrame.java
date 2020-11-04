package journalplus.gui;

import javax.swing.JFrame;

import journalplus.main.settings.Settings;

public abstract class BasicFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final String WINDOW_TITLE = Settings.EINSTELLUNG_TITEL;
	public static final String SEPARATOR = Settings.EINSTELLUNG_TITEL_SEPARATOR;
	
	public BasicFrame(String text) {
		super(text);
	}
}
