package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.dao.CourseDao;
import com.entity.Course;
import com.entity.Teacher;
import com.util.ImagePanel;
import com.util.MyFont;

public class TeacherCourseSechView extends ImagePanel {

	public static void main(String args[]) {
		JFrame jf = new JFrame();
		JPanel jp = null;
		Teacher t = new Teacher();
		t.setTno("1111111");
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new TeacherCourseSechView(t, 1000, 550, image);
			jp.setSize(1000, 550);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jf.add(jp);
		jf.setSize(700, 700);
		jf.setVisible(true);

	}

	/**
	 * Create the panel.
	 */
	public TeacherCourseSechView(Teacher teacher, int width, int height, Image image) {
		super(width, height, image);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setLayout(new GridLayout(5, 8));
		JLabel[] jls = new JLabel[40];
		for (int i = 0; i < 40; i++) {
			jls[i] = new JLabel();
			jls[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			this.add(jls[i]);
			if ((i % 8) != 0)
				jls[i].setHorizontalAlignment(SwingConstants.CENTER);
			jls[i].setFont(MyFont.getMyFont());
		}
		jls[0].setText("星期");
		jls[1].setText("星期一");
		jls[2].setText("星期二");
		jls[3].setText("星期三");
		jls[4].setText("星期四");
		jls[5].setText("星期五");
		jls[6].setText("星期六");
		jls[7].setText("星期天");

		jls[8].setText("一二");
		jls[16].setText("三四");
		jls[24].setText("五六");
		jls[32].setText("七八");
		List<Course> list = new CourseDao().selectCourseListByTeacher(teacher);
		for (Course course : list) {
			String cname = course.getCname();
			String cplace = course.getCplace();
			String ctime = course.getCtime();

			int location = getLocation(ctime);
			System.out.print("location");
			jls[location].setText("<html>" + cname + "<br>" + cplace + "</html>");
		}

	}

	public int getLocation(String str) {
		String[] content = str.split(",");
		int i = 0;
		if (content[1].equals("12")) {
			i = 1;
		} else if (content[1].equals("34")) {
			i = 2;
		} else if (content[1].equals("56")) {
			i = 3;
		} else if (content[1].equals("78")) {
			i = 4;
		} else {

		}

		int j = 0;
		if (content[0].equals("一")) {
			j = 1;
		} else if (content[0].equals("二")) {
			j = 2;
		} else if (content[0].equals("三")) {
			j = 3;
		} else if (content[0].equals("四")) {
			j = 4;
		} else if (content[0].equals("五")) {
			j = 5;
		} else if (content[0].equals("六")) {
			j = 6;
		} else if (content[0].equals("七")) {
			j = 7;
		} else {

		}
		return i * 8 + j;

	}

}
