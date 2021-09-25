package ia;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		getContentPane().setBackground(new Color(255, 204, 204));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 37, 175, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(37, 107, 99, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(37, 171, 99, 27);
		getContentPane().add(lblNewLabel_1_1);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(131, 107, 184, 29);
		getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(131, 171, 184, 27);
		getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("Login!");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(51, 102, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(117, 254, 89, 23);
		getContentPane().add(btnNewButton);
		setBackground(new Color(153, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(UIManager.getBorder("Button.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(249, 169, 382, 70);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton loginB = new JButton("Login!");
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from login where Username= '" + textField.getText() + "' and Password='" + passwordField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) 
						JOptionPane.showMessageDialog(null,"Login Sucesfull!");
					else 
						JOptionPane.showMessageDialog(null,"Incorrect username or password!");
					con.close();
					
				} catch(Exception b) {System.out.print(b);}
			}
		});
		loginB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		loginB.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(204, 204, 204), null, new Color(153, 153, 153), null));
		loginB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginB.setBounds(249, 421, 150, 33);
		contentPane.add(loginB);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(249, 285, 382, 70);
		contentPane.add(passwordField);
		
				
		JLabel username = new JLabel("Username:");			
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setBounds(152, 187, 87, 33);
		contentPane.add(username);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(152, 303, 87, 33);
		contentPane.add(password);
		
		JLabel login = new JLabel("LOGIN");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setHorizontalTextPosition(SwingConstants.CENTER);
		login.setFont(new Font("Tahoma", Font.BOLD, 30));
		login.setBounds(249, 68, 382, 70);
		contentPane.add(login);
		
		JLabel close = new JLabel("X");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setFont(new Font("Tahoma", Font.BOLD, 17));
		close.setHorizontalTextPosition(SwingConstants.CENTER);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setBounds(867, 0, 33, 25);
		contentPane.add(close);
		
		setUndecorated(true);
	}
}
