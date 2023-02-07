package ex1;


import java.sql.*;

public class Program3 {
     // JDBC 수정  
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 수정할 내용   
		String title ="TEST10";  
		String content = "hahaha3";
		String files = "";
		int id = 7; // 수정할곳  
		
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe"; // url 서버 주소 
		String sql = " UPDATE NOTICE "// UPDATE = 수정 
				+ "SET "
				+ "    TITLE =?,"
				+ "    CONTENT = ?,"
				+ "    FILES =?"
				+ "WHERE ID =?"; // 속성값 수 
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드 
		Connection con =DriverManager.getConnection(url,"dev","dev"); // 연결 객체  
		//Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM ) 
		 
	PreparedStatement st = con.prepareStatement(sql); //setSTRING 파일 실행 
	st.setString(1, title);
	st.setString(2, content);
	st.setString(3, files);
	st.setInt(4, id);
	
    int result = st.executeUpdate(); //파일 넣기 
    System.out.println(result);
		
		st.close();
		con.close();

	}

}
