package com.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.dao.ThingDao;
import com.entity.Thing;
import com.util.Frame;
import com.util.Location;
import com.util.MyFont;

public class ThingDialogView extends JDialog implements MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtf_thno;
	public JTextField jtf_thtext;
	private JTextField jtf_thtime;
	JLabel jl_thno_1;
	JLabel jl_thtext_1;
	JLabel jl_thtime_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public ThingDialogView(Thing th, int flag) {
		setSize(483, 504);
		Location.setCenter(this);
		this.setTitle("通知信息");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel jl_thno = new JLabel("通知编号:");
			jl_thno.setBounds(74, 87, 68, 30);
			contentPanel.add(jl_thno);
			jl_thno.setFont(MyFont.getMyFont());
		}

		JLabel jl_thtext = new JLabel("通知内容:");
		jl_thtext.setBounds(74, 127, 68, 30);
		contentPanel.add(jl_thtext);
		jl_thtext.setFont(MyFont.getMyFont());

		JLabel jl_thtime_1 = new JLabel("通知时间:");
		jl_thtime_1.setBounds(74, 177, 68, 30);
		contentPanel.add(jl_thtime_1);
		jl_thtime_1.setFont(MyFont.getMyFont());

		JLabel lblNewLabel = new JLabel("通知信息");
		lblNewLabel.setFont(new Font("方正舒体", Font.BOLD, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 27, 254, 50);
		contentPanel.add(lblNewLabel);

		jtf_thno = new JTextField();
		jtf_thno.setBounds(158, 87, 205, 30);
		contentPanel.add(jtf_thno);
		jtf_thno.setColumns(10);
		jtf_thno.setFont(MyFont.getMyFont());

		jtf_thtext = new JTextField();
		jtf_thtext.setColumns(10);
		jtf_thtext.setBounds(158, 128, 205, 30);
		contentPanel.add(jtf_thtext);
		jtf_thtext.setFont(MyFont.getMyFont());
		jtf_thtext.addMouseListener(this);

		jtf_thtime = new JTextField();
		jtf_thtime.setColumns(10);
		jtf_thtime.setBounds(158, 172, 205, 30);
		contentPanel.add(jtf_thtime);
		jtf_thtime.setFont(MyFont.getMyFont());

		JButton jb_submit = new JButton("New button");
		jb_submit.setBounds(181, 256, 100, 30);
		contentPanel.add(jb_submit);
		jb_submit.setFont(MyFont.getMyFont());

		jl_thno_1 = new JLabel("");
		jl_thno_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_thno_1.setBounds(373, 87, 84, 30);
		contentPanel.add(jl_thno_1);

		jl_thtext_1 = new JLabel("");
		jl_thtext_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_thtext_1.setBounds(373, 127, 84, 30);
		contentPanel.add(jl_thtext_1);

		jl_thtime_1 = new JLabel("");
		jl_thtime_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		jl_thtime_1.setBounds(373, 171, 84, 30);
		contentPanel.add(jl_thtime_1);

		if (flag == 0) {
			// jtf_thtime.setText(th.getThingno());
			// jtf_thtime.setEditable(false);
			//
			// jtf_thtime.setText(th.getThingtime());
			// jtf_thtime.setEditable(false);
			//
			// jtf_thtext.setText(th.getThingtext());
			// jtf_thtext.setEditable(false);
			jb_submit.setText("发布");
		} else if (flag == 1) {
			jb_submit.setText("删除");
			Thing th1 = new ThingDao().selectThing(th);
			setValues(th1);
			setEdit();
		} else if (flag == 2) {
			jtf_thno.setEnabled(false);
			jb_submit.setText("修改");
			Thing th2 = new ThingDao().selectThing(th);
			setValues(th2);
		} else {

		}
		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag == 0) {

					if (!isNull()) {
						JOptionPane.showMessageDialog(ThingDialogView.this, "有未输入的值");
						return;
					}
					System.out.println("r" + jtf_thno.getText() + "y");
					Thing th1 = getThing();
					System.out.println("e" + th1.getThingno() + "r");
					// Thing th1=new RoomDao().selectRoom(r);
					int i = new ThingDao().insertThing(th1);
					if (i == 1) {
						JOptionPane.showMessageDialog(ThingDialogView.this, "添加成功");
						ThingDialogView.this.dispose();
						return;
					} else {
						JOptionPane.showMessageDialog(ThingDialogView.this, "添加失败");
					}
				} else if (flag == 1) {
					int i = new ThingDao().delThing(th);
					if (i == 0) {
						JOptionPane.showMessageDialog(ThingDialogView.this, "删除失败");
					} else {
						JOptionPane.showMessageDialog(ThingDialogView.this, "删除成功");
					}
					ThingDialogView.this.dispose();
					return;
				} else if (flag == 2) {

					Thing th = getThing();
					if (!isNull()) {
						JOptionPane.showMessageDialog(ThingDialogView.this, "有未输入的值");
						return;
					}
					int update = new ThingDao().updateThing(th);
					if (update == 0) {
						JOptionPane.showMessageDialog(ThingDialogView.this, "修改失败");
						return;
					} else {
						JOptionPane.showMessageDialog(ThingDialogView.this, "修改成功");
						ThingDialogView.this.dispose();
						return;
					}
				}
			}

		});

		jtf_thno.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {

				Thing th1 = new Thing();
				th1.setThingno(jtf_thno.getText());
				Thing r = new ThingDao().selectThing(th1);
				if (r != null) {
					jl_thno_1.setIcon(new ImageIcon("image/no.png"));
					jl_thno_1.setText("已存在");
					return;
				} else {
					jl_thno_1.setIcon(new ImageIcon("image/yes.png"));
					jl_thno_1.setText("");
				}

			}

		});

		jtf_thtime.addFocusListener(new FocusListener()

		{

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {

			}

		});

	}

	public Thing getThing() {
		Thing th = new Thing();
		th.setThingno(jtf_thno.getText());
		th.setThingtext(jtf_thtext.getText());
		th.setThingtime(jtf_thtime.getText());
		return th;
	}

	public void setValues(Thing th) {

		jtf_thtext.setText(th.getThingtext());
		jtf_thno.setText(th.getThingno());
		jtf_thtime.setText(th.getThingtime());

	}

	public boolean isNull() {
		String name = jtf_thtext.getText();
		String cno = jtf_thno.getText();
		String tno = jtf_thtime.getText();

		if ("".equals(name) || name == null)
			return false;
		if ("".equals(cno) || cno == null)
			return false;
		if ("".equals(tno) || tno == null)
			return false;
		return true;

	}

	public void setEdit() {
		jtf_thtext.setEnabled(false);
		jtf_thno.setEnabled(false);
		jtf_thtime.setEnabled(false);
	}

	public static void main(String args[]) {
		// new RoomDialogView(jf).setVisible(true);
		// JFrame jf=new JFrame();
		Thing r = new Thing();
		r.setThingno("1");

		// System.out.print("rr");
		ThingDialogView cdv = new ThingDialogView(r, 2);
		cdv.setVisible(true);
		// jf.add(cdv);
		// System.out.print("rr");
		// jf.setSize(700, 700);
		// jf.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Frame frame = new Frame(this, jtf_thtext.getText());
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 基础的一些构造 frame
		frame.setVisible(false);
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

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
