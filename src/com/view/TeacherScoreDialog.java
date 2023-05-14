package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.StudentCourseDao;
import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.util.Location;
import com.util.MyFont;

public class TeacherScoreDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_cno;
	private JTextField jtf_cname;
	private JTextField jtf_cmark;
	private JTextField jtf_sno;
	private JTextField jtf_sname;
	private JTextField jtf_cscore;
	StudentCourse sc;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public TeacherScoreDialog(StudentCourse sc) {
		this.setTitle("教师课程信息");
		this.sc = sc;
		setSize(425, 483);
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel jl_cno = new JLabel("\u8BFE\u7A0B\u7F16\u53F7:");
		jl_cno.setBounds(70, 78, 71, 30);
		contentPanel.add(jl_cno);
		jl_cno.setFont(MyFont.getMyFont());

		JLabel jl_cname = new JLabel("\u8BFE\u7A0B\u540D\u79F0:");
		jl_cname.setBounds(70, 134, 71, 30);
		contentPanel.add(jl_cname);
		jl_cname.setFont(MyFont.getMyFont());

		JLabel jl_cmark = new JLabel("\u5B66       \u5206:");
		jl_cmark.setBounds(70, 180, 71, 30);
		contentPanel.add(jl_cmark);
		jl_cmark.setFont(MyFont.getMyFont());

		JLabel jl_sno = new JLabel("\u5B66       \u53F7:");
		jl_sno.setBounds(70, 228, 71, 30);
		contentPanel.add(jl_sno);
		jl_sno.setFont(MyFont.getMyFont());

		JLabel jl_sname = new JLabel("\u59D3       \u540D:");
		jl_sname.setBounds(70, 279, 71, 30);
		contentPanel.add(jl_sname);
		jl_sname.setFont(MyFont.getMyFont());

		JLabel jl_cscore = new JLabel("\u6210       \u7EE9:");
		jl_cscore.setBounds(70, 333, 71, 30);
		contentPanel.add(jl_cscore);
		jl_cscore.setFont(MyFont.getMyFont());

		jtf_cno = new JTextField();
		jtf_cno.setBounds(151, 79, 160, 30);
		contentPanel.add(jtf_cno);
		jtf_cno.setColumns(10);
		jtf_cno.setFont(MyFont.getMyFont());

		jtf_cname = new JTextField();
		jtf_cname.setColumns(10);
		jtf_cname.setBounds(151, 135, 160, 30);
		contentPanel.add(jtf_cname);
		jtf_cname.setFont(MyFont.getMyFont());

		jtf_cmark = new JTextField();
		jtf_cmark.setColumns(10);
		jtf_cmark.setBounds(151, 181, 160, 30);
		contentPanel.add(jtf_cmark);
		jtf_cmark.setFont(MyFont.getMyFont());

		jtf_sno = new JTextField();
		jtf_sno.setColumns(10);
		jtf_sno.setBounds(151, 229, 160, 30);
		contentPanel.add(jtf_sno);
		jtf_sno.setFont(MyFont.getMyFont());

		jtf_sname = new JTextField();
		jtf_sname.setColumns(10);
		jtf_sname.setBounds(151, 280, 160, 30);
		contentPanel.add(jtf_sname);
		jtf_sname.setFont(MyFont.getMyFont());

		jtf_cscore = new JTextField();
		jtf_cscore.setColumns(10);
		jtf_cscore.setBounds(151, 334, 160, 30);
		contentPanel.add(jtf_cscore);
		jtf_cscore.setFont(MyFont.getMyFont());

		JLabel jl_logo = new JLabel("\u6210\u7EE9\u5F55\u5165");
		jl_logo.setFont(new Font("方正舒体", Font.BOLD, 30));
		jl_logo.setBounds(151, 10, 160, 47);
		contentPanel.add(jl_logo);

		JButton jb_submit = new JButton("\u63D0\u4EA4");
		jb_submit.setBounds(151, 391, 100, 30);
		contentPanel.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setValues(sc);
		setVisible(true);
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String score = jtf_cscore.getText();
				int cscore = 0;
				if ("".equals(cscore)) {
					cscore = -1;
				} else {
					try {
						cscore = Integer.valueOf(score);
						if (cscore < 0 || cscore > 100) {
							JOptionPane.showMessageDialog(TeacherScoreDialog.this, "输入的数字有误");
							return;
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(TeacherScoreDialog.this, "输入的数字成绩有误");
						return;
					}
				}
				sc.setCscore(cscore);
				int flag = new StudentCourseDao().updateStudentCourse(sc);
				if (flag == 0) {
					JOptionPane.showMessageDialog(TeacherScoreDialog.this, "保存失败");
					return;
				} else {
					JOptionPane.showMessageDialog(TeacherScoreDialog.this, "成功");
					TeacherScoreDialog.this.dispose();
					return;
				}

			}

		});
	}

	public void setValues(StudentCourse sc) {
		Course c = sc.getCourse();
		Student s = sc.getStudent();
		jtf_cno.setText(c.getCno());
		jtf_cno.setEditable(false);

		jtf_cname.setText(c.getCname());
		jtf_cname.setEditable(false);

		jtf_cmark.setText(c.getCmark() + "");
		jtf_cmark.setEditable(false);
		jtf_sno.setText(s.getSno());
		jtf_sno.setEditable(false);
		jtf_sname.setText(s.getSname());
		jtf_sname.setEditable(false);

		int cscore = sc.getCscore();
		if (cscore == -1)
			jtf_cscore.setText("");
		else
			jtf_cscore.setText(cscore + "");

	}
}
