package journalplus.gui.einstellungen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;
import journalplus.main.settings.Settings;
import journalplus.main.settings.SettingsIO;
import journalplus.utility.BasicUtility;
import journalplus.utility.ComboBoxThemesUtility;
import journalplus.utility.GridBagConstraintsUtility;

public class EinstellungenPanel extends BasicPanel implements ChangeListener, ActionListener {
	private static final long serialVersionUID = 1L;

	private JSlider sliderWindowScale;
	private JLabel labelWindowScale;

	private JComboBox<String> comboboxTheme;
	private JLabel labelTheme;
	
	private JCheckBox checkboxLiveList;
	private JLabel labelLiveList;
	
	private JCheckBox checkboxUpdateCheck;
	private JLabel labelUpdateCheck;
	
	private JTextField textboxAuswertungDefJa;
	private JLabel labelAuswertungDefJa;
	private JTextField textboxAuswertungVerJa;
	private JLabel labelAuswertungVerJa;
	private JTextField textboxAuswertungVerNein;
	private JLabel labelAuswertungVerNein;
	private JTextField textboxAuswertungDefNein;
	private JLabel labelAuswertungDefNein;

	private JTextField textboxAuswertungDefJa2;
	private JLabel labelAuswertungDefJa2;
	private JTextField textboxAuswertungDefNein2;
	private JLabel labelAuswertungDefNein2;
	
	private JButton buttonReset;
	private JButton buttonApply;
	
