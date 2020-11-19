package version_01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class TabClass extends JFrame{
	
	JTable table;
	JScrollPane scroll1, scroll2;
	JTextArea ta1;
	JTextField tf_st, tf_go;
	JLabel jl1,jl2;
	JButton bt_ex,bt_sc,bt_ch,bt_reco,bt_ok;
	JPanel p_main,p1,p2,p3;
	Font f1;
	JCheckBox cb;
	JLabel l_title;
	TabClass(){
		scroll1 = new JScrollPane();
		ta1 = new JTextArea("세부정보 출력", 10, 50);
		jl1 = new JLabel("Start Point");
		jl2 = new JLabel("Destination Point");
		tf_st = new JTextField();
		tf_go = new JTextField();
		bt_ex = new JButton("Exchange");
		bt_sc = new JButton("Search");
		bt_ch = new JButton("Change");
		bt_reco = new JButton("Record");
		bt_ok = new JButton("OK");
		p_main = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		f1 = new Font("돋음", Font.PLAIN, 20);
		cb = new JCheckBox();
		l_title = new JLabel("Bus Search");
		this.Pmain();
	}
	
	void Panel1() {
		cb.setHorizontalAlignment(JLabel.CENTER);
		
		String[] data = {"Check","Bus Number"};
		String[][] num = new String[3][2];
		num[0][1] = "1번";
		num[2][1] = "11번";
		num[1][1] = "13번";
		
		DefaultTableModel tt = new DefaultTableModel(num,data);
		table = new JTable(tt);
		scroll1 = new JScrollPane(table);
		scroll1.setPreferredSize(new Dimension(500,500));
		
		
		DefaultCellEditor checkEditor = new DefaultCellEditor(cb) {
			public Component getTableCellEditorComponent(
					JTable table, Object value, boolean isSelected, int row, int column) {
				JCheckBox editor;
				editor = (JCheckBox)super.getTableCellEditorComponent(table, value, isSelected, row, column);
				return editor;
			}
		};
		
		table.getColumn("Check").setCellEditor(checkEditor);
		table.getColumn("Check").setCellRenderer(new cellCheckRenderer());
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumn("Bus Number").setPreferredWidth(397);
		table.getColumn("Check").setPreferredWidth(100);
		table.setRowHeight(40);
		table.setFont(f1);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		p1.add(scroll1);
		p1.setSize(500,700);
		p1.setLocation(0, 200);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for(int i=0;i<tcm.getColumnCount();i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}
	
	void Panel2() {
		p2.setLayout(null);
		scroll2 = new JScrollPane(ta1);
		scroll2.setLocation(0, 200);
		scroll2.setSize(500,300);
		p2.add(scroll2);
		p2.setBounds(600, 200, 500, 700);
	}
	
	void Panel3() {
		p3.setLayout(null);
		jl1.setBounds(0,0,100,50);
		jl2.setBounds(0, 100,100,50);
		tf_st.setBounds(0, 50,200,50);
		tf_go.setBounds(0, 150,200,50);
		bt_ex.setBounds(220, 100, 100, 50);
		bt_sc.setBounds(0, 250, 200, 50);
		bt_ch.setBounds(0, 350, 200, 50);
		bt_reco.setBounds(0, 450, 200, 50);
		
		
		p3.add(jl1);
		p3.add(jl2);
		p3.add(tf_st);
		p3.add(tf_go);
		p3.add(bt_ex);
		p3.add(bt_sc);
		p3.add(bt_ch);
		p3.add(bt_reco);
		
		
		p3.setBounds(1150,200,500,700);
	}
	
	void Pmain() {
		p_main.setLayout(null);
		bt_ok.setBounds(449,150, 50, 50);
		l_title.setBounds(0, 0, 1500, 120);
		p_main.add(l_title);
		p_main.add(bt_ok);
		this.Panel1();
		this.Panel2();
		this.Panel3();
		this.ButtonEvent();
		p_main.add(p1,BorderLayout.WEST);
		p_main.add(p2,BorderLayout.CENTER);
		p_main.add(p3,BorderLayout.EAST);
		p_main.setBounds(10, 10, 1400, 1000);
		p_main.setSize(1500,1000);
	}
	
	class cellCheckRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRenderComponent(JTable table, Object value, boolean isSelected, Boolean hasFocus, int row, int column) {
			JCheckBox check = new JCheckBox();
			boolean a = false;
			check.setSelected(((Boolean)value).booleanValue());
			check.setHorizontalAlignment(SwingConstants.CENTER);
			return check;
		}
	}
	
	void ButtonEvent() {
		bt_ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String str = (String)table.getValueAt(table.getSelectedRow(),1);
				ta1.setText(str);
			}
		});
		bt_ex.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String start = tf_st.getText();
				String goal = tf_go.getText();
				
				tf_st.setText(goal);
				tf_go.setText(start);
				
			}
		});
	}
}