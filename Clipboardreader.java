import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

public class Clipboardreader 
{
        Clipboardreader()
        {
    
        }
        
        public  String getClipboard()
        {
            try 
            {
                return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            } 
            catch (Exception e)
            {
                System.out.println("Error");
            }
            return null;
        }
          
        
   
        
    
}
