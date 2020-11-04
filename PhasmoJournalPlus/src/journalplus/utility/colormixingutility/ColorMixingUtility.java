package journalplus.utility.colormixingutility;

public class ColorMixingUtility {
	public static String mixColors(String color1, String color2, double percentage) {
		return mix(new HTMLColorString(color1), new HTMLColorString(color2), percentage);
	}
	
	private static String mix(HTMLColorString s1, HTMLColorString s2, double percentage) {
		double p1 = percentage;
		double p2 = 1 - percentage;

		int r = (int)Math.round(s1.getR() * p1 + s2.getR() * p2);
		int g = (int)Math.round(s1.getG() * p1 + s2.getG() * p2);
		int b = (int)Math.round(s1.getB() * p1 + s2.getB() * p2);
		
		return "#" + toHex(r) + toHex(g) + toHex(b);
	}
	
	private static String toHex(int i) {
		String hex = Integer.toHexString(i);
		if(hex.length() == 1) { return "0" + hex; }
		return hex;
	}
}
