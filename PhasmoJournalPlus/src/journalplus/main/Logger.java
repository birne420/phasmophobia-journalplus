package journalplus.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Logger {
	private static File log_file;
	private static PrintStream pStream;
	
	public static void setFileLoggingEnabled(boolean b) {
		if(b) {
			try {
				log_file = new File("JournalPlus.log");
				log_file.createNewFile();
				pStream = new PrintStream(log_file);
				System.setOut(pStream);
				log("LOGGING", "Set to file.");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Debug-Logging gescheitert[code 0]: " + e, "Error", 0);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Debug-Logging gescheitert[code 1]: " + e, "Error", 0);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Debug-Logging gescheitert[code 2]: " + e, "Error", 0);
			}
			log("ERROR", "Logging failed!");
		} else {
			System.setOut(System.out);
			log("LOGGING", "Set to console.");
		}
	}
	
	public static void log(String type, String msg) {
		System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "/" + type.toUpperCase() + "]: " + msg);
	}
}