package Component;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class MDISimple extends JFrame implements ActionListener {

	JDesktopPane desktop = new JDesktopPane();

	JMenuItem m_new = new JMenuItem("New");
	JMenuItem m_close = new JMenuItem("Close");
	JMenuItem m_exit = new JMenuItem("Exit");

	int cnt=1;

	public MDISimple() {
		super("MDI Simple Test");

		buildGUI();

		setBounds(100,100,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	void buildGUI() {

		add(desktop, BorderLayout.CENTER);

		// 메뉴바 구성
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);

		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);

		fileMenu.add(m_new);
		fileMenu.add(m_close);
		fileMenu.addSeparator();
		fileMenu.add(m_exit);

		m_new.addActionListener(this);
		m_close.addActionListener(this);
		m_exit.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if(obj == m_new) {
			NewFrame();
		} else if(obj == m_close) {
			CloseFrame();
		} else if(obj == m_exit) {
			System.exit(0);
		}
	}

	public void NewFrame() {
		JTextArea t_ta = new JTextArea();
		JInternalFrame iFrame = new JInternalFrame("" + cnt++, true, true, true, true);

		// iFrame 구성 설정

		// desktop에 iFrame 부착

		// iFrame 가시화

		// iFrame 종료 이벤트 처리
	}

	class InternalFrameEventHandler extends InternalFrameAdapter {
		public void internalFrameClosing(InternalFrameEvent e) {
			CloseFrame();
		}
	}

	public void CloseFrame() {
		JInternalFrame frame = desktop.getSelectedFrame();
		if(frame == null) return;

		frame.setVisible(false);
		frame.dispose();
	}

	public static void main(String[] args){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);

		new MDISimple();
	}
}
