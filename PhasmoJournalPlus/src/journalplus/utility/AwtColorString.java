package journalplus.utility;

import java.awt.Color;

public class AwtColorString {
	public static Color fromString(String str) {
		if(str.startsWith("#")) {
			HTMLColorString color = new HTMLColorString(str);
			return new Color(color.getR(), color.getG(), color.getB());
		} else {
			String colorStr = str.toUpperCase();
			if(colorStr.equals("NULL")) { return null; }
			else if(colorStr.equals("WHITE")) { return Color.WHITE; }
			else if(colorStr.equals("LIGHT_GRAY")) { return Color.LIGHT_GRAY; }
			else if(colorStr.equals("GRAY")) { return Color.GRAY; }
			else if(colorStr.equals("DARK_GRAY")) { return Color.DARK_GRAY; }
			else if(colorStr.equals("BLACK")) { return Color.BLACK; }
			else if(colorStr.equals("RED")) { return Color.RED; }
			else if(colorStr.equals("PINK")) { return Color.PINK; }
			else if(colorStr.equals("ORANGE")) { return Color.ORANGE; }
			else if(colorStr.equals("YELLOW")) { return Color.YELLOW; }
			else if(colorStr.equals("GREEN")) { return Color.GREEN; }
			else if(colorStr.equals("MAGENTA")) { return Color.MAGENTA; }
			else if(colorStr.equals("CYAN")) { return Color.CYAN; }
			else if(colorStr.equals("BLUE")) { return Color.BLUE; }
			else { return null; }
		}
	}
}
