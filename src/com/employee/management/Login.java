package com.employee.management;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
//import javax.swing.JPopupMenu;
//import java.awt.Component;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
//import javax.swing.JToggleButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtuser;
	private JTextField txtpass;
	private JLabel lab1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(153, 29, 179, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblUsername.setBounds(60, 129, 179, 40);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblPassword.setBounds(60, 204, 179, 40);
		contentPane.add(lblPassword);
		
		txtuser = new JTextField();
		txtuser.setBounds(193, 132, 204, 40);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(193, 207, 204, 40);
		contentPane.add(txtpass);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setBackground(new Color(245, 222, 179));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
				PreparedStatement st = null;
				ResultSet rs = null;
				   String name =  txtuser.getText();
				   String pass = txtpass.getText();
				   String sql = "select * from login where username= ? and password = ?";
				try {
					 c = ConnectionDB.getConnection();
					 st = c.prepareStatement(sql);
					st.setString(1, name);
					st.setString(2, pass);
					
					rs = st.executeQuery();
//					rs.next();
					if(rs.next()) {
						setVisible(false);
						Employee frame = new Employee();
						frame.setVisible(true);
					} 
					c.close();
					st.close();
					rs.close();
					
					
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(null, "Invalid Password");
					new Login();
				}
				
				
				
			}
		});
		btnsubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsubmit.setBounds(163, 313, 133, 47);
		contentPane.add(btnsubmit);
		
		 lab1 = new JLabel("");
		lab1.setBounds(154, 389, 156, 28);
		contentPane.add(lab1);
	}
	
////	@SuppressWarnings("unused")
////	private static void addPopup(Component component, final JPopupMenu popup) {
////		component.addMouseListener(new MouseAdapter() {
////			public void mousePressed(MouseEvent e) {
////				if (e.isPopupTrigger()) {
////					showMenu(e);
////				}
////			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			private void showMenu(MouseEvent e) {
//				popup.show(e.getComponent(), e.getX(), e.getY());
//			}
//		});
//	}
}