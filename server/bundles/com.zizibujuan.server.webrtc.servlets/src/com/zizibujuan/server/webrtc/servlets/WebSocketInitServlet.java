package com.zizibujuan.server.webrtc.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class WebSocketInitServlet extends HttpServlet{
	private static final long serialVersionUID = -5630044878662227354L;
	private static List<SignalingSocket> socketList;  
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		socketList = new ArrayList<SignalingSocket>(); 
		super.init(config);
		System.out.println("Server start============");  
	}

	public static synchronized List<SignalingSocket> getSocketList() {  
        return socketList;  
    }
}