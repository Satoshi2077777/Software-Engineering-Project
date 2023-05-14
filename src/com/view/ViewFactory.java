package com.view;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.entity.Student;
import com.entity.Teacher;
import com.util.ImagePanel;

public class ViewFactory {
	public static ImagePanel getIndexBackPanel() {
		ImagePanel imagePanel = null;
		try {
			Image image = ImageIO.read(new File("image/index_back1.jpg"));
			// Image image=ImageIO.read(new File("image/userback.jpg"));
			imagePanel = new ImagePanel(1000, 550, image);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return imagePanel;
		}
	}

	public static JPanel getStudentManagerPanel() {
		JPanel jp = new StudentManagerPanel();
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getTeacherManagerPanle() {
		JPanel jp = new TeacherManagerView();
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getCourseManagerPanel() {
		JPanel jp = new CourseManagerView();
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getStudentInformationPanel(Student student) {
		JPanel jp = null;
		try {
			// Image image=ImageIO.read(new File("image/index_back1.jpg"));
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new StudentInfromationView(1050, 550, image, student);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getStudentUpdatePswView(Student student) {

		JPanel jp = null;
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new StudentUpdatePswView(1050, 550, image, student);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getStudentSelectCourseView(Student student) {
		JPanel jp = new StudentSelectCuorseView(student);
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getCoursetAlView(Student student) {
		JPanel jp = new CourseAlSelectView(student);
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getStudentScoreView(Student student) {
		JPanel jp = new StudentScoreView(student);
		jp.setSize(1000, 550);
		return jp;
	}

	public static JPanel getStudentCourseSechView(Student student) {
		JPanel jp = null;
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new StudentCourseSechView(student, 1000, 550, image);
			jp.setSize(1000, 550);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getTeacherInformationView(Teacher teacher) {
		JPanel jp = null;
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new TeacherInfromationView(teacher, 1000, 550, image);
			jp.setSize(1000, 550);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getTeacherUpdatePswView(Teacher teacher) {
		JPanel jp = null;
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new TeacherUpdatePswView(1000, 550, image, teacher);
			jp.setSize(1000, 550);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getTeacherCourseView(Teacher t) {
		JPanel jp = new TeacherCourseView(t);
		jp.setPreferredSize(new Dimension(1000, 550));
		return jp;
	}

	public static JPanel getTeacherCourseSechView(Teacher teacher) {
		JPanel jp = null;
		try {
			Image image = ImageIO.read(new File("image/userback.jpg"));
			jp = new TeacherCourseSechView(teacher, 1000, 550, image);
			jp.setSize(1000, 550);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return jp;
		}
	}

	public static JPanel getTeacherSocreView(Teacher t) {
		JPanel jp = new TeacherSocreView(t);
		jp.setPreferredSize(new Dimension(1000, 550));
		return jp;
	}
}
