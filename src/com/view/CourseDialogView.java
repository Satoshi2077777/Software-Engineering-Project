package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.CourseDao;
import com.dao.TeacherDao;
import com.entity.Course;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.FormCheck;
import com.util.Location;
import com.util.MyFont;

public class CourseDialogView extends JDialog {

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
	JLabel jl_cno_1;
	JLabel jl_name_1;
	JLabel jl_mark_1;
	JLabel jl_tno_1;
	JLabel jl_time_1;
	JLabel jl_place_1;
	JLabel jl_kind_1;
	JLabel jl_desc_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public CourseDialogView(Course course, int flag) {
		setSize(483, 504);
		Location.setCenter(this);
		this.setTitle("课程信息");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel jl_cno = new JLabel("课程编号:");
			jl_cno.setBounds(74, 87, 68, 30);
			contentPanel.add(jl_cno);
			jl_cno.setFont(MyFont.getMyFont());
		}

		JLabel jl_name = new JLabel("课程名称:");
		jl_name.setBounds(74, 127, 68, 30);
		contentPanel.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		JLabel jl_mark = new JLabel("课程学分:");
		jl_mark.setBounds(74, 171, 68, 30);
		contentPanel.add(jl_mark);
		jl_mark.setFont(MyFont.getMyFont());

		JLabel jl_tno = new JLabel("教师编号:");
		jl_tno.setBounds(74, 211, 68, 30);
		contentPanel.add(jl_tno);
		jl_tno.setFont(MyFont.getMyFont());

		JLabel jl_time = new JLabel("上课时间:");
		jl_time.setBounds(74, 251, 68, 30);
		contentPanel.add(jl_time);
		jl_time.setFont(MyFont.getMyFont());

