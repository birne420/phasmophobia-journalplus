package journalplus.utility;

import journalplus.main.settings.SettingsIO;

public class ComboBoxThemesUtility {
	public static String[] getAllThemeNames() {
		String[] hardCodedThemeIds = new String[] { SettingsIO.getTheme().getThemeId(), "default", "dark" };
		return hardCodedThemeIds;
	}
}
