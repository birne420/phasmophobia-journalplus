package journalplus.main.settings;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import journalplus.gui.themes.ActualTheme;
import journalplus.gui.themes.ThemeLoader;
import journalplus.utility.BasicUtility;

public class SettingsIO {
	public static final String CONFIG_FILE = System.getProperty("java.io.tmpdir") + "journal_plus_config.json";

	private static final String CONFIG_JSON_BASE = "journal_plus_config";
	private static final String CONFIG_JSON_WINDOWSIZESCALE = "window_scaling";
	private static final String CONFIG_JSON_THEME = "active_theme";
	private static final String CONFIG_JSON_LIVELIST = "livelist_enabled";
	private static final String CONFIG_JSON_UPDATE_CHECK = "update_check";
	private static final String CONFIG_JSON_AUSWERTUNG_DEFJA = "evaluation_def_yes";
	private static final String CONFIG_JSON_AUSWERTUNG_VERJA = "evaluation_prob_yes";
	private static final String CONFIG_JSON_AUSWERTUNG_VERNEIN = "evaluation_prob_no";
	private static final String CONFIG_JSON_AUSWERTUNG_DEFNEIN = "evaluation_def_no";
	private static final String CONFIG_JSON_AUSWERTUNG_DEFJA2 = "evaluation_def_yes_2";
	private static final String CONFIG_JSON_AUSWERTUNG_DEFNEIN2 = "evaluation_def_no_2";

	private static String settingWindowSizeScale = "64";
	private static String settingTheme = "default";
	private static String settingLiveList = "true";
	private static String settingUpdateCheck = "true";
	private static String configVersion = null;
	
	private static String settingAuswertungFaktorDefJa = "2.0";
	private static String settingAuswertungFaktorVerJa = "1.2";
	private static String settingAuswertungFaktorVerNein = "0.8";
	private static String settingAuswertungFaktorDefNein = "0.0";
	
	private static String settingAuswertungFaktorDefJa2 = "4.0";
	private static String settingAuswertungFaktorDefNein2 = "0.64";
	
