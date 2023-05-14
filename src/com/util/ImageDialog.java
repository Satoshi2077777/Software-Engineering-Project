package com.util;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ImageDialog extends JDialog {
	@Override
	public void paint(Graphics g) {
		Image image;
		try {
			image = ImageIO.read(new File("image/userback.jpg"));
			g.drawImage(image, 0, 0, 500, 500, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImageDialog() {
		this.setLayout(new FlowLayout());
		JButton jb = new JButton();
		this.add(jb);
	}

	public static void main(String[] args) {
		ImageDialog d = new ImageDialog();
		d.setSize(new Dimension(500, 500));
		d.setVisible(true);
	}

}
