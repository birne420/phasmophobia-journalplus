package journalplus.gui.steckbrief;

import journalplus.gui.BasicFrame;
import journalplus.journal.Geist;
import journalplus.main.Logger;

public class SteckbriefFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;

	public SteckbriefFrame(Geist geist) {
		super(WINDOW_TITLE + SEPARATOR + geist.toString());
		Logger.log("steckbrief.gui", "init");
		this.setSize(640, 360);
		this.setLocationRelativeTo(null);
		
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        this.add(new SteckbriefPanel(geist));
        
		this.setVisible(true);
		Logger.log("steckbrief.gui", "showing window");
	}
}
