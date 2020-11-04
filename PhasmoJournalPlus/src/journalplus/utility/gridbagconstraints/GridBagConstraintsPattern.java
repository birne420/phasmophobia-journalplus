package journalplus.utility.gridbagconstraints;

import java.awt.Insets;

public class GridBagConstraintsPattern {
	private int width;
	private int height;
	private int fill;
	private double weightx;
	private double weighty;
	private Insets insets;
	private int anchor;
	
	public GridBagConstraintsPattern(int width, int height, int fill, double weightx, double weighty, Insets insets, int anchor) {
		this.width = width;
		this.height = height;
		this.fill = fill;
		this.weightx = weightx;
		this.weighty = weighty;
		this.insets = insets;
		this.anchor = anchor;
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getFill() { return fill; }
	public double getWeightx() { return weightx; }
	public double getWeighty() { return weighty; }
	public Insets getInsets() { return insets; }
	public int getAnchor() { return anchor; }
}
