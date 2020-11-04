package journalplus.gui.einstellungen;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;
import journalplus.main.settings.SettingsIO;
import journalplus.utility.gridbagconstraints.GridBagConstraintsUtility;

public class EinstellungenPanel extends BasicPanel implements ChangeListener, ActionListener {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	
	private JSlider sliderWindowScale;
	private JLabel labelWindowScale;

	private JCheckBox checkboxDarkTheme;
	private JLabel labelTheme;
	
	private JCheckBox checkboxLiveList;
	private JLabel labelLiveList;

	private JButton buttonReset;
	private JButton buttonApply;
	
	public EinstellungenPanel(JFrame frame) {
		this.frame = frame;
		this.setLayout(new GridBagLayout());
		
		this.sliderWindowScale = new JSlider(50, 120, SettingsIO.getWindowSizeScale());
		this.sliderWindowScale.addChangeListener(this);
		this.labelWindowScale = new JLabel();
		
		this.checkboxDarkTheme = new JCheckBox("Dark Theme");
		if(SettingsIO.getTheme().getThemeId().equals("dark")) {
			this.checkboxDarkTheme.setSelected(true);
		}
		this.checkboxDarkTheme.addChangeListener(this);
		this.labelTheme = new JLabel();
		
		this.checkboxLiveList = new JCheckBox("Live Auswertung");
		if(SettingsIO.getLiveList()) {
			this.checkboxLiveList.setSelected(true);
		}
		this.checkboxLiveList.addChangeListener(this);
		this.labelLiveList = new JLabel();

		this.buttonReset = new JButton("Zurücksetzen (wird beendet)");
		this.buttonReset.addActionListener(this);
		this.buttonApply = new JButton("Übernehmen (Neustart nötig)");
		this.buttonApply.addActionListener(this);

		//Window Scale
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Hauptfenster-Skalierung", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 0, GBCPATTERN_SIDED));
		this.add(this.labelWindowScale, GridBagConstraintsUtility.build(1, 0, GBCPATTERN_SIDED_DETERMINANT));
		this.add(this.sliderWindowScale, GridBagConstraintsUtility.build(2, 0, GBCPATTERN_SIDED));

		//Theme
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("DarkTheme verwenden", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 1, GBCPATTERN_SIDED));
		this.add(this.labelTheme, GridBagConstraintsUtility.build(1, 1, GBCPATTERN_SIDED_DETERMINANT));
		this.add(this.checkboxDarkTheme, GridBagConstraintsUtility.build(2, 1, GBCPATTERN_SIDED));
		
		//LiveGeisterList OnOff
		this.add(new JLabel(HTML_START + HTML_STRCOLOR("Geister-LiveAuswertung", PRIMARY_COLOR) + ":" + HTML_END), GridBagConstraintsUtility.build(0, 2, GBCPATTERN_SIDED));
		this.add(this.labelLiveList, GridBagConstraintsUtility.build(1, 2, GBCPATTERN_SIDED_DETERMINANT));
		this.add(this.checkboxLiveList, GridBagConstraintsUtility.build(2, 2, GBCPATTERN_SIDED));
		
		this.add(this.buttonApply, GridBagConstraintsUtility.build(0, 3, 2, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_DEFAULT, GridBagConstraints.CENTER));
		this.add(this.buttonReset, GridBagConstraintsUtility.build(2, 3, 1, 1, GridBagConstraints.HORIZONTAL, 0, 0, MARGIN_DEFAULT, GridBagConstraints.CENTER));
		
		updateTexts();
		
		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource() == this.sliderWindowScale || e.getSource() == this.checkboxDarkTheme || e.getSource() == this.checkboxLiveList) {
			updateTexts();
		}
	}
	private void updateTexts() {
		this.labelWindowScale.setText(HTML_START + HTML_STRCOLOR(this.sliderWindowScale.getValue() + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + SettingsIO.getWindowSizeScale() + ")", SECONDARY_COLOR) + HTML_END);
		this.labelTheme.setText(HTML_START + HTML_STRCOLOR(this.checkboxDarkTheme.isSelected() + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + (SettingsIO.getTheme().getThemeId().equals("dark") ? true : false) + ")", SECONDARY_COLOR) + HTML_END);
		this.labelLiveList.setText(HTML_START + HTML_STRCOLOR(this.checkboxLiveList.isSelected() + " ", ACCENT_COLOR) + HTML_STRCOLOR("(" + SettingsIO.getLiveList() + ")", SECONDARY_COLOR) + HTML_END);
	}
	private void saveData() {
		SettingsIO.setWindowSizeScale(this.sliderWindowScale.getValue());
		if(this.checkboxDarkTheme.isSelected()) {
			SettingsIO.setTheme("dark");
		} else {
			SettingsIO.setTheme("default");
		}
		SettingsIO.setLiveList(this.checkboxLiveList.isSelected());
		SettingsIO.saveSets();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.buttonApply) {
			saveData();
			frame.dispose();
		}
		if(e.getSource() == this.buttonReset) {
			SettingsIO.deleteConfig();
			System.exit(0);
		}
	}
}
