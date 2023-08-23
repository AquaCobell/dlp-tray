import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{

    public static void main(String[] args) throws IOException 
    {
       Worker worker = new Worker();
        
        Tray tray = new Tray();

        try 
        {
            tray.loadTray();

        } 
        catch (Exception e) 
        {
           
        }
       
        //Worker worker = new Worker();
        //Media media = new Media("https://www.youtube.com/watch?v=mQS6nPMSSBY", Mediatype.VIDEO);
        //worker.downloadVideo(media);
      

                /* 

        String link = "https://youtu.be/ozIRRIv--8k";
       
        ProcessBuilder pb  = new ProcessBuilder(
        "yt-dlp", 
        "--audio-quality", " 0", 
        "--extract-audio",
        "--audio-format", "mp3", 
        "-o", "%(title)s.%(ext)s'",
        "--add-metadata",
        "--embed-thumbnail",
        "--metadata-from-title", "\"%(artist)s - %(title)s\"",  
        link);

       Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            */



 
        
    }
}

