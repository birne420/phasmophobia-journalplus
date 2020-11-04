package journalplus.gui.ingamejournal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import journalplus.gui.BasicPanel;
import journalplus.gui.IThemeInfluenced;

public class IngameJournalPanel extends BasicPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel panelImage;
	private JPanel panelControls;

	private JLabel pageLeft;
	private JButton buttonLeftHard;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton buttonRightHard;
	private JLabel pageRight;
	
	private int page;
	
	public IngameJournalPanel() {
		this.setLayout(new BorderLayout());
		
		this.page = 1;
		
		this.pageLeft = new JLabel("Seite");
		this.pageRight = new JLabel("Seite");

		this.buttonLeftHard = new JButton("<----");
		this.buttonLeftHard.addActionListener(this);
		this.buttonLeft = new JButton("<--");
		this.buttonLeft.addActionListener(this);
		this.buttonRight = new JButton("-->");
		this.buttonRight.addActionListener(this);
		this.buttonRightHard = new JButton("---->");
		this.buttonRightHard.addActionListener(this);
		
		this.panelImage = new ImagePanel();
		
		this.panelControls = new JPanel();
		this.panelControls.add(pageLeft);
		this.panelControls.add(buttonLeftHard);
		this.panelControls.add(buttonLeft);
		this.panelControls.add(buttonRight);
		this.panelControls.add(buttonRightHard);
		this.panelControls.add(pageRight);

		this.add(panelImage);
		this.add(panelControls, BorderLayout.PAGE_END);
		
		this.checkComponents();
		
		//Theme
		IThemeInfluenced.applyThemeToComponent(this);
		IThemeInfluenced.applyThemeToMultipleComponents(this.getComponents());
		IThemeInfluenced.applyThemeToMultipleComponents(this.panelControls.getComponents());
	}
	
	private void checkComponents() {
		if(this.page == 1) {
			this.buttonLeft.setEnabled(false);
			this.buttonLeftHard.setEnabled(false);
			this.buttonRight.setEnabled(true);
			this.buttonRightHard.setEnabled(true);
		} else if(page == 12) {
			this.buttonLeft.setEnabled(true);
			this.buttonLeftHard.setEnabled(true);
			this.buttonRight.setEnabled(false);
			this.buttonRightHard.setEnabled(false);
		} else {
			this.buttonLeft.setEnabled(true);
			this.buttonLeftHard.setEnabled(true);
			this.buttonRight.setEnabled(true);
			this.buttonRightHard.setEnabled(true);
		}
		
		int pageRight = this.page * 2;
		int pageLeft = pageRight - 1;
		String blank = "          ";
		this.pageLeft.setText("Seite " + pageLeft + blank);
		this.pageRight.setText(blank + "Seite " + pageRight);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.buttonLeftHard) {
			this.page = 1;
			((ImagePanel) this.panelImage).displayPage(this.page);
			this.checkComponents();
		} else if(e.getSource() == this.buttonLeft) {
			this.page--;
			((ImagePanel) this.panelImage).displayPage(this.page);
			this.checkComponents();
		} else if(e.getSource() == this.buttonRight) {
			this.page++;
			((ImagePanel) this.panelImage).displayPage(this.page);
			this.checkComponents();
		} else if(e.getSource() == this.buttonRightHard) {
			this.page = 12;
			((ImagePanel) this.panelImage).displayPage(this.page);
			this.checkComponents();
		}
	}
}
