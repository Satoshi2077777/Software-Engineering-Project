package com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.DepartDao;
import com.dao.StudentDao;
import com.entity.Depart;
import com.entity.Student;
import com.util.CommboxData;
import com.util.FormCheck;
import com.util.FormatToDate;
import com.util.Location;
import com.util.MyFont;

public class StudentInformationDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_sno;
	JLabel jl_sno_1;
	private JTextField jtf_name;
	private JTextField jtf_birth;
	JLabel jl_sex_1;
	private JTextField jtf_tele;
	JLabel jl_tele_1;
	JLabel jl_birth_1;
	JLabel jl_nation_1;
	private JTextField jtf_nation;
	private JTextField jtf_place;
	JComboBox jc_department;
	JComboBox jc_major;
	JComboBox jc_class;
	JLabel jl_department_1;
	JLabel jl_major_1;
	JLabel jl_name_1;
	JLabel jl_place_1;
	JRadioButton rb_boy;
	JRadioButton rb_gril;
	JLabel jl_class_1;
	Student s;
	int flag;

	public StudentInformationDialog(Student s, int flag) {
		setForeground(new Color(0, 255, 204));
		this.s = s;
		this.flag = flag;
		setSize(504, 684);
		this.setTitle("学生信息");
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel jl_logo = new JLabel("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
			jl_logo.setBackground(new Color(51, 204, 153));
			jl_logo.setHorizontalAlignment(SwingConstants.CENTER);
			jl_logo.setFont(new Font("微软雅黑", Font.BOLD, 30));
			jl_logo.setBounds(167, 10, 199, 43);
			contentPanel.add(jl_logo);
		}
		{
			JLabel jl_sno = new JLabel("\u5B66       \u53F7:");
			jl_sno.setBounds(83, 74, 79, 30);
			contentPanel.add(jl_sno);
		}
		{
			JLabel jl_name = new JLabel("\u59D3       \u540D:");
			jl_name.setBounds(83, 127, 79, 30);
			contentPanel.add(jl_name);
		}
		{
			JLabel jl_sex = new JLabel("\u6027       \u522B:");
			jl_sex.setBounds(83, 176, 79, 30);
			contentPanel.add(jl_sex);
		}
		{
			JLabel jl_birth = new JLabel("\u51FA\u751F\u65E5\u671F:");
			jl_birth.setBounds(83, 216, 65, 30);
			contentPanel.add(jl_birth);
		}
		{
			JLabel jl_tele = new JLabel("\u8054\u7CFB\u7535\u8BDD:");
			jl_tele.setBounds(83, 264, 65, 30);
			contentPanel.add(jl_tele);
		}
		{
			JLabel jl_nation = new JLabel("\u6C11       \u65CF: ");
			jl_nation.setBounds(83, 314, 79, 30);
			contentPanel.add(jl_nation);
		}
		{
			JLabel jl_major = new JLabel("\u4E13       \u4E1A:");
			jl_major.setBounds(83, 417, 79, 30);
			contentPanel.add(jl_major);
		}
		{
			JLabel jl_class = new JLabel("\u73ED       \u7EA7:");
			jl_class.setBounds(83, 469, 72, 30);
			contentPanel.add(jl_class);
		}
		{
			JLabel jl_department = new JLabel("\u9662       \u7CFB:");
			jl_department.setBounds(83, 365, 72, 30);
			contentPanel.add(jl_department);
		}
		{
			JLabel jl_place = new JLabel("\u7C4D       \u8D2F:");
			jl_place.setBounds(83, 520, 79, 30);
			contentPanel.add(jl_place);
		}

		jtf_sno = new JTextField();
		jtf_sno.setBounds(172, 74, 180, 30);
		contentPanel.add(jtf_sno);
		jtf_sno.setColumns(10);
		jtf_sno.setFont(MyFont.getMyFont());

		jl_sno_1 = new JLabel("");
		jl_sno_1.setBounds(370, 74, 94, 30);
		contentPanel.add(jl_sno_1);

		jtf_sno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String sno = jtf_sno.getText();
				if (!FormCheck.isSno(sno)) {
					jl_sno_1.setIcon(new ImageIcon("image/no.png"));
					jl_sno_1.setText("10位数字");
					return;
				}
				Student st = new Student();
				st.setSno(sno);
				Student s = new StudentDao().selectStudent(st);
				if (s != null) {
					jl_sno_1.setIcon(new ImageIcon("image/no.png"));
					jl_sno_1.setText("学号已存在");
					return;
				}
				jl_sno_1.setIcon(new ImageIcon("image/yes.png"));
				jl_sno_1.setText("");

			}
		});

		JButton jb_submit = new JButton("\u63D0\u4EA4");
		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		jb_submit.setBounds(188, 577, 108, 30);
		contentPanel.add(jb_submit);
		{
			jtf_name = new JTextField();
			jtf_name.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_name.setColumns(10);
			jtf_name.setBounds(172, 127, 180, 30);
			contentPanel.add(jtf_name);
		}
		jl_name_1 = new JLabel("");
		jl_name_1.setBounds(370, 127, 94, 30);
		contentPanel.add(jl_name_1);

		jtf_name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				String name = jtf_name.getText();
				if (!FormCheck.isName(name)) {
					jl_name_1.setIcon(new ImageIcon("image/no.png"));
				} else {
					jl_name_1.setIcon(new ImageIcon("image/yes.png"));
					jl_name_1.setText("");
				}
			}

		});

		rb_boy = new JRadioButton("\u7537");
		rb_boy.setBounds(168, 176, 51, 30);
		contentPanel.add(rb_boy);

		rb_gril = new JRadioButton("\u5973");
		rb_gril.setBounds(323, 176, 43, 30);
		contentPanel.add(rb_gril);
		ButtonGroup group = new ButtonGroup();
		group.add(rb_gril);
		group.add(rb_boy);
		{
			jtf_birth = new JTextField();
			jtf_birth.setFont(new Font("微软雅黑", Font.PLAIN, 14));

			jtf_birth.setColumns(10);
			jtf_birth.setBounds(172, 216, 180, 30);
			contentPanel.add(jtf_birth);
		}
		{
			jl_sex_1 = new JLabel("");
			jl_sex_1.setBounds(370, 176, 94, 30);
			contentPanel.add(jl_sex_1);
		}
		{
			jl_birth_1 = new JLabel("");
			jl_birth_1.setBounds(370, 216, 94, 30);
			contentPanel.add(jl_birth_1);
		}
		{
			jtf_tele = new JTextField();
			jtf_tele.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_tele.setColumns(10);
			jtf_tele.setBounds(172, 264, 180, 30);
			contentPanel.add(jtf_tele);
		}
		{
			jl_tele_1 = new JLabel("");
			jl_tele_1.setBounds(370, 264, 94, 30);
			contentPanel.add(jl_tele_1);
		}
		{
			jtf_nation = new JTextField();
			jtf_nation.setFont(new Font("微软雅黑", Font.PLAIN, 14));
			jtf_nation.setColumns(10);
			jtf_nation.setBounds(172, 314, 180, 30);
			contentPanel.add(jtf_nation);
		}
		{
			jl_nation_1 = new JLabel("");
			jl_nation_1.setBounds(370, 314, 94, 30);
			contentPanel.add(jl_nation_1);
		}
		{
			jc_department = new JComboBox();
			jc_department.setBounds(174, 365, 178, 30);
			jc_department.setFont(MyFont.getMyFont());
			jc_department.addItem("---------请选择---------");
			contentPanel.add(jc_department);
		}
		{
			jc_major = new JComboBox();
			jc_major.setBounds(174, 417, 178, 30);
			contentPanel.add(jc_major);
			jc_major.setFont(MyFont.getMyFont());
			jc_major.addItem("---------请选择---------");
		}
		{
			jc_class = new JComboBox();
			jc_class.setBounds(174, 469, 178, 30);
			contentPanel.add(jc_class);
			jc_class.addItem("---------请选择---------");
			jc_class.setFont(MyFont.getMyFont());
		}
		{
			jtf_place = new JTextField();
			jtf_place.setBounds(172, 520, 180, 30);
			contentPanel.add(jtf_place);
			jtf_place.setColumns(10);
			jtf_place.setFont(MyFont.getMyFont());
		}
		{
			jl_department_1 = new JLabel("");
			jl_department_1.setBounds(370, 365, 94, 30);
			contentPanel.add(jl_department_1);
		}
		{
			jl_major_1 = new JLabel("");
			jl_major_1.setBounds(370, 417, 94, 30);
			contentPanel.add(jl_major_1);
		}
		{
			jl_class_1 = new JLabel("");
			jl_class_1.setBounds(370, 469, 94, 30);
			contentPanel.add(jl_class_1);
		}
		{
			jl_place_1 = new JLabel("");
			jl_place_1.setBounds(370, 520, 94, 30);
			contentPanel.add(jl_place_1);
		}
		jtf_birth.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!(rb_gril).isSelected() && (!(rb_boy.isSelected()))) {
					jl_sex_1.setIcon(new ImageIcon("image/no.png"));
					jl_sex_1.setText("未选择");
				} else {
					jl_sex_1.setIcon(new ImageIcon("image/yes.png"));
					jl_sex_1.setText("");
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				String birth = jtf_birth.getText();
				String[] births = birth.split("-");
				if (births.length != 3) {
					jl_birth_1.setIcon(new ImageIcon("image/no.png"));
					jl_birth_1.setText("1995-7-28");
					return;
				}
				try {
					int year = Integer.valueOf(births[0]);
					int month = Integer.valueOf(births[1]);
					int day = Integer.valueOf(births[2]);
				} catch (Exception e1) {
					jl_birth_1.setIcon(new ImageIcon("image/no.png"));
					jl_birth_1.setText("1995-7-28");
					return;
				}
				jl_birth_1.setIcon(new ImageIcon("image/yes.png"));
				jl_birth_1.setText("");
			}

		});
		jtf_tele.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String tele = jtf_tele.getText();
				if (!FormCheck.isPhoneLegal(tele)) {
					jl_tele_1.setIcon(new ImageIcon("image/no.png"));
					return;
				}
				jl_tele_1.setIcon(new ImageIcon("image/yes.png"));
				jl_tele_1.setText("");
			}
		});
		jtf_nation.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String nation = jtf_nation.getText();
				String[] nations = CommboxData.getNations();
				for (String str : nations) {
					if (str.equals(nation) || str.equals(nation + "族")) {
						jl_nation_1.setIcon(new ImageIcon("image/yes.png"));
						jl_nation_1.setText("");
						return;
					}
				}
				jl_nation_1.setIcon(new ImageIcon("image/no.png"));
				jl_nation_1.setText("不存在");
			}

		});
		List<Depart> departments = new DepartDao().selectDepartListByDname("");
		for (Depart data : departments) {
			jc_department.addItem(data.getDname());
		}
		jc_department.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String gets = (String) jc_department.getSelectedItem();
				if ("---------请选择---------".equals(gets)) {
					jl_department_1.setIcon(new ImageIcon("image/no.png"));
					jl_department_1.setText("不能为空");
					return;
				} else {
					jl_department_1.setIcon(new ImageIcon("image/yes.png"));
					jl_department_1.setText("");

					String name = (String) jc_department.getSelectedItem();
					jc_major.removeAllItems();
					jc_major.addItem("---------请选择---------");
					List<Depart> list = new DepartDao().selectDepartListByDname2(name);
					for (Depart data : list) {
						jc_major.addItem(data.getDname());
					}
				}

			}

		});
		jc_major.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String gets = (String) jc_major.getSelectedItem();

				if ("---------请选择---------".equals(gets)) {
					jl_major_1.setIcon(new ImageIcon("image/no.png"));
					jl_major_1.setText("不能为空");
					return;
				} else {
					jl_major_1.setIcon(new ImageIcon("image/yes.png"));
					jl_major_1.setText("");

					String name = (String) jc_major.getSelectedItem();
					jc_class.removeAllItems();
					jc_class.addItem("---------请选择---------");
					List<Depart> list = new DepartDao().selectDepartlistByMajor(gets);
					for (Depart data : list) {
						jc_class.addItem(data.getMajor());
					}
				}

			}

		});
		jc_class.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String gets = (String) jc_class.getSelectedItem();
				if ("---------请选择---------".equals(gets)) {
					jl_class_1.setIcon(new ImageIcon("image/no.png"));
					jl_class_1.setText("不能为空");
					return;
				} else {
					jl_class_1.setIcon(new ImageIcon("image/yes.png"));
					jl_class_1.setText("");

				}

			}

		});
		jtf_place.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if ("".equals(jtf_place.getText())) {
					jl_place_1.setIcon(new ImageIcon("image/no.png"));
					jl_place_1.setText("不能为空");
					return;
				} else {
					jl_place_1.setIcon(new ImageIcon("image/yes.png"));
					jl_place_1.setText("");
				}

			}

		});
		jb_submit.setFont(MyFont.getMyFont());
		if (flag == 0)
			jb_submit.setText("添加");
		else if (flag == 1) {
			jb_submit.setText("删除");
			setStudent(s);
			setEdit();
		} else if (flag == 2) {
			jb_submit.setText("修改");
			setStudent(s);
			jtf_sno.setEnabled(false);
		}
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "有未输入的值");
						return;
					}

					Student st = getStudent();
					int flag_add = new StudentDao().insertStudent(st);
					if (flag_add == 1) {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "添加成功");
						(StudentInformationDialog.this).dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "添加失败");
						return;
					}
				} else if (flag == 1) {
					int flag_del = new StudentDao().delStudent(s);
					if (flag_del == 0) {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "删除失败");
						return;
					} else {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "删除成功");
						StudentInformationDialog.this.dispose();

					}
				} else if (flag == 2) {
					Student st = getStudent();
					if (!isNull()) {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "有未输入的值");
						return;
					}
					int flag_del = new StudentDao().updateStudent(st);
					if (flag_del == 0) {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(StudentInformationDialog.this, "修改成功");
						StudentInformationDialog.this.dispose();
						return;
					}
				} else {

				}
			}

		});
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		Location.setCenter(this);
	}

	public void setStudent(Student s) {
		jtf_sno.setText(s.getSno());
		jtf_name.setText(s.getSname());
		jc_department.setSelectedItem(s.getDepartment());
		jc_major.addItem(s.getMajor());
		jc_major.setSelectedItem(s.getMajor());
		jc_class.addItem(s.getSclass());
		jc_class.setSelectedItem(s.getSclass());
		jtf_tele.setText(s.getTelephone());
		jtf_nation.setText(s.getNationality());
		jtf_place.setText(s.getNativeplace());

		int i = s.getSex();
		if (i == 0)
			rb_gril.setSelected(true);
		else
			rb_boy.setSelected(true);
		jtf_birth.setText(s.getSbirth() + "");
	}

	public Student getStudent() {
		Student st = new Student();
		st.setSno(jtf_sno.getText());
		st.setSname(jtf_name.getText());
		st.setDepartment((String) jc_department.getSelectedItem());
		st.setMajor((String) jc_major.getSelectedItem());
		st.setSclass((String) jc_class.getSelectedItem());
		st.setTelephone(jtf_tele.getText());
		// st.setSbirth(jtf_birth.getText());
		st.setNationality(jtf_nation.getText());
		st.setNativeplace(jtf_place.getText());

		int sex = -1;
		if (rb_boy.isSelected())
			sex = 1;
		else if (rb_gril.isSelected())
			sex = 0;
		else {
		}
		st.setSex(sex);

		st.setSbirth(FormatToDate.getDate(jtf_birth.getText()));
		return st;

	}

	public void setEdit() {
		jtf_sno.setEnabled(false);
		jtf_name.setEnabled(false);
		rb_gril.setEnabled(false);
		rb_boy.setEnabled(false);
		jtf_tele.setEnabled(false);
		jtf_place.setEnabled(false);
		jtf_birth.setEnabled(false);
		jtf_nation.setEnabled(false);
		jc_department.setEnabled(false);
		jc_major.setEnabled(false);
		jc_class.setEnabled(false);
	}

	public Boolean isNull() {
		String sno = jtf_sno.getText();
		String sname = jtf_name.getText();
		String phone = jtf_tele.getText();
		String nailty = jtf_nation.getText();
		String place = jtf_place.getText();

		String department = (String) jc_department.getSelectedItem();
		String major = (String) jc_major.getSelectedItem();
		String sclass = (String) jc_class.getSelectedItem();

		String birth = jtf_birth.getText();

		if ("".equals(sno) || sno == null)
			return false;
		if ("".equals(sname) || sname == null)
			return false;
		if ("".equals(phone) || phone == null)
			return false;
		if ("".equals(nailty) || nailty == null)
			return false;
		if ("".equals(birth) || birth == null)
			return false;
		if ("".equals(place) || place == null)
			return false;

		if ("---------请选择---------".equals(department))
			return false;
		if ("---------请选择---------".equals(sclass))
			return false;
		if ("---------请选择---------".equals(birth))
			return false;
		if (!(rb_boy.isSelected()) && (!(rb_gril.isSelected())))
			return false;

		return true;

	}
}
