import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket ss;
        try {
            ss = new ServerSocket(6789);
            System.out.println("SERVER DA~ DUOC TAO");
            while (true) {
                Socket s = ss.accept();

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                while (true) {
                    int ch = is.read();
                    System.out.println((char) ch);
                    if (ch == '1')
                        System.out.println("một");
                    if (ch == '2')
                        System.out.println("hai");
                    if (ch == '3')
                        System.out.println("ba");
                    if (ch == '4')
                        System.out.println("bốn");
                    if (ch == '5')
                        System.out.println("năm");
                    if (ch == '6')
                        System.out.println("sáu");
                    if (ch == '7')
                        System.out.println("bảy");
                    if (ch == '8')
                        System.out.println("tám");
                    if (ch == '9')
                        System.out.println("chín");
                    if (ch == '0')
                        System.out.println("không");
                    //else
                        //System.out.println("EROR");        
                    if (ch == -1)
                        break;
                    os.write(ch);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}