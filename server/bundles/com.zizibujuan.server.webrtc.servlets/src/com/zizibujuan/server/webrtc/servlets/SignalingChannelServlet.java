package com.zizibujuan.server.webrtc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

public class SignalingChannelServlet extends WebSocketServlet{

	private static final long serialVersionUID = -1059026580914219545L;

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		
		return new SignalingSocket();
	}

	
}
