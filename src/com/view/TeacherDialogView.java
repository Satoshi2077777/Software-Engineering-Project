package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractButton;
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

import com.dao.TeacherDao;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.FormCheck;
import com.util.FormatToDate;
import com.util.Location;
import com.util.MyFont;

public class TeacherDialogView extends JDialog {

	private static final AbstractButton jtf_nailty = null;
	private final JPanel f = new JPanel();
	private JTextField jtf_name;
	private JTextField jtf_tno;
	private JTextField jtf_birth;
	private JTextField jtf_telephone;
	private JTextField jtf_ationality;
	private JTextField jtf_place;
	JLabel jl_name_1;
	JLabel jl_tno_1;
	JLabel jl_birth_1;
	JLabel jl_tele_1;
	JLabel jl_nation_1;
	JLabel jl_place_1;
	JLabel jl_sex_1;
	JLabel jl_depart_1;
	JButton jb_submit;
	JRadioButton rb_gril;
	JComboBox jc_department;
	JRadioButton rb_boy;
	Teacher t;

	/**
	 * Launch the application.
	 */
	// "学号","姓名","性别","出生日期","联系电话",
	// "院系","民族","籍贯"

	public TeacherDialogView(Teacher t, int flag) {
		this.t = t;
		this.setTitle("教师信息");
		setSize(463, 620);
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(f, BorderLayout.CENTER);
		f.setLayout(null);
		{
			JLabel jl_name = new JLabel("\u59D3       \u540D:");
			jl_name.setBounds(91, 109, 60, 30);
			f.add(jl_name);
			jl_name.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_sex = new JLabel("\u6027       \u522B:");
			jl_sex.setBounds(91, 205, 60, 30);
			f.add(jl_sex);
			jl_sex.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_telephone = new JLabel("\u7535       \u8BDD:");
			jl_telephone.setBounds(91, 304, 60, 30);
			f.add(jl_telephone);
			jl_telephone.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_nationity = new JLabel("\u6C11       \u65CF:");
			jl_nationity.setBounds(91, 356, 60, 30);
			f.add(jl_nationity);
			jl_nationity.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_tno = new JLabel("\u5DE5       \u53F7:");
			jl_tno.setBounds(91, 155, 60, 30);
			f.add(jl_tno);
			f.setFont(MyFont.getMyFont());
			jl_tno.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_birth = new JLabel("\u51FA\u751F\u65E5\u671F:");
			jl_birth.setBounds(91, 258, 60, 30);
			f.add(jl_birth);
			f.setFont(MyFont.getMyFont());
			jl_birth.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_department = new JLabel("\u9662       \u7CFB:");
			jl_department.setBounds(91, 462, 60, 30);
			f.add(jl_department);
			f.setFont(MyFont.getMyFont());
			jl_department.setFont(MyFont.getMyFont());
		}
		{
			JLabel jl_place = new JLabel("\u7C4D       \u8D2F:");
			jl_place.setBounds(91, 409, 60, 30);
			f.add(jl_place);
			jl_place.setFont(MyFont.getMyFont());
		}
		{
			jtf_name = new JTextField();
			jtf_name.setBounds(182, 110, 150, 30);
			f.add(jtf_name);
			jtf_name.setColumns(10);
			jtf_name.setFont(MyFont.getMyFont());
		}
		{
			jtf_tno = new JTextField();
			jtf_tno.setColumns(10);
			jtf_tno.setBounds(182, 156, 150, 30);
			f.add(jtf_tno);
			jtf_tno.setFont(MyFont.getMyFont());
		}
		{
			jtf_birth = new JTextField();
			jtf_birth.setColumns(10);
			jtf_birth.setBounds(182, 259, 150, 30);
			f.add(jtf_birth);
			f.setFont(MyFont.getMyFont());
			jtf_birth.setFont(MyFont.getMyFont());
		}
		{
			jtf_telephone = new JTextField();
			jtf_telephone.setColumns(10);
			jtf_telephone.setBounds(182, 305, 150, 30);
			f.add(jtf_telephone);
			jtf_telephone.setFont(MyFont.getMyFont());
		}
		{
			jtf_ationality = new JTextField();
			jtf_ationality.setColumns(10);
			jtf_ationality.setBounds(182, 357, 150, 30);
			f.add(jtf_ationality);
			jtf_ationality.setFont(MyFont.getMyFont());
		}
		{
			jtf_place = new JTextField();
			jtf_place.setColumns(10);
			jtf_place.setBounds(182, 410, 150, 30);
			f.add(jtf_place);
			jtf_place.setFont(MyFont.getMyFont());
		}

		ButtonGroup group = new ButtonGroup();
		rb_boy = new JRadioButton("男");
		rb_boy.setBounds(179, 209, 60, 23);
		f.add(rb_boy);
		group.add(rb_boy);

		rb_gril = new JRadioButton("女");
		rb_gril.setBounds(290, 210, 42, 23);
		group.add(rb_gril);
		f.add(rb_gril);
		rb_gril.setFont(MyFont.getMyFont());
		rb_boy.setFont(MyFont.getMyFont());

		jc_department = new JComboBox();
		jc_department.setBounds(182, 462, 148, 30);
		jc_department.setFont(MyFont.getMyFont());
		f.add(jc_department);
		{
			JLabel lblNewLabel = new JLabel("\u6559\u5E08\u4E2A\u4EBA\u57FA\u672C\u4FE1\u606F");
			lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(75, 31, 282, 56);
			f.add(lblNewLabel);
		}
		{
			jb_submit = new JButton("New button");
			jb_submit.setBounds(182, 517, 93, 30);
			f.add(jb_submit);
			f.setFont(MyFont.getMyFont());
		}

		jl_name_1 = new JLabel("");
		jl_name_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_name_1.setBounds(349, 109, 75, 30);
		f.add(jl_name_1);

		jl_tno_1 = new JLabel("");
		jl_tno_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_tno_1.setBounds(349, 155, 75, 30);
		f.add(jl_tno_1);

		jl_sex_1 = new JLabel("");
		jl_sex_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_sex_1.setBounds(349, 205, 75, 30);
		f.add(jl_sex_1);

		jl_birth_1 = new JLabel("");
		jl_birth_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_birth_1.setBounds(349, 258, 88, 30);
		f.add(jl_birth_1);

		jl_tele_1 = new JLabel("");
		jl_tele_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_tele_1.setBounds(349, 304, 75, 30);
		f.add(jl_tele_1);

		jl_nation_1 = new JLabel("");
		jl_nation_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_nation_1.setBounds(349, 356, 75, 30);
		f.add(jl_nation_1);

		jl_place_1 = new JLabel("");
		jl_place_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_place_1.setBounds(349, 409, 75, 30);
		f.add(jl_place_1);

		jl_depart_1 = new JLabel("");
		jl_depart_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_depart_1.setBounds(349, 462, 75, 30);
		f.add(jl_depart_1);

		if (flag == 0) {
			jb_submit.setText("添加");
			jc_department.addItem("--请选择--");

			String[] departments = CommboxData.getDepartments();
			for (String data : departments) {
				jc_department.addItem(data);
			}
		}
		if (flag == 1) {
			jb_submit.setText("删除");
			setValues(t);
			setEdit();
		}
		if (flag == 2) {
			jb_submit.setText("修改");
			setValues(t);
			jtf_tno.setEnabled(false);
		}

		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "有未输入的值");
						return;
					}
					Teacher t = getValues();
					int i = new TeacherDao().insertTeacher(t);
					if (i == 0) {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "添加失败");
					} else {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "添加成功");
						TeacherDialogView.this.dispose();
						return;
					}

				} else if (flag == 1) {
					int i = new TeacherDao().delTeacher(t);
					if (i == 0) {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "删除失败");
					} else {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "删除成功");
					}
					TeacherDialogView.this.dispose();
					return;
				} else if (flag == 2) {
					if (!isNull()) {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "有未输入的值");
						return;
					}
					Teacher t = getValues();
					Teacher tc = new TeacherDao().selectTeacher(t);
					int flag_del = new TeacherDao().updateTeacher(t);
					if (flag_del == 0) {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(TeacherDialogView.this, "修改成功");
						TeacherDialogView.this.dispose();
						return;
					}

				}

			}

		});
		jtf_name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!FormCheck.isName(jtf_name.getText())) {
					jl_name_1.setIcon(new ImageIcon("image/no.png"));
					return;
				}
				jl_name_1.setIcon(new ImageIcon("image/yes.png"));
				return;
			}
		});
		jtf_tno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!FormCheck.isTno(jtf_tno.getText())) {
					jl_tno_1.setIcon(new ImageIcon("image/no.png"));
					jl_tno_1.setText("10位数字");
					return;
				}
				t.setTno(jtf_tno.getText());
				Teacher te = new TeacherDao().selectTeacher(t);
				if (te != null) {
					jl_tno_1.setIcon(new ImageIcon("image/no.png"));
					jl_tno_1.setText("已存在");
					return;
				}

				jl_tno_1.setIcon(new ImageIcon("image/yes.png"));
				jl_tno_1.setText("");
			}
		});
		jtf_birth.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (!(rb_boy.isSelected()) && (!(rb_gril.isSelected()))) {
					jl_sex_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_sex_1.setIcon(new ImageIcon("image/yes.png"));
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

		jtf_telephone.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!FormCheck.isPhoneLegal(jtf_telephone.getText())) {
					jl_tele_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_tele_1.setIcon(new ImageIcon("image/yes.png"));
				}

			}

		});

		jtf_ationality.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String nation = jtf_ationality.getText();
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
		jc_department.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String gets = (String) jc_department.getSelectedItem();
				System.out.println(gets);
				if ("---------请选择---------".equals(gets)) {
					jl_depart_1.setIcon(new ImageIcon("image/no.png"));
					jl_depart_1.setText("不能为空");
					return;
				} else {
					jl_depart_1.setIcon(new ImageIcon("image/yes.png"));
					jl_depart_1.setText("");
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
				if (!"".equals(jtf_place.getText())) {
					jl_place_1.setIcon(new ImageIcon("image/yes.png"));
					return;
				} else {
					jl_place_1.setIcon(new ImageIcon("image/no.png"));
					return;
				}
			}

		});

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public Teacher getValues() {
		Teacher t = new Teacher();
		t.setTno(jtf_tno.getText());
		t.setTname(jtf_name.getText());

		t.setTelephone(jtf_telephone.getText());
		t.setNationality(jtf_ationality.getText());
		t.setDepartment((String) jc_department.getSelectedItem());
		t.setNativeplace(jtf_place.getText());
		int sex = -1;

		if (rb_boy.isSelected())
			sex = 1;
		if (rb_gril.isSelected())
			sex = 0;
		t.setSex(sex);
		t.setTbirth(FormatToDate.getDate(jtf_birth.getText()));
		return t;
	}

	public void setValues(Teacher t) {

		jtf_name.setText(t.getTname());
		jtf_tno.setText(t.getTno());
		int i = t.getSex();
		System.out.println("i=:" + i);
		if (i == 1)
			rb_boy.setSelected(true);
		else
			rb_gril.setSelected(true);
		jtf_telephone.setText(t.getTelephone());
		;
		jtf_ationality.setText(t.getNationality());
		;
		jtf_place.setText(t.getNativeplace());

		jtf_birth.setText(t.getTbirth() + "");

		jc_department.addItem("--请选择--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}
		jc_department.setSelectedItem(t.getDepartment());
	}

	public boolean isNull() {
		String name = jtf_name.getText();
		String tno = jtf_tno.getText();
		String tele = jtf_telephone.getText();
		String nality = jtf_ationality.getText();
		String place = jtf_place.getText();
		String birth = jtf_birth.getText();
		String department = (String) jc_department.getSelectedItem();
		if ((!rb_boy.isSelected()) && (!rb_gril.isSelected()))
			return false;
		if ("".equals(name) || name == null)
			return false;
		if ("".equals(tno) || tno == null)
			return false;
		if ("".equals(tele) || tele == null)
			return false;
		if ("".equals(nality) || nality == null)
			return false;
		if ("".equals(place) || place == null)
			return false;
		if ("".equals(birth) || birth == null)
			return false;
		if ("".equals(department) || department == null || "--请选择--".equals(department))
			return false;
		return true;
	}

	public void setEdit() {
		jtf_name.setEnabled(false);
		jtf_tno.setEnabled(false);
		jtf_telephone.setEnabled(false);
		jtf_ationality.setEnabled(false);
		jtf_place.setEnabled(false);
		jtf_birth.setEnabled(false);
		jc_department.setEnabled(false);

		rb_boy.setEnabled(false);
		rb_gril.setEnabled(false);
	}
}
