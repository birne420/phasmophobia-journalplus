package journalplus.utility.colormixingutility;

public class HTMLColorString {
	private String realHexString;
	
	private int r;
	private int g;
	private int b;
	
	public HTMLColorString(String color) {
		this.realHexString = color.substring(1);
		this.r = Integer.parseInt(this.realHexString.substring(0, 2), 16);
		this.g = Integer.parseInt(this.realHexString.substring(2, 4), 16);
		this.b = Integer.parseInt(this.realHexString.substring(4, 6), 16);
	}
	
	public int getR() { return r; }
	public int getG() { return g; }
	public int getB() { return b; }
}
