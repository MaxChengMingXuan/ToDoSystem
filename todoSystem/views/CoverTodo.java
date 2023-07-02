package todoSystem.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoverTodo extends JFrame {

	private JPanel contentPane;
	private JTextField newUserTextField;
	private JComboBox comboBox;
	private JButton enterButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoverTodo frame = new CoverTodo();
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
	public CoverTodo() {
		setTitle("To Do List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CoverTodo.class.getResource("/todoSystem/resources/icon.png")));
		initComponents();
		createEvents();

	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel userPanel = new JPanel();
		userPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		userPanel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(171)
					.addComponent(userPanel, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addGap(170))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(userPanel, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
					.addGap(36))
		);
		
		JLabel titleLabel = new JLabel("Weekly To Do");
		titleLabel.setForeground(new Color(112, 128, 144));
		titleLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/icon.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH)));
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		JLabel desLabel = new JLabel("Organize, Plan and Collaborate");
		desLabel.setForeground(new Color(128, 128, 128));
		desLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Wong Re Jie", "Cheng Ming Xuan"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel guestLabel = new JLabel("New User");
		guestLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		
		newUserTextField = new JTextField();
		newUserTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		newUserTextField.setColumns(10);
		
		JLabel orLabel = new JLabel("Or");
		orLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		enterButton = new JButton("Enter");

		enterButton.setFont(new Font("Arial", Font.PLAIN, 12));
		GroupLayout gl_userPanel = new GroupLayout(userPanel);
		gl_userPanel.setHorizontalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(desLabel, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
						.addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
						.addGroup(gl_userPanel.createSequentialGroup()
							.addGroup(gl_userPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(userLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(guestLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_userPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(newUserTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(enterButton, Alignment.TRAILING))
							.addGap(52)))
					.addGap(59))
				.addGroup(gl_userPanel.createSequentialGroup()
					.addGap(86)
					.addComponent(orLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		gl_userPanel.setVerticalGroup(
			gl_userPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPanel.createSequentialGroup()
					.addGap(61)
					.addComponent(titleLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desLabel)
					.addGap(102)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(orLabel)
					.addGap(18)
					.addGroup(gl_userPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(guestLabel)
						.addComponent(newUserTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(87)
					.addComponent(enterButton)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		userPanel.setLayout(gl_userPanel);
		panel.setLayout(gl_panel);
		
	}

	private void createEvents() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=0) {
					newUserTextField.setEditable(false);
				}
				else {
					newUserTextField.setEditable(true);
				}
			}
		});
		
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=-1 && comboBox.getSelectedIndex()!=0) {
					GuiTodo frame = new GuiTodo(String.valueOf(comboBox.getSelectedItem()));
					frame.setModalExclusionType(null);
					frame.setVisible(true);
		            dispose();
				}
				else if(newUserTextField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please input username.");
				}
				else {
					GuiTodo frame = new GuiTodo(newUserTextField.getText());
					frame.setModalExclusionType(null);
					frame.setVisible(true);
		            dispose();
				}

			}
		});
		
	}
}