	public EinstellungenPanel(JFrame frame) {
		this.setLayout(new GridBagLayout());
		
		this.sliderWindowScale = new JSlider(50, 120, SettingsIO.getWindowSizeScale());
		this.sliderWindowScale.addChangeListener(this);
		this.labelWindowScale = new JLabel();
		
		this.comboboxTheme = new JComboBox<String>(ComboBoxThemesUtility.getAllThemeNames());
		this.labelTheme = new JLabel();
		
		this.checkboxLiveList = new JCheckBox("Live Auswertung");
		if(SettingsIO.getLiveList()) {
			this.checkboxLiveList.setSelected(true);
		}
		this.checkboxLiveList.addChangeListener(this);
		this.labelLiveList = new JLabel();
		
		this.checkboxUpdateCheck = new JCheckBox("Auf Updates prüfen");
		if(SettingsIO.getUpdateCheck()) {
			this.checkboxUpdateCheck.setSelected(true);
		}
		this.checkboxUpdateCheck.addChangeListener(this);
		this.labelUpdateCheck = new JLabel();

		this.textboxAuswertungDefJa = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA));
		this.labelAuswertungDefJa = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA), ACCENT_COLOR) + HTML_END);
		
		this.textboxAuswertungVerJa = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERJA));
		this.labelAuswertungVerJa = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERJA), ACCENT_COLOR) + HTML_END);
		
		this.textboxAuswertungVerNein = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERNEIN));
		this.labelAuswertungVerNein = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_VERNEIN), ACCENT_COLOR) + HTML_END);
		
		this.textboxAuswertungDefNein = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN));
		this.labelAuswertungDefNein = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN), ACCENT_COLOR) + HTML_END);
		
		this.textboxAuswertungDefJa2 = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA2));
		this.labelAuswertungDefJa2 = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFJA2), ACCENT_COLOR) + HTML_END);
		
		this.textboxAuswertungDefNein2 = new JTextField(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN2));
		this.labelAuswertungDefNein2 = new JLabel(HTML_START + HTML_STRCOLOR(Double.toString(Settings.EINSTELLUNG_AUSWERTUNG_FAKTOR_DEFNEIN2), ACCENT_COLOR) + HTML_END);

		this.buttonReset = new JButton("Zurücksetzen");
		this.buttonReset.addActionListener(this);
		this.buttonApply = new JButton("Übernehmen");
		this.buttonApply.addActionListener(this);
		
		int yCoord = 0;
		//Window Scale
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Hauptfenster-Skalierung", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelWindowScale, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.sliderWindowScale, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));

		yCoord = 1;
		//Theme
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Theme", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelTheme, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.comboboxTheme, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));

		yCoord = 2;
		//LiveGeisterList OnOff
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Geister-LiveAuswertung", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelLiveList, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.checkboxLiveList, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		
		yCoord = 3;
		//UpdateCheck OnOff
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Update-Check", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelUpdateCheck, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.checkboxUpdateCheck, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));

		//6 Faktor-Felder
		yCoord = 4;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Definitiv Ja'", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungDefJa, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungDefJa, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		yCoord = 5;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Vermutlich Ja'", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungVerJa, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungVerJa, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		yCoord = 6;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Vermutlich Nein'", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungVerNein, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungVerNein, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		yCoord = 7;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Definitiv Nein'", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungDefNein, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungDefNein, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		yCoord = 8;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Definitiv Ja' (Beweise)", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungDefJa2, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungDefJa2, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		yCoord = 9;
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Auswertungsfaktor 'Definitiv Nein' (nicht Beweise)", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED));
		this.add(this.labelAuswertungDefNein2, GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED));
		this.add(this.textboxAuswertungDefNein2, GridBagConstraintsUtility.build(2, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		
		yCoord = 10;
		//Version
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Version", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, yCoord, GBCPATTERN_SIDED_DETERMINANT));
		this.add(new JLabel(HTML_START + HTML_STRCOLOR(Settings.EINSTELLUNG_VERSION_STRING, SECONDARY_COLOR) + HTML_END), GridBagConstraintsUtility.build(1, yCoord, GBCPATTERN_SIDED_DETERMINANT));

		yCoord = 11;
		this.add(this.buttonApply, GridBagConstraintsUtility.build(0, yCoord, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_DEFAULT, GridBagConstraints.CENTER));
		this.add(this.buttonReset, GridBagConstraintsUtility.build(2, yCoord, 1, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_DEFAULT, GridBagConstraints.CENTER));
		
		updateTexts();
		
		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == this.sliderWindowScale || e.getSource() == this.comboboxTheme || e.getSource() == this.checkboxLiveList || e.getSource() == this.checkboxUpdateCheck) {
			updateTexts();
		}
	}
	private void updateTexts() {
		this.labelWindowScale.setText(HTML_START + HTML_STRCOLOR(SettingsIO.getWindowSizeScale() + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + this.sliderWindowScale.getValue() + ")", SECONDARY_COLOR) + HTML_END);
		this.labelTheme.setText(HTML_START + HTML_STRCOLOR(SettingsIO.getTheme().getThemeId(), ACCENT_COLOR) + HTML_END);
		this.labelLiveList.setText(HTML_START + HTML_STRCOLOR((SettingsIO.getLiveList() ? "An" : "Aus") + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + (this.checkboxLiveList.isSelected() ? "An" : "Aus") + ")", SECONDARY_COLOR) + HTML_END);
		this.labelUpdateCheck.setText(HTML_START + HTML_STRCOLOR((SettingsIO.getUpdateCheck() ? "An" : "Aus") + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + (this.checkboxUpdateCheck.isSelected() ? "An" : "Aus") + ")", SECONDARY_COLOR) + HTML_END);
	}
	private void saveData() {
		SettingsIO.setWindowSizeScale(this.sliderWindowScale.getValue());
		SettingsIO.setTheme(this.comboboxTheme.getSelectedItem().toString());
		SettingsIO.setLiveList(this.checkboxLiveList.isSelected());
		SettingsIO.setUpdateCheck(this.checkboxUpdateCheck.isSelected());
		SettingsIO.setAuswertungFaktorDefJa(this.textboxAuswertungDefJa.getText());
		SettingsIO.setAuswertungFaktorVerJa(this.textboxAuswertungVerJa.getText());
		SettingsIO.setAuswertungFaktorVerNein(this.textboxAuswertungVerNein.getText());
		SettingsIO.setAuswertungFaktorDefNein(this.textboxAuswertungDefNein.getText());
		SettingsIO.setAuswertungFaktorDefJa2(this.textboxAuswertungDefJa2.getText());
		SettingsIO.setAuswertungFaktorDefNein2(this.textboxAuswertungDefNein2.getText());
		SettingsIO.saveSets();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.buttonApply) {
			this.saveData();
			if(!BasicUtility.restartProcess()) {
				JOptionPane.showMessageDialog(null, "Konnte JAR-Datei nicht neustarten.", "Fehler", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == this.buttonReset) {
			SettingsIO.deleteConfig();
			if(!BasicUtility.restartProcess()) {
				JOptionPane.showMessageDialog(null, "Konnte JAR-Datei nicht neustarten.", "Fehler", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
