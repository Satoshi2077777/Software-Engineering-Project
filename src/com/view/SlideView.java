package com.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.util.Frame;

public class SlideView extends JPanel implements MouseListener {
	private static final long serialVersionUID = 4767050156491994899L;
	private JLabel label;
	private String scrolledText;

	public SlideView(String str) {
		scrolledText = str;
		label = new JLabel(new String(scrolledText));
		this.add(label);
		label.addMouseListener(this);
		Thread thread = new Thread(new TextChanger(label));
		thread.start();
	}

	// @Override
	// protected void paintComponent(Graphics g) {
	// super.paintComponent(g);
	//
	// Graphics2D g2d = (Graphics2D) g;
	//
	// }

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		frame.getContentPane().add(new SlideView("fsdoihf;svfb;sdjfbsd;bfsdubfvusdb"));

		frame.setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SlideView.createAndShowGUI();
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Frame frame = new Frame(null, scrolledText);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

class TextChanger implements Runnable {
	private static final int BOLD = 0;
	private JLabel label;

	public TextChanger(JLabel label) {
		this.label = label;
	}

	public void run() {
		try {
			while (true) {
				String text = label.getText();
				if (text.length() > 1) {
					text = text.substring(1, text.length()) + text.charAt(0);
					label.setText(text);
					label.setFont(new Font("¿¬Ìå", BOLD, 34));
					// Get the frame
					Component frame = SwingUtilities.getRoot(label);
					// if (frame != null && (frame instanceof JFrame)) {
					// ((JFrame)frame).setTitle(text);
					// }

					label.repaint();
				}

				Thread.sleep(300);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
