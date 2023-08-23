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
            queue.take();
        } 
        catch (InterruptedException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void checkMedia(Media media)
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

    public void downloadVideo(Media media)
    {
        cb.downloadVideo(media.getLink());

    }

    public void downloadAudio(Media media)
    {
        cb.downloadAudio(media.getLink());

    }

    public void downloadMusic(Media media)
    {
        cb.downloadMusic(media.getLink());

    }

    

}