package journalplus.gui;

import java.awt.Color;
import java.awt.Component;

import journalplus.main.settings.Settings;

public interface IThemeInfluenced {
	public static final Color AWT_COLOR_BACKGROUND = Settings.EINSTELLUNG_THEME_AWTBG;
	public static final Color AWT_COLOR_FOREGROUND = Settings.EINSTELLUNG_THEME_AWTFG;
	
	public static void applyThemeToMultipleComponents(Component[] components) {
		for(Component component : components) {
			applyThemeToComponent(component);
		}
	}
	public static void applyThemeToComponent(Component component) {
		applyColorsToComponent(component, AWT_COLOR_BACKGROUND, AWT_COLOR_FOREGROUND);
	}
	static void applyColorsToComponent(Component component, Color backColor, Color foreColor) {
		component.setBackground(backColor);
		component.setForeground(foreColor);
	}
}
