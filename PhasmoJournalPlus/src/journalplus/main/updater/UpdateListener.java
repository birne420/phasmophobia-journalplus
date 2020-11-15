package journalplus.main.updater;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import journalplus.main.Logger;
import journalplus.main.settings.Settings;

public class UpdateListener {
	private String onlineVersion = null;
	private String onlineVersionLink = null;
	private boolean isUpdateAvailable = false;
	private boolean isInitialized = false;
	
	public UpdateListener() {
		try {
			URL updateURL = new URL(Settings.EINSTELLUNG_UPDATE_URL);
			Logger.log("main.updater", "looking for update meta: " + Settings.EINSTELLUNG_UPDATE_URL);
			try {
				Logger.log("main.updater.search", "retrieving data...");
				Scanner scn = new Scanner(updateURL.openStream(), "UTF-8").useDelimiter("\\A");
				Logger.log("main.updater.search", "parsing json...");
				String jsonContent = scn.next();
				scn.close();
				JSONObject obj = new JSONObject(jsonContent);
				this.onlineVersion = obj.getString("current_version");
				Logger.log("main.updater.search", "online version: " + this.onlineVersion);
				this.onlineVersionLink = obj.getString("update_url");
				Logger.log("main.updater.search", "current version link: " + this.onlineVersionLink);
				if(!this.onlineVersion.equals(Settings.EINSTELLUNG_VERSION_STRING)) {
					Logger.log("main.updater.search", "update available");
					this.isUpdateAvailable = true;
				} else {
					Logger.log("main.updater.search", "no update available");
				}
				this.isInitialized = true;
				Logger.log("main.updater.search", "update search done");
			} catch (IOException e) {
				Logger.log("error", e.getMessage());
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			Logger.log("error", e.getMessage());
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
