package aller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class join_insertDAO {
public static void main(String[] args) {
}

 public static boolean create(join_DTO dto) throws Exception {

  boolean flag = false;
  Connection con = null;
  PreparedStatement ps = null;
  
  String id = dto.getId();
  String passwd = dto.getPassword();
  String name = dto.getName();
  String mobile = dto.getMobile();
  String phone = dto.getPhone();
  
   /*한글처리를 위해
    * 이클립스와 데이터베이스 설치시 한글처리를 미리 해주면 코드에서 한글처리
    * 안해도 됩니다.
    * */
  try {
	   Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩         
       con = DriverManager.getConnection
       		("jdbc:mysql://localhost:3306/allergorithm" ,"root" ,"1234"); // 데이터연결생성 
	   
	   ps = (PreparedStatement) con.prepareStatement("INSERT INTO teacher_info"
	   		+ " (id, pw, name, mobile, phone) VALUES (?, ?, ?, ?, ?)");
	   ps.setString(1, id);
	   ps.setString(2, passwd);
	   ps.setString(3, name);;;
	   ps.setString(4, mobile);
	   ps.setString(5, phone);
	   
	   flag = true;

	   if(ps.executeUpdate() > 0 ) {
		    System.out.println("성공");
		   } else {
		    System.out.println("실패");
		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		   flag = false;
		  } finally {
		   /* resource를 반환합니다. open 한 순서 반대로 close 시킵니다. */
		   if (ps != null) {
		    try {
		     ps.close();
		    } catch (SQLException e) {
		    }
		   }
		   if (con != null) {
		    try {
		     con.close();
		    } catch (SQLException e) {
		    }
		   }
		  }
  return flag;
 }
}




