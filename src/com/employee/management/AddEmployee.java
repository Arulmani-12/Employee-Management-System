package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class AddEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_id;
	private JTextField txt_name;
	private JTextField txt_phone;
	private JTextField txt_salary;
	private JTextField txt_email;
	private JTextField txt_address;
	private JButton btnReset;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Employee Details");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 14));
		lblNewLabel.setBounds(277, 5, 387, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Emp_Id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(191, 60, 138, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Emp_Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(192, 123, 138, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Emp_Salary:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(191, 243, 138, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Emp_Email:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(191, 304, 138, 25);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Emp_Phone :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(191, 185, 138, 25);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Address :");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_2.setBounds(195, 360, 148, 39);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		txt_id = new JTextField();
		txt_id.setBounds(355, 61, 235, 34);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_name = new JTextField();
		txt_name.setColumns(10);
		txt_name.setBounds(354, 119, 235, 37);
		contentPane.add(txt_name);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(355, 179, 235, 39);
		contentPane.add(txt_phone);
		
		txt_salary = new JTextField();
		txt_salary.setColumns(10);
		txt_salary.setBounds(354, 236, 235, 41);
		contentPane.add(txt_salary);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(354, 300, 241, 40);
		contentPane.add(txt_email);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(353, 358, 241, 51);
		contentPane.add(txt_address);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setForeground(new Color(245, 245, 245));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Connection con = null;
				 PreparedStatement ps =null;
				try {
					int id = Integer.parseInt(txt_id.getText());
							String name = txt_name.getText();
				    String phone = txt_phone.getText();	
				   int salary = Integer.parseInt(txt_salary.getText());
				   String email = txt_email.getText();	
				   String address = txt_address.getText();
				   
						   con = ConnectionDB.getConnection();
						   
					 String sql = "insert into employee values(?,?,?,?,?,?)";
					 ps = con.prepareStatement(sql);
					 ps.setInt(1, id);
					 ps.setString(2, name);
					 ps.setString(3,phone);
					 ps.setInt(4, salary);
					 ps.setString(5, email);
					 ps.setString(6, address);
					 
					 int row = ps.executeUpdate();
					 
					 if (row == 1) {
						 JOptionPane.showMessageDialog(null, "Inserted SuccessFully...");
						
						
					 }
				}catch (InputMismatchException e1) {
			   JOptionPane.showMessageDialog(null, "Please Give Valid Details");
			   setVisible(false);
			}
				catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Please Give Valid Details");
					setVisible(false);
				}
				catch (Exception e2) {
				e2.printStackTrace();
				setVisible(false);
				}
				finally {
					try {
						if(con != null) {
						con.close();
						ps.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					
				}
			}
		});
		btnsubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsubmit.setBackground(new Color(0, 0, 0));
		btnsubmit.setBounds(208, 442, 145, 47);
		contentPane.add(btnsubmit);
		
		 btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(245, 245, 245));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
             txt_address.setText(" ");
             txt_email.setText(" ");
             txt_id.setText(" ");
             txt_name.setText(" ");
             txt_phone.setText(" ");
             txt_salary.setText(" ");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBackground(new Color(0, 0, 0));
		btnReset.setBounds(408, 442, 145, 47);
		contentPane.add(btnReset);
		
		JButton btnback = new JButton("Back");
		btnback.setForeground(new Color(245, 245, 245));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee frame = new Employee();
				frame.setVisible(true);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnback.setBackground(new Color(0, 0, 0));
		btnback.setBounds(579, 442, 145, 47);
		contentPane.add(btnback);
		setVisible(true);
	}
}
