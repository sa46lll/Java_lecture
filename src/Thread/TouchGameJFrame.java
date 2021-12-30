package Thread;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TouchGameJFrame extends JFrame {

	private JLabel mLbnScore;
	private JButton mBtn;

	private static final int GAME_PANEL_WIDTH = 300;
	private static final int GAME_PANEL_HEIGHT = 400;

	private GameCanvas mCanvas;
	private Thread mThread;

	public TouchGameJFrame() {
		super("PhoneBook");

		buildGUI();
		registerEvent();

		setBounds(100, 200, GAME_PANEL_WIDTH, GAME_PANEL_HEIGHT + 90);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		add(createStatusPanel(), BorderLayout.NORTH);
		add(createGamePanel(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);
	}

	private void registerEvent() {
		mBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();

				if (s.equals("게임 시작")) {
					mBtn.setText("게임 종료");

					// 캔버스 초기화
					mCanvas.initTargets();

					// 점수 초기화
					mLbnScore.setText("0");

					// 주기적으로 타겟 이동
					mThread = new GameThread();
					mThread.start();
				}
				else {
					mBtn.setText("게임 시작");

					// 주기적 타겟 이동 중지
					mThread = null;

					// 캔버스 지우기
					mCanvas.clear();
				}
			}

		});
	}

	private JPanel createStatusPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		mLbnScore = new JLabel("0");

		panel.add(new JLabel("점수: "));
		panel.add(mLbnScore);
		panel.add(new JLabel("점"));

		return panel;
	}

	private JPanel createGamePanel() {
		JPanel panel = new JPanel(new BorderLayout());

		mCanvas = new GameCanvas();
		panel.add(mCanvas);

		return panel;
	}

	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1));

		mBtn = new JButton("게임 시작");

		panel.add(mBtn);

		return panel;
	}

	private class GameCanvas extends JComponent {

		Vector<Target> mTargets;

		static final int NUM_OF_TARGET = 3;

		Random mRandom = new Random();

		GameCanvas() {
			mTargets = new Vector<Target>();

			addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					int x = e.getX();
					int y = e.getY();
					
					Iterator<Target> itr = mTargets.iterator();
					while(itr.hasNext()) {
						int s = Integer.parseInt(mLbnScore.getText());
						
						if (itr.next().isInner(x, y)) {
							itr.remove();
							mCanvas.repaint();
							
							mLbnScore.setText(String.valueOf(s + 10));
						}
						
						if (mTargets.size() == 0) {
							mThread = null;
							mBtn.setText("게임 시작");
						}
					}
				}
			});
		}

		void initTargets() {
			int i;
			for (i = 0; i < NUM_OF_TARGET; i++) {
				mTargets.add(new Target(-1, -1));
			}
		}

		void clear() {
			mTargets.clear();
			mCanvas.repaint();
		}

		@Override
		public void paint(Graphics g) {
			g.setColor(Color.RED);
			
			Iterator<Target> itr = mTargets.iterator();
			Target t;
			while (itr.hasNext()) {
				t = itr.next();
				
				g.fillRect(t.getX(), t.getY(), Target.TARGET_WIDTH, Target.TARGET_HEIGHT);
			}
			
		}

		void nextState() {
			int x;
			int y;

			// 타겟들에 새 좌표값 설정
			Iterator<Target> itr = mTargets.iterator();
			Target t;
			while(itr.hasNext()) {
				t = itr.next();
				
				x = mRandom.nextInt(GAME_PANEL_WIDTH - Target.TARGET_WIDTH);
				y = mRandom.nextInt(GAME_PANEL_HEIGHT - Target.TARGET_HEIGHT);
				
				t.setXY(x,  y);
			}
			repaint();
		}

	}

	private class Target {
		static final int TARGET_WIDTH = 10;
		static final int TARGET_HEIGHT = 10;

		private int x;
		private int y;

		public Target(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Target) {
				Target t = (Target) obj;
				if (this.x == t.x && this.y == t.y)
					return true;
			}

			return false;
		}

		public boolean isInner(int x, int y) {
			if ((this.x < x && x < this.x + TARGET_WIDTH)
					&& (this.y < y && y < this.y + TARGET_HEIGHT))
				return true;

			return false;
		}
	}

	private class GameThread extends Thread {

		@Override
		public void run() {
			while (mThread == Thread.currentThread()){
				// 주기적으로 캔버스의 타겟 좌표 새로 설정
				mCanvas.nextState();
				
				// 캔버스 화면 갱신
				mCanvas.repaint();
				
				// 시간 지연
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			}
		}

	}

	public static void main(String[] args) {
		new TouchGameJFrame();
	}


}
