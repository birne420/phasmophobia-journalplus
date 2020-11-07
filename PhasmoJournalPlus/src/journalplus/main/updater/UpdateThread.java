package journalplus.main.updater;

import javax.swing.JOptionPane;

import journalplus.utility.BasicUtility;

public class UpdateThread extends Thread {
	private UpdateListener listener;
	
	@Override
	public void run() {
		this.listener = new UpdateListener();
		
		if(this.listener.setupCorrect()) {
			if(this.listener.isUpdateAvailable()) {
				int result = JOptionPane.showConfirmDialog(null, "Eine neue Version ist verfügbar: " + this.listener.getVersion() + "\nHerunterladen?", "Update verfügbar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					BasicUtility.openUrl(this.listener.getVersionLink());
				}
			} else {
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Beim Suchen nach einer aktuelleren Version trat ein Fehler auf.", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
