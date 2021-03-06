import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
	
	private JToggleButton tb1_normal;
	private JToggleButton tb2_univ;
	private JToggleButton tb3_company;
	
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
				// if (e.getSource() == tb1_)
				String src = e.getActionCommand();
				card.show(p_cardPage, src);
				
			}
		};
		
		tb1_normal.addActionListener(handler); //비슷한 기능을 수행하기 때문에 하나의 리스너로 수행
		tb2_univ.addActionListener(handler);
		tb3_company.addActionListener(handler);
		
		// 하단 버튼에 대한 이벤트 추가
		b_input.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		b_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tf1_name.setText("");
				tf2_phoneNum.setText("");
				tf3_birthday.setText("");
				tf4_major.setText("");
				tf5_grade.setText("");
				tf6_company.setText("");
				
				tb1_normal.setSelected(true);
				card.show(p_cardPage, "일반");
				
			}
		});
	}

	private JPanel createTopButtonPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		ButtonGroup bg = new ButtonGroup();
		
		tb1_normal = new JToggleButton("일반", true); //선택되어진상태
		tb2_univ = new JToggleButton("대학");
		tb3_company = new JToggleButton("회사");
		bg.add(tb1_normal);
		bg.add(tb2_univ);
		bg.add(tb3_company);
		panel.add(tb1_normal);
		panel.add(tb2_univ);
		panel.add(tb3_company);
				   
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
				
		panel.add(createBasicInputPanel(), BorderLayout.CENTER);	// 고정패널
		panel.add(p_cardPage, BorderLayout.SOUTH); 					// 확장패널
		
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
		p_grade.add(new JLabel("학         년", JLabel.RIGHT));
		p_grade.add(tf5_grade);
		
		panel.add(p_major);
		panel.add(p_grade);
		
		return panel;
	}

	private JPanel createCompanyInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		JPanel p_company = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		tf6_company = new JTextField(8);
		
		p_company.add(new JLabel("회         사", JLabel.RIGHT));
		p_company.add(tf6_company);
		
		panel.add(p_company);
		
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
