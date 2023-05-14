package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class CourseAlSelectView extends JPanel implements MouseListener {

	/**
	 * Create the panel.
	 */
	JLabel jl_refresh;
	JTable jt_course;
	JLabel jl_del;
	DefaultTableModel dm;
	Student student = null;

	public void fillTable(Student student) {
		this.student = student;
		dm = (DefaultTableModel) jt_course.getModel();
		dm.setRowCount(0);
		// "¿Î³Ì±àºÅ","¿Î³ÌÃû³Æ","Ñ§·Ö","ÊÚ¿Î½ÌÊ¦","Ñ§¿ÆÃÅÀà","¿Î³ÌÃèÊö"
		List<StudentCourse> list = new StudentCourseDao().selectStudentCourseListByStudent(student);
		for (StudentCourse st : list) {
			Vector<Object> v = new Vector<Object>();

			Course course = st.getCourse();
			v.add(course.getCno());
			v.add(course.getCname());
			v.add(course.getCmark());

			Teacher t = course.getTeacher();
			v.add(t.getTname());

			v.add(course.getCkind());
			v.add(course.getCdesc());
			dm.addRow(v);

		}
	}

	public CourseAlSelectView(Student student) {
		this.setPreferredSize(new Dimension(1000, 550));

		jt_course = new JTable(new DefaultTableModel(TableColums.getSelectColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_course.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_course.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_course);

		fillTable(student);
		setLayout(new BorderLayout(0, 0));
		JScrollPane js = new JScrollPane(jt_course);
		this.add(js, BorderLayout.CENTER);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(1000, 50));

		this.add(jp, BorderLayout.NORTH);
		jp.setLayout(null);

		jl_refresh = new JLabel("Ë¢ÐÂ");
		jl_refresh.setBounds(10, 10, 54, 30);
		jp.add(jl_refresh);
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));

		jl_del = new JLabel("É¾³ý");
		jl_del.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		jl_del.setBounds(77, 10, 54, 30);
		jp.add(jl_del);
		jl_del.setIcon(new ImageIcon("image/delete.png"));

		jl_del.addMouseListener(this);
		jl_refresh.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_course.getSelectedRow();
		if (e.getSource() == jl_refresh) {
			fillTable(student);
		} else if (e.getSource() == jl_del && row >= 0) {
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setStudent(student);

			String cno = (String) jt_course.getValueAt(row, 0);
			Course course = new Course();
			course.setCno(cno);
			studentCourse.setCourse(course);

			int flag = new StudentCourseDao().delStudentCourse(studentCourse);
			if (flag == 0) {
				JOptionPane.showMessageDialog(CourseAlSelectView.this, "É¾³ýÊ§°Ü");
				return;
			} else {
				JOptionPane.showMessageDialog(CourseAlSelectView.this, "É¾³ý³É¹¦");
				return;
			}
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
		if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "Ë¢ÐÂ" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "É¾³ý" + "</font></html>");
		} else {

		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jl_refresh) {
			jl_refresh.setText("Ë¢ÐÂ");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("É¾³ý");
		} else {

		}
	}

}
