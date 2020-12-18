package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.cn.dao.StudentDao;
import com.cn.model.Student;
import com.cn.util.StringUtil;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JInternalFrame {
	private JTextField name;
	private JTextField age;
	private JTextField address;
	private JTextField tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudent() {
		setIconifiable(true);
		setClosable(true);
		setTitle("新增学生");
		setBounds(100, 100, 260, 319);
		
		JLabel label = new JLabel("姓名：");
		
		name = new JTextField();
		name.setColumns(10);
		
		JLabel label_1 = new JLabel("年龄：");
		
		age = new JTextField();
		age.setColumns(10);
		
		JLabel label_2 = new JLabel("住址:");
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel label_3 = new JLabel("课程：");
		
		tel = new JTextField();
		tel.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		button.setIcon(new ImageIcon(AddStudent.class.getResource("/images/submit.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		button_1.setIcon(new ImageIcon(AddStudent.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tel))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(address))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(age)
										.addComponent(name, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(button)
							.addGap(27)
							.addComponent(button_1)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(label_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(44))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(button_1)
							.addContainerGap())))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	//提交
	private void submit() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String age = this.age.getText();
		String address = this.address.getText();
		String tel = this.tel.getText();
		
		if (StringUtil.isNull(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空!");
			return;
		}
		if (StringUtil.isNull(age)) {
			JOptionPane.showMessageDialog(null, "年龄不能为空!");
			return;
		}
		if (StringUtil.isNull(address)) {
			JOptionPane.showMessageDialog(null, "地址不能为空!");
			return;
		}
		if (StringUtil.isNull(tel)) {
			JOptionPane.showMessageDialog(null, "课程不能为空!");
			return;
		}
		
		Student student = new Student(0, name, age, address, tel);
		StudentDao studentDao = new StudentDao();
		int num = studentDao.writeStudent(student);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "新增成功！");
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "新增失败！");
		}
		
	}
	
	//清空
	private void reset() {
		// TODO Auto-generated method stub
		this.name.setText("");
		this.age.setText("");
		this.address.setText("");
		this.tel.setText("");
	}
}
