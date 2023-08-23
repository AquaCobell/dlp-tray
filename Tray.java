
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Tray 
{
    Clipboardreader reader;
    Worker worker;
    Thread t1;
       

    Tray()
    {
        reader = new Clipboardreader();
        worker = new Worker();
        t1 = new Thread(worker);
        t1.start();
    }

    public void loadTray() throws AWTException
    {
        TrayIcon trayIcon = null;
        if(SystemTray.isSupported())
        {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
            
            PopupMenu popup = new PopupMenu();

            MenuItem downloadMusic= new MenuItem("Download Music");
            MenuItem exit = new MenuItem("Exit");

            exit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
                
            });

          
           downloadMusic.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                   
                    Media m = new Media(reader.getClipboard(), Mediatype.MUSIC);
                    try 
                    {
                        worker.addMedia(m);
                    } 
                    catch (Exception e1) 
                    {
                        System.out.println("Es ist ein Fehler aufgetreten" +e1);
                    }
                    
                }
                
            });


            popup.add(downloadMusic);
            popup.add(exit);





            trayIcon = new TrayIcon(image, "DLP-Tray",popup);

            tray.add(trayIcon);
    
            //https://stackoverflow.com/questions/758083/how-do-i-put-a-java-app-in-the-system-tray
            
           

    

        } 
        else
        {
            System.out.println("error");
        }
        
    }
}
