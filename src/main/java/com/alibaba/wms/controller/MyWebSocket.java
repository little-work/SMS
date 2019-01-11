package com.alibaba.wms.controller;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.mysql.jdbc.Connection;

@ServerEndpoint("/wbSocket")
public class MyWebSocket {
	
	static String URL="jdbc:mysql://127.0.0.1:3306/wms";
	static String USER="root";
	static String PASSWORD="root";
	
	Statement stat = null;
	ResultSet rs = null;
	
	//������¼��Ҫʵʱ��ȡ���ݿ�������ݵļ�¼��
		private int num;
		private int new_num;
		private boolean flag=true;
		
		static Connection conn=null;
	     static {
	         try {
	             //1.������������
	             Class.forName("com.mysql.jdbc.Driver");
	             //2.������ݿ������
	             conn=(Connection) DriverManager.getConnection(URL, USER, PASSWORD);
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
		
		
	

	 private Session session; //��¼�ͻ���session����
	 
	    public static CopyOnWriteArraySet<MyWebSocket> wbSockets =
	    		new CopyOnWriteArraySet<MyWebSocket>(); //�˴����徲̬�������������������л�ȡ����������
	
	  
	    /**
	     * �������ӡ�
	     * ��������ʱ���Ϊsession
	     */
	    @OnOpen
	    public void onOpen(Session session){
	    	
	        this.session = session;
	        wbSockets.add(this); //���˶�����뼯��������֮��㲥�ã����Ҫʵ��һ��һ���ģ������Ͷ�ӦΪMap����������㲥�Ϳ�����������Set
	        System.out.println("һ���µ�����  ͨ��websocket�����ˣ�����sessionID"
	        		+ "��"+ session.getId());
	        new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					num=getCount();
					
						while(flag){
							new_num=getCount();
							
							if(num!=new_num){
								num=new_num;
								try {
									sendMessage("���ݸ�����"+String.valueOf(getCount()));
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
					}
				
				}
			}).start();
	        
	     
	    }
	
	    /**
	     * �ر�����
	     */
	    @OnClose
	    public void onClose(){
	        wbSockets.remove(this);//��socket����Ӽ������Ƴ����Ա�㲥ʱ�����ʹ����ӡ�������Ƴ��ᱨ��(��Ҫ����)
	        flag=false;
	        try {
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        System.out.println("��һ���û��Ѿ��˳�������"+ session.getId());
	    }
	    
	    /**
	     * ����ǰ�˴����������ݡ�
	     * ��Ȼ��ʵ�������߼��в����� Ҫ����ǰ�����ݣ�������Ϊһ��webSocket�Ľ̳̻�б��������ǽ��������ݵ��߼������ˡ�
	     */
	    @OnMessage
	    public void onMessage(String message ,Session session){
	        System.out.println("һ���µ���Ϣ����"+message + "���� " + session.getId());
	    }

	    public void sendMessage(String message) throws IOException {
	        this.session.getBasicRemote().sendText(message);
	    }
	    public int getCount(){
			try {
				stat = conn.createStatement();
				String sql="select count(*) from tutorials_tbl ";
				rs=stat.executeQuery(sql);
				rs.next();
				int row = rs.getInt(1);
				System.out.println("����:"+row);
				return row;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
	    
}
