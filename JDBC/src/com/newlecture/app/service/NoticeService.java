package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;


public class NoticeService {
	private String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
	private String uid = "dev";
	private String pwd = "dev";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<Notice> getList(int page, String field,String query) throws ClassNotFoundException, SQLException {

		int Start = 1+ (page-1) *10;       //1,   11, 21, 31, ... 
		int end = 10*page ; // 10 , 20 ,30 ,40 ...
		
		// url 서버 주소
		String sql = "select * from ("
				+ "    SELECT ROWNUM NUM, N.* FROM ("
				+ "        SELECT * FROM NOTICE ORDER BY REGDATE DESC"
				+ "    ) N "
				+ ")"
				+ "WHERE "+field+" LIKE ? AND NUM between ? and ?";

		Class.forName(driver); // 드라이버 로드
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결 객체
		PreparedStatement st = con.prepareStatement(sql);// 쿼리 실행(ex SELECT * FROM )
		st.setString(1, "%"+query+"%");
		st.setInt(2,Start);
		st.setInt(3, end);
		ResultSet rs = st.executeQuery(); // 결과 실행

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			;
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerid = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");

			Notice notice = new Notice(id, title, writerid, regDate, content, hit, files

			);

			list.add(notice);
			System.out.println("id: " + id + "title: " + title + "write: " + writerid + "date: " + regDate + "content: "
					+ content + "hit: " + hit);

		}

		rs.close(); // close 순서는 역순
		st.close();
		con.close();

		return list;
	}
	   // Scalar
		public int getCount() throws ClassNotFoundException, SQLException {
			int count = 0;
			// TODO Auto-generated method stub
			String sql = "select COUNT(ID) COUNT FROM NOTICE";

			Class.forName(driver); // 드라이버 로드
			Connection con = DriverManager.getConnection(url, uid, pwd); // 연결 객체
			Statement st = con.createStatement();// 쿼리 실행(ex SELECT * FROM )

			ResultSet rs = st.executeQuery(sql); // 결과 실행

			List<Notice> list = new ArrayList<Notice>();

			if(rs.next())
			 count = rs.getInt("COUNT");
			

			rs.close(); // close 순서는 역순
			st.close();
			con.close();

			return count;
		}
	
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		// 넣을값
		String title = notice.getTitle();
		String writerId = notice.getWriterid();
		String content = notice.getContent();
		String files = notice.getFiles();

		// TODO Auto-generated method stub

		String sql = "     INSERT INTO notice (" // 넣을 속성들
				+ "    title," + "    writer_id," + "    content," + "    files" + ") VALUES (?,?,?,?)"; // 속성값 수

		Class.forName(driver); // 드라이버 로드
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결 객체
		// Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM )

		PreparedStatement st = con.prepareStatement(sql); // setSTRING 파일 실행
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);

		int result = st.executeUpdate(); // 파일 넣기
		System.out.println(result);

		st.close();
		con.close();
		return result;
	}

	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		// 수정할 내용
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId(); // 수정할곳

		// TODO Auto-generated method stub

		String sql = " UPDATE NOTICE "// UPDATE = 수정
				+ "SET " + "    TITLE =?," + "    CONTENT = ?," + "    FILES =?" + "WHERE ID =?"; // 속성값 수

		Class.forName(driver); // 드라이버 로드
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결 객체
		// Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM )

		PreparedStatement st = con.prepareStatement(sql); // setSTRING 파일 실행
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);

		int result = st.executeUpdate(); // 파일 넣기

		st.close();
		con.close();
		return result;

	}

	public int delelte(int id) throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub

		String sql = "DELETE NOTICE WHERE ID=?";// DELETE = 삭제

		Class.forName(driver); // 드라이버 로드
		Connection con = DriverManager.getConnection(url, uid, pwd); // 연결 객체
		// Statement st = con.createStatement(); // 쿼리 실행(ex SELECT * FROM )

		PreparedStatement st = con.prepareStatement(sql); // 파일 실행
		st.setInt(1, id);

		int result = st.executeUpdate(); // 파일 업데이트

		st.close();
		con.close();

		return result;
	}
 
}
