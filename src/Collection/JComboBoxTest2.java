package Collection;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JComboBoxTest2 extends JFrame {

	private JTextField			mTvInput;
	private JComboBox<String>	mCombo;
	private JButton				mBtnAdd, mBtnDel;

	public JComboBoxTest2() {
		super("JComboBox Test2");

		buildGUI();
		registerListener();

		setSize(500, 300);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		setLayout(new FlowLayout());

		mTvInput = new JTextField(10);
		mBtnAdd = new JButton("추가");
		mBtnDel = new JButton("삭제");
		mBtnDel.setEnabled(false);

		String[] fruits = { "apple", "banana", "kiwi", "mango" };
		mCombo = new JComboBox<String>(fruits);

		add(mTvInput);
		add(mBtnAdd);
		add(mBtnDel);
		add(mCombo);
	}

	private void registerListener() {
		mBtnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = mTvInput.getText();

//					DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) mCombo.getModel();
//					model.addElement(str);
					mCombo.addItem(str);

					mTvInput.setText("");
				}
			}
		);

		//*/
		mCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//mTvInput.setText((String) mCombo.getSelectedItem());
					JComboBox<String> cb = (JComboBox<String>) e.getSource();
					mTvInput.setText((String) cb.getSelectedItem());

					mBtnDel.setEnabled(true);
				}
			}
		);
		/*/
		mCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					mTvInput.setText(e.getItem().toString());
					mBtnDel.setEnabled(true);
				}
			}

		});
		//*/

		mBtnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str = mTvInput.getText();

//					DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) mCombo.getModel();
//					if (model.getIndexOf(str) != -1)
//						model.removeElement(str);
					mCombo.removeItem(str);
				}
			}
		);
	}

	public static void main(String[] args) {
		new JComboBoxTest2();
	}

}
