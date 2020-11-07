package journalplus.main.updater;

public class UpdateThread extends Thread {
	private UpdateListener listener;
	
	@Override
	public void run() {
		this.listener = new UpdateListener();
		System.out.println("Update-Check erfolgreich: " + this.listener.setupCorrect());
		System.out.println("Neue Version verfügbar: " + this.listener.isUpdateAvailable());
		if(this.listener.isUpdateAvailable()) {
			System.out.println("Neue Version: " + this.listener.getVersion());
			System.out.println("Version Link: " + this.listener.getVersionLink());
		}
	}
}
