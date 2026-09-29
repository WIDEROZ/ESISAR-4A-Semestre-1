package ex05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;

public class SampleFileWriter 
{
	
	private FileOutputStream fos;
	
    public SampleFileWriter(String file_name) throws IOException{
    	fos = new FileOutputStream(file_name);
    }

    /**
     * 
     */
    private void execute() throws IOException
    {
        System.out.println("Début écriture du fichier");

        FileOutputStream fos = new FileOutputStream("/home/wideroz/text.txt");


        byte[] buf = new byte[10];

        buf[0] = 69;
        buf[1] = 83;
        buf[2] = 73;
        buf[3] = 83;
        buf[4] = 65;
        buf[5] = 82;


        // Ecriture des 6 premiers octets du buffer 
        fos.write(buf,0,6);

        // Fermeture du fichier
        fos.close();

        System.out.println("Fin écriture du fichier");
    }
    
    public void write_buffer(byte[] buf, int len) throws IOException{
    	System.out.println("Ecriture dans client.txt");
    	fos.write(buf, 0, len);
    }
    
    public void close_file() throws IOException
    {
    	fos.close();

        System.out.println("Fin d'ecriture du fichier");
    }
    
    
    
    
}