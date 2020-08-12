package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField idField;
	int xx, xy;
	//static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);  //remove border
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/LM128.png")));
		setTitle("Library Management System");
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 169, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Login.this.setLocation(x - xx, y - xy);
			}
		});
		lblNewLabel.setBounds(0, -11, 168, 435);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/bgLL.jpg")));
		
		Button logInButton = new Button("Log In");
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logInButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInButton.setBackground(new Color(220, 20, 60));
			}
		});
		logInButton.setBackground(new Color(220, 20, 60));
		logInButton.setForeground(Color.WHITE);
		logInButton.setFont(new Font("Monospaced", Font.PLAIN, 13));
		logInButton.setBounds(242, 246, 327, 45);
		contentPane.add(logInButton);
		
		Button RegButton = new Button("Create Account Now");
		RegButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RegButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RegButton.setBackground(new Color(220, 20, 60));
			}
		});
		RegButton.setForeground(Color.WHITE);
		RegButton.setFont(new Font("Monospaced", Font.PLAIN, 13));
		RegButton.setBackground(new Color(220, 20, 60));
		RegButton.setBounds(242, 311, 327, 45);
		contentPane.add(RegButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monospaced", Font.BOLD, 20));
		passwordField.setBounds(243, 187, 326, 45);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(242, 96, 113, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(242, 165, 113, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Don't have a account?");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(242, 291, 233, 23);
		contentPane.add(lblNewLabel_1_2);
		
		idField = new JTextField();
		idField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		idField.setBounds(242, 119, 327, 45);
		contentPane.add(idField);
		idField.setColumns(10);
		
		Label labelClose = new Label("\u00D7");
		labelClose.setAlignment(Label.CENTER);
		labelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelClose.setBackground(new Color(220, 20, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelClose.setBackground(Color.DARK_GRAY);
			}
		});
		labelClose.setFont(new Font("Dialog", Font.BOLD, 18));
		labelClose.setForeground(Color.WHITE);
		labelClose.setBackground(Color.DARK_GRAY);
		labelClose.setBounds(632, 0, 32, 22);
		contentPane.add(labelClose);
		
		Label labelMinimise = new Label("-");
		labelMinimise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				labelMinimise.setBackground(new Color(220, 20, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelMinimise.setBackground(Color.DARK_GRAY);
			}
		});
		labelMinimise.setForeground(Color.WHITE);
		labelMinimise.setFont(new Font("Monospaced", Font.BOLD, 18));
		labelMinimise.setBackground(Color.DARK_GRAY);
		labelMinimise.setAlignment(Label.CENTER);
		labelMinimise.setBounds(594, 0, 32, 22);
		contentPane.add(labelMinimise);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Login.this.setLocation(x - xx -169,y - xy);
			}
		});
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(169, 0, 419, 22);
		contentPane.add(panel_1);
		
		logInButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id= idField.getText();
				@SuppressWarnings("deprecation")
				String pw= passwordField.getText();
				
				boolean rglt = core.Registration.signIn(id, pw);
				
				if(rglt==true)
				{
					BkList a=new BkList();
					a.setUndecorated(true);
					a.setVisible(true);
					dispose();
				}
				
			}
			
		});
		RegButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Reg a=new Reg();
				a.setUndecorated(true);
				a.setVisible(true);
				dispose();
				
			}
			
		});
	}
}
