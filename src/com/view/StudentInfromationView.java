package com.view;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.entity.Student;
import com.util.CommboxData;
import com.util.ImagePanel;
import com.util.MyFont;

public class StudentInfromationView extends ImagePanel {
	private JTextField jtf_sno;
	private JTextField jtf_name;
	private JTextField jtf_tele;
	private JTextField jtf_major;
	private JTextField jtf_birth;
	private JTextField jtf_nation;
	private JTextField jtf_place;
	private JTextField jtf_class;
	JComboBox jc_department;
	JRadioButton rb_boy;
	JRadioButton rb_gril;

	/**
	 * Create the panel.
	 */
	public StudentInfromationView(int width, int height, Image image, Student student) {
		super(width, height, image);
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(null);

		JLabel jl_sno = new JLabel("\u5B66\u53F7:");
		jl_sno.setBounds(212, 70, 60, 30);
		add(jl_sno);
		jl_sno.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("\u59D3\u540D:");
		jl_name.setBounds(549, 70, 60, 30);
		add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		JLabel jl_sex = new JLabel("\u6027\u522B");
		jl_sex.setBounds(212, 151, 82, 30);
		add(jl_sex);
		jl_sex.setFont(MyFont.getMyFont());

		rb_boy = new JRadioButton("\u7537");
		rb_boy.setBounds(294, 151, 51, 30);
		add(rb_boy);
		rb_boy.setFont(MyFont.getMyFont());

		rb_gril = new JRadioButton("\u5973");
		rb_gril.setBounds(424, 151, 51, 30);
		add(rb_gril);
		rb_gril.setFont(MyFont.getMyFont());

		ButtonGroup group = new ButtonGroup();
		group.add(rb_boy);
		group.add(rb_gril);

		JLabel jl_tele = new JLabel("\u7535\u8BDD:");
		jl_tele.setBounds(212, 228, 82, 30);
		add(jl_tele);
		jl_tele.setFont(MyFont.getMyFont());

		jtf_sno = new JTextField();
		jtf_sno.setEnabled(false);
		jtf_sno.setBounds(294, 71, 182, 30);
		add(jtf_sno);
		jtf_sno.setColumns(10);
		jtf_sno.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setEnabled(false);
		jtf_name.setColumns(10);
		jtf_name.setBounds(625, 71, 182, 30);
		add(jtf_name);
		jtf_name.setFont(MyFont.getMyFont());

		jtf_tele = new JTextField();
		jtf_tele.setColumns(10);
		jtf_tele.setBounds(293, 229, 182, 30);
		add(jtf_tele);
		jtf_tele.setFont(MyFont.getMyFont());

		JLabel jl_major = new JLabel("\u4E13\u4E1A:");
		jl_major.setBounds(212, 313, 82, 30);
		add(jl_major);
		jl_major.setFont(MyFont.getMyFont());

		jtf_major = new JTextField();
		jtf_major.setEnabled(false);
		jtf_major.setColumns(10);
		jtf_major.setBounds(293, 314, 182, 30);
		add(jtf_major);
		jtf_major.setFont(MyFont.getMyFont());

		JLabel jl_department = new JLabel("\u9662\u7CFB:");
		jl_department.setBounds(549, 313, 82, 30);
		add(jl_department);
		jl_department.setFont(MyFont.getMyFont());

		jc_department = new JComboBox();
		jc_department.setBounds(625, 313, 182, 30);
		add(jc_department);
		jc_department.setFont(MyFont.getMyFont());
		jc_department.addItem("--«Î—°‘Ò--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}

		JLabel jl_birth = new JLabel("\u751F\u65E5:");
		jl_birth.setBounds(549, 151, 82, 30);
		add(jl_birth);
		jl_birth.setFont(MyFont.getMyFont());

		jtf_birth = new JTextField();
		jtf_birth.setEnabled(false);
		jtf_birth.setColumns(10);
		jtf_birth.setBounds(625, 152, 182, 30);
		add(jtf_birth);
		jtf_birth.setFont(MyFont.getMyFont());

		JLabel jc_nation = new JLabel("\u6C11\u65CF:");
		jc_nation.setBounds(212, 398, 82, 30);
		add(jc_nation);
		jc_nation.setFont(MyFont.getMyFont());

		jtf_nation = new JTextField();
		jtf_nation.setEnabled(false);
		jtf_nation.setColumns(10);
		jtf_nation.setBounds(293, 399, 182, 30);
		add(jtf_nation);
		jtf_nation.setFont(MyFont.getMyFont());

		jtf_place = new JTextField();
		jtf_place.setEnabled(false);
		jtf_place.setColumns(10);
		jtf_place.setBounds(625, 399, 182, 30);
		add(jtf_place);
		jtf_place.setFont(MyFont.getMyFont());

		JLabel jl_class = new JLabel("\u73ED\u7EA7:");
		jl_class.setBounds(549, 228, 82, 30);
		add(jl_class);
		jl_class.setFont(MyFont.getMyFont());

		jtf_class = new JTextField();
		jtf_class.setEnabled(false);
		jtf_class.setColumns(10);
		jtf_class.setBounds(625, 229, 182, 30);
		add(jtf_class);
		jtf_class.setFont(MyFont.getMyFont());

		JLabel jl_place = new JLabel("\u9662\u7CFB:");
		jl_place.setBounds(549, 398, 82, 30);
		add(jl_place);
		jl_place.setFont(MyFont.getMyFont());

		setValues(student);
		setEdit();
	}

	public void setEdit() {
		jtf_sno.setEditable(false);
		;
		jtf_name.setEditable(false);
		jtf_major.setEditable(false);
		jtf_class.setEditable(false);
		jtf_tele.setEditable(false);
		jtf_nation.setEditable(false);
		jc_department.setEnabled(false);
		jtf_place.setEditable(false);
		rb_gril.setEnabled(false);
		rb_boy.setEnabled(false);
		jtf_birth.setEditable(false);
		jc_department.setEnabled(false);

	}

	public void setValues(Student s) {
		jtf_sno.setText(s.getSno());
		jtf_name.setText(s.getSname());
		jtf_major.setText(s.getMajor());
		jtf_class.setText(s.getSclass());
		jtf_tele.setText(s.getTelephone());
		jtf_nation.setText(s.getNationality());
		jtf_place.setText(s.getNativeplace());

		int i = s.getSex();
		if (i == 0)
			rb_gril.setSelected(true);
		else
			rb_boy.setSelected(true);

		jc_department.setSelectedItem(s.getDepartment());
		jtf_birth.setText(s.getSbirth() + "");

	}
}
