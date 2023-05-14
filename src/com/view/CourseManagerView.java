package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import com.dao.StudentCourseDao;
import com.eltima.components.ui.DatePicker;
import com.entity.Course;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;
import com.eltima.components.ui.DatePicker;
public class CourseManagerView extends JPanel implements MouseListener {
	//private JTextField jtf_name;
	
	JTable jt_course;
	JButton jb_submit;
	JComboBox jc_kind;
	JLabel jl_add;
	JLabel jl_del;
	JLabel jl_update;
	DefaultTableModel dm;
	private JLabel jl_refresh;

	public void fillTable(Course course) {
		dm = (DefaultTableModel) jt_course.getModel();
		dm.setRowCount(0);

		List<Course> list = new CourseDao().selectCourseList(course);
		;
		for (Course st : list) {
			Vector<Object> v = new Vector<>();
			v.add(st.getCno());
			v.add(st.getCname());
			v.add(st.getCmark());
			// Teacher t=new TeacherBussImpl().getTeacher(st.getTeacher());
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

	public CourseManagerView() {
		setLayout(new BorderLayout(0, 0));

		JPanel jp_tool = new JPanel();
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setPreferredSize(new Dimension(960, 50));
		jp_tool.setLayout(null);

		jb_submit = new JButton("查询");
		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb_submit.setBounds(876, 11, 100, 30);
		jp_tool.add(jb_submit);

		jc_kind = new JComboBox();
		jc_kind.setBounds(749, 10, 100, 30);
		jp_tool.add(jc_kind);
		jc_kind.setFont(MyFont.getMyFont());

		JLabel jl_kind = new JLabel("课程类别:");
		jl_kind.setBounds(679, 10, 60, 30);
		jp_tool.add(jl_kind);
		jl_kind.setFont(MyFont.getMyFont());

		final DatePicker datepick;
	    datepick = getDatePicker();
	    datepick.setBounds(400, 10, 150, 30);
	    jp_tool.add( datepick);
		
		
//		jtf_name = new JTextField();
//		jtf_name.setBounds(556, 10, 100, 30);
//		jp_tool.add(jtf_name);
//		jtf_name.setColumns(10);
//		jtf_name.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("选课时间:");
		jl_name.setBounds(330, 10, 150, 30);
		jp_tool.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());
		
		JButton jb_submit1 = new JButton("设置");
		jb_submit1.setBounds(570, 10, 70, 30);
		jp_tool.add(jb_submit1);
		jb_submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				new StudentCourseDao().updateselectcoursetime(sdf.format(datepick.getValue()));
				JOptionPane.showMessageDialog(new JFrame(),
						"<html>选课时间已设定为：<br><h1><font color=green>"+ sdf.format(datepick.getValue())+"</font></h1></html>");
			}
		});

		jl_add = new JLabel("\u6DFB\u52A0");
		jl_add.setBounds(10, 10, 60, 30);
		jp_tool.add(jl_add);
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);

		jl_del = new JLabel("\u5220\u9664");
		jl_del.setBounds(80, 10, 60, 30);
		jp_tool.add(jl_del);
		jl_del.setFont(MyFont.getMyFont());
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);

		jl_update = new JLabel("\u4FEE\u6539");
		jl_update.setBounds(150, 10, 60, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);

		jc_kind.addItem("--请选择--");

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setBounds(217, 11, 60, 30);
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		jp_tool.add(jl_refresh);
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
		this.add(js, BorderLayout.CENTER);
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//String cname = jtf_name.getText().trim();
				//String kind = ((String) jc_kind.getSelectedItem()).trim();

//				Course course = new Course();
//				course.setCname(cname);
//				if (!("--请选择--").equals(kind))
//					course.setCkind(kind);
				//fillTable(course);

			}

		});

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_course.getSelectedRow();
		if (e.getSource() == jl_add) {
			Course st = new Course();
			new CourseDialogView(st, 0);

		} else if (e.getSource() == jl_del && row >= 0) {

			Course c = new Course();
			c.setCno((String) (jt_course.getValueAt(row, 0)));
			Course s = new CourseDao().selectCourse(c);
			new CourseDialogView(s, 1);
		} else if (e.getSource() == jl_update && row >= 0) {
			Course c = new Course();
			c.setCno((String) (jt_course.getValueAt(row, 0)));
			Course s = new CourseDao().selectCourse(c);
			new CourseDialogView(s, 2);
		} else if (e.getSource() == jl_refresh) {
			fillTable(new Course());
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

	public static void main(String args[])

	{
		JFrame jf = new JFrame();
		CourseManagerView cmv = new CourseManagerView();
		jf.add(cmv);
		jf.setSize(700, 700);
		jf.setVisible(true);

	}
	
	private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd HH:mm:ss";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times New Roman", Font.BOLD, 14);
   
        Dimension dimension = new Dimension(177, 24);
   
        int[] hilightDays = { 1, 3, 5, 7 };
   
        int[] disabledDays = { 4, 6, 5, 9 };
   
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
   
        datepick.setLocation(137, 83);
        datepick.setBounds(137, 83, 177, 24);
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
        datepick.setTimePanleVisible(true);
        return datepick;
    }
}
