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
		this.setTitle("教务管理系统");
		this.admin = admin;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initAdminMenuPanel();
		jl_weclome.setText("欢迎 : " + admin.getAname() + " 管理员登录");
		jl_weclome.setFont(MyFont.getMyFont());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public IndexView(Student student) {
		this.setTitle("教务管理系统");
		this.student = student;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initMenuPanel();
		jl_weclome.setText("欢迎 : " + student.getSname() + "同学登录");
		jl_weclome.setFont(MyFont.getMyFont());
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public IndexView(Teacher teacher) {
		this.setTitle("教务管理系统");
		this.teacher = teacher;
		this.setSize(1000, 600);
		this.setResizable(false);
		Location.setCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		UIManager.put("TabbedPane.tabAreaInsets", new javax.swing.plaf.InsetsUIResource(0, 0, 0, 0));
		centerPanel = initCenterPanel();
		menuPanel = initMenuPanel();
		jl_weclome.setText("欢迎 : " + teacher.getTname() + "老师登录");
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

		jl_index = initMenu("首页");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_student = initMenu("学生管理");
		jl_student.setIcon(new ImageIcon("image/student.png"));
		jl_teacher = initMenu("教师管理");
		jl_teacher.setIcon(new ImageIcon("image/teacher.png"));
		jl_admin_course = initMenu("课程管理");
		jl_admin_course.setIcon(new ImageIcon("image/course.png"));
		jl_room = initMenu("教室管理");
		jl_room.setIcon(new ImageIcon("image/room.png"));
		jl_thing = initMenu("通知管理");
		jl_thing.setIcon(new ImageIcon("image/music.png"));

		jl_exit = new JLabel();
		jl_exit.setFont(MyFont.getMyFont());
		jl_exit.setPreferredSize(new Dimension(94, 40));
		jl_exit.setText("<html><font color='black' >注销登录</font></html>");
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
		jl_index = initMenu("首页");
		jl_index.setIcon(new ImageIcon("image/index.png"));
		jl_score = initMenu("成绩管理");
		jl_score.setIcon(new ImageIcon("image/score.png"));
		jl_sechdule = initMenu("课表管理");
		jl_sechdule.setIcon(new ImageIcon("image/sechdule.png"));
		jl_course = initMenu("选课管理");
		jl_course.setIcon(new ImageIcon("image/course.png"));
		jl_user = initMenu("用户管理");
		jl_user.setIcon(new ImageIcon("image/user.png"));
		jl_room = initMenu("教室管理");
		jl_room.setIcon(new ImageIcon("image/room.png"));
		jl_plan = initMenu("培养计划");
		jl_plan.setIcon(new ImageIcon("image/plan.png"));
		jl_exit = initMenu("注销登录");
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
		jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页   | " + "</font>&nbsp;</html>");
		jl_index.setPreferredSize(new Dimension(70, 40));
		ImagePanel backPanel = ViewFactory.getIndexBackPanel();
		centerPanel.add(backPanel);

		List<Thing> list = new ThingDao().selectThingList(new Thing());
		for (Thing th : list) {
			text = new String();
			text = th.getThingtext() + " 通知时间：" + th.getThingtime() + "                      ";
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
		tab.add("学生管理", jp);
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
		tab.add("教师管理", jp);
		centerPanel.add(tab);
	}

	public void createRoomView(Admin admin, Student studen, Teacher teacher) {
		centerPanel.removeAll();
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(MyFont.getMyFont());
		tab.add("教室管理", new RoomView(admin, studen, teacher));
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
		tab.add("课程管理", jp);
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
		tab.add("成绩管理", jp);
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
			tab.add("学生课表", jp);
		}
		if (teacher != null) {
			jp = ViewFactory.getTeacherCourseSechView(teacher);
			tab.add("教师课表", jp);
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
			tab.add("选择课程", jp1);
			tab.add("已选课程", jp2);
		} else if (teacher != null) {
			jp1 = ViewFactory.getTeacherCourseView(teacher);
			tab.add("安排课程", jp1);
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
			tab.add("基本信息", jp1);
			tab.add("修改密码", jp2);
			centerPanel.add(tab);
		} else if (teacher != null) {
			JPanel jp1 = ViewFactory.getTeacherInformationView(teacher);
			JPanel jp2 = ViewFactory.getTeacherUpdatePswView(teacher);
			tab.add("基本信息", jp1);
			tab.add("修改密码", jp2);
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
			tab.add("培养计划", new StudyPlanView());
			centerPanel.add(tab);

		} else if (e.getSource() == jl_thing) {
			centerPanel.removeAll();
			JTabbedPane tab = new JTabbedPane();
			tab.setFont(MyFont.getMyFont());
			tab.add("通知管理", new ThingView());
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
				tab.add("教室管理", new RoomView(admin, null, null));

			} else if (student != null) {
				System.out.print("n");
				tab.add("教室管理", new RoomView(null, student, null));
			} else if (teacher != null) {
				System.out.print("p");
				tab.add("教室管理", new RoomView(null, null, teacher));
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
			jl_index.setText("<html><font color='#336699' style='font-weight:bold'>" + "首页   | " + "</font></html>");
		} else if (e.getSource() == jl_score) {
			jl_score.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_score.setText("<html><font color='#336699' style='font-weight:bold'>" + "成绩管理   | " + "</font></html>");
		} else if (e.getSource() == jl_sechdule) {
			jl_sechdule.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_sechdule
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "课表管理   | " + "</font></html>");
		} else if (e.getSource() == jl_course) {
			jl_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_course
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "选课管理    | " + "</font></html>");
		} else if (e.getSource() == jl_user) {
			jl_user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_user.setText("<html><font color='#336699' style='font-weight:bold'>" + "用户管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_student) {
			jl_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_student
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "学生管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_teacher) {
			jl_teacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_teacher
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "教师管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_admin_course) {
			jl_admin_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_admin_course
					.setText("<html><font color='#336699' style='font-weight:bold'>" + "课程管理    | " + "</font></html>");
		} else if (e.getSource() == jl_room) {
			jl_room.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_room.setText("<html><font color='#336699' style='font-weight:bold'>" + "教室管理    | " + "</font></html>");
		} else if (e.getSource() == jl_thing) {
			jl_thing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_thing.setText("<html><font color='#336699' style='font-weight:bold'>" + "通知管理    | " + "</font></html>");
		} else if (e.getSource() == jl_plan) {
			jl_plan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_plan.setText("<html><font color='#336699' style='font-weight:bold'>" + "培养计划    | " + "</font></html>");
		} else {

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jl_index) {
			jl_index.setText("<html><font color='black'>" + "首页   | " + "</font></html>");
		} else if (e.getSource() == jl_score) {
			jl_score.setText("<html><font color='black' >" + "成绩管理   | " + "</font></html>");
		} else if (e.getSource() == jl_sechdule) {
			jl_sechdule.setText("<html><font color='black'>" + "课表管理   | " + "</font></html>");
		} else if (e.getSource() == jl_course) {
			jl_course.setText("<html><font color='black'>" + "选课管理    | " + "</font></html>");
		} else if (e.getSource() == jl_user) {
			jl_user.setText("<html><font color='black'>" + "用户管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_student) {
			jl_student.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_student.setText("<html><font color='black'>" + "学生管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_teacher) {
			jl_teacher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_teacher.setText("<html><font color='black'>" + "教师管理    | " + "</font></html>");
		} else if (admin != null && e.getSource() == jl_admin_course) {
			jl_admin_course.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_admin_course.setText("<html><font color='black'>" + "课程管理    | " + "</font></html>");
		} else if (e.getSource() == jl_room) {
			jl_room.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_room.setText("<html><font color='black'>" + "教室管理    | " + "</font></html>");
		} else if (e.getSource() == jl_thing) {
			jl_thing.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_thing.setText("<html><font color='black'>" + "通知管理    | " + "</font></html>");
		} else if (e.getSource() == jl_plan) {
			jl_plan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_plan.setText("<html><font color='black'>" + "培养计划    | " + "</font></html>");
		} else {

		}

	}
}
