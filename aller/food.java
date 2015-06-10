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

public class food extends Frame implements ActionListener, ItemListener,Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	food_DTO dto = new food_DTO();//DTO ��ü ����
	
	Button b1; //���۹�ư
	private JTextField in_name;
	private JTextField in_Pname;
	private JTextField all_num1;
	private JTextField all_num2;
	
	public food() {
		setTitle("Food");
		
		init();
		start();
		
		setLocation(100, 100); //������ ������ġ
		setVisible(true); //������ �������� ȭ�鿡 ���
		setSize(345, 416); //�������� ó�� ũ��
		setResizable(false); //������ ������ ����
		setBounds(100, 400, 347, 491);
	}

	public void init() {
		  Panel p = new Panel();
		  setLayout(new BorderLayout());
		  
		  add("Center",p);
		  p.setLayout(null);
		  
		  JLabel label = new JLabel("\uC54C\uB7EC\uC9C0\uBC88\uD638\uC785\uB825");
		  label.setBounds(117, 15, 108, 21);
		  p.add(label);
		  
		  in_name = new JTextField();
		  in_name.setBounds(153, 55, 156, 27);
		  p.add(in_name);
		  in_name.setColumns(10);
		  
		  JLabel lname = new JLabel("date");
		  lname.setBounds(17, 58, 78, 21);
		  p.add(lname);
		  
		  in_Pname = new JTextField();
		  in_Pname.setBounds(153, 123, 156, 27);
		  p.add(in_Pname);
		  in_Pname.setColumns(10);
		  
		  JLabel lpname = new JLabel("allergy number1");
		  lpname.setBounds(17, 126, 102, 21);
		  p.add(lpname);
		  
		  all_num1 = new JTextField();
		  all_num1.setBounds(153, 192, 156, 27);
		  p.add(all_num1);
		  all_num1.setColumns(10);
		  
		  JLabel lblAllergyNumber = new JLabel("allergy number2");
		  lblAllergyNumber.setBounds(17, 195, 129, 21);
		  p.add(lblAllergyNumber);
		  
		  all_num2 = new JTextField();
		  all_num2.setBounds(153, 265, 156, 27);
		  p.add(all_num2);
		  all_num2.setColumns(10);
		  
		  JLabel lblAllergyNumber_1 = new JLabel("allergy number3");
		  lblAllergyNumber_1.setBounds(17, 268, 129, 21);
		  p.add(lblAllergyNumber_1);
		  
		  b1 = new Button("����");
		  b1.setBounds(120, 338, 105, 30);
		  p.add(b1);
		  b1.addActionListener(this);
		  
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
			 public void actionPerformed(ActionEvent e) { //�׼��̺�Ʈ
			  
			  Object obj = e.getSource();
			 
			  //���̵� üũ��ư ������ ��
			  if ((Button) obj == b1) {
			   dto.setDate(in_name.getText()); //�Էµ� ���̵� ������ dto�� ����
			   dto.setAllergy_num1(in_Pname.getText());  //�Էµ� ��й�ȣ�� ������ dto�� ����
			  
			   dto.setAllergy_num2(all_num1.getText());  //�Էµ� �ڱ�Ұ��� ������ dto�� ����
			   dto.setAllergy_num3(all_num2.getText());  //�Էµ� �ڱ�Ұ��� ������ dto�� ����
			   
			   try {
			    food_insertDAO.create(dto);  //dto�� DAO�� �Ѱ��ش�.
			    
			   } catch (Exception e1) {
			    // TODO Auto-generated catch block
			    e1.printStackTrace();
			    
			   }
			   
			  }
			 }
			}