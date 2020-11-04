package journalplus.utility.gridbagconstraints;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagConstraintsUtility {
	public static GridBagConstraints build(int posX, int posY, GridBagConstraintsPattern pattern) {
		return build(posX, posY, pattern.getWidth(), pattern.getHeight(), pattern.getFill(), pattern.getWeightx(), pattern.getWeighty(), pattern.getInsets(), pattern.getAnchor());
	}
	public static GridBagConstraints build(int posX, int posY, int width, int height) {
		return build(posX, posY, width, height, GridBagConstraints.NONE, 0, 0, new Insets(0, 0, 0, 0), GridBagConstraints.CENTER);
	}
	public static GridBagConstraints build(int posX, int posY, int width, int height, int fill) {
		return build(posX, posY, width, height, fill, 0, 0, new Insets(0, 0, 0, 0), GridBagConstraints.CENTER);
	}
	public static GridBagConstraints build(int posX, int posY, int width, int height, int fill, double weightx, double weighty) {
		return build(posX, posY, width, height, fill, weightx, weighty, new Insets(0, 0, 0, 0), GridBagConstraints.CENTER);
	}
	public static GridBagConstraints build(int posX, int posY, int width, int height, int fill, double weightx, double weighty, Insets insets) {
		return build(posX, posY, width, height, fill, weightx, weighty, insets, GridBagConstraints.CENTER);
	}
	public static GridBagConstraints build(int posX, int posY, int width, int height, int fill, double weightx, double weighty, Insets insets, int anchor) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = posX;
		c.gridy = posY;
		c.gridwidth = width;
		c.gridheight = height;
		c.weightx = weightx;
		c.weighty = weighty;
		c.fill = fill;
		c.insets = insets;
		c.anchor = anchor;
		return c;
	}
}
