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


   /*�ѱ�ó���� ����
    * ��Ŭ������ �����ͺ��̽� ��ġ�� �ѱ�ó���� �̸� ���ָ� �ڵ忡�� �ѱ�ó��
    * ���ص� �˴ϴ�.
    * */
  try {
	   Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�         
       con = DriverManager.getConnection
       		("jdbc:mysql://localhost:3306/allergorithm" ,"root" ,"1234"); // �����Ϳ������ 
	   
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
