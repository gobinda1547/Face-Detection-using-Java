package org.ju.cse.gobinda.ai.faceDetection;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage bi;
	private int picHeight = 550;
	private int picWidth = 500;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(25, 25, picWidth, picHeight);
		if (bi != null) {
			g.drawImage(bi, 25, 25, null);
		}
	}

	public void setImage(String fileLocation) {
		try {
			BufferedImage nowImage = ImageIO.read(new File(fileLocation));
			int type = nowImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : nowImage.getType();

			bi = new BufferedImage(picWidth, picHeight, type);
			Graphics2D g = bi.createGraphics();
			g.drawImage(nowImage, 0, 0, picWidth, picHeight, null);
			g.dispose();

			repaint();
		} catch (Exception e) {
			System.out.println("problem occurs while loading file");
		}
	}

}