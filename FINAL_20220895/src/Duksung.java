
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Duksung {
	public static Connection makeConnection() {	
		String url = "jdbc:mysql://localhost:3306/book_db";
		String id = "root";
		String password = "juliakimsas";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}
	public static void main(String[] args) throws SQLException{
		Duksung("2022001","Minji Lee","010-0000-0001","Cyber Security");
		Duksung("2022002","Hanni Park","010-0000-0002","Computer");
		Duksung("2022003","Danielle Chung","010-0000-0003","IT Media");
		Duksung("2022004","Hyein Choi","010-0000-0004","Software");
		

	}
	private static void Duksung(String stuId, String name, String tel, String dept) {
	    Connection con = makeConnection();

	    try {
	        Statement stmt = con.createStatement();
	        String s = "INSERT INTO books(stuId,name,tel,dept) VALUES ";
	        s += "('" + stuId + "','" + name + "','" + tel + "'," + dept + ")";

	        System.out.println(s);
	        int i = stmt.executeUpdate(s);
	        if (i == 1)
	            System.out.println("레코드 추가 성공)");
	        else
	            System.out.println("레코드 추가 실패)");
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.exit(0);
	    }
	}


}
