import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TabTest extends JFrame {

	JTabbedPane m_tp = new JTabbedPane();

	public TabTest() {
		super("�� �׽�Ʈ");

		JPanel p_tab1 = CreateFirstTab();
		JPanel p_tab2 = CreateSecondTab();
		JPanel p_tab3 = CreateThirdTab();

		// m_tp�� p_tab1~3���� ������ �߰�

		add("Center", m_tp);

		setBounds(200, 200, 450, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

	private JPanel CreateFirstTab() {
		JPanel panel = new JPanel();
		panel.add(new JButton("ù��°"));

		return panel;
	}

	private JPanel CreateSecondTab() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JButton("�ι�°"));

		return panel;
	}

	private JPanel CreateThirdTab() {
		JPanel panel = new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("����°"));
		panel.add(new JButton("����°"));

		return panel;
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		new TabTest();
	}

}
