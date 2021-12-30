package Thread;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreGraph extends JFrame {

	private JTextField text1;
	private JTextField text2;
	private JTextField text3;

	private DrawingCanvas canvas;

	public ScoreGraph() {
		super("성적 분포표");

		buildGUI();

		setLocation(500, 200);
		setSize(400, 350);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void buildGUI() {
		canvas = new DrawingCanvas();
		add(canvas);

		add(createBtnPanel(), BorderLayout.SOUTH);
	}

	private JPanel createBtnPanel() {
		JPanel panel = new JPanel();
		text1 = new JTextField(3);
		text2 = new JTextField(3);
		text3 = new JTextField(3);

		panel.add(new JLabel("국어"));
		panel.add(text1);

		panel.add(new JLabel("영어"));
		panel.add(text2);

		panel.add(new JLabel("수학"));
		panel.add(text3);

		JButton button = new JButton("그래프 그리기");
		panel.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int korean = Integer.parseInt(text1.getText());
					int english = Integer.parseInt(text2.getText());
					int math = Integer.parseInt(text3.getText());

					// 그래프 캔버스에 점수 설정
					// 그래프 캔버스 갱신
				}
				catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(ScoreGraph.this, "잘못된 숫자 포맷입니다,", "에러 메시지", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		return panel;

	}

	public static void main(String[] args) {
		new ScoreGraph();
	}

}

class DrawingCanvas extends JComponent {

	int korean, english, math;

	public void paint(Graphics g) {
		// 화면 지우기

		// 좌표 그리기

		// 각 점수별 막대그래프 그리기
	}

	void setScores(int korean, int english, int math) {
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}

