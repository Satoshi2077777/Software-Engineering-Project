package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.StudentCourseDao;
import com.entity.Course;
import com.entity.StudentCourse;
import com.util.CommboxData;
import com.util.Location;
import com.util.MyFont;

public class SelectCourseDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_cno;
	private JTextField jtf_cname;
	private JTextField jtf_cmark;
	private JTextField jtf_tno;
	private JTextField jtf_cplace;
	private JTextField jtf_cdesc;
	JComboBox jc_ckind;
	JComboBox jc_day;
	JComboBox jc_week;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public SelectCourseDialog(StudentCourse studentCourse) {
		this.setTitle("选课信息");
		setSize(468, 504);
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel jl_cno = new JLabel("\u8BFE\u7A0B\u7F16\u53F7:");
			jl_cno.setBounds(74, 87, 68, 30);
			contentPanel.add(jl_cno);
			jl_cno.setFont(MyFont.getMyFont());
		}

		JLabel jl_name = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		jl_name.setBounds(74, 127, 68, 30);
		contentPanel.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		JLabel jl_mark = new JLabel("\u8BFE\u7A0B\u5B66\u5206:");
		jl_mark.setBounds(74, 171, 68, 30);
		contentPanel.add(jl_mark);
		jl_mark.setFont(MyFont.getMyFont());

		JLabel jl_tno = new JLabel("\u6559\u5E08\u5DE5\u53F7:");
		jl_tno.setBounds(74, 211, 68, 30);
		contentPanel.add(jl_tno);
		jl_tno.setFont(MyFont.getMyFont());

		JLabel jl_time = new JLabel("\u6559\u5B66\u65F6\u95F4:");
		jl_time.setBounds(74, 251, 68, 30);
		contentPanel.add(jl_time);
		jl_time.setFont(MyFont.getMyFont());

		JLabel jl_place = new JLabel("\u6559\u5B66\u5730\u70B9:");
		jl_place.setBounds(74, 291, 68, 30);
		contentPanel.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());
		JLabel jl_kind = new JLabel("\u8BFE\u7A0B\u95E8\u7C7B:");
		jl_kind.setBounds(74, 331, 68, 30);
		contentPanel.add(jl_kind);
		jl_kind.setFont(MyFont.getMyFont());

		JLabel jl_desc = new JLabel("\u8BFE\u7A0B\u63CF\u8FF0:");
		jl_desc.setBounds(74, 371, 68, 30);
		contentPanel.add(jl_desc);
		jl_desc.setFont(MyFont.getMyFont());

		JLabel lblNewLabel = new JLabel("\u8BFE \u7A0B \u4FE1 \u606F");
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 27, 254, 50);
		contentPanel.add(lblNewLabel);

		jtf_cno = new JTextField();
		jtf_cno.setBounds(158, 87, 205, 30);
		contentPanel.add(jtf_cno);
		jtf_cno.setColumns(10);
		jtf_cno.setFont(MyFont.getMyFont());

		jtf_cname = new JTextField();
		jtf_cname.setColumns(10);
		jtf_cname.setBounds(158, 128, 205, 30);
		contentPanel.add(jtf_cname);
		jtf_cname.setFont(MyFont.getMyFont());

		jtf_cmark = new JTextField();
		jtf_cmark.setColumns(10);
		jtf_cmark.setBounds(158, 172, 205, 30);
		contentPanel.add(jtf_cmark);
		jtf_cmark.setFont(MyFont.getMyFont());

		jtf_tno = new JTextField();
		jtf_tno.setColumns(10);
		jtf_tno.setBounds(158, 212, 205, 30);
		contentPanel.add(jtf_tno);
		jtf_tno.setFont(MyFont.getMyFont());

		jtf_cplace = new JTextField();
		jtf_cplace.setColumns(10);
		jtf_cplace.setBounds(158, 292, 205, 30);
		contentPanel.add(jtf_cplace);
		jtf_cplace.setFont(MyFont.getMyFont());

		jtf_cdesc = new JTextField();
		jtf_cdesc.setColumns(10);
		jtf_cdesc.setBounds(158, 372, 205, 30);
		contentPanel.add(jtf_cdesc);
		jtf_cdesc.setFont(MyFont.getMyFont());

		JButton jb_submit = new JButton("确认选课信息");
		jb_submit.setBounds(158, 426, 140, 30);
		contentPanel.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jc_week = new JComboBox();
		jc_week.setBounds(158, 252, 95, 30);
		jc_week.setFont(MyFont.getMyFont());
		contentPanel.add(jc_week);
		jc_week.addItem("--请选择--");
		String[] weeks = CommboxData.getWeeks();
		for (String data : weeks) {
			jc_week.addItem(data);
		}

		jc_day = new JComboBox();
		jc_day.setFont(MyFont.getMyFont());
		jc_day.addItem("--请选择--");
		String[] days = CommboxData.getDays();
		for (String data : days) {
			jc_day.addItem(data);
		}

		jc_day.setBounds(264, 252, 99, 30);
		contentPanel.add(jc_day);

		jc_ckind = new JComboBox();
		jc_ckind.setBounds(158, 331, 205, 30);
		contentPanel.add(jc_ckind);
		jc_ckind.setFont(MyFont.getMyFont());
		jc_ckind.addItem("--请选择--");
		String[] kinds = CommboxData.getSubjects();
		for (String data : kinds) {
			jc_ckind.addItem(data);
		}

		this.setValues(studentCourse.getCourse());
		setEdit();
		jb_submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				StudentCourse sc = new StudentCourseDao().selectStudentCourse(studentCourse);

				if (sc != null) {
					System.out.println(sc.getCourse().getCno());
					JOptionPane.showMessageDialog(SelectCourseDialog.this, "该课程已选");
					SelectCourseDialog.this.dispose();
					return;
				}

				int flag = new StudentCourseDao().insertStudentCourse(studentCourse);

				if (flag == 0) {
					JOptionPane.showMessageDialog(SelectCourseDialog.this,
							"<html>选课失败可能未到选课时间,时间为<br><h1><font color=red>7-18~7-20</font></h1></html>");
					return;
				} else {
					JOptionPane.showMessageDialog(SelectCourseDialog.this, "选课成功");
					SelectCourseDialog.this.dispose();
					return;
				}
			}

		});

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void setValues(Course c) {

		jtf_cname.setText(c.getCname());
		jtf_cno.setText(c.getCno());
		jtf_tno.setText(c.getTeacher().getTno());
		jtf_cmark.setText(c.getCmark() + "");
		jtf_cplace.setText(c.getCplace());
		jc_ckind.setSelectedItem(c.getCkind());
		jtf_cdesc.setText(c.getCdesc());
		String ctime = c.getCtime();
		if (ctime != null) {
			String[] times = ctime.split(",");
			String week = "星期" + times[0];
			jc_day.setSelectedItem(times[1]);
			jc_week.setSelectedItem(week);
		} else {
			jc_week.setSelectedItem("");
			jc_day.setSelectedItem("");
		}

	}

	public void setEdit() {
		jtf_cname.setEditable(false);
		jtf_cno.setEditable(false);
		jtf_cmark.setEditable(false);
		jtf_cplace.setEditable(false);
		jtf_cdesc.setEditable(false);
		jtf_cno.setEditable(false);
		jc_week.setEnabled(false);
		jc_day.setEnabled(false);
	}
}
