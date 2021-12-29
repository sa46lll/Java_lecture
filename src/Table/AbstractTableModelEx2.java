package Table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class AbstractTableModelEx2 extends JFrame {
private JTable mTable;
	
	public AbstractTableModelEx2() {
		super("테이블 테스트3-1");

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
		MyTableModel2 model = new MyTableModel2();
		
		// table = model과 연관된 JTable 객체 생성
		mTable = new JTable(model);

		mTable.setRowHeight(30);
		
		// panel에 table 부착
		panel.add(new JScrollPane(mTable));

		return panel;
	}
	
	private ActionListener mHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TableModel model = table.getModel();

			int rowNum = mTable.getRowCount();
			int colNum = mTable.getColumnCount();
			
			for ( int c = 0; c < colNum; c++ ) {
				String colName = mTable.getColumnName(c);
				System.out.print(colName + "\t");
			}
			System.out.println();
			
			for ( int r = 0; r < rowNum; r++ ) {
				for ( int c = 0; c < colNum; c++ ) {
					Object cell = mTable.getValueAt(r, c);
					System.out.print(cell + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	};
	
	public static void main(String[] args) {
		new AbstractTableModelEx2();
	}

}

class MyTableModel2 extends AbstractTableModel {
	
	private Object[][] data = {
			{ "고주몽", 22, "남" },
			{ "소서노", 20, "여" }
	};
	
	private String[] columnNames = {"이    름", "나이", "성별"};

	@Override
	public int getColumnCount() {
		return columnNames.length; //data[0].length
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	// 컬럼명 입력
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

//	@Override
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		return (columnIndex != 0) ? true : false;
//	}
//
//	// 모델값을 변경
//	@Override //
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		// TODO Auto-generated method stub
//		data[rowIndex][columnIndex] = aValue;
//	}
}
