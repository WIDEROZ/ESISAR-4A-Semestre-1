package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Client basique TCP
 * 
 */
public class ClientTCP
{

    public static void main(String[] args) throws Exception
    {
        ClientTCP clientTCP = new ClientTCP();
        clientTCP.addition();                
    }

    /**
     * Le client cree une socket, envoie un message au serveur
     * et attend la reponse 
     * EXERCICE 2
     */
    private void execute() throws IOException
    {
        //
        System.out.println("Demarrage du client ...");

        // Creation de la socket
        Socket socket = new Socket();

        // Connexion au serveur 
        InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 5099);
        socket.connect(adrDest);

        // Envoi de la requete
        byte[] bufE = new String("question du client").getBytes();
        OutputStream os = socket.getOutputStream();
        os.write(bufE);
        System.out.println("Message envoye");

        // Attente de la reponse 
        byte[] bufR = new byte[2048];
        InputStream is = socket.getInputStream();
        int lenBufR = is.read(bufR);
        if (lenBufR!=-1)
        {
            String reponse = new String(bufR, 0 , lenBufR );
            System.out.println("Reponse recue = "+reponse);
        }

        // Fermeture de la socket
        socket.close();
        System.out.println("Arret du client .");
    }



    /*
        EXERCICE 4
    */

    private void addition() throws IOException
    {
        //
        System.out.println("Demarrage du client ...");

        // Creation de la socket
        Socket socket = new Socket();

        // Connexion au serveur 
        InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", 5099);
        socket.connect(adrDest);


        byte[] bufR = new byte[2048];
        byte[] bufE = new byte[2048];
        InputStream is;
        int lenBufR;


        String question_server = new String();
        String operande_1 = new String();
        String operande_2 = new String();
        String operation = new String();


        String char_buffer = new String();
        boolean after_operation = false;


        while(lenBufR!=-1){
            // Attente de la question du server
            is = socket.getInputStream();
            lenBufR = is.read(bufR);

            // Traitement de la chaine de texte
            question_server = bufR.toString();

            for(int i = 0; i < lenBufR; i++){
                char_buffer.substring(i, i+1);
                if (char_buffer == "+"){
                    
                }
            }








            // Réponse a la question du server
            String reponse = new String(bufR, 0, lenBufR);
            System.out.println("Reponse recue = "+reponse);
        }




        // Envoi de la requete
        
        OutputStream os = socket.getOutputStream();
        os.write(bufE);
        System.out.println("Message envoye");

        // Attente de la reponse 
        byte[] bufR = new byte[2048];
        InputStream is = socket.getInputStream();
        int lenBufR = is.read(bufR);
        if (lenBufR!=-1)
        {
            String reponse = new String(bufR, 0 , lenBufR );
            System.out.println("Reponse recue = "+reponse);
        }

        // Fermeture de la socket
        socket.close();
        System.out.println("Arret du client .");
    }


}
