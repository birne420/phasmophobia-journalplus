package journalplus.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Logger {
	private static PrintStream pStream;
	
	public static void setLoggingEnabled(boolean b) {
		if(b) {
			try {
				pStream = new PrintStream(new File("JournalPlus.log"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Debug-Logging gescheitert: " + e.getMessage(), "Error", 0);
			}
			System.setOut(pStream);
			log("LOGGING", "Set to file.");
		} else {
			System.setOut(System.out);
			log("LOGGING", "Set to console.");
		}
	}
	
	public static void log(String type, String msg) {
		System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "/" + type.toUpperCase() + "]: " + msg);
	}
}