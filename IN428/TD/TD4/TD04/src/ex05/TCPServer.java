package ex05;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import ex05.SampleFileReader;

import java.net.ServerSocket;



public class TCPServer {
	
	public static void main(String[] args) throws Exception
    {
        TCPServer serveurTCP = new TCPServer();
        serveurTCP.execute();

    }



    private void execute() throws IOException
    {
        //
        System.out.println("Demarrage du serveur ...");

        // Le serveur se declare aupres de la couche transport
        // sur le port 5099
        ServerSocket socketEcoute = new ServerSocket();
        socketEcoute.bind(new InetSocketAddress(5099));


        // Attente de la connexion d'un client
        System.out.println("Attente de la connexion du client ...");
        Socket socketConnexion = socketEcoute.accept();

        // Affichage du port et de l'ip du client 
        System.out.println("Un client est connecté");
        System.out.println("IP:"+socketConnexion.getInetAddress());
        System.out.println("Port:"+socketConnexion.getPort());
        
       

        // Emission d'un message en retour
        byte[] bufE = new byte[2048];
        OutputStream os = socketConnexion.getOutputStream();
        // Read file server.txt
        SampleFileReader sfr = new SampleFileReader("/home/wideroz/file1");
        int len = sfr.read_buffer(bufE);

        while(len != -1) {
        	os.write(bufE, 0, len); // Envoi en TCP
        	len = sfr.read_buffer(bufE); // Read file buffer
        }
        
        sfr.close_file();
        System.out.println("Message envoye");

        // Fermeture de la socket de connexion
        socketConnexion.close();


        // Arret du serveur 
        socketEcoute.close();
        System.out.println("Arret du serveur .");
    }
}