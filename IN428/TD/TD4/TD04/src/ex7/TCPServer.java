package ex7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.File;

import ex7.SampleFileReader;

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
        
       //Reçois le nom du fichier
        int len;
        InputStream is = socketConnexion.getInputStream();
        byte[] bufR = new byte[256];
        len = is.read(bufR);
        
       
        //Chercher le fichier
        String nom_fichier= new String(bufR, 0, len);
        SampleFileReader sfr;
        System.out.println("/home/wideroz/" + nom_fichier);
        try {
        	sfr = new SampleFileReader("/home/wideroz/" + nom_fichier);
        }catch (IOException exp) {
        	byte[] bufE = {-1};
            OutputStream os = socketConnexion.getOutputStream();
            os.write(bufE);
            socketConnexion.close();
            socketEcoute.close();
            System.out.println("Arret du serveur , fichier imaginaire.");
            return;
        }
        // Fichier trouvé
        byte[] bufE = {0};
        OutputStream os = socketConnexion.getOutputStream();
        os.write(bufE);

        //File size detection and send
        
        File f = new File("/home/wideroz/" + nom_fichier);
        int fileSize = (int) f.length();
        byte[] bufS = new byte[4];
        bufS[0] = (byte) (fileSize >> 24);
        bufS[1] = (byte) (fileSize >> 16);
        bufS[2] = (byte) (fileSize >> 8);
        bufS[3] = (byte) (fileSize);
        
        
        int len_file = ((((int) bufS[0])*256+ ((int) bufS[1]))*256 + ((int) bufS[2]))*256 + ((int) bufS[3]);

        
        System.out.println("File Size server side : " + fileSize);
        System.out.println("File Size server side TANSLATED : " + len_file);
        
        os.write(bufS);
        
        // Emission d'un message en retour
        bufE = new byte[2048];        
        
        // Read file server.txt
        
        len = sfr.read_buffer(bufE);

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