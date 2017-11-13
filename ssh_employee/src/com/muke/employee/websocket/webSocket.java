package com.muke.employee.websocket;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ServerEndpoint(value = "/client")
public class webSocket {
	    private static final Log log = LogFactory.getLog(webSocket.class);

	    private static final String GUEST_PREFIX = "Guest";
	    private static final AtomicInteger connectionIds = new AtomicInteger(0);
	    private static final Set<webSocket> connections = new CopyOnWriteArraySet<webSocket>();

	    private String nickname;
	    private Session session;

	    public webSocket() {
	        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	    }

	    /*
	     * ��websocket�Ŀͻ������ӵ�������ʱ����������ͻ�ִ�У����Ҵ���һ��session�Ự������
	     * �����õ��⻰session�����ǿ��Ը��ͻ��˷�����Ϣ
	     */
	    @OnOpen
	    public void start(Session session) {
	        this.session = session;
	        connections.add(this);
	        String message = String.format("* %s %s", nickname, "has joined.");
	        broadcast(message);
	    }

	    /* �ͻ��˱��ر�ʱ�򣬾ͻ��Զ������������� */
	    @OnClose
	    public void end() {
	        connections.remove(this);
	        String message = String.format("* %s %s", nickname, "has disconnected.");
	        broadcast(message);
	    }

	    /* �ͻ��˸�������������Ϣ������������Զ����ã����ҿ����õ����͹��������� */
	    @OnMessage
	    public void incoming(String message) {
	        // Never trust the client
	        System.out.println(message);
	        broadcast(message);
	    }

	    /* �������쳣�Զ�ִ�� */
	    @OnError
	    public void onError(Throwable t) throws Throwable {
	        log.error("Chat Error: " + t.toString(), t);
	    }

	    /* �㲥�������ͻ��˼���������Ϣ��ע�ⷢ��Ҫ�õ�session����session.getBasicRemote().sendText(msg)������Ϣ */
	    private static void broadcast(String msg) {
	        for (webSocket client : connections) {// ��������
	            try {// ������client�Ѿ�����
	                synchronized (client) {
	                    client.session.getBasicRemote().sendText(msg);// ������Ϣ
	                }
	            } catch (IOException e) {// ������client������
	                log.debug("Chat Error: Failed to send message to client", e);
	                connections.remove(client);
	                try {
	                    client.session.close();
	                } catch (IOException e1) {
	                    // Ignore
	                }
	                String message = String.format("* %s %s", client.nickname, "has been disconnected.");
	                broadcast(message);
	            }
	        }
	    }
	
	
	
}
