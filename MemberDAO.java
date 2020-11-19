package version_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "egoing";
	String password = "111111";
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> members() throws SQLException, Exception {
		con = null;
		pstmt = null; // �̸�ó���ϱ� ����.
		//statement stmt = null;
		rs = null;
		
		ArrayList<MemberVo> members = new ArrayList<MemberVo>();
		MemberVo membervo;
		//DB table�� 1���� ���ڵ�(record: row)�� �ҷ����� ����  temp ����
		
		con = getConnection();
		String sql = "SELECT * FROM ID_INFO";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				//pstmt = con.createStatement(); ->
				//sql�� �Ŀ� ó�� \PrearedStatement ���� SQL ����ó���� �Ѵܰ�
				//�ʱ� ������ SQL ó�������� ����
				//rs = pstmt.executeQuery(sql);
				//* CallableStatement : PL/SQL ó���� �� ���.
			while(rs.next()) {
				membervo = new MemberVo(); // temp
				String ID = rs.getNString("ID");
				String PASSWORD = rs.getString("PASSWORD");
				membervo.setID(ID);
				membervo.setPASSWORD(PASSWORD);
				members.add(membervo); 
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(SQLException e) {
			System.out.println("����ó��3 : "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("����ó��4 : "+e.getMessage());
			e.printStackTrace();
		}
		return members;
	}
	
	
	public Connection getConnection() throws ClassNotFoundException, Exception {
		con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException e) {
			System.out.println("����ó�� 1 : "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("����ó�� 2 : "+e.getMessage());			
			e.printStackTrace();
		}finally {
			//System.out.println("JDBC ����̹��� ����Ǿ����ϴ�.");
		}
		return con;
	}
}
