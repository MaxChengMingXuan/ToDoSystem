package todoSystem.views;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultComboBoxModel;


public class GuiTodo extends JFrame {
	int row;
	DefaultTableModel tableModel;
	DefaultTableModel cTableModel;
	String header[]= new String[]{"No.","Day","Code","Title","Note","Due date"};
	private JPanel contentPane;
	private JTable cTable;
	private JTable table;
	private JTextField codeTextField;
	private JTextField tasknameTextField;
	private JTextField dueTextField;
	private JComboBox dayComboBox;
	private JButton resetButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton editButton;
	private JButton addAtButton;
	private JButton addFirstutton;
	private JButton deleteFirstButton;
	private JButton printButton;
	private JButton exportButton;
	private JTextArea noteTextArea;
	private JButton searchButton;
	private JButton completeButton;
	private JButton recoverButton;
	private JButton returnButton;
	private JLabel userLabel;
	
TaskList todoList=new TaskList();
CompleteList cList= new CompleteList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTodo frame = new GuiTodo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displayTaskDetails(){
		tableModel.setRowCount(0);
		for(int i=0; i<todoList.TaskList.size();i++){
			Object[] obj={i+1,todoList.TaskList.get(i).getDay(),todoList.TaskList.get(i).getCode(),todoList.TaskList.get(i).getTask(),todoList.TaskList.get(i).getNote(),todoList.TaskList.get(i).getDueDate()};
			tableModel.addRow(obj);
		}
	}
	
	public void displayCompleteDetails(){
		cTableModel.setRowCount(0);
		for(int i=0; i<cList.CompleteList.size();i++){
			Object[] obj={i+1,cList.CompleteList.get(i).getDay(),cList.CompleteList.get(i).getCode(),cList.CompleteList.get(i).getTask(),cList.CompleteList.get(i).getNote(),cList.CompleteList.get(i).getDueDate()};
			cTableModel.addRow(obj);
		}
	}
	/**
	 * Create the frame.
	 */
	
	public GuiTodo(String username) {
		initComponents();
		createEvents();
		userLabel.setText(username);
		
		tableModel=new DefaultTableModel(header,0);
		table.setModel(tableModel);
		
		cTableModel=new DefaultTableModel(header,0);
		cTable.setModel(cTableModel);
	}
	
	public GuiTodo() {
		initComponents();
		createEvents();

		tableModel=new DefaultTableModel(header,0);
		table.setModel(tableModel);
	
		cTableModel=new DefaultTableModel(header,0);
		cTable.setModel(cTableModel);
	}

