package journalplus.gui.main;

import java.awt.Dimension;

import journalplus.gui.BasicFrame;
import journalplus.main.settings.Settings;
import journalplus.main.updater.UpdateThread;

public class MainFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;
	
	private Thread updateThread;
	
	public MainFrame() {
		super(WINDOW_TITLE);
		
		this.setSize(Settings.EINSTELLUNG_FENSTER_X, Settings.EINSTELLUNG_FENSTER_Y);
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(Settings.EINSTELLUNG_FENSTER_X, Settings.EINSTELLUNG_FENSTER_Y));
        
        MainPanel panel = new MainPanel();
        
        this.setJMenuBar(new MainMenuBar(WINDOW_TITLE, panel));
        this.add(panel);
        
		this.setVisible(true);
		
		this.updateThread = new UpdateThread();
		this.updateThread.start();
	}
}
