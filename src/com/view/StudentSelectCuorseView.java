package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.CourseDao;
import com.dao.PlanDao;
import com.dao.StudentCourseDao;
import com.entity.Course;
import com.entity.Plan;
import com.entity.Student;
import com.entity.StudentCourse;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class StudentSelectCuorseView extends JPanel implements MouseListener {
	private JTextField jtf_name;
	JComboBox jc_kind;
	JLabel jl_add;
	DefaultTableModel dm;
	JTable jt_course;
	Student student;

	/**
	 * Create the panel.
	 */
	public static void main(String args[]) {
		Student t = new Student();
		t.setSno("1");
		StudentSelectCuorseView a = new StudentSelectCuorseView(t);
		JFrame jf = new JFrame();
		jf.add(a);
		jf.setSize(1000, 600);
		jf.setVisible(true);
	}

	public void fillTable(Course course) {
		dm = (DefaultTableModel) jt_course.getModel();
		dm.setRowCount(0);
		Plan p = null;

		List<Course> list = new CourseDao().selectCourseList(course);
		;
		for (Course st : list) {
			p = new Plan();
			p.setPid(student.getMajor());
			p.setCno(st.getCno());
			if ((new PlanDao().checkPlanList(p)) == 0)
				continue;
			StudentCourse c=new StudentCourse();
			c.setCourse(st);
			c.setStudent(student);
			if(new StudentCourseDao().selectStudentCourse(c)!=null)continue;
			Vector<Object> v = new Vector<>();
			v.add(st.getCno());
			v.add(st.getCname());
			v.add(st.getCmark());
			Teacher t = st.getTeacher();
			v.add(t.getTno());

			String time = st.getCtime();
			String week = null;
			if (time != null) {
				String[] times = time.split(",");
				week = "周" + String.valueOf(times[0]) + "第" + String.valueOf(times[1]) + "课";
			} else {
				week = "";
			}
			v.add(week);
			v.add(st.getCplace());
			v.add(st.getCkind());
			v.add(st.getCdesc());

			dm.addRow(v);
		}
	}

	public StudentSelectCuorseView(Student student) {
		this.student = student;
		this.setPreferredSize(new Dimension(960, 550));
		setLayout(new BorderLayout(0, 0));

		JPanel jp_tool = new JPanel();
		jp_tool.setPreferredSize(new Dimension(1000, 50));
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);

		JButton jb_submit = new JButton("\u67E5\u8BE2");
		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb_submit.setBounds(880, 10, 80, 30);
		jp_tool.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		JLabel jl_kind = new JLabel("\u5B66\u79D1\u95E8\u7C7B:");
		jl_kind.setBounds(666, 10, 66, 30);
		jp_tool.add(jl_kind);
		jl_kind.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setBounds(539, 11, 100, 30);
		jp_tool.add(jtf_name);
		jtf_name.setColumns(10);
		jtf_name.setFont(MyFont.getMyFont());

		jc_kind = new JComboBox();
		jc_kind.setBounds(742, 10, 100, 30);
		jp_tool.add(jc_kind);
		jc_kind.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("\u5B66\u79D1\u540D\u79F0:");
		jl_name.setBounds(469, 10, 66, 30);
		jp_tool.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		jc_kind.addItem("--请选择--");

		jl_add = new JLabel("\u9009\u8BFE");
		jl_add.setBounds(10, 10, 54, 30);
		jp_tool.add(jl_add);
		jl_add.setFont(MyFont.getMyFont());
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);
		String[] subjects = CommboxData.getSubjects();
		for (String data : subjects) {
			jc_kind.addItem(data);
		}

		jt_course = new JTable(new DefaultTableModel(TableColums.getCourseColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_course.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_course.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_course);

		fillTable(new Course());
		JScrollPane js = new JScrollPane(jt_course);
		this.add(js);

		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cname = jtf_name.getText().trim();
				String kind = ((String) jc_kind.getSelectedItem()).trim();

				Course course = new Course();
				course.setCname(cname);
				if (!("--请选择--").equals(kind))
					course.setCkind(kind);
				fillTable(course);

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
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "选课" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("选课");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jt_course.getSelectedRow();
		if (e.getSource() == jl_add && row >= 0) {
			
			StudentCourseDao a=new StudentCourseDao();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(!(a.checkselectcoursetime(sdf.format(new java.util.Date()).toString()).equals("到期")))
			{
				JOptionPane.showMessageDialog(this,
						"<html>选课失败,未到选课时间,时间为<br><h1><font color=red>"+ a.checkselectcoursetime(sdf.format(new java.util.Date()).toString())+"</font></h1></html>");
				return;
			}
			String cno = (String) jt_course.getValueAt(row, 0);
			Course course = new Course();
			course.setCno(cno);
			Course c = new CourseDao().selectCourse(course);

			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setCourse(c);
			studentCourse.setStudent(student);
			studentCourse.setCscore(-1);
			new SelectCourseDialog(studentCourse);

		}

	}
}
