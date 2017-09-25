package br.edu.unirn.avaliacao02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Mestre {

	public static void main(String[] args) throws Exception {
		
		ArrayList<String> ipescravos = new ArrayList<String>();

		DatagramSocket datagramSocket = new DatagramSocket(2000);
		DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512);
		
		while(true) {
			System.out.println("Aguardando mensagem... ");
			datagramSocket.receive(datagramPacket);
			System.out.println("IP: " + new String(datagramPacket.getData()));
			String ippacote = new String(datagramPacket.getData());
			
			if(!ippacote.isEmpty()) {
				ipescravos.add(ippacote);
				for(int i = 0; i < ipescravos.size(); i++) {
					System.out.println(ipescravos.get(i));
				}
			}
			datagramPacket = new DatagramPacket(new byte[512],512);		
		}
	}
}
