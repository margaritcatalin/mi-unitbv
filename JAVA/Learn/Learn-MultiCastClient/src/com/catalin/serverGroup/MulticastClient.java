package com.catalin.serverGroup;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
	public static void main(String[] args) throws IOException {
		InetAddress group = InetAddress.getByName("230.0.0.1");
		int port = 4444;
		MulticastSocket socket = null;
		byte buf[];
		try {
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
			buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			System.out.println("Asteptam un packet...");
			socket.receive(packet);
			System.out.println(new String(packet.getData()).trim());
		} finally {
			if (socket != null) {
				socket.leaveGroup(group);
				socket.close();
			}
		}
	}
}
