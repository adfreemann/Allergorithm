package aller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

class get_mm {
	
	   private String url = "jdbc:mysql://localhost:3306/allergorithm";
	   private String strUser = "root";
	   private String strPassword = "1234"; 
	   private String strMySQLDriver = "com.mysql.jdbc.Driver"; 
	   Connection con;
	   Statement stmt;
	   ResultSet rs;
	   
	   int stu_an1;
	   int stu_an2;
	   int stu_an3;
	   
	   GregorianCalendar gc = new GregorianCalendar();
	   int day = gc.get(Calendar.DATE);
	   
	public get_mm()
	{
		String query = "SELECT allergy_num1, allergy_num2, allergy_num3 FROM month_menu where date='" +6+ "'";

		try {
			Class.forName(strMySQLDriver);
			con = (Connection) DriverManager.getConnection(url, strUser,
			strPassword);
			stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(con!=null){
						System.out.println("연결성공");
			}
				
		while (rs.next()) {
			stu_an1 = Integer.parseInt(rs.getString("allergy_num1"));
			stu_an2 = Integer.parseInt(rs.getString("allergy_num2"));
			stu_an3 = Integer.parseInt(rs.getString("allergy_num3"));
		}

		} catch (Exception b) {
		b.printStackTrace();
		}
		}

	
	}

 
public class com_time {
	   
	private String url = "jdbc:mysql://localhost:3306/allergorithm";
	private String strUser = "root"; 
	private String strPassword = "1234"; 
    private String strMySQLDriver = "com.mysql.jdbc.Driver";
	Connection con;
	Statement stmt;

	public String name;
	public String parent_phone;
    public int allergy_num1;
    public int allergy_num2;

    public int stu_an1;
    public int stu_an2;
    public int result_an1 ;
    public int result_an2 ;
    public int n = 0;
	
	static public void main(String[] args) throws SQLException
	{
		@SuppressWarnings("unused")
		com_time ct = new com_time();
		
	}
		
	public com_time() throws SQLException {
		
		get_mm td = new get_mm();
	
		for(int i=1; i<4; i++)
		{
			getAlnum(i);
		    if(stu_an1 == td.stu_an1 || stu_an1 == td.stu_an2 || stu_an1 == td.stu_an3)
		    	result_an1 = stu_an1;
		    else
		    	result_an1 = 0;
		    if(stu_an2 == td.stu_an1 || stu_an2 == td.stu_an2 || stu_an2 == td.stu_an3)
			    result_an2 = stu_an2;
		    else
		    	result_an2 = 0;
			if(result_an1 != 0 || result_an2 != 0 )
			{
				textSend(result_an1, result_an2, parent_phone);
			}
			result_an1=result_an2=stu_an1=stu_an2=0;
		}
	}
	
	void getAlnum (int i) throws SQLException
	{
		String r1 = null,r2 = null;
		DbCon();
		String query = "SELECT name, allergy_num1, allergy_num2, parent_phone FROM student_info where no='"+i+"'";
		ResultSet rs = stmt.executeQuery(query);
			
		while (rs.next()) {
			r1 = rs.getString("allergy_num1");
			r2 = rs.getString("allergy_num2");
			parent_phone = new String(rs.getString("parent_phone"));
			}
		
		if(!(r1.equals(null)))
			stu_an1 = Integer.parseInt(r1);
		else
			stu_an1 = 0;
		
		if(!(r2.equals(null)))
		    stu_an2 = Integer.parseInt(r2);
		else
			stu_an2 = 0;
	}
	
	void DbCon()
	{
		 try {
				Class.forName(strMySQLDriver);
				con = (Connection) DriverManager.getConnection(url, strUser,
				strPassword);
				stmt = (Statement) con.createStatement();
				} catch (Exception b) {
				System.out.println("db연결실패");
				}
	}
	
	void textSend(int r1, int r2, String pp)
	{
		String s1 = null;
		String s2 = null;
		String aln[];                                          
		aln = new String[12];   
		
		aln[0]= "난류";
		aln[1]= "우유";
		aln[2]= "밀";
		aln[3]= "보리";
		aln[4]= "옥수수";
		aln[5]= "쌀";
		aln[6]= "메밀";
		aln[7]= "땅콩";
		aln[8]= "대두콩";
		aln[9]= "새우";
		aln[10]= "토마토";
		aln[11]= "돼지고기";
		
		for(int i=1; i<13; i++)
		{
			if(r1 == i)
				s1 = new String(aln[i-1]);
		}
		
		for(int i=1; i<13; i++)
		{
			if(r2 == i)
				s2 = new String(aln[i-1]);
		}
		
		if(!pp.equals(null))
		{
		if(r1 != 0 && r2 != 0)
			send(s1,s2,pp);
		else if( r1 == 0 && r2 != 0)
			send(s2,pp);
		else if( r1 != 0 && r2 == 0)
			send(s1,pp);
		}
		parent_phone=null;
	}


	void send(String r1, String r2, String pp)
	{
		SMS sms = new SMS();
        sms.appversion("TEST/1.0");
        sms.charset("utf8");
        sms.setuser("qwer687", "thrhd2011");

     
        SmsMessagePdu pdu = new SmsMessagePdu();
        pdu.type = "SMS";
        pdu.destinationAddress = pp;
        pdu.scAddress = "01044878704";
        pdu.text = "내일 급식에 "+r1+"성분과 "+r2+"성분이 있으니 주의하십시오.";
        sms.add(pdu);

        
        try {
            sms.connect();
            sms.send();
            sms.disconnect();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

   
        sms.printr();
        sms.emptyall();
	}
	
	void send(String r, String pp)
	{
		SMS sms = new SMS();
        sms.appversion("TEST/1.0");
        sms.charset("utf8");
        sms.setuser("qwer687", "thrhd2011");

     
        SmsMessagePdu pdu = new SmsMessagePdu();
        pdu.type = "SMS";
        pdu.destinationAddress = pp;
        pdu.scAddress = "01044878704";
        pdu.text = "내일 급식에 "+r+" 성분이 있으니 주의하십시오.";
        sms.add(pdu);

        
        try {
            sms.connect();
            sms.send();
            sms.disconnect();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

   
        sms.printr();
        sms.emptyall();
	}
	
}