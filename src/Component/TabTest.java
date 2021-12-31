package Component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TabTest extends JFrame {

	JTabbedPane m_tp = new JTabbedPane();

	public TabTest() {
		super("탭 테스트");

		JPanel p_tab1 = CreateFirstTab();
		JPanel p_tab2 = CreateSecondTab();
		JPanel p_tab3 = CreateThirdTab();

		// m_tp에 p_tab1~3까지 탭으로 추가

		add("Center", m_tp);

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
