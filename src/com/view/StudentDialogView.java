package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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

import com.dao.StudentDao;
import com.entity.Student;
import com.util.CommboxData;
import com.util.FormatToDate;
import com.util.Location;
import com.util.MyFont;

public class StudentDialogView extends JDialog {

	public static void main(String args[]) {
		Student st = new Student();
		st.setSno("1");
		StudentDialogView s = new StudentDialogView(st, 1);
		s.setSize(1000, 600);
		s.setVisible(true);
	}

	private final JPanel jtf_ality = new JPanel();
	private JTextField jtf_name;
	private JTextField jtf_sno;
	private JTextField jtf_sbirth;
	private JTextField jtf_phone;
	private JTextField jtf_nailty;
	private JTextField jtf_major;
	private JTextField jtf_sclass;
	private JTextField jtf_year;
	JTextField jc_place;
	JComboBox jc_department;
	JRadioButton rb_girl;
	JRadioButton rb_boy;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public StudentDialogView() {

	}

	public StudentDialogView(Student s, int flag) {
		this.setTitle("学生信息");
		setSize(661, 496);
		Location.setCenter(this);
		getContentPane().setLayout(new BorderLayout());
		jtf_ality.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(jtf_ality, BorderLayout.CENTER);
		jtf_ality.setLayout(null);
		jtf_ality.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("\u59D3       \u540D:");
		jl_name.setBounds(86, 98, 61, 30);
		jtf_ality.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setBounds(159, 98, 147, 30);
		jtf_ality.add(jtf_name);
		jtf_name.setColumns(10);
		jtf_name.setFont(MyFont.getMyFont());
		jtf_name.setText(s.getSname());

		JLabel jl_sno = new JLabel("\u5B66       \u53F7:");
		jl_sno.setBounds(350, 98, 61, 30);
		jtf_ality.add(jl_sno);
		jl_sno.setFont(MyFont.getMyFont());
		jl_sno.setFont(MyFont.getMyFont());

		jtf_sno = new JTextField();
		jtf_sno.setColumns(10);
		jtf_sno.setBounds(423, 98, 147, 30);
		jtf_ality.add(jtf_sno);
		jtf_sno.setFont(MyFont.getMyFont());
		jtf_sno.setText(s.getSno());

		JLabel jl_sex = new JLabel("\u6027       \u522B:");
		jl_sex.setBounds(86, 149, 61, 30);
		jtf_ality.add(jl_sex);
		jl_sex.setFont(MyFont.getMyFont());
		jl_sex.setFont(MyFont.getMyFont());

		jtf_sbirth = new JTextField();
		jtf_sbirth.setColumns(10);
		jtf_sbirth.setBounds(423, 149, 147, 30);
		jtf_ality.add(jtf_sbirth);
		jtf_sbirth.setFont(MyFont.getMyFont());
		String sbirth = String.valueOf(s.getSbirth()).trim();
		if (!"null".equals(sbirth))
			jtf_sbirth.setText(String.valueOf(s.getSbirth()));

		ButtonGroup group = new ButtonGroup();
		rb_boy = new JRadioButton("\u7537");
		rb_boy.setBounds(159, 149, 54, 30);
		jtf_ality.add(rb_boy);
		group.add(rb_boy);
		rb_boy.setFont(MyFont.getMyFont());

		rb_girl = new JRadioButton("\u5973");
		group.add(rb_girl);
		rb_girl.setBounds(267, 149, 39, 30);
		jtf_ality.add(rb_girl);
		rb_girl.setFont(MyFont.getMyFont());

		int i = s.getSex();
		if (i == 0)
			rb_girl.setSelected(true);
		if (i == 1)
			rb_boy.setSelected(true);
		JLabel jl_sbirth = new JLabel("\u51FA\u751F\u65E5\u671F:");
		jl_sbirth.setBounds(350, 149, 61, 30);
		jtf_ality.add(jl_sbirth);
		jl_sbirth.setFont(MyFont.getMyFont());

		JLabel jl_telephone = new JLabel("\u8054\u7CFB\u7535\u8BDD:");
		jl_telephone.setBounds(86, 205, 61, 30);
		jtf_ality.add(jl_telephone);
		jl_telephone.setFont(MyFont.getMyFont());

		jtf_phone = new JTextField();
		jtf_phone.setColumns(10);
		jtf_phone.setBounds(159, 205, 147, 30);
		jtf_ality.add(jtf_phone);
		jtf_phone.setFont(MyFont.getMyFont());
		jtf_phone.setText(s.getTelephone());

		JLabel jl_department = new JLabel("\u9662       \u7CFB:");
		jl_department.setBounds(84, 319, 61, 30);
		jtf_ality.add(jl_department);
		jl_department.setFont(MyFont.getMyFont());

		jtf_nailty = new JTextField();
		jtf_nailty.setBounds(423, 205, 147, 30);
		jtf_ality.add(jtf_nailty);
		jtf_nailty.setColumns(10);
		jtf_nailty.setFont(MyFont.getMyFont());
		jtf_nailty.setText(s.getNationality());

		jtf_major = new JTextField();
		jtf_major.setColumns(10);
		jtf_major.setBounds(160, 262, 147, 30);
		jtf_major.setFont(MyFont.getMyFont());
		jtf_ality.add(jtf_major);
		jtf_major.setText(s.getMajor());
		JLabel jl_major = new JLabel("\u4E13       \u4E1A:");
		jl_major.setBounds(84, 262, 61, 30);
		jtf_ality.add(jl_major);

		JLabel jl_class = new JLabel("\u73ED       \u7EA7:");
		jl_class.setBounds(350, 262, 72, 30);
		jtf_ality.add(jl_class);
		jl_class.setFont(MyFont.getMyFont());

		jtf_sclass = new JTextField();
		jtf_sclass.setColumns(10);
		jtf_sclass.setBounds(423, 262, 147, 30);
		jtf_ality.add(jtf_sclass);
		jtf_sclass.setFont(MyFont.getMyFont());
		jtf_sclass.setText(s.getSclass());

		JLabel jl_nationlity = new JLabel("\u6C11      \u65CF:");
		jl_nationlity.setBounds(350, 205, 72, 30);
		jtf_ality.add(jl_nationlity);
		jl_nationlity.setFont(MyFont.getMyFont());

		jc_department = new JComboBox();

		jc_department.setBounds(159, 320, 147, 28);
		jtf_ality.add(jc_department);
		jc_department.setFont(MyFont.getMyFont());
		jc_department.addItem("--请选择--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}
		if (flag != 0) {
			jc_department.setSelectedItem(s.getDepartment());
		}

		JLabel jl_place = new JLabel("\u7C4D      \u8D2F:");
		jl_place.setBounds(350, 319, 63, 30);
		jtf_ality.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());

		jc_place = new JTextField();
		jc_place.setBounds(423, 320, 147, 28);
		jtf_ality.add(jc_place);
		jc_place.setFont(MyFont.getMyFont());
		jc_place.setText(s.getNativeplace());

		JLabel jl_logo = new JLabel("\u5B66\u751F\u57FA\u672C\u4FE1\u606F");
		jl_logo.setFont(new Font("华文楷体", Font.BOLD, 30));
		jl_logo.setHorizontalAlignment(SwingConstants.CENTER);
		jl_logo.setBounds(180, 27, 335, 59);
		jl_major.setFont(MyFont.getMyFont());
		jtf_ality.add(jl_logo);

		JButton jb = new JButton("");
		jb.setFont(MyFont.getMyFont());
		if (flag == 0)
			jb.setText("添加");
		else if (flag == 1) {
			jb.setText("删除");
			setEdit();
		} else if (flag == 2) {
			jb.setText("修改");
			jtf_sno.setEditable(false);
		}
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "有未输入的值");
						return;
					}
					Student st = getStudent();
					Student s = new StudentDao().selectStudent(st);
					String sno = st.getSno();

					if (sno.length() != 13) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "必须为13位纯数字");
						return;
					}
					// for(int i=0;i<sno.length();i++){
					// if(sno.charAt(i)<='0'||sno.charAt(i)>='9'){
					// JOptionPane.showMessageDialog(StudentDialogView.this,"必须为13位纯数字");
					// return ;
					// }
					// }
					if (s != null) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "学号已存在,不能添加");
						return;
					}
					int flag_add = new StudentDao().insertStudent(st);
					if (flag_add == 1) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "添加成功");
						(StudentDialogView.this).dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(StudentDialogView.this, "添加失败");
						return;
					}
				} else if (flag == 1) {
					int flag_del = new StudentDao().delStudent(s);
					if (flag_del == 0) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "删除失败");
						return;
					} else {
						JOptionPane.showMessageDialog(StudentDialogView.this, "删除成功");

					}
				} else if (flag == 2) {
					Student st = getStudent();
					if (!isNull()) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "有未输入的值");
						return;
					}
					int flag_del = new StudentDao().updateStudent(st);
					if (flag_del == 0) {
						JOptionPane.showMessageDialog(StudentDialogView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(StudentDialogView.this, "修改成功");
						StudentDialogView.this.dispose();
						return;
					}
				} else {

				}
			}
		});
		jb.setBounds(299, 421, 90, 30);
		jtf_ality.add(jb);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public Student getStudent() {
		Student st = new Student();
		st.setSno(jtf_sno.getText());
		st.setSname(jtf_name.getText());
		st.setMajor(jtf_major.getText());
		st.setSclass(jtf_sclass.getText());
		st.setTelephone(jtf_phone.getText());
		st.setNationality(jtf_nailty.getText());
		st.setDepartment((String) jc_department.getSelectedItem());
		st.setNativeplace(jc_place.getText());
		int sex = -1;
		if (rb_girl.isSelected())
			sex = 0;
		if (rb_boy.isSelected())
			sex = 1;
		st.setSex(sex);
		String birth = jtf_sbirth.getText().trim();
		st.setSbirth(FormatToDate.getDate(birth));
		return st;
	}

	public void setEdit() {
		jtf_sno.setEditable(false);
		jtf_name.setEditable(false);
		jtf_major.setEditable(false);
		jtf_sclass.setEditable(false);
		jtf_phone.setEditable(false);
		jtf_nailty.setEditable(false);
		jc_department.setEnabled(false);
		jc_place.setEditable(false);
		rb_boy.setEnabled(false);
		rb_girl.setEnabled(false);

	}

	public Boolean isNull() {
		String sno = jtf_sno.getText();
		String sname = jtf_name.getText();
		String smajor = jtf_major.getText();
		String sclass = jtf_sclass.getText();
		String phone = jtf_phone.getText();
		String nailty = jtf_nailty.getText();
		String department = (String) (jc_department.getSelectedItem());
		String place = jc_place.getText();
		if ("".equals(sno) || sno == null)
			return false;
		if ("".equals(sname) || sname == null)
			return false;
		if ("".equals(smajor) || smajor == null)
			return false;
		if ("".equals(sclass) || sclass == null)
			return false;
		if ("".equals(phone) || phone == null)
			return false;
		if ("".equals(nailty) || nailty == null)
			return false;
		if ("".equals(department) || department == null || "--请选择--".equals(department))
			return false;
		if ("".equals(place) || place == null)
			return false;
		return true;

	}
}
