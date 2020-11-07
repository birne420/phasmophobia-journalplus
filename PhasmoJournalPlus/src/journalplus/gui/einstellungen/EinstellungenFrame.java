package journalplus.gui.einstellungen;

import journalplus.gui.BasicFrame;

public class EinstellungenFrame extends BasicFrame {
	private static final long serialVersionUID = 1L;

	public EinstellungenFrame() {
		super(WINDOW_TITLE + SEPARATOR + "Einstellungen");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        this.add(new EinstellungenPanel(this));
        
		this.setVisible(true);
	}
}
