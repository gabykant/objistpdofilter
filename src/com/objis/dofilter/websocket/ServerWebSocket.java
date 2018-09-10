package com.objis.dofilter.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/serverchat")
public class ServerWebSocket {

	static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	@OnOpen
	public void onOpen(Session session)
	{
		System.out.println(session.getId() + " a ouvert une connexion");
		peers.add(session);
		/*try {
			session.getBasicRemote().sendText("Connexion etablie");;
		} catch( IOException e) {
			e.printStackTrace();
		}*/
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException, EncodeException
	{
		for (Session peer: peers) {
			if (!session.getId().equals(peer.getId())) {
				peer.getBasicRemote().sendText(message);
			}
		}
		//System.out.println("Message venant de " + session.getId() + " : " + message);
		/*try {
			session.getBasicRemote().sendText(message);
		} catch( IOException e) {
			e.printStackTrace();
		}*/
	}
	
	@OnClose
	public void onClose(Session session) throws IOException
	{
		System.out.println("Session " + session.getId() + " terminee");
		peers.remove(session);
		
		for (Session peer : peers) {
			String message = "L utilisayteur " + peer.getId() + " s est deconnecte";
            peer.getBasicRemote().sendText(message);
		}
		/*try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
}
