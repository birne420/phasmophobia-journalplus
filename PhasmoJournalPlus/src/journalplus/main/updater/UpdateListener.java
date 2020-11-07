package journalplus.main.updater;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import journalplus.main.settings.Settings;

public class UpdateListener {
	private String onlineVersion = null;
	private String onlineVersionLink = null;
	private boolean isUpdateAvailable = false;
	private boolean isInitialized = false;
	
	public UpdateListener() {
		try {
			URL updateURL = new URL(Settings.EINSTELLUNG_UPDATE_URL);
			try {
				Scanner scn = new Scanner(updateURL.openStream(), "UTF-8").useDelimiter("\\A");
				String jsonContent = scn.next();
				scn.close();
				JSONObject obj = new JSONObject(jsonContent);
				this.onlineVersion = obj.getString("current_version");
				this.onlineVersionLink = obj.getString("update_url");
				//System.out.println("Online-Version: " + this.onlineVersion);
				//System.out.println("Offline-Version: " + Settings.EINSTELLUNG_VERSION_STRING);
				if(!this.onlineVersion.equals(Settings.EINSTELLUNG_VERSION_STRING)) {
					this.isUpdateAvailable = true;
				}
				this.isInitialized = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean setupCorrect() {
		return this.isInitialized;
	}
	public boolean isUpdateAvailable() {
		return this.isUpdateAvailable;
	}
	public String getVersion() {
		return this.onlineVersion;
	}
	public String getVersionLink() {
		return this.onlineVersionLink;
	}
}
