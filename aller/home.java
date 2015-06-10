package aller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel contentPane;
   private final JLabel lblNewLabel = new JLabel("");

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
	   home h = new home();
	   h.setVisible(true);
   }

   /**
    * Create the frame.
    */
   public home() {
   	setTitle("Home");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 450, 300);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);
      lblNewLabel.setBounds(195, 5, 57, 15);
      panel.add(lblNewLabel);
    
     
      
      
      JButton button_1 = new JButton("\uD559\uC0DD\uB4F1\uB85D");
      button_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      	}
      });
        button_1.addMouseListener(new MouseAdapter() {
          
          @Override
          public void mouseClicked(MouseEvent e) {
             EventQueue.invokeLater(new Runnable() {
                public void run() {
                   try {
                      student frame = new student();
                      frame.setVisible(true);
                   } catch (Exception e) {
                      e.printStackTrace();
                   }
                }
             });
          }
       });
     
      button_1.setBounds(213, 78, 125, 29);
      panel.add(button_1);
      
      JButton button_2 = new JButton("\uC2DD\uB2E8\uB4F1\uB85D");
button_2.addMouseListener(new MouseAdapter() {
          
          @Override
          public void mouseClicked(MouseEvent e) {
             EventQueue.invokeLater(new Runnable() {
                public void run() {
                   try {
                      food frame = new food();
                      frame.setVisible(true);
                   } catch (Exception e) {
                      e.printStackTrace();
                   }
                }
             });
          }
       });
      button_2.setBounds(46, 78, 125, 29);
      panel.add(button_2);
   }
}