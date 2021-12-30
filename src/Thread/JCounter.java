package Thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JCounter extends JFrame {
	private JLabel mLblDisplay = new JLabel("0");

	private JButton mBtnStart = new JButton("START");
	private JButton mBtnPause = new JButton("PAUSE");
	private JButton mBtnReset = new JButton("RESET");
	
	private Thread mThread = null;

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
				
				// 라벻 객체의 숫자를 얻어와 1 증가 후 다시 설정하는 일을 1초마다 반복
				/*
				for (int i = 0; i < 3; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
					}
					
					mLblDisplay.setText(String.valueOf(Integer.parseInt(mLblDisplay.getText())+1));

				}
				*/
				mThread = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						// 라벻 객체의 숫자를 얻어와 1 증가 후 다시 설정하는 일을 1초마다 반복
						while(mThread == Thread.currentThread()) { //작업스레드가 여러개 생성되었을 때, 중복되지 않도록 제일 마지막의 스레드만 실행됨
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
							}
							
							if (mThread != Thread.currentThread()) //pause의 지연상태 
								break;
							
							mLblDisplay.setText(String.valueOf(Integer.parseInt(mLblDisplay.getText()) + 1));
						}
					}
				});
				mThread.start();

			}
			else if (src == mBtnPause) {
				mBtnStart.setEnabled(true);
				mBtnPause.setEnabled(false);
				mBtnReset.setEnabled(true);
				
				// 화면 갱신을 중지
				mThread = null;

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
