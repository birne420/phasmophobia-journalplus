package journalplus.utility;

public class ColorMixingUtility {
	public static String mixColors(String color1, String color2, double percentage) {
		HTMLColorString s1 = new HTMLColorString(color1);
		HTMLColorString s2 = new HTMLColorString(color2);

		int r = (int)Math.round(s1.getR() * percentage + s2.getR() * (1 - percentage));
		int g = (int)Math.round(s1.getG() * percentage + s2.getG() * (1 - percentage));
		int b = (int)Math.round(s1.getB() * percentage + s2.getB() * (1 - percentage));
		
		return "#" + toHex(r) + toHex(g) + toHex(b);
	}
	
	private static String toHex(int i) {
		String hex = Integer.toHexString(i);
		if(hex.length() == 1) return "0" + hex;
		return hex;
	}
}
