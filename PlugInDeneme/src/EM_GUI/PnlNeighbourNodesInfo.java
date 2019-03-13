package EM_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.TransformerException;

import EM_Config.ConfigWriter;
import EM_Config.ConfigWriterTemplate;

public class PnlNeighbourNodesInfo extends JPanel {
	private static final long serialVersionUID = 1L;
	private String name;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnSubmit;
	private JComboBox<Vector<String>> nodeCombo;
	private JComboBox<Vector<String>> neighbourCombo;
	private DefaultTableModel model;
	private JTable table;
	private Color color;
	private Font font;
	private ConfigWriterTemplate cnfgModel;
	private Vector  nodes;
	private JTextPane info;
	
	
	public PnlNeighbourNodesInfo(Vector  nodes, ConfigWriterTemplate cnfgModel) {
		setNodes(nodes);
		setName(name);
		setCnfgModel(cnfgModel);
		this.color = new Color(153, 0, 0);
		this.font = new Font("jdIcoMoonFree", Font.PLAIN, 13);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.addTable();
		this.addComboBox();
		this.addButtons();
		this.addPanes();
		
		
	}
	private void setNodes(Vector  nodes) {
		this.nodes = nodes;
	}
	
	private ConfigWriterTemplate getCnfgModel() {
		return cnfgModel;
	}
	private void setCnfgModel(ConfigWriterTemplate cnfgModel) {
		this.cnfgModel = cnfgModel;
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
				
				String node = (String)nodeCombo.getSelectedItem();
				String neighbour = (String)neighbourCombo.getSelectedItem();
				
				String[] aRow = {node, neighbour};
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
			 
		        info.setText("NODES ARE CREATED!");
		        btnAdd.setEnabled(false);
		        btnDelete.setEnabled(false);
		        btnSubmit.setEnabled(false);
			}
			
		};
		btnSubmit.addActionListener(submitAction);
	}

	private void addComboBox() {
		 this.nodeCombo = new JComboBox();
		this.nodeCombo.setBounds(411, 49, 147, 22);
		this.nodeCombo.setModel(new DefaultComboBoxModel(nodes.toArray()));
		this.nodeCombo.setBackground(Color.WHITE);
		this.nodeCombo.setForeground(color);
		this.nodeCombo.setFont(font);
		this.add(this.nodeCombo);
		
		this.neighbourCombo = new JComboBox();
		this.neighbourCombo.setBounds(564, 49, 147, 22);
		this.neighbourCombo.setBackground(Color.WHITE);
		this.neighbourCombo.setForeground(color);
		this.neighbourCombo.setFont(font);
		this.add(this.neighbourCombo);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {	 
		    	  int state = itemEvent.getStateChange();
		    	  if(state == ItemEvent.SELECTED) {
		    		 Vector temp = new Vector<>();
		    		  for (int i = 0; i < nodes.size(); i++) {
		    			  if (!nodes.get(i).equals(itemEvent.getItem())) {
							temp.add(nodes.get(i));
						}
					}
		    		 neighbourCombo.setModel(new DefaultComboBoxModel(temp.toArray()));
		    	 }
		      }
		    };
		nodeCombo.addItemListener(itemListener);
		
		
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
					"NODE ", "NEIGHBOUR"
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
		JTextPane txtpnNode = new JTextPane();
		txtpnNode.setBounds(411, 27, 94, 22);
		txtpnNode.setText("NODE");
		txtpnNode.setEnabled(true);
		txtpnNode.setEditable(false);
		txtpnNode.setForeground(color);
		txtpnNode.setFont(font);
		this.add(txtpnNode);
		
		JTextPane txtpnNeighbour = new JTextPane();
		txtpnNeighbour.setBounds(557, 27, 116, 22);
		txtpnNeighbour.setEnabled(true);
		txtpnNeighbour.setEditable(false);
		txtpnNeighbour.setText("NEIGHBOUR");
		txtpnNeighbour.setForeground(color);
		txtpnNeighbour.setFont(font);
		this.add(txtpnNeighbour);	
		
		info = new JTextPane();
		info.setBounds(411, 191, 276, 120);
		info.setForeground(color);
		info.setFont(font);
		info.setEditable(false);
		info.setEnabled(true);
		this.add(info);
	}
}