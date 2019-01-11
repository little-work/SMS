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
	
	//用来记录需要实时获取数据库表中数据的记录数
		private int num;
		private int new_num;
		private boolean flag=true;
		
		static Connection conn=null;
	     static {
	         try {
	             //1.加载驱动程序
	             Class.forName("com.mysql.jdbc.Driver");
	             //2.获得数据库的连接
	             conn=(Connection) DriverManager.getConnection(URL, USER, PASSWORD);
	         } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
		
		
	

	 private Session session; //记录客户端session对象
	 
	    public static CopyOnWriteArraySet<MyWebSocket> wbSockets =
	    		new CopyOnWriteArraySet<MyWebSocket>(); //此处定义静态变量，以在其他方法中获取到所有连接
	
	  
	    /**
	     * 建立连接。
	     * 建立连接时入参为session
	     */
	    @OnOpen
	    public void onOpen(Session session){
	    	
	        this.session = session;
	        wbSockets.add(this); //将此对象存入集合中以在之后广播用，如果要实现一对一订阅，则类型对应为Map。由于这里广播就可以了随意用Set
	        System.out.println("一个新的连接  通过websocket连接了，他的sessionID"
	        		+ "是"+ session.getId());
	        new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					num=getCount();
					
						while(flag){
							new_num=getCount();
							
							if(num!=new_num){
								num=new_num;
								try {
									sendMessage("数据更新了"+String.valueOf(getCount()));
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
	     * 关闭连接
	     */
	    @OnClose
	    public void onClose(){
	        wbSockets.remove(this);//将socket对象从集合中移除，以便广播时不发送次连接。如果不移除会报错(需要测试)
	        flag=false;
	        try {
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        System.out.println("有一个用户已经退出了连接"+ session.getId());
	    }
	    
	    /**
	     * 接收前端传过来的数据。
	     * 虽然在实现推送逻辑中并不需 要接收前端数据，但是作为一个webSocket的教程或叫备忘，还是将接收数据的逻辑加上了。
	     */
	    @OnMessage
	    public void onMessage(String message ,Session session){
	        System.out.println("一个新的消息来自"+message + "来自 " + session.getId());
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
				System.out.println("行数:"+row);
				return row;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
			
		}
	    
}
