package Table;

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
		
		// mData = Person의 벡터 생성;
		mData = new Vector<Person>();
		
		buildGUI();
		
		setSize(500,500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
    
	private void buildGUI() {
		// 표
		// mData와 연계된 사용자정의테이블모델 VectorTableModel을 기반으로 테이블 생성
		mTable = new JTable();
		mTable.setModel(new VectorTableModel(mData));
		
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
			int num = mTable.getRowCount();
			for (int i = num; i < num + 5; i++) {
				Person p = new Person("홍길동" + i, 20 + i, "010=1234-" + (1000+i));
				mData.add(p);
			}
			
			// 테이블 갱신
			mTable.updateUI();
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
	
	public VectorTableModel(Vector<Person> v) {
		String[] s = {"이름", "나이", "전화번호"};
		mColumnNames = new Vector<String>(s.length);
		
		for ( int c = 0; c < s.length; c++ )
			mColumnNames.addElement(s[c]);
		
		//셀 데이터 설정
		mData = v;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return mColumnNames.size();
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Person p = mData.get(rowIndex);
		
		switch(columnIndex) {
		case 0: return p.getName();
		case 1: return p.getAge();
		case 2: return p.getPhoneNum();
		}
		
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return mColumnNames.get(column);
	}
	
	

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
