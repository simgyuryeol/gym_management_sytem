package DBProject;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JScrollBar;

import java.sql.*;

public class DBProject {

   private JFrame frame;
   private JTextField id_input;
   private JTextField pass_input;
   private JTextField number_text;
   private JTextField fee_text;
   private JTextField address;
   private JTextField rocker;
   private JTextField all_people;
   private JTable table;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTable table_1;
   private JTextField tri_name_input;
   private JTextField tri_number_input;
   private JTextField tri_adress_input;
   private JTable table_2;
   private JTable tro_pt_panel;
   private JTable tri_pt_table;
   private JTextField pt_info_name_input;
   private JTextField pt_info_diet_input;
   private JTextField pt_info_Progress_input;
   private JTable table_3;
   private JTable table_4;
   private JTable table_5;

     
      String url ="jdbc:oracle:thin:@localhost:1521:XE";
      String id = "HEALTH";      
      String password = "1234";
      private JTable health_table;
      private JTable table_health;

      private JTextField health_info_number;
      private JTextField health_info_fee_text;
      private JTextField health_info_add_text;
      private JTextField health_info_rocker_text;
      private JTextField health_info_all_text;
      
      Connection con = null;
      private JTextField health_info_address;
      private JTextField textField_3;
      private JTextField textField_4;
      private JTextField textField_5;
      private JTextField textField_6;
      private JLabel health_info_name;
      private JTable table_6;
      private JTextField textField_7;
      private JTextField textField_8;
      private JTextField textField_9;
      private JTextField textField_10;
      private JTextField textField_11;
      private JTextField textField_12;
      private JTextField textField_13;
      private JTextField textField_14;
      private JTextField textField_15;
      private JTextField textField_16;
      private JTextField textField_17;
      private JTextField textField_18;
      private JTextField textField_19;
      private JTextField textField_20;
      private JTextField textField_21;
      private JTextField textField_22;
      private JTextField textField_23;
      private JTextField textField_24;
      
      String healt_name;
      
	protected String health_name; //�ｺ�� �̸�
	protected String trainer_name; //Ʈ���̳��̸�
	protected String trainer_number; //Ʈ���̳ʹ�ȣ
	protected String user_number; //������ȣ
	
	private JTextField textField_29;
	private JTextField textField_188;
	private JTextField add_name_input;
	private JTextField ad;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_month;
	private JTextField textField_ex_num;
	
	
      public DBProject() {
         initialize();
      
           try {
             Class.forName("oracle.jdbc.driver.OracleDriver");
              System.out.println("����̹� ���� ����");
           } 
           
           catch (ClassNotFoundException e) {
              System.out.println("No Driver."); 
              }  
         }
         
      public void DB_Connect() {
           try {
              
               con = DriverManager.getConnection(url, id, password);
               System.out.println("DB ���� ����");
           } catch (SQLException e) {         
              System.out.println("Connection Fail");     
              }
         }
         
