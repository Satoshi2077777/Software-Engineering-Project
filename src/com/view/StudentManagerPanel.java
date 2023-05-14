package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.dao.StudentDao;
import com.entity.Student;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class StudentManagerPanel extends JPanel implements MouseListener {
	public static void main(String args[])
	{
		StudentManagerPanel A=new StudentManagerPanel();
		JFrame jf=new JFrame();
		jf.add(A);
		jf.setSize(1000,500);
		jf.setVisible(true);
	}
	private JTextField jtf_name;
	JTable jt_student;
	DefaultTableModel dm;
	DefaultTableColumnModel dcm;
	JLabel jl_add;
	JLabel jl_del;
	JLabel jl_update;
	JLabel jl_refresh;

	public void fillTable(Student student) {
		dm = (DefaultTableModel) jt_student.getModel();
		dm.setRowCount(0);

		List<Student> list = new StudentDao().selectStudentList(student);
		for (Student st : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(st.getSno());
			v.add(st.getSname());
			int i = st.getSex();
			String sex = null;
			if (i == 0)
				sex = "女";
			else
				sex = "男";
			v.add(sex);
			v.add(st.getSbirth());
			v.add(st.getTelephone());
			v.add(st.getDepartment());
			v.add(st.getMajor());
			v.add(st.getSclass());
			v.add(st.getNationality());
			v.add(st.getNativeplace());
			dm.addRow(v);
		}

	}

	public StudentManagerPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel jp_tool = new JPanel();
		jp_tool.setPreferredSize(new Dimension(1000, 50));
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);

		jl_add = new JLabel("\u6DFB\u52A0");
		jl_add.setBounds(0, 10, 54, 30);
		jp_tool.add(jl_add);
		jl_add.setFont(MyFont.getMyFont());
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);

		jl_del = new JLabel("\u5220\u9664");
		jl_del.setBounds(64, 11, 54, 30);
		jp_tool.add(jl_del);
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);

		jl_update = new JLabel("\u4FEE\u6539");
		jl_update.setBounds(128, 10, 54, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);

		JLabel jl_name = new JLabel("\u59D3\u540D:");
		jl_name.setBounds(352, 10, 50, 30);
		jp_tool.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setBounds(399, 11, 100, 30);
		jp_tool.add(jtf_name);
		jtf_name.setColumns(10);
		jtf_name.setFont(MyFont.getMyFont());

		JLabel jl_department = new JLabel("\u5B66\u9662:");
		jl_department.setBounds(521, 10, 50, 30);
		jp_tool.add(jl_department);
		jl_department.setFont(MyFont.getMyFont());

		JComboBox jc_department = new JComboBox();
		jc_department.setBounds(572, 10, 100, 30);
		jp_tool.add(jc_department);
		jc_department.setFont(MyFont.getMyFont());
		jc_department.addItem("--请选择--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}

		JLabel jl_place = new JLabel("\u7C4D\u8D2F:");
		jl_place.setBounds(700, 10, 50, 30);
		jp_tool.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());

		JComboBox jc_place = new JComboBox();
		jc_place.setBounds(750, 10, 100, 30);
		jp_tool.add(jc_place);
		jc_place.setFont(MyFont.getMyFont());
		jc_place.addItem("--请选择--");
		String[] provinces = CommboxData.getProvinces();
		for (String data : provinces) {
			jc_place.addItem(data);
		}
		jt_student = new JTable(new DefaultTableModel(TableColums.getStudentColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_student.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_student.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_student);

		fillTable(new Student());
		JScrollPane js = new JScrollPane(jt_student);
		this.add(js, BorderLayout.CENTER);
		JButton jb_submit = new JButton("查询");
		jb_submit.setBounds(890, 10, 80, 30);
		jp_tool.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_refresh.setBounds(199, 10, 54, 30);
		jp_tool.add(jl_refresh);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sname = jtf_name.getText().trim();
				String department = ((String) jc_department.getSelectedItem()).trim();
				String provinces = ((String) jc_place.getSelectedItem()).trim();

				Student student = new Student();
				student.setSname(sname);
				if (!("--请选择--").equals(department))
					student.setDepartment(department);
				if (!("--请选择--").equals(provinces))
					student.setNativeplace(provinces);
				fillTable(student);

			}

		});

	}

	// public static void main(String[] args){
	// JFrame jf=new JFrame();
	// jf.setSize(960,500);
	// jf.getContentPane().add(new StudentManagerPanel());
	// jf.setVisible(true);
	// }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_student.getSelectedRow();
		if (e.getSource() == jl_add) {
			Student st = new Student();
			st.setSex(-1);
			new StudentInformationDialog(st, 0);

		} else if (e.getSource() == jl_del && row >= 0) {
			Student st = new Student();
			st.setSno(((String) jt_student.getValueAt(row, 0)));
			Student s = new StudentDao().selectStudent(st);
			new StudentInformationDialog(s, 1);
		} else if (e.getSource() == jl_update && row >= 0) {
			Student st = new Student();
			st.setSno(((String) jt_student.getValueAt(row, 0)));
			Student s = new StudentDao().selectStudent(st);
			new StudentInformationDialog(s, 2);
		} else if (e.getSource() == jl_refresh) {
			fillTable(new Student());
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
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "添加" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "删除" + "</font></html>");
		} else if (e.getSource() == jl_update) {
			jl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_update.setText("<html><font color='#336699' style='font-weight:bold'>" + "修改" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "刷新" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("添加");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("删除");
		} else if (e.getSource() == jl_update) {
			jl_update.setText("修改");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setText("刷新");
		}
	}
	// public void fillTable(Student student){
	// this.student=student;
	// dm=(DefaultTableModel) jt_score.getModel();
	// dm.setRowCount(0);
	// //"课程编号","课程名称","学分","授课教师","学科门类","成绩"
	// List<StudentCourse> list=new
	// StudentCourseDao().selectStudentCourseListByStudent(student);
	// for(StudentCourse st:list){
	// Vector<Object> v=new Vector<>();
	//
	// Course course=st.getCourse();
	// v.add(course.getCno());
	// v.add(course.getCname());
	// v.add(course.getCmark());
	//
	// Teacher t=course.getTeacher();
	// v.add(t.getTname());
	//
	// v.add(course.getCkind());
	//
	// int score=st.getCscore();
	// if(score==-1) v.add("成绩未公布");
	// else v.add(score);
	//
	// dm.addRow(v);
	//
	// }
	// }

}
