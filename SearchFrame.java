package version_01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SearchFrame extends JFrame {
	private JFrame f;
	TabClass tc;
	JTabbedPane tab;
	

	SearchFrame() {
		f = new JFrame();
		tc = new TabClass();
	}

	void Run() {
		this.createTabbedPane();
		f.add(tab);
		
		this.SetFrame();
	}

	void SetFrame() {
		f.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTabbedPane createTabbedPane() {		
		tab = new JTabbedPane();
		tab.addTab("Bus Search", tc.p_main);
		tab.setBounds(0, 0, 1500, 1000);
		return tab;
	}
}
