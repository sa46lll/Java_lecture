package Component;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabTest extends JFrame {

	JTabbedPane m_tp = new JTabbedPane();

	public TabTest() {
		super("탭 테스트");

		JPanel p_tab1 = CreateFirstTab();
		JPanel p_tab2 = CreateSecondTab();
		JPanel p_tab3 = CreateThirdTab();

		// m_tp에 p_tab1~3까지 탭으로 추가
		m_tp.addTab("첫번째 탭", p_tab1);
		m_tp.addTab("첫번째 탭", p_tab2);
		m_tp.addTab("첫번째 탭", p_tab3);

		add(m_tp, BorderLayout.CENTER); //컴파일 타임에 어디서 오류가 났는지 알려줌.(런타임 전에)
//		add("Center", m_tp);
		
		setBounds(200, 200, 450, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	private JPanel CreateFirstTab() {
		JPanel panel = new JPanel();
		panel.add(new JButton("첫번째"));

		return panel;
	}

	private JPanel CreateSecondTab() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JButton("두번째"));

		return panel;
	}

	private JPanel CreateThirdTab() {
		JPanel panel = new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("세번째"));
		panel.add(new JButton("세번째"));

		return panel;
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		new TabTest();
	}

}
