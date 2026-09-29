package ex7;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.String;

public class SampleFileReader 
{
    private FileInputStream fis;
    
    public SampleFileReader(String file_name) throws IOException{
    	fis = new FileInputStream(file_name);
    }


    /**
     * 
     */
    private void execute() throws IOException
    {
        System.out.println("Début lecture du fichier");

        FileInputStream fis = new FileInputStream("/home/wideroz/text.txt");
        byte[] buf = new byte[10];
        
        int len = fis.read(buf);
        while(len!=-1)
        {
            displayBufContent(buf,len);
            len = fis.read(buf);
        }
        fis.close();

        System.out.println("Fin lecture du fichier");
    }


    private void displayBufContent(byte[] buf, int len) 
    {
        System.out.println("len="+len);
        for (int i = 0; i < len; i++) 
        {
            System.out.println("Caractère lu : "+buf[i]);
        }

    }
    
    public int read_buffer(byte[] buf) throws IOException
    {
        return fis.read(buf);
        
    }
    
    public void close_file() throws IOException
    {
    	fis.close();

        System.out.println("Fin lecture du fichier");
    }
}