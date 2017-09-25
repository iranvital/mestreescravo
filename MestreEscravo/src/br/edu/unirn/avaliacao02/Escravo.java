package br.edu.unirn.avaliacao02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Escravo {

	public static void main(String[] args) throws Exception {
		
		InetAddress ip = InetAddress.getByName("::1");
		
		DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512, ip, 2000);
		DatagramSocket datagramSocket = new DatagramSocket();
		
		while(true) {
			datagramPacket.setData(InetAddress.getLocalHost().getHostAddress().getBytes());
			datagramSocket.send(datagramPacket);
			datagramSocket.close();
		}

	}

}
