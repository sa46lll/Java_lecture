package Component;


import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class BorderTest extends JFrame {
	
	public BorderTest() {
		super("보더 테스트");

		buildGUI();
		
		setSize(300, 500);
		setLocation(300,200);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		// frame 구성
		setLayout(new GridLayout(0,1));		// (inf,2) : (4,2)
		
		add(createLineBorder());
		add(createRaisedEtchedBorder());
		add(createLoweredEtchedBorder());
		add(createRaisedBevelBorder());
		add(createLoweredBevelorder());
		add(createTitleBorder());
		add(createEtchedTitleBorder());
	}


	private JPanel createLineBorder() {
		JPanel p = new JPanel();

		p.setBorder(BorderFactory.createLineBorder(Color.black));
		p.add(new JLabel("line border"));
		
		return p;
	}
	
	private JPanel createRaisedEtchedBorder() {
		JPanel p = new JPanel();
		
		p.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		p.add(new JLabel("raised etched border"));
		
		return p;
	}
	
	private JPanel createLoweredEtchedBorder() {
		JPanel p = new JPanel();
		
		p.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		p.add(new JLabel("lowered etched border"));
		
		return p;
	}
	
	private JPanel createRaisedBevelBorder() {
		JPanel p = new JPanel();
		
		p.setBorder(BorderFactory.createRaisedBevelBorder());
		p.add(new JLabel("raised bevel border"));
		
		return p;
	}
	
	private JPanel createLoweredBevelorder() {
		JPanel p = new JPanel();
		
		p.setBorder(BorderFactory.createLoweredBevelBorder());
		p.add(new JLabel("lowered bevel border"));
		
		return p;
	}

	private JPanel createTitleBorder() {
		JPanel p = new JPanel();
		
		p.setBorder(BorderFactory.createTitledBorder("Title"));
		p.add(new JLabel("title border"));
		
		return p;
	}
	
	private JPanel createEtchedTitleBorder() {
		JPanel p = new JPanel();
		
		//p.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Title"));
		Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		Border etchedTitleBorder = BorderFactory.createTitledBorder(etchedBorder, "Title");
		p.setBorder(etchedTitleBorder);
		p.add(new JLabel("etched title border"));
		
		return p;
	}
	
	public static void main(String[] args){
		new BorderTest();		
	}
}