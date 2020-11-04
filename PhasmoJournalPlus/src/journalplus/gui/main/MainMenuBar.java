package journalplus.gui.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import journalplus.gui.IThemeInfluenced;
import journalplus.gui.einstellungen.EinstellungenFrame;
import journalplus.gui.ingamejournal.IngameJournalFrame;
import journalplus.gui.steckbrief.SteckbriefFrame;
import journalplus.journal.*;
import journalplus.journal.vermutung.Vermutung;

public class MainMenuBar extends JMenuBar implements MouseListener, IThemeInfluenced {
	private static final long serialVersionUID = 1L;

	private JMenu menuMehr = new JMenu("Menü");
	private JMenu menuGeister = new JMenu("Geister");
	private List<JMenu> menuGeist = new ArrayList<JMenu>();

	private JMenu menuReset;
	private JMenu menuIngameJournal;
	private JMenu menuEinstellungen;
	private JMenu menuBeenden;
	
	private MainPanel mainPanel;
	
	public MainMenuBar(String baseWindowTitle, MainPanel panel) {
		this.menuReset = new JMenu("Zurücksetzen");
		this.menuReset.addMouseListener(this);
		this.menuIngameJournal = new JMenu("Ingame Journal");
		this.menuIngameJournal.addMouseListener(this);
		this.menuEinstellungen = new JMenu("Einstellungen");
		this.menuEinstellungen.addMouseListener(this);
		this.menuBeenden = new JMenu("Beenden");
		this.menuBeenden.addMouseListener(this);
		
		this.menuGeister.addMouseListener(this);

		this.menuMehr.add(this.menuReset);
		this.menuMehr.add(this.menuIngameJournal);
		this.menuMehr.add(this.menuEinstellungen);
		this.menuMehr.add(this.menuBeenden);
		
		for(Geist geist : Geist.values()) {
			JMenu jmenu = new JMenu(geist.toString());
			jmenu.addMouseListener(this);
			this.menuGeist.add(jmenu);
			this.menuGeister.add(jmenu);
		}

		this.add(menuMehr);
		this.add(menuGeister);
		
		this.mainPanel = panel;
		
		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToComponent(this.menuMehr);
		IThemeInfluenced.applyThemeToComponent(this.menuGeister);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.menuReset) {
			this.reset();
		} else if(e.getSource() == this.menuIngameJournal) {
			new IngameJournalFrame();
		} else if(e.getSource() == this.menuEinstellungen) {
			new EinstellungenFrame();
		} else if(e.getSource() == this.menuBeenden) {
			System.exit(0);
		} else {
			for(int i = 0; i < this.menuGeist.size(); i++) {
				if(e.getSource() == this.menuGeist.get(i)) {
					new SteckbriefFrame(Geist.values()[i]);
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }
	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) { }
	
	private void reset() {
		for(Geist g : Geist.values()) {
			for(Beweis b : g.getBeweise()) {
				b.setVermutung(Vermutung.NICHTS);
			}
			g.getStaerke().setVermutung(Vermutung.NICHTS);
			g.getSchwaeche().setVermutung(Vermutung.NICHTS);
			for(Detaileigenschaft d : g.getDetails()) {
				d.setVermutung(Vermutung.NICHTS);
			}
		}
		this.mainPanel.reset();
	}
}
