package ex1;


import java.sql.*;







public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe"; // url 서버 주소 
		String sql = "SELECT * FROM NOTICE  ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드 
		Connection con =DriverManager.getConnection(url,"dev","dev"); // 연결 객체  
		Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM ) 
		ResultSet rs = st.executeQuery(sql); //결과 실행 
		
		if(rs.next()){;
		int id = rs.getInt("ID");
		String title = rs.getString("TITLE");
		String writerid = rs.getString("WRITER_ID");
		Date regDate = rs.getDate("REGDATE");
		String content =rs.getString("CONTENT");
		int hit =rs.getInt("hit");
		
		
			System.out.println("id: "+id+"title: "+title+"write: "+writerid+"date: "+regDate+"content: "+content+"hit: "+hit);
		
		
		}
		
			
		
		rs.close(); //close 순서는 역순 
		st.close();
		con.close();

	}

}
