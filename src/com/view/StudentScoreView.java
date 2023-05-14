package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.StudentCourseDao;
import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.entity.Teacher;
import com.util.TabelSetting;
import com.util.TableColums;

public class StudentScoreView extends JPanel {
	public static void main(String args[]) {
		Student t = new Student();
		t.setSno("1");
		StudentScoreView a = new StudentScoreView(t);
		JFrame jf = new JFrame();
		jf.add(a);
		jf.setSize(1000, 600);
		jf.setVisible(true);
	}

	/**
	 * Create the panel.
	 */
	JTable jt_score;
	Student student;
	DefaultTableModel dm;

	public void fillTable(Student student) {
		this.student = student;
		dm = (DefaultTableModel) jt_score.getModel();
		dm.setRowCount(0);
		// "课程编号","课程名称","学分","授课教师","学科门类","成绩"
		List<StudentCourse> list = new StudentCourseDao().selectStudentCourseListByStudent(student);
		for (StudentCourse st : list) {

			Course course = st.getCourse();
			Teacher t = course.getTeacher();

			String color1 = "blank";
			int score = st.getCscore();
			if (new StudentCourseDao().SelectStatu(student.getSno(), course.getCno()) > 0) {
				if (score >= 60)
					color1 = "green";
				else
					color1 = "red";
			}
			Vector<Object> v = new Vector<>();
			v.add("<html><font color='" + color1 + "'>" + course.getCno() + "</font></html>");
			v.add("<html><font color='" + color1 + "'>" + course.getCname() + "</font></html>");
			v.add("<html><font color='" + color1 + "'>" + course.getCmark() + "</font></html>");

			v.add("<html><font color='" + color1 + "'>" + t.getTname() + "</font></html>");

			v.add("<html><font color='" + color1 + "'>" + course.getCkind() + "</font></html>");

			if (new StudentCourseDao().SelectStatu(student.getSno(), course.getCno()) > 0) {
				v.add("<html><font color='" + color1 + "'>" + score + "</font></html>");

			} else
				v.add("<html><font color='" + color1 + "'>" + "成绩未公布" + "</font></html>");

			dm.addRow(v);

		}
	}

	public StudentScoreView(Student student) {
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 30));
		add(panel, BorderLayout.NORTH);

		jt_score = new JTable(new DefaultTableModel(TableColums.getScoreColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_score.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_score.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_score);
		fillTable(student);
		setLayout(new BorderLayout(0, 0));
		JScrollPane js = new JScrollPane(jt_score);
		this.add(js, BorderLayout.CENTER);
	}
}
