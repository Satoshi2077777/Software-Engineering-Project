package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.CourseDao;
import com.dao.StudentCourseDao;
import com.dao.UserTeacherDao;
import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.entity.Teacher;
import com.entity.UserTeacher;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class TeacherSocreView extends JPanel implements MouseListener {

	public static void main(String args[]) {
		Teacher t = new Teacher();
		t.setTno("2015015110");
		TeacherSocreView a = new TeacherSocreView(t);
		JFrame jf = new JFrame();
		jf.add(a);
		jf.setSize(1000, 600);
		jf.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	JComboBox jc_name;
	JTable jt_course;
	JLabel jl_add;
	JLabel jl_refresh;
	Teacher t;
	DefaultTableModel dm;

	public void fillTable(Course course) {
		dm = (DefaultTableModel) jt_course.getModel();
		dm.setRowCount(0);
		// "�γ̱��","�γ�����","ѧ��","ѧ��","����","�ɼ�"
		List<StudentCourse> list = new StudentCourseDao().selectStudentCourseListByCourse(course);
		for (StudentCourse st : list) {
			Vector<Object> v = new Vector<>();
			Course c = new Course();
			Student s = st.getStudent();
			c = st.getCourse();
			v.add(c.getCno());
			if (new StudentCourseDao().SelectStatu(s.getSno(), c.getCno()) > 0)
				v.add(c.getCname() + " �����ύ��");
			else
				v.add(c.getCname() + " ��δ�ύ��");

			v.add(c.getCmark());
			v.add(s.getSno());
			v.add(s.getSname());

			int score = st.getCscore();
			if (score == -1) {
				v.add("�ɼ�δ����");
			} else {
				v.add(score + "");
			}
			dm.addRow(v);
		}
	}

	public TeacherSocreView(Teacher t) {
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(new BorderLayout(0, 0));
		this.t = t;
		JPanel jp_tool = new JPanel();
		jp_tool.setPreferredSize(new Dimension(1000, 50));
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);

		jl_add = new JLabel("����");
		jl_add.setBounds(10, 10, 54, 30);
		jp_tool.add(jl_add);
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.setFont(MyFont.getMyFont());

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setBounds(85, 10, 54, 30);
		jp_tool.add(jl_refresh);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.setFont(MyFont.getMyFont());

		jl_add.addMouseListener(this);
		jl_refresh.addMouseListener(this);

		JLabel jl_kind = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		jl_kind.setBounds(551, 11, 62, 30);
		jp_tool.add(jl_kind);

		JButton jb_chaxun = new JButton("\u67E5\u8BE2");
		jb_chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb_chaxun.setBounds(795, 10, 80, 30);
		jp_tool.add(jb_chaxun);
		jb_chaxun.setFont(MyFont.getMyFont());

		JButton jb_submit = new JButton("�ύ");
		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb_submit.setBounds(895, 10, 80, 30);
		jp_tool.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jc_name = new JComboBox();
		jc_name.setBounds(623, 10, 132, 30);
		jp_tool.add(jc_name);
		jc_name.setFont(MyFont.getMyFont());

		jc_name.addItem("----��ѡ��----");
		List<Course> list = new CourseDao().selectCourseListByTeacher(t);
		;
		for (Course course : list) {
			jc_name.addItem(course.getCname());
		}
		jt_course = new JTable(new DefaultTableModel(TableColums.getTeacherScoreColums(), 0) {
			public boolean isCellEditable(int row, int column) {

				if (column == 5)
					return true;
				JOptionPane.showMessageDialog(new JFrame().getContentPane(), "�ñ����ɼ��ⲻ�ɱ༭��", "�༭��Ϣ",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		});
		jt_course.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_course.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_course);

		Course course = new Course();
		course.setCname("");
		course.setTeacher(t);
		fillTable(course);
		JScrollPane js = new JScrollPane(jt_course);
		this.add(js);

		jb_chaxun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String content = (String) jc_name.getSelectedItem();
				if ("----��ѡ��----".equals(content))
					content = "";
				Course c = new Course();
				c.setTeacher(t);
				c.setCname(content);
				fillTable(c);

			}

		});

		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String inputValue = JOptionPane.showInputDialog("������������ȷ�ϱ��棨���ύ���ɼ���");
				UserTeacher userTeacher = new UserTeacherDao()
						.selectUserTeacher(new UserTeacher(t.getTno(), inputValue));

				if (userTeacher != null) {
					String content = (String) jc_name.getSelectedItem();
					if ("----��ѡ��----".equals(content))
						content = "";
					Course c = new Course();
					c.setTeacher(t);
					c.setCname(content);
					List<StudentCourse> list = new StudentCourseDao().selectStudentCourseListByCourse(c);
					int a =0;
					for (StudentCourse st : list) {
						c = new Course();
						c = st.getCourse();
						Student s = st.getStudent();

						 a=new StudentCourseDao().updateStudentCourseStatu(s.getSno(), c.getCno());
				
					}
					if (a > 0)
						JOptionPane.showMessageDialog(new JFrame(), "�ύ�ɹ���");
					else
						JOptionPane.showMessageDialog(new JFrame(), "�����ظ��ύ��");
					;
				} else
					JOptionPane.showMessageDialog(new JFrame(), "<html><font size=5>�����������,�ύʧ�ܣ�</font></html>");
			}

		});

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
		if (e.getSource() == jl_add) {
			jl_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "����" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "ˢ��" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("����");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setText("ˢ��");

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jt_course.getSelectedRow();
		if (e.getSource() == jl_add) {
			String inputValue = JOptionPane.showInputDialog("������������ȷ���ύ�ɼ���");
			UserTeacher userTeacher = new UserTeacherDao().selectUserTeacher(new UserTeacher(t.getTno(), inputValue));

			if (userTeacher != null) {
				saveData();
			} else
				JOptionPane.showMessageDialog(this, "<html><font size=5>�����������,�ύʧ�ܣ�</font></html>");

		} else if (e.getSource() == jl_refresh) {
			Course course = new Course();
			course.setCname("");
			course.setTeacher(t);
			fillTable(course);
		}

	}

	private void saveData() {
		int col = jt_course.getColumnCount();
		int row = jt_course.getRowCount();
		for (int i = 0; i < col; i++) {
			System.out.print(jt_course.getColumnName(i) + "\t");
		}
		System.out.print("\r\n");
		for (int i = 0; i < row; i++) {

			String cno = (String) jt_course.getValueAt(i, 0);
			String cname = (String) jt_course.getValueAt(i, 1);

			int cmark = (int) jt_course.getValueAt(i, 2);

			String sno = (String) jt_course.getValueAt(i, 3);
			String sname = (String) jt_course.getValueAt(i, 4);
			String s = (String) jt_course.getValueAt(i, 5);
			int csocre = -1;
			if (!("�ɼ�δ����".equals(s))) {
				csocre = Integer.valueOf(s);
			}
			Course c = new Course();
			c.setCno(cno);
			c.setCname(cname);
			c.setCmark(cmark);

			Student student = new Student();
			student.setSno(sno);
			student.setSname(sname);

			StudentCourse sc = new StudentCourse();
			sc.setCourse(c);
			sc.setStudent(student);
			sc.setCscore(csocre);

			System.out.print(sc.toString() + "\t");
			int flag = new StudentCourseDao().updateStudentCourse(sc);
			if (flag == 0) {
				JOptionPane.showMessageDialog(this, "�γ̺ţ�" + c.getCno() + "  ѧ�ţ�" + student.getSno() + "����ʧ��,�����жϣ�");
				return;
			} else {

			}

		}
		JOptionPane.showMessageDialog(this, "����ɹ���");
		System.out.println("------------------------------------");
	}

}
