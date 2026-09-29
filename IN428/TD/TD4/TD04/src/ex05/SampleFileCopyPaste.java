package ex05;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;


public class SampleFileCopyPaste {
	public static void main(String[] args) throws Exception
    {
		SampleFileCopyPaste fr = new SampleFileCopyPaste();
        fr.execute();
    }
	private void execute() throws IOException{
		long start = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("/home/wideroz/file1");
		FileOutputStream fos = new FileOutputStream("/home/wideroz/file2");
		byte[] buf = new byte[10000];

        int len = fis.read(buf);
        while(len!=-1)
        {
        	fos.write(buf,0,len);
            len = fis.read(buf);
            
        }
        fos.close();
        fis.close();
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed Time = "+(stop-start)+" ms");

	}
}
