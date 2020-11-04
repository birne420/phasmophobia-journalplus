package journalplus.gui.ingamejournal;

import journalplus.gui.BasicFrame;

public class IngameJournalFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;

	public IngameJournalFrame() {
		super(WINDOW_TITLE + SEPARATOR + "Ingame Journal");
		this.setSize(960, 540);
		this.setLocationRelativeTo(null);
		
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        this.add(new IngameJournalPanel());
        
		this.setVisible(true);
	}
}