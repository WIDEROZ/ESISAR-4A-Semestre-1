package ex6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) throws Exception
    {
        TCPClient clientTCP = new TCPClient();
        clientTCP.execute();                
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
        Socket socket = new Socket();

        // Connexion au serveur 
        InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 5099);
        socket.connect(adrDest);        

        //Envoi le nom du fichier
        byte[] bufE;
        String nomFichier = "file1";
        bufE = nomFichier.getBytes();
        OutputStream os = socket.getOutputStream();
        os.write(bufE);
        
        // Vérification de la validité du nom du fichier
        byte[] bufV = {1};
        InputStream is = socket.getInputStream();
        is.read(bufV);
        System.out.println("Bit de validité : " + bufV[0]);
        
        if(bufV[0] == -1) {
        	socket.close();
            System.out.println("Arret du client, mauvais nom de fichier envoyé");
            return;
        }
        
        
        // Attente du fichier server
        byte[] bufR = new byte[2048];
        // Read buffer TCP
        int lenBufR = is.read(bufR);
        
        
        // Write dans le fichier client.txt
        SampleFileWriter sfr = new SampleFileWriter("/home/wideroz/file2");
        
        while (lenBufR!=-1)
        {
        	sfr.write_buffer(bufR, lenBufR);
            lenBufR = is.read(bufR);
        }
        
        sfr.close_file();

        // Fermeture de la socket
        socket.close();
        System.out.println("Arret du client .");

    }

}