package Collection;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JCheckBoxTest extends JFrame {

	private JCheckBox[] cb_list;
	private JTextArea t_display;

	public JCheckBoxTest() {
		super("JCheckBox 예제");

		buildGUI();
		registerEventListener();

		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		// JTextArea t_display;
		t_display = new JTextArea();

		add(createCheckBoxPanel(), BorderLayout.NORTH);
		add(t_display, BorderLayout.CENTER);
	}

	private JPanel createCheckBoxPanel() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

		//JCheckBox[] cb_list;
		cb_list = new JCheckBox[5];

		for (int i = 0; i < cb_list.length; i++) {
			cb_list[i] = new JCheckBox("항목" + (i + 1));
			p.add(cb_list[i]);

			//cb_list[i].addItemListener(...);
		}

		return p;
	}

	private void registerEventListener() {
//		for (int i = 0; i < cb_list.length; i++)
//			cb_list[i].addItemListener(handler);

		for (JCheckBox cb : cb_list)
			cb.addItemListener(handler);
	}

	ItemListener handler = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			//JCheckBox cb = (JCheckBox) e.getSource();
			JCheckBox cb = (JCheckBox) e.getItem();

			String s = cb.getText();

			if (e.getStateChange() == ItemEvent.SELECTED)
				s += " 선택";
			else
				s += " 해제";

			t_display.append(s + "\n");
		}

	};

	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}
