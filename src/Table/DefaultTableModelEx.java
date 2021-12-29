package Table;

// 2. 기본 표 모델 이용
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DefaultTableModelEx {

	private JFrame mFrame;
	private JTable mTable;
	
	private JTextField mTvName;
	private JTextField mTvAge;
	private JTextField mTvGender;

	public DefaultTableModelEx() {
		mFrame = new JFrame("테이블 테스트2");

		buildGUI();
		
		mFrame.setSize(400,200);

		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setVisible(true);
	}
	
	private void buildGUI() {
		mFrame.add(createTablePanel(), BorderLayout.CENTER);
		mFrame.add(createInputPanel(), BorderLayout.SOUTH);
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		String[] columnNames = { "이름", "나이", "성별" };
		
		// model = 기본 테이블 모델 생성
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		// mTable = model과 연관된 JTable 객체 생성
		mTable = new JTable(model);
		
		mTable.setRowHeight(30);

		// panel에 mTable 부착
		panel.add(new JScrollPane(mTable));
		
		return panel;
	}
	
	private JPanel createInputPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		// 입력패널
		JPanel p_input = new JPanel();
		
		mTvName = new JTextField(6);
		mTvAge = new JTextField(3);
		mTvGender = new JTextField(2);
		
		p_input.add(new JLabel("이름"));
		p_input.add(mTvName);
		p_input.add(new JLabel("나이"));
		p_input.add(mTvAge);
		p_input.add(new JLabel("성별"));
		p_input.add(mTvGender);
		
		// 기본 버튼 패널
		JPanel p_button = new JPanel();

		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		
		button1.addActionListener(mAddActionListener);
		button2.addActionListener(mRemoveActionListener);

		p_button.add(button1);
		p_button.add(button2);
		
		panel.add(p_input);
		panel.add(p_button);
		
		return panel;
	}
	
	private ActionListener mAddActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// 텍스트필드에 입력한 값을 배열 arr로 가져오기
			String arr[] = new String[3];
			arr[0] = mTvName.getText();
			arr[1] = mTvAge.getText();
			arr[2] = mTvGender.getText();
			
			// mTable에 설정된 모델 가져오고 arr을 한 행으로 추가하기
			DefaultTableModel model = (DefaultTableModel) mTable.getModel();
			model.addRow(arr);
			
			mTvName.setText("");
			mTvAge.setText("");
			mTvGender.setText("");
		}
		
	};
	
	private ActionListener mRemoveActionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 테이블에 현재 선택된 행 번호 가져오기
			int row = mTable.getSelectedRow();
			if (row == -1) return;
			
			// 모델 객체에서 해당 행 삭제하기
			DefaultTableModel model = (DefaultTableModel) mTable.getModel();
			model.removeRow(row);
		}
		
	};
	
	public static void main(String[] args) {
		new DefaultTableModelEx();
	}

}
