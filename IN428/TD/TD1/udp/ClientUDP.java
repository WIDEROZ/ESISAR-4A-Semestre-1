package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Client basique UDP
 * 
 */
public class ClientUDP
{

    public static void main(String[] args) throws Exception
    {
        ClientUDP clientUDP = new ClientUDP();
        clientUDP.multiplication();

    }


    /**
     * Le client cree une socket, envoie un message au serveur
     * et attend la reponse 
     * 
     */
    private void execute() throws IOException
    {
        //
        System.out.println("Demarrage du client ...");

        //Creation de la socket
        DatagramSocket socket = new DatagramSocket();

        // Creation et envoi du message
        InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 3000);
        byte[] bufE = new String("question du client").getBytes();
        DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
        socket.send(dpE);
        System.out.println("Message envoyé");

        // Attente de la reponse 
        byte[] bufR = new byte[2048];
        DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
        socket.receive(dpR);
        String reponse = new String(bufR, dpR.getOffset(), dpR.getLength());
        System.out.println("Reponse recue = "+reponse);

        // Fermeture de la socket
        socket.close();
        System.out.println("Arret du client .");
    }

    private void ping_pong() throws IOException{
        System.out.println("Demarrage du client ...");

        //Creation de la socket
        DatagramSocket socket = new DatagramSocket();

        // Creation et envoi de JOUER
        InetSocketAddress adrDest = new  InetSocketAddress("127.0.0.1", 29000);
        byte[] bufE = new String("JOUER").getBytes();
        DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
        socket.send(dpE);
        System.out.println("Message envoyé");

        // Attente de la reponse 
        byte[] bufR = new byte[2048];
        DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
        socket.receive(dpR);
        String reponse = new String(bufR, dpR.getOffset(), dpR.getLength());
        System.out.println("Reponse recue = "+reponse);


        // Envoi de Ping ou de pong suivant la réponse
        if(reponse.equals("PING")){
            bufE = "PONG".getBytes();
        }
        else{
            bufE = "PING".getBytes();
        }

        DatagramPacket dpP = new DatagramPacket(bufE, bufE.length, adrDest);
        socket.send(dpP);

        socket.close();
        System.out.println("Arret du client .");

    }

    private void multiplication() throws IOException{
        System.out.println("Demarrage du client ...");

        //Creation de la socket
        DatagramSocket socket = new DatagramSocket();

        InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 11000);
        

        // Buffers et Datagrams
        // Envoi
        byte[] bufE;
        DatagramPacket dpE;
        // Reception
        byte[] bufR;
        DatagramPacket dpR;

        // Déclaration des chiffres String et Integers
        String chiffre_1_str;
        String chiffre_2_str;
        int chiffre_1_int;
        int chiffre_2_int;

        int result_int;
        String result_str;

        String win_msg;



        
        while(true){
            // Creation et envoi de JOUER
            bufE = new String("JOUER").getBytes();
            dpE = new DatagramPacket(bufE, bufE.length, adrDest);
            socket.send(dpE);
            System.out.println("Message JOUER envoyé");


            bufR = new byte[2048];
            dpR = new DatagramPacket(bufR, bufR.length);
            

            // Attente du chiffre 1
            socket.receive(dpR);
            chiffre_1_str = new String(bufR, dpR.getOffset(), dpR.getLength());
            System.out.println("Chiffre 1 = " + chiffre_1_str);
            chiffre_1_str = String.valueOf(chiffre_1_str.charAt(0));

            // Attente du chiffre 2
            socket.receive(dpR);
            chiffre_2_str = new String(bufR, dpR.getOffset(), dpR.getLength());
            System.out.println("Chiffre 2 = " + chiffre_2_str);
            chiffre_2_str = String.valueOf(chiffre_2_str.charAt(0));



            // Conversion String -> Integer
            chiffre_1_int = Integer.parseInt(chiffre_1_str);
            chiffre_2_int = Integer.parseInt(chiffre_2_str);


            result_int = chiffre_1_int * chiffre_2_int;


            result_str = new String(Integer.toString(result_int) + ";");


            // Envoi de la multiplication
            bufE = result.getBytes();
            dpE = new DatagramPacket(bufE, bufE.length, adrDest);
            socket.send(dpE);
            System.out.println("Message envoyé");


            // Attente du message perdu ou gagné
            socket.receive(dpR);
            win_msg = new String(bufR, dpR.getOffset(), dpR.getLength());
            System.out.println(win_msg);
        }


    }

}