import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandBuilder
{
    CommandBuilder()
    {
            


    }


    public void downloadVideo(String link) throws IOException //yt-dlp --audio-quality 0 --extract-audio --audio-format mp3 -o %(title)s.%(ext)s' --add-metadata --embed-thumbnail --metadata-from-title "%(artist)s - %(title)s" (url of video)

    {
        /*ProcessBuilder pb  = new ProcessBuilder("yt-dlp", 
        "--extract-audio",
        "--audio-format", "mp3",
        "--add-metadata",
        "--embed-thumbnail",
        "--metadata-from-title", "\"%(artist)s - %(title)s\"", link);

        */

      
   
    }

    public void downloadAudio(String link)
    {


    }


    public void downloadMusic(String link) throws IOException
    {
            
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
        while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
        }

    }
}