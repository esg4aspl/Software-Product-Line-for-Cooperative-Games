package EM_GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Array;
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

import EM_Config.ConfigWriter;

public class PnlNodeInfo extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnAddNeighbour;
	private JTextField nodeName;
	private DefaultTableModel model;
	private JTable table;
	private Color color;
	private Font font;
	private JPanel pnlCard;
	private Vector data;
	private ConfigWriter cnfgModel;
	
	
	public PnlNodeInfo(JPanel pnlCard,ConfigWriter cnfgModel) {
		setPnlCard(pnlCard);
		setCnfgModel(cnfgModel);
		this.color = new Color(153, 0, 0);
		this.font = new Font("jdIcoMoonFree", Font.PLAIN, 13);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.addTable();
		this.addInputFields();
		this.addButtons();
		this.addPanes();
	}
	private ConfigWriter getCnfgModel() {
		return cnfgModel;
	}
	private void setCnfgModel(ConfigWriter cnfgModel) {
		this.cnfgModel = cnfgModel;
	}
	public Vector getNodes() {
		return data;
	}
	public JPanel getPnlCard() {
		return pnlCard;
	}

	public void setPnlCard(JPanel pnlCard) {
		this.pnlCard = pnlCard;
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
		
		this.btnAddNeighbour = new JButton("ADD NEIGHBOURS");
		btnAddNeighbour.setBounds(411, 260, 300, 25);
		btnAddNeighbour.setForeground(color);
		btnAddNeighbour.setFont(font);
		this.add(btnAddNeighbour);
		 btnAddNeighbour.setEnabled(false);
		addActionListeners();
		
		
	}
	private void addActionListeners() {
		ActionListener addAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fType =nodeName.getText() ;
				String[] aRow = {fType};
				 model = (DefaultTableModel) table.getModel();
				 model.addRow(aRow);
				 btnAddNeighbour.setEnabled(true);
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
				    data = model.getDataVector();
				    if(data.size() == 0) {
						   btnAddNeighbour.setEnabled(false);
				    }
			}
		};
		btnDelete.addActionListener(deleteAction);
		
		ActionListener addNeighbourAction = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
			    data = model.getDataVector();
			    Vector aVector = new Vector<>();
			    for (int i = 0; i <data.size(); i++) {
					aVector.add(((Vector) data.get(i)).get(0));
				}
				CardLayout cards = (CardLayout)(pnlCard.getLayout());
				PnlNeighbourNodesInfo pnlNeighbourNodesInfo = new PnlNeighbourNodesInfo( aVector , cnfgModel);
		        pnlCard.add(pnlNeighbourNodesInfo,"NEIGHBOUR");
				cards.show(pnlCard, "NEIGHBOUR");
			}
		};
		btnAddNeighbour.addActionListener(addNeighbourAction);
	}
	private void addInputFields() {
		this.nodeName = new JTextField();
		nodeName.setBounds(411, 43, 300, 25);
		this.add(nodeName);
		nodeName.setColumns(10);
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
				new Object[][] {},
				new String[] {"NODE NAME "}) {
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
		JTextPane txtpnFeatureType = new JTextPane();
		txtpnFeatureType.setBounds(509, 21, 116, 22);
		txtpnFeatureType.setEnabled(true);
		txtpnFeatureType.setEditable(false);
		txtpnFeatureType.setText("NODE NAME");
		txtpnFeatureType.setForeground(color);
		txtpnFeatureType.setFont(font);
		this.add(txtpnFeatureType);
	}
}
