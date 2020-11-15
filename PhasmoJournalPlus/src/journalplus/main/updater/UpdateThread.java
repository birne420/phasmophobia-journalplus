package journalplus.main.updater;

import javax.swing.JOptionPane;

import journalplus.main.Logger;
import journalplus.main.settings.Settings;
import journalplus.utility.BasicUtility;

public class UpdateThread extends Thread {
	private UpdateListener listener;
	
	@Override
	public void run() {
		if(Settings.EINSTELLUNG_UPDATE_CHECK) {
			Logger.log("main.updater", "initialize update listener");
			this.listener = new UpdateListener();
			
			if(this.listener.setupCorrect()) {
				if(this.listener.isUpdateAvailable()) {
					int result = JOptionPane.showConfirmDialog(null, "Eine neue Version ist verfügbar: " + this.listener.getVersion() + "\nHerunterladen?", "Update verfügbar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.YES_OPTION) {
						Logger.log("main.updater", "open url: " + this.listener.getVersionLink());
						BasicUtility.openUrl(this.listener.getVersionLink());
					}
				} else {
					return;
				}
			} else {
				Logger.log("main.updater", "update search failed");
				JOptionPane.showMessageDialog(null, "Beim Suchen nach einer aktuelleren Version trat ein Fehler auf.", "Fehler", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			Logger.log("main.updater", "stopped search: auto updater disabled in options");
		}
	}
}
