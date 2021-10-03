import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class FileTReader implements Runnable {
    String fileName;
    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName){
        this.fileName= fileName;
    }
    public FileTReader (String fileName){
        this.fileName = fileName;
    }
    @Override
    synchronized public void run()  {
        try {
            FileReader fr = new FileReader(new File(this.getFileName()));
            BufferedReader br = new BufferedReader(fr);
            int c;
            while((c = br.read()) != -1)
            {
                System.out.println(this.getFileName() + ": " + c);
                Thread.sleep(3000);
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            e.printStackTrace(); // giảm thiểu thời gian fix 
        }
        
    }
    public static void main(String[] arg){
        Thread t1 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test1.txt"));
        Thread t2 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test2.txt"));
        Thread t3 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test3.txt"));
        
        t1.start();
        t2.start();
        t3.start();        
    }
}
