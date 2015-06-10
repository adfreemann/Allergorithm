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
  
   /*�ѱ�ó���� ����
    * ��Ŭ������ �����ͺ��̽� ��ġ�� �ѱ�ó���� �̸� ���ָ� �ڵ忡�� �ѱ�ó��
    * ���ص� �˴ϴ�.
    * */
  try {
	   Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�         
       con = DriverManager.getConnection
       		("jdbc:mysql://localhost:3306/allergorithm" ,"root" ,"1234"); // �����Ϳ������ 
	   
	   ps = (PreparedStatement) con.prepareStatement("INSERT INTO teacher_info"
	   		+ " (id, pw, name, mobile, phone) VALUES (?, ?, ?, ?, ?)");
	   ps.setString(1, id);
	   ps.setString(2, passwd);
	   ps.setString(3, name);;;
	   ps.setString(4, mobile);
	   ps.setString(5, phone);
	   
	   flag = true;

	   if(ps.executeUpdate() > 0 ) {
		    System.out.println("����");
		   } else {
		    System.out.println("����");
		   }
		  } catch (SQLException e) {
		   e.printStackTrace();
		   flag = false;
		  } finally {
		   /* resource�� ��ȯ�մϴ�. open �� ���� �ݴ�� close ��ŵ�ϴ�. */
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




