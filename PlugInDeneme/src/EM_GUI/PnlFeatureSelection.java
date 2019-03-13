package EM_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.TransformerException;

import EM_Config.ConfigWriter;
import EM_Config.ConfigWriterTemplate;

public class PnlFeatureSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	private String name;
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
	private ConfigWriterTemplate cnfgModel;
	
	
	public PnlFeatureSelection(String name,ConfigWriterTemplate cnfgModel) {
		setName(name);
		setCnfgModel(cnfgModel);
		this.color = new Color(153, 0, 0);
		this.font = new Font("jdIcoMoonFree", Font.PLAIN, 13);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		String[] array = new String[30];
		this.addTable();
		this.addInputFields();
		this.addComboBox(array);
		this.addButtons();
		this.addPanes();
	}
	public ConfigWriterTemplate getCnfgModel() {
		return cnfgModel;
	}
	public void setCnfgModel(ConfigWriterTemplate cnfgModel) {
		this.cnfgModel = cnfgModel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}		
	private void addButtons() {
		this.btnAdd = new JButton("ADD");
		btnAdd.setBounds(411, 84, 300, 25);
		btnAdd.setForeground(color);
		btnAdd.setFont(font);
		this.add(btnAdd);
		
		this.btnDelete = new JButton("DELETE");
		btnDelete.setBounds(411, 125, 300, 25);
		btnDelete.setForeground(color);
		btnDelete.setFont(font);
		this.add(btnDelete);
		
		this.btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(411, 260, 300, 25);
		btnSubmit.setForeground(color);
		btnSubmit.setFont(font);
		this.add(btnSubmit);
		btnSubmit.setEnabled(false);
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
				 btnSubmit.setEnabled(true);
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
				   Vector data = model.getDataVector();
				   if(data.size() == 0) {
					   btnSubmit.setEnabled(false);
				   }
			}
		};
		btnDelete.addActionListener(deleteAction);
		
		ActionListener submitAction = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
			    Vector data = model.getDataVector();
		        try {
					cnfgModel.write(data);
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        btnSubmit.setEnabled(false);
		        btnAdd.setEnabled(false);
		        btnDelete.setEnabled(false);
		        info.setText("FEATURES ARE SELECTED!");
			}
			
		};
		btnSubmit.addActionListener(submitAction);
	}
	private void addInputFields() {
		this.featureType = new JTextField();
		featureType.setBounds(545, 49, 105, 22);
		this.add(featureType);
		featureType.setColumns(10);
		
        SpinnerModel sModel = new SpinnerNumberModel(0, 0, 100, 1);

		this.spinner = new JSpinner(sModel);
		spinner.setBounds(654, 49, 57, 22);
		this.add(spinner);
	}
	private void addComboBox(String[] array) {
		 this.comboBox = new JComboBox();
		this.comboBox.setBounds(411, 49, 130, 22);
		this.comboBox.setModel(new DefaultComboBoxModel(new String[] {"Player","Role Card" ,"Reference Card", "Event Card", "State Card", "Pawn","Tokens","Dice","Move Timer", "Game Timer"}));
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
		txtpnFeature.setBounds(411, 27, 120, 22);
		txtpnFeature.setText("FEATURE NAME");
		txtpnFeature.setEnabled(true);
		txtpnFeature.setEditable(false);
		txtpnFeature.setForeground(color);
		txtpnFeature.setFont(font);
		this.add(txtpnFeature);
		
		JTextPane txtpnFeatureType = new JTextPane();
		txtpnFeatureType.setBounds(545, 27, 110, 22);
		txtpnFeatureType.setEnabled(true);
		txtpnFeatureType.setEditable(false);
		txtpnFeatureType.setText("FEATURE TYPE");
		txtpnFeatureType.setForeground(color);
		txtpnFeatureType.setFont(font);
		this.add(txtpnFeatureType);
		
		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setBounds(654, 27, 58, 22);
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