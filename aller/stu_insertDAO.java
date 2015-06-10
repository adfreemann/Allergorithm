package aller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class stu_insertDAO {
public static void main(String[] args) {
}

 public static boolean create(stu_DTO dto) throws Exception {

  boolean flag = false;
  Connection con = null;
  PreparedStatement ps = null;
  
  String name = dto.getName();
  String Pname = dto.getPname();
  String Pmobile = dto.getPmobile();
  String Tname = dto.getTname();
  String Tmobile = dto.getTmobile();
  String Sname = dto.getSname();
  String An1 = dto.getAn1();
  String An2 = dto.getAn2();


   /*한글처리를 위해
    * 이클립스와 데이터베이스 설치시 한글처리를 미리 해주면 코드에서 한글처리
    * 안해도 됩니다.
    * */
  try {
	   Class.forName("com.mysql.jdbc.Driver"); // 드라이버로딩         
       con = DriverManager.getConnection
       		("jdbc:mysql://localhost:3306/allergorithm" ,"root" ,"1234"); // 데이터연결생성 
	   
	   ps = (PreparedStatement) con.prepareStatement("INSERT INTO student_info"
	   		+ " (name, parent_name, parent_phone, teacher_name, teacher_phone, school_name, allergy_num1, allergy_num2) "
	   		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	   ps.setString(1, name);
	   ps.setString(2, Pname);
	   ps.setString(3, Pmobile);;;
	   ps.setString(4, Tname);
	   ps.setString(5, Tmobile);
	   ps.setString(6, Sname);
	   ps.setString(7, An1);
	   ps.setString(8, An2);
	   
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
