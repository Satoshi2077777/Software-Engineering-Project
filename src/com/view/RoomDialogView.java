package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.RoomDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.Admin;
import com.entity.Room;
import com.entity.Student;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.FormCheck;
import com.util.Location;
import com.util.MyFont;

public class RoomDialogView extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_rid;
	private JTextField jtf_rname;
	private JTextField jtf_pname;
	private JComboBox jtf_pstatu;
	JComboBox jc_day;
	JComboBox jc_week;
	JLabel jl_rid_1;
	JLabel jl_rame_1;
	JLabel jl_pname_1;
	JLabel jl_time_1;
	JLabel jl_pstatu_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public RoomDialogView(Room room, int flag, Admin a1, Student s1, Teacher t1) {
		System.out.println("now is RoomDialogView");
		setSize(483, 504);
		Location.setCenter(this);
		this.setTitle("教室信息");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel jl_cno = new JLabel("预约编号:");
			jl_cno.setBounds(74, 87, 68, 30);
			contentPanel.add(jl_cno);
			jl_cno.setFont(MyFont.getMyFont());
		}

		JLabel jl_name = new JLabel("教室名称:");
		jl_name.setBounds(74, 127, 68, 30);
		contentPanel.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());
		//
		// JLabel jl_mark = new JLabel("\u8BFE\u7A0B\u5B66\u5206:");
		// jl_mark.setBounds(74, 171, 68, 30);
		// contentPanel.add(jl_mark);
		// jl_mark.setFont(MyFont.getMyFont());
		//
		JLabel jl_pno = new JLabel("预约人:");
		jl_pno.setBounds(74, 171, 68, 30);
		contentPanel.add(jl_pno);
		jl_pno.setFont(MyFont.getMyFont());

		JLabel jl_time = new JLabel("预约时间:");
		jl_time.setBounds(74, 211, 68, 30);// 74, 251, 68, 30
		contentPanel.add(jl_time);
		jl_time.setFont(MyFont.getMyFont());

		JLabel jl_psta = new JLabel("可用状态:");
		jl_psta.setBounds(74, 251, 68, 30);// 74, 291, 68, 30
		contentPanel.add(jl_psta);
		jl_psta.setFont(MyFont.getMyFont());

		JLabel lblNewLabel = new JLabel("教室信息");
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 27, 254, 50);
		contentPanel.add(lblNewLabel);

		jtf_rid = new JTextField();
		jtf_rid.setBounds(158, 87, 205, 30);
		contentPanel.add(jtf_rid);
		jtf_rid.setColumns(10);
		jtf_rid.setFont(MyFont.getMyFont());

		jtf_rname = new JTextField();
		jtf_rname.setColumns(10);
		jtf_rname.setBounds(158, 128, 205, 30);
		contentPanel.add(jtf_rname);
		jtf_rname.setFont(MyFont.getMyFont());

		jtf_pname = new JTextField();
		jtf_pname.setColumns(10);
		jtf_pname.setBounds(158, 172, 205, 30);
		contentPanel.add(jtf_pname);
		jtf_pname.setFont(MyFont.getMyFont());

		jtf_pstatu = new JComboBox();
		jtf_pstatu.setBounds(158, 252, 205, 30);
		jtf_pstatu.setFont(MyFont.getMyFont());
		contentPanel.add(jtf_pstatu);
		jtf_pstatu.addItem("--请选择--");
		String[] pstatu = CommboxData.getPstatu();
		for (String data : pstatu) {
			jtf_pstatu.addItem(data);
		}

		JButton jb_submit = new JButton("New button");
		jb_submit.setBounds(181, 306, 100, 30);
		contentPanel.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jc_week = new JComboBox();
		jc_week.setBounds(158, 212, 95, 30);
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

		jc_day.setBounds(264, 212, 99, 30);
		contentPanel.add(jc_day);

		jl_rid_1 = new JLabel("");
		jl_rid_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_rid_1.setBounds(373, 87, 84, 30);
		contentPanel.add(jl_rid_1);

		jl_rame_1 = new JLabel("");
		jl_rame_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_rame_1.setBounds(373, 127, 84, 30);
		contentPanel.add(jl_rame_1);

		jl_pname_1 = new JLabel("");
		jl_pname_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_pname_1.setBounds(373, 171, 84, 30);
		contentPanel.add(jl_pname_1);

		jl_time_1 = new JLabel("");
		jl_time_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_time_1.setBounds(373, 211, 84, 30);
		contentPanel.add(jl_time_1);

		jl_pstatu_1 = new JLabel("");
		jl_pstatu_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_pstatu_1.setBounds(373, 251, 84, 30);
		contentPanel.add(jl_pstatu_1);

		if (flag == 0) {
			System.out.println("r" + room.getPtime());
			String ctime = room.getPtime();
			if (ctime != null) {
				String[] times = ctime.split(",");
				String week = "星期" + times[0];
				jc_day.setSelectedItem(times[1]);
				jc_week.setSelectedItem(week);
			} else {
				jc_week.setSelectedItem("");
				jc_day.setSelectedItem("");
			}
			if (s1 != null) {
				jtf_rid.setText(String.valueOf((int) (Math.random() * 90000 + 10000)));
				jtf_rname.setText(room.getRname());
				jtf_pname.setText(s1.getSno());
				jtf_pname.setEditable(false);
			} else if (t1 != null) {
				jtf_rid.setText(String.valueOf((int) (Math.random() * 90000 + 10000)));
				jtf_rname.setText(room.getRname());
				jtf_pname.setText(t1.getTno());
				jtf_pname.setEditable(false);
			} else
				;
			jtf_pstatu.setSelectedItem("预约中");
			jtf_pstatu.setEnabled(false);
			jb_submit.setText("添加");
		} else if (flag == 1) {
			if (t1 != null || s1 != null) {
				JOptionPane.showMessageDialog(RoomDialogView.this, "权限不足，无法删除");
				jb_submit.setText("无法删除");
				jb_submit.setEnabled(false);
			} else
				jb_submit.setText("删除");
			Room r2 = new RoomDao().selectRoom(room);
			setValues(r2);
			setEdit();
		} else if (flag == 2) {
			if (t1 != null || s1 != null) {
				JOptionPane.showMessageDialog(RoomDialogView.this, "权限不足，无法修改");
				jb_submit.setText("无法修改");
				jb_submit.setEnabled(false);
			} else
				jb_submit.setText("修改");
			jtf_rid.setEnabled(false);
			Room r2 = new RoomDao().selectRoom(room);
			setValues(r2);
		} else {

		}
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(RoomDialogView.this, "有未输入的值");
						return;
					}
					Room r = getRoom();
					Room r1 = new RoomDao().selectRoom(r);
					int i = new RoomDao().insertRoom(r);
					if (i == 1) {
						JOptionPane.showMessageDialog(RoomDialogView.this, "添加成功");
						RoomDialogView.this.dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(RoomDialogView.this, "添加失败");
					}
				} else if (flag == 1) {
					int i = new RoomDao().delRoom(room);
					if (i == 0) {
						JOptionPane.showMessageDialog(RoomDialogView.this, "删除失败");
					} else {
						JOptionPane.showMessageDialog(RoomDialogView.this, "删除成功");
					}
					RoomDialogView.this.dispose();
					return;
				} else if (flag == 2) {
					Room room = getRoom();
					if (!isNull()) {
						JOptionPane.showMessageDialog(RoomDialogView.this, "有未输入的值");
						return;
					}
					int update = new RoomDao().updateRoom(room);
					if (update == 0) {
						JOptionPane.showMessageDialog(RoomDialogView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(RoomDialogView.this, "修改成功");
						RoomDialogView.this.dispose();
						return;
					}
				}
			}

		});

		jtf_rid.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!FormCheck.isCno((jtf_rid.getText()))) {
					jl_rid_1.setIcon(new ImageIcon("image/no.png"));
					jl_rid_1.setText("五位数字");
					return;
				}
				Room room = new Room();
				room.setRid(Integer.parseInt(jtf_rid.getText()));
				Room r = new RoomDao().selectRoom(room);
				if (r != null) {
					jl_rid_1.setIcon(new ImageIcon("image/no.png"));
					jl_rid_1.setText("已存在");
					return;
				} else {
					jl_rid_1.setIcon(new ImageIcon("image/yes.png"));
					jl_rid_1.setText("");
				}

			}

		});
		jtf_rname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if (!new RoomDao().checkRoomName(jtf_rname.getText())) {
						jl_rame_1.setIcon(new ImageIcon("image/no.png"));
						jl_rame_1.setText("不存在");
						return;
					} else {
						jl_rame_1.setIcon(new ImageIcon("image/yes.png"));
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}

			}

		});

		jtf_pname.addFocusListener(new FocusListener()

		{

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String str = jtf_pname.getText();
				Teacher t = new Teacher();
				t.setTno(str);
				Student s = new Student();
				s.setSno(str);
				Teacher te = new TeacherDao().selectTeacher(t);
				Student st = new StudentDao().selectStudent(s);
				if (te != null || st != null || str.equals("")) {
					jl_pname_1.setText("");
					jl_pname_1.setIcon(new ImageIcon("image/yes.png"));
					return;
				} else {
					jl_pname_1.setText("不存在");
					jl_pname_1.setIcon(new ImageIcon("image/no.png"));
					return;
				}
			}

		});

		jtf_pstatu.addFocusListener(new FocusListener() {
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
				if ("".equals(jtf_pstatu.getSelectedItem().toString())) {
					jl_pstatu_1.setIcon(new ImageIcon("image/no.png"));
					return;
				} else {
					jl_pstatu_1.setIcon(new ImageIcon("image/yes.png"));
				}
			}
		});

	}

	public Room getRoom() {
		Room room = new Room();
		room.setRid(Integer.parseInt(jtf_rid.getText()));
		room.setRname(jtf_rname.getText());
		room.setPstatu(jtf_pstatu.getSelectedItem().toString());
		room.setPname(jtf_pname.getText());
		String time = (((String) jc_week.getSelectedItem()).replace("星期", "")) + ","
				+ (String) (jc_day.getSelectedItem());
		room.setPtime(time);
		return room;

	}

	public void setValues(Room r) {

		jtf_rname.setText(r.getRname());
		jtf_rid.setText(String.valueOf(r.getRid()));
		jtf_pname.setText(r.getPname());
		jtf_pstatu.setSelectedItem(r.getPstatu());
		String ctime = r.getPtime();
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
		String name = jtf_rname.getText();
		String cno = jtf_rid.getText();
		String tno = jtf_pname.getText();
		String place = jtf_pstatu.getSelectedItem().toString();
		String week = (String) jc_week.getSelectedItem();
		String day = (String) jc_day.getSelectedItem();

		if ("".equals(name) || name == null)
			return false;
		if ("".equals(cno) || cno == null)
			return false;
		if ("".equals(tno) || tno == null)
			return false;
		if ("".equals(week) || week == null || "--请选择--".equals(week))
			return false;
		if ("".equals(day) || day == null || "--请选择--".equals(day))
			return false;
		if ("".equals(place) || place == null)
			return false;
		return true;

	}

	public void setEdit() {
		jtf_rname.setEnabled(false);
		jtf_rid.setEnabled(false);
		jtf_pstatu.setEnabled(false);
		jtf_rid.setEnabled(false);
		jc_week.setEnabled(false);
		jc_day.setEnabled(false);
		jtf_pname.setEnabled(false);
	}

	public static void main(String args[]) {
		// new RoomDialogView(jf).setVisible(true);
		// JFrame jf=new JFrame();
		Room r = new Room();
		r.setRid(11111);
		Admin a = new Admin();
		Student s = new Student();
		s.setSno("2012214324325");
		// System.out.print("rr");
		RoomDialogView cdv = new RoomDialogView(r, 0, null, s, null);
		cdv.setVisible(true);
		// jf.add(cdv);
		// System.out.print("rr");
		// jf.setSize(700, 700);
		// jf.setVisible(true);
	}
}
