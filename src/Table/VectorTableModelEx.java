
// 4. 사용자 표 모델 이용 - 벡터와 연
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.event.*;
import java.util.Vector;

public class VectorTableModelEx extends JFrame {

	private JTable mTable;
	private Vector<Person> mData;
    
	public VectorTableModelEx() {
		super("테이블 테스트4");
		
		// mData = Person의 벡터 생;
		
		buildGUI();
		
		setSize(500,500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
    
	private void buildGUI() {
		// 표
		// mData와 연계된 사용자정의테이블모델 VectorTableModel을 기반으로 테이블 생성
		
		// 버튼
		JPanel p_button = new JPanel();
		JButton b_input = new JButton("추가");
		JButton b_output = new JButton("출력");
		   
		b_input.addActionListener(mAddHandler);
		b_output.addActionListener(mShowHandler);
		
		p_button.add(b_input);
		p_button.add(b_output);

		// 프레임
		add(new JScrollPane(mTable));
		add("South", p_button);
	}
    
	private ActionListener mAddHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent ae) {
			// 벡터에 데이터 추가
			// 테이블 갱신
		}
		
	};
	
	private ActionListener mShowHandler = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent ae) {
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
		new VectorTableModelEx();
	}
}

class VectorTableModel extends AbstractTableModel {

	private Vector<String> mColumnNames;
	private Vector<Person> mData;

}


class Person {
	private String	mName;
	private String	mPhoneNum;
	private int		mAge;

	Person(String name, int age, String phoneNum) {
		this.mName = name;
		this.mAge = age;
		this.mPhoneNum = phoneNum;
	}
	
	int getAge() {
		return mAge;
	}

	String getName() {
		return mName;
	}
	
	String getPhoneNum() {
		return mPhoneNum;
	}
	
	void setPhoneNum(String phoneNum) {
		this.mPhoneNum = phoneNum;
	}
}
