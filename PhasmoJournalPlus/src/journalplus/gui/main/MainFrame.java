package journalplus.gui.main;

import java.awt.Dimension;

import journalplus.gui.BasicFrame;
import journalplus.main.Logger;
import journalplus.main.settings.Settings;
import journalplus.main.updater.UpdateThread;

public class MainFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;
	
	private Thread updateThread;
	
	public MainFrame() {
		super(WINDOW_TITLE);
		Logger.log("main", "awaiking...");
		
		this.setSize(Settings.EINSTELLUNG_FENSTER_X, Settings.EINSTELLUNG_FENSTER_Y);
		Logger.log("main.gui", "set window size to " + Settings.EINSTELLUNG_FENSTER_X + "x" + Settings.EINSTELLUNG_FENSTER_Y);
		this.setLocationRelativeTo(null);
		Logger.log("main.gui", "set window position to centered");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Logger.log("main.gui", "set default close operation to EXIT_ON_CLOSE");
		this.setMinimumSize(new Dimension(Settings.EINSTELLUNG_FENSTER_X, Settings.EINSTELLUNG_FENSTER_Y));
		Logger.log("main.gui", "set minimum size to " + Settings.EINSTELLUNG_FENSTER_X + "x" + Settings.EINSTELLUNG_FENSTER_Y);
        
        MainPanel panel = new MainPanel();
        
        Logger.log("main.gui", "applying menu bar to panel");
        this.setJMenuBar(new MainMenuBar(WINDOW_TITLE, panel));
        this.add(panel);

        Logger.log("main.gui", "open up gui");
		this.setVisible(true);

        Logger.log("main.updater", "initialize auto updater");
		this.updateThread = new UpdateThread();
		this.updateThread.start();
	}
}
