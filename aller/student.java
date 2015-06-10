package aller;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;


public class student extends Frame implements ActionListener, ItemListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	stu_DTO dto = new stu_DTO();//DTO 객체 생성
	
	Button b1; //전송버튼
	private JTextField in_name;
	private JTextField in_Pname;
	private JTextField in_Pmobile;
	private JTextField in_Tname;
	private JTextField in_Tmobile;
	private JTextField in_Sname;
	private JTextField all_num1;
	private JTextField all_num2;
	
	public student() {
		
		init();
		start();
		
		setLocation(100, 100); //프레임 시작위치
		setVisible(true); //실제로 프레임을 화면에 출력
		setSize(270, 200); //프레임의 처음 크기
		setResizable(false); //프레임 사이즈 조절
		setBounds(100, 400, 347, 491);
	}

	public void init() {
		  Panel p = new Panel();
		  setLayout(new BorderLayout());
		  
		  add("Center",p);
		  p.setLayout(null);
		  
		  JLabel label = new JLabel("\uD559\uC0DD\uC815\uBCF4\uC785\uB825");
		  label.setBounds(117, 15, 108, 21);
		  p.add(label);
		  
		  in_name = new JTextField();
		  in_name.setBounds(153, 55, 156, 27);
		  p.add(in_name);
		  in_name.setColumns(10);
		  
		  JLabel lname = new JLabel("name");
		  lname.setBounds(17, 58, 78, 21);
		  p.add(lname);
		  
		  in_Pname = new JTextField();
		  in_Pname.setBounds(153, 100, 156, 27);
		  p.add(in_Pname);
		  in_Pname.setColumns(10);
		  
		  JLabel lpname = new JLabel("parent name");
		  lpname.setBounds(17, 103, 102, 21);
		  p.add(lpname);
		  
		  in_Pmobile = new JTextField();
		  in_Pmobile.setBounds(153, 142, 156, 27);
		  p.add(in_Pmobile);
		  in_Pmobile.setColumns(10);
		  
		  JLabel lblParentMobile = new JLabel("parent mobile");
		  lblParentMobile.setBounds(17, 145, 109, 21);
		  p.add(lblParentMobile);
		  
		  in_Tname = new JTextField();
		  in_Tname.setBounds(153, 184, 156, 27);
		  p.add(in_Tname);
		  in_Tname.setColumns(10);
		  
		  JLabel lblTeacherName = new JLabel("teacher name");
		  lblTeacherName.setBounds(17, 187, 112, 21);
		  p.add(lblTeacherName);
		  
		  in_Tmobile = new JTextField();
		  in_Tmobile.setBounds(153, 226, 156, 27);
		  p.add(in_Tmobile);
		  in_Tmobile.setColumns(10);
		  
		  JLabel lblTeacherMobile = new JLabel("teacher mobile");
		  lblTeacherMobile.setBounds(17, 229, 119, 21);
		  p.add(lblTeacherMobile);
		  
		  in_Sname = new JTextField();
		  in_Sname.setBounds(153, 268, 156, 27);
		  p.add(in_Sname);
		  in_Sname.setColumns(10);
		  
		  JLabel lblSchoolName = new JLabel("school name");
		  lblSchoolName.setBounds(17, 271, 106, 21);
		  p.add(lblSchoolName);
		  
		  all_num1 = new JTextField();
		  all_num1.setBounds(153, 310, 156, 27);
		  p.add(all_num1);
		  all_num1.setColumns(10);
		  
		  JLabel lblAllergyNumber = new JLabel("allergy number1");
		  lblAllergyNumber.setBounds(17, 313, 129, 21);
		  p.add(lblAllergyNumber);
		  
		  all_num2 = new JTextField();
		  all_num2.setBounds(153, 352, 156, 27);
		  p.add(all_num2);
		  all_num2.setColumns(10);
		  
		  JLabel lblAllergyNumber_1 = new JLabel("allergy number2");
		  lblAllergyNumber_1.setBounds(17, 355, 129, 21);
		  p.add(lblAllergyNumber_1);
		  
		  b1 = new Button("저장");
		  b1.setBounds(117, 411, 105, 30);
		  p.add(b1);
		  b1.addActionListener(this);
		  
		 }
		 
		 public void start() {
			  this.addWindowListener(new WindowAdapter() { // x를 눌렀을때 종료
			   public void windowClosing(WindowEvent e) {
			    System.exit(0);
			   }
			   });
			  }
		 
		 public static void main(String[] args) {
			 }
			 
			 public void run() { //스레드 정의부분
			  
			 }
			 
			 public void itemStateChanged(ItemEvent e) { // 체크상태 확인
			 
			 
			 }
			 public void actionPerformed(ActionEvent e) { //액션이벤트
			  
			  Object obj = e.getSource();
			 
			  //아이디 체크버튼 눌렀을 떄
			  if ((Button) obj == b1) {
			   dto.setName(in_name.getText()); //입력된 아이디를 가져와 dto에 저장
			   dto.setPname(in_Pname.getText());  //입력된 비밀번호를 가져와 dto에 저장
			   dto.setPmobile(in_Pmobile.getText());  //입력된 자기소개를 가져와 dto에 저장
			   dto.setTname(in_Tname.getText());  //입력된 자기소개를 가져와 dto에 저장
			   dto.setTmobile(in_Tmobile.getText());  //입력된 자기소개를 가져와 dto에 저장
			   dto.setSname(in_Sname.getText());  //입력된 자기소개를 가져와 dto에 저장
			   dto.setAn1(all_num1.getText());  //입력된 자기소개를 가져와 dto에 저장
			   dto.setAn2(all_num2.getText());  //입력된 자기소개를 가져와 dto에 저장
			   
			   try {
			    stu_insertDAO.create(dto);  //dto를 DAO에 넘겨준다.
			    System.exit(0);
			   } catch (Exception e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			    System.exit(0);
			   }
			   
			  }
			 }
			}