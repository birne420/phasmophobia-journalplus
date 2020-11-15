package journalplus.utility;

import journalplus.main.Logger;

public class ColorMixingUtility {
	public static String mixColors(String color1, String color2, double percentage) {
		HTMLColorString s1 = new HTMLColorString(color1);
		HTMLColorString s2 = new HTMLColorString(color2);

		int r = (int)Math.round(s1.getR() * percentage + s2.getR() * (1 - percentage));
		int g = (int)Math.round(s1.getG() * percentage + s2.getG() * (1 - percentage));
		int b = (int)Math.round(s1.getB() * percentage + s2.getB() * (1 - percentage));
		
		String rtn = "#" + toHex(r) + toHex(g) + toHex(b);
		Logger.log("utility.color_mixing", "mixed " + s1.getR() + "/" + s1.getG() + "/" + s1.getB() + " + " + s2.getR() + "/" + s2.getG() + "/" + s2.getB() + " to " + rtn);
		
		return rtn;
	}
	
	private static String toHex(int i) {
		String hex = Integer.toHexString(i);
		if(hex.length() == 1) return "0" + hex;
		return hex;
	}
}
