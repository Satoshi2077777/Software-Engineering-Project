package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.dao.ThingDao;
import com.entity.Admin;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Thing;
import com.main.MySystem;
import com.util.ImagePanel;
import com.util.Location;
import com.util.MyFont;

public class IndexView extends JFrame implements MouseListener {
	JPanel centerPanel;
	JPanel menuPanel;
	JLabel jl_index;
	JLabel jl_score;
	JLabel jl_sechdule;
	JLabel jl_course;
	JLabel jl_user;
	JLabel jl_student;
	JLabel jl_thing;
	JLabel jl_room;
	JLabel jl_exit;
	JLabel jl_plan;
	JLabel jl_teacher;
	JLabel jl_admin_course;
	JLabel jl_weclome;
	int flag_index;
	int flag_score;
	int flag_sechdule;
	int flag_course;
	int flag_user;
	int flag_student;
	int flag_teacher;
	int flag_admin_course;
	Teacher teacher = null;
	Student student = null;
	Admin admin = null;

	public static void main(String args[]) {
		Admin a = new Admin();
		a.setAid(1);
		IndexView i = new IndexView(a);
		i.setVisible(true);
	}

	public IndexView() {

	}

	public void closeindex() {
		this.dispose();
	}

	public IndexView(Admin admin) {
		this.setTitle("�������ϵͳ");
		this.admin = admin;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initAdminMenuPanel();
		jl_weclome.setText("��ӭ : " + admin.getAname() + " ����Ա��¼");
		jl_weclome.setFont(MyFont.getMyFont());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public IndexView(Student student) {
		this.setTitle("�������ϵͳ");
		this.student = student;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initMenuPanel();
		jl_weclome.setText("��ӭ : " + student.getSname() + "ͬѧ��¼");
		jl_weclome.setFont(MyFont.getMyFont());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public IndexView(Teacher teacher) {
		this.setTitle("�������ϵͳ");
		this.teacher = teacher;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initMenuPanel();
		jl_weclome.setText("��ӭ : " + teacher.getTname() + "��ʦ��¼");
		jl_weclome.setFont(MyFont.getMyFont());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public JPanel initAdminMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(950, 50));

		jl_weclome = new JLabel();
		jl_weclome.setIcon(new ImageIcon("image/weclome.png"));
		jl_weclome.setFont(MyFont.getMyFont());

		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		jl_index = initMenu("��ҳ");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_student = initMenu("ѧ������");
		jl_student.setIcon(new ImageIcon("image/student.png"));
		jl_teacher = initMenu("��ʦ����");
		jl_teacher.setIcon(new ImageIcon("image/teacher.png"));
		jl_admin_course = initMenu("�γ̹���");
		jl_admin_course.setIcon(new ImageIcon("image/course.png"));
		jl_room = initMenu("���ҹ���");
		jl_room.setIcon(new ImageIcon("image/room.png"));
		jl_thing = initMenu("֪ͨ����");
		jl_thing.setIcon(new ImageIcon("image/music.png"));

		jl_exit = new JLabel();
		jl_exit.setFont(MyFont.getMyFont());
		jl_exit.setPreferredSize(new Dimension(94, 40));
		jl_exit.setText("<html><font color='black' >ע����¼</font></html>");
		jl_exit.addMouseListener(this);
		jl_exit.setIcon(new ImageIcon("image/exit.png"));

		menuPanel.add(jl_index);
		menuPanel.add(jl_student);
		menuPanel.add(jl_teacher);
		menuPanel.add(jl_admin_course);
		menuPanel.add(jl_room);
		menuPanel.add(jl_thing);
		menuPanel.add(jl_exit);

		menuPanel.add(new JLabel("                            "));
		menuPanel.add(jl_weclome);

		createIndex();
		return menuPanel;
	}

	public JPanel initMenuPanel() {
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(850, 50));

		jl_weclome = new JLabel();
		jl_weclome.setIcon(new ImageIcon("image/weclome.png"));

		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		jl_index = initMenu("��ҳ");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_score = initMenu("�ɼ�����");
		jl_score.setIcon(new ImageIcon("image/score.png"));
		jl_sechdule = initMenu("�α����");
		jl_sechdule.setIcon(new ImageIcon("image/sechdule.png"));
		jl_course = initMenu("ѡ�ι���");
		jl_course.setIcon(new ImageIcon("image/course.png"));
		jl_user = initMenu("�û�����");
		jl_user.setIcon(new ImageIcon("image/user.png"));
		jl_room = initMenu("���ҹ���");
		jl_room.setIcon(new ImageIcon("image/room.png"));
		jl_plan = initMenu("�����ƻ�");
		jl_plan.setIcon(new ImageIcon("image/plan.png"));
		jl_exit = initMenu("ע����¼");
		jl_exit.setIcon(new ImageIcon("image/exit.png"));

		menuPanel.add(jl_index);
		menuPanel.add(jl_score);
		menuPanel.add(jl_sechdule);
		menuPanel.add(jl_course);
		menuPanel.add(jl_user);
		menuPanel.add(jl_room);
		menuPanel.add(jl_plan);
		menuPanel.add(jl_exit);
		menuPanel.add(jl_weclome);

		createIndex();
		return menuPanel;

	}

