package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Serveur basique UDP
 */
public class ServeurUDP
{

    public static void main(String[] args) throws Exception
    {
        ServeurUDP serveurUDP = new ServeurUDP();
        serveurUDP.execute();

    }



    private void execute() throws IOException
    {
        //
        System.out.println("Demarrage du serveur ...");

        // Le serveur se declare aupres de la couche transport
        // sur le port 3000
        DatagramSocket socket = new DatagramSocket(null);
        socket.bind(new InetSocketAddress(3000));

        // Attente du premier message
        byte[] bufR = new byte[2048];
        DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
        socket.receive(dpR);
        String message = new String(bufR, dpR.getOffset(), dpR.getLength());
        System.out.println("Message recu de : " + dpR.getAddress() + ", sur le port : " + dpR.getPort());
        System.out.println("Message : " + message);

        // Emission d'un message en retour
        byte[] bufE = new String("ok").getBytes();
        DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, 
                dpR.getAddress(),dpR.getPort());
        socket.send(dpE);
        System.out.println("Message envoye = ok");

        // Fermeture de la socket
        socket.close();
        System.out.println("Arret du serveur .");
    }

}