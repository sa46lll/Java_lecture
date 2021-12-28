import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhoneBook {
	
	JFrame frame;
	private JPanel p_cardPage;
	private CardLayout card;
	
	private JTextField tf1_name;
	private JTextField tf2_phoneNum;
	private JTextField tf3_birthday;
	private JTextField tf4_major;
	private JTextField tf5_grade;
	private JTextField tf6_company;
	
	private JToggleButton tb1;
	private JToggleButton tb2;
	private JToggleButton tb3;
	
	private JButton b_input;
	private JButton b_reset;
	
	public PhoneBook() {
		frame = new JFrame("PhoneBook");
		frame.setLayout(new BorderLayout());
		
		buildGUI();
		registerEvent();
		
		frame.setSize(250, 400);
		frame.setLocation(500, 300);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	private void buildGUI() {
		// TODO Auto-generated method stub
		frame.add(createTopButtonPanel(), BorderLayout.NORTH);
		frame.add(createCenterPanel()); // CENTER
		frame.add(createBottomButtonPanel(), BorderLayout.SOUTH);
	}
	
	private void registerEvent() {
		// 토글 버튼에 대한 이벤트 추가
		ActionListener handler = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// if (e.getSource() == tb1)
				String src = e.getActionCommand();
				card.show(p_cardPage, src);
				
			}
		};
		
		tb1.addActionListener(handler); //비슷한 기능을 수행하기 때문에 하나의 리스너로 수행
		tb2.addActionListener(handler);
		tb3.addActionListener(handler);
		
		// 하단 버튼에 대한 이벤트 추가
		tb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		tb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private JPanel createTopButtonPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		
		tb1 = new JToggleButton("일반", true); //선택되어진상태
		tb2 = new JToggleButton("대학");
		tb3 = new JToggleButton("회사");
		bg.add(tb1);
		bg.add(tb2);
		bg.add(tb3);
		panel.add(tb1);
		panel.add(tb2);
		panel.add(tb3);
				   
		return panel;
	}
	
	private JPanel createCenterPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new BorderLayout());

		card = new CardLayout();
		p_cardPage = new JPanel(card);
		
		p_cardPage.add("일반", createNormalInputPanel());
		p_cardPage.add("대학", createUnivInputPanel());
		p_cardPage.add("회사", createCompanyInputPanel());
				
		// 고정패널
		panel.add(createBasicInputPanel(), BorderLayout.CENTER);
		panel.add(p_cardPage, BorderLayout.SOUTH);
		
		JPanel p_page = new JPanel();
		p_page.add(panel);
	
		return p_page;
	}
	
	private JPanel createNormalInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		
		return panel;
	}
	
	private JPanel createUnivInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_major = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p_grade = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		tf4_major = new JTextField(8);
		tf5_grade = new JTextField(8);
		
		p_major.add(new JLabel("전         공", JLabel.RIGHT));
		p_major.add(tf4_major);
		p_major.add(new JLabel("학         년", JLabel.RIGHT));
		p_major.add(tf5_grade);
		
		return panel;
	}

	private JPanel createCompanyInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_company = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		tf6_company = new JTextField(8);
		
		p_company.add(new JLabel("회         사", JLabel.RIGHT));
		p_company.add(tf4_major);
		
		return panel;
	}

	private JPanel createBasicInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_name = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p_phoneNum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p_birthday = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		tf1_name = new JTextField(8);
		tf2_phoneNum = new JTextField(8);
		tf3_birthday = new JTextField(8);
		
		p_name.add(new JLabel("이         름", JLabel.RIGHT));
		p_name.add(tf1_name);
		p_phoneNum.add(new JLabel("전화번호", JLabel.RIGHT));
		p_phoneNum.add(tf2_phoneNum);
		p_birthday.add(new JLabel("생년월일", JLabel.RIGHT));
		p_birthday.add(tf3_birthday);
		
		panel.add(p_name);
		panel.add(p_phoneNum);
		panel.add(p_birthday);
		
		return panel;
	}

	private JPanel createBottomButtonPanel() {
		// TODO Auto-generated method stub
		JPanel panel3 = new JPanel();
		
		b_input = new JButton("입력");
		b_reset = new JButton("초기화");
		
		panel3.add(b_input);
		panel3.add(b_reset);
		
		return panel3;
	}
	
	public static void main(String[] args) {
		new PhoneBook();
	}

}
