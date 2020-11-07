package journalplus.utility;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import journalplus.gui.main.MainFrame;

public class BasicUtility {
	public static double runden(final double wert, final int n) {
        return Math.round(Math.pow(10.0, n) * wert) / Math.pow(10.0, n);
    }
	public static double strToDouble(String string) {
		try {
			return Double.parseDouble(string);
		} catch(NumberFormatException numFormatExc) {
			return 1.0d;
		}
	}
	public static boolean restartProcess() {
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
				builder.start();
				System.exit(0);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public static boolean execute(String path) {
		ArrayList<String> command = new ArrayList<String>();
		command.add(path);
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
