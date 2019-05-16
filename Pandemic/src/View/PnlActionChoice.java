package View;

import javax.swing.JPanel;

import core.AbstractAction;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;


public class PnlActionChoice extends JPanel {

	public PnlActionChoice() {
		setLayout(new GridLayout(0, 9, 0, 0));
		
		JPanel pnlDriveFerry = new JPanel();
		pnlDriveFerry.setLayout(null);
		pnlDriveFerry.setBackground(new Color(250, 240, 230));
		add(pnlDriveFerry);
		
		JButton btnDriveferry = new JButton("Drive/Ferry");
		btnDriveferry.setForeground(new Color(165, 42, 42));
		btnDriveferry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDriveferry.setBackground(new Color(245, 255, 250));
		btnDriveferry.setBounds(0, 130, 191, 38);
		pnlDriveFerry.add(btnDriveferry);
		
		JPanel pnlDirectFlight = new JPanel();
		pnlDirectFlight.setBackground(new Color(250, 240, 230));
		add(pnlDirectFlight);
		pnlDirectFlight.setLayout(null);
		
		JButton btnDirectFlight = new JButton("Direct Flight");
		btnDirectFlight.setForeground(new Color(165, 42, 42));
		btnDirectFlight.setBackground(new Color(245, 255, 250));
		btnDirectFlight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDirectFlight.setBounds(0, 132, 191, 38);
		pnlDirectFlight.add(btnDirectFlight);
		
		JPanel pnlCharterFlight = new JPanel();
		pnlCharterFlight.setLayout(null);
		pnlCharterFlight.setBackground(new Color(250, 240, 230));
		add(pnlCharterFlight);
		
		JButton btnCharterFlight = new JButton("Charter Flight");
		btnCharterFlight.setForeground(new Color(165, 42, 42));
		btnCharterFlight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCharterFlight.setBackground(new Color(245, 255, 250));
		btnCharterFlight.setBounds(0, 132, 191, 38);
		pnlCharterFlight.add(btnCharterFlight);
		
		JPanel pnlShuttleFlight = new JPanel();
		pnlShuttleFlight.setLayout(null);
		pnlShuttleFlight.setBackground(new Color(250, 240, 230));
		add(pnlShuttleFlight);
		
		JButton btnShuttleFlight = new JButton("Shuttle Flight");
		btnShuttleFlight.setForeground(new Color(165, 42, 42));
		btnShuttleFlight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShuttleFlight.setBackground(new Color(245, 255, 250));
		btnShuttleFlight.setBounds(0, 132, 191, 38);
		pnlShuttleFlight.add(btnShuttleFlight);
		
		JPanel pnlTreatDisease = new JPanel();
		pnlTreatDisease.setLayout(null);
		pnlTreatDisease.setBackground(new Color(250, 240, 230));
		add(pnlTreatDisease);
		
		JButton btnTreatDisease = new JButton("Treat Disease");
		btnTreatDisease.setForeground(new Color(165, 42, 42));
		btnTreatDisease.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTreatDisease.setBackground(new Color(245, 255, 250));
		btnTreatDisease.setBounds(0, 132, 191, 38);
		pnlTreatDisease.add(btnTreatDisease);
		
		JPanel pnlDiscoverCure = new JPanel();
		pnlDiscoverCure.setLayout(null);
		pnlDiscoverCure.setBackground(new Color(250, 240, 230));
		add(pnlDiscoverCure);
		
		JButton btnDiscoverCure = new JButton("Discover Cure");
		btnDiscoverCure.setForeground(new Color(165, 42, 42));
		btnDiscoverCure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDiscoverCure.setBackground(new Color(245, 255, 250));
		btnDiscoverCure.setBounds(0, 132, 191, 38);
		pnlDiscoverCure.add(btnDiscoverCure);
		
		JPanel pnlBuildResearchStation = new JPanel();
		pnlBuildResearchStation.setLayout(null);
		pnlBuildResearchStation.setBackground(new Color(250, 240, 230));
		add(pnlBuildResearchStation);
		
		JButton btnBuildResearchStation = new JButton("Build Research Station");
		btnBuildResearchStation.setForeground(new Color(165, 42, 42));
		btnBuildResearchStation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuildResearchStation.setBackground(new Color(245, 255, 250));
		btnBuildResearchStation.setBounds(0, 132, 191, 38);
		pnlBuildResearchStation.add(btnBuildResearchStation);
		
		JPanel pnlTakeKnowledge = new JPanel();
		pnlTakeKnowledge.setLayout(null);
		pnlTakeKnowledge.setBackground(new Color(250, 240, 230));
		add(pnlTakeKnowledge);
		
		JButton btnTakeCard = new JButton("Take Knowledge");
		btnTakeCard.setForeground(new Color(165, 42, 42));
		btnTakeCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTakeCard.setBackground(new Color(245, 255, 250));
		btnTakeCard.setBounds(0, 132, 191, 38);
		pnlTakeKnowledge.add(btnTakeCard);
		
		JPanel pnlGiveCard = new JPanel();
		pnlGiveCard.setLayout(null);
		pnlGiveCard.setBackground(new Color(250, 240, 230));
		add(pnlGiveCard);
		
		JButton btnGiveKnowledge = new JButton("Give Knowledge");
		btnGiveKnowledge.setForeground(new Color(165, 42, 42));
		btnGiveKnowledge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGiveKnowledge.setBackground(new Color(245, 255, 250));
		btnGiveKnowledge.setBounds(0, 132, 190, 38);
		btnGiveKnowledge.addActionListener(new ActionSelectionButtonListener(btnGiveKnowledge));
	
		pnlGiveCard.add(btnGiveKnowledge);
	}

	public String getSelectedAction() {
		
		return null;
	}

}
