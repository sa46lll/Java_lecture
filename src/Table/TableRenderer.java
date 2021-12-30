package Table;

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
		table.setRowHeight(30);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setAutoCreateRowSorter(true);
		
		tableSelectionListener();
		
		panel.add(new JScrollPane(table));

		// 표 정보 표시
		System.out.println("컬럼 수 : " + tm.getColumnCount());
		System.out.println("세번째 컬럼 명 : " + tm.getColumnName(2));
		System.out.println("줄 수 : " + tm.getRowCount());

		return panel;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel = new JPanel(new GridLayout(0, 4));
		
		JButton button = new JButton("셀내용 삽입");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 특정 셀 내용 삽입
						DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						
						dtm.setValueAt("여성", 1, 2);
					}
					
				}
		);
		panel.add(button);
		
		
		button = new JButton("컬럼 추가");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로운 컬럼 추가
						DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						
						String columnName = "비고";
						String[] columnData = { "가", "나" };
						dtm.addColumn(columnName, columnData);

						System.out.println("컬럼 클래스명 : " + dtm.getColumnClass(3));
					}
				}
		);
		panel.add(button);
		
		button = new JButton("열(row) 추가");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로운 행 추가
						DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						
						String[] rowData = { "홍길동", "20", "남" };
						dtm.addRow(rowData);
					}
				}
		);
		panel.add(button);
		
		button = new JButton("열(row) 삽입");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 표에 새로움 행 삽입
						DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						
						String[] rowData = { "일지매", "18", "남" };
						dtm.insertRow(1, rowData);
					}
					
				}
		);
		panel.add(button);
		
		button = new JButton("열 이동");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 특정 열의 이동
						DefaultTableModel dtm = (DefaultTableModel)table.getModel();
						
						dtm.moveRow(1, 3, 0);
					}
				}
		);
		panel.add(button);
		
		button = new JButton("셀 서식");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 2번 컬럼에 대해
						TableColumnModel tcm = table.getColumnModel();
						TableColumn tc = tcm.getColumn(2);

						// 셀 너비 설정
						tc.setPreferredWidth(20);

						// 셀 정렬 방법 설정
						DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
						dtcr.setHorizontalAlignment(SwingConstants.CENTER);
						
						tc.setCellRenderer(dtcr);
					}
				}
		);
		panel.add(button);

		button = new JButton("정렬");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 코드로 정렬하기 : 나이-이름
						DefaultTableModel tm = (DefaultTableModel)table.getModel();

						TableRowSorter<DefaultTableModel> sorter;
						sorter = new TableRowSorter<DefaultTableModel>(tm);
						table.setRowSorter(sorter);

						java.util.List <RowSorter.SortKey> sortKeys = new java.util.ArrayList<RowSorter.SortKey>();
						sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
						sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
						sorter.setSortKeys(sortKeys); 
					}
				}
		);
		panel.add(button);

		button = new JButton("콤보박스");
		button.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 비고를 콤보박스와 연결
						// 3번 컬럼에 대해
						TableColumnModel tcm = table.getColumnModel();
						TableColumn tc = tcm.getColumn(3);

						// 콤보박스로 표시
				        JComboBox cb = new JComboBox();
				        cb.addItem("가");
				        cb.addItem("나");
				        cb.addItem("다");
				        cb.addItem("라");

				        DefaultCellEditor dce = new DefaultCellEditor(cb);
						tc.setCellEditor(dce);
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
					public void changedUpdate(DocumentEvent e) {
					    newFilter(t_filterText, 0);
					}
					public void insertUpdate(DocumentEvent e) {
						newFilter(t_filterText, 0);
					}
					public void removeUpdate(DocumentEvent e) {
						newFilter(t_filterText, 0);
					}
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
