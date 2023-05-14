package com.main;

import java.awt.EventQueue;

import com.view.LoginView;

public class MySystem {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("Ä¬ÈÏ×Ö·û¼¯£º" + System.getProperty("file.encoding"));
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
