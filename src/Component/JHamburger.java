import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JHamburger extends JFrame implements ActionListener {

	JTextArea t_ta1;
	JTextArea t_ta2;

	JButton b_start;
	JButton b_exit;

	public JHamburger() {
		super("Hamburger 가게");

		//  JLabel 표시부
		JPanel p_txt = new JPanel(new GridLayout(1, 2));
		p_txt.add(new JLabel("요리사"));
		p_txt.add(new JLabel("손님"));


		//  JTextArea 표시부
		t_ta1 = new JTextArea(20,12);
		t_ta2 = new JTextArea(20,12);

		t_ta1.setEditable(false);
		t_ta2.setEditable(false);

		JPanel p_ta = new JPanel(new GridLayout(1,2));
		p_ta.add(t_ta1);
		p_ta.add(t_ta2);

		JScrollPane sp = new JScrollPane(p_ta);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


		// 버튼 입력부
		JPanel p_button = new JPanel(new GridLayout(1,2));

		b_start = new JButton("시작");
		b_exit = new JButton("종료");

		p_button.add(b_start);
		p_button.add(b_exit);

		b_start.addActionListener(this);
		b_exit.addActionListener(this);


		// 프레임구성
		add("North", p_txt);
		add("Center", sp);
		add("South", p_button);

		pack();
		setLocation(100,50);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();

		if (src == b_start) {
			t_ta1.setText("");
			t_ta2.setText("");

			Shelf s = new Shelf(4);

			Producer p1 = new Producer(s, 1);
			Producer p2 = new Producer(s, 2);

			Consumer c1 = new Consumer(s, 1);
			Consumer c2 = new Consumer(s, 2);
			Consumer c3 = new Consumer(s, 3);

			p1.start();
			p2.start();

			c1.start();
			c2.start();
			c3.start();
		} else {
			System.exit(0);
		}
	}

	public class Shelf {

		private int max;	// 선반에 올려놓을 수 있는 햄버거 개수
		private int value;	// 생산된 햄버거 개수

		public Shelf(int max) {
			this.max = max;
		}

		public int getValue() {
			return value;
		}

		public void make() {
			++value;

			Thread thisThread = Thread.currentThread();

			t_ta1.append(thisThread.getName() + ": 생산 [재고="+getValue() + "]\n");
			t_ta2.append("\n");

			t_ta1.setCaretPosition(t_ta1.getDocument().getLength());
		}

		public void sell() {
			value--;

			Thread thisThread = Thread.currentThread();

			t_ta1.append("\n");
			t_ta2.append(thisThread.getName() + ": 소비 [재고="+getValue() + "]\n");

			t_ta2.setCaretPosition(t_ta2.getDocument().getLength());
		}

	}


	public class Producer extends Thread {

		private Shelf s;
		private int id;
		private final int MAX = 30;

		public Producer(Shelf s, int id) {
			super("P" + id);

			this.s = s;
			this.id = id;
		}

		public void run() {
			for ( int i = 0; i < MAX; i++ ) {
				try {
					s.make();
					sleep( (long)(400*Math.random()) );
				} catch (Exception e) {}
			}
		}
	}


	public class Consumer extends Thread {

		private Shelf s;
		private int id;
		private final int MAX = 20;

		public Consumer(Shelf s, int id) {
			super("C" + id);

			this.s = s;
			this.id = id;
		}

		public void run() {

			for ( int i = 0; i < MAX; i++ ) {
				try {
					 s.sell();
					sleep( (long)(600*Math.random()) );
				} catch (Exception e) {}
			}
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new JHamburger();
	}

}
