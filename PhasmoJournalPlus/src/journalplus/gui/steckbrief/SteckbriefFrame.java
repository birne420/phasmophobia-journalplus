package journalplus.gui.steckbrief;

import journalplus.gui.BasicFrame;
import journalplus.journal.Geist;

public class SteckbriefFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;

	public SteckbriefFrame(Geist geist) {
		super(WINDOW_TITLE + SEPARATOR + geist.toString());
		this.setSize(640, 360);
		this.setLocationRelativeTo(null);
		
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        this.add(new SteckbriefPanel(geist));
        
		this.setVisible(true);
	}
}