	private void initComponents() {
		setTitle("Weekly To-Do");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GuiTodo.class.getResource("/todoSystem/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBackground(new Color(245, 255, 250));
		
		JPanel proccessPanel = new JPanel();
		proccessPanel.setBackground(new Color(112, 128, 144));
		
		JPanel donePanel = new JPanel();
		donePanel.setForeground(new Color(255, 255, 255));
		donePanel.setBackground(new Color(105, 105, 105));
		donePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Completed", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		
		JPanel functionPanel = new JPanel();
		functionPanel.setBackground(new Color(112, 128, 144));
		
		returnButton = new JButton("");
		returnButton.setBackground(Color.BLACK);
		returnButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/return.png")).getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH)));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(usernamePanel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(returnButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(functionPanel, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(proccessPanel, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
						.addComponent(donePanel, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addComponent(proccessPanel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(donePanel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_mainPanel.createSequentialGroup()
							.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(returnButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addComponent(usernamePanel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(functionPanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JScrollPane cTableSrollPane = new JScrollPane();
		
		recoverButton = new JButton("");
		recoverButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/recover.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		GroupLayout gl_donePanel = new GroupLayout(donePanel);
		gl_donePanel.setHorizontalGroup(
			gl_donePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_donePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cTableSrollPane, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(recoverButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_donePanel.setVerticalGroup(
			gl_donePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_donePanel.createSequentialGroup()
					.addGroup(gl_donePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cTableSrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addComponent(recoverButton))
					.addContainerGap())
		);
		
		cTable = new JTable();
		cTable.setForeground(Color.WHITE);
		cTable.setBackground(Color.DARK_GRAY);
		cTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "Day", "Code", "Task", "Note", "Due Date"
			}
		));
		cTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		cTable.getColumnModel().getColumn(0).setMinWidth(13);
		cTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		cTable.getColumnModel().getColumn(2).setPreferredWidth(35);
		cTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		cTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		cTable.getColumnModel().getColumn(5).setResizable(false);
		cTable.getColumnModel().getColumn(5).setPreferredWidth(40);
		cTable.setFont(new Font("Arial", Font.PLAIN, 11));
		cTableSrollPane.setViewportView(cTable);
		donePanel.setLayout(gl_donePanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Tasks", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		
		JPanel outputPanel = new JPanel();
		outputPanel.setBorder(new TitledBorder(null, "Output", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(null, "Control", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_functionPanel = new GroupLayout(functionPanel);
		gl_functionPanel.setHorizontalGroup(
			gl_functionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_functionPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_functionPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(controlPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)
						.addComponent(outputPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_functionPanel.setVerticalGroup(
			gl_functionPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_functionPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 292, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(outputPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setForeground(new Color(220, 220, 220));
		dayLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		dayComboBox = new JComboBox();
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}));
		dayComboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JLabel codeLabel = new JLabel("Code");
		codeLabel.setForeground(new Color(220, 220, 220));
		codeLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel taskNameLabel = new JLabel("Task Name");
		taskNameLabel.setForeground(new Color(220, 220, 220));
		taskNameLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		codeTextField = new JTextField();
		codeTextField.setColumns(10);
		
		tasknameTextField = new JTextField();
		tasknameTextField.setColumns(10);
		
		JLabel noteLabel = new JLabel("Note");
		noteLabel.setForeground(new Color(220, 220, 220));
		noteLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		removeButton = new JButton("Remove");
		
		resetButton = new JButton("Reset");
		
		editButton = new JButton("Edit");
		editButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		addButton = new JButton("Add");
		addButton.setFont(new Font("Arial", Font.PLAIN, 11));

		addButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/add.png")).getImage().getScaledInstance(15,15, Image.SCALE_SMOOTH)));
		
		JLabel dueLabel = new JLabel("Due Date");
		dueLabel.setForeground(new Color(220, 220, 220));
		dueLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		dueTextField = new JTextField();
		dueTextField.setFont(new Font("Arial", Font.PLAIN, 11));
		dueTextField.setColumns(10);
		
		JScrollPane noteScrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(noteScrollPane, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dayComboBox, 0, 135, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(codeLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(codeTextField, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(taskNameLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tasknameTextField, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
						.addComponent(noteLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
								.addComponent(removeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(addButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(editButton, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(dueLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dueTextField, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(codeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(codeLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(taskNameLabel)
						.addComponent(tasknameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(noteLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(noteScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(dueLabel)
						.addComponent(dueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(addButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(removeButton)
						.addComponent(editButton))
					.addGap(20))
		);
		
		noteTextArea = new JTextArea();
		noteScrollPane.setViewportView(noteTextArea);
		panel.setLayout(gl_panel);
		
		addFirstutton = new JButton("Insert First");		
		addFirstutton.setFont(new Font("Arial", Font.PLAIN, 11));
		deleteFirstButton = new JButton("Delete First");
		deleteFirstButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		addAtButton = new JButton("Insert At");
		addAtButton.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout gl_controlPanel = new GroupLayout(controlPanel);
		gl_controlPanel.setHorizontalGroup(
			gl_controlPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_controlPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_controlPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_controlPanel.createSequentialGroup()
							.addComponent(addAtButton, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_controlPanel.createSequentialGroup()
							.addComponent(addFirstutton, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deleteFirstButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(6))))
		);
		gl_controlPanel.setVerticalGroup(
			gl_controlPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_controlPanel.createSequentialGroup()
					.addComponent(addAtButton)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_controlPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(addFirstutton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteFirstButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		controlPanel.setLayout(gl_controlPanel);
		
		printButton = new JButton("Print");
		
		exportButton = new JButton("Export");
		GroupLayout gl_outputPanel = new GroupLayout(outputPanel);
		gl_outputPanel.setHorizontalGroup(
			gl_outputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_outputPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(printButton, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exportButton, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(2))
		);
		gl_outputPanel.setVerticalGroup(
			gl_outputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_outputPanel.createSequentialGroup()
					.addGroup(gl_outputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(printButton)
						.addComponent(exportButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		outputPanel.setLayout(gl_outputPanel);
		functionPanel.setLayout(gl_functionPanel);
		
		JScrollPane tableScrollPane = new JScrollPane();
		
		JLabel taskLabel = new JLabel("Weekly To Do List");
		taskLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/icon.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH)));
		taskLabel.setForeground(new Color(224, 255, 255));
		taskLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		searchButton = new JButton("");
		searchButton.setBackground(new Color(255, 255, 255));
		searchButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/search.png")).getImage().getScaledInstance(35,35, Image.SCALE_SMOOTH)));
		
		completeButton = new JButton("Complete");

		completeButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/checkmarkicon.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		completeButton.setBackground(new Color(100, 149, 237));
		completeButton.setForeground(new Color(255, 255, 255));
		completeButton.setFont(new Font("Arial", Font.PLAIN, 11));
		GroupLayout gl_proccessPanel = new GroupLayout(proccessPanel);
		gl_proccessPanel.setHorizontalGroup(
			gl_proccessPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proccessPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_proccessPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_proccessPanel.createSequentialGroup()
							.addComponent(taskLabel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
							.addComponent(completeButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableScrollPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_proccessPanel.setVerticalGroup(
			gl_proccessPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proccessPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_proccessPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_proccessPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(taskLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(completeButton))
						.addComponent(searchButton))
					.addGap(11)
					.addComponent(tableScrollPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table= new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "Day", "Code", "Task", "Note", "Due  Date"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.setBackground(new Color(240, 255, 240));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		tableScrollPane.setViewportView(table);
		proccessPanel.setLayout(gl_proccessPanel);
		
		userLabel = new JLabel("");
		userLabel.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/todoSystem/resources/user icon.png")).getImage().getScaledInstance(25,25, Image.SCALE_SMOOTH)));
		GroupLayout gl_usernamePanel = new GroupLayout(usernamePanel);
		gl_usernamePanel.setHorizontalGroup(
			gl_usernamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_usernamePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(userLabel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addGap(103))
		);
		gl_usernamePanel.setVerticalGroup(
			gl_usernamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_usernamePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(userLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		usernamePanel.setLayout(gl_usernamePanel);
		mainPanel.setLayout(gl_mainPanel);
		
	}
	
	private void createEvents() {
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day=String.valueOf(dayComboBox.getSelectedItem());
				todoList.add(day,codeTextField.getText(),tasknameTextField.getText(),noteTextArea.getText(),dueTextField.getText());
				displayTaskDetails();
			}
		});
		
		
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "No data to delete", "To Do List",
								JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete", "To Do List",
								JOptionPane.OK_OPTION);
					}
				} else {
					int i=table.getSelectedRow();
					tableModel.removeRow(i);
					todoList.remove(i);
					displayTaskDetails();

				}
			}
		});
		
		addAtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Select a row to add", "To Do List",
								JOptionPane.OK_OPTION);
					}
				}
				else {
			 		int input=table.getSelectedRow();
						String day=String.valueOf(dayComboBox.getSelectedItem());
						Task data=new Task(day,codeTextField.getText(),tasknameTextField.getText(),noteTextArea.getText(),dueTextField.getText());
						todoList.insertAt(input, data);
						displayTaskDetails();
				}
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dayComboBox.setSelectedItem("Select Day");
				codeTextField.setText("");
				tasknameTextField.setText("");
				dueTextField.setText("");
				noteTextArea.setText("");
			}
		});
		
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			 		
				 try {
					int i=table.getSelectedRow();
					if(table.getSelectedRow()!=-1) {
						todoList.TaskList.get(i).setDay((String) dayComboBox.getSelectedItem());
						todoList.TaskList.get(i).setCode(codeTextField.getText());
						todoList.TaskList.get(i).setTask(tasknameTextField.getText());
						todoList.TaskList.get(i).setDueDate(dueTextField.getText());
						todoList.TaskList.get(i).setNote(noteTextArea.getText());
						displayTaskDetails();
						
						JOptionPane.showMessageDialog(null, "Update Successfully");
					}
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Please select a task to edit.");
				}
				
			}	
		});
		
		addFirstutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day=String.valueOf(dayComboBox.getSelectedItem());
				
				todoList.insertFirst(new Task(day,codeTextField.getText(),tasknameTextField.getText(),noteTextArea.getText(),dueTextField.getText()));
				displayTaskDetails();
			}
		});
		
		deleteFirstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "Empty table.");
				}
				else{
					
					todoList.removeFirst();
					displayTaskDetails();
				}
			}
		});
		
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (java.awt.print.PrinterException e1) {
					System.err.format("No printer found", e1.getMessage());
				}
			}
		});
		
		exportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File(
							"C:\\Users\\User\\Desktop\\Weekly assignment list.txt");
					if (!file.exists()) {
						file.createNewFile();
					}
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write("My Weekly To Do List\n\n");
					bw.write(table.getColumnName(0)+"\t"+table.getColumnName(1)+"\t\t"+table.getColumnName(2)+"\t"
					        +table.getColumnName(3)+"\t\t"+table.getColumnName(4)+"\t\t\t"+table.getColumnName(5)+"\t\n\n");
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getModel().getValueAt(i, j) + "\t");
						}
						bw.write("\n___________________________________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Data Exported");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog("Enter Task Title");
				 for (int i = 0; i < todoList.TaskList.size(); i++) {
			            if (todoList.TaskList.get(i).getTask().equalsIgnoreCase(input)){
			                JOptionPane.showMessageDialog(searchButton, "Task Found","Search Title",2);
			                dayComboBox.setSelectedItem(todoList.TaskList.get(i).getDay());
			                codeTextField.setText(todoList.TaskList.get(i).getCode());
			                tasknameTextField.setText(todoList.TaskList.get(i).getTask());
			                dueTextField.setText(todoList.TaskList.get(i).getDueDate());
			                noteTextArea.setText(todoList.TaskList.get(i).getNote());
			                table.setRowSelectionInterval(i, i);
			                return;//Quit after found
			            }
			        }
			        JOptionPane.showMessageDialog(searchButton, "Task not Found.","Search Task",2);
			}
		});
		
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Please select a task  from task list.");
				}
				else {
					//playSound();
					int i=table.getSelectedRow();
				
					cList.insertFirst(todoList.TaskList.get(i).getDay(),todoList.TaskList.get(i).getCode(),todoList.TaskList.get(i).getTask(),todoList.TaskList.get(i).getNote(),todoList.TaskList.get(i).getDueDate());
					displayCompleteDetails();
					tableModel.removeRow(i);
					todoList.remove(i);
					displayTaskDetails();
					displayCompleteDetails();
				}
			}
		});
		
		recoverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cTable.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Please select a task in completed list.");
				}
				else {
					int i=cTable.getSelectedRow();
					todoList.insertFirst(cList.CompleteList.get(i));
					cTableModel.removeRow(i);
					cList.remove(i);
					displayTaskDetails();
					displayCompleteDetails();
				}
			}
		});
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoverTodo frame = new CoverTodo();
				frame.setModalExclusionType(null);
				frame.setVisible(true);
	            dispose();
			}
		});
		
	}
	
	public void playSound()
	 {
	   try 
	   {
	    File sound=new File("D:\\UUM\\IT SEM_02\\DATA STRUCTURES AND ALGORITHM ANALYSIS A202 STIA2024 KUMP C\\Project Code\\ProjectGuiList\\src\\todoSystem\\resources\\ding.wav");
	    Clip clip = AudioSystem.getClip( );
	    clip.open(AudioSystem.getAudioInputStream(sound));
	    clip.start( );
	   }
	   catch(Exception ex)
	   {
	     System.out.println("Error with playing sound.");
	     ex.printStackTrace( );
	   }
	 }

}
