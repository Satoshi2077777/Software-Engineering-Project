package com.view;

import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.entity.Teacher;
import com.util.CommboxData;
import com.util.ImagePanel;
import com.util.MyFont;

public class TeacherInfromationView extends ImagePanel {
	private JTextField jtf_tno;
	private JTextField jtf_name;
	private JTextField jtf_birth;
	private JTextField jtf_tele;
	private JTextField jtf_nation;
	private JTextField jtf_place;
	JComboBox jc_department;
	JRadioButton rb_boy;
	JRadioButton rb_gril;

	/**
	 * Create the panel.
	 */
	public TeacherInfromationView(Teacher t, int width, int height, Image image) {
		super(width, height, image);
		this.setSize(1000, 550);
		setLayout(null);

		JLabel jl_tno = new JLabel("\u5DE5\u53F7:");
		jl_tno.setBounds(203, 79, 64, 30);
		add(jl_tno);
		jl_tno.setFont(MyFont.getMyFont());

		jtf_tno = new JTextField();
		jtf_tno.setEnabled(false);
		jtf_tno.setBounds(266, 80, 180, 30);
		add(jtf_tno);
		jtf_tno.setColumns(10);
		jtf_tno.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("\u59D3\u540D:");
		jl_name.setBounds(584, 79, 64, 30);
		add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setEnabled(false);
		jtf_name.setColumns(10);
		jtf_name.setBounds(658, 80, 180, 30);
		add(jtf_name);
		jtf_name.setFont(MyFont.getMyFont());

		JLabel jl_sex = new JLabel("\u6027\u522B:");
		jl_sex.setBounds(203, 171, 64, 30);
		add(jl_sex);
		jl_sex.setFont(MyFont.getMyFont());

		rb_boy = new JRadioButton("\u7537");
		rb_boy.setBounds(273, 171, 58, 30);
		add(rb_boy);
		rb_boy.setFont(MyFont.getMyFont());

		rb_gril = new JRadioButton("\u5973");
		rb_gril.setBounds(398, 171, 50, 30);
		add(rb_gril);
		rb_gril.setFont(MyFont.getMyFont());

		JLabel jl_birth = new JLabel("\u751F\u65E5:");
		jl_birth.setBounds(584, 172, 54, 30);
		jl_birth.setFont(MyFont.getMyFont());
		add(jl_birth);

		jtf_birth = new JTextField();
		jtf_birth.setEnabled(false);
		jtf_birth.setBounds(658, 173, 180, 30);
		add(jtf_birth);
		jtf_birth.setColumns(10);
		jtf_birth.setFont(MyFont.getMyFont());

		JLabel jl_tele = new JLabel("\u7535\u8BDD:");
		jl_tele.setBounds(203, 244, 54, 30);
		add(jl_tele);
		jl_tele.setFont(MyFont.getMyFont());

		jtf_tele = new JTextField();
		jtf_tele.setEditable(false);
		jtf_tele.setColumns(10);
		jtf_tele.setBounds(266, 245, 180, 30);
		add(jtf_tele);
		jtf_tele.setFont(MyFont.getMyFont());

		JLabel jl_nation = new JLabel("\u6C11\u65CF:");
		jl_nation.setBounds(584, 244, 54, 30);
		add(jl_nation);
		jl_nation.setFont(MyFont.getMyFont());

		jtf_nation = new JTextField();
		jtf_nation.setEnabled(false);
		jtf_nation.setColumns(10);
		jtf_nation.setBounds(658, 245, 180, 30);
		add(jtf_nation);
		jtf_nation.setFont(MyFont.getMyFont());

		JLabel jl_place = new JLabel("\u7C4D\u8D2F:");
		jl_place.setBounds(203, 343, 54, 30);
		add(jl_place);
		jl_place.setFont(MyFont.getMyFont());

		JLabel jl_department = new JLabel("\u9662\u7CFB:");
		jl_department.setBounds(584, 343, 54, 30);
		add(jl_department);
		jl_department.setFont(MyFont.getMyFont());

		jtf_place = new JTextField();
		jtf_place.setEnabled(false);
		jtf_place.setColumns(10);
		jtf_place.setBounds(266, 344, 180, 30);
		add(jtf_place);
		jtf_place.setFont(MyFont.getMyFont());

		jc_department = new JComboBox();
		jc_department.setBounds(663, 344, 180, 30);
		add(jc_department);
		jc_department.setFont(MyFont.getMyFont());
		jc_department.addItem("--«Î—°‘Ò--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}

		setValues(t);
		setEdit();
	}

	public void setEdit() {
		jtf_tno.setEditable(false);
		jtf_name.setEditable(false);
		jtf_nation.setEditable(false);
		jc_department.setEditable(false);
		jtf_place.setEditable(false);
		rb_gril.setEnabled(false);
		rb_boy.setEnabled(false);
		jtf_birth.setEditable(false);
		jc_department.setEnabled(false);

	}

	public void setValues(Teacher s) {
		jtf_tno.setText(s.getTno());
		jtf_name.setText(s.getTname());
		jtf_tele.setText(s.getTelephone());
		jtf_nation.setText(s.getNationality());
		jtf_place.setText(s.getNativeplace());

		int i = s.getSex();
		if (i == 0)
			rb_gril.setSelected(true);
		else
			rb_boy.setSelected(true);

		jc_department.setSelectedItem(s.getDepartment());
		jtf_birth.setText(s.getTbirth() + "");

	}
}
