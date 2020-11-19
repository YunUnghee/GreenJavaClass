package version_01;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	private JFrame frame;
	private JPanel jp_1,jp_2,jp_3;
	private JLabel la_title, la_ID, la_PASS;
	private JButton bt_OK, bt_AD, bt_FIN;
	private JTextField tf_ID;
	private JPasswordField pass;
	private Font f1,f2,f3;
	private ImageIcon I_title, I_ID,I_PASS, I_OK;
	private Color c;
	MemberDAO dao;


	
	public LoginFrame(){
		frame = new JFrame("Bus Search");
		I_title = new ImageIcon(Main.class.getResource("..//Image/title.png"));
		I_ID = new ImageIcon(Main.class.getResource("../Image/ID.png"));
		I_PASS = new ImageIcon(Main.class.getResource("../Image/Pass.png"));
		I_OK = new ImageIcon(Main.class.getResource("../Image/login.png"));
		la_title = new JLabel(I_title);
		la_PASS = new JLabel(I_PASS);
		la_ID = new JLabel(I_ID);
		bt_OK = new JButton(I_OK);
		bt_AD = new JButton("회원가입");
		bt_FIN = new JButton("찾 기");
		tf_ID = new JTextField(15);
		tf_ID.setLocation(100, 100);
		pass = new JPasswordField(15);
		jp_1 = new JPanel();
		jp_2 = new JPanel();
		jp_3 = new JPanel();
		f1 = new Font("돋음",Font.PLAIN, 15);
		f2 = new Font("궁서",Font.PLAIN, 15);
		f3 = new Font("바탕",Font.PLAIN, 15);
		c = new Color(051,153,051);

	}
	
	public void run() {
		frame.getContentPane().setBackground(c);
		frame.setSize(600,1000);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds();
		this.SetFont();
		this.PanelAdd();
		this.FrameAdd();
		
//		this.eventUp();
		
	}
	
	void SetFont() {
		tf_ID.setFont(f1);
		pass.setFont(f1);
		la_ID.setFont(f1);
		la_PASS.setFont(f1);
	}
	
	void setBounds() {
		bt_OK.setBounds(220,450, 150,150);
		bt_OK.setBorderPainted(false);
		bt_OK.setContentAreaFilled(false);
		bt_OK.setOpaque(false);
		bt_AD.setBounds(100, 800, 100, 100);
		bt_FIN.setBounds(400, 800, 100, 100);
		jp_1.setBounds(100, 300, 400, 50);
		jp_2.setBounds(100, 350, 400, 50);
		jp_1.setBackground(c);
		jp_2.setBackground(c);
		
		
		la_title.setBounds(0, 50, 600, 100);
	}
	
	void PanelAdd() {
		jp_1.add(la_ID);
		jp_1.add(tf_ID);
		jp_2.add(la_PASS);
		jp_2.add(pass);
		jp_3.setBackground(c);
		
	}
	
	void FrameAdd() {
		frame.add(la_title);
		frame.add(jp_1);
		frame.add(jp_2);
		frame.add(bt_AD);
		frame.add(bt_FIN);
		frame.add(bt_OK);
		frame.setVisible(true);
		
	}
	
//	void eventUp() {
//		bt_OK.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String id = tf_ID.getText();
//				String pw = new String(pass.getPassword());
//				HashMap<String, String> map = new HashMap<String, String>();
//				
//				MemberDAO dao = new MemberDAO();
//				ArrayList<MemberVo> members = new ArrayList<MemberVo>();
//				try {
//					members = dao.members();
//					
//					for(int i=0;i<members.size();i++) {
//						map.put(members.get(i).getID(), members.get(i).getPASSWORD());
//					}
//					if(!map.containsKey(id)) {
//						JOptionPane.showMessageDialog(null, "입력하신 아이디가 없습니다.", "ID오류", JOptionPane.YES_OPTION);
//					}else {
//						if(!(map.get(id)).equals(anObject))
//					}
//				}
//				
//				
//				tf_ID.setText("");
//				pass.setText("");
//			}
//			
//		});
//		bt_FIN.addActionListener(this);
//		bt_AD.addActionListener(this);
//		
//		tf_ID.addActionListener(this);
//		pass.addActionListener(this);
//	}
//
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
