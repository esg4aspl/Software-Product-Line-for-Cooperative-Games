package EM_GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class PnlFeatureSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	private String name;
	private JPanel pnlHead;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnSubmit;
	private JSpinner spinner;
	private JTextField featureType;
	private JComboBox comboBox;
	private DefaultTableModel model;
	private JTable table;
	private JTextPane info;
	private Color color;
	private Font font;
	
	
	public PnlFeatureSelection(String name) {
		setName(name);
		this.color = new Color(153, 0, 0);
		this.font = new Font("jdIcoMoonFree", Font.PLAIN, 13);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		String[] array = new String[30];
		this.pnlHead = new JPanel();
		this.addTable();
		this.addInputFields();
		this.addComboBox(array);
		this.addButtons();
		this.addPanes();
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}		
	private void addButtons() {
		this.btnAdd = new JButton("ADD");
		btnAdd.setBounds(411, 84, 277, 25);
		btnAdd.setForeground(color);
		btnAdd.setFont(font);
		this.add(btnAdd);
		
		this.btnDelete = new JButton("DELETE");
		btnDelete.setBounds(411, 125, 277, 25);
		btnDelete.setForeground(color);
		btnDelete.setFont(font);
		this.add(btnDelete);
		
		this.btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(411, 166, 277, 25);
		btnSubmit.setForeground(color);
		btnSubmit.setFont(font);
		this.add(btnSubmit);
		addActionListeners();
		
		
	}
	private void addActionListeners() {
		ActionListener addAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fType =featureType.getText() ;
				String selectedFeature = (String)comboBox.getSelectedItem();
				String spinnerValue = Integer.toString((Integer)spinner.getValue())	;
				
				String[] aRow = {selectedFeature, fType, spinnerValue};
				 model = (DefaultTableModel) table.getModel();
				 model.addRow(aRow);
			}
		};
		btnAdd.addActionListener(addAction);
		
		ActionListener deleteAction = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				   int[] rows = table.getSelectedRows();
				   for(int i=0;i<rows.length;i++){
				     model.removeRow(rows[i]-i);
				   }
				
			}
		};
		btnDelete.addActionListener(deleteAction);
		
		ActionListener submitAction = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
			    Vector data = model.getDataVector();
				ArrayList<String> numdata = new ArrayList<String>();
		        for (int count = 0; count < data.size(); count++){
		              System.out.println(data.get(count));
		        }
			}
		};
		btnSubmit.addActionListener(submitAction);
	}
	private void addInputFields() {
		this.featureType = new JTextField();
		featureType.setBounds(509, 49, 116, 22);
		this.add(featureType);
		featureType.setColumns(10);
		
		this.spinner = new JSpinner();
		spinner.setBounds(629, 49, 57, 22);
		this.add(spinner);
	}
	private void addComboBox(String[] array) {
		 this.comboBox = new JComboBox();
		this.comboBox.setBounds(411, 49, 94, 22);
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] {"Feature 1", "Feature 2", "Feature 3", "Feature 4", "Feature 5", "Feature 6"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(color);
		comboBox.setFont(font);
		
		this.add(this.comboBox);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		    	  
		    	  int state = itemEvent.getStateChange();
		    	 if(state == ItemEvent.SELECTED) {
		    		 ItemSelectable is = itemEvent.getItemSelectable();
		    		 
		    		 switch ((String)itemEvent.getItem()) {
					case "Feature 2" :
						info.setText("BÝR FIRELAMA ÝÞLEMÝ YAPILDI ");
						info.setVisible(true);
						break;
		
					default:
						break;
					}
		    	 }
		      }
		    };
		comboBox.addItemListener(itemListener);
	}
	private void addTable() {
		table = new JTable();
		table.setBounds(24, 27, 375, 259);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.setForeground(color);
		table.setFont(font);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"FEATURE NAME ", "FEATURE TYPE", "AMOUNT"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(0).setPreferredWidth(120);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(1).setPreferredWidth(200);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			
			JScrollPane scrollPane = new JScrollPane(table);
			// Force the scrollbars to always be displayed
			scrollPane.setHorizontalScrollBarPolicy(
			    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(
			    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
			scrollPane.setBounds(24, 27, 375, 259);
			this.add(scrollPane);
	}
	private void addPanes() {
		JTextPane txtpnFeature = new JTextPane();
		txtpnFeature.setBounds(411, 27, 94, 22);
		txtpnFeature.setText("FEATURE");
		txtpnFeature.setEnabled(true);
		txtpnFeature.setEditable(false);
		txtpnFeature.setForeground(color);
		txtpnFeature.setFont(font);
		this.add(txtpnFeature);
		
		JTextPane txtpnFeatureType = new JTextPane();
		txtpnFeatureType.setBounds(509, 27, 116, 22);
		txtpnFeatureType.setEnabled(true);
		txtpnFeatureType.setEditable(false);
		txtpnFeatureType.setText("FEATURE TYPE");
		txtpnFeatureType.setForeground(color);
		txtpnFeatureType.setFont(font);
		this.add(txtpnFeatureType);
		
		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setBounds(629, 27, 58, 22);
		txtpnAmount.setEnabled(true);
		txtpnAmount.setEditable(false);
		txtpnAmount.setText("AMOUNT");
		txtpnAmount.setForeground(color);
		txtpnAmount.setFont(font);
		this.add(txtpnAmount);
		
		info = new JTextPane();
		info.setBounds(411, 191, 276, 120);
		info.setForeground(color);
		info.setFont(font);
		info.setEditable(false);
		info.setEnabled(true);
		this.add(info);
	}
	
}
