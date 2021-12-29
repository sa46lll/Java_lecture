

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.event.*;

class TableRenderer extends JFrame {

	private JTable table;
	JTextField t_filterText;
	
	TableRenderer() {
		super("테이블 테스트2");
		
		add(createFilterPanel(), BorderLayout.NORTH);
		add(createTablePanel(), BorderLayout.CENTER);
		add(createButtonPanel(), BorderLayout.SOUTH);
		
		setSize(450, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private JPanel createTablePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		//JPanel panel = new JPanel();
		
		/*****************************************************************************/
		String[] columnNames = { "이  름", "나이", "성별" };
		Object[][] data = { { "고주몽", 22, "남" },
								{ "소서노", 20, "여" } };
		
		//DefaultTableModel tm = new DefaultTableModel(columnNames, 0);			// 빈 테이블 작성시
		DefaultTableModel tm = new DefaultTableModel(data, columnNames);	// 초기값을 갖는 테이블 작성시
		/*****************************************************************************/

		table = new JTable(tm);
		
		// 테이블 속성 변경
		
		tableSelectionListener();
		
		panel.add(new JScrollPane(table));

		// 표 정보 표시

		return panel;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 4));
		
		JButton button = new JButton("셀내용 삽입");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 특정 셀 내용 삽입
					}
					
				}
		);
		panel.add(button);
		
		
		button = new JButton("컬럼 추가");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로운 컬럼 추가
					}
				}
		);
		panel.add(button);
		
		button = new JButton("열(row) 추가");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로운 행 추가
					}
				}
		);
		panel.add(button);
		
		button = new JButton("열(row) 삽입");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로움 행 삽입
					}
				}
		);
		panel.add(button);
		
		button = new JButton("열 이동");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 특정 열의 이동
					}
				}
		);
		panel.add(button);
		
		button = new JButton("셀 서식");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 2번 컬럼에 대해

						// 셀 너비 설정

						// 셀 정렬 방법 설정
					}
				}
		);
		panel.add(button);

		button = new JButton("정렬");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 코드로 정렬하기 : 나이-이름
					}
				}
		);
		panel.add(button);

		button = new JButton("콤보박스");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 비고를 콤보박스와 연결
					}
				}
		);
		panel.add(button);

		return panel;
	}
	
	private JPanel createFilterPanel() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		t_filterText = new JTextField(10);
		t_filterText.setFocusable(true);
		
		// Whenever t_filterText changes, invoke newFilter.
		t_filterText.getDocument().addDocumentListener(
				new DocumentListener() {
					// 입력 필터 설정
				}
		);
		
		panel.add(new JLabel("필터 : "));
		panel.add(t_filterText);
		
		return panel;
	}
	
    private void newFilter(JTextField filterText, int idx) {
        RowFilter<DefaultTableModel, Object> rf = null;
        
        try {
            rf = RowFilter.regexFilter(filterText.getText(), idx);
        } 
        catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        
		DefaultTableModel tm = (DefaultTableModel)table.getModel();

		TableRowSorter<DefaultTableModel> sorter;
		sorter = new TableRowSorter<DefaultTableModel>(tm);
        
		sorter.setRowFilter(rf);

        table.setRowSorter(sorter);
    }
    
    private void tableSelectionListener() {
    	// 표 항목 선택시 이벤트 처리
    }
	
	public static void main(String[] args) {
		new TableRenderer();
	}

}
