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
   
   private String url = "jdbc:mysql://localhost:3306/allergorithm";// user테이블을 수정하면
   private String strUser = "root"; // 계정 id
   private String strPassword = "1234"; // 계정 패스워드
   private String strMySQLDriver = "com.mysql.jdbc.Driver"; // 드라이버 이름 따로 만들어줌
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
		// 로그인 버튼이 클릭 되었을시에 jdbc드라이버를 등록한다.
		Class.forName(strMySQLDriver);
		// DriverManager로부터 커넥션을 얻어오는데 mysql서버 . id, pw 등을 언어온다.
		con = (Connection) DriverManager.getConnection(url, strUser,
		strPassword);
		// 커넥션으로부터 실제로 sql쿼리 실행시키기 위한 statement 객체를 얻어온다.
		stmt = (Statement) con.createStatement();
		} catch (Exception b) {
		System.out.println("db연결실패");
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
                	  
              	   // 로그인창의 로그인 버튼
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
      
      in_join = new Button("회원가입");
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
// 로그인 체 크
void loginCheck() {
// 로그인창의 텍스트필드에 쓴값을 가져오기
id = in_id.getText().trim();
pw = in_pw.getText().trim();

// SELECT 쿼리를 작성한다. 해당하는 아이디값의 패스워드를 검색한다.
String query = "SELECT pw,name FROM teacher_info where id='" + id + "'";

System.out.println(query);
try {
// executeQuery() 메서드로 SELECT문의 실행시키고 결과로 ResultSet 객체를 받는다.
ResultSet rs = stmt.executeQuery(query);

// 레코드가 있는지 검사
if (rs.next()) {
//
name = rs.getString("name");

// 텍스트필드에 쓴값과 데이터베이스에 있는 패스워드 값을 비교한다.
if (pw.equals(rs.getString("pw"))) {

   System.out.println("확인되었습니다.");
   home frame = new home();
   frame.setVisible(true);
   
}

}

} catch (Exception b) {
b.printStackTrace();
}
}

}