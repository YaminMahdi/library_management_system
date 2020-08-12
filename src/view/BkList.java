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
//import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.border.SoftBevelBorder;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;
//import javax.swing.JButton;
//import java.awt.EventQueue;

public class BkList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int xx, xy, x;
	private JTable table;
	private JTextField bkNmField;
	private JTextField autrField;
	private JTextField QuatField;
	private JTextField subField;
	private JTextField SecField;
	//static BkList frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BkList frame = new BkList();
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
	public BkList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BkList.class.getResource("/images/LM128.png")));
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
		
		JLabel backLabel_btn = new JLabel("");
		backLabel_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<core.BookList> lst = core.BookList.getList();
				DefaultTableModel model1 = (DefaultTableModel)table.getModel();
				model1.setRowCount(0);
				Object[] row = new Object[6];
				for(int i=0;i<lst.size();i++)
				{
					row[0]=lst.get(i).bId;
					row[1]=lst.get(i).name;
					row[2]=lst.get(i).author;
					row[3]=lst.get(i).quantity;
					row[4]=lst.get(i).subject;
					row[5]=lst.get(i).section;
					model1.addRow(row);
				}
				backLabel_btn.setVisible(false);
			}
		});
		backLabel_btn.setIcon(new ImageIcon(BkList.class.getResource("/images/back25wh.png")));
		backLabel_btn.setBounds(180, 31, 25, 25);
		contentPane.add(backLabel_btn);
		backLabel_btn.setVisible(false);
		
		
		
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
				BkList.this.setLocation(x - xx, y - xy);
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
				BkList.this.setLocation(x - xx -169,y - xy);
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
				"Book ID", "Book Name", "Author", "Quantity", "Subject", "Section"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(144);
		table.getColumnModel().getColumn(2).setPreferredWidth(139);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		ArrayList<core.BookList> lst = core.BookList.getList();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		Object[] row = new Object[6];
		x=lst.size();
		for(int i=0;i<x;i++)
		{
			row[0]=lst.get(i).bId;
			row[1]=lst.get(i).name;
			row[2]=lst.get(i).author;
			row[3]=lst.get(i).quantity;
			row[4]=lst.get(i).subject;
			row[5]=lst.get(i).section;
			model.addRow(row);
		}
		
		JPanel ActivePanel = new JPanel();
		ActivePanel.setBackground(Color.DARK_GRAY);
		ActivePanel.setBounds(169, 25, 247, 38);
		contentPane.add(ActivePanel);
		
		JLabel BkLabel_btn = new JLabel("Book List");
		ActivePanel.add(BkLabel_btn);
		BkLabel_btn.setFont(new Font("Monospaced", Font.BOLD, 15));
		BkLabel_btn.setForeground(Color.WHITE);
		BkLabel_btn.setHorizontalAlignment(SwingConstants.CENTER);
		BkLabel_btn.setLabelFor(ActivePanel);
		
		JPanel InactivePanel = new JPanel();
		InactivePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				InactivePanel.setBackground(new Color(85,85,85));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				InactivePanel.setBackground(Color.GRAY);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				BwrList a=new BwrList();
				a.setUndecorated(true);
				a.setVisible(true);
				dispose();
			}
		});
		InactivePanel.setBackground(Color.GRAY);
		InactivePanel.setBounds(417, 25, 247, 38);
		contentPane.add(InactivePanel);
		
		bkNmField = new JTextField();
		bkNmField.setToolTipText("Input only Book Name, if you want to SEARCH any Book.");
		bkNmField.setForeground(Color.BLACK);
		bkNmField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		bkNmField.setBounds(261, 74, 141, 22);
		contentPane.add(bkNmField);
		bkNmField.setColumns(10);
		
		JLabel bNmLabel = new JLabel("Book Name :");
		bNmLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		bNmLabel.setForeground(Color.WHITE);
		bNmLabel.setBounds(185, 74, 86, 22);
		contentPane.add(bNmLabel);
		
		JLabel authorLabel = new JLabel("Author :");
		authorLabel.setForeground(Color.WHITE);
		authorLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		authorLabel.setBounds(437, 74, 86, 22);
		contentPane.add(authorLabel);
		
		autrField = new JTextField();
		autrField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		autrField.setColumns(10);
		autrField.setBounds(513, 74, 141, 22);
		contentPane.add(autrField);
		
		JLabel QuanLabel = new JLabel("Quantity :");
		QuanLabel.setForeground(Color.WHITE);
		QuanLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		QuanLabel.setBounds(185, 107, 86, 22);
		contentPane.add(QuanLabel);
		
		QuatField = new JTextField();
		QuatField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		QuatField.setColumns(10);
		QuatField.setBounds(261, 107, 141, 22);
		contentPane.add(QuatField);
		
		JLabel SubLabel = new JLabel("Subject :");
		SubLabel.setForeground(Color.WHITE);
		SubLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		SubLabel.setBounds(437, 107, 86, 22);
		contentPane.add(SubLabel);
		
		subField = new JTextField();
		subField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		subField.setColumns(10);
		subField.setBounds(513, 107, 141, 22);
		contentPane.add(subField);
		
		JLabel SecLabel = new JLabel("Section :");
		SecLabel.setForeground(Color.WHITE);
		SecLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		SecLabel.setBounds(185, 140, 86, 22);
		contentPane.add(SecLabel);
		
		SecField = new JTextField();
		SecField.setFont(new Font("Monospaced", Font.PLAIN, 12));
		SecField.setColumns(10);
		SecField.setBounds(261, 140, 141, 22);
		contentPane.add(SecField);
		
		int a=core.BookList.bkCount();
		int b=core.BorrowerList.bwrCount();
		JLabel bkCountLabel = new JLabel("Total Books: "+(a+b));
		bkCountLabel.setForeground(Color.WHITE);
		bkCountLabel.setFont(new Font("Monospaced", Font.PLAIN, 11));
		bkCountLabel.setBounds(185, 395, 140, 20);;
		contentPane.add(bkCountLabel);
		
		JLabel bkAviCountLabel = new JLabel("Available Books: "+core.BookList.bkCount());
		bkAviCountLabel.setForeground(Color.WHITE);
		bkAviCountLabel.setFont(new Font("Monospaced", Font.PLAIN, 11));
		bkAviCountLabel.setBounds(330, 395, 165, 20);;
		contentPane.add(bkAviCountLabel);
		
		Button AddBookButton = new Button("Add Book");
		AddBookButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				AddBookButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				AddBookButton.setBackground(new Color(220, 20, 60));
			}
		});
		AddBookButton.setForeground(Color.WHITE);
		AddBookButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		AddBookButton.setBackground(new Color(220, 20, 60));
		AddBookButton.setBounds(425, 135, 100, 29);
		contentPane.add(AddBookButton);
		
		Button SearchButton = new Button("Search By Name");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<core.BookList> srclst = core.BookList.searchBook(bkNmField.getText());
				//if(r==true)
				{
					DefaultTableModel model2 = (DefaultTableModel)table.getModel();
					Object[] row = new Object[6];
					model2.setRowCount(0);
					for(int i=0;i<srclst.size();i++)
					{
						row[0]=srclst.get(i).bId;
						row[1]=srclst.get(i).name;
						row[2]=srclst.get(i).author;
						row[3]=srclst.get(i).quantity;
						row[4]=srclst.get(i).subject;
						row[5]=srclst.get(i).section;
						model2.addRow(row);
					}
					
					bkCountLabel.setText("Total Books: "+(core.BookList.bkCount()+core.BorrowerList.bwrCount()));
					bkAviCountLabel.setText("Available Books: "+core.BookList.bkCount());
					backLabel_btn.setVisible(true);
				}
			}
		});
		SearchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SearchButton.setBackground(new Color(183, 20, 40));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SearchButton.setBackground(new Color(220, 20, 60));
			}
		});
		SearchButton.setForeground(Color.WHITE);
		SearchButton.setFont(new Font("Monospaced", Font.PLAIN, 12));
		SearchButton.setBackground(new Color(220, 20, 60));
		SearchButton.setBounds(531, 135, 125, 29);
		contentPane.add(SearchButton);
		
		
		JLabel bwrLabel_btn = new JLabel("Borrower List");
		bwrLabel_btn.setHorizontalAlignment(SwingConstants.CENTER);
		InactivePanel.add(bwrLabel_btn);
		bwrLabel_btn.setBackground(Color.WHITE);
		bwrLabel_btn.setForeground(Color.WHITE);
		bwrLabel_btn.setFont(new Font("Monospaced", Font.BOLD, 15));
		bwrLabel_btn.setLabelFor(InactivePanel);
		
		AddBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String bkNm= bkNmField.getText();
				String athr= autrField.getText();
				int qnty= Integer.parseInt(QuatField.getText());  //get integer value
				String sub= subField.getText();
				String sec= SecField.getText();
				
				core.BookList.addBook(bkNm, athr, qnty, sub, sec);
				ArrayList<core.BookList> lst = core.BookList.getList();
				DefaultTableModel model1 = (DefaultTableModel)table.getModel();
				model1.setRowCount(0);
				Object[] row = new Object[6];
				for(int i=0;i<lst.size();i++)
				{
					row[0]=lst.get(i).bId;
					row[1]=lst.get(i).name;
					row[2]=lst.get(i).author;
					row[3]=lst.get(i).quantity;
					row[4]=lst.get(i).subject;
					row[5]=lst.get(i).section;
					model1.addRow(row);
				}
				
				//contentPane.remove(bkCountLabel);
				//contentPane.revalidate();
				//contentPane.repaint();
				bkCountLabel.setText("Total Books: "+(core.BookList.bkCount()+core.BorrowerList.bwrCount()));
				bkAviCountLabel.setText("Available Books: "+core.BookList.bkCount());
					//main(null);
					//dispose();
				
				}
		});
	}
	
	public JTable getTable() {
		return table;
	}
}