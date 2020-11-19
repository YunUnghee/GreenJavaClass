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
		pstmt = null; // 미리처리하기 위함.
		//statement stmt = null;
		rs = null;
		
		ArrayList<MemberVo> members = new ArrayList<MemberVo>();
		MemberVo membervo;
		//DB table의 1개의 레코드(record: row)를 불러오기 위한  temp 변수
		
		con = getConnection();
		String sql = "SELECT * FROM ID_INFO";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
				//pstmt = con.createStatement(); ->
				//sql을 후에 처리 \PrearedStatement 보다 SQL 구문처리가 한단계
				//늦기 때문에 SQL 처리성능이 저하
				//rs = pstmt.executeQuery(sql);
				//* CallableStatement : PL/SQL 처리할 때 사용.
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
			System.out.println("예외처리3 : "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("예외처리4 : "+e.getMessage());
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
			System.out.println("예외처리 1 : "+e.getMessage());
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("예외처리 2 : "+e.getMessage());			
			e.printStackTrace();
		}finally {
			//System.out.println("JDBC 드라이버와 연결되었습니다.");
		}
		return con;
	}
}
