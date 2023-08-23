public class Media
{

    /**
    * Direkter Link zum Video
    */
    String link;

    /**
    * Medientyp zbs. Video, Audio, oder Musik
    */
    Mediatype mediatype;

    Media(String link, Mediatype mediatype)
    {   
        this.mediatype =  mediatype;
        this.link=link;
    }

    public String getLink()
    {
        return this.link;
    }

    public Mediatype getMediaType()
    {
        return this.mediatype;
    }
}