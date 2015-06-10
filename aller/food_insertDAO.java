package aller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class food_insertDAO {
public static void main(String[] args) {
}

 public static boolean create(food_DTO dto) throws Exception {

	 boolean flag = false;
	  Connection con = null;
	  PreparedStatement ps = null;
  
  String date = dto.getDate();
  String allergy_num1 = dto.getAllergy_num1();
  String allergy_num2 = dto.getAllergy_num2();
  String allergy_num3 = dto.getAllergy_num3();

 


   /*�ѱ�ó���� ����
    * ��Ŭ������ �����ͺ��̽� ��ġ�� �ѱ�ó���� �̸� ���ָ� �ڵ忡�� �ѱ�ó��
    * ���ص� �˴ϴ�.
    * */
  try {
	   Class.forName("com.mysql.jdbc.Driver"); // ����̹��ε�         
       con = DriverManager.getConnection
       		("jdbc:mysql://localhost:3306/allergorithm" ,"root" ,"1234"); // �����Ϳ������ 
	   
	   ps = (PreparedStatement) con.prepareStatement("INSERT INTO month_menu "
	   		+ " (date,allergy_num1,allergy_num2,allergy_num3) "
	   		+ "VALUES (?, ?, ?, ?)");
	   ps.setString(1, date);
	   ps.setString(2, allergy_num1);
	   ps.setString(3, allergy_num2);
	   ps.setString(4, allergy_num3);
	   
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