	public JPanel initCenterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		return panel;
	}

	public JLabel initMenu(String name) {
		JLabel menu = new JLabel();
		menu.setFont(MyFont.getMyFont());
		menu.setPreferredSize(new Dimension(94, 40));
		menu.setText("<html><font color='black' >" + name + " | " + "</font></html>");
		menu.addMouseListener(this);
		return menu;
	}

	public void createIndex() {
		String text = null;
		centerPanel.removeAll();
		flag_index = 1;
		flag_score = 0;
		flag_sechdule = 0;
		flag_course = 0;
		flag_user = 0;
		flag_student = 0;
		flag_teacher = 0;
		flag_admin_course = 0;
		jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ҳ   | " + "</font>&nbsp;</html>");
		jl_index.setPreferredSize(new Dimension(70, 40));
		ImagePanel backPanel = ViewFactory.getIndexBackPanel();
		centerPanel.add(backPanel);

		List<Thing> list = new ThingDao().selectThingList(new Thing());
		for (Thing th : list) {
			text = new String();
			text = th.getThingtext() + " ֪ͨʱ�䣺" + th.getThingtime() + "                      ";
			centerPanel.add(new SlideView(text));
		}

		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	}

	public void createAdminStudent() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_student = 1;
		flag_teacher = 0;
		flag_user = 0;
		flag_admin_course = 0;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getStudentManagerPanel();
		tab.add("ѧ������", jp);
		centerPanel.add(tab);
	}

	public void createAdminTeacher() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_student = 0;
		flag_teacher = 1;
		flag_user = 0;
		flag_admin_course = 0;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getTeacherManagerPanle();
		tab.add("��ʦ����", jp);
		centerPanel.add(tab);
	}

	public void createRoomView(Admin admin, Student studen, Teacher teacher) {
		centerPanel.removeAll();
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		tab.add("���ҹ���", new RoomView(admin, studen, teacher));
		centerPanel.add(tab);
		System.out.println("createRoomView");
	}

	public void createAdminCourse() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_student = 0;
		flag_teacher = 0;
		flag_user = 0;
		flag_admin_course = 1;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = ViewFactory.getCourseManagerPanel();
		tab.add("�γ̹���", jp);
		centerPanel.add(tab);
	}

	public void createScore() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_score = 1;
		flag_sechdule = 0;
		flag_course = 0;
		flag_user = 0;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = new JPanel();
		if (student != null) {
			jp = ViewFactory.getStudentScoreView(student);
		} else {
			jp = ViewFactory.getTeacherSocreView(teacher);
		}
		tab.add("�ɼ�����", jp);
		centerPanel.add(tab);

	}

	public void createSechdule() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_score = 0;
		flag_sechdule = 1;
		flag_course = 0;
		flag_user = 0;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp = null;
		if (student != null) {
			jp = ViewFactory.getStudentCourseSechView(student);
			tab.add("ѧ���α�", jp);
		}
		if (teacher != null) {
			jp = ViewFactory.getTeacherCourseSechView(teacher);
			tab.add("��ʦ�α�", jp);
		}

		centerPanel.add(tab);
	}

	public void createCourse() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_score = 0;
		flag_sechdule = 0;
		flag_course = 1;
		flag_user = 0;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		JPanel jp1 = null;
		JPanel jp2 = null;
		if (student != null) {
			jp1 = ViewFactory.getStudentSelectCourseView(student);
			jp2 = ViewFactory.getCoursetAlView(student);
			tab.add("ѡ��γ�", jp1);
			tab.add("��ѡ�γ�", jp2);
		} else if (teacher != null) {
			jp1 = ViewFactory.getTeacherCourseView(teacher);
			tab.add("���ſγ�", jp1);
		}

		centerPanel.add(tab);
	}

	public void createUser() {
		centerPanel.removeAll();
		flag_index = 0;
		flag_score = 0;
		flag_sechdule = 0;
		flag_course = 0;
		flag_user = 1;
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		if (student != null) {
			JPanel jp1 = ViewFactory.getStudentInformationPanel(student);
			JPanel jp2 = ViewFactory.getStudentUpdatePswView(student);
			tab.add("������Ϣ", jp1);
			tab.add("�޸�����", jp2);
			centerPanel.add(tab);
		} else if (teacher != null) {
			JPanel jp1 = ViewFactory.getTeacherInformationView(teacher);
			JPanel jp2 = ViewFactory.getTeacherUpdatePswView(teacher);
			tab.add("������Ϣ", jp1);
			tab.add("�޸�����", jp2);
			centerPanel.add(tab);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_index) {
			if (flag_index == 0) {
				this.createIndex();
			}
		} else if (e.getSource() == jl_score) {
			if (flag_score == 0) {
				this.createScore();
			}
		} else if (e.getSource() == jl_sechdule) {
			if (flag_sechdule == 0) {
				this.createSechdule();
			}
		} else if (e.getSource() == jl_course) {
			if (flag_course == 0) {
				this.createCourse();
			}
		} else if (e.getSource() == jl_user) {
			if (flag_user == 0) {
				this.createUser();
			}
		} else if (e.getSource() == jl_student) {
			if (flag_student == 0) {
				this.createAdminStudent();
			}
		} else if (e.getSource() == jl_teacher) {
			if (flag_teacher == 0) {
				this.createAdminTeacher();
			}
		} else if (e.getSource() == jl_admin_course) {
			if (flag_admin_course == 0) {
				this.createAdminCourse();
			}

		} else if (e.getSource() == jl_plan) {
			centerPanel.removeAll();
			JTabbedPane tab = new JTabbedPane();
			tab.setFont(MyFont.getMyFont());
			tab.add("�����ƻ�", new StudyPlanView());
			centerPanel.add(tab);

		} else if (e.getSource() == jl_thing) {
			centerPanel.removeAll();
			JTabbedPane tab = new JTabbedPane();
			tab.setFont(MyFont.getMyFont());
			tab.add("֪ͨ����", new ThingView());
			centerPanel.add(tab);
		} else if (e.getSource() == jl_exit) {
			MySystem.main(null);
			this.dispose();

		}

		else if (e.getSource() == jl_room) {
			centerPanel.removeAll();
			JTabbedPane tab = new JTabbedPane();
			tab.setFont(MyFont.getMyFont());
			// RoomView.main(null);
			if (admin != null) {
				System.out.println("now is getSource()==jl_room");
				// centerPanel.add(new RoomView(admin,null,null));
				tab.add("���ҹ���", new RoomView(admin, null, null));

			} else if (student != null) {
				System.out.print("n");
				tab.add("���ҹ���", new RoomView(null, student, null));
			} else if (teacher != null) {
				System.out.print("p");
				tab.add("���ҹ���", new RoomView(null, null, teacher));
			}
			centerPanel.add(tab);
			System.out.println("now is endif");

		}
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
		if (e.getSource() == jl_index) {
			jl_index.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ҳ   | " + "</font></html>");
		} else if (e.getSource() == jl_score) {
			jl_score.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_score.setText("<html><font color='#336699' style='font-weight:bold'>" + "�ɼ�����   | " + "</font></html>");
		} else if (e.getSource() == jl_sechdule) {
			jl_sechdule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_sechdule
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "�α����   | " + "</font></html>");
		} else if (e.getSource() == jl_course) {
			jl_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_course
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "ѡ�ι���    | " + "</font></html>");
		} else if (e.getSource() == jl_user) {
			jl_user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_user.setText("<html><font color='#336699' style='font-weight:bold'>" + "�û�����    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_student) {
			jl_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_student
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "ѧ������    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_teacher) {
			jl_teacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_teacher
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ʦ����    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_admin_course) {
			jl_admin_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_admin_course
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "�γ̹���    | " + "</font></html>");
		} else if (e.getSource() == jl_room) {
			jl_room.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_room.setText("<html><font color='#336699' style='font-weight:bold'>" + "���ҹ���    | " + "</font></html>");
		} else if (e.getSource() == jl_thing) {
			jl_thing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_thing.setText("<html><font color='#336699' style='font-weight:bold'>" + "֪ͨ����    | " + "</font></html>");
		} else if (e.getSource() == jl_plan) {
			jl_plan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_plan.setText("<html><font color='#336699' style='font-weight:bold'>" + "�����ƻ�    | " + "</font></html>");
		} else {

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jl_index) {
			jl_index.setText("<html><font color='black'>" + "��ҳ   | " + "</font></html>");
		} else if (e.getSource() == jl_score) {
			jl_score.setText("<html><font color='black' >" + "�ɼ�����   | " + "</font></html>");
		} else if (e.getSource() == jl_sechdule) {
			jl_sechdule.setText("<html><font color='black'>" + "�α����   | " + "</font></html>");
		} else if (e.getSource() == jl_course) {
			jl_course.setText("<html><font color='black'>" + "ѡ�ι���    | " + "</font></html>");
		} else if (e.getSource() == jl_user) {
			jl_user.setText("<html><font color='black'>" + "�û�����    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_student) {
			jl_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_student.setText("<html><font color='black'>" + "ѧ������    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_teacher) {
			jl_teacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_teacher.setText("<html><font color='black'>" + "��ʦ����    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_admin_course) {
			jl_admin_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_admin_course.setText("<html><font color='black'>" + "�γ̹���    | " + "</font></html>");
		} else if (e.getSource() == jl_room) {
			jl_room.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_room.setText("<html><font color='black'>" + "���ҹ���    | " + "</font></html>");
		} else if (e.getSource() == jl_thing) {
			jl_thing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_thing.setText("<html><font color='black'>" + "֪ͨ����    | " + "</font></html>");
		} else if (e.getSource() == jl_plan) {
			jl_plan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_plan.setText("<html><font color='black'>" + "�����ƻ�    | " + "</font></html>");
		} else {

		}

	}
}
