package journalplus.gui.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;
import journalplus.gui.auswertung.AuswertungFrame;
import journalplus.gui.steckbrief.SteckbriefFrame;
import journalplus.journal.*;
import journalplus.journal.auswertung.GeistEvaluator;
import journalplus.journal.auswertung.Ranking;
import journalplus.journal.vermutung.IVermutung;
import journalplus.journal.vermutung.Vermutung;
import journalplus.main.settings.Settings;
import journalplus.utility.colormixingutility.ColorMixingUtility;
import journalplus.utility.gridbagconstraints.GridBagConstraintsPattern;
import journalplus.utility.gridbagconstraints.GridBagConstraintsUtility;

public class MainPanel extends BasicPanel implements ActionListener, ListSelectionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private GUIState guiState = GUIState.NICHTS;

	private Insets generalMargin;
	
	private DefaultListModel<String> listEigenschaftenModel;
	private JList<String> listEigenschaften;
	private DefaultListModel<String> listGeisterModel;
	private JList<String> listGeister;
	
	private JButton buttonBeweise;
	private JButton buttonStaerken;
	private JButton buttonSchwaechen;
	private JButton buttonDetaileigenschaften;
	private JButton buttonAuswertung;
	
	private JButton buttonVermutungNichts;
	private JButton buttonVermutungDefinitivJa;
	private JButton buttonVermutungVermutlichJa;
	private JButton buttonVermutungVermutlichNein;
	private JButton buttonVermutungDefinitivNein;

	private JLabel labelMenu;
	private JLabel labelTitel;
	private JLabel labelGeister;
	private JLabel labelAuswahl;
	
	private static final GridBagConstraintsPattern GBCPATTERN_SPECIAL_LABEL = new GridBagConstraintsPattern(1, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_LIGHTSIDED, GridBagConstraints.WEST);
	private static final String LABEL_NOTHING_SELECTED = HTML_START + HTML_STRCOLOR("Noch kein Hinweis eingegeben!", ACCENT_COLOR) + HTML_END;
	
	//Konstruktor
	public MainPanel() {
		this.setLayout(new GridBagLayout());
		
		this.generalMargin = new Insets(5, 5, 5, 5);

		this.listEigenschaftenModel = new DefaultListModel<String>();
		this.listEigenschaften = new JList<String>(listEigenschaftenModel);
		this.listEigenschaften.addListSelectionListener(this);
		this.listGeisterModel = new DefaultListModel<String>();
		this.listGeister = new JList<String>(listGeisterModel);
		this.listGeister.addMouseListener(this);
		
		//Create Components
		this.buttonBeweise = new JButton("Beweise");
		this.buttonBeweise.addActionListener(this);
		this.buttonStaerken = new JButton("Stärken");
		this.buttonStaerken.addActionListener(this);
		this.buttonSchwaechen = new JButton("Schwächen");
		this.buttonSchwaechen.addActionListener(this);
		this.buttonDetaileigenschaften = new JButton("Detaileigenschaften");
		this.buttonDetaileigenschaften.addActionListener(this);
		this.buttonAuswertung = new JButton("Auswertung");
		this.buttonAuswertung.addActionListener(this);
		
		this.buttonVermutungNichts = new JButton(Vermutung.NICHTS.toString());
		this.buttonVermutungNichts.addActionListener(this);
		this.buttonVermutungDefinitivJa = new JButton(Vermutung.DEFINITIV_JA.toString());
		this.buttonVermutungDefinitivJa.addActionListener(this);
		this.buttonVermutungVermutlichJa = new JButton(Vermutung.VERMUTLICH_JA.toString());
		this.buttonVermutungVermutlichJa.addActionListener(this);
		this.buttonVermutungVermutlichNein = new JButton(Vermutung.VERMUTLICH_NEIN.toString());
		this.buttonVermutungVermutlichNein.addActionListener(this);
		this.buttonVermutungDefinitivNein = new JButton(Vermutung.DEFINITIV_NEIN.toString());
		this.buttonVermutungDefinitivNein.addActionListener(this);
		
		this.disableVermutungButtons();

		this.labelMenu = new JLabel(HTML_START + HTML_STRCOLOR("Hinweis-Menü", PRIMARY_COLOR) + ":" + HTML_END);
		this.labelTitel = new JLabel(LABEL_NOTHING_SELECTED);
		this.labelGeister = new JLabel(HTML_START + HTML_STRCOLOR("Geister", PRIMARY_COLOR) + ":" + HTML_END);
		this.labelAuswahl = new JLabel(HTML_START + HTML_STRCOLOR("Auswahl", PRIMARY_COLOR) + ":" + HTML_END);

		this.add(labelMenu, GridBagConstraintsUtility.build(0, 0, GBCPATTERN_SPECIAL_LABEL));
		this.add(buttonBeweise, GridBagConstraintsUtility.build(0, 1, GBCPATTERN_DEFAULT));
		this.add(buttonStaerken, GridBagConstraintsUtility.build(0, 2, GBCPATTERN_DEFAULT));
		this.add(buttonSchwaechen, GridBagConstraintsUtility.build(0, 3, GBCPATTERN_DEFAULT));
		this.add(buttonDetaileigenschaften, GridBagConstraintsUtility.build(0, 4, GBCPATTERN_DEFAULT));
		this.add(buttonAuswertung, GridBagConstraintsUtility.build(0, 5, GBCPATTERN_DEFAULT));
		this.add(labelAuswahl, GridBagConstraintsUtility.build(0, 6, GBCPATTERN_SPECIAL_LABEL));

		this.add(buttonVermutungDefinitivJa, GridBagConstraintsUtility.build(1, 6, GBCPATTERN_DEFAULT));
		this.add(buttonVermutungVermutlichJa, GridBagConstraintsUtility.build(2, 6, GBCPATTERN_DEFAULT));
		this.add(buttonVermutungVermutlichNein, GridBagConstraintsUtility.build(3, 6, GBCPATTERN_DEFAULT));
		this.add(buttonVermutungDefinitivNein, GridBagConstraintsUtility.build(4, 6, GBCPATTERN_DEFAULT));
		this.add(buttonVermutungNichts, GridBagConstraintsUtility.build(5, 6, GBCPATTERN_DEFAULT));

		this.add(labelTitel, GridBagConstraintsUtility.build(1, 0, GBCPATTERN_SPECIAL_LABEL));
		this.add(listEigenschaften, GridBagConstraintsUtility.build(1, 1, 5, 5, GridBagConstraints.VERTICAL, 1, 1, this.generalMargin, GridBagConstraints.WEST));
		
		if(Settings.EINSTELLUNG_GEISTERLISTE_LIVE) {
			this.add(labelGeister, GridBagConstraintsUtility.build(6, 0, GBCPATTERN_DEFAULT));
			this.add(listGeister, GridBagConstraintsUtility.build(6, 1, 1, 5, GridBagConstraints.VERTICAL, 0, 0, this.generalMargin));
		}
		
		this.updateGeisterList();

		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
	}

	//GUI-Controls
	private void disableVermutungButtons() {
		this.buttonVermutungNichts.setEnabled(false);
		this.buttonVermutungDefinitivJa.setEnabled(false);
		this.buttonVermutungVermutlichJa.setEnabled(false);
		this.buttonVermutungVermutlichNein.setEnabled(false);
		this.buttonVermutungDefinitivNein.setEnabled(false);
	}
	private void enableVermutungButtons(Vermutung vermutung) {
		switch(vermutung) {
			case NICHTS:
				this.buttonVermutungNichts.setEnabled(false);
				this.buttonVermutungDefinitivJa.setEnabled(true);
				this.buttonVermutungVermutlichJa.setEnabled(true);
				this.buttonVermutungVermutlichNein.setEnabled(true);
				this.buttonVermutungDefinitivNein.setEnabled(true);
				break;
			case DEFINITIV_JA:
				this.buttonVermutungNichts.setEnabled(true);
				this.buttonVermutungDefinitivJa.setEnabled(false);
				this.buttonVermutungVermutlichJa.setEnabled(true);
				this.buttonVermutungVermutlichNein.setEnabled(true);
				this.buttonVermutungDefinitivNein.setEnabled(true);
				break;
			case VERMUTLICH_JA:
				this.buttonVermutungNichts.setEnabled(true);
				this.buttonVermutungDefinitivJa.setEnabled(true);
				this.buttonVermutungVermutlichJa.setEnabled(false);
				this.buttonVermutungVermutlichNein.setEnabled(true);
				this.buttonVermutungDefinitivNein.setEnabled(true);
				break;
			case VERMUTLICH_NEIN:
				this.buttonVermutungNichts.setEnabled(true);
				this.buttonVermutungDefinitivJa.setEnabled(true);
				this.buttonVermutungVermutlichJa.setEnabled(true);
				this.buttonVermutungVermutlichNein.setEnabled(false);
				this.buttonVermutungDefinitivNein.setEnabled(true);
				break;
			case DEFINITIV_NEIN:
				this.buttonVermutungNichts.setEnabled(true);
				this.buttonVermutungDefinitivJa.setEnabled(true);
				this.buttonVermutungVermutlichJa.setEnabled(true);
				this.buttonVermutungVermutlichNein.setEnabled(true);
				this.buttonVermutungDefinitivNein.setEnabled(false);
				break;
			default: break;
		}
	}
	private void disableMainButtons(JButton buttonClick) {
		this.buttonBeweise.setEnabled(true);
		this.buttonStaerken.setEnabled(true);
		this.buttonSchwaechen.setEnabled(true);
		this.buttonDetaileigenschaften.setEnabled(true);
		buttonClick.setEnabled(false);
	}
	public void guiStateLabelUpdate(JButton button) {
		String basicButtonText = ((JButton) button).getText();
		this.labelTitel.setText(HTML_START + HTML_STRCOLOR(basicButtonText, ACCENT_COLOR) + ":" + HTML_END);
	}
	private String updateEigenschaftenList_Helper(Vermutung vermutung, String text) {
		String color = "#000000";
		switch(vermutung) {
			case NICHTS: color = SECONDARY_COLOR; break;
			case DEFINITIV_JA: color = POSITIVE_COLOR; break;
			case DEFINITIV_NEIN: color = NEGATIVE_COLOR; break;
			case VERMUTLICH_JA:
			case VERMUTLICH_NEIN: color = PRIMARY_COLOR; break;
			default: break;
		}
		return HTML_START + HTML_STRCOLOR("[", SECONDARY_COLOR) + HTML_STRCOLOR(vermutung.toString(), color) + HTML_STRCOLOR("]", SECONDARY_COLOR) + " " + text + HTML_END;
	}
	private void updateEigenschaftenList() {
		int index = this.listEigenschaften.getSelectedIndex();
		this.listEigenschaftenModel.clear();
		if(this.guiState == GUIState.BEWEISE) {
			for(Beweis beweis : Beweis.values()) {
				this.listEigenschaftenModel.addElement(updateEigenschaftenList_Helper(beweis.getVermutung(), beweis.toString()));
			}
		} else if(this.guiState == GUIState.DETAILS) {
			for(Detaileigenschaft detaileigenschaft : Detaileigenschaft.values()) {
				this.listEigenschaftenModel.addElement(updateEigenschaftenList_Helper(detaileigenschaft.getVermutung(), detaileigenschaft.toString()));
			}
		} else if(this.guiState == GUIState.SCHWAECHEN) {
			for(Schwaeche schwaeche : Schwaeche.values()) {
				this.listEigenschaftenModel.addElement(updateEigenschaftenList_Helper(schwaeche.getVermutung(), schwaeche.toString()));
			}
		} else if(this.guiState == GUIState.STAERKEN) {
			for(Staerke staerke : Staerke.values()) {
				this.listEigenschaftenModel.addElement(updateEigenschaftenList_Helper(staerke.getVermutung(), staerke.toString()));
			}
		} else {
			return;
		}
		this.listEigenschaften.setSelectedIndex(index);
	}
	//List-Utility
	private void setVermutung(Vermutung vermutung) {
		int selectedIndex = listEigenschaften.getSelectedIndex();
		if(selectedIndex != -1) {
			IVermutung v = getVermutungAt(selectedIndex);
			if(v != null) {
				v.setVermutung(vermutung);
			}
		}
		enableVermutungButtons(vermutung);
	}
	private IVermutung getVermutungAt(int index) {
		IVermutung[] o = null;
		switch(this.guiState) {
			case BEWEISE:
				o = Beweis.values();
				break;
			case STAERKEN:
				o = Staerke.values();
				break;
			case SCHWAECHEN:
				o = Schwaeche.values();
				break;
			case DETAILS:
				o = Detaileigenschaft.values();
				break;
			default: return null;
		}
		return o[index];
	}
	//Auswerten
	private void updateGeisterList() {
		this.listGeisterModel.clear();
		double maxPoints = new GeistEvaluator((Geist) new Ranking().get()[0]).get();
		for(Geist geist : Geist.values()) {
			double geistPoints = new GeistEvaluator(geist).get();
			
			//String color = (geistPoints == maxPoints ? POSITIVE_COLOR : ACCENT_COLOR);
			String color = ColorMixingUtility.mixColors(ACCENT_COLOR, NEGATIVE_COLOR, geistPoints / maxPoints);
			if(geistPoints == maxPoints)
				color = POSITIVE_COLOR;
			
			if(geistPoints == 0) color = SECONDARY_COLOR;
			this.listGeisterModel.addElement(HTML_START + HTML_STRCOLOR("[", SECONDARY_COLOR) + HTML_STRCOLOR("" + geistPoints + "", color) + HTML_STRCOLOR("]", SECONDARY_COLOR) + " " + geist.toString() + HTML_END);
		}
	}
	//Method-Overrides
	@Override
	public void valueChanged(ListSelectionEvent e) {
		int selectedIndex = ((JList<?>) e.getSource()).getSelectedIndex();
		if(selectedIndex != -1) {
			IVermutung o = getVermutungAt(selectedIndex);
			this.setVermutung(o.getVermutung());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == this.buttonBeweise) {
			this.guiStateLabelUpdate(this.buttonBeweise);
			this.guiState = GUIState.BEWEISE;
			this.disableVermutungButtons();
			this.disableMainButtons(this.buttonBeweise);
		} else if(o == this.buttonStaerken) {
			this.guiStateLabelUpdate(this.buttonStaerken);
			this.guiState = GUIState.STAERKEN;
			this.disableVermutungButtons();
			this.disableMainButtons(this.buttonStaerken);
		} else if(o == this.buttonSchwaechen) {
			this.guiStateLabelUpdate(this.buttonSchwaechen);
			this.guiState = GUIState.SCHWAECHEN;
			this.disableVermutungButtons();
			this.disableMainButtons(this.buttonSchwaechen);
		} else if(o == this.buttonDetaileigenschaften) {
			this.guiStateLabelUpdate(this.buttonDetaileigenschaften);
			this.guiState = GUIState.DETAILS;
			this.disableVermutungButtons();
			this.disableMainButtons(this.buttonDetaileigenschaften);
		} else if(o == this.buttonAuswertung) {
			new AuswertungFrame(WINDOW_TITLE);
		} else if(o == this.buttonVermutungNichts) {
			this.setVermutung(Vermutung.NICHTS);
		} else if(o == this.buttonVermutungDefinitivJa) {
			this.setVermutung(Vermutung.DEFINITIV_JA);
		} else if(o == this.buttonVermutungVermutlichJa) {
			this.setVermutung(Vermutung.VERMUTLICH_JA);
		} else if(o == this.buttonVermutungVermutlichNein) {
			this.setVermutung(Vermutung.VERMUTLICH_NEIN);
		} else if(o == this.buttonVermutungDefinitivNein) {
			this.setVermutung(Vermutung.DEFINITIV_NEIN);
		}
		this.updateEigenschaftenList();
		this.updateGeisterList();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		new SteckbriefFrame(Geist.values()[this.listGeister.getSelectedIndex()]);
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	public void reset() {
		this.buttonBeweise.setEnabled(true);
		this.buttonStaerken.setEnabled(true);
		this.buttonSchwaechen.setEnabled(true);
		this.buttonDetaileigenschaften.setEnabled(true);
		this.listEigenschaften.setSelectedIndex(-1);
		this.disableVermutungButtons();
		this.guiState = GUIState.NICHTS;
		this.updateEigenschaftenList();
		this.updateGeisterList();
		this.labelTitel.setText(LABEL_NOTHING_SELECTED);
	}
}