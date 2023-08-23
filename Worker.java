import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker implements Runnable
{

    BlockingQueue<Media> queue;
    CommandBuilder cb = new CommandBuilder();

    Worker()
    {
        queue = new LinkedBlockingQueue<>();
    }
    
    
    
    @Override
    public void run() 
    {
        try 
        {
            System.out.println("QUEUE READY");
           while(true)
           {
                checkMedia(queue.take());
           } 
            
        } 
        catch (InterruptedException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e)
        {
             e.printStackTrace();
        }
    }

    public void checkMedia(Media media) throws IOException
    {
        if(media.getMediaType() == Mediatype.MUSIC)
        {
            downloadMusic(media);
        }
        else if(media.getMediaType() == Mediatype.AUDIO)
        {
            downloadAudio(media);
        }
        else
        {
            downloadVideo(media);
        }
    }

    public void downloadVideo(Media media) throws IOException
    {
        cb.downloadVideo(media.getLink());

    }

    public void downloadAudio(Media media)
    {
        cb.downloadAudio(media.getLink());

    }

    public void downloadMusic(Media media)
    {
        try 
        {
            cb.downloadMusic(media.getLink());
        } catch (Exception e) 
        {
            System.out.println("Ein Fehler ist aufgetreten");
        }

    }

    public void addMedia(Media m)
    {
        System.out.println(queue.add(m));
    }

    

}