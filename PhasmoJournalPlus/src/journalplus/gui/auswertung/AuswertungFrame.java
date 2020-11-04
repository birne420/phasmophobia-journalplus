package journalplus.gui.auswertung;

import journalplus.gui.BasicFrame;

public class AuswertungFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;

	public AuswertungFrame(String title) {
		super(WINDOW_TITLE + SEPARATOR + "Auswertung");
		this.setSize(960, 540);
		this.setLocationRelativeTo(null);
		
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        this.add(new AuswertungPanel());
        
		this.setVisible(true);
	}
}
