package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.RoomDao;
import com.entity.Admin;
import com.entity.Room;
import com.entity.Student;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class RoomView extends JPanel implements MouseListener {
	JTable jt_room;
	// JComboBox jc_kind;
	JLabel jl_add;
	JLabel jl_del;
	JLabel jl_update;
	JComboBox jcb_statu;
	JComboBox jc_day;
	JComboBox jc_week;
	DefaultTableModel dm;
	private JLabel jl_refresh;
	private Admin a1;
	private Student s1;
	private Teacher t1;

	public RoomView() {
	}

	public void fillTable(Room room) {
		System.out.println("now is RoomView.fillTable");
		dm = (DefaultTableModel) jt_room.getModel();
		dm.setRowCount(0);

		String color1 = "blank";

		List<Room> list = new RoomDao().selectRoomList(room);
		for (Room rm : list) {
			if (rm.getPstatu().equals("�ѱ�ռ��"))
				color1 = "red";
			else if (rm.getPstatu().equals("ԤԼ��"))
				color1 = "purple";
			else if (rm.getPstatu().equals("����"))
				color1 = "green";
			else if (rm.getPstatu().equals("ԤԼ�ɹ�"))
				color1 = "blue";
			Vector<Object> v = new Vector<>();
			// v.add("<html><font color='" + color1 + "'>" + rm.getRid() +
			// "</font></html>");
			v.add(rm.getRid());
			v.add("<html><font color='" + color1 + "'>" + rm.getRname() + "</font></html>");
			v.add("<html><font color='" + color1 + "'>" + rm.getPname() + "</font></html>");

			String time = rm.getPtime();
			String week = null;
			if (time != null) {
				String[] times = time.split(",");
				// System.out.println(times[0]);
				week = "��" + String.valueOf(times[0]) + "��" + String.valueOf(times[1]) + "��";
			} else {
				week = "";
			}

			v.add("<html><font color='" + color1 + "'>" + rm.getPstatu() + "</font></html>");
			v.add("<html><font color='" + color1 + "'>" + week + "</font></html>");
			dm.addRow(v);
		}
	}

	public void fillEmptyTable(Room room) {
		dm = (DefaultTableModel) jt_room.getModel();
		dm.setRowCount(0);
		room.setPstatu("");
		String color1 = "green";
		String[] str = TableColums.getRoomColums();

		for (int j = 0; j < str.length; j++) {
			room.setRname(str[j]);

			String list = new RoomDao().checkRoomList(room);
			System.out.println("fff" + list);
			if (list == null) {
				Vector<Object> v = new Vector<>();
				// v.add("<html><font color='" + color1 + "'>" + rm.getRid() +
				// "</font></html>");

				v.add("<html><font color='" + color1 + "'>" + "��" + "</font></html>");
				if (room.getRname() != null)
					v.add("<html><font color='" + color1 + "'>" + room.getRname() + "</font></html>");
				else
					v.add("<html><font color='" + color1 + "'>" + "��" + "</font></html>");
				v.add("<html><font color='" + color1 + "'>" + "��" + "</font></html>");
				v.add("<html><font color='" + color1 + "'>" + "����" + "</font></html>");
				if (room.getPtime() != null) {
					String time = room.getPtime();
					String week = null;
					if (time != null) {
						String[] times = time.split(",");
						// System.out.println(times[0]);
						week = "��" + String.valueOf(times[0]) + "��" + String.valueOf(times[1]) + "��";
					} else {
						week = "";
					}
					v.add("<html><font color='" + color1 + "'>" + week + "</font></html>");

				} else
					v.add("<html><font color='" + color1 + "'>" + "��" + "</font></html>");

				dm.addRow(v);
			}
		}

	}

	public JPanel getRoomView(Admin a1, Student s1, Teacher t1) {
		return new RoomView(a1, s1, t1);
	}

	public RoomView(Admin a1, Student s1, Teacher t1) {
		System.out.println("now is RoomView");
		this.a1 = a1;
		this.s1 = s1;
		this.t1 = t1;
		setLayout(new BorderLayout(0, 0));
		JPanel jp_tool = new JPanel();
		add(jp_tool, BorderLayout.NORTH);

		jp_tool.setPreferredSize(new Dimension(960, 50));
		jp_tool.setLayout(null);

		jl_add = new JLabel("���");
		jl_add.setBounds(10, 10, 60, 30);
		jp_tool.add(jl_add);
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);

		jl_del = new JLabel("ɾ��");
		jl_del.setBounds(80, 10, 60, 30);
		jp_tool.add(jl_del);
		jl_del.setFont(MyFont.getMyFont());
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);

		jl_update = new JLabel("�޸�");
		jl_update.setBounds(150, 10, 60, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);

		jl_refresh = new JLabel("ˢ��");
		jl_refresh.setBounds(217, 11, 60, 30);
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		jp_tool.add(jl_refresh);

		if (a1 == null) {
			jl_del.setEnabled(false);
			jl_update.setEnabled(false);
		}

		jc_week = new JComboBox();
		jc_week.setBounds(350, 11, 130, 30);
		jc_week.setFont(MyFont.getMyFont());
		jp_tool.add(jc_week);
		jc_week.addItem("ѡ��ԤԼ�ܼ�");
		String[] weeks = CommboxData.getWeeks();
		for (String data : weeks) {
			jc_week.addItem(data);
		}

		jc_day = new JComboBox();
		jc_day.setFont(MyFont.getMyFont());
		jc_day.addItem("ѡ��ԤԼʱ��");
		String[] days = CommboxData.getDays();
		for (String data : days) {
			jc_day.addItem(data);
		}

		jc_day.setBounds(500, 11, 130, 30);
		jp_tool.add(jc_day);

		jcb_statu = new JComboBox();
		jcb_statu.setBounds(657, 11, 130, 30);
		jcb_statu.setFont(MyFont.getMyFont());
		jp_tool.add(jcb_statu);
		jcb_statu.addItem("ѡ��ԤԼ״̬");
		jp_tool.add(jcb_statu);
		String[] statukinds = CommboxData.getPstatu();
		for (String data : statukinds) {
			jcb_statu.addItem(data);
		}

		JButton btn_submit = new JButton("��ѯ");
		jp_tool.add(btn_submit);
		btn_submit.setBounds(807, 11, 100, 30);
		btn_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Room r1 = new Room();

				r1.setPstatu((String) jcb_statu.getSelectedItem());

				if (r1.getPstatu().equals("����")) {
					String time = (((String) jc_week.getSelectedItem()).replace("����", "")) + ","
							+ (String) (jc_day.getSelectedItem());
					r1.setPtime(time);
					fillEmptyTable(r1);
				} else
					fillTable(r1);
			}

		});

		String[] subjects = CommboxData.getSubjects();
		jt_room = new JTable(new DefaultTableModel(TableColums.getAdminRoomColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_room.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_room.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_room);
		fillTable(new Room());
		JScrollPane js = new JScrollPane(jt_room);
		this.add(js, BorderLayout.CENTER);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_room.getSelectedRow();
		if (e.getSource() == jl_add) {
			Room r = new Room();
			r.setRname(jt_room.getValueAt(row, 1).toString().replaceAll("</?[a-zA-Z]+[^><]*>", ""));
			String A = jt_room.getValueAt(row, 4).toString().replaceAll("</?[a-zA-Z]+[^><]*>", "");

			r.setPtime(A.replaceAll("��", "").replaceAll("��", ",").replaceAll("��", ""));
			if (a1 != null)
				new RoomDialogView(r, 0, a1, null, null).setVisible(true);
			if (s1 != null)
				new RoomDialogView(r, 0, null, s1, null).setVisible(true);
			if (t1 != null)
				new RoomDialogView(r, 0, null, null, t1).setVisible(true);
		} else if (e.getSource() == jl_del && row >= 0) {

			int[] selections = jt_room.getSelectedRows();
			// ��tableModelͳһ���
			for (int i = 0; i < selections.length; i++) {
				selections[i] = jt_room.convertRowIndexToModel(selections[i]);
			}
			
			// ��ȡmodel
			DefaultTableModel df = (DefaultTableModel) jt_room.getModel();
			// ����ɾ��
			int j = 0;
			for (int i = 0; i < selections.length; i++) {
				Room r = new Room();
				r.setRid((int) (jt_room.getValueAt(i, 0)));
				Room s = new RoomDao().selectRoom(r);
				if (new RoomDao().delRoom(s) <= 0)
					JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
				else
					j++;
				// new RoomDialogView(r, 1, a1, null, null).setVisible(true);
				// System.out.println(jt_room.getValueAt(i, 0));
			}
			JOptionPane.showMessageDialog(this, "�ɹ�ɾ��" + j + "����¼��");

		} else if (e.getSource() == jl_update && row >= 0) {
			Room r = new Room();
			r.setRid((int) (jt_room.getValueAt(row, 0)));
			Room s = new RoomDao().selectRoom(r);

			new RoomDialogView(r, 2, a1, null, null).setVisible(true);

		} else if (e.getSource() == jl_refresh) {
			fillTable(new Room());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "��ӽ���" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "ɾ������" + "</font></html>");
		} else if (e.getSource() == jl_update) {
			jl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_update.setText("<html><font color='#336699' style='font-weight:bold'>" + "����޸�" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "ˢ��" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("���");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("ɾ��");
		} else if (e.getSource() == jl_update) {
			jl_update.setText("���");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setText("ˢ��");
		}
	}

	public static void main(String args[])

	{
		JFrame jf = new JFrame();
		Admin a = new Admin();
		a.setAid(1);
		RoomView cmv = new RoomView(a, null, null);
		jf.add(cmv);
		jf.setSize(1000, 600);
		jf.setVisible(true);

	}
}
