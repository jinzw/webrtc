package com.zizibujuan.server.webrtc.servlets;

import java.io.IOException;
import java.util.List;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

/**
 * 信号
 * 
 * @author jzw
 * @since 0.0.1
 */
public class SignalingSocket implements OnTextMessage {

	private Connection conn;

	@Override
	public void onClose(int arg0, String arg1) {
		WebSocketInitServlet.getSocketList().remove(this);
		System.out.println("onClose==========================");
	}

	@Override
	public void onOpen(Connection conn) {
		System.out.println("onOpen=========================="
				+ conn.getMaxIdleTime());
		WebSocketInitServlet.getSocketList().add(this);
		this.conn = conn;
	}

	@Override
	public void onMessage(String data) {
		List<SignalingSocket> socketList = WebSocketInitServlet.getSocketList();
		for (SignalingSocket socket : socketList) {
			try {
				socket.getConn().sendMessage(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
