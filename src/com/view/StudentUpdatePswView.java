package com.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.dao.UserStuentDao;
import com.entity.Student;
import com.entity.UserStudent;
import com.main.MySystem;
import com.util.ImagePanel;
import com.util.MyFont;

public class StudentUpdatePswView extends ImagePanel {
	private JTextField jtf_sno;
	private JPasswordField jtf_psw;
	private JPasswordField jtf_again;

	/**
	 * Create the panel.
	 */
	public StudentUpdatePswView(int width, int height, Image image, Student s) {
		this.setPreferredSize(new Dimension(1000, 550));
		setLayout(null);

		JPanel jp_back = new JPanel();
		jp_back.setBounds(343, 123, 379, 282);
		add(jp_back);
		jp_back.setLayout(null);

		JLabel jl_sno = new JLabel("\u59D3      \u540D:");
		jl_sno.setBounds(53, 29, 65, 30);
		jp_back.add(jl_sno);
		jl_sno.setFont(MyFont.getMyFont());

		JLabel jl_psw = new JLabel("\u8F93\u5165\u5BC6\u7801:");
		jl_psw.setBounds(53, 97, 65, 30);
		jp_back.add(jl_psw);
		jl_psw.setFont(MyFont.getMyFont());

		JLabel jl_again = new JLabel("\u91CD\u65B0\u8F93\u5165:");
		jl_again.setBounds(53, 160, 65, 30);
		jp_back.add(jl_again);
		jl_again.setFont(MyFont.getMyFont());

		JButton jb_submit = new JButton("\u63D0\u4EA4");
		jb_submit.setBounds(141, 212, 100, 30);
		jp_back.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jtf_sno = new JTextField();
		jtf_sno.setBounds(141, 30, 157, 30);
		jp_back.add(jtf_sno);
		jtf_sno.setColumns(10);
		jtf_sno.setFont(MyFont.getMyFont());
		jtf_sno.setText(s.getSno());
		jtf_sno.setEditable(false);

		jtf_psw = new JPasswordField();
		jtf_psw.setBounds(141, 97, 157, 30);
		jp_back.add(jtf_psw);
		jtf_psw.setFont(MyFont.getMyFont());

		jtf_again = new JPasswordField();
		jtf_again.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jtf_again.setBounds(141, 160, 157, 30);
		jp_back.add(jtf_again);

		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sno = jtf_sno.getText();
				String psw = jtf_psw.getText();
				String again = jtf_again.getText();
				if (!psw.equals(again)) {
					JOptionPane.showMessageDialog(StudentUpdatePswView.this, "两次输入的密码不一致");
					return;
				}
				if ("".equals(psw)) {
					JOptionPane.showMessageDialog(StudentUpdatePswView.this, "密码不能为空");
					return;
				}
				String inputValue = JOptionPane.showInputDialog("请输入密码以确认提交成绩：");
				UserStudent u = new UserStuentDao().selectUserStudent(new UserStudent(sno, inputValue));
				if (u == null) {
					JOptionPane.showMessageDialog(new JFrame(), "密码错误，修改失败！");
					return;
				}
				UserStudent user = new UserStudent();
				user.setSno(sno);
				user.setUspsw(psw);
				int i = new UserStuentDao().updateUserStudent(user);
				if (i == 0) {
					JOptionPane.showMessageDialog(StudentUpdatePswView.this, "密码修改失败");
					return;
				} else {
					JOptionPane.showMessageDialog(StudentUpdatePswView.this, "密码修改完成,请重新登录！");
					JOptionPane.getFrameForComponent(StudentUpdatePswView.this).dispose();
					MySystem.main(null);
					return;
				}

			}

		});
	}
}
