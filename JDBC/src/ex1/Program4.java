package ex1;


import java.sql.*;

public class Program4 {
     // JDBC 삭제   
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 삭제할 ID     
		int id = 7; // 수정할곳  
		
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe"; // url 서버 주소 
		String sql = "DELETE NOTICE WHERE ID=?";// DELETE = 삭제   
				
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드 
		Connection con =DriverManager.getConnection(url,"dev","dev"); // 연결 객체  
		//Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM ) 
		 
	PreparedStatement st = con.prepareStatement(sql); //파일 실행 
	st.setInt(1, id);
	
    int result = st.executeUpdate(); //파일 업데이트   
    System.out.println(result);
		
		st.close();
		con.close();

	}

}
