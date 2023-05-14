package com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.UserStuentDao;
import com.dao.UserTeacherDao;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.UserStudent;
import com.entity.UserTeacher;
import com.util.Location;
import com.util.MyFont;

public class RegisterView extends JDialog {
	public static void main(String args[]) {
		RegisterView a = new RegisterView();
		a.setSize(1000, 600);
		a.setVisible(true);
	}

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_user;
	private JPasswordField jpf_psw;
	private JPasswordField jpf_again;
	JRadioButton rb_teacher;
	JRadioButton rb_student;

	/**
	 * Create the dialog.
	 */
	public void init() {
		rb_teacher.setSelected(false);
		rb_student.setSelected(false);
		jtf_user.setText("");
		jpf_psw.setText("");
		jpf_again.setText("");
	}

	public RegisterView() {
		setSize(630, 400);
		this.setResizable(false);
		this.setTitle("ע��");
		getContentPane().setLayout(new BorderLayout());
		Location.setCenter(this);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ButtonGroup group = new ButtonGroup();

		JPanel jp_back = new JPanel();
		jp_back.setBounds(126, 21, 339, 306);
		contentPanel.add(jp_back);
		jp_back.setLayout(null);

		JLabel jl_role = new JLabel("��    ɫ:");
		jl_role.setBounds(29, 53, 80, 30);
		jp_back.add(jl_role);
		jl_role.setFont(MyFont.getMyFont());

		JLabel jl_user = new JLabel("�û���:");
		jl_user.setBounds(29, 97, 80, 30);
		jp_back.add(jl_user);
		jl_user.setFont(MyFont.getMyFont());

		JLabel jl_psw = new JLabel("��    ��:");
		jl_psw.setBounds(29, 148, 80, 30);
		jp_back.add(jl_psw);
		jl_psw.setFont(MyFont.getMyFont());

		JLabel jl_again = new JLabel("��������:");
		jl_again.setBounds(29, 198, 80, 30);
		jp_back.add(jl_again);
		jl_again.setFont(MyFont.getMyFont());

		jtf_user = new JTextField();
		jtf_user.setBounds(119, 98, 190, 30);
		jp_back.add(jtf_user);
		jtf_user.setColumns(10);
		jtf_user.setFont(MyFont.getMyFont());

		jpf_psw = new JPasswordField();
		jpf_psw.setBounds(119, 149, 190, 30);
		jp_back.add(jpf_psw);
		jpf_psw.setFont(MyFont.getMyFont());

		jpf_again = new JPasswordField();
		jpf_again.setBounds(120, 199, 190, 30);
		jp_back.add(jpf_again);
		jpf_again.setFont(MyFont.getMyFont());

		rb_teacher = new JRadioButton("��ʦ");
		rb_teacher.setBounds(115, 56, 121, 25);
		jp_back.add(rb_teacher);
		rb_teacher.setFont(MyFont.getMyFont());

		rb_student = new JRadioButton("ѧ��");
		rb_student.setBounds(254, 57, 55, 25);
		jp_back.add(rb_student);
		rb_teacher.setFont(MyFont.getMyFont());

		group.add(rb_student);
		group.add(rb_teacher);

		JButton jb_submit = new JButton("ע��");
		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String psw = jpf_psw.getText();
				String again_psw = jpf_again.getText();
				String user = jtf_user.getText();
				if (rb_teacher.isSelected()) {
					Teacher t = new Teacher();
					t.setTno(user);
					Teacher teacher = new TeacherDao().selectTeacher(t);
					if (teacher == null) {
						JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>�û���������</font></html>");
						init();
						return;
					} else {
						if ((!(psw).equals(again_psw)) || "".equals(psw)) {
							JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>�����������</font></html>");
							init();
							return;
						} else {
							UserTeacher userTeacher = new UserTeacher(user, psw);
							UserTeacher teacher1 = new UserTeacherDao().selectUserTeacher(userTeacher);
							if (teacher1 != null) {
								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>�û���ע��</font></html>");
								init();
								return;
							}
							int flag = new UserTeacherDao().insertUserTeacher(userTeacher);
							if (flag != 0) {
								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>ע��ɹ�</font></html>");
								RegisterView.this.dispose();
								new LoginView();
							} else {
								init();
								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>ע��ʧ��</font></html>");
							}

						}
					}
				} else if (rb_student.isSelected()) {
					Student t = new Student();
					t.setSno(user);
					Student student = new StudentDao().selectStudent(t);
					if (student == null) {
						JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>�û���������</font></html>");
						init();
						return;
					} else {
						if ((!(psw).equals(again_psw)) || "".equals(psw)) {
							JOptionPane.showMessageDialog(RegisterView.this, "<html><font size=5>�����������</font></html>");
							init();
							return;
						} else {
							UserStudent userStudent = new UserStudent(user, psw);
							UserStudent user1 = new UserStuentDao().selectUserStudent(userStudent);
							if (user1 != null) {
								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>�û���ע��</font><html>");
								init();
								return;
							}
							int flag = new UserStuentDao().insertUserStudent(userStudent);
							if (flag != 0) {

								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>ע��ɹ�</font><html>");
								RegisterView.this.dispose();
								new LoginView().setVisible(true);
								;
							} else {
								JOptionPane.showMessageDialog(RegisterView.this,
										"<html><font size=5>ע��ʧ��</font><html>");
								init();
								return;
							}

						}
					}
				} else {
					JOptionPane.showMessageDialog(RegisterView.this, "��ɫδѡ��");
				}
			}
		});
		jb_submit.setBounds(120, 245, 80, 30);
		jp_back.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		JButton jb_reset = new JButton("����");
		jb_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init();
			}
		});
		jb_reset.setBounds(230, 245, 80, 30);
		jp_back.add(jb_reset);
		jb_reset.setFont(MyFont.getMyFont());

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				new LoginView().setVisible(true);
			}

		});
	}
}
