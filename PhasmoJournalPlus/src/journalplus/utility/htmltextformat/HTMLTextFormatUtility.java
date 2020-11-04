package journalplus.utility.htmltextformat;

public class HTMLTextFormatUtility {
	public static final String START = "<html><body>";
	public static final String END = "</body></html>";
	
	public static final String STRCOLOR(String text, String color) {
		return "<font color='" + color + "'>" + text + "</font>";
	}
}
