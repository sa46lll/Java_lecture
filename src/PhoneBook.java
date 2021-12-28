import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhoneBook {
	
	JFrame frame;
	private JPanel p_cardPage;
	private CardLayout card;
	
	private JToggleButton tb1;
	private JToggleButton tb2;
	private JToggleButton tb3;
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	
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
		frame.add(createCenterPanel(), BorderLayout.CENTER);
		frame.add(createBottomButtonPanel(), BorderLayout.SOUTH);
	}
	
	private void registerEvent() {
		// 토글 버튼에 대한 이벤트 추가
					
	}

	private JPanel createTopButtonPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
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
		
		ActionListener handler = new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
				   
		return panel;
	}
	
	private JPanel createCenterPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//고정 패널
		JPanel panel2_center = new JPanel();
		p_cardPage = new JPanel();
		JPanel panel2_center_txt = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2_center_txtfld = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2_center_txt.add(new Label("이름"));
		panel2_center_txt.add(new Label("전화번호"));
		panel2_center_txt.add(new Label("생년월일"));

		panel2_center.add(panel2_center_txt);
		panel2_center.add(panel2_center_txtfld);
				
		
		panel.add(createInputPanel(), BorderLayout.CENTER);
		panel.add(p_cardPage, BorderLayout.SOUTH);
		
		JPanel p_page = new JPanel();
		p_page.add(panel);
	
		return p_page;
	}
	
	private JPanel createInputPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//고정 패널
		JPanel panel2_center = new JPanel();
		JPanel panel2_bottom = new JPanel();
		JPanel panel2_center_txt = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2_center_txtfld = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2_center_txt.add(new Label("이름"));
		panel2_center_txt.add(new Label("전화번호"));
		panel2_center_txt.add(new Label("생년월일"));

		panel2_center.add(panel2_center_txt);
		panel2_center.add(panel2_center_txtfld);
		
		return panel;
	}

	private JPanel createBottomButtonPanel() {
		// TODO Auto-generated method stub
		JPanel panel3 = new JPanel();
		
		JButton jbt1 = new JButton("입력");
		JButton jbt2 = new JButton("초기화");
		panel3.add(jbt1);
		panel3.add(jbt2);
		return panel3;
	}
	
	public static void main(String[] args) {
		new PhoneBook();
	}

}
