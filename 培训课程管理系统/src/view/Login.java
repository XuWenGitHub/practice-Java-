package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cn.dao.AdminDao;
import com.cn.model.Admin;
import com.cn.util.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		setTitle("欢迎来到学生培训管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("学生培训管理系统");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/学生.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));

		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
		label.setFont(new Font("宋体", Font.PLAIN, 14));

		username = new JTextField();
		username.setColumns(10);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/password.png")));
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));

		password = new JPasswordField();

		JButton button = new JButton("\u767B\u5F55");
		button.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});

		JButton btnNewButton = new JButton("重置");
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/images/reset.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(110, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(button).addGap(18)
								.addComponent(btnNewButton).addGap(
										120))
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
										.createParallelGroup(Alignment.TRAILING, false).addGroup(gl_contentPane
												.createSequentialGroup()
												.addComponent(label_1, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(password,
														GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(10)
												.addComponent(username, GroupLayout.PREFERRED_SIZE, 133,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel)).addGap(120)))));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(28).addComponent(lblNewLabel)
										.addGap(26)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(2)
														.addComponent(label))
												.addComponent(username, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(20)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 16,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(password, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNewButton).addComponent(button))
										.addContainerGap(26, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		ButtonGroup group = new ButtonGroup();

		// 居中显示
		this.setLocationRelativeTo(null);
	}

	private void reset() {
		// TODO Auto-generated method stub
		this.username.setText("");
		this.password.setText("");
	}

	private void Login() {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String password = new String(this.password.getPassword());

		if (StringUtil.isNull(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
			return;
		}

		if (StringUtil.isNull(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}

		AdminDao adminDao = new AdminDao();
		Map<String, String> map = adminDao.readAdmin();
		if (map.get(username) == null) {
			JOptionPane.showMessageDialog(null, "账号错误!");
			return;
		} else {
			if (!map.get(username).equals(password)) {
				JOptionPane.showMessageDialog(null, "密码错误!");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "登入成功!");
				frame.setVisible(false);
				AdminMainPage adminMainPage = new AdminMainPage();
				adminMainPage.setVisible(true);
			}
		}
	}
}
