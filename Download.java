import java.io.FileOutputStream ;
import java.io.IOException ;
import java.io.InputStream ; 
import java.net.URL ;
import java.net.URLConnection ;
import java.io.File ;

import java.net.MalformedURLException;

public class Download {
    private static final int BUFFER_SIZE = 4096 ;

    public void download() throws MalformedURLException {
        String ftpServerUrl = "ftp://oracle:osn61new@rws3260575.us.oracle.com:22/attach3.jpg";
       String saveFile = "downloadedFile.zzz";
       try{
           URL url = new URL(ftpServerUrl);
           URLConnection conn = url.openConnection();
           InputStream inputStream = conn.getInputStream();
           long filesize = conn.getContentLength();
           System.out.println("size of the file to be downloaded is: "+filesize);
           FileOutputStream outputStream = new FileOutputStream(saveFile);
           byte[] buffer = new byte[BUFFER_SIZE] ;
           int bytesRead = -1 ; 
           while ((bytesRead = inputStream.read(buffer)) != -1) { 
               outputStream.write(buffer, 0, bytesRead) ;
               }
           System.out.println("File downloaded");
           inputStream.close();
           outputStream.close();
       }
       catch(IOException ex){
           ex.printStackTrace();
       }
    }
    public static void main(String[] args){
        Download d = new Download();
        try {
            d.download();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}