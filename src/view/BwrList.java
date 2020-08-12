package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

//import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

//import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Toolkit;

//import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.border.SoftBevelBorder;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
//import java.awt.Dialog.ModalExclusionType;
//import java.awt.Window.Type;

public class BwrList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int xx, xy, x;
	private JTable table;
	private JTextField idField;
	private JTextField nmField;
	private JTextField bidField;
	private JTextField pnNoField;
	private JTextField addField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BwrList frame = new BwrList();
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
	public BwrList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BwrList.class.getResource("/images/LM128.png")));
		setTitle("Library Management System");
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 422);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button LogOutButton = new Button("Log Out");
		LogOutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LogOutButton.setBackground(new Color(44,44,44));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LogOutButton.setBackground(Color.DARK_GRAY);
			}
		});
		LogOutButton.setFont(new Font("Monospaced", Font.PLAIN, 11));
		LogOutButton.setForeground(Color.LIGHT_GRAY);
		LogOutButton.setBackground(Color.DARK_GRAY);
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a=new Login();
				a.setUndecorated(true);
				a.setVisible(true);
				dispose();
			}
		});
		LogOutButton.setActionCommand("Log Out");
		LogOutButton.setBounds(584, 398, 72, 20);
		contentPane.add(LogOutButton);
		
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
				BwrList.this.setLocation(x - xx, y - xy);
			}
		});
		lblNewLabel.setBounds(0, -11, 168, 435);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/bgLL.jpg")));
		
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
		
		JPanel panel_ber = new JPanel();
		panel_ber.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		panel_ber.setForeground(Color.DARK_GRAY);
		
		panel_ber.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		panel_ber.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				BwrList.this.setLocation(x - xx -169,y - xy);
			}
		});
		panel_ber.setBackground(Color.DARK_GRAY);
		panel_ber.setBounds(169, 0, 495, 25);
		contentPane.add(panel_ber);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBounds(185, 170, 472, 223);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(7, 7, 458, 210);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Borrowed Book", "Book Id", "Phone No.", "Address"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(124);
		table.getColumnModel().getColumn(2).setPreferredWidth(143);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(136);
		
		ArrayList<core.BorrowerList> lst = core.BorrowerList.getList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[6];
		x = lst.size();
		for(int i=0;i<x;i++)
		{
			row[0]=lst.get(i).id;
			row[1]=lst.get(i).name;
			row[2]=lst.get(i).brwdBk;
			row[3]=lst.get(i).bid;
			row[4]=lst.get(i).pnNo;
			row[5]=lst.get(i).address;
			model.addRow(row);
		}
		
		JPanel ActivePanel = new JPanel();
		ActivePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ActivePanel.setBackground(new Color(85,85,85));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ActivePanel.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				BkList a=new BkList();
				a.setUndecorated(true);
				a.setVisible(true);
				dispose();
			}
		});
		ActivePanel.setBackground(Color.GRAY);
		ActivePanel.setBounds(169, 25, 247, 38);
		contentPane.add(ActivePanel);
		
		JLabel BkLabel_btn = new JLabel("Book List");
		ActivePanel.add(BkLabel_btn);
		BkLabel_btn.setFont(new Font("Monospaced", Font.BOLD, 15));
		BkLabel_btn.setForeground(Color.WHITE);
		BkLabel_btn.setHorizontalAlignment(SwingConstants.CENTER);
		BkLabel_btn.setLabelFor(ActivePanel);
		
		JPanel InactivePanel = new JPanel();

		InactivePanel.setBackground(Color.DARK_GRAY);
		InactivePanel.setBounds(417, 25, 247, 38);
		contentPane.add(InactivePanel);
		
		idField = new JTextField();
		idField.setForeground(Color.BLACK);
		idField.setToolTipText("Input only ID, if you want to REMOVE any Borrower.");
		idField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		idField.setBounds(261, 74, 141, 22);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(185, 74, 86, 22);
		contentPane.add(idLabel);
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		nameLabel.setBounds(437, 74, 86, 22);
		contentPane.add(nameLabel);
		
		nmField = new JTextField();
		nmField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		nmField.setColumns(10);
		nmField.setBounds(513, 74, 141, 22);
		contentPane.add(nmField);
		
		JLabel bkidLabel = new JLabel("Book Id :");
		bkidLabel.setForeground(Color.WHITE);
		bkidLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		bkidLabel.setBounds(185, 107, 86, 22);
		contentPane.add(bkidLabel);
		
		bidField = new JTextField();
		bidField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		bidField.setColumns(10);
		bidField.setBounds(261, 107, 141, 22);
		contentPane.add(bidField);
		
		JLabel pnNoLabel = new JLabel("Phone No. :");
		pnNoLabel.setForeground(Color.WHITE);
		pnNoLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		pnNoLabel.setBounds(437, 107, 86, 22);
		contentPane.add(pnNoLabel);
		
		pnNoField = new JTextField();
		pnNoField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		pnNoField.setColumns(10);
		pnNoField.setBounds(513, 107, 141, 22);
		contentPane.add(pnNoField);
		
		JLabel addLabel = new JLabel("Address :");
		addLabel.setForeground(Color.WHITE);
		addLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		addLabel.setBounds(185, 140, 86, 22);
		contentPane.add(addLabel);
		
		addField = new JTextField();
		addField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		addField.setColumns(10);
		addField.setBounds(261, 140, 141, 22);
		contentPane.add(addField);
		
		
		
		Button AddBwrButton = new Button("Add Borrower");
		AddBwrButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddBwrButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AddBwrButton.setBackground(new Color(220, 20, 60));
			}
		});
		AddBwrButton.setForeground(Color.WHITE);
		AddBwrButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		AddBwrButton.setBackground(new Color(220, 20, 60));
		AddBwrButton.setBounds(425, 135, 100, 29);
		contentPane.add(AddBwrButton);
		
		JLabel bwrLabel_btn = new JLabel("Borrower List");
		bwrLabel_btn.setHorizontalAlignment(SwingConstants.CENTER);
		InactivePanel.add(bwrLabel_btn);
		bwrLabel_btn.setBackground(Color.WHITE);
		bwrLabel_btn.setForeground(Color.WHITE);
		bwrLabel_btn.setFont(new Font("Monospaced", Font.BOLD, 15));
		bwrLabel_btn.setLabelFor(InactivePanel);

		JLabel bkRecvLabel = new JLabel("Receivable Books: "+core.BorrowerList.bwrCount());
		bkRecvLabel.setForeground(Color.WHITE);
		bkRecvLabel.setFont(new Font("Monospaced", Font.PLAIN, 11));
		bkRecvLabel.setBounds(185, 395, 180, 20);;
		contentPane.add(bkRecvLabel);
		
		Button RmvBwrButton = new Button("Remove By ID");
		RmvBwrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean r = core.BorrowerList.removeBwr(idField.getText());
				if(r==true)
				{
					DefaultTableModel model2 = (DefaultTableModel)table.getModel();
					Object[] row = new Object[6];
					model2.setRowCount(0);
					ArrayList<core.BorrowerList> lst1 = core.BorrowerList.getList();
					for(int i=0;i<lst1.size();i++)
					{
						row[0]=lst1.get(i).id;
						row[1]=lst1.get(i).name;
						row[2]=lst1.get(i).brwdBk;
						row[3]=lst1.get(i).bid;
						row[4]=lst1.get(i).pnNo;
						row[5]=lst1.get(i).address;
						model2.addRow(row);
					}
					
					bkRecvLabel.setText("Receivable Books: "+core.BorrowerList.bwrCount());
				}
			}
		});
		RmvBwrButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RmvBwrButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RmvBwrButton.setBackground(new Color(220, 20, 60));
			}
		});
		RmvBwrButton.setForeground(Color.WHITE);
		RmvBwrButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		RmvBwrButton.setBackground(new Color(220, 20, 60));
		RmvBwrButton.setBounds(531, 135, 125, 29);
		contentPane.add(RmvBwrButton);
		
		AddBwrButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id= idField.getText();
				String nm= nmField.getText();
				int bid= Integer.parseInt(bidField.getText());
				String pnNo= pnNoField.getText();
				String add= addField.getText();
				
				core.BorrowerList.addBwr(id, nm, bid, pnNo, add);
				ArrayList<core.BorrowerList> lst2 = core.BorrowerList.getList();
				
				DefaultTableModel model1 = (DefaultTableModel)table.getModel();
				Object[] row = new Object[6];
				model1.setRowCount(0);
				for(int i=0;i<lst2.size();i++)
				{
					row[0]=lst2.get(i).id;
					row[1]=lst2.get(i).name;
					row[2]=lst2.get(i).brwdBk;
					row[3]=lst2.get(i).bid;
					row[4]=lst2.get(i).pnNo;
					row[5]=lst2.get(i).address;
					model1.addRow(row);
				}
				
				bkRecvLabel.setText("Receivable Books: "+core.BorrowerList.bwrCount());
					//main(null);
					//dispose();
				}
		});
	}
	
	public JTable getTable() {
		return table;
	}
}
