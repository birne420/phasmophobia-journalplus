package journalplus.gui.themes;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import journalplus.main.Logger;
import journalplus.utility.AwtColorString;

public class ThemeLoader {
	private ActualTheme theme;
	
	public boolean loadTheme(String jsonFile) {
		String requestedFile = "/journalplus/assets/themes/" + jsonFile + ".json";
		Logger.log("themeloader", "loading theme " + requestedFile);
		
		URL url = this.getClass().getResource(requestedFile);
		
		try {
			Logger.log("themeloader", "reading file");
			@SuppressWarnings("resource")
			Scanner scn = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A");
			String jsonContent = scn.next();
			scn.close();
			Logger.log("themeloader", "parsing json object");
			JSONObject obj = new JSONObject(jsonContent);

			this.theme = new ActualTheme(
					obj.getJSONObject("theme").getString("name"),
					obj.getJSONObject("theme").getString("id"),
					obj.getJSONObject("colors").getString("positive"),
					obj.getJSONObject("colors").getString("negative"),
					obj.getJSONObject("colors").getString("neutral"),
					obj.getJSONObject("colors").getString("decent"),
					obj.getJSONObject("colors").getString("signal"),
					AwtColorString.fromString(obj.getJSONObject("awt_colors").getString("background")),
					AwtColorString.fromString(obj.getJSONObject("awt_colors").getString("foreground")));
			Logger.log("themeloader", "theme loaded successfully");
			return true;
		} catch (IOException e) {
			Logger.log("error", e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ActualTheme get() {
		return this.theme;
	}
}
