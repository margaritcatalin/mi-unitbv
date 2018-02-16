package com.catalin.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSend {
	public static void main(String[] args) throws IOException {
		InetAddress grup = InetAddress.getByName("230.0.0.1");
		int port = 4444;
		byte[] buf;
		DatagramPacket packet = null;
		DatagramSocket socket = new DatagramSocket(0);
		try {
			buf = (new String("Salut grup!")).getBytes();
			packet = new DatagramPacket(buf, buf.length, grup, port);
			socket.send(packet);
		} finally {
			socket.close();
		}
	}
}
