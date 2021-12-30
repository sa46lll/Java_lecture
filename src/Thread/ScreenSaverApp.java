package Thread;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenSaverApp extends JFrame {

	private Point mScreen;
	private SSaver mSaver;
	private Thread mThread;

	public ScreenSaverApp() {
		super("스크린 세이버");

		buildGUI();

		this.setSize(mScreen.x, mScreen.y);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		/*/
		manualStart();
		/*/
		autoStart();
		//*/
	}

	private void buildGUI() {
		mScreen = getScreenSize();
		mScreen.y -= 40;	// 작업표시줄 영역 제외

		mSaver = new SSaver(mScreen.x, mScreen.y - 50, 5);
		this.add(mSaver);

		this.add(createInputPanel(), BorderLayout.SOUTH);
	}

	private Point getScreenSize() {
		int width	= Toolkit.getDefaultToolkit().getScreenSize().width;  //현재  화면의  최대  크기(가로)
		int height	= Toolkit.getDefaultToolkit().getScreenSize().height;  //현재  화면의  최대  크기(세로)

//		System.out.printf("(%d, %d)\n", width, height);

		return new Point(width, height);
	}

	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JTextField tf_input = new JTextField(20);

		panel.add(tf_input);

		tf_input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mSaver.mText = tf_input.getText();
				tf_input.setText("");
			}

		});

		return panel;
	}

	private void manualStart() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				mSaver.move();
			}
		});

	}

	private void autoStart() {
		mThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
					mSaver.move();
				}
			}
			
		});
		mThread.start();

	}

	public static void main(String[] args) {
		new ScreenSaverApp();
	}

}