		JLabel jl_place = new JLabel("上课地点:");
		jl_place.setBounds(74, 291, 68, 30);
		contentPanel.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());
		JLabel jl_kind = new JLabel("课程类别:");
		jl_kind.setBounds(74, 331, 68, 30);
		contentPanel.add(jl_kind);
		jl_kind.setFont(MyFont.getMyFont());

		JLabel jl_desc = new JLabel("课程描述:");
		jl_desc.setBounds(74, 371, 68, 30);
		contentPanel.add(jl_desc);
		jl_desc.setFont(MyFont.getMyFont());

		JLabel lblNewLabel = new JLabel("\u8BFE \u7A0B \u4FE1 \u606F");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 33));
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

		JButton jb_submit = new JButton("New button");
		jb_submit.setBounds(181, 426, 100, 30);
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

		jl_cno_1 = new JLabel("");
		jl_cno_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_cno_1.setBounds(373, 87, 84, 30);
		contentPanel.add(jl_cno_1);

		jl_name_1 = new JLabel("");
		jl_name_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_name_1.setBounds(373, 127, 84, 30);
		contentPanel.add(jl_name_1);

		jl_mark_1 = new JLabel("");
		jl_mark_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_mark_1.setBounds(373, 171, 84, 30);
		contentPanel.add(jl_mark_1);

		jl_tno_1 = new JLabel("");
		jl_tno_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_tno_1.setBounds(373, 211, 84, 30);
		contentPanel.add(jl_tno_1);

		jl_time_1 = new JLabel("");
		jl_time_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_time_1.setBounds(373, 251, 84, 30);
		contentPanel.add(jl_time_1);

		jl_place_1 = new JLabel("");
		jl_place_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_place_1.setBounds(373, 291, 84, 30);
		contentPanel.add(jl_place_1);

		jl_kind_1 = new JLabel("");
		jl_kind_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_kind_1.setBounds(373, 331, 84, 30);
		contentPanel.add(jl_kind_1);

		jl_desc_1 = new JLabel("");
		jl_desc_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_desc_1.setBounds(373, 371, 84, 30);
		contentPanel.add(jl_desc_1);
		String[] kinds = CommboxData.getSubjects();
		for (String data : kinds) {
			jc_ckind.addItem(data);
		}

		if (flag == 0) {
			jb_submit.setText("添加");
		} else if (flag == 1) {
			jb_submit.setText("删除");

			setValues(course);
			setEdit();
		} else if (flag == 2) {
			jb_submit.setText("修改");
			jtf_cno.setEnabled(false);
			setValues(course);
		} else {

		}
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(CourseDialogView.this, "有未输入的值");
						return;
					}
					Course c = getCourse();
					Course t = new CourseDao().selectCourse(c);
					int i = new CourseDao().insertCourse(c);
					if (i == 1) {
						JOptionPane.showMessageDialog(CourseDialogView.this, "添加成功");
						CourseDialogView.this.dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(CourseDialogView.this, "添加失败");
					}
				} else if (flag == 1) {
					int i = new CourseDao().delCourse(course);
					;
					if (i == 0) {
						JOptionPane.showMessageDialog(CourseDialogView.this, "删除失败");
					} else {
						JOptionPane.showMessageDialog(CourseDialogView.this, "删除成功");
					}
					CourseDialogView.this.dispose();
					return;
				} else if (flag == 2) {
					Course course = getCourse();
					if (!isNull()) {
						JOptionPane.showMessageDialog(CourseDialogView.this, "有未输入的值");
						return;
					}
					int update = new CourseDao().updateCourse(course);
					if (update == 0) {
						JOptionPane.showMessageDialog(CourseDialogView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(CourseDialogView.this, "修改成功");
						CourseDialogView.this.dispose();
						return;
					}
				}
			}

		});

		jtf_cno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!FormCheck.isCno((jtf_cno.getText()))) {
					jl_cno_1.setIcon(new ImageIcon("image/no.png"));
					jl_cno_1.setText("五位数字");
					return;
				}
				Course course = new Course();
				course.setCno(jtf_cno.getText());
				Course c = new CourseDao().selectCourse(course);
				if (c != null) {
					jl_cno_1.setIcon(new ImageIcon("image/no.png"));
					jl_cno_1.setText("已存在");
					return;
				} else {
					jl_cno_1.setIcon(new ImageIcon("image/yes.png"));
					jl_cno_1.setText("");
				}

			}

		});
		jtf_cname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!(FormCheck.isName((jtf_cname.getText())))) {
					jl_name_1.setIcon(new ImageIcon("image/no.png"));
					jl_name_1.setText("");
					return;
				} else {
					jl_name_1.setIcon(new ImageIcon("image/yes.png"));
				}

			}

		});
		jtf_cmark.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (!(FormCheck.isMark(jtf_cmark.getText()))) {
					jl_mark_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_mark_1.setIcon(new ImageIcon("image/yes.png"));
				}
			}

		});
		jtf_tno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = jtf_tno.getText();
				Teacher t = new Teacher();
				t.setTno(str);
				Teacher te = new TeacherDao().selectTeacher(t);
				if (te == null) {
					jl_tno_1.setText("不存在");
					jl_tno_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_tno_1.setText("");
					jl_tno_1.setIcon(new ImageIcon("image/yes.png"));
				}

			}

		});

		jtf_cplace.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				if ("--请选择--".equals((String) jc_week.getSelectedItem())
						|| "--请选择--".equals((String) jc_day.getSelectedItem())) {
					jl_time_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_time_1.setIcon(new ImageIcon("image/yes.png"));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if ("".equals(jtf_cplace.getText())) {
					jl_place_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_place_1.setIcon(new ImageIcon("image/yes.png"));
				}
			}

		});

		jtf_cdesc.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if ("--请选择--".equals(jc_ckind.getSelectedItem())) {
					jl_kind_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_kind_1.setIcon(new ImageIcon("image/yes.png"));
					return;
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!(FormCheck.isName(jtf_cdesc.getText()))) {
					jl_desc_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_desc_1.setIcon(new ImageIcon("image/yes.png"));
				}

			}

		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public Course getCourse() {
		Course course = new Course();
		course.setCno(jtf_cno.getText());
		course.setCname((jtf_cname).getText());
		course.setCmark(Integer.parseInt(jtf_cmark.getText()));
		course.setCkind((String) jc_ckind.getSelectedItem());
		course.setCdesc(jtf_cdesc.getText());
		course.setCplace(jtf_cplace.getText());

		Teacher t = new Teacher();
		t.setTno(jtf_tno.getText());
		course.setTeacher(t);
		String time = (((String) jc_week.getSelectedItem()).replace("星期", "")) + ","
				+ (String) (jc_day.getSelectedItem());
		course.setCtime(time);
		return course;

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

	public boolean isNull() {
		String name = jtf_cname.getText();
		String cno = jtf_cno.getText();
		String tno = jtf_tno.getText();
		String cmark = jtf_cmark.getText();
		String place = jtf_cplace.getText();
		String cdesc = jtf_cdesc.getText();
		String ckind = (String) jc_ckind.getSelectedItem();
		String week = (String) jc_week.getSelectedItem();
		String day = (String) jc_day.getSelectedItem();

		if ("".equals(name) || name == null)
			return false;
		if ("".equals(cno) || cno == null)
			return false;
		if ("".equals(tno) || tno == null)
			return false;
		if ("".equals(cmark) || cmark == null)
			return false;
		if ("".equals(week) || week == null || "--请选择--".equals(week))
			return false;
		if ("".equals(day) || day == null || "--请选择--".equals(day))
			return false;

		if ("".equals(ckind) || ckind == null || "--请选择--".equals(ckind))
			return false;
		if ("".equals(cdesc) || cdesc == null)
			return false;
		if ("".equals(place) || place == null)
			return false;
		return true;

	}

	public void setEdit() {
		jtf_cname.setEnabled(false);
		jtf_cno.setEnabled(false);
		jtf_cmark.setEnabled(false);
		jtf_cplace.setEnabled(false);
		jtf_cdesc.setEnabled(false);
		jtf_cno.setEnabled(false);
		jc_week.setEnabled(false);
		jc_day.setEnabled(false);
		jtf_tno.setEnabled(false);
	}

	public static void main(String args[]) {
		JFrame jf = new JFrame();
		CourseDialogView cdv = new CourseDialogView(new Course(), 0);
		;
		jf.add(cdv);
		jf.setSize(700, 700);
		jf.setVisible(true);
	}
}
