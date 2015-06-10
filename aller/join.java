package aller;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
 
public class join extends Frame implements ActionListener, ItemListener,Runnable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

join_DTO dto = new join_DTO();//DTO ��ü ����

 public Button b1; //���۹�ư
 public JTextField in_id;
 public JTextField in_name;
 public JTextField in_mobile;
 public JTextField in_phone;
 public JPasswordField in_pw;
 
 public join() {
  
  init();
  start();
 
  this.setLocation(100, 100); //������ ������ġ
  super.setVisible(true); //������ �������� ȭ�鿡 ���
  super.setSize(270, 200); //�������� ó�� ũ��
  super.setResizable(false); //������ ������ ����
  setBounds(100, 400, 346, 363);
 
 }
 
 public void init() {
 
  Panel p = new Panel();
  setLayout(new BorderLayout());
  b1 = new Button("ȸ������"); 
  b1.addActionListener(this);

  
  add("Center",p);
  p.setLayout(null);
  
  in_id = new JTextField();
  in_id.setBounds(153, 55, 156, 27);
  p.add(in_id);
  in_id.setColumns(10);
  
  JLabel lblId = new JLabel("ID");
  lblId.setBounds(17, 58, 78, 21);
  p.add(lblId);
  
  JLabel lblPw = new JLabel("PW");
  lblPw.setBounds(17, 103, 78, 21);
  p.add(lblPw);
  
  in_name = new JTextField();
  in_name.setBounds(153, 139, 156, 27);
  p.add(in_name);
  in_name.setColumns(10);
  
  JLabel lblName = new JLabel("NAME");
  lblName.setBounds(17, 142, 78, 21);
  p.add(lblName);
  
  in_mobile = new JTextField();
  in_mobile.setBounds(153, 181, 156, 27);
  p.add(in_mobile);
  in_mobile.setColumns(10);
  
  in_phone = new JTextField();
  in_phone.setBounds(153, 225, 156, 27);
  p.add(in_phone);
  in_phone.setColumns(10);
  
  JLabel lblMobile = new JLabel("MOBILE");
  lblMobile.setBounds(17, 184, 78, 21);
  p.add(lblMobile);
  
  JLabel lblPhone = new JLabel("PHONE");
  lblPhone.setBounds(17, 228, 78, 21);
  p.add(lblPhone);
  
  JLabel lblJoin = new JLabel("JOIN");
  lblJoin.setBounds(153, 15, 36, 21);
  p.add(lblJoin);
  
  in_pw = new JPasswordField();
  in_pw.setBounds(153, 100, 156, 27);
  p.add(in_pw);
  add("South",b1);
 }
 
   public void start() {
	  this.addWindowListener(new WindowAdapter() { // x�� �������� ����
	   public void windowClosing(WindowEvent e) {
	    System.exit(0);
	   }
	   });
	   }
 
 public static void main(String[] args) {
 }
 
 public void run() { //������ ���Ǻκ�
  
 }
 
 public void itemStateChanged(ItemEvent e) { // üũ���� Ȯ��
 
 
 }
 @SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) { //�׼��̺�Ʈ
  
  Object obj = e.getSource();
 
  //���̵� üũ��ư ������ ��
  if ((Button) obj == b1) {
   dto.setId(in_id.getText()); //�Էµ� ���̵� ������ dto�� ����
   dto.setPassword(in_pw.getText());  //�Էµ� ��й�ȣ�� ������ dto�� ����
   dto.setName(in_name.getText());  //�Էµ� �ڱ�Ұ��� ������ dto�� ����
   dto.setMobile(in_mobile.getText());  //�Էµ� �ڱ�Ұ��� ������ dto�� ����
   dto.setPhone(in_phone.getText());  //�Էµ� �ڱ�Ұ��� ������ dto�� ����
   
   try {
    join_insertDAO.create(dto);  //dto�� DAO�� �Ѱ��ش�.
    //System.exit(0);
   } catch (Exception e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
    //System.exit(0);
   }
   
  }
 }
}

