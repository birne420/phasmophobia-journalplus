package journalplus.main;

import journalplus.gui.main.MainFrame;

public class JournalPlus {
	public static void main(String[] args) {
		Logger.setLoggingEnabled(true);
		new MainFrame();
	}
}
