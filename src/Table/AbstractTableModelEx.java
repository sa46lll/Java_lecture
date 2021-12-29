
// 3. 사용자 표 모델 이용
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AbstractTableModelEx extends JFrame {
	
	private JTable table;
	
	public AbstractTableModelEx() {
		super("테이블 테스트3");

		buildGUI();
		
		setSize(300,200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void buildGUI() {
		JButton button = new JButton("출력");
		
		button.addActionListener(mHandler);
		
		add(createTablePanel(), BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		// model = 사용자정의 테이블모델 MyTableModel 객체 생성
		// table = model과 연관된 JTable 객체 생성

		table.setRowHeight(30);
		
		// panel에 table 부착

		return panel;
	}
	
	private ActionListener mHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TableModel model = table.getModel();

			int rowNum = table.getRowCount();
			int colNum = table.getColumnCount();
			
			for ( int c = 0; c < colNum; c++ ) {
				String colName = table.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for ( int r = 0; r < rowNum; r++ ) {
				for ( int c = 0; c < colNum; c++ ) {
					Object cell = table.getValueAt(r, c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	};
	
	public static void main(String[] args) {
		new AbstractTableModelEx();
	}

}


class MyTableModel extends AbstractTableModel {

}