   public static void main(String[] args){
      

      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               DBProject window = new DBProject();
               window.DB_Connect();
               window.frame.setVisible(true);
               
            } catch (Exception e) {
               e.printStackTrace();
            }
            
         }
      });
   }


   /**
    * Create the application.
    */

   /**
    * Initialize the contents of the frame.
    */
   
   
   
   private void initialize() {
      


      String system  = "system";
      String number = "1234";
            
      
      
      
      //������ ����
      frame = new JFrame();
      frame.setBounds(100, 100, 905, 729);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
     

           
      //�α��� �г�
       JPanel login_panel = new JPanel();
      login_panel.setBounds(0, 10, 715, 512);
      frame.getContentPane().add(login_panel);
      login_panel.setLayout(null);
  
 
      

      //���� �������̽�
      JPanel main = new JPanel();
      main.setForeground(Color.WHITE);
      main.setBounds(0, 55, 889, 443);
      frame.getContentPane().add(main);
      main.setLayout(null);
      main.setVisible(false);

      //�ｺ������
      JPanel main_info = new JPanel();
      main_info.setForeground(Color.WHITE);
      main_info.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(main_info);
      main_info.setLayout(null);
      main_info.setVisible(false);
  

         
      //ȸ������
      JPanel number_panel = new JPanel();
      number_panel.setBounds(0, 22, 889, 476);
      frame.getContentPane().add(number_panel);
      number_panel.setLayout(null);
      number_panel.setVisible(false);


      //ȸ����ȸ
      JPanel number_panel_1 = new JPanel();
      number_panel_1.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(number_panel_1);
       number_panel_1.setLayout(null);
       number_panel_1.setVisible(false);
    
    
      
 
      //Ʈ���̳�  �г�
    JPanel tri_panel = new JPanel();
    tri_panel.setBounds(0, 0, 889, 690);
    frame.getContentPane().add(tri_panel);
    tri_panel.setLayout(null);
    tri_panel.setVisible(false);
    

    //Ʈ���̳� ���� �г�
    JPanel tri_info_panel = new JPanel();
    tri_info_panel.setBounds(0, 0, 889, 690);
    frame.getContentPane().add(tri_info_panel);
    tri_info_panel.setLayout(null);
    tri_info_panel.setVisible(false);


      //Ʈ���̳� pt�г�
      JPanel tri_pt_panel = new JPanel();
      tri_pt_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(tri_pt_panel);
      tri_pt_panel.setLayout(null);
      tri_pt_panel.setVisible(false);
   

      //ptȸ��_����
      JPanel pt_member_info = new JPanel();
      pt_member_info.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(pt_member_info);
      pt_member_info.setLayout(null);
      pt_member_info.setVisible(false);
        

      //��ⱸ�߰�
      JPanel ex_add_panel = new JPanel();
      ex_add_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(ex_add_panel);
      ex_add_panel.setLayout(null);
      ex_add_panel.setVisible(false);
     

      //��ǰ�г�
      JPanel goods_panel = new JPanel();
      goods_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(goods_panel);
      goods_panel.setLayout(null);
      goods_panel.setVisible(false);


      //��ǰ ������ �г�
      JPanel goods_add_panel = new JPanel();
      goods_add_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(goods_add_panel);
      goods_add_panel.setLayout(null);
      goods_add_panel.setVisible(false);
      
      
      
      
    //��ǰ

      

      JPanel goods_panel_add = new JPanel();
      goods_panel_add.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(goods_panel_add);
      goods_panel_add.setLayout(null);
      goods_panel_add.setVisible(false);
   

      
     
      //pt����г�
      JPanel pt_add_panel = new JPanel();
      pt_add_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(pt_add_panel);
      pt_add_panel.setLayout(null);
      pt_add_panel.setVisible(false);

      
      //��ⱸ �г�
      JPanel  ex_info_panel= new JPanel();
      ex_info_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(ex_info_panel);
      ex_info_panel.setLayout(null);
      ex_info_panel.setVisible(false);
     

      //��ⱸ ��Ż�г�
      JPanel ex_rental_panel = new JPanel();
      ex_rental_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(ex_rental_panel);
      ex_rental_panel.setLayout(null);
      ex_rental_panel.setVisible(false);
      
      

      //��ǰ���� �г�
      JPanel goods_purchase_panel = new JPanel();
      goods_purchase_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(goods_purchase_panel);
      goods_purchase_panel.setLayout(null);
      goods_purchase_panel.setVisible(false);
      
      //��ǰ�ֹ� �г�
      JPanel goods_order_panel = new JPanel();
      goods_order_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(goods_order_panel);
      goods_order_panel.setLayout(null);
      goods_order_panel.setVisible(false);
      

      //pt��� �г�
      JPanel pt_Enroll_panel = new JPanel();
      pt_Enroll_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(pt_Enroll_panel);
      pt_Enroll_panel.setLayout(null);
      pt_Enroll_panel.setVisible(false);
      

      //�ⱸ �뿩 �г�
      JPanel rental_add_panel = new JPanel();
      rental_add_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(rental_add_panel);
      rental_add_panel.setLayout(null);
      rental_add_panel.setVisible(false);
    

      

      //ȸ���߰� �г�
      JPanel number_add_panel = new JPanel();
      number_add_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(number_add_panel);
      number_add_panel.setLayout(null);
      number_add_panel.setVisible(false);
      
      
    //�ⱸ�߰� �г� 
      JPanel ex_enroll_panel = new JPanel();
      ex_enroll_panel.setBounds(0, 0, 889, 690);
      frame.getContentPane().add(ex_enroll_panel);
      ex_enroll_panel.setLayout(null);
        ex_enroll_panel.setVisible(false);; 
      
   
      
      String header_health []  = { "���Ը� "};
      DefaultTableModel model = new DefaultTableModel(header_health,0);

      JButton btnNewButton_5 = new JButton("\uC0AD\uC81C");
      btnNewButton_5.setBackground(Color.WHITE);
      
      btnNewButton_5.addActionListener(new ActionListener() {  //�ｺ�� ���� ��ư
      	public void actionPerformed(ActionEvent e) {
      		 try {
		         DB_Connect(); 
		         String query = "delete from �ｺ�� where �ｺ��.���Ը�="+"\'"+ health_name +"\'"; 
		         Statement stmt = con.createStatement(); 
		         stmt.execute(query);
		         stmt.close();
		      }catch (SQLException e1) {
		    	  JOptionPane.showMessageDialog(null,"��������!");
		         e1.printStackTrace();
		      }finally {
		         try {           
		         } catch (Exception e1) {
		            
		            e1.printStackTrace();
		         }
		      }
	 
			//�ｺ�� ���̺� ��ȸ
		      try {
		         DB_Connect();
		         String query = "select ���Ը� from �ｺ��"; 
		         Statement stmt = con.createStatement(); 
		         ResultSet rs = stmt.executeQuery(query); 
		         model.setNumRows(0);
		         while(rs.next()) {
		            String[] rows = new String[1];
		            rows[0]=rs.getString("���Ը�");
		            model.addRow(rows);
		            
		         }
		         rs.close();
		         stmt.close();
		      }catch (SQLException e1) {
		         e1.printStackTrace();
		      }finally {
		         try {
		            
		            
		         } catch (Exception e1) {
		            
		            e1.printStackTrace();
		         }
		      }
		      
			 
			 main_info.setVisible(false);
			main.setVisible(true);
      	}
      });
      btnNewButton_5.setFont(new Font("�������", Font.PLAIN, 21));
      btnNewButton_5.setBounds(607, 550, 97, 45);
      main_info.add(btnNewButton_5);


      
      //�α���
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setFont(new Font("���� ���", Font.PLAIN, 21));
      lblNewLabel.setBounds(138, 198, 92, 36);
      login_panel.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
      lblNewLabel_1.setFont(new Font("�������", Font.PLAIN, 21));
      lblNewLabel_1.setBounds(138, 264, 92, 27);
      login_panel.add(lblNewLabel_1);
      
      id_input = new JTextField();
      id_input.setBounds(242, 200, 148, 42);
      login_panel.add(id_input);
      id_input.setColumns(10);
      
      pass_input = new JTextField();
      pass_input.setBounds(242, 260, 148, 42);
      login_panel.add(pass_input);
      pass_input.setColumns(10);
      
      JButton login_button = new JButton("\uB85C\uADF8\uC778");
      login_button.setBackground(Color.WHITE);
      login_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(system.equals(id_input.getText()) && number.equals(pass_input.getText())){
                  login_panel.setVisible(false);
                  main.setVisible(true);
            }
         }
      });
      login_button.setFont(new Font("�������", Font.PLAIN, 18));
      login_button.setBounds(414, 213, 120, 78);
      login_panel.add(login_button);
      
      
      //���� �������̽�


		JLabel lblNewLabel_2;
		health_info_name = new JLabel("\uD5EC\uC2A4\uC7A5");
		health_info_name.setFont(new Font("�������", Font.PLAIN, 40));
		health_info_name.setBounds(390, 10, 444, 82);
		main_info.add(health_info_name);
		


		number_text = new JTextField();
		number_text.setFont(new Font("�������", Font.PLAIN, 19));
		number_text.setBounds(337, 192, 233, 46);
		main_info.add(number_text);
		number_text.setColumns(10);
		
		fee_text = new JTextField();
		fee_text.setFont(new Font("�������", Font.PLAIN, 19));
		fee_text.setToolTipText("zxczcz");
		fee_text.setBounds(337, 266, 233, 46);
		number_text.setText("tt");
		main_info.add(fee_text);
		fee_text.setColumns(10);
		
		address = new JTextField();
		address.setFont(new Font("�������", Font.PLAIN, 19));
		address.setBounds(337, 340, 525, 52);
		main_info.add(address);
		address.setColumns(10);
		
		
		all_people = new JTextField();
		all_people.setFont(new Font("�������", Font.PLAIN, 19));
		all_people.setBounds(337, 486, 233, 41);
		main_info.add(all_people);
		all_people.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_3.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(230, 195, 95, 41);
		main_info.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uC6A9\uB8CC");
		lblNewLabel_4.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(230, 269, 78, 41);
		main_info.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_5.setFont(new Font("�������", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(230, 351, 82, 30);
		main_info.add(lblNewLabel_5);

		
		JLabel lblNewLabel_7 = new JLabel("\uC804\uCCB4 \uD68C\uC6D0\uC218");
		lblNewLabel_7.setFont(new Font("�������", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(230, 486, 123, 41);
		main_info.add(lblNewLabel_7);

		
		JButton main_info_back = new JButton("\uB098\uAC00\uAE30");
	
		main_info_back.setBackground(Color.WHITE);
		main_info_back.setFont(new Font("�������", Font.PLAIN, 21));
		main_info_back.setBounds(36, 600, 97, 40);
		main_info.add(main_info_back);
		
		 //�� ����� 
	      JLabel lblNewLabel_111 = new JLabel("\uCD1D \uB9E4\uCD9C\uC561");
	      lblNewLabel_111.setFont(new Font("�������", Font.PLAIN, 20));
	      lblNewLabel_111.setBounds(230, 541, 108, 27);
	      main_info.add(lblNewLabel_111);
	      
	    //�� ����� text
			textField_29 = new JTextField();
		    textField_29.setBounds(337, 537, 124, 31);
		    main_info.add(textField_29);
		    textField_29.setColumns(10);
  		
    //�ｺ�� ���̺� ��ȸ

      try {
         DB_Connect();
         String query = "select ���Ը� from �ｺ��"; //db���̺��� ����ҷ�����
         Statement stmt = con.createStatement(); //statement����
         ResultSet rs = stmt.executeQuery(query); //prearedstatement����
         
         while(rs.next()) {
            String[] rows = new String[1];
            rows[0]=rs.getString("���Ը�");
            model.addRow(rows);
            
         }
         rs.close();
         stmt.close();
      }catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            
            
         } catch (Exception e1) {
            
            e1.printStackTrace();
         }
      }
      JTable table10 = new JTable(model);
      JScrollPane health_scrollPane = new JScrollPane(table10);
      health_scrollPane.setEnabled(false);
      health_scrollPane.setBounds(106, 106, 654, 239);
      
      
	  
      main.add(health_scrollPane);
   

      //���̺� Ŭ���� �ｺ�� ������ȸ
   

     table10.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {  //�ｺ�� ������
			// TODO Auto-generated method stub
			main.setVisible(false);
			main_info.setVisible(true);
			int row = table10.getSelectedRow();
			String data  = (String) table10.getValueAt(row,0);
			health_name = data;
			
			  try {
			         DB_Connect();
			         String query = "select ���Ը�,��ȭ��ȣ,�̿��,�ּ�,��Ŀ��Ȳ from �ｺ��";
			         Statement ps = con.createStatement();
			         ResultSet rs = ps.executeQuery(query);
			         
			         while(rs.next()) {
			        	 if(rs.getString("���Ը�").equals(data)){
			        		 
			        	health_info_name.setText(rs.getString("���Ը�"));
			        	number_text.setText(rs.getString("��ȭ��ȣ"));
			        	fee_text.setText(rs.getString("�̿��"));
			        	address.setText(rs.getString("�ּ�"));
			        	
			        	CallableStatement cstmt_1 = con.prepareCall("{call �ｺ���ο���(?,?)}");
			        	cstmt_1.setString(1,data);
			        	cstmt_1.registerOutParameter(2, Types.INTEGER);
			        	cstmt_1.executeQuery();
			        	all_people.setText(Integer.toString(cstmt_1.getInt(2))+"��");
			        	
			        	CallableStatement cstmt = con.prepareCall("{call SALES(?,?)}");
			        	cstmt.setString(1,data);
			        	cstmt.registerOutParameter(2, Types.INTEGER);
			        	cstmt.executeQuery();
			        	textField_29.setText(Integer.toString(cstmt.getInt(2))+"��");
			        	

			         }
			         }
			         rs.close();
			         ps.close();
			      }catch (SQLException e1) {
			         e1.printStackTrace();
			      }finally {
			         try {
			            
			            
			         } catch (Exception e1) {
			            
			            e1.printStackTrace();
			         }
			      }

	      	  main_info.add(health_info_name);
			  main_info.add(number_text);
			  main_info.add(fee_text);
			  main_info.add(address);
			  main_info.add(all_people);
			  //main_info.add(rocker);
		
		}
	});
      
     //�ڷΰ���
		main_info_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_info.setVisible(false);
				main.setVisible(true);
			}
		});
		


     //ȸ������ �г��̵�
      JButton number_info = new JButton("\uD68C\uC6D0\uC815\uBCF4");
      number_info.setBackground(Color.WHITE);
      number_info.setFont(new Font("�������", Font.PLAIN, 13));
      number_info.setBounds(118, 102, 124, 52);
      main_info.add(number_info);
      
      
      
      String number_health []  = { "ȸ����ȣ ","�̸�","���� ��"};
      DefaultTableModel number_dm = new DefaultTableModel(number_health,0);
     
      number_info.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) { //ȸ�� ���
            // TODO Auto-generated method stub
            main_info.setVisible(false);
            number_panel.setVisible(true);
            
           
            try {
            	
               DB_Connect();
               String user_query = "select ȸ��.ȸ����ȣ,ȸ��.�̸� ,����.���Ը� from ȸ��,���� where ȸ��.ȸ����ȣ=����.ȸ����ȣ"; 
               Statement stmt = con.createStatement(); 
               ResultSet rs = stmt.executeQuery(user_query); 
               System.out.println(health_name);
               number_dm.setNumRows(0);
               while(rs.next()) {
            	   
            	  if(rs.getString("���Ը�").equals(health_name)) {
            	
                  String[] rows = new String[3];
                  rows[0]=rs.getString("ȸ����ȣ");
                  rows[1]=rs.getString("�̸�");
                  
                  CallableStatement cstmt = con.prepareCall("{call ������(?,?)}");
		        	cstmt.registerOutParameter(1,Types.VARCHAR);
		        	cstmt.setInt(2, Integer.parseInt(rs.getString("ȸ����ȣ")));
		        	cstmt.executeQuery();
		        	rows[2]=cstmt.getString(1)+"��";
		        	        			
                  number_dm.addRow(rows);
                  number_dm.isCellEditable(2,0);

            	  }
            	  
            	  }
               rs.close();
               stmt.close();
            }catch (SQLException e1) {
               e1.printStackTrace();
            }finally {
               try {
                        
               } catch (Exception e1) {
                  
                  e1.printStackTrace();
               }
            }
                     
         }
                  
      });
     
      JTable number_table_1 = new JTable(number_dm);
      JScrollPane number_scrollPane = new JScrollPane(number_table_1);
      number_scrollPane.setEnabled(false);
      number_scrollPane.setBounds(90, 23, 654, 320);
      number_panel.add(number_scrollPane);
     
      
      
      //ȸ������
      textField = new JTextField();
      textField.setFont(new Font("�������", Font.PLAIN, 19));
      textField.setBounds(378, 41, 126, 35);
      number_panel_1.add(textField);
      textField.setColumns(10);
      
      
      textField_1 = new JTextField();
      textField_1.setFont(new Font("�������", Font.PLAIN, 19));
      textField_1.setBounds(378, 102, 183, 35);
      number_panel_1.add(textField_1);
      textField_1.setColumns(10);
      
      
      
      textField_2 = new JTextField();
      textField_2.setFont(new Font("�������", Font.PLAIN, 19));
      textField_2.setBounds(378, 172, 244, 35);
      number_panel_1.add(textField_2);
      textField_2.setColumns(10);
      
      
      
      JLabel lblNewLabel_8 = new JLabel("\uC774\uB984");
      lblNewLabel_8.setFont(new Font("�������", Font.PLAIN, 18));
      lblNewLabel_8.setBounds(295, 41, 57, 25);
      number_panel_1.add(lblNewLabel_8);
      
      
      
      JLabel lblNewLabel_9 = new JLabel("\uC5F0\uB77D\uCC98");
      lblNewLabel_9.setFont(new Font("�������", Font.PLAIN, 18));
      lblNewLabel_9.setBounds(295, 103, 71, 35);
      number_panel_1.add(lblNewLabel_9);
      
      
      
      JLabel lblNewLabel_10 = new JLabel("\uC8FC\uC18C");
      lblNewLabel_10.setFont(new Font("�������", Font.PLAIN, 18));
      lblNewLabel_10.setBounds(295, 178, 77, 25);
      number_panel_1.add(lblNewLabel_10);
      
      
      
      //������ư ������ �ڷΰ���
      JButton button = new JButton("\uB098\uAC00\uAE30");
      button.setBackground(Color.WHITE);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            number_panel_1.setVisible(false);
            number_panel.setVisible(true);
         }
      });
      
     
      //ȸ������ 
      button.setFont(new Font("�������", Font.PLAIN, 19));
      button.setBounds(12, 635, 97, 45);
      number_panel_1.add(button);
      

      
      JLabel key_label = new JLabel("\uD0A4");
      key_label.setFont(new Font("�������", Font.PLAIN, 18));
      key_label.setBounds(295, 309, 77, 25);
      number_panel_1.add(key_label);
      
      JLabel whight_number = new JLabel("\uBAB8\uBB34\uAC8C");
      whight_number.setFont(new Font("�������", Font.PLAIN, 18));
      whight_number.setBounds(295, 240, 57, 33);
      number_panel_1.add(whight_number);
      
      JLabel age_number = new JLabel("\uB098\uC774");
      age_number.setFont(new Font("�������", Font.PLAIN, 18));
      age_number.setBounds(295, 368, 57, 15);
      number_panel_1.add(age_number);
      
      JLabel sung_number = new JLabel("\uC131\uBCC4");
      sung_number.setFont(new Font("�������", Font.PLAIN, 18));
      sung_number.setBounds(295, 428, 75, 25);
      number_panel_1.add(sung_number);
      
      JLabel use_number = new JLabel("\uC0AC\uC6A9\uAE08\uC561");
      use_number.setFont(new Font("�������", Font.PLAIN, 18));
      use_number.setBounds(291, 486, 75, 25);
      number_panel_1.add(use_number);
      
      JLabel emdrmq_number = new JLabel("\uB4F1\uAE09");
      emdrmq_number.setFont(new Font("�������", Font.PLAIN, 18));
      emdrmq_number.setBounds(291, 554, 75, 25);
      number_panel_1.add(emdrmq_number);
      
      JLabel akdlf_number = new JLabel("\uB9C8\uC77C\uB9AC\uC9C0");
      akdlf_number.setFont(new Font("�������", Font.PLAIN, 18));
      akdlf_number.setBounds(291, 618, 75, 25);
      number_panel_1.add(akdlf_number);
      
      textField_7 = new JTextField();
      textField_7.setBounds(378, 240, 126, 35);
      number_panel_1.add(textField_7);
      textField_7.setColumns(10);
      
      textField_8 = new JTextField();
      textField_8.setBounds(378, 309, 126, 35);
      number_panel_1.add(textField_8);
      textField_8.setColumns(10);
      
      textField_9 = new JTextField();
      textField_9.setBounds(378, 366, 126, 35);
      number_panel_1.add(textField_9);
      textField_9.setColumns(10);
      
      textField_10 = new JTextField();
      textField_10.setBounds(378, 424, 126, 35);
      number_panel_1.add(textField_10);
      textField_10.setColumns(10);
      
      textField_11 = new JTextField();
      textField_11.setBounds(378, 482, 126, 35);
      number_panel_1.add(textField_11);
      textField_11.setColumns(10);
      
      textField_12 = new JTextField();
      textField_12.setBounds(378, 550, 126, 35);
      number_panel_1.add(textField_12);
      textField_12.setColumns(10);
      
      textField_13 = new JTextField();
      textField_13.setBounds(378, 614, 126, 35);
      number_panel_1.add(textField_13);
      textField_13.setColumns(10);
      
      
      //ȸ�� ����
      JButton number_1_su = new JButton("\uC218\uC815");
      number_1_su.setBackground(Color.WHITE);
      number_1_su.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  //ȸ�� ����
        		
        		 try{
            		 DB_Connect();
            		 
            		 System.out.println(user_number);
            		PreparedStatement pstmt =null;  
            	 	String sql = "update ȸ�� set �̸�=?, ����ó=?, �ּ�=?, ������=?, Ű=?,����=?,����=? where ȸ��.ȸ����ȣ="+"\'"+user_number+"\'";
            	 	pstmt=con.prepareStatement(sql);
            	 	pstmt.setString(1, textField.getText());
            	 	pstmt.setString(2, textField_1.getText());
            	 	pstmt.setString(3, textField_2.getText());
            	 	pstmt.setString(4, textField_7.getText());
            	 	pstmt.setString(5, textField_8.getText());
            	 	pstmt.setString(6, textField_9.getText());
            	 	pstmt.setString(7, textField_10.getText());
            	 	pstmt.execute();
            	 	

        		
        		
        		 }catch (SQLException e1) {
        			 JOptionPane.showMessageDialog(null,"���� ����!");
       		         e1.printStackTrace();
      		      }finally {
      		         try {       
      		         } catch (Exception e1) {
      		            
      		            e1.printStackTrace();
      		         }
      		      }
        		 
        		 try {
                    	
                     DB_Connect();
                     String user_query = "select ȸ��.ȸ����ȣ,ȸ��.�̸� ,����.���Ը� from ȸ��,���� where ȸ��.ȸ����ȣ=����.ȸ����ȣ"; 
                     Statement stmt = con.createStatement(); 
                     ResultSet rs = stmt.executeQuery(user_query); 
                     System.out.println(health_name);
                     number_dm.setNumRows(0);
                     while(rs.next()) {
                  	   
                  	  if(rs.getString("���Ը�").equals(health_name)) {
                  	
                        String[] rows = new String[3];
                        rows[0]=rs.getString("ȸ����ȣ");
                        rows[1]=rs.getString("�̸�");
                        
                        CallableStatement cstmt = con.prepareCall("{call ������(?,?)}");
      		        	cstmt.registerOutParameter(1,Types.VARCHAR);
      		        	cstmt.setInt(2, Integer.parseInt(rs.getString("ȸ����ȣ")));
      		        	cstmt.executeQuery();
      		        	rows[2]=cstmt.getString(1)+"��";
	
                        number_dm.addRow(rows);
                        number_dm.isCellEditable(2,0);

                  	  }
                  	  
                  	  }
                     rs.close();
                     stmt.close();
                  }catch (SQLException e1) {
                     e1.printStackTrace();
                  }finally {
                     try {
                              
                     } catch (Exception e1) {
                        
                        e1.printStackTrace();
                     }
                  }
        		 
        		 number_panel_1.setVisible(false);
                 number_panel.setVisible(true);
        	}
        });
     
      
      number_1_su.setFont(new Font("�������", Font.PLAIN, 19));
      number_1_su.setBounds(721, 568, 97, 45);
      number_panel_1.add(number_1_su);
      
      
      JButton number_1_del = new JButton("\uC0AD\uC81C");
      number_1_del.setBackground(Color.WHITE);
      number_1_del.setFont(new Font("�������", Font.PLAIN, 19));
      
      number_1_del.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  //ȸ������
        		
        		//number_1_del.setVisible(false);
        		number_panel.setVisible(true);
        		try {
   		         DB_Connect();
   		      System.out.println(user_number);
   		         
   		         String query = "delete from ȸ�� where ȸ��.ȸ����ȣ="+"\'"+ user_number +"\'"; 
   		         Statement stmt = con.createStatement(); 
   		         stmt.execute(query);

   		         stmt.close();
   		      }catch (SQLException e1) {
   		    	JOptionPane.showMessageDialog(null,"���� ����!");
   		         e1.printStackTrace();
   		      }finally {
   		         try {       
   		         } catch (Exception e1) {
   		            
   		            e1.printStackTrace();
   		         }
   		      }
   			
        		//ȸ�� ��ȸ ���̺� ����
                 try {
                 	
                    DB_Connect();
                    String user_query = "select ȸ��.ȸ����ȣ,ȸ��.�̸� ,����.���Ը� from ȸ��,���� where ȸ��.ȸ����ȣ=����.ȸ����ȣ"; //db���̺��� ����ҷ�����
                    Statement stmt = con.createStatement(); //statement����
                    ResultSet rs = stmt.executeQuery(user_query); 
                    System.out.println(health_name);
                    number_dm.setNumRows(0);
                    while(rs.next()) {
                 	   
                 	  if(rs.getString("���Ը�").equals(health_name)) {
                 	
                       String[] rows = new String[3];
                       rows[0]=rs.getString("ȸ����ȣ");
                       rows[1]=rs.getString("�̸�");
                       
                       CallableStatement cstmt = con.prepareCall("{call ������(?,?)}");
     		        	cstmt.registerOutParameter(1,Types.VARCHAR);
     		        	cstmt.setInt(2, Integer.parseInt(rs.getString("ȸ����ȣ")));
     		        	cstmt.executeQuery();
     		        	rows[2]=cstmt.getString(1)+"��";
     		        	
     		        			
                       number_dm.addRow(rows);
                       number_dm.isCellEditable(2,0);
     
                 	  }
                 	  
                 	  }
                    rs.close();
                    stmt.close();
                 }catch (SQLException e1) {
                    e1.printStackTrace();
                 }finally {
                    try {
                             
                    } catch (Exception e1) {
                       
                       e1.printStackTrace();
                    }
                 }
                     
                 number_panel_1.setVisible(false);
                 number_panel.setVisible(true);
        		
        		
        	}
        });
      number_1_del.setBounds(721, 613, 97, 45);
      number_panel_1.add(number_1_del);
      
      
      //pt��� �гη� �̵�
      JButton number_pt_add = new JButton("pt\uB4F1\uB85D");
      number_pt_add.setBackground(Color.WHITE);
      number_pt_add.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		number_panel_1.setVisible(false);
      		pt_Enroll_panel.setVisible(true);
      	}
      });
      
      
      number_pt_add.setFont(new Font("�������", Font.PLAIN, 19));
      number_pt_add.setBounds(721, 523, 97, 45);
      number_panel_1.add(number_pt_add);
      
      //�ⱸ�뿩 �гη� �̵�
      JButton number_rental_add = new JButton("\uAE30\uAD6C \uB300\uC5EC");
      number_rental_add.setBackground(Color.WHITE);
      number_rental_add.setFont(new Font("�������", Font.PLAIN, 19));
      number_rental_add.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		try {
      		DB_Connect();
      		CallableStatement cstmt = con.prepareCall("{call HEALTH_TOOL(?,?)}");
      		cstmt.setInt(1, Integer.parseInt(user_number));
      		cstmt.registerOutParameter(2, Types.INTEGER);
      		cstmt.executeQuery();
      		
      		textField_ex_num.setText(Integer.toString(cstmt.getInt(2))+"��");
      		cstmt.close();
      		con.close();
      		}
      		catch(SQLException e1) {e1.printStackTrace();}
      		
      		
      		number_panel_1.setVisible(false);
      		rental_add_panel.setVisible(true);
      		
      	}
      });
      
      
      number_rental_add.setBounds(721, 478, 116, 45);
      number_panel_1.add(number_rental_add);
      
      //��ǰ���� �г��̵�
      JButton number_ex_add = new JButton("\uC0C1\uD488 \uAD6C\uB9E4");
      number_ex_add.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			number_panel_1.setVisible(false);
			goods_purchase_panel.setVisible(true);
		}
	});
      
      number_ex_add.setBackground(Color.WHITE);
      number_ex_add.setFont(new Font("�������", Font.PLAIN, 19));
      number_ex_add.setBounds(721, 433, 116, 45);
      number_panel_1.add(number_ex_add);
      

      String tri_health []  = { "Ʈ���̳ʹ�ȣ ","�̸�"};
      DefaultTableModel tri_dm = new DefaultTableModel(tri_health,0);
      
      JTable tri_table = new JTable(tri_dm);
      JScrollPane tri_scrollPane = new JScrollPane(tri_table);
      tri_scrollPane.setEnabled(false);
      tri_scrollPane.setBounds(123, 83, 441, 280);
      tri_panel.add(tri_scrollPane);
      
      
      tri_table.addMouseListener(new MouseListener() {
  		
 

		@Override
  		public void mouseClicked(MouseEvent e) {
  			// TODO Auto-generated method stub
  			
  			  
  		}

		@Override
		public void mousePressed(MouseEvent e) { //Ʈ���̳� �̸� ����
			// TODO Auto-generated method stub
			int row = tri_table.getSelectedRow();
  			String data  = (String) tri_table.getValueAt(row,1);
  			trainer_name = data;
  			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
  	});
      
      
      //Ʈ���̳� �г� �̵�
      JButton tria_info = new JButton("\uD2B8\uB808\uC774\uB108\uC815\uBCF4");
      tria_info.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            main_info.setVisible(false);
            tri_panel.setVisible(true);
            

            
            try { //Ʈ���̳� ���
               DB_Connect();
               String query = "select Ʈ���̳ʹ�ȣ,�̸�,Ʈ���̳�.���Ը� from Ʈ���̳�,�ｺ�� where Ʈ���̳�.���Ը�=�ｺ��.���Ը�"; 
               Statement stmt = con.createStatement(); 
               ResultSet rs = stmt.executeQuery(query); 
               tri_dm.setNumRows(0);
               while(rs.next()) {
            	   if(rs.getString("���Ը�").equals(health_name)) {
                  String[] rows = new String[2];
                  rows[0]=rs.getString("Ʈ���̳ʹ�ȣ");
                  rows[1]=rs.getString("�̸�");
                  tri_dm.addRow(rows);
            	   }
               }
               rs.close();
               stmt.close();
            }catch (SQLException e1) {
               e1.printStackTrace();
            }finally {
               try {
                  
                  
               } catch (Exception e1) {
                  
                  e1.printStackTrace();
               }
            }
            
            
            
         }
      });
      

      tria_info.setBackground(Color.WHITE);
      tria_info.setFont(new Font("�������", Font.PLAIN, 13));
      tria_info.setBounds(287, 102, 124, 52);
      main_info.add(tria_info);
      
      
      //��ⱸ ���̺�
      String ex_header []  = {"�ⱸ��ȣ","�ⱸ��","�뿩����"};
      DefaultTableModel ex_gigu = new DefaultTableModel(ex_header,0);
      
      JTable table4 = new JTable(ex_gigu); //�ⱸ ��ȸ
      JScrollPane ex_scrollPane = new JScrollPane(table4);
      ex_scrollPane.setBounds(85, 44, 660, 400);
      ex_info_panel.add(ex_scrollPane);
      
      //��ⱸ �г� �̵�
      JButton ex_info = new JButton("\uC6B4\uB3D9\uAE30\uAD6C\uC815\uBCF4");
      
      ex_info.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            main_info.setVisible(false);
            ex_info_panel.setVisible(true);
            
            //��ⱸ ���
            
            try {
                DB_Connect();
                String query = "select �ⱸ��ȣ,�ⱸ��,���Ը�,�뿩���� from ��ⱸ "; 
                Statement stmt = con.createStatement(); 
                ResultSet rs = stmt.executeQuery(query); 
                ex_gigu.setNumRows(0);
                while(rs.next()) {
                	 if(rs.getString("���Ը�").equals(health_name)) {
                   String[] rows = new String[3];
                   rows[0]=rs.getString("�ⱸ��ȣ");
                   rows[1]=rs.getString("�ⱸ��");
                   rows[2]=rs.getString("�뿩����");
                   ex_gigu.addRow(rows);
                	 }
                }
                rs.close();
                stmt.close();
             }catch (SQLException e1) {
                e1.printStackTrace();
             }finally {
                try {    
                } catch (Exception e1) {       
                   e1.printStackTrace();
                }
             }
      
          }
       });
      ex_info.setBackground(Color.WHITE);
      ex_info.setFont(new Font("�������", Font.PLAIN, 13));
      ex_info.setBounds(459, 102, 124, 52);
      main_info.add(ex_info);
      
      
      
      
      //��ǰ����
      
      //��ǰ ���̺�
      String goods_header []  = {"��ǰ��ȣ","��ǰ�̸�","��ǰ ����","����"};
      DefaultTableModel goods = new DefaultTableModel(goods_header,0);
            
      
      JTable table6 = new JTable(goods);
      JScrollPane goods_scrollPane = new JScrollPane(table6);
      goods_scrollPane.setBounds(141, 84, 482, 295);
      goods_panel.add(goods_scrollPane);
      
      
      JButton goods_info = new JButton("\uC0C1\uD488\uC815\uBCF4");
      goods_info.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            main_info.setVisible(false);
            goods_panel.setVisible(true);
            
            try {  //��ǰ ���
                DB_Connect();
                String query = "select ��ǰ��ȣ,��ǰ�̸�,��ǰ����,����,���Ը� from ��ǰ"; 
                Statement stmt = con.createStatement(); 
                ResultSet rs = stmt.executeQuery(query); 
                goods.setNumRows(0);
                while(rs.next()) {
             	   if(rs.getString("���Ը�").equals(health_name)) {
                   String[] rows = new String[4];
                   rows[0]=rs.getString("��ǰ��ȣ");
                   rows[1]=rs.getString("��ǰ�̸�");
                   rows[2]=rs.getString("��ǰ����");
                   rows[3]=rs.getString("����");
                   goods.addRow(rows);
             	   }
                }
                rs.close();
                stmt.close();
             }catch (SQLException e1) {
                e1.printStackTrace();
             }finally {
                try {         
                } catch (Exception e1) {
                   
                   e1.printStackTrace();
                }
             }
          }
       });
           
            
      
      
      goods_info.setBackground(Color.WHITE);
      goods_info.setFont(new Font("�������", Font.PLAIN, 13));
      goods_info.setBounds(619, 102, 131, 52);
      main_info.add(goods_info);
      
      JLabel health_main = new JLabel("\uD5EC\uC2A4 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
      health_main.setFont(new Font("�������", Font.PLAIN, 36));
      health_main.setBounds(280, 32, 344, 45);
      main.add(health_main);
      
      table_6 = new JTable();
      table_6.setBounds(120, 106, 1, 1);
      main.add(table_6);
      
 
      
         
   
      //���̺� ������ ��ȸ��ư����
      JButton number_Lookup = new JButton("\uC870\uD68C");
      number_Lookup.setBackground(Color.WHITE);
      number_Lookup.setFont(new Font("�������", Font.PLAIN, 22));
      number_Lookup.setBounds(756, 36, 97, 45);
      number_panel.add(number_Lookup);
      
      
      JButton btnNewButton_1 = new JButton("\uB4A4\uB85C");
      btnNewButton_1.setFont(new Font("�������", Font.PLAIN, 18));
      btnNewButton_1.setBounds(696, 631, 97, 45);
      number_panel.add(btnNewButton_1);
      
      //ȸ���߰� �гη� �̵�
      JButton member_add = new JButton("\uCD94\uAC00");
      member_add.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			number_panel.setVisible(false);
			number_add_panel.setVisible(true);
		}
	});
      
      member_add.setBackground(Color.WHITE);
      member_add.setFont(new Font("�������", Font.PLAIN, 22));
      member_add.setBounds(756, 91, 97, 45);
      number_panel.add(member_add);


      //�ｺ�� ���̺� ����
  		
        
        
        JButton btnNewButton = new JButton("\uB098\uAC00\uAE30");
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		number_panel.setVisible(false);
        		main_info.setVisible(true);
        	}
        });
        
        btnNewButton.setFont(new Font("�������", Font.PLAIN, 19));
        btnNewButton.setBounds(46, 392, 97, 45);
        number_panel.add(btnNewButton);

      
        
      //ȸ�� ������ �����ư
      number_Lookup.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         
            number_panel.setVisible(false);
            number_panel_1.setVisible(true);
            
            
            int row = number_table_1.getSelectedRow();
	         String data = (String) number_table_1.getValueAt(row,1);
	      
			  try {  //ȸ�� ������
			         DB_Connect();
			         
			         String sql = "select ȸ��.ȸ����ȣ,�̸�,����ó,�ּ�,������,Ű,����,����,���ݾ�,���,���ϸ��� from ȸ��,���ȸ�� where ���ȸ��.ȸ����ȣ=ȸ��.ȸ����ȣ";
			         Statement st = con.createStatement();
			         ResultSet rs = st.executeQuery(sql);
			         
			         while(rs.next()) { 
			        	 if(rs.getString("�̸�").equals(data)){
			        		  textField.setText(rs.getString("�̸�"));
			                  textField_1.setText(rs.getString("����ó"));
			                  textField_2.setText(rs.getString("�ּ�"));
			                  textField_7.setText(rs.getString("������"));
			                  textField_8.setText(rs.getString("Ű"));
			                  textField_9.setText(rs.getString("����"));
			                  textField_10.setText(rs.getString("����"));
			                  textField_11.setText(rs.getString("���ݾ�"));
			                  textField_12.setText(rs.getString("���"));
			                  textField_13.setText(rs.getString("���ϸ���"));
			                  
			                  user_number=rs.getString("ȸ����ȣ");
			                  System.out.println(user_number);
			                  
			        	    
			        		 	 }
			         }
			         rs.close();
			         st.close();
			        }catch (SQLException e1) {
			         e1.printStackTrace();
			      }finally {
			         try {
			            
			            
			         } catch (Exception e1) {
			            
			            e1.printStackTrace();
			         }
			      }
				
			}
		});
          
            
 
      //�ڷΰ��� ��ư
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            number_panel.setVisible(false);
            main_info.setVisible(true);
         }
      });
      

      String pt_header []  = {"ȸ��","����"};
      DefaultTableModel pt_user = new DefaultTableModel(pt_header,0);
      
      JTable table3 = new JTable(pt_user);
      JScrollPane pt_scrollPane = new JScrollPane(table3);
      pt_scrollPane.setBounds(194, 55, 423, 371);
      tri_pt_panel.add(pt_scrollPane);
      
      //Ʈ���̳� pt��ư
      JButton tri_pt_info = new JButton("pt\uC815\uBCF4");
      tri_pt_info.setBackground(Color.WHITE);
      tri_pt_info.setFont(new Font("�������", Font.PLAIN, 18));
      tri_pt_info.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            tri_panel.setVisible(false);
            tri_pt_panel.setVisible(true);
            
            //pt���̺�
           
            try {  //Ʈ���̳� pt ����
                DB_Connect();
                String query = "select ȸ��.�̸� as ȸ���̸�,ȸ��.���� as ȸ������,Ʈ���̳�.�̸� as Ʈ���̳��̸� from PT,ȸ��,Ʈ���̳� where PT.ȸ����ȣ=ȸ��.ȸ����ȣ and PT.Ʈ���̳ʹ�ȣ=Ʈ���̳�.Ʈ���̳ʹ�ȣ"; //db���̺��� ����ҷ�����
                Statement stmt = con.createStatement(); 
                ResultSet rs = stmt.executeQuery(query); 
                pt_user.setNumRows(0);
                
                
                while(rs.next()) {
             	   if(rs.getString("Ʈ���̳��̸�").equals(trainer_name)) {
                   String[] rows = new String[2];
                   
                   rows[0]=rs.getString("ȸ���̸�");
                   rows[1]=rs.getString("ȸ������");
                   pt_user.addRow(rows);
             	   }
                }
                rs.close();
                stmt.close();
             }catch (SQLException e1) {
                e1.printStackTrace();
             }finally {
                try {   
                } catch (Exception e1) {
                   
                   e1.printStackTrace();
                }
             }
          }
       });
      
      tri_pt_info.setBounds(599, 176, 97, 45);
      tri_panel.add(tri_pt_info);
      
      JButton back_btn = new JButton("\uB098\uAC00\uAE30");
      back_btn.setBackground(Color.WHITE);
      back_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            tri_panel.setVisible(false);
            main_info.setVisible(true);
         }
      });
      back_btn.setFont(new Font("�������", Font.PLAIN, 18));
      back_btn.setBounds(40, 414, 97, 45);
      tri_panel.add(back_btn);
  
      
      
    
      //Ʈ���̳� ȸ�� ��ȸ
      JLabel tri_name = new JLabel("\uC774\uB984");
      tri_name.setFont(new Font("�������", Font.PLAIN, 18));
      tri_name.setBounds(193, 124, 76, 25);
      tri_info_panel.add(tri_name);
      
      
      
      JLabel tri_add = new JLabel("��ȭ��ȣ");
      tri_add.setFont(new Font("�������", Font.PLAIN, 18));
      tri_add.setBounds(193, 173, 86, 26);
      tri_info_panel.add(tri_add);
      
      
      
      JLabel tri_address = new JLabel("\uC8FC\uC18C");
      tri_address.setFont(new Font("�������", Font.PLAIN, 18));
      tri_address.setBounds(193, 226, 86, 26);
      tri_info_panel.add(tri_address);
      

      JLabel tri_age = new JLabel("\uB098\uC774");
      tri_age.setFont(new Font("�������", Font.PLAIN, 18));
      tri_age.setBounds(193, 275, 76, 25);
      tri_info_panel.add(tri_age);
      
      
      
      JLabel tri_grade = new JLabel("\uACBD\uB825");
      tri_grade.setFont(new Font("�������", Font.PLAIN, 18));
      tri_grade.setBounds(193, 322, 86, 26);
      tri_info_panel.add(tri_grade);
      
      
      
      JLabel tri_sung = new JLabel("\uC131\uBCC4");
      tri_sung.setFont(new Font("�������", Font.PLAIN, 18));
      tri_sung.setBounds(193, 373, 86, 26);
      tri_info_panel.add(tri_sung);
      

      JLabel tri_ipsa = new JLabel("\uB4F1\uAE09");
      tri_ipsa.setFont(new Font("�������", Font.PLAIN, 18));
      tri_ipsa.setBounds(193, 464, 76, 25);
      tri_info_panel.add(tri_ipsa);
      
      
      
      JLabel tri_emdrmq = new JLabel("\uC785\uC0AC\uC77C");
      tri_emdrmq.setFont(new Font("�������", Font.PLAIN, 18));
      tri_emdrmq.setBounds(193, 413, 86, 26);
      tri_info_panel.add(tri_emdrmq);
      
      
      
      JLabel tri_fee = new JLabel("\uC218\uC5C5\uB8CC");
      tri_fee.setFont(new Font("�������", Font.PLAIN, 18));
      tri_fee.setBounds(193, 508, 86, 26);
      tri_info_panel.add(tri_fee);
      
      tri_name_input = new JTextField();
      tri_name_input.setBounds(281, 122, 147, 35);
      tri_info_panel.add(tri_name_input);
      tri_name_input.setColumns(10);
      
      
      
      tri_number_input = new JTextField();
      tri_number_input.setBounds(281, 172, 147, 35);
      tri_info_panel.add(tri_number_input);
      tri_number_input.setColumns(10);
      
      
      
      tri_adress_input = new JTextField();
      tri_adress_input.setBounds(281, 225, 200, 35);
      tri_info_panel.add(tri_adress_input);
      tri_adress_input.setColumns(10);
   

      JButton tri_lookup = new JButton("\uC870\uD68C");
      tri_lookup.setBackground(Color.WHITE);
      tri_lookup.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
            tri_panel.setVisible(false);
            tri_info_panel.setVisible(true);

            int row = tri_table.getSelectedRow();
	         String data = (String) tri_table.getValueAt(row,1);
	      
			  try {  //Ʈ���̳� ������
			         DB_Connect();
			         
			         String sql = "select Ʈ���̳�.Ʈ���̳ʹ�ȣ,�̸�,����ó,�ּ�,����,���,����,�Ի���,���,������ from Ʈ���̳�,���� where Ʈ���̳�.Ʈ���̳ʹ�ȣ=����.Ʈ���̳ʹ�ȣ";
			         Statement st = con.createStatement();
			         ResultSet rs = st.executeQuery(sql);
			         
			         while(rs.next()) {
			        	 if(rs.getString("�̸�").equals(data)){
			        		 trainer_number=rs.getString("Ʈ���̳ʹ�ȣ");
			        		  tri_name_input.setText(rs.getString("�̸�"));
			                  tri_number_input.setText(rs.getString("����ó"));
			                  tri_adress_input.setText(rs.getString("�ּ�"));
			                  textField_18.setText(rs.getString("����"));
			                  textField_19.setText(rs.getString("���"));
			                  textField_20.setText(rs.getString("����"));
			                  textField_21.setText(rs.getString("�Ի���"));
			                  textField_22.setText(rs.getString("���"));
			                  textField_23.setText(rs.getString("������"));
			                  
			                  
			        		 	 }
			         }
			         rs.close();
			         st.close();
			        }catch (SQLException e1) {
			         e1.printStackTrace();
			      }finally {
			         try {
			            
			            
			         } catch (Exception e1) {
			            
			            e1.printStackTrace();
			         }
			      }
				
			}
		});
      		
      tri_lookup.setFont(new Font("�������", Font.PLAIN, 18));
      tri_lookup.setBounds(599, 125, 97, 45);
      tri_panel.add(tri_lookup);
      
      /* Ʈ���̳� �߰� ��ư
      JButton tri_add_button = new JButton("\uCD94\uAC00");
      tri_add_button.setFont(new Font("�������", Font.PLAIN, 18));
      tri_add_button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      tri_add_button.setBackground(Color.WHITE);
      tri_add_button.setBounds(597, 231, 97, 45);
      tri_panel.add(tri_add_button);
      */
      
      //Ʈ���̳� ���� �ڷι�ư
      JButton tri_info_back_button = new JButton("\uB098\uAC00\uAE30");
      tri_info_back_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            tri_info_panel.setVisible(false);
            tri_panel.setVisible(true);
         }
      });
      
      
      //�ڷΰ��� ��ư
      
      JButton pt_info_back_button = new JButton("\uB098\uAC00\uAE30");
      pt_info_back_button.setBackground(Color.WHITE);
      pt_info_back_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            tri_pt_panel.setVisible(false);
            tri_panel.setVisible(true);
         }
      });
        
      pt_info_back_button.setFont(new Font("�������", Font.PLAIN, 19));
      pt_info_back_button.setBounds(42, 448, 101,45);
      tri_pt_panel.add(pt_info_back_button);
      

      //ptȸ�� �̸�,�Ĵ�,�����Ȳ
      pt_info_name_input = new JTextField();
      pt_info_name_input.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_name_input.setBounds(245, 95, 215, 34);
      pt_member_info.add(pt_info_name_input);
      pt_info_name_input.setColumns(10);
      
      
      
      //ptȸ�� �Ĵ�
      pt_info_diet_input = new JTextField();
      pt_info_diet_input.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_diet_input.setBounds(245, 162, 215, 157);
      pt_member_info.add(pt_info_diet_input);
      pt_info_diet_input.setColumns(10);
      
      
      
      //ptȸ�� �����Ȳ
      pt_info_Progress_input = new JTextField();
      pt_info_Progress_input.setFont(new Font("����", Font.PLAIN, 18));
      pt_info_Progress_input.setBounds(245, 337, 215, 48);
      pt_member_info.add(pt_info_Progress_input);
      pt_info_Progress_input.setColumns(10);
      
      
      
      //ptȸ�� �̸�
      JLabel pt_info_name = new JLabel("\uC774\uB984");
      pt_info_name.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_name.setBounds(153, 104, 90, 35);
      pt_member_info.add(pt_info_name);
      
      
      
      //ptȸ�� �Ĵ�
      JLabel pt_info_diet = new JLabel("\uC2DD\uB2E8");
      pt_info_diet.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_diet.setBounds(153, 209, 90, 35);
      pt_member_info.add(pt_info_diet);
      
      
      //ptȸ�� �����Ȳ
      JLabel pt_info_Progress = new JLabel("\uC9C4\uD589\uC0C1\uD669");
      pt_info_Progress.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_Progress.setBounds(153, 350, 90, 35);
      pt_member_info.add(pt_info_Progress);
      
      
      JButton back_button = new JButton("\uB098\uAC00\uAE30");
      back_button.setBackground(Color.WHITE);
      back_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            pt_member_info.setVisible(false);
            tri_pt_panel.setVisible(true);
         }
      });
      
      
      back_button.setFont(new Font("�������", Font.PLAIN, 18));
      back_button.setBounds(70, 551, 97, 45);
      pt_member_info.add(back_button);
      
      
      //pt ȸ������
      JButton pt_info_su = new JButton("\uC218\uC815");
      pt_info_su.setFont(new Font("�������", Font.PLAIN, 18));
      pt_info_su.setBackground(Color.WHITE);
      pt_info_su.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      pt_info_su.setBounds(510, 131, 97, 45);
      pt_member_info.add(pt_info_su);
      

      //��ⱸ ���̺� �����ϴµ�
      JTable ex_info_tabel = new JTable();
      ex_info_tabel.setBounds(154, 391, 387, -303);
      ex_info_panel.add(ex_info_tabel);
      

      
      //�ⱸ �뿩 ��Ȳ ���̺�
      String rental_header []  = {"�뿩����","ȸ���̸�","�ⱸ��ȣ"};
      DefaultTableModel ex_rental = new DefaultTableModel(rental_header,0);
    
            
      
      JTable table5 = new JTable(ex_rental);  //�뿩��Ȳ
      JScrollPane rental_scrollPane = new JScrollPane(table5);
      rental_scrollPane.setBounds(85, 44, 660, 400);
      ex_rental_panel.add(rental_scrollPane);

      
      //�뿩��Ȳ��ư
      JButton ex_rental_button = new JButton("\uB300\uC5EC\uD604\uD669");
      ex_rental_button.setBackground(Color.WHITE);
      ex_rental_button.addActionListener(new ActionListener() {
         
         public void actionPerformed(ActionEvent e) {
            ex_info_panel.setVisible(false);
            ex_rental_panel.setVisible(true);
            
            int row =  table4.getSelectedRow();
            TableModel data = table4.getModel();
            
            try {  
                DB_Connect();
                String query = "select �뿩����,�̸�,�뿩.���Ը�, �뿩.�ⱸ��ȣ from �뿩,ȸ�� where ȸ��.ȸ����ȣ=�뿩.ȸ����ȣ";
                Statement stmt = con.createStatement(); 
                ResultSet rs = stmt.executeQuery(query); 
                ex_rental.setNumRows(0);
                while(rs.next()) {
             	   if(rs.getString("���Ը�").equals(health_name)) {
                   String[] rows = new String[3];
                   rows[0]=rs.getString("�뿩����");
                   rows[1]=rs.getString("�̸�");
                   rows[2]=rs.getString("�ⱸ��ȣ");
                   ex_rental.addRow(rows);
             	   }
                }
                rs.close();
                stmt.close();
             }catch (SQLException e1) {
                e1.printStackTrace();
             }finally {
                try { 
                } catch (Exception e1) {
                   
                   e1.printStackTrace();
                }
             }
            
            ex_enroll_panel.setVisible(false);
			 ex_info.setVisible(true);
            
          }
       });
      ex_rental_button.setFont(new Font("�������", Font.PLAIN, 21));
      ex_rental_button.setBounds(756, 121, 121, 40);
      ex_info_panel.add(ex_rental_button);
      
      

      //�ڷΰ��� ��ư
      JButton ex_info_back_button = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      ex_info_back_button.setBackground(Color.WHITE);
      ex_info_back_button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ex_info_panel.setVisible(false);
            main_info.setVisible(true);
            
         }
      });
      
      
      ex_info_back_button.setFont(new Font("�������", Font.PLAIN, 21));
      ex_info_back_button.setBounds(756, 188, 121, 44);
      ex_info_panel.add(ex_info_back_button);
      
      JButton rental_lookup = new JButton("�߰�"); //�ⱸ �߰��߰�
      rental_lookup.setBackground(Color.WHITE);
      rental_lookup.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		
      		ex_info_panel.setVisible(false);
      		ex_enroll_panel.setVisible(true);
      		
      		
      		 
      	}
      });
      rental_lookup.setFont(new Font("�������", Font.PLAIN, 21));
      rental_lookup.setBounds(757, 64, 120, 34);
      ex_info_panel.add(rental_lookup);
      

         //�ڷΰ���
         JButton rental_back_button = new JButton("\uB4A4\uB85C\uAC00\uAE30");
         rental_back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ex_rental_panel.setVisible(false);
               ex_info_panel.setVisible(true);
            }
         });
         
         
         rental_back_button.setFont(new Font("�������", Font.PLAIN, 21));
         rental_back_button.setBackground(Color.WHITE);
         rental_back_button.setBounds(740, 148, 100, 60);
         ex_rental_panel.add(rental_back_button);
       
         
         JButton goods_back_btn = new JButton("\uB098\uAC00\uAE30");
         goods_back_btn.setBackground(Color.WHITE);
         goods_back_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               goods_panel.setVisible(false);
               main_info.setVisible(true);
            }
         });
         
         
         goods_back_btn.setFont(new Font("�������", Font.PLAIN, 21));
         goods_back_btn.setBounds(48, 417, 97, 50);
         goods_panel.add(goods_back_btn);
      
        

         //�Ѿ� 
         JLabel ex_all_price = new JLabel("\uCD1D\uC561");
         ex_all_price.setFont(new Font("�������", Font.PLAIN, 18));
         ex_all_price.setBounds(273, 500, 66, 22);
         goods_add_panel.add(ex_all_price);
         //
        
         //�Ѿ� text 
         textField_188 = new JTextField();
         textField_188.setBounds(351, 500, 130, 35);
         goods_add_panel.add(textField_188);
         textField_188.setColumns(10);

         String add_header []  = {"��������","ȸ���̸�","��ǰ�̸�","���ż���"};
         DefaultTableModel byu_goods = new DefaultTableModel(add_header,0);
                
          
          JTable table7 = new JTable(byu_goods);
          JScrollPane asdaf_scrollPane = new JScrollPane(table7);
          asdaf_scrollPane.setBounds(85, 44, 660, 400);
          goods_add_panel.add(asdaf_scrollPane);
         
         
         //������ �г��̵�
         JButton goods_add = new JButton("\uAD6C\uB9E4\uC790");
         goods_add.setBackground(Color.WHITE);
         goods_add.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
            
               goods_panel.setVisible(false);
               goods_add_panel.setVisible(true);
    
               try {  //��ǰ ������ ���
                   DB_Connect();
                   String query = " select ��������,�̸�,��ǰ�̸�,���ż���,����.���Ը� as ���Ը� from ����,ȸ��,��ǰ where ����.ȸ����ȣ=ȸ��.ȸ����ȣ and ��ǰ.��ǰ��ȣ=����.���Ź�ȣ and ����.���Ը�=��ǰ.���Ը�"; //db���̺��� ����ҷ�����
                   Statement stmt = con.createStatement(); 
                   ResultSet rs = stmt.executeQuery(query); 
                   byu_goods.setNumRows(0);
                   while(rs.next()) {
                	   
                	   if(rs.getString("���Ը�").equals(health_name)) {
                      String[] rows = new String[4];
                      rows[0]=rs.getString("��������");
                      rows[1]=rs.getString("�̸�");
                      rows[2]=rs.getString("��ǰ�̸�");
                      rows[3]=rs.getString("���ż���");
                      byu_goods.addRow(rows);
                      
                      
                      CallableStatement cstmt = con.prepareCall("{call �����Ѿ�(?,?)}");
			        	cstmt.setString(1,health_name);
			        	cstmt.registerOutParameter(2, Types.INTEGER);
			        	cstmt.executeQuery();
			        	textField_188.setText(Integer.toString(cstmt.getInt(2))+"��");
			        	
                      
                	   }
                   }
                   rs.close();
                   stmt.close();
                }catch (SQLException e1) {
                   e1.printStackTrace();
                }finally {
                   try {
                      
                      
                   } catch (Exception e1) {
                      
                      e1.printStackTrace();
                   }
                }
             }
          });
        
         
         JButton add_back = new JButton("\uB098\uAC00\uAE30");
         add_back.setBackground(Color.WHITE);
         add_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               goods_add_panel.setVisible(false);
               goods_panel.setVisible(true);
            }
         });
         
         
         
         add_back.setFont(new Font("�������", Font.PLAIN, 18));
         add_back.setBounds(76, 500, 97, 45);
         goods_add_panel.add(add_back);
         

         JLabel lblNewLabel_11 = new JLabel("\uCD1D \uB9E4\uCD9C\uC561");
         lblNewLabel_11.setFont(new Font("�������", Font.PLAIN, 18));
         lblNewLabel_11.setBounds(251, 350, 83, 25);
         goods_add_panel.add(lblNewLabel_11);
         
         JScrollPane add_scroll = new JScrollPane();
         add_scroll.setBounds(569, 43, -457, 459);
         
      

         goods_add.setFont(new Font("�������", Font.PLAIN, 21));
         goods_add.setBounds(650, 116, 97, 45);
         goods_panel.add(goods_add);
         
         
         
         JButton btnNewButton_4 = new JButton("\uC0C1\uD488\uC8FC\uBB38");
         btnNewButton_4.setBackground(Color.WHITE);
         btnNewButton_4.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_4.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		goods_panel.setVisible(false);
         		goods_order_panel.setVisible(true);
         	}
         });
         btnNewButton_4.setBounds(650, 165, 109, 45);
         goods_panel.add(btnNewButton_4);
         
         

         JLabel pt_tri_name = new JLabel("\uD2B8\uB808\uC774\uB108 \uC774\uB984");
         pt_tri_name.setFont(new Font("�������", Font.PLAIN, 18));
         pt_tri_name.setBounds(254, 130, 116, 25);
         pt_add_panel.add(pt_tri_name);
         
         
         JLabel pt_number_name = new JLabel("\uD68C\uC6D0 \uC774\uB984");
         pt_number_name.setFont(new Font("�������", Font.PLAIN, 18));
         pt_number_name.setBounds(287, 188, 94, 35);
         pt_add_panel.add(pt_number_name);
         
         textField_14 = new JTextField();
         textField_14.setBounds(373, 126, 129, 35);
         pt_add_panel.add(textField_14);
         textField_14.setColumns(10);
         
         textField_15 = new JTextField();
         textField_15.setBounds(373, 189, 129, 35);
         pt_add_panel.add(textField_15);
         textField_15.setColumns(10);
         
         
         //��ⱸ �뿩
         JButton ex_add_button = new JButton("\uB4F1\uB85D");
         ex_add_button.setBackground(Color.WHITE);
         ex_add_button.setFont(new Font("�������", Font.PLAIN, 18));
         ex_add_button.setBounds(543, 152, 97, 45);
         ex_add_panel.add(ex_add_button);
         

         JLabel ex_nember_name = new JLabel("\uD68C\uC6D0 \uC774\uB984");
         ex_nember_name.setFont(new Font("�������", Font.PLAIN, 18));
         ex_nember_name.setBounds(287, 130, 81, 25);
         ex_add_panel.add(ex_nember_name);
         
         
         JLabel ex_name = new JLabel("\uB300\uC5EC \uC77C\uC790");
         ex_name.setFont(new Font("�������", Font.PLAIN, 18));
         ex_name.setBounds(287, 251, 94, 35);
         ex_add_panel.add(ex_name);
         

         JLabel ex_year = new JLabel("\uAE30\uAD6C \uC774\uB984");
         ex_year.setFont(new Font("�������", Font.PLAIN, 18));
         ex_year.setBounds(287, 188, 94, 35);
         ex_add_panel.add(ex_year);
         
         textField_14 = new JTextField();
         textField_14.setBounds(373, 126, 129, 35);
         ex_add_panel.add(textField_14);
         textField_14.setColumns(10);
         
         textField_15 = new JTextField();
         textField_15.setBounds(373, 189, 129, 35);
         ex_add_panel.add(textField_15);
         textField_15.setColumns(10);
         
         textField_16 = new JTextField();
         textField_16.setBounds(372, 259, 130, 35);
         ex_add_panel.add(textField_16);
         textField_16.setColumns(10);


         //��ǰ����
         JLabel goods_name = new JLabel("\uC0C1\uD488 \uC774\uB984");
         goods_name.setFont(new Font("�������", Font.PLAIN, 18));
         goods_name.setBounds(287, 130, 81, 25);
         goods_panel_add.add(goods_name);
         
         
         JLabel goods_number_name = new JLabel("\uD68C\uC6D0 \uC774\uB984");
         goods_number_name.setFont(new Font("�������", Font.PLAIN, 18));
         goods_number_name.setBounds(287, 188, 94, 35);
         goods_panel_add.add(goods_number_name);
         

         JLabel goods_num = new JLabel("\uC218\uB7C9");
         goods_num.setFont(new Font("�������", Font.PLAIN, 18));
         goods_num.setBounds(287, 258, 94, 35);
         goods_panel_add.add(goods_num);
         

         JLabel goods_year = new JLabel("\uAD6C\uB9E4 \uC77C\uC790");
         goods_year.setFont(new Font("�������", Font.PLAIN, 18));
         goods_year.setBounds(287, 324, 94, 35);
         goods_panel_add.add(goods_year);
  
         
         JButton goods_add_button = new JButton("\uB4F1\uB85D");
         goods_add_button.setBackground(Color.WHITE);
         goods_add_button.setFont(new Font("�������", Font.PLAIN, 18));
         goods_add_button.setBounds(543, 152, 97, 45);
         goods_panel_add.add(goods_add_button);
   
         
         textField_14 = new JTextField();
         textField_14.setBounds(373, 126, 129, 35);
         goods_panel_add.add(textField_14);
         textField_14.setColumns(10);
         
         textField_15 = new JTextField();
         textField_15.setBounds(373, 189, 129, 35);
         goods_panel_add.add(textField_15);
         textField_15.setColumns(10);
         
         textField_16 = new JTextField();
         textField_16.setBounds(372, 259, 130, 35);
         goods_panel_add.add(textField_16);
         textField_16.setColumns(10);
         
         textField_17 = new JTextField();
         textField_17.setBounds(373, 325, 129,35);
         goods_panel_add.add(textField_17);
         textField_17.setColumns(10);
         

         //Ʈ���̳� ����
         tri_info_back_button.setFont(new Font("�������", Font.PLAIN, 21));
         tri_info_back_button.setBackground(Color.WHITE);
         tri_info_back_button.setBounds(32, 590, 97, 45);
         tri_info_panel.add(tri_info_back_button);
         
         
         JButton tri_info_del = new JButton("\uC0AD\uC81C");
         tri_info_del.setBackground(Color.WHITE);
         
         tri_info_del.addActionListener(new ActionListener() {  //Ʈ���̳� ����
          	public void actionPerformed(ActionEvent e) {
          		try {
      		         DB_Connect();
      		         String query = "delete from Ʈ���̳� where Ʈ���̳�.Ʈ���̳ʹ�ȣ="+"\'"+ trainer_number +"\'"; //db���̺��� ����ҷ�����
      		         Statement stmt = con.createStatement(); //statement����
      		         stmt.execute(query);
      		         stmt.close();
      		      }catch (SQLException e1) {
      		    	JOptionPane.showMessageDialog(null,"��������!");
      		         e1.printStackTrace();
      		      }finally {
      		         try {
      		            
      		         } catch (Exception e1) {     
      		            e1.printStackTrace();
      		         }
      		      }
      			 
      			 
      			//Ʈ���̳� ��ȸ ���̺� ����
      				
          		try {
                    DB_Connect();
                    String query = "select Ʈ���̳ʹ�ȣ,�̸�,Ʈ���̳�.���Ը� from Ʈ���̳�,�ｺ�� where Ʈ���̳�.���Ը�=�ｺ��.���Ը�"; 
                    Statement stmt = con.createStatement(); 
                    PreparedStatement ps = con.prepareStatement(query); 
                    
                    ResultSet rs = ps.executeQuery(); 
                    tri_dm.setNumRows(0);
                    while(rs.next()) {
                 	   if(rs.getString("���Ը�").equals(health_name)) {
                       String[] rows = new String[2];
                       rows[0]=rs.getString("Ʈ���̳ʹ�ȣ");
                       rows[1]=rs.getString("�̸�");
                       tri_dm.addRow(rows);
                 	   }
                    }
                    rs.close();
                    stmt.close();
                 }catch (SQLException e1) {
                    e1.printStackTrace();
                 }finally {
                    try {
                       
                       
                    } catch (Exception e1) {
                       
                       e1.printStackTrace();
                    }
                 }
                    
                   
                    tri_info_panel.setVisible(false);
                    tri_panel.setVisible(true);
           		
          		
          	}
          });
         tri_info_del.setFont(new Font("�������", Font.PLAIN, 18));
         tri_info_del.setBounds(530, 199, 97, 45);
         tri_info_panel.add(tri_info_del);
         
         //Ʈ���̳� ���� ����
         JButton tri_info_su = new JButton("\uC218\uC815");
         tri_info_su.setBackground(Color.WHITE);
         tri_info_su.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		 try{
             		 DB_Connect();
             		 
             		 System.out.println(user_number);
             		PreparedStatement pstmt =null;  //Ʈ���̳� ���� ����
             	 	String sql = "update Ʈ���̳� set �̸�=?, ����ó=?,�ּ�=?,����=?,���=?,����=? where Ʈ���̳�.Ʈ���̳ʹ�ȣ="+"\'"+trainer_number+"\'";
             	 	pstmt=con.prepareStatement(sql);
             	 	pstmt.setString(1,tri_name_input.getText());
             	 	pstmt.setString(2,tri_number_input.getText());
             	 	pstmt.setString(3,tri_adress_input.getText());
             	 	pstmt.setString(4,textField_18.getText());
             	 	pstmt.setString(5,textField_19.getText());
             	 	pstmt.setString(6,textField_20.getText());

             	 	int a=pstmt.executeUpdate();
             	 	System.out.println(a);
         		
         		 }catch (SQLException e1) {
         			JOptionPane.showMessageDialog(null,"��������!");
        		         e1.printStackTrace();
       		      }finally {
       		         try {       
       		         } catch (Exception e1) {
       		            
       		            e1.printStackTrace();
       		         }
       		      }
         		 
         		try { //Ʈ���̳� ���
                    DB_Connect();
                    String query = "select Ʈ���̳ʹ�ȣ,�̸�,Ʈ���̳�.���Ը� from Ʈ���̳�,�ｺ�� where Ʈ���̳�.���Ը�=�ｺ��.���Ը�"; 
                    Statement stmt = con.createStatement(); 
                    ResultSet rs = stmt.executeQuery(query); 
                    tri_dm.setNumRows(0);
                    while(rs.next()) {
                 	   if(rs.getString("���Ը�").equals(health_name)) {
                       String[] rows = new String[2];
                       rows[0]=rs.getString("Ʈ���̳ʹ�ȣ");
                       rows[1]=rs.getString("�̸�");
                       tri_dm.addRow(rows);
                 	   }
                    }
                    rs.close();
                    stmt.close();
                 }catch (SQLException e1) {
                    e1.printStackTrace();
                 }finally {
                    try {
                       
                       
                    } catch (Exception e1) {
                       
                       e1.printStackTrace();
                    }
                 }

          	  tri_info_panel.setVisible(false);
              tri_panel.setVisible(true);
         		 
         	}
         });
         
         tri_info_su.setFont(new Font("�������", Font.PLAIN, 18));
         tri_info_su.setBounds(530, 245, 97, 45);
         tri_info_panel.add(tri_info_su);
         
         textField_18 = new JTextField();
         textField_18.setBounds(281, 280, 147, 35);
         tri_info_panel.add(textField_18);
         textField_18.setColumns(10);
         
         textField_19 = new JTextField();
         textField_19.setBounds(281, 328, 147, 35);
         tri_info_panel.add(textField_19);
         textField_19.setColumns(10);
         
         textField_20 = new JTextField();
         textField_20.setBounds(281, 370, 147, 35);
         tri_info_panel.add(textField_20);
         textField_20.setColumns(10);
         
         textField_21 = new JTextField();
         textField_21.setBounds(281, 410, 147, 35);
         tri_info_panel.add(textField_21);
         textField_21.setColumns(10);
         
         textField_22 = new JTextField();
         textField_22.setBounds(281, 459, 147, 35);
         tri_info_panel.add(textField_22);
         textField_22.setColumns(10);
         
         textField_23 = new JTextField();
         textField_23.setBounds(281, 505, 147, 35);
         tri_info_panel.add(textField_23);
         textField_23.setColumns(10);
         
         
         //ȸ�� �߰� �г� ����
         //ȸ����ȣ
         JLabel add_number = new JLabel("\uD68C\uC6D0\uC774\uB984");
         add_number.setFont(new Font("�������", Font.PLAIN, 18));
         add_number.setBounds(295, 41, 57, 25);
         number_add_panel.add(add_number);
         
         
         //ȸ���̸�
         JLabel add_number_name = new JLabel("\uC774\uB984");
         add_number_name.setFont(new Font("�������", Font.PLAIN, 18));
         add_number_name.setBounds(295, 103, 71, 35);
         number_add_panel.add(add_number_name);
         
         
         //����ó
         JLabel add_phonenumber = new JLabel("\uC5F0\uB77D\uCC98");
         add_phonenumber.setFont(new Font("�������", Font.PLAIN, 18));
         add_phonenumber.setBounds(295, 178, 77, 25);
         number_add_panel.add(add_phonenumber);
         
         //�ּ� 
         JLabel add_address = new JLabel("\uC8FC\uC18C");
         add_address.setFont(new Font("�������", Font.PLAIN, 18));
         add_address.setBounds(295, 309, 77, 25);
         number_add_panel.add(add_address);
         
         //Ű
         JLabel add_key = new JLabel("\uD0A4");
         add_key .setFont(new Font("�������", Font.PLAIN, 18));
         add_key .setBounds(295, 240, 57, 33);
         number_add_panel.add(add_key );
         
         
         //ü��
         JLabel add_weight = new JLabel("\uBAB8\uBB34\uAC8C");
         add_weight.setFont(new Font("�������", Font.PLAIN, 18));
         add_weight.setBounds(295, 368, 57, 15);
         number_add_panel.add(add_weight);
         
         //���� 
         JLabel add_age = new JLabel("\uB098\uC774");
         add_age .setFont(new Font("�������", Font.PLAIN, 18));
         add_age .setBounds(295, 428, 75, 25);
         number_add_panel.add(add_age );
         
         
         //����
         JLabel add_tjdquf = new JLabel("\uC131\uBCC4");
         add_tjdquf .setFont(new Font("�������", Font.PLAIN, 18));
         add_tjdquf .setBounds(291, 486, 75, 25);
         number_add_panel.add(add_tjdquf );
         
       //��ϴ�
         JLabel add_month = new JLabel("��� ��");
         add_month .setFont(new Font("�������", Font.PLAIN, 18));
         add_month .setBounds(291, 540, 75, 25);
         number_add_panel.add(add_month);
         
         //ȸ����ȣ �Է�
         textField_26 = new JTextField();
         textField_26.setFont(new Font("�������", Font.PLAIN, 16));
         textField_26.setBounds(378, 36, 125, 35);
         number_add_panel.add(textField_26);
         textField_26.setColumns(10);
         
       //ȸ���̸�  �Է�
         textField_34 = new JTextField();
         textField_34.setFont(new Font("�������", Font.PLAIN, 16));
         textField_34.setBounds(378, 103, 125, 35);
         number_add_panel.add(textField_34);
         textField_34.setColumns(10);
         
         //����ó �Է�
         textField_35 = new JTextField();
         textField_35.setFont(new Font("�������", Font.PLAIN, 16));
         textField_35.setBounds(382, 173, 379, 35);
         number_add_panel.add(textField_35);
         textField_35.setColumns(10);
         
         //�ּ� �Է�
         textField_36 = new JTextField();
         textField_36.setFont(new Font("�������", Font.PLAIN, 16));
         textField_36.setBounds(381, 239, 125, 35);
         number_add_panel.add(textField_36);
         textField_36.setColumns(10);
         
         //Ű �Է�
         textField_37 = new JTextField();
         textField_37.setFont(new Font("�������", Font.PLAIN, 16));
         textField_37.setBounds(384, 304, 122, 35);
         number_add_panel.add(textField_37);
         textField_37.setColumns(10);
         
         //������ �Է�
         textField_38 = new JTextField();
         textField_38.setFont(new Font("�������", Font.PLAIN, 16));
         textField_38.setBounds(381, 359, 125, 35);
         number_add_panel.add(textField_38);
         textField_38.setColumns(10);
         
         //���� �Է� 
         textField_39 = new JTextField();
         textField_39.setFont(new Font("�������", Font.PLAIN, 16));
         textField_39.setBounds(381, 424, 125, 35);
         number_add_panel.add(textField_39);
         textField_39.setColumns(10);
         
         //���� 
         textField_40 = new JTextField();
         textField_40.setFont(new Font("�������", Font.PLAIN, 16));
         textField_40.setBounds(381, 481, 125, 35);
         number_add_panel.add(textField_40);
         textField_40.setColumns(10);
         
         //��� ��
         textField_month = new JTextField();
         textField_month.setFont(new Font("�������", Font.PLAIN, 16));
         textField_month.setBounds(381, 540, 125, 35);
         number_add_panel.add(textField_month);
         textField_month.setColumns(10);
 
         
         //��Ϲ�ư
         JButton add_emdfhr_btn = new JButton("\uB4F1\uB85D");
         add_emdfhr_btn.setBackground(Color.WHITE);
         
         //ȸ�� ���
         add_emdfhr_btn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 
            	 try{
            		 DB_Connect();
            		 
            		PreparedStatement pstmt =null;  //ȸ�� �߰�
            	 	String sql = "insert into ȸ�� values(?,?,?,?,?,?,?,?)";
            	 	pstmt=con.prepareStatement(sql);
            	 	
            	 	
            	 	pstmt.setString(1, textField_26.getText());
            	 	pstmt.setString(2, textField_34.getText());
            	 	pstmt.setString(3, textField_35.getText());
            	 	pstmt.setString(5, textField_36.getText());
            	 	pstmt.setString(4, textField_37.getText());
            	 	pstmt.setString(6, textField_38.getText());
            	 	pstmt.setString(7, textField_39.getText());
            	 	pstmt.setString(8, textField_40.getText());

            	 	pstmt.execute();
            	 	
            	 	//���� �߰�
            	 	PreparedStatement cpstmt =null;
            	 	String sqle = "insert into ���� values(?,?,?,?)";
            	 	cpstmt=con.prepareStatement(sqle);
            	 	
            	 	LocalDate now = LocalDate.now(); //����ð�
            	 	
            	 	cpstmt.setString(1, now.toString());
            	 	cpstmt.setString(2, textField_month.getText());
            	 	cpstmt.setString(3, textField_26.getText());
            	 	cpstmt.setString(4, health_name);
            	 	cpstmt.execute();
            	 	
            	 	
            	 	cpstmt.close();
            	 	pstmt.close();
            	 	}catch(Exception e1){
            	 		JOptionPane.showMessageDialog(null,"ȸ�� �߰� ����!");
            	 	e1.printStackTrace();
            	 	}finally{
            	 		try{
            	 	}catch(Exception e1){
            	 		e1.printStackTrace();
            	 	}
            	 		}
            	 
            	 
            	 try {
                 	
                     DB_Connect();
                     String user_query = "select ȸ��.ȸ����ȣ,ȸ��.�̸� ,����.���Ը� from ȸ��,���� where ȸ��.ȸ����ȣ=����.ȸ����ȣ"; 
                     Statement stmt = con.createStatement(); 
                     ResultSet rs = stmt.executeQuery(user_query); 
                     System.out.println(health_name);
                     number_dm.setNumRows(0);
                     while(rs.next()) {
                  	   
                  	  if(rs.getString("���Ը�").equals(health_name)) {
                  	
                        String[] rows = new String[3];
                        rows[0]=rs.getString("ȸ����ȣ");
                        rows[1]=rs.getString("�̸�");
                        
                        CallableStatement cstmt = con.prepareCall("{call ������(?,?)}");
      		        	cstmt.registerOutParameter(1,Types.VARCHAR);
      		        	cstmt.setInt(2, Integer.parseInt(rs.getString("ȸ����ȣ")));
      		        	cstmt.executeQuery();
      		        	rows[2]=cstmt.getString(1)+"��";
      		        	
      		        			
                        number_dm.addRow(rows);
                        number_dm.isCellEditable(2,0);
                        
                       
                        
                  	  }
                  	  
                  	  }
                     rs.close();
                     stmt.close();
                  }catch (SQLException e1) {
                     e1.printStackTrace();
                  }finally {
                     try {
                              
                     } catch (Exception e1) {
                        
                        e1.printStackTrace();
                     }
                  }
            	  	 
            	number_add_panel.setVisible(false);
          		number_panel.setVisible(true);

             }
          });
         
         
         add_emdfhr_btn.setFont(new Font("�������", Font.PLAIN, 18));
         add_emdfhr_btn.setBounds(705, 546, 97, 45);
         number_add_panel.add(add_emdfhr_btn);
         
         
         //������ ��ư
         JButton add_panel_back = new JButton("\uB098\uAC00\uAE30");
         add_panel_back.setBackground(Color.WHITE);
         add_panel_back.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		number_add_panel.setVisible(false);
         		number_panel.setVisible(true);
         		
         	}
         });
         add_panel_back.setFont(new Font("�������", Font.PLAIN, 18));
         add_panel_back.setBounds(31, 559, 97, 45);
         number_add_panel.add(add_panel_back);
         

         
         //�뿩����
         JLabel rental_year = new JLabel("\uB300\uC5EC\uC77C\uC790");
         rental_year.setFont(new Font("�������", Font.PLAIN, 18));
         rental_year.setBounds(305, 188, 85, 28);
         rental_add_panel.add(rental_year);
         
         //�ⱸ��ȣ
         JLabel ex_number = new JLabel("\uAE30\uAD6C\uBC88\uD638");
         ex_number .setFont(new Font("�������", Font.PLAIN, 18));
         ex_number .setBounds(305, 256, 85, 47);
         rental_add_panel.add(ex_number );
         
         //�뿩���� �Է�
         textField_41 = new JTextField();
         textField_41.setFont(new Font("�������", Font.PLAIN, 16));
         textField_41.setBounds(386, 185, 126, 36);
         rental_add_panel.add(textField_41);
         textField_41.setColumns(10);
         
         //�ⱸ��ȣ �Է�
         textField_42 = new JTextField();
         textField_42.setFont(new Font("�������", Font.PLAIN, 16));
         textField_42.setBounds(386, 262, 126, 36);
         rental_add_panel.add(textField_42);
         textField_42.setColumns(10);
         
       //�������� ���
         JLabel ex_num = new JLabel("���� ����");
         ex_num .setFont(new Font("�������", Font.PLAIN, 18));
         ex_num .setBounds(305, 312, 85, 47);
         rental_add_panel.add(ex_num );
         
         
       //���� ���� ���
         textField_ex_num = new JTextField();
         textField_ex_num.setFont(new Font("�������", Font.PLAIN, 16));
         textField_ex_num.setBounds(386, 312, 126, 36);
         rental_add_panel.add(textField_ex_num);
         textField_ex_num.setColumns(10);
         
         //�뿩 ��ư
         JButton btnNewButton_2 = new JButton("\uB300\uC5EC");
         btnNewButton_2.setBackground(Color.WHITE);
         
         btnNewButton_2.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
         try{
        	 
        	 System.out.println(health_name);
    		 System.out.println(user_number);
    		 
    		 DB_Connect();
    		 
    		 PreparedStatement pstmt =null;  //�ⱸ �뿩
    		 
    		 	String sql = "insert into �뿩 values(?,?,?,?)";
    		 	pstmt=con.prepareStatement(sql);
    		 	pstmt.setString(1, textField_41.getText());
    		 	pstmt.setString(2, user_number);
    		 	pstmt.setString(3, health_name);
    		 	pstmt.setString(4, textField_42.getText());
    		 	
    		 	
    		 	
    		 	pstmt.execute();
    		 	pstmt.close();
    		 	}catch(Exception e1){
    		 		JOptionPane.showMessageDialog(null,"�̴̹뿩��!");
    		 	e1.printStackTrace();
    		 	}finally{
    		 		try{
    		 	}catch(Exception e1){
    		 		e1.printStackTrace();
    		 	}
    		 		}


         rental_add_panel.setVisible(false);
			number_panel_1.setVisible(true);
  		
             }
         });
         
         btnNewButton_2.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_2.setBounds(551, 203, 97, 55);
         rental_add_panel.add(btnNewButton_2);
         
         JButton btnNewButton_3 = new JButton("\uB098\uAC00\uAE30");
         btnNewButton_3.setBackground(Color.WHITE);
         btnNewButton_3.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		rental_add_panel.setVisible(false);
				number_panel_1.setVisible(true);
         	}
         });
         btnNewButton_3.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_3.setBounds(162, 358, 97, 47);
         rental_add_panel.add(btnNewButton_3);
         
         
         

         //pt���
         
         //�����ϼ�
         JLabel pt_year = new JLabel("\uC218\uC5C5\uC77C\uC218");
         pt_year.setFont(new Font("�������", Font.PLAIN, 18));
         pt_year.setBounds(296, 150, 81, 38);
         pt_Enroll_panel.add(pt_year);
         
         //�Ĵ�
         JLabel pt_diet = new JLabel("\uC2DD\uB2E8");
         pt_diet.setFont(new Font("�������", Font.PLAIN, 18));
         pt_diet.setBounds(296, 218, 81, 27);
         pt_Enroll_panel.add(pt_diet);
         
         //����
         JLabel pt_sca = new JLabel("\uC77C\uC815");
         pt_sca.setFont(new Font("�������", Font.PLAIN, 18));
         pt_sca.setBounds(296, 271, 81, 38);
         pt_Enroll_panel.add(pt_sca);
         
       //Ʈ���̳ʹ�ȣ
         JLabel pt_num = new JLabel("Ʈ���̳ʹ�ȣ");
         pt_num.setFont(new Font("�������", Font.PLAIN, 18));
         pt_num.setBounds(296, 321, 81, 38);
         pt_Enroll_panel.add(pt_num);
         
         //�����ϼ� �Է�
         textField_43 = new JTextField();
         textField_43.setFont(new Font("�������", Font.PLAIN, 16));
         textField_43.setBounds(377, 150, 135, 38);
         pt_Enroll_panel.add(textField_43);
         textField_43.setColumns(10);
         
         //�Ĵ�-�Է�
         textField_44 = new JTextField();
         textField_44.setFont(new Font("�������", Font.PLAIN, 16));
         textField_44.setBounds(377, 213, 135, 38);
         pt_Enroll_panel.add(textField_44);
         textField_44.setColumns(10);
         
         //����-�Է�
         textField_45 = new JTextField();
         textField_45.setFont(new Font("�������", Font.PLAIN, 16));
         textField_45.setBounds(377, 271, 135, 38);
         pt_Enroll_panel.add(textField_45);
         textField_45.setColumns(10);
         
       //Ʈ���̳� ��ȣ �Է�
         textField_53 = new JTextField();
         textField_53.setFont(new Font("�������", Font.PLAIN, 16));
         textField_53.setBounds(377, 321, 135, 38);
         pt_Enroll_panel.add(textField_53);
         textField_53.setColumns(10);
         
         //pt��Ϲ�ư
         JButton btnNewButton_6 = new JButton("\uB4F1\uB85D");
         btnNewButton_6.setFont(new Font("�������", Font.PLAIN, 18));
         
         
         btnNewButton_6.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 
            	 
            	 try{
            		 DB_Connect();
            		 
            		 PreparedStatement pstmt =null;  //pt���
            		
            		 	String sql = "insert into PT values(?,?,?,?,?)";
            		 	pstmt=con.prepareStatement(sql);
            		 	pstmt.setString(1, textField_43.getText());
            		 	pstmt.setString(2, textField_44.getText());
            		 	pstmt.setString(3, textField_45.getText());
            		 	pstmt.setString(4, user_number);
            		 	pstmt.setString(5, textField_53.getText());
            		 	pstmt.execute();
            		 	
            		 	pstmt.close();
            		 	}catch(Exception e1){
            		 		JOptionPane.showMessageDialog(null,"��� ����!");
            		 	e1.printStackTrace();
            		 	}finally{
            		 		try{
            		 	}catch(Exception e1){
            		 		e1.printStackTrace();
            		 	}
            		 		}
            	 
            	 
            	 
            	 pt_Enroll_panel.setVisible(false);
          		number_panel_1.setVisible(true);

             }
          });
         
         btnNewButton_6.setBackground(Color.WHITE);
         btnNewButton_6.setBounds(576, 192, 97, 46);
         pt_Enroll_panel.add(btnNewButton_6);
         

         //pt-������ ��ư
         JButton btnNewButton_7 = new JButton("\uB098\uAC00\uAE30");
         btnNewButton_7.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		pt_Enroll_panel.setVisible(false);
         		number_panel_1.setVisible(true);
         	}
         });
         
         btnNewButton_7.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_7.setBackground(Color.WHITE);
         btnNewButton_7.setBounds(54, 421, 97, 46);
         pt_Enroll_panel.add(btnNewButton_7);
 
         
         //��ǰ�ֹ�
         
         //��ǰ��ȣ
         JLabel goods_number = new JLabel("\uC0C1\uD488\uBC88\uD638");
         goods_number.setFont(new Font("�������", Font.PLAIN, 18));
         goods_number.setBounds(296, 160, 78, 21);
         goods_order_panel.add(goods_number);
         
         //��ǰ�̸�
         JLabel name_goods = new JLabel("\uC0C1\uD488\uC774\uB984");
         name_goods.setFont(new Font("�������", Font.PLAIN, 18));
         name_goods.setBounds(296, 215, 89, 33);
         goods_order_panel.add(name_goods);
         
         //��ǰ����
         JLabel num_goods = new JLabel("\uC0C1\uD488\uC218\uB7C9");
         num_goods.setFont(new Font("�������", Font.PLAIN, 18));
         num_goods.setBounds(296, 272, 89, 27);
         goods_order_panel.add(num_goods);
         
         //����
         JLabel goods_price = new JLabel("\uAC00\uACA9");
         goods_price.setFont(new Font("�������", Font.PLAIN, 18));
         goods_price.setBounds(296, 328, 89, 21);
         goods_order_panel.add(goods_price);
         
         //��ǰ��ȣ_�Է�
         textField_46 = new JTextField();
         textField_46.setFont(new Font("�������", Font.PLAIN, 16));
         textField_46.setBounds(386, 148, 142, 39);
         goods_order_panel.add(textField_46);
         textField_46.setColumns(10);
         
         
         //��ǰ�̸� �Է�
         textField_47 = new JTextField();
         textField_47.setFont(new Font("�������", Font.PLAIN, 16));
         textField_47.setBounds(386, 212, 142, 39);
         goods_order_panel.add(textField_47);
         textField_47.setColumns(10);
         
         
         //��ǰ���� �Է�
         textField_48 = new JTextField();
         textField_48.setFont(new Font("�������", Font.PLAIN, 16));
         textField_48.setBounds(386, 266, 142, 39);
         goods_order_panel.add(textField_48);
         textField_48.setColumns(10);
         
         
         //���� �Է�
         textField_49 = new JTextField();
         textField_49.setFont(new Font("�������", Font.PLAIN, 16));
         textField_49.setBounds(386, 319, 142, 39);
         goods_order_panel.add(textField_49);
         textField_49.setColumns(10);
         
         //�ֹ� ��ư
         JButton btnNewButton_8 = new JButton("\uC8FC\uBB38");
         btnNewButton_8.setBackground(Color.WHITE);
         
         //�ֹ� 
         btnNewButton_8.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 
 	 
            	 try{
            		 DB_Connect();
            		
            		 con.setAutoCommit(false);
            		 if (Integer.parseInt(textField_48.getText())>10) {throw new SQLException();}

            		 PreparedStatement pstmt =null;  //��ǰ�ֹ�
            		 	String sql = "insert into ��ǰ values(?,?,?,?,?)";
            		 	pstmt=con.prepareStatement(sql);
            		 	pstmt.setString(1, textField_46.getText());
            		 	pstmt.setString(2, textField_47.getText());
            		 	pstmt.setString(3, textField_48.getText());
            		 	pstmt.setString(4, textField_49.getText());
            		 	pstmt.setString(5, health_name);
            		 	pstmt.execute();
            		 	pstmt.close();
            		 	
            		 	con.commit(); 		 		 	
            		 	}catch(Exception e1){
            		 		try {
								con.rollback();
								JOptionPane.showMessageDialog(null,"�ֹ� ����!");
							} catch (SQLException e2) {
								
								e2.printStackTrace();
							}
            		 	e1.printStackTrace();
            		 	}finally{
            		 		try{
            		 	}catch(Exception e1){
            		 		e1.printStackTrace();
            		 	}
            		 		}
            	 
            	 try {
					con.setAutoCommit(true);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
            	
            	 
            	 
            	 try {
                     DB_Connect();
                     String query = "select ��ǰ��ȣ,��ǰ�̸�,��ǰ����,����,���Ը� from ��ǰ"; 
                     Statement stmt = con.createStatement(); 
                     PreparedStatement ps = con.prepareStatement(query); 
                     
                     ResultSet rs = ps.executeQuery(); 
                     goods.setNumRows(0);
                     while(rs.next()) {
                  	   if(rs.getString("���Ը�").equals(health_name)) {
                        String[] rows = new String[4];
                        rows[0]=rs.getString("��ǰ��ȣ");
                        rows[1]=rs.getString("��ǰ�̸�");
                        rows[2]=rs.getString("��ǰ����");
                        rows[3]=rs.getString("����");
                        goods.addRow(rows);
                  	   }
                     }
                     rs.close();
                     stmt.close();
                  }catch (SQLException e1) {
                     e1.printStackTrace();
                  }finally {
                     try {         
                     } catch (Exception e1) {
                        
                        e1.printStackTrace();
                     }
                  }
            	 
            	 
            	 
            	 
            	 goods_order_panel.setVisible(false);
 				goods_panel.setVisible(true);

             }
          });
         btnNewButton_8.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_8.setBounds(611, 233, 97, 44);
         goods_order_panel.add(btnNewButton_8);
         
         //������ ��ư
         JButton btnNewButton_9 = new JButton("\uB098\uAC00\uAE30");
         btnNewButton_9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goods_order_panel.setVisible(false);
				goods_panel.setVisible(true);
				
			}
		});
         
         
         btnNewButton_9.setBackground(Color.WHITE);
         btnNewButton_9.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_9.setBounds(98, 420, 97, 44);
         goods_order_panel.add(btnNewButton_9);


         //��ǰ ����
         //��������
         JLabel purchase_year  = new JLabel("\uAD6C\uB9E4\uC77C\uC790");
         purchase_year.setFont(new Font("�������", Font.PLAIN, 18));
         purchase_year.setBounds(296, 150, 81, 38);
         goods_purchase_panel.add(purchase_year);
         
         //���ż���
         JLabel purchase_num = new JLabel("\uAD6C\uB9E4\uC218\uB7C9");
         purchase_num.setFont(new Font("�������", Font.PLAIN, 18));
         purchase_num.setBounds(296, 218, 81, 27);
         goods_purchase_panel.add(purchase_num);
         
         //���Ź�ȣ
         JLabel purchase_number = new JLabel("\uAD6C\uB9E4\uBC88\uD638");
         purchase_number.setFont(new Font("�������", Font.PLAIN, 18));
         purchase_number.setBounds(296, 271, 81, 38);
         goods_purchase_panel.add(purchase_number);
         
         //�������� �Է�
         textField_50 = new JTextField();
         textField_50.setFont(new Font("�������", Font.PLAIN, 16));
         textField_50.setBounds(379, 150, 148, 38);
         goods_purchase_panel.add(textField_50);
         textField_50.setColumns(10);
         
         //���ż���
         textField_51 = new JTextField();
         textField_51.setFont(new Font("����", Font.PLAIN, 16));
         textField_51.setBounds(379, 205, 148, 38);
         goods_purchase_panel.add(textField_51);
         textField_51.setColumns(10);
         
         //���Ź�ȣ
         textField_52 = new JTextField();
         textField_52.setFont(new Font("�������", Font.PLAIN, 16));
         textField_52.setBounds(379, 264, 148, 38);
         goods_purchase_panel.add(textField_52);
         textField_52.setColumns(10);
         
         
         
         //����
         JButton btnNewButton_10 = new JButton("\uAD6C\uB9E4");
         btnNewButton_10.setBackground(Color.WHITE);
         
         
         btnNewButton_10.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 
            	 
            	 try{
            		 DB_Connect();
            		 
            		 PreparedStatement pstmt =null; //��ǰ ����
            		 
            		 	String sql = "insert into ���� values(?,?,?,?,?)";
            		 	pstmt=con.prepareStatement(sql);
            		 	pstmt.setString(1, textField_50.getText());
            		 	pstmt.setString(2, textField_51.getText());
            		 	pstmt.setString(3, textField_52.getText());
            		 	pstmt.setString(4, user_number);
            		 	pstmt.setString(5, health_name);
            		 	int a=pstmt.executeUpdate();
            		 	System.out.print("���� : "+a);
            		 	pstmt.close();
            		 	}catch(Exception e1){
            		 		JOptionPane.showMessageDialog(null,"��ǰ����!");
            		 	e1.printStackTrace();
            		 	}finally{
            		 		try{
            		 	}catch(Exception e1){
            		 		e1.printStackTrace();
            		 	}
            		 		}
            	 

            	 
            	 goods_purchase_panel.setVisible(false);
          		number_panel_1.setVisible(true);
             }
          });
         
         btnNewButton_10.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_10.setBounds(582, 190, 97, 44);
         goods_purchase_panel.add(btnNewButton_10);
         
         
         //������
         JButton btnNewButton_11 = new JButton("\uB098\uAC00\uAE30");
         btnNewButton_11.setBackground(Color.WHITE);
         btnNewButton_11.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		goods_purchase_panel.setVisible(false);
         		number_panel_1.setVisible(true);
         	}
         });
         
         
         btnNewButton_11.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_11.setBounds(149, 391, 97, 44);
         goods_purchase_panel.add(btnNewButton_11);
         
         
         
         
  //�ⱸ�߰�
         
         //�ⱸ �߰� �뿩����
         JLabel rental_enroll_year = new JLabel("\uB300\uC5EC\uC77C\uC790");
         rental_enroll_year.setFont(new Font("�������", Font.PLAIN, 18));
         rental_enroll_year.setBounds(305, 188, 85, 28);
         ex_enroll_panel.add(rental_enroll_year);
         
         //�ⱸ��ȣ
         JLabel ex_enroll_number = new JLabel("\uAE30\uAD6C\uBC88\uD638");
         ex_enroll_number .setFont(new Font("�������", Font.PLAIN, 18));
         ex_enroll_number .setBounds(305, 256, 85, 47);
         ex_enroll_panel.add(ex_enroll_number );
         
       //ȸ����ȣ
         JLabel ex_user_number = new JLabel("ȸ����ȣ");
         ex_user_number .setFont(new Font("�������", Font.PLAIN, 18));
         ex_user_number .setBounds(305, 326, 85, 47);
         ex_enroll_panel.add(ex_user_number );
         
         JButton btnNewButton_12 = new JButton("\uCD94\uAC00");
         btnNewButton_12.setBackground(Color.WHITE);

         btnNewButton_12.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
         try{
    		 DB_Connect();
    		 
    		 PreparedStatement pstmt =null;  //�ⱸ �뿩
    		 System.out.println(health_name);
    		
    		 	String sql = "insert into �뿩 values(?,?,?,?)";
    		 	pstmt=con.prepareStatement(sql);
    		 	pstmt.setString(1, textField_54.getText());
    		 	pstmt.setString(4, textField_55.getText());
    		 	pstmt.setString(3, health_name);
    		 	pstmt.setString(2, textField_56.getText());
    		 	
    		 	pstmt.execute();
    		 	pstmt.close();
    		 	}catch(Exception e1){
    		 		JOptionPane.showMessageDialog(null,"�̹� �뿩��!");
    		 	e1.printStackTrace();
    		 	}finally{
    		 		try{
    		 	}catch(Exception e1){
    		 		e1.printStackTrace();
    		 	}
    		 		}


  		 try {
             DB_Connect();
             String query = "select �ⱸ��ȣ,�ⱸ��,���Ը�,�뿩���� from ��ⱸ "; 
             Statement stmt = con.createStatement(); 
             PreparedStatement ps = con.prepareStatement(query); 
             
             ResultSet rs = ps.executeQuery(); 
             ex_gigu.setNumRows(0);
             while(rs.next()) {
             	 if(rs.getString("���Ը�").equals(health_name)) {
                String[] rows = new String[3];
                rows[0]=rs.getString("�ⱸ��ȣ");
                rows[1]=rs.getString("�ⱸ��");
                rows[2]=rs.getString("�뿩����");
                ex_gigu.addRow(rows);
             	 }
             }
             rs.close();
             stmt.close();
          }catch (SQLException e1) {
             e1.printStackTrace();
          }finally {
             try {    
             } catch (Exception e1) {       
                e1.printStackTrace();
             }
          }
  		 
  		ex_enroll_panel.setVisible(false);
		 ex_info_panel.setVisible(true);
  		
             }
         });
         
         
         btnNewButton_12.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_12.setBounds(555, 220, 97, 47);
         ex_enroll_panel.add(btnNewButton_12);
         
         //��ⱸ �߰� ������ 
         JButton btnNewButton_13 = new JButton("\uB098\uAC00\uAE30");
         btnNewButton_13.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 ex_enroll_panel.setVisible(false);
				 ex_info_panel.setVisible(true);
			}
		});
         
         
         btnNewButton_13.setBackground(Color.WHITE);
         btnNewButton_13.setFont(new Font("�������", Font.PLAIN, 18));
         btnNewButton_13.setBounds(153, 358, 97, 47);
         ex_enroll_panel.add(btnNewButton_13);
         
         //�뿩���� �Է�
         textField_54 = new JTextField();
         textField_54 .setFont(new Font("�������", Font.PLAIN, 16));
         textField_54 .setBounds(391, 187, 125, 34);
         ex_enroll_panel.add(textField_54);
         textField_54.setColumns(10);
         
         //�ⱸ��ȣ �Է�
         textField_55 = new JTextField();
         textField_55.setFont(new Font("�������", Font.PLAIN, 16));
         textField_55.setBounds(391, 263, 125, 35);
         ex_enroll_panel.add(textField_55);
         textField_55.setColumns(10);
         
         //ȸ�� �Է�
         textField_56 = new JTextField();
         textField_56.setFont(new Font("�������", Font.PLAIN, 16));
         textField_56.setBounds(391, 320, 125, 35);
         ex_enroll_panel.add(textField_56);
         textField_56.setColumns(10);
    
         
         
   }
}