	public static void setWindowSizeScale(int scale) {
		settingWindowSizeScale = "" + scale;
	}
	public static int getWindowSizeScale() {
		init();
		return Integer.parseInt(settingWindowSizeScale);
	}
	public static void setTheme(String themeId) {
		settingTheme = themeId;
	}
	public static ActualTheme getTheme() {
		init();
		String themeId = settingTheme.toLowerCase();
		
		ThemeLoader loader = new ThemeLoader();
		if(!loader.loadTheme(themeId)) {
			loader.loadTheme("default");
		}
		ActualTheme theme = loader.get();
		return theme;
	}
	public static void setLiveList(boolean bool) {
		settingLiveList = "" + bool;
	}
	public static boolean getLiveList() {
		init();
		if(settingLiveList.toLowerCase().equals("true")) {
			return true;
		}
		return false;
	}
	public static void setUpdateCheck(boolean bool) {
		settingUpdateCheck = "" + bool;
	}
	public static boolean getUpdateCheck() {
		init();
		if(settingUpdateCheck.toLowerCase().equals("true")) {
			return true;
		}
		return false;
	}
	public static void setAuswertungFaktorDefJa(String faktor) {
		settingAuswertungFaktorDefJa = faktor;
	}
	public static double getAuswertungFaktorDefJa() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefJa);
	}
	public static void setAuswertungFaktorVerJa(String faktor) {
		settingAuswertungFaktorVerJa = faktor;
	}
	public static double getAuswertungFaktorVerJa() {
		return BasicUtility.strToDouble(settingAuswertungFaktorVerJa);
	}
	public static void setAuswertungFaktorVerNein(String faktor) {
		settingAuswertungFaktorVerNein = faktor;
	}
	public static double getAuswertungFaktorVerNein() {
		return BasicUtility.strToDouble(settingAuswertungFaktorVerNein);
	}
	public static void setAuswertungFaktorDefNein(String faktor) {
		settingAuswertungFaktorDefNein = faktor;
	}
	public static double getAuswertungFaktorDefNein() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefNein);
	}
	public static void setAuswertungFaktorDefJa2(String faktor) {
		settingAuswertungFaktorDefJa2 = faktor;
	}
	public static double getAuswertungFaktorDefJa2() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefJa2);
	}
	public static void setAuswertungFaktorDefNein2(String faktor) {
		settingAuswertungFaktorDefNein2 = faktor;
	}
	public static double getAuswertungFaktorDefNein2() {
		return BasicUtility.strToDouble(settingAuswertungFaktorDefNein2);
	}
	
	public static void saveSets() {
		saveConfig();
	}
	public static boolean init() {
		File file = new File(CONFIG_FILE);
		if(!(file.exists() && !file.isDirectory())) {
			saveConfig();
		}

		return loadConfig();
	}
	
	public static boolean configVersionCheck() {
		return configVersion.equalsIgnoreCase(Settings.EINSTELLUNG_VERSION_STRING);
	}

	private static boolean loadConfig() {
		try {
			String jsonString = Files.readString(Paths.get(CONFIG_FILE));
			
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONObject configBase = jsonObject.getJSONObject(CONFIG_JSON_BASE);
			configVersion = configBase.getString("config_version");
			
			try {
				settingWindowSizeScale = configBase.getString(CONFIG_JSON_WINDOWSIZESCALE);
				settingTheme = configBase.getString(CONFIG_JSON_THEME);
				settingLiveList = configBase.getString(CONFIG_JSON_LIVELIST);
				settingUpdateCheck = configBase.getString(CONFIG_JSON_UPDATE_CHECK);
				settingAuswertungFaktorDefJa = configBase.getString(CONFIG_JSON_AUSWERTUNG_DEFJA);
				settingAuswertungFaktorVerJa = configBase.getString(CONFIG_JSON_AUSWERTUNG_VERJA);
				settingAuswertungFaktorVerNein = configBase.getString(CONFIG_JSON_AUSWERTUNG_VERNEIN);
				settingAuswertungFaktorDefNein = configBase.getString(CONFIG_JSON_AUSWERTUNG_DEFNEIN);
				settingAuswertungFaktorDefJa2 = configBase.getString(CONFIG_JSON_AUSWERTUNG_DEFJA2);
				settingAuswertungFaktorDefNein2 = configBase.getString(CONFIG_JSON_AUSWERTUNG_DEFNEIN2);
				return true;
			} catch(JSONException ex) {
				if(configVersionCheck()) {
					JOptionPane.showMessageDialog(null, "Einstellungen wurden zurückgesetzt, da die Konfigurationsdatei beschädigt war.", "Einstellungen", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Einstellungen wurden zurückgesetzt, da sich das Konfigurationsformat in der neuen Version geändert hat.", "Einstellungen", JOptionPane.INFORMATION_MESSAGE);
				}
				deleteConfig();
				init();
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	private static boolean saveConfig() {
		JSONObject configObject = new JSONObject();
		
		JSONObject configBase = new JSONObject();

		configBase.put("config_version", Settings.EINSTELLUNG_VERSION_STRING);
		configBase.put(CONFIG_JSON_WINDOWSIZESCALE, settingWindowSizeScale);
		configBase.put(CONFIG_JSON_THEME, settingTheme);
		configBase.put(CONFIG_JSON_LIVELIST, settingLiveList);
		configBase.put(CONFIG_JSON_UPDATE_CHECK, settingUpdateCheck);
		configBase.put(CONFIG_JSON_AUSWERTUNG_DEFJA, settingAuswertungFaktorDefJa);
		configBase.put(CONFIG_JSON_AUSWERTUNG_VERJA, settingAuswertungFaktorVerJa);
		configBase.put(CONFIG_JSON_AUSWERTUNG_VERNEIN, settingAuswertungFaktorVerNein);
		configBase.put(CONFIG_JSON_AUSWERTUNG_DEFNEIN, settingAuswertungFaktorDefNein);
		configBase.put(CONFIG_JSON_AUSWERTUNG_DEFJA2, settingAuswertungFaktorDefJa2);
		configBase.put(CONFIG_JSON_AUSWERTUNG_DEFNEIN2, settingAuswertungFaktorDefNein2);
		
		configObject.put(CONFIG_JSON_BASE, configBase);
		
		try {
			Files.writeString(Paths.get(CONFIG_FILE), configObject.toString(), StandardCharsets.UTF_8);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void deleteConfig() {
		new File(CONFIG_FILE).delete();
	}
}
