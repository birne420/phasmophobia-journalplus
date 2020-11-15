package journalplus.utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import journalplus.gui.main.MainFrame;
import journalplus.main.Logger;

public class BasicUtility {
	public static double runden(final double wert, final int n) {
        return Math.round(Math.pow(10.0, n) * wert) / Math.pow(10.0, n);
    }
	public static double strToDouble(String string) {
		try {
			return Double.parseDouble(string);
		} catch(Exception ex) {
			Logger.log("error", ex.getMessage());
			ex.printStackTrace();
			return 1.0d;
		}
	}
	public static boolean restartProcess() {
		Logger.log("utility.restart_process", "restarting process...");
		String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		File currentJar;
		try {
			currentJar = new File(MainFrame.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			if(!currentJar.getName().endsWith(".jar")) {
				return false;
			}
			ArrayList<String> command = new ArrayList<String>();
			command.add(javaBin);
			command.add("-jar");
			command.add(currentJar.getPath());
			ProcessBuilder builder = new ProcessBuilder(command);
			try {
				Logger.log("utility.restart_process", "executing " + javaBin + " -jar " + currentJar.getPath());
				builder.start();
				Logger.log("utility.restart_process", "terminating...");
				System.exit(0);
				return true;
			} catch (IOException e) {
				Logger.log("error", e.getMessage());
				e.printStackTrace();
				return false;
			}
		} catch (URISyntaxException e) {
			Logger.log("error", e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean openUrl(String url) {
		if(Desktop.isDesktopSupported() ) {
			Desktop desktop = Desktop.getDesktop();
			if(desktop.isSupported(Desktop.Action.BROWSE) ) {
				java.net.URI uri;
				try {
					uri = new URI(url);
					desktop.browse(uri);
					return true;
				} catch (URISyntaxException e) {
					Logger.log("error", e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					Logger.log("error", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
