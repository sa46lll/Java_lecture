import javax.swing.*;
import java.awt.*;

public class ToolBarEx extends JFrame {

	ToolBarEx() {
		super("���� ����� ����");

		createToolBar();

		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void createToolBar() {
		// ���� ����

		// ���ٿ� �޴��� ����� ������Ʈ�� ����
		JButton btn = new JButton("New");

		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C");
		combo.addItem("C++");

		// ���ٸ� ����Ʈ���� NORTH�� �����Ѵ�.
	}

	public static void main(String [] args) {
		new ToolBarEx();
	}
}
