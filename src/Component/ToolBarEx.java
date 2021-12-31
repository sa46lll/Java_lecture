package Component;

import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {

	ToolBarEx() {
		super("툴바 만들기 예제");

		createToolBar();

		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void createToolBar() {
		// 툴바 생성
		JToolBar tb = new JToolBar("My ToolBar");
		tb.setBackground(Color.ORANGE);
		
		JButton b = new JButton("New");
		b.setToolTipText("test");
		
		tb.add(b);
		tb.addSeparator();
		
		tb.add(new JLabel("search"));
		tb.add(new JTextField(""));
		
		// 툴바에 메뉴로 사용할 컴포넌트를 삽입
		JButton btn = new JButton("New");

		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C");
		combo.addItem("C++");
		
		btn.add(combo);

		// 툴바를 컨텐트팬의 NORTH에 부착한다.
		this.add(tb, BorderLayout.NORTH);
		this.add(btn, BorderLayout.SOUTH);
	}

	public static void main(String [] args) {
		new ToolBarEx();
	}
}
