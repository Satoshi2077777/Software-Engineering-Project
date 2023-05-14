package com.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.dao.StudentCourseDao;
import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.util.ImagePanel;
import com.util.MyFont;

public class StudentCourseSechView extends ImagePanel {

	/**
	 * Create the panel.
	 */
	public StudentCourseSechView(Student student, int width, int height, Image image) {
		super(width, height, image);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setLayout(new GridLayout(5, 8));
		JLabel[] jls = new JLabel[40];
		for (int i = 0; i < 40; i++) {
			jls[i] = new JLabel();
			jls[i].setBorder(BorderFactory.createLineBorder(Color.black));
			this.add(jls[i]);
			if ((i % 8) != 0)
				jls[i].setHorizontalAlignment(SwingConstants.CENTER);
			jls[i].setFont(MyFont.getMyFont());
		}
		jls[0].setText("����");
		jls[1].setText("����һ");
		jls[2].setText("���ڶ�");
		jls[3].setText("������");
		jls[4].setText("������");
		jls[5].setText("������");
		jls[6].setText("������");
		jls[7].setText("������");

		jls[8].setText("һ��");
		jls[16].setText("����");
		jls[24].setText("����");
		jls[32].setText("�߰�");
		List<StudentCourse> list = new StudentCourseDao().selectStudentCourseListByStudent(student);
		for (StudentCourse studentCourse : list) {
			Course course = studentCourse.getCourse();
			String cname = course.getCname();
			String cplace = course.getCplace();
			String ctime = course.getCtime();

			int location = getLocation(ctime);
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
		if (content[0].equals("һ")) {
			j = 1;
		} else if (content[0].equals("��")) {
			j = 2;
		} else if (content[0].equals("��")) {
			j = 3;
		} else if (content[0].equals("��")) {
			j = 4;
		} else if (content[0].equals("��")) {
			j = 5;
		} else if (content[0].equals("��")) {
			j = 6;
		} else if (content[0].equals("��")) {
			j = 7;
		} else {

		}
		return i * 8 + j;

	}

}
