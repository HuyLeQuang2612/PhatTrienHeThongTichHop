import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class SyncCompile implements Runnable {
    String fileName;
    public String getFileName(){
        return fileName;
    }
    public void setSyncCompile (String fileName){
        this.fileName = fileName;
    }
    public SyncCompile (String fileName){
        this.fileName = fileName;
    }
    
    public synchronized void writeTable(int n){
            try {
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                for(int i = 0 ; i < 10; i++){
                    int rand = (int) (Math.random() * 10);
                    bw.write(rand + "\t");
                }
                fw.close();
                bw.close();
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        } 
    public void printTable(){
        synchronized(this){
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                String c;
                while((c = br.readLine()) != null) // nếu là số thì dùng read() , còn nếu là văn bản thì dùng readLine() != null
                {
                    System.out.println(this.getFileName() + ": " + c);
                }
                br.close();
                fr.close();
            } catch(Exception e) {
                e.printStackTrace(); // giảm thiểu thời gian fix 
            }
        }
    }
    @Override
    public void run() {
        try {
            printTable();
        } catch(Exception e) {
            e.printStackTrace(); // giảm thiểu thời gian fix 
        } 
    }

    public static void main(String[] args) {
        //final SyncCompile obj = new  SyncCompile(); 
        Thread t1 = new Thread(new FileTWriter("C:\\Users\\acer\\testing\\test4.txt"));
        /*public void run() {
            obj.printTable();
        }*/
        Thread t2 = new Thread(new FileTWriter("C:\\Users\\acer\\testing\\test5.txt"));
        Thread t3 = new Thread(new FileTWriter("C:\\Users\\acer\\testing\\test6.txt"));
    
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Hoàn tất chương trình !!!");
    }
}