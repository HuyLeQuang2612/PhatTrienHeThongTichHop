
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss =   new ServerSocket(4567);
        while(true)
        {
            Socket s = null;
            try {
                s = ss.accept();
                System.out.println("Socket đã kết nối !!!");
                
                DataInputStream dis =  new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Tạo luồng cho Client");
                Thread t = new ClientHandler(s, dis, dos);
                t.start();

            }
            catch(Exception e){
                s.close();
                e.printStackTrace();
            }
        }  
    } 
}
