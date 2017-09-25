package br.edu.unirn.avaliacao02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Mestre {

	public static void main(String[] args) throws Exception {
		
		ArrayList<String> ipescravos = new ArrayList<String>();

		DatagramSocket socket = new DatagramSocket(2000);
		DatagramPacket packet = new DatagramPacket(new byte[512], 512);
		
		while(true) {
			System.out.println("Aguardando mensagem... ");
			socket.receive(packet);
			System.out.println("IP: " + new String(packet.getData()));
			String ippacote = new String(packet.getData());
			
			if(!ippacote.isEmpty()) {
				ipescravos.add(ippacote);
				for(int i = 0; i < ipescravos.size(); i++) {
					System.out.println(ipescravos.get(i));
				}
			}
			packet = new DatagramPacket(new byte[512],512);		
		}

	}
}
