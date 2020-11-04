package journalplus.gui.ingamejournal;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private BufferedImage image;
	private JLabel i;
	
	public ImagePanel() {
		i = new JLabel(loadPage(1));
		this.add(i);
	}
	
	public void displayPage(int page) {
		i.setIcon(loadPage(page));
	}
	
	private ImageIcon loadPage(int page) {
		if(page < 1) page = 1;
		if(page > 12) page = 12;
		
		String requestedFile = "/journalplus/assets/s" + page + ".jpg";
		URL url = this.getClass().getResource(requestedFile);
		
		try {
			this.image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new ImageIcon(getScaledImage(this.image, 620, 460));
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, 330, 55, 1555, 1015, null);
	    g2.dispose();

	    return resizedImg;
	}
}
