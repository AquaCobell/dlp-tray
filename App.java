public class App
{

    public static void main(String[] args) 
    {
        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();
        System.out.println("test");

        
    }
}

