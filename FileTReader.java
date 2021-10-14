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
<<<<<<< Updated upstream
=======
    
>>>>>>> Stashed changes
    @Override
    synchronized public void run()  {
        try {
            FileReader fr = new FileReader(new File(this.getFileName()));
            BufferedReader br = new BufferedReader(fr);
<<<<<<< Updated upstream
            int c;
            while((c = br.read()) != -1)
            {
                System.out.println(this.getFileName() + ": " + c);
                Thread.sleep(3000);
=======
            String c;
            while((c = br.readLine()) != null) // nếu là số thì dùng read() , còn nếu là văn bản thì dùng readLine() != null
            {
                System.out.println(this.getFileName() + ": " + c);
>>>>>>> Stashed changes
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            e.printStackTrace(); // giảm thiểu thời gian fix 
        }
        
    }
<<<<<<< Updated upstream
    public static void main(String[] arg){
        Thread t1 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test1.txt"));
        Thread t2 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test2.txt"));
        Thread t3 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test3.txt"));
        
        t1.start();
        t2.start();
        t3.start();        
    }
}
=======


    public static void main(String[] arg) throws InterruptedException{
        Thread t1 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test1.txt"));
        Thread t2 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test2.txt"));
        Thread t3 = new Thread(new FileTReader("C:\\Users\\acer\\testing\\test3.txt"));
    
        t1.start();
        Thread.sleep(3000);
        t2.start();
        Thread.sleep(3000);
        t3.start();
        Thread.sleep(3000);     

        System.out.println("Chương trình chạy hoàn tất !!!");
    }
}
>>>>>>> Stashed changes
