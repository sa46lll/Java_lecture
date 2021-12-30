package Thread;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JCounter extends JFrame {
	private JLabel mLblDisplay = new JLabel("0");

	private JButton mBtnStart = new JButton("START");
	private JButton mBtnPause = new JButton("PAUSE");
	private JButton mBtnReset = new JButton("RESET");

	public JCounter() {
		super("Counter");

		buildGUI();
		this.pack();
		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void buildGUI() {
		// 프레임 구성
		add(createDisplayPanel(), BorderLayout.CENTER);
		add(createBtnPanel(), BorderLayout.SOUTH);
	}

	// 표시부 패널
	private JPanel createDisplayPanel() {
		mLblDisplay.setFont(new Font("Courier New", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);

		panel.add(mLblDisplay);

		return panel;
	}

	// 버튼 패널
	private JPanel createBtnPanel() {
		mBtnStart.setFont(new Font("Courier New", Font.BOLD, 15));
		mBtnPause.setFont(new Font("Courier New", Font.BOLD, 15));
		mBtnReset.setFont(new Font("Courier New", Font.BOLD, 15));

		mBtnPause.setEnabled(false);
		mBtnReset.setEnabled(false);

		mBtnStart.addActionListener(handler);
		mBtnPause.addActionListener(handler);
		mBtnReset.addActionListener(handler);

		JPanel panel = new JPanel();

		panel.add(mBtnStart);
		panel.add(mBtnPause);
		panel.add(mBtnReset);

		return panel;
	}

	ActionListener handler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();

			if (src == mBtnStart) {
				mBtnStart.setEnabled(false);
				mBtnPause.setEnabled(true);
				mBtnReset.setEnabled(false);

			}
			else if (src == mBtnPause) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(true);

			}
			else if (src == mBtnReset) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(false);

				mLblDisplay.setText("0");
			}

		}

	};



	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);
		new JCounter();
	}

}
