package aller;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class login_home extends JFrame {

   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JLabel lblId;
   private JLabel lblPw;
   Button in_login, in_join;
   public JTextField in_id;
   public JPasswordField in_pw;
   
   private String url = "jdbc:mysql://localhost:3306/allergorithm";// user���̺��� �����ϸ�
   private String strUser = "root"; // ���� id
   private String strPassword = "1234"; // ���� �н�����
   private String strMySQLDriver = "com.mysql.jdbc.Driver"; // ����̹� �̸� ���� �������
   Connection con;
   Statement stmt;
   ResultSet rs;
   String sql;
   
   
   String id;
   String pw;
   String name;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      
         /*EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               login_home frame = new login_home();
               frame.setVisible(true);
               frame.setResizable(false);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });*/     
     
	   login_home frame = new login_home();
       frame.setVisible(true);
       frame.setResizable(false);
   }

   /**
    * Create the frame.
    */
   public login_home() {
	   
	   try {
		// �α��� ��ư�� Ŭ�� �Ǿ����ÿ� jdbc����̹��� ����Ѵ�.
		Class.forName(strMySQLDriver);
		// DriverManager�κ��� Ŀ�ؼ��� �����µ� mysql���� . id, pw ���� ���´�.
		con = (Connection) DriverManager.getConnection(url, strUser,
		strPassword);
		// Ŀ�ؼ����κ��� ������ sql���� �����Ű�� ���� statement ��ü�� ���´�.
		stmt = (Statement) con.createStatement();
		} catch (Exception b) {
		System.out.println("db�������");
		}
	    


	   
   	  setTitle("Login");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      lblId = new JLabel("ID    :");
      lblId.setBounds(64, 71, 78, 21);
      contentPane.add(lblId);
      
      lblPw = new JLabel("PW   :");
      lblPw.setBounds(64, 117, 78, 21);
      contentPane.add(lblPw);
      
      in_login = new Button("LOG-IN");
      in_login.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            EventQueue.invokeLater(new Runnable() {
               public void run() {
                  try {
                	  
              	   // �α���â�� �α��� ��ư
              	   loginCheck();
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            });
         }
      });
      
      in_login.setBounds(68, 200, 125, 29);
      contentPane.add(in_login);
      
      in_join = new Button("ȸ������");
      in_join.addMouseListener(new MouseAdapter() {
         
         @Override
         public void mouseClicked(MouseEvent e) {
            EventQueue.invokeLater(new Runnable() {
               public void run() {
                  try {
                     join frame = new join();
                     frame.setVisible(true);
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
               }
            });
         }
      });
      
      in_join.setBounds(210, 200, 125, 29);
      contentPane.add(in_join);
      
      JLabel lblAllergorithm = new JLabel("ALLERGORITHM");
      lblAllergorithm.setBounds(159, 32, 127, 21);
      contentPane.add(lblAllergorithm);
      
      in_id = new JTextField();
      in_id.setBounds(159, 68, 156, 27);
      contentPane.add(in_id);
      in_id.setColumns(10);
      
      in_pw = new JPasswordField();
      in_pw.setBounds(159, 113, 156, 29);
      contentPane.add(in_pw);
   }
   
   @SuppressWarnings("deprecation")
// �α��� ü ũ
void loginCheck() {
// �α���â�� �ؽ�Ʈ�ʵ忡 ������ ��������
id = in_id.getText().trim();
pw = in_pw.getText().trim();

// SELECT ������ �ۼ��Ѵ�. �ش��ϴ� ���̵��� �н����带 �˻��Ѵ�.
String query = "SELECT pw,name FROM teacher_info where id='" + id + "'";

System.out.println(query);
try {
// executeQuery() �޼���� SELECT���� �����Ű�� ����� ResultSet ��ü�� �޴´�.
ResultSet rs = stmt.executeQuery(query);

// ���ڵ尡 �ִ��� �˻�
if (rs.next()) {
//
name = rs.getString("name");

// �ؽ�Ʈ�ʵ忡 ������ �����ͺ��̽��� �ִ� �н����� ���� ���Ѵ�.
if (pw.equals(rs.getString("pw"))) {

   System.out.println("Ȯ�εǾ����ϴ�.");
   home frame = new home();
   frame.setVisible(true);
   
}

}

} catch (Exception b) {
b.printStackTrace();
}
}

}