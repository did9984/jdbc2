package ex1;


import java.sql.*;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 넣을값 
		String title ="TEST14"; 
		String writerId ="newlec";
		String content = "hahaha";
		String files = "";
		
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe"; // url 서버 주소 
		String sql = "     INSERT INTO notice (" // 넣을 속성들 
				+ "    title,"
				+ "    writer_id,"
				+ "    content,"
				+ "    files"
				+ ") VALUES (?,?,?,?)"; // 속성값 수 
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드 
		Connection con =DriverManager.getConnection(url,"dev","dev"); // 연결 객체  
		//Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM ) 
		 
	PreparedStatement st = con.prepareStatement(sql); //setSTRING 파일 실행 
	st.setString(1, title);
	st.setString(2, writerId);
	st.setString(3, content);
	st.setString(4, files);
	
    int result = st.executeUpdate(); //파일 넣기 
    System.out.println(result);
		
		
		
		
			
		
		 
		st.close();
		con.close();

	}

}
