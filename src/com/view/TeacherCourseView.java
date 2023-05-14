package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.CourseDao;
import com.entity.Course;
import com.entity.Teacher;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class TeacherCourseView extends JPanel implements MouseListener {

	/**
	 * Create the panel.
	 */
	JTable jt_course;
	JLabel jl_refresh;
	Teacher t;
	DefaultTableModel dm;

	public void fillTable(Teacher t) {
		dm = (DefaultTableModel) jt_course.getModel();
		dm.setRowCount(0);

		List<Course> list = new CourseDao().selectCourseListByTeacher(t);
		for (Course st : list) {
			Vector<Object> v = new Vector<>();
			v.add(st.getCno());
			v.add(st.getCname());
			v.add(st.getCmark());
			// Teacher t=new TeacherBussImpl().getTeacher(st.getTeacher());
			v.add(t.getTname());
			v.add(st.getCkind());
			v.add(st.getCdesc());
			dm.addRow(v);
		}
	}

	public TeacherCourseView(Teacher t) {
		this.t = t;
		this.setSize(new Dimension(1000, 550));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 50));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(null);

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setBounds(10, 10, 54, 30);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.setFont(MyFont.getMyFont());
		panel.add(jl_refresh);

		jt_course = new JTable(new DefaultTableModel(TableColums.getTeacherCourseColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_course.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_course.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_course);

		fillTable(t);
		JScrollPane js = new JScrollPane(jt_course);
		this.add(js, BorderLayout.CENTER);
		jl_refresh.addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == jl_refresh) {
			fillTable(t);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "Ë¢ÐÂ" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_refresh) {
			jl_refresh.setText("Ë¢ÐÂ");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
