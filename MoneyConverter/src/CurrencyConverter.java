import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CurrencyConverter extends JFrame {

	private JPanel contentPane;
	private JTextField value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter frame = new CurrencyConverter();
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
	public CurrencyConverter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(240, 230, 140), new Color(240, 230, 140), new Color(240, 230, 140), new Color(240, 230, 140)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter value:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(28, 84, 97, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(28, 143, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(28, 194, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		value = new JTextField();
		value.addKeyListener(new KeyAdapter() {
			@Override
			//only numbers are allowed!
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || ( c == KeyEvent.VK_DELETE))) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Only numbers allowed!");
				}
			}
		});
		value.setFont(new Font("Tahoma", Font.PLAIN, 17));		
		value.setBounds(160, 84, 165, 27);
		contentPane.add(value);
		value.setColumns(10);
		
		JComboBox from = new JComboBox();
		from.addItem("EUR");
		from.addItem("USD");
		from.addItem("RON");
		from.setFont(new Font("Tahoma", Font.PLAIN, 17));
		from.setBounds(160, 142, 165, 22);
		contentPane.add(from);
		
		JComboBox to = new JComboBox();
		to.addItem("EUR");
		to.addItem("USD");
		to.addItem("RON");
		to.setFont(new Font("Tahoma", Font.PLAIN, 17));
		to.setBounds(160, 193, 165, 22);
		contentPane.add(to);
		
		JLabel lblNewLabel_3 = new JLabel("CURRENCY CONVERTER");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_3.setBounds(10, 11, 430, 33);
		contentPane.add(lblNewLabel_3);
		
		JButton convert = new JButton("Convert");
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double tot;
				
				Double amount = Double.parseDouble(value.getText());
				
				//conversion between different currencies
				if(from.getSelectedItem().toString() ==  "EUR" && to.getSelectedItem().toString() == "USD") {
					tot = amount * 1.1716;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				} 
				else if(from.getSelectedItem().toString() ==  "EUR" && to.getSelectedItem().toString() == "RON") {
					tot = amount * 4.95;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				} 
				else if(from.getSelectedItem().toString() ==  "EUR" && to.getSelectedItem().toString() == "EUR") {
					tot = amount * 1;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				}
				else if(from.getSelectedItem().toString() ==  "USD" && to.getSelectedItem().toString() == "USD") {
					tot = amount * 1;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				} 
				else if(from.getSelectedItem().toString() ==  "USD" && to.getSelectedItem().toString() == "EUR") {
					tot = amount * 0.85;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				} 
				else if(from.getSelectedItem().toString() ==  "USD" && to.getSelectedItem().toString() == "RON") {
					tot = amount * 4.22;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				}
				else if(from.getSelectedItem().toString() ==  "RON" && to.getSelectedItem().toString() == "RON") {
					tot = amount * 1;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				} 
				else if(from.getSelectedItem().toString() ==  "RON" && to.getSelectedItem().toString() == "EUR") {
					tot = amount * 0.20;
					JOptionPane.showMessageDialog(null, "Your amount will be:" + tot.toString());
				}
				else if(from.getSelectedItem().toString() ==  "RON" && to.getSelectedItem().toString() == "USD") {
					tot = amount * 0.24;
					JOptionPane.showMessageDialog(null,  "Your amount will be:" + tot.toString());
				}
			}
		});
		convert.setBackground(new Color(240, 230, 140));
		convert.setForeground(new Color(0, 0, 0));
		convert.setFont(new Font("Tahoma", Font.PLAIN, 17));
		convert.setBounds(71, 243, 97, 28);
		contentPane.add(convert);
		
		JButton exit = new JButton("Exit");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exit.setBackground(new Color(240, 230, 140));
		exit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		exit.setBounds(249, 243, 102, 28);
		contentPane.add(exit);
		
		setUndecorated(true);
	}
}
