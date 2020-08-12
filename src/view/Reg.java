package view;

//import java.awt.BorderLayout;
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

public class Reg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField idField;
	int xx, xy;
	private JTextField emailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
					frame.setUndecorated(true);  
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
	public Reg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reg.class.getResource("/images/LM128.png")));
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
				Reg.this.setLocation(x - xx, y - xy);
			}
		});
		lblNewLabel.setBounds(0, -11, 168, 435);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/bgLL.jpg")));
		
		Button regButton = new Button("Sign Up");
		regButton.setActionCommand("Sign Up");
		regButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				regButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				regButton.setBackground(new Color(220, 20, 60));
			}
		});
		regButton.setBackground(new Color(220, 20, 60));
		regButton.setForeground(Color.WHITE);
		regButton.setFont(new Font("Monospaced", Font.PLAIN, 13));
		regButton.setBounds(242, 246, 327, 39);
		contentPane.add(regButton);
		
		Button LogInPgButton = new Button("Try to Log In");
		LogInPgButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LogInPgButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LogInPgButton.setBackground(new Color(220, 20, 60));
			}
		});
		LogInPgButton.setForeground(Color.WHITE);
		LogInPgButton.setFont(new Font("Monospaced", Font.PLAIN, 13));
		LogInPgButton.setBackground(new Color(220, 20, 60));
		LogInPgButton.setBounds(242, 311, 327, 45);
		contentPane.add(LogInPgButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monospaced", Font.BOLD, 20));
		passwordField.setBounds(243, 196, 326, 35);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(242, 63, 113, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(242, 174, 113, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Already have an account?");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(242, 291, 233, 23);
		contentPane.add(lblNewLabel_1_2);
		
		idField = new JTextField();
		idField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		idField.setBounds(242, 85, 327, 35);
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
				Reg.this.setLocation(x - xx -169,y - xy);
			}
		});
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(169, 0, 419, 22);
		contentPane.add(panel_1);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Monospaced", Font.PLAIN, 16));
		emailField.setColumns(10);
		emailField.setBounds(242, 141, 327, 35);
		contentPane.add(emailField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Monospaced", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(242, 118, 113, 23);
		contentPane.add(lblNewLabel_1_3);
		
		regButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id= idField.getText();
				String eml=emailField.getText();
				@SuppressWarnings("deprecation")
				String pw= passwordField.getText();
				
				boolean rglt = core.Registration.signUp(id, pw, eml);
				
				if(rglt==true)
				{
					BkList a=new BkList();
					a.setUndecorated(true);
					a.setVisible(true);
					dispose();
				}
			}
		});
		LogInPgButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Login a=new Login();
				a.setUndecorated(true);
				a.setVisible(true);
				dispose();
				
			}
			
		});
	}
}
